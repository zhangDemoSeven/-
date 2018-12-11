package com.inter.controller.paper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	/**
	 * @Title: monthPage
	 * @Description: TODO:月度考试页面跳转
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping("/paper/month/s/view.do")
	public String monthPage() {
		return "/paper/month/month";
	}
}
