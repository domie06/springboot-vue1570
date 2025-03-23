package com.design.framework.medicine.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.design.framework.medicine.model.Medicine;
import com.design.framework.medicine.service.MedicineService;
import com.design.framework.medicineType.service.MedicineTypeService;


@Controller
@Scope("prototype")
@RequestMapping("/sys/medicine")
public class MedicineController {

    private final static String URL_MEDICINE_LIST = "/list";
    private final static String URL_MEDICINE_LIST2 = "/list2";
    private final static String JSP_MEDICINE_LIST = "jsp/medicine/list";
    private final static String JSP_MEDICINE_LIST2 = "jsp/medicine/list2";
    private final static String URL_MEDICINE_ADD = "/add";
    private final static String JSP_MEDICINE_ADD = "jsp/medicine/add";
    private final static String URL_MEDICINE_DELETE = "/delete/{m_id}";
    private final static String URL_MEDICINE_TOUPDATE = "/update/{m_id}";
    private final static String JSP_MEDICINE_TOUPDATE = "jsp/medicine/update";
    private final static String URL_MEDICINE_UPDATE = "/update";

    @Autowired
    private MedicineService medicineService;

    @Autowired
    private MedicineTypeService medicineTypeService ;

    @GetMapping(URL_MEDICINE_TOUPDATE)
    public String update(@PathVariable("m_id") Integer m_id,Model model){
        model.addAttribute("medicine" , this.medicineService.load(m_id));
        model.addAttribute("medicineTypeList" , this.medicineTypeService.list());
        return JSP_MEDICINE_TOUPDATE;
    }
    
    @PostMapping(URL_MEDICINE_UPDATE)
    public String update(Medicine medicine){
        this.medicineService.update(medicine);
        return "redirect:/sys/medicine/list";
    }
    
    @GetMapping(URL_MEDICINE_ADD)
    public String add(Model model){
        model.addAttribute("medicineTypeList" , this.medicineTypeService.list());
        return JSP_MEDICINE_ADD;
    }

    @PostMapping(URL_MEDICINE_ADD)
    public String add(Medicine medicine,ModelMap modelMap){
        try{
            this.medicineService.add(medicine);
            modelMap.addAttribute("addMessage" , "添加成功");
        }catch(Exception e){
            modelMap.addAttribute("addMessage" , "添加失败,原因为:"+e.getMessage());
        }

        return "redirect:/sys/medicine/list";
    }


    @GetMapping(URL_MEDICINE_LIST)
    public String list(Model model,String key){
        model.addAttribute("medicineList" , this.medicineService.list(key==""?null:key));
        model.addAttribute("key" , key);
        return JSP_MEDICINE_LIST;
    }
    
    @GetMapping(URL_MEDICINE_LIST2)
    public String list2(Model model,String key){
        model.addAttribute("medicineList" , this.medicineService.list(key==""?null:key));
        model.addAttribute("key" , key);
        return JSP_MEDICINE_LIST2;
    }

    @GetMapping(URL_MEDICINE_DELETE)
    public String delete(@PathVariable("m_id") Integer m_id){
        this.medicineService.delete(m_id);
        return "redirect:/sys/medicine/list";
    }

}
