package kr.co.subway.basic.ch02_데이터전달;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StrController {
	
	// http://localhost:8080/ch02
	@GetMapping("/ch02/str")
	public String user(Model model) {
		model.addAttribute("username", "홍길동");
		model.addAttribute("greeting", "환영합니다.");
		// src/main/resources/templates/ch02_데이터전달/stringResult.html로 이동
		return "ch02_데이터전달/str";
	}
}
