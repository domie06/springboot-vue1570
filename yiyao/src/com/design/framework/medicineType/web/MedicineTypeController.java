package com.design.framework.medicineType.web;

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
import com.design.framework.medicineType.model.MedicineType;
import com.design.framework.medicineType.service.MedicineTypeService;
@Controller
@Scope("prototype")
@RequestMapping("/sys/medicineType")
public class MedicineTypeController extends BaseController {
    
    private final static String URL_MEDICINETYPE_LIST = "/list";
    private final static String JSP_MEDICINETYPE_LIST = "jsp/medicineType/list";
    private final static String URL_MEDICINETYPE_ADD = "/add";
    private final static String JSP_MEDICINETYPE_ADD = "jsp/medicineType/add";
    private final static String URL_MEDICINETYPE_DELETE = "/delete/{medicineType_id}";
    private final static String JSP_MEDICINETYPE_DELETE = "redirect:/sys/medicineType/list";
    
    
    @Autowired
    private MedicineTypeService medicineTypeService ;
    
    @GetMapping(URL_MEDICINETYPE_DELETE)
    public String delete(@PathVariable("medicineType_id") Integer medicineType_id){
        this.medicineTypeService.delete(medicineType_id);
        return JSP_MEDICINETYPE_DELETE;
    }

    @GetMapping(URL_MEDICINETYPE_LIST)
    public String list(Model model){
        model.addAttribute("medicineTypeList" , this.medicineTypeService.list());
        return JSP_MEDICINETYPE_LIST;
    }
    @GetMapping(URL_MEDICINETYPE_ADD)
    public String add(){
        return JSP_MEDICINETYPE_ADD;
    }
    @PostMapping(URL_MEDICINETYPE_ADD)
    @ResponseBody
    public Map<String,Object> add(String mt_name){
        Map<String , Object> map = new HashMap<String , Object>();
        MedicineType medicineType = new MedicineType();
        medicineType.setMt_name(mt_name);;
        try{
            this.medicineTypeService.add(medicineType);
            map.put("flag" , "success");
        }catch(Exception e){
            map.put("message" , e.getMessage());
        }
        return map;
    }

    
}
