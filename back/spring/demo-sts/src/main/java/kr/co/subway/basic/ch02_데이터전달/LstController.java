package kr.co.subway.basic.ch02_데이터전달;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LstController {
	@GetMapping("ch02/lst")
	public String ch02Lst(Model model) {
		List<UserDTO> userList = new ArrayList<>();
		
		userList.add(new UserDTO("김철수", "chul@example.com", 25));
		userList.add(new UserDTO("이오리", "young@example.com", 19));
		userList.add(new UserDTO("박민수", "min@example.com", 32));
		
		model.addAttribute("users", userList);
		return "ch02_데이터전달/lst";
	}
}
