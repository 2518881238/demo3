package com.example.demo3;

import com.example.demo3.entity.BuyFood;
import com.example.demo3.service.StuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@SpringBootApplication
@Controller
public class turnPage {

    @Resource
    private StuService stuService;

//    @RequestMapping("/list")
//    public String findAll(){
//        return stuService.findAll().toString();
//    }
    @GetMapping("/page")
    public String turnPage(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<BuyFood> userList = stuService.findAll();
        PageInfo<BuyFood> pageInfo = new PageInfo<>(userList);
        PageHelper.startPage(pageNum,5);
        List<BuyFood> userList1 = stuService.findAllByZhuHong();
        PageInfo<BuyFood> pageInfo1 = new PageInfo<>(userList1);
        PageHelper.startPage(pageNum,5);
        List<BuyFood> userList2 = stuService.findAllByWangLang();
        PageInfo<BuyFood> pageInfo2 = new PageInfo<>(userList2);
        PageHelper.startPage(pageNum,5);
        List<BuyFood> userList3 = stuService.findAllByJinBiao();
        PageInfo<BuyFood> pageInfo3 = new PageInfo<>(userList3);

        List<BuyFood> userList4 = stuService.findAll();
        float zhuhong = 0;
        float wanglang = 0;
        float jinbiao = 0;
        float zhuhong1 = 0;
        float wanglang1 = 0;
        float jinbiao1 = 0;
        for (int i = 0; i < userList4.size(); i++){
            if ("朱宏".equals(userList4.get(i).getUser_name())) {
                zhuhong = zhuhong + userList4.get(i).getPrice();
            }
            if ("金彪".equals(userList4.get(i).getUser_name())) {
                jinbiao = jinbiao + userList4.get(i).getPrice();
            }
            if ("王浪".equals(userList4.get(i).getUser_name())) {
                wanglang = wanglang + userList4.get(i).getPrice();
            }
        }
        zhuhong1 = zhuhong - (zhuhong + jinbiao + wanglang)/3;
        jinbiao1 = jinbiao - (zhuhong + jinbiao + wanglang)/3;
        wanglang1 = wanglang - (zhuhong + jinbiao + wanglang)/3;
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("pageInfo1", pageInfo1);
        model.addAttribute("pageInfo2", pageInfo2);
        model.addAttribute("pageInfo3", pageInfo3);
        model.addAttribute("zhuhong",zhuhong);
        model.addAttribute("wanglang",wanglang);
        model.addAttribute("jinbiao",jinbiao);
        model.addAttribute("zhuhong1",zhuhong1);
        model.addAttribute("wanglang1",wanglang1);
        model.addAttribute("jinbiao1",jinbiao1);
        return "show";
    }
}
