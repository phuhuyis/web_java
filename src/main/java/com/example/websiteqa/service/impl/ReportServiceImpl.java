package com.example.websiteqa.service.impl;

import com.example.websiteqa.model.Cthd;
import com.example.websiteqa.model.Hoadon;
import com.example.websiteqa.model.Sanpham;
import com.example.websiteqa.service.HoaDonService;
import com.example.websiteqa.service.ReportService;
import com.example.websiteqa.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    private SanPhamService sanPhamService;

    @Override
    public List<Integer> getAllPrice() {
        List<Hoadon> hoadons = hoaDonService.list();
        List<Sanpham> sanphams = sanPhamService.list();
        List<Integer> results = new ArrayList<>();
        for(int i = 1; i < 13; i++){
            Date dateNow = new Date();
            int amount = 0;
            for(Hoadon hoadon : hoadons){
                if(hoadon.getNgaydat().getYear() == dateNow.getYear() && hoadon.getNgaydat().getMonth() == i){
                    List<Cthd> cthds = hoaDonService.getDetailById(hoadon.getId());
                    for (Cthd cthd : cthds){
                        for(Sanpham sanpham : sanphams){
                            if(sanpham.getId() == cthd.getSanpham()){
                                amount += sanpham.getGia() * cthd.getSoluong();
                            }
                        }
                    }
                }
            }
            results.add(amount);
        }
        return results;
    }

    @Override
    public List<Integer> getAllQuantity() {
        List<Hoadon> hoadons = hoaDonService.list();
        List<Sanpham> sanphams = sanPhamService.list();
        List<Integer> results = new ArrayList<>();
        for(int i = 1; i < 13; i++){
            Date dateNow = new Date();
            int quantity = 0;
            for(Hoadon hoadon : hoadons){
                if(hoadon.getNgaydat().getYear() == dateNow.getYear() && hoadon.getNgaydat().getMonth() == i){
                    List<Cthd> cthds = hoaDonService.getDetailById(hoadon.getId());
                    for (Cthd cthd : cthds){
                        for(Sanpham sanpham : sanphams){
                            if(sanpham.getId() == cthd.getSanpham()){
                                quantity += cthd.getSoluong();
                            }
                        }
                    }
                }
            }
            results.add(quantity);
        }
        return results;
    }
}
