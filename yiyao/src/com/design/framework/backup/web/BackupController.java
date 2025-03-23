package com.design.framework.backup.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.design.base.utils.DatabaseBackup;

@Controller
@Scope("prototype")
@RequestMapping("/sys/backup")
public class BackupController {

    private final static String URL_BACKUP_TOBACKUP = "/toBackup";
    private final static String JSP_BACKUP_TOBACKUP = "jsp/backup/backup";
    private final static String URL_BACKUP_BACKUP = "/backup";
    
    private final static String URL_BACKUP_TORESTORE = "/toRestore";
    private final static String JSP_BACKUP_TORESTORE = "jsp/backup/restore";
    private final static String URL_BACKUP_RESTORE = "/restore";

    @GetMapping(URL_BACKUP_TOBACKUP)
    public String update(){
        return JSP_BACKUP_TOBACKUP;
    }
    
    @PostMapping(URL_BACKUP_BACKUP)
    public String update(String url,Model model){
        try{
            DatabaseBackup bak = new DatabaseBackup("D:/mysql5.7-win32/bin", "root", "mysql");
            bak.backup(url+"yiyao.sql", "yiyao");
            model.addAttribute("message" , "备份成功");
        }catch(Exception e){
            model.addAttribute("message" , "失败,原因为:"+e.getMessage());
        }
        return JSP_BACKUP_TOBACKUP;
    }

    @GetMapping(URL_BACKUP_TORESTORE)
    public String restore(){
        return JSP_BACKUP_TORESTORE;
    }

    @PostMapping(URL_BACKUP_RESTORE)
    public String restore(String url,Model model){
        try{
            DatabaseBackup bak = new DatabaseBackup("D:/mysql5.7-win32/bin", "root", "mysql");
            bak.restore(url+"yiyao.sql", "yiyao");
            model.addAttribute("message" , "恢复成功");
        }catch(Exception e){
            model.addAttribute("message" , "失败,原因为:"+e.getMessage());
        }
        return JSP_BACKUP_TORESTORE;
    }


}
