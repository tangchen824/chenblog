package com.tc.controller;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  

  
/** 
 * Description: 交流墙Controller
 * @author tc
 * @date 2015-03-09 
 * @version v1.0 
 */  
@Controller  
@RequestMapping("communionWall")  
public class CommunionWallController {  
    @RequestMapping("communionWall")  
    public String communionWall() {  
        return "/life/communion_wall_/communion_wall_list";  
    }   
}  