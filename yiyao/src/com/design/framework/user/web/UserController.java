package com.design.framework.user.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.design.framework.user.model.User;
import com.design.framework.user.service.UserService;


@Controller
@Scope("prototype")
@RequestMapping("/sys/user")
public class UserController {

    private final static String URL_USER_LIST = "/list";
    private final static String JSP_USER_LIST = "jsp/user/list";
    private final static String URL_USER_ADD = "/add";
    private final static String JSP_USER_ADD = "jsp/user/add";
    private final static String URL_USER_DELETE = "/delete/{user_id}";
    private final static String URL_USER_CHECKACCOUNT = "/checkAccount";
    private final static String URL_USER_CHANGEPASSWORD = "/changePassword";
    private final static String JSP_USER_CHANGEPASSWORD = "jsp/user/changePassword";
    private final static String URL_USER_TOUPDATE = "/update/{user_id}";
    private final static String JSP_USER_TOUPDATE = "jsp/user/update";
    private final static String URL_USER_UPDATE = "/update";

    @Autowired
    private UserService userService;

    @GetMapping(URL_USER_TOUPDATE)
    public String update(@PathVariable("user_id") Integer user_id,Model model){
        model.addAttribute("user" , this.userService.load(user_id));
        return JSP_USER_TOUPDATE;
    }
    
    @PostMapping(URL_USER_UPDATE)
    public String changePassword(User user){
        this.userService.update(user);
        return "redirect:/sys/user/list";
    }
    
    @GetMapping(URL_USER_CHANGEPASSWORD)
    public String changePassword(){
        return JSP_USER_CHANGEPASSWORD;
    }

    @PostMapping(URL_USER_CHANGEPASSWORD)
    public String changePassword(User user,ModelMap modelMap,HttpServletRequest request){
        this.userService.update(user);
        
        HttpSession session = request.getSession();
        User newUser = (User)session.getAttribute("session_user");
        newUser.setPassword(user.getPassword());
        session.setAttribute("session_user" , newUser);
        
        modelMap.addAttribute("changeMessage" , "修改成功");
        return JSP_USER_CHANGEPASSWORD;
    }

    @GetMapping(URL_USER_ADD)
    public String add(){
        return JSP_USER_ADD;
    }

    @PostMapping(URL_USER_ADD)
    public String add(User user,ModelMap modelMap){
        try{
            this.userService.add(user);
            modelMap.addAttribute("addMessage" , "添加成功");
        }catch(Exception e){
            modelMap.addAttribute("addMessage" , "添加失败,原因为:"+e.getMessage());
        }

        return JSP_USER_ADD;
    }

    @PostMapping(URL_USER_CHECKACCOUNT)
    @ResponseBody
    public Map<String,Object> checkAccount(String account){
        Map<String , Object> map = new HashMap<String , Object>();
        if(this.userService.checkAccount(account)){
            map.put("flag" , "success");
        }else{
            
            map.put("flag" , "error");
        }
        return map;
    }

    @GetMapping(URL_USER_LIST)
    public String list(Model model){
        model.addAttribute("userList" , this.userService.list());
        return JSP_USER_LIST;
    }

    @GetMapping(URL_USER_DELETE)
    public String delete(@PathVariable("user_id") Integer user_id){
        this.userService.delete(user_id);
        return "redirect:/sys/user/list";
    }

}
