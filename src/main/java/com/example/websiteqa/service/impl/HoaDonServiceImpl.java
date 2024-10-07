package com.example.websiteqa.service.impl;

import com.example.websiteqa.entity.CthdEntity;
import com.example.websiteqa.entity.HoadonEntity;
import com.example.websiteqa.model.*;
import com.example.websiteqa.repository.CthdRepository;
import com.example.websiteqa.repository.HoaDonRepository;
import com.example.websiteqa.repository.KhachHangRepository;
import com.example.websiteqa.repository.SanPhamRepository;
import com.example.websiteqa.service.HoaDonService;
import com.example.websiteqa.service.NganHangService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HoaDonServiceImpl implements HoaDonService {
    @Autowired
    private HoaDonRepository hoaDonRepository;
    @Autowired
    private CthdRepository cthdRepository;
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private NganHangService nganHangService;

    @Override
    public void createBill(List<Giohang> giohangs, Hoadon hoaDon, int khachHang) {
        HoadonEntity hoaDonEntity = new HoadonEntity();
        hoaDonEntity.setNgaydat(new Date());
        hoaDonEntity.setKhachhangEntity(khachHangRepository.findOne(khachHang));
        hoaDonEntity.setTrangthai(0);
        hoaDonEntity = hoaDonRepository.save(hoaDonEntity);
        for(Giohang giohang : giohangs){
            CthdEntity cthdEntity = new CthdEntity();
            cthdEntity.setSoluong(giohang.getSoluong());
            cthdEntity.setHoadonEntity(hoaDonEntity);
            cthdEntity.setSanphamEntity(sanPhamRepository.findOne(giohang.getSanpham()));
            cthdRepository.save(cthdEntity);
        }
    }

    @Override
    public List<Hoadon> listByKhachHang(int khachHang) {
        List<HoadonEntity> hoaDonEntities = hoaDonRepository.findAllByKhachhangEntity(khachHangRepository.findOne(khachHang));
        List<Hoadon> hoaDons = new ArrayList<>();
        for(HoadonEntity entity : hoaDonEntities){
            Hoadon hoaDon = new Hoadon();
            hoaDon.setNgaydat(entity.getNgaydat());
            hoaDon.setId(entity.getId());
            hoaDon.setKhachhang(entity.getKhachhangEntity().getId());
            hoaDon.setTrangthai(entity.getTrangthai());
            hoaDons.add(hoaDon);
        }
        return hoaDons;
    }

    @Override
    public List<Cthd> getDetailById(int id) {
        List<CthdEntity> cthdEntities = cthdRepository.findAllByHoadonEntity(hoaDonRepository.findOne(id));
        List<Cthd> cthds = new ArrayList<>();
        for(CthdEntity entity : cthdEntities){
            Cthd cthd = new Cthd();
            cthd.setHoadon(entity.getHoadonEntity().getId());
            cthd.setSoluong(entity.getSoluong());
            cthd.setId(entity.getId());
            cthd.setSanpham(entity.getSanphamEntity().getId());
            cthds.add(cthd);
        }
        return cthds;
    }

    @Override
    public List<Hoadon> list() {
        List<HoadonEntity> hoaDonEntities = hoaDonRepository.findAll();
        List<Hoadon> hoaDons = new ArrayList<>();
        for(HoadonEntity entity : hoaDonEntities){
            Hoadon hoaDon = new Hoadon();
            hoaDon.setNgaydat(entity.getNgaydat());
            hoaDon.setId(entity.getId());
            hoaDon.setKhachhang(entity.getKhachhangEntity().getId());
            hoaDon.setTrangthai(entity.getTrangthai());
            hoaDons.add(hoaDon);
        }
        return hoaDons;
    }

    @Override
    public void delete(int id) {
        hoaDonRepository.delete(id);
    }

    @Override
    public void update(Hoadon hoadon) {
        HoadonEntity entity = hoaDonRepository.findOne(hoadon.getId());
        if(entity == null)
            return;
        entity.setTrangthai(hoadon.getTrangthai());
        hoaDonRepository.save(entity);
    }

    @Override
    public Hoadon get(int id) {
        HoadonEntity entity = hoaDonRepository.findOne(id);
        Hoadon hoaDon = new Hoadon();
        hoaDon.setNgaydat(entity.getNgaydat());
        hoaDon.setId(entity.getId());
        hoaDon.setKhachhang(entity.getKhachhangEntity().getId());
        hoaDon.setTrangthai(entity.getTrangthai());
        return hoaDon;
    }

    @Override
    public String createQR(int amount) {
        try{
            Nganhang nganhang = nganHangService.get();
            ApiRequest apiRequest = new ApiRequest();
            apiRequest.setAcqId(Integer.parseInt(nganhang.getNganhang()));
            apiRequest.setAccountNo(nganhang.getStk());
            apiRequest.setAccountName(nganhang.getTen());
            apiRequest.setAddInfo(nganhang.getNoidungchuyenkhoan());
            apiRequest.setAmount(amount);
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(apiRequest);

            HttpClient client = HttpClients.createDefault();
            URIBuilder builder = new URIBuilder("https://api.vietqr.io/v2/generate");
            HttpPost getStubMethod = new HttpPost(builder.build().toString());
            StringEntity myEntity = new StringEntity(json,
                    ContentType.create("application/json"));
            getStubMethod.setEntity(myEntity);
            org.apache.http.HttpResponse getStubResponse = client.execute(getStubMethod);
            String responseBody = EntityUtils
                    .toString(getStubResponse.getEntity());
            return responseBody;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
