package com.tc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description: 测试用途的Controller
 * 
 * @author tc
 * @date 2016-01-26
 * @version v1.0
 */
@Controller
@RequestMapping("test")
public class TestController {
	@RequestMapping("/helloWorld")
	public String helloWorld(Model model) {
		String word0 = "Hello ";
		String word1 = "World!";
		// 将数据添加到视图容器中
		model.addAttribute("word0", word0);
		model.addAttribute("word1", word1);
		return "helloWorld";
	}
}
