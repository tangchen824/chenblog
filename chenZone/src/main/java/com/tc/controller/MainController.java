package com.tc.controller;

import com.tc.log.Log;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description: 主页的Controller
 * 
 * @author tc
 * @date 2016-01-26
 * @version v1.0
 */
@Controller
@RequestMapping("/main")
public class MainController {
	private Log log = Log.getLog(this.getClass());
	
	@RequestMapping("/index")
	public String helloWorld(Model model) {
//		String word0 = "Hello ";
//		String word1 = "World!";
//		// 将数据添加到视图容器中
//		model.addAttribute("word0", word0);
//		model.addAttribute("word1", word1);
		log.info("通知");
		log.debug("调试");
		log.warn("警告");
		log.error("错误");
		return "home/index";
	}
	
	@RequestMapping("/gallery")
	public String gallery(Model model) {
		return "home/gallery";
	}
	
	@RequestMapping("/contact")
	public String contact(Model model) {
		return "home/contact";
	}
	
	@RequestMapping("/about")
	public String about(Model model) {
		return "home/about";
	}
	
	@RequestMapping("/home")
	public String home(Model model) {
		return "main/home";
	}
}
