package com.example.websiteqa.service;

import com.example.websiteqa.model.Sanpham;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SanPhamService {
    List<Sanpham> list();
    void add(Sanpham sanpham);
    boolean checkFile(MultipartFile file);
    String saveFile(MultipartFile file);
    void update(Sanpham sanpham) throws IOException;
    void delete(int id) throws IOException;
    Sanpham get(int id);
    List<Sanpham> searchBycategory(String metatitle, int page);
    int getFullPageBycategory(String metatitle);
    List<Sanpham> searchByBrand(String metatitle, int page);
    int getFullPageByBrand(String metatitle);
    List<Sanpham> searchByKeyWord(String keyWord, int page);
    int getFullPageByKeyWord(String keyWord);
}
