package com.example.websiteqa.service.impl;

import com.example.websiteqa.entity.SlideEntity;
import com.example.websiteqa.entity.SlideEntityComparator;
import com.example.websiteqa.model.Slide;
import com.example.websiteqa.repository.SlideRepository;
import com.example.websiteqa.repository.TaiKhoanRepository;
import com.example.websiteqa.service.SlideService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SlideServiceImpl implements SlideService {
    @Autowired
    private SlideRepository slideRepository;
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Override
    public List<Slide> list() {
        List<SlideEntity> entities = slideRepository.findAll();
        List<Slide> models = new ArrayList<>();
        for(SlideEntity entity : entities){
            Slide slide = new Slide();
            slide.setDuongdan(entity.getDuongdan());
            slide.setVitri(entity.getVitri());
            slide.setId(entity.getId());
            models.add(slide);
        }
        return models;
    }

    @Override
    public void add(Slide slide) {
        String url = saveFile(slide.getFile());
        if(url != null){
            SlideEntity entity = new SlideEntity();
            entity.setDuongdan(url);
            entity.setTaikhoanEntity(taiKhoanRepository.findOne(slide.getUsername()));
            entity.setVitri(slide.getVitri());
            slideRepository.save(entity);
        }
    }

    @Override
    public boolean checkFile(MultipartFile file) {
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

    public String getFileExtension(String fileName) {
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

    @Override
    public String saveFile(MultipartFile file) {
        String path = System.getProperty("user.dir");
        path += "\\src\\main\\webapp\\resources\\images\\slide\\";
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        Date date = new Date(timestamp.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String formattedDate = formatter.format(date);
        String fileName = "slide-" +
                formattedDate + "." + getFileExtension(file.getOriginalFilename());
        String rs = "/resources/images/slide/" + fileName;
        try
        {
            File dir = new File(path);
            if (!dir.exists())
            {
                dir.mkdirs();
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
    public void update(Slide slide) {
        SlideEntity old = slideRepository.findOne(slide.getId());
        if(old != null){
            try{
                //delete file
                String path = System.getProperty("user.dir");
                path += "\\src\\main\\webapp";
                path += old.getDuongdan().replace("/","\\");
                Files.delete(Paths.get(path));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        String url = saveFile(slide.getFile());
        if(url != null){
            SlideEntity entity = new SlideEntity();
            entity.setId(slide.getId());
            entity.setDuongdan(url);
            entity.setVitri(slide.getVitri());
            entity.setTaikhoanEntity(taiKhoanRepository.findOne(slide.getUsername()));
            slideRepository.save(entity);
        }
    }

    @Override
    public void delete(int id) {
        SlideEntity old = slideRepository.findOne(id);
        if(old != null){
            try{
                //delete file
                String path = System.getProperty("user.dir");
                path += "\\src\\main\\webapp";
                path += old.getDuongdan().replace("/","\\");
                Files.delete(Paths.get(path));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        slideRepository.delete(id);
        List<SlideEntity> entities = slideRepository.findAll();
        entities.sort(new SlideEntityComparator());
        for(int i = 0; i < entities.size(); i++){
            if(entities.get(i).getVitri() != i + 1){
                entities.get(i).setVitri(i + 1);
                slideRepository.save(entities.get(i));
            }
        }
    }

    @Override
    public Slide get(int id) {
        SlideEntity entity = slideRepository.findOne(id);
        if (entity == null)
            return null;
        Slide slide = new Slide();
        slide.setDuongdan(entity.getDuongdan());
        slide.setVitri(entity.getVitri());
        slide.setId(entity.getId());
        return slide;
    }

    @Override
    public int getViTri() {
        List<SlideEntity> entities = slideRepository.findAll();
        if(entities.size() == 0)
            return 1;
        int vt = 0;
        for(SlideEntity entity : entities){
            if(entity.getVitri() > vt)
                vt = entity.getVitri();
        }
        return vt + 1;
    }
}
