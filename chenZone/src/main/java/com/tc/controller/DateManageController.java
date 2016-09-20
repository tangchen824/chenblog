package com.tc.controller;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  

  
/** 
 * Description: 查寝周期管理Controller
 * @author tc
 * @date 2015-03-09 
 * @version v1.0 
 */  
@Controller  
@RequestMapping("dateManage")  
public class DateManageController {  
    @RequestMapping("helloWorld")  
    public String helloworld() {  
        return "hello";  
    }  
  
}  