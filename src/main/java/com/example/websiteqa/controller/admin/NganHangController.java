package com.example.websiteqa.controller.admin;

import com.example.websiteqa.model.DataBank;
import com.example.websiteqa.model.Datum;
import com.example.websiteqa.model.Nganhang;
import com.example.websiteqa.model.Taikhoan;
import com.example.websiteqa.service.NganHangService;
import com.example.websiteqa.utils.SessionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller(value = "bankAdmin")
@RequestMapping("/admin/bank")
public class NganHangController {
    @Autowired
    private NganHangService nganHangService;

    @GetMapping({"/edit"})
    public String edit(Model model){
        if(nganHangService.get() == null)
            return "redirect:/admin";
        model.addAttribute("title", "Cập nhập tài khoản ngân hàng");
        model.addAttribute("active", "bank");
        model.addAttribute("bank", nganHangService.get());
        model.addAttribute("listBank", listBank());
        return "admin/bank/edit";
    }

    @PostMapping({"/edit"})
    public String edit(Model model, @Validated @ModelAttribute(name = "bank") Nganhang bank, BindingResult bindingResult, HttpServletRequest request){
        if(nganHangService.get() == null)
            return "redirect:/admin";
        model.addAttribute("title", "Cập nhập tài khoản ngân hàng");
        model.addAttribute("active", "bank");
        model.addAttribute("listBank", listBank());
        if(!bindingResult.hasErrors()){
            model.addAttribute("success", "Cập nhập tài khoản ngân hàng thành công");
            bank.setUsername(((Taikhoan) SessionUtil.getInstance().getKey(request, "user")).getUsername());
            bank.setId(nganHangService.get().getId());
            nganHangService.update(bank);
        }
        return "admin/bank/edit";
    }

    public List<Datum> listBank(){
        try {
            HttpClient client = HttpClients.createDefault();
            URIBuilder builder = new URIBuilder("https://api.vietqr.io/v2/banks");
            HttpGet getStubMethod = new HttpGet(builder.build().toString());
            HttpResponse getStubResponse = client.execute(getStubMethod);
            String responseBody = EntityUtils
                    .toString(getStubResponse.getEntity());
            ObjectMapper objectMapper = new ObjectMapper();
            DataBank dataBank = objectMapper.readValue(responseBody, DataBank.class);
            return dataBank.data;
            /*foreach(Datum item in listBankData.data)
            {
                selectListItems.Add(new System.Web.Mvc.SelectListItem() { Text = item.shortName, Value = item.bin });
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
