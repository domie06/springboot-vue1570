package com.design.framework.supplier.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.design.base.utils.BaseController;
import com.design.framework.supplier.model.Supplier;
import com.design.framework.supplier.service.SupplierService;
@Controller
@Scope("prototype")
@RequestMapping("/sys/supplier")
public class SupplierController extends BaseController {
    
    private final static String URL_SUPPLIER_LIST = "/list";
    private final static String JSP_SUPPLIER_LIST = "jsp/supplier/list";
    private final static String URL_SUPPLIER_LIST2 = "/list2";
    private final static String JSP_SUPPLIER_LIST2 = "jsp/supplier/list2";
    private final static String URL_SUPPLIER_ADD = "/add";
    private final static String JSP_SUPPLIER_ADD = "jsp/supplier/add";
    private final static String URL_SUPPLIER_DELETE = "/delete/{supplier_id}";
    private final static String JSP_SUPPLIER_DELETE = "redirect:/sys/supplier/list";
    
    
    @Autowired
    private SupplierService supplierService ;
    
    @GetMapping(URL_SUPPLIER_DELETE)
    public String delete(@PathVariable("supplier_id") Integer supplier_id){
        this.supplierService.delete(supplier_id);
        return JSP_SUPPLIER_DELETE;
    }

    @GetMapping(URL_SUPPLIER_LIST)
    public String list(Model model){
        model.addAttribute("supplierList" , this.supplierService.list());
        return JSP_SUPPLIER_LIST;
    }
    @GetMapping(URL_SUPPLIER_LIST2)
    public String list2(Model model){
        model.addAttribute("supplierList" , this.supplierService.list());
        return JSP_SUPPLIER_LIST2;
    }
    @GetMapping(URL_SUPPLIER_ADD)
    public String add(){
        return JSP_SUPPLIER_ADD;
    }
    @PostMapping(URL_SUPPLIER_ADD)
    @ResponseBody
    public Map<String,Object> add(String s_name){
        Map<String , Object> map = new HashMap<String , Object>();
        Supplier supplier = new Supplier();
        supplier.setS_name(s_name);;
        try{
            this.supplierService.add(supplier);
            map.put("flag" , "success");
        }catch(Exception e){
            map.put("message" , e.getMessage());
        }
        return map;
    }

    
}
