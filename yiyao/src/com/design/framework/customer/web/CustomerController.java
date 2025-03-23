package com.design.framework.customer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.design.framework.customer.model.Customer;
import com.design.framework.customer.service.CustomerService;


@Controller
@Scope("prototype")
@RequestMapping("/sys/customer")
public class CustomerController {

    private final static String URL_CUSTOMER_LIST = "/list";
    private final static String JSP_CUSTOMER_LIST = "jsp/customer/list";
    private final static String URL_CUSTOMER_LIST2 = "/list2";
    private final static String JSP_CUSTOMER_LIST2 = "jsp/customer/list2";
    private final static String URL_CUSTOMER_ADD = "/add";
    private final static String JSP_CUSTOMER_ADD = "jsp/customer/add";
    private final static String URL_CUSTOMER_DELETE = "/delete/{s_id}";
    private final static String URL_CUSTOMER_TOUPDATE = "/update/{s_id}";
    private final static String JSP_CUSTOMER_TOUPDATE = "jsp/customer/update";
    private final static String URL_CUSTOMER_UPDATE = "/update";
    private final static String URL_CUSTOMER_ADD2 = "/add2";
    private final static String JSP_CUSTOMER_ADD2 = "jsp/customer/add2";

    @Autowired
    private CustomerService customerService;

    
    @GetMapping(URL_CUSTOMER_LIST)
    public String list(Model model){
    	model.addAttribute("customerList" , this.customerService.list());
    	return JSP_CUSTOMER_LIST;
    }
    
    @GetMapping(URL_CUSTOMER_LIST2)
    public String list2(Model model){
    	model.addAttribute("customerList" , this.customerService.list());
    	return JSP_CUSTOMER_LIST2;
    }

    @GetMapping(URL_CUSTOMER_TOUPDATE)
    public String update(@PathVariable("s_id") Integer s_id,Model model){
        model.addAttribute("customer" , this.customerService.load(s_id));
        return JSP_CUSTOMER_TOUPDATE;
    }
    
    @PostMapping(URL_CUSTOMER_UPDATE)
    public String update(Customer customer){
        this.customerService.update(customer);
        return "redirect:/sys/customer/list";
    }
    
    @GetMapping(URL_CUSTOMER_ADD)
    public String add(Model model){
        return JSP_CUSTOMER_ADD;
    }
    
    @GetMapping(URL_CUSTOMER_ADD2)
    public String add2(Model model){
        return JSP_CUSTOMER_ADD2;
    }

    @PostMapping(URL_CUSTOMER_ADD)
    public String add(Customer customer,ModelMap modelMap){
        try{
            this.customerService.add(customer);
            modelMap.addAttribute("addMessage" , "添加成功");
        }catch(Exception e){
            modelMap.addAttribute("addMessage" , "添加失败,原因为:"+e.getMessage());
        }

        return JSP_CUSTOMER_ADD;
    }



    @GetMapping(URL_CUSTOMER_DELETE)
    public String delete(@PathVariable("s_id") Integer s_id){
        this.customerService.delete(s_id);
        return "redirect:/sys/customer/list";
    }

}
