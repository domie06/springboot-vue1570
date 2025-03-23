package com.design.framework.log.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.design.framework.log.service.LogService;

@Controller
@Scope("prototype")
@RequestMapping("/sys/log")
public class LogController {

	private final static String URL_LOG_PURCHASE_LIST = "/purchaseList";
	private final static String JSP_LOG_PURCHASE_LIST = "jsp/log/purchaseList";
	private final static String URL_LOG_SALE_LIST = "/saleList";
	private final static String JSP_LOG_SALE_LIST = "jsp/log/saleList";
	private final static String URL_LOG_SALE_RETURN_LIST = "/returnSaleList";
	private final static String JSP_LOG_SALE_RETURN_LIST = "jsp/log/returnSaleList";
	private final static String URL_LOG_INBOUND = "/inbound";
	private final static String JSP_LOG_INBOUND = "jsp/log/inbound";
	private final static String URL_LOG_OUTBOUND = "/outbound";
	private final static String JSP_LOG_OUTBOUND = "jsp/log/outbound";
	private final static String URL_LOG_SALE_CHART = "/saleChart";
	private final static String JSP_LOG_SALE_CHART = "jsp/log/saleChart";
	
	@Autowired
    private LogService logService;
	
    @GetMapping(URL_LOG_PURCHASE_LIST)
    public String purchaseList(Model model){
        model.addAttribute("logList" ,this.logService.boundList(2));
        return JSP_LOG_PURCHASE_LIST;
    }
    
    @GetMapping(URL_LOG_SALE_CHART)
    public String saleChart(Model model){
        model.addAttribute("logList" ,this.logService.saleChart());
        return JSP_LOG_SALE_CHART;
    }
    
    @GetMapping(URL_LOG_OUTBOUND)
    public String outbound(Model model){
        model.addAttribute("logList" ,this.logService.boundList(3));
        return JSP_LOG_OUTBOUND;
    }
    
    @GetMapping(URL_LOG_INBOUND)
    public String inbound(Model model){
        model.addAttribute("logList" ,this.logService.boundList(2));
        return JSP_LOG_INBOUND;
    }
    
    @GetMapping(URL_LOG_SALE_LIST)
    public String saleList(Model model){
        model.addAttribute("logList" ,this.logService.saleList(0));
        return JSP_LOG_SALE_LIST;
    }
    
    @GetMapping(URL_LOG_SALE_RETURN_LIST)
    public String saleReturnList(Model model){
        model.addAttribute("logList" ,this.logService.saleList(1));
        return JSP_LOG_SALE_RETURN_LIST;
    }
}
