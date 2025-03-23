package com.design.framework.inventory.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.design.base.utils.BaseController;
import com.design.framework.customer.service.CustomerService;
import com.design.framework.inventory.model.Inventory;
import com.design.framework.inventory.service.InventoryService;
import com.design.framework.log.model.Log;
import com.design.framework.log.service.LogService;
import com.design.framework.medicine.service.MedicineService;
import com.design.framework.supplier.service.SupplierService;
import com.design.framework.user.model.User;
@Controller
@Scope("prototype")
@RequestMapping("/sys/inventory")
public class InventoryController extends BaseController {

    private final static String URL_INVENTORY_LIST = "/list";
    private final static String JSP_INVENTORY_LIST = "jsp/inventory/list";
    private final static String URL_INVENTORY_TO_UPDATE = "/update/{m_id}";
    private final static String URL_INVENTORY_ADD = "/add";
    private final static String URL_INVENTORY_RETURN = "/return";
    private final static String URL_INVENTORY_UPDATE = "/update";
    private final static String JSP_INVENTORY_UPDATE = "jsp/inventory/update";
    private final static String JSP_INVENTORY_ADD = "jsp/inventory/add";
    private final static String JSP_INVENTORY_RETURN = "jsp/inventory/return";
    private final static String URL_INVENTORY_SALE = "/sale";
    private final static String JSP_INVENTORY_SALE = "jsp/doctor/sale";
    private final static String URL_INVENTORY_SALE_RETURN = "/saleReturn";
    private final static String JSP_INVENTORY_SALE_RETURN = "jsp/doctor/saleReturn";

    @Autowired
    private InventoryService inventoryService ;
    @Autowired
    private MedicineService medicineService;
    @Autowired
    private LogService logService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private CustomerService customerService;
    
    @GetMapping(URL_INVENTORY_LIST)
    public String list(Model model){
        model.addAttribute("inventoryList" , this.inventoryService.list());
        return JSP_INVENTORY_LIST;
    }
    @GetMapping(URL_INVENTORY_TO_UPDATE)
    public String update(@PathVariable("m_id") Integer m_id,Model model){
        model.addAttribute("inventory" , this.inventoryService.load(m_id));
        return JSP_INVENTORY_UPDATE;
    }
    @GetMapping(URL_INVENTORY_ADD)
    public String add(ModelMap model){
        model.addAttribute("medicineList" , this.medicineService.list(null));
        model.addAttribute("supplierList" , this.supplierService.list());
        return JSP_INVENTORY_ADD;
    }

    @GetMapping(URL_INVENTORY_SALE)
    public String sale(ModelMap model){
        model.addAttribute("medicineList" , this.medicineService.list(null));
        model.addAttribute("customerList" , this.customerService.list());
        return JSP_INVENTORY_SALE;
    }

    @GetMapping(URL_INVENTORY_SALE_RETURN)
    public String saleReturn(ModelMap model){
        model.addAttribute("medicineList" , this.medicineService.list(null));
        model.addAttribute("customerList" , this.customerService.list());
        return JSP_INVENTORY_SALE_RETURN;
    }

    @GetMapping(URL_INVENTORY_RETURN)
    public String returnMedicine(ModelMap model){
        model.addAttribute("medicineList" , this.medicineService.list(null));
        model.addAttribute("supplierList" , this.supplierService.list());
        return JSP_INVENTORY_RETURN;
    }
    @PostMapping(URL_INVENTORY_SALE)
    public String sale(Integer m_id,Integer num,Integer c_id,ModelMap modelMap,HttpServletRequest request){
        try{
            if(this.customerService.load(c_id)!=null){
                Inventory inventory = this.inventoryService.load(m_id);
                if(inventory.getNum() >= num){
                    inventory.setNum(inventory.getNum() - num);
                    this.inventoryService.update(inventory);
                    User user = (User) request.getSession().getAttribute("session_user");
                    Log log = new Log();
                    log.setL_type(0);
                    log.setM_id(m_id);
                    log.setS_id(c_id);
                    log.setM_num(num);
                    log.setU_id(user.getUser_id());
                    log.setL_date(new Date());
                    this.logService.add(log);
                    if(inventory.getMin_num() < inventory.getNum()){
                        modelMap.addAttribute("addMessage" , "销售成功");
                        modelMap.addAttribute("medicineList" , this.medicineService.list(null));
                        modelMap.addAttribute("supplierList" , this.supplierService.list());
                    }else{
                        modelMap.addAttribute("addMessage" , "销售成功，库存余额不足，请尽快进货，该药品剩余数量为："+inventory.getNum());
                        modelMap.addAttribute("medicineList" , this.medicineService.list(null));
                        modelMap.addAttribute("supplierList" , this.supplierService.list());
                    }
                }else{
                    modelMap.addAttribute("addMessage" , "销售失败，库存余额不足");
                    modelMap.addAttribute("medicineList" , this.medicineService.list(null));
                    modelMap.addAttribute("supplierList" , this.supplierService.list());
                }
            }else{
                modelMap.addAttribute("addMessage" , "查无此id,请重新输入顾客id");
                modelMap.addAttribute("medicineList" , this.medicineService.list(null));
                modelMap.addAttribute("supplierList" , this.supplierService.list());
            }
        }catch(Exception e){
            modelMap.addAttribute("addMessage" , "销售失败,原因为:"+e.getMessage());
            modelMap.addAttribute("medicineList" , this.medicineService.list(null));
            modelMap.addAttribute("supplierList" , this.supplierService.list());
        }
        return sale(modelMap);
    }

    @PostMapping(URL_INVENTORY_SALE_RETURN)
    public String saleReturn(Integer m_id,Integer num,Integer c_id,ModelMap modelMap,HttpServletRequest request){
        try{
            if(this.customerService.load(c_id)!=null){
                Inventory inventory = this.inventoryService.load(m_id);
                inventory.setNum(inventory.getNum() + num);
                this.inventoryService.update(inventory);
                User user = (User) request.getSession().getAttribute("session_user");
                Log log = new Log();
                log.setL_type(1);
                log.setM_id(m_id);
                log.setS_id(c_id);
                log.setM_num(num);
                log.setU_id(user.getUser_id());
                log.setL_date(new Date());
                this.logService.add(log);
                if(inventory.getMax_num() > inventory.getNum()){
                    modelMap.addAttribute("addMessage" , "退货成功");
                    modelMap.addAttribute("medicineList" , this.medicineService.list(null));
                    modelMap.addAttribute("supplierList" , this.supplierService.list());
                }else{
                    modelMap.addAttribute("addMessage" , "退货成功，库存溢出，该药品剩余数量为："+inventory.getNum());
                    modelMap.addAttribute("medicineList" , this.medicineService.list(null));
                    modelMap.addAttribute("supplierList" , this.supplierService.list());
                }
            }else{
                modelMap.addAttribute("addMessage" , "查无此id,请重新输入顾客id");
                modelMap.addAttribute("medicineList" , this.medicineService.list(null));
                modelMap.addAttribute("supplierList" , this.supplierService.list());
            }
        }catch(Exception e){
            modelMap.addAttribute("addMessage" , "退货失败,原因为:"+e.getMessage());
            modelMap.addAttribute("medicineList" , this.medicineService.list(null));
            modelMap.addAttribute("supplierList" , this.supplierService.list());
        }
        return saleReturn(modelMap);
    }

    @PostMapping(URL_INVENTORY_ADD)
    public String add(Inventory inventory,Integer s_id,ModelMap modelMap,HttpServletRequest request){
        try{
            Inventory finalInventory = this.inventoryService.load(inventory.getM_id());
            finalInventory.setNum(finalInventory.getNum()+inventory.getNum());
            this.inventoryService.update(finalInventory);
            User user = (User) request.getSession().getAttribute("session_user");
            Log log = new Log();
            log.setL_type(2);
            log.setM_id(inventory.getM_id());
            log.setS_id(s_id);
            log.setM_num(inventory.getNum());
            log.setU_id(user.getUser_id());
            log.setL_date(new Date());
            this.logService.add(log);
            if(finalInventory.getMax_num()>=(finalInventory.getNum()+inventory.getNum())){
                modelMap.addAttribute("addMessage" , "添加货物成功");
                modelMap.addAttribute("medicineList" , this.medicineService.list(null));
                modelMap.addAttribute("supplierList" , this.supplierService.list());
            }else if(finalInventory.getMax_num()<(finalInventory.getNum()+inventory.getNum())){
                modelMap.addAttribute("addMessage" , "添加货物成功,库存已超过上限");
                modelMap.addAttribute("medicineList" , this.medicineService.list(null));
                modelMap.addAttribute("supplierList" , this.supplierService.list());
            }else if(finalInventory.getMax_num()==(finalInventory.getNum()+inventory.getNum())){
                modelMap.addAttribute("addMessage" , "添加货物成功,库存已达到上限");
                modelMap.addAttribute("medicineList" , this.medicineService.list(null));
                modelMap.addAttribute("supplierList" , this.supplierService.list());
            }
        }catch(Exception e){
            modelMap.addAttribute("addMessage" , "添加货物失败,原因为:"+e.getMessage());
            modelMap.addAttribute("medicineList" , this.medicineService.list(null));
            modelMap.addAttribute("supplierList" , this.supplierService.list());
        }
        return add(modelMap);
    }

    @PostMapping(URL_INVENTORY_RETURN)
    public String returnMedicine(Inventory inventory,Integer s_id,ModelMap modelMap,HttpServletRequest request){
        try{
            Inventory finalInventory = this.inventoryService.load(inventory.getM_id());
            if(finalInventory.getNum() >= inventory.getNum()){
                finalInventory.setNum(finalInventory.getNum()-inventory.getNum());
                this.inventoryService.update(finalInventory);
                User user = (User) request.getSession().getAttribute("session_user");
                Log log = new Log();
                log.setL_type(3);
                log.setM_id(inventory.getM_id());
                log.setS_id(s_id);
                log.setM_num(inventory.getNum());
                log.setU_id(user.getUser_id());
                log.setL_date(new Date());
                this.logService.add(log);
                if(finalInventory.getMin_num() >= finalInventory.getNum()){
                    modelMap.addAttribute("addMessage" , "退货成功,库存不足，请尽快进货");
                    modelMap.addAttribute("medicineList" , this.medicineService.list(null));
                    modelMap.addAttribute("supplierList" , this.supplierService.list());
                }else{
                    modelMap.addAttribute("addMessage" , "退货成功");
                    modelMap.addAttribute("medicineList" , this.medicineService.list(null));
                    modelMap.addAttribute("supplierList" , this.supplierService.list());
                }
            }else{
                modelMap.addAttribute("addMessage" , "退货失败，库存数量不足退货，剩余数量为："+finalInventory.getNum());
                modelMap.addAttribute("medicineList" , this.medicineService.list(null));
                modelMap.addAttribute("supplierList" , this.supplierService.list());
            }
        }catch(Exception e){
            modelMap.addAttribute("addMessage" , "退货失败,原因为:"+e.getMessage());
            modelMap.addAttribute("medicineList" , this.medicineService.list(null));
            modelMap.addAttribute("supplierList" , this.supplierService.list());
        }
        return returnMedicine(modelMap);
    }
    @PostMapping(URL_INVENTORY_UPDATE)
    @ResponseBody
    public Map<String,Object> update(Inventory inventory){
        Map<String , Object> map = new HashMap<String , Object>();
        try{
            this.inventoryService.update(inventory);
            map.put("flag" , "success");
        }catch(Exception e){
            map.put("message" , e.getMessage());
        }
        return map;
    }
    

}
