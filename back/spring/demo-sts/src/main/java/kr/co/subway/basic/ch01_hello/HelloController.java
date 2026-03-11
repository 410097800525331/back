package kr.co.subway.basic.ch01_hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * ctrl+shift+o: 임포트(이클립스)
 * alt+shift+o: 임포트(VS Code)
 */
@Controller
public class HelloController {
    @GetMapping("/")
		public String hello() {
		return "ch01_hello/hello";
    }
}
