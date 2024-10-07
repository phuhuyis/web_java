package com.example.websiteqa.service.impl;

import com.example.websiteqa.entity.SanphamEntity;
import com.example.websiteqa.model.Sanpham;
import com.example.websiteqa.repository.LoaiSanPhamRepository;
import com.example.websiteqa.repository.NhanHieuRepository;
import com.example.websiteqa.repository.SanPhamRepository;
import com.example.websiteqa.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private NhanHieuRepository nhanHieuRepository;
    @Autowired
    private LoaiSanPhamRepository loaiSanPhamRepository;

    @Override
    public boolean checkFile(MultipartFile file)
    {
        String extension = getFileExtension(file.getOriginalFilename());
        if (extension.equals("png") || extension.equals("jpg") || extension.equals("jpeg"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public String saveFile(MultipartFile file)
    {
        String path = System.getProperty("user.dir");
        path += "\\src\\main\\webapp\\resources\\images\\product\\";
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        Date date = new Date(timestamp.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String formattedDate = formatter.format(date);
        String fileName = "product-" +
                formattedDate + "." + getFileExtension(file.getOriginalFilename());
        String rs = "/resources/images/product/" + fileName;
        try
        {
            File dir = new File(path);
            if (!dir.exists())
            {
                dir.mkdir();
            }
            Files.copy(file.getInputStream(), Paths.get(path + fileName));
            return rs;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Sanpham sanpham) {
        SanphamEntity old = sanPhamRepository.findOne(sanpham.getId());
        if(old != null){
            try{
                //delete file
                String path = System.getProperty("user.dir");
                path += "\\src\\main\\webapp";
                path += old.getHinhanh().replace("/","\\");
                Files.delete(Paths.get(path));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        String url = saveFile(sanpham.getFile());
        if(url != null){
            SanphamEntity entity = new SanphamEntity();
            entity.setId(sanpham.getId());
            entity.setGia(sanpham.getGia());
            entity.setHinhanh(url);
            entity.setTen(sanpham.getTen());
            entity.setNhanhieuEntity(nhanHieuRepository.findOne(sanpham.getNhanhieu()));
            entity.setLoaisanphamEntity(loaiSanPhamRepository.findOne(sanpham.getDanhmuc()));
            sanPhamRepository.save(entity);
        }
    }

    @Override
    public void delete(int id) {
        SanphamEntity old = sanPhamRepository.findOne(id);
        if(old != null){
            try{
                //delete file
                String path = System.getProperty("user.dir");
                path += "\\src\\main\\webapp";
                path += old.getHinhanh().replace("/","\\");
                Files.delete(Paths.get(path));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        sanPhamRepository.delete(id);
    }

    @Override
    public Sanpham get(int id) {
        SanphamEntity entity = sanPhamRepository.findOne(id);
        if (entity == null)
            return null;
        Sanpham sanpham = new Sanpham();
        sanpham.setTen(entity.getTen());
        sanpham.setNhanhieu(entity.getNhanhieuEntity().getId());
        sanpham.setDanhmuc(entity.getLoaisanphamEntity().getId());
        sanpham.setHinhanh(entity.getHinhanh());
        sanpham.setGia(entity.getGia());
        sanpham.setId(id);
        return sanpham;
    }

    @Override
    public List<Sanpham> searchBycategory(String metatitle, int page) {
        PageRequest pageRequest = new PageRequest(page - 1, 6);
        Page<SanphamEntity> entities = sanPhamRepository.findAllByMetatitle(metatitle, pageRequest);
        List<Sanpham> models = new ArrayList<>();
        for(SanphamEntity entity : entities){
            Sanpham sp = new Sanpham();
            sp.setId(entity.getId());
            sp.setDanhmuc(entity.getLoaisanphamEntity().getId());
            sp.setGia(entity.getGia());
            sp.setHinhanh(entity.getHinhanh());
            sp.setNhanhieu(entity.getNhanhieuEntity().getId());
            sp.setTen(entity.getTen());
            models.add(sp);
        }
        return models;
    }

    @Override
    public int getFullPageBycategory(String metatitle) {
        List<SanphamEntity> entities = sanPhamRepository.findAllByMetatitle(metatitle);
        return entities.size() % 6 == 0 ? entities.size() / 6 : entities.size() / 6 + 1;
    }

    @Override
    public List<Sanpham> searchByBrand(String metatitle, int page) {
        PageRequest pageRequest = new PageRequest(page - 1, 6);
        Page<SanphamEntity> entities = sanPhamRepository.findAllByBrand(metatitle, pageRequest);
        List<Sanpham> models = new ArrayList<>();
        for(SanphamEntity entity : entities){
            Sanpham sp = new Sanpham();
            sp.setId(entity.getId());
            sp.setDanhmuc(entity.getLoaisanphamEntity().getId());
            sp.setGia(entity.getGia());
            sp.setHinhanh(entity.getHinhanh());
            sp.setNhanhieu(entity.getNhanhieuEntity().getId());
            sp.setTen(entity.getTen());
            models.add(sp);
        }
        return models;
    }

    @Override
    public int getFullPageByBrand(String metatitle) {
        List<SanphamEntity> entities = sanPhamRepository.findAllByBrand(metatitle);
        return entities.size() % 6 == 0 ? entities.size() / 6 : entities.size() / 6 + 1;
    }

    @Override
    public List<Sanpham> searchByKeyWord(String keyWord, int page) {
        keyWord = "%" + keyWord + "%";
        PageRequest pageRequest = new PageRequest(page - 1, 6);
        Page<SanphamEntity> entities = sanPhamRepository.search(keyWord, pageRequest);
        List<Sanpham> models = new ArrayList<>();
        for(SanphamEntity entity : entities){
            Sanpham sp = new Sanpham();
            sp.setId(entity.getId());
            sp.setDanhmuc(entity.getLoaisanphamEntity().getId());
            sp.setGia(entity.getGia());
            sp.setHinhanh(entity.getHinhanh());
            sp.setNhanhieu(entity.getNhanhieuEntity().getId());
            sp.setTen(entity.getTen());
            models.add(sp);
        }
        return models;
    }

    @Override
    public int getFullPageByKeyWord(String keyWord) {
        keyWord = "%" + keyWord + "%";
        List<SanphamEntity> entities = sanPhamRepository.search(keyWord);
        return entities.size() % 6 == 0 ? entities.size() / 6 : entities.size() / 6 + 1;
    }

    public String getFileExtension(String fileName) {
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

    @Override
    public List<Sanpham> list() {
        List<SanphamEntity> entities = sanPhamRepository.findAll();
        List<Sanpham> models = new ArrayList<>();
        for(SanphamEntity entity : entities){
            Sanpham sp = new Sanpham();
            sp.setId(entity.getId());
            sp.setDanhmuc(entity.getLoaisanphamEntity().getId());
            sp.setGia(entity.getGia());
            sp.setHinhanh(entity.getHinhanh());
            sp.setNhanhieu(entity.getNhanhieuEntity().getId());
            sp.setTen(entity.getTen());
            models.add(sp);
        }
        return models;
    }

    @Override
    public void add(Sanpham sanpham) {
        String url = saveFile(sanpham.getFile());
        if(url != null){
            SanphamEntity entity = new SanphamEntity();
            entity.setGia(sanpham.getGia());
            entity.setHinhanh(url);
            entity.setTen(sanpham.getTen());
            entity.setNhanhieuEntity(nhanHieuRepository.findOne(sanpham.getNhanhieu()));
            entity.setLoaisanphamEntity(loaiSanPhamRepository.findOne(sanpham.getDanhmuc()));
            sanPhamRepository.save(entity);
        }
    }
}
