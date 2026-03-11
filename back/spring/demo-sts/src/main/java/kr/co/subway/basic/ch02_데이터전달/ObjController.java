package kr.co.subway.basic.ch02_데이터전달;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ObjController {
	@GetMapping("/ch02/obj")
	public String userInfo(Model model) {
		UserDTO user = new UserDTO("홍길동", "hong@naver.com", 25);
		
		model.addAttribute("user", user);
		return "ch02_데이터전달/obj";
	}
}
