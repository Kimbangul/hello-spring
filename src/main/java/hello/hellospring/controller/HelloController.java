package hello.hellospring.controller;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
	
	@GetMapping("hello") // HTTP GET 메서드의 GET
	public String hello(Model model) {
		model.addAttribute("data","hello");
		return "hello"; // 렌더링 할 위치 
		// 컨트롤러에서 리턴 값으로 문자를 반환하면 view resolver가 화면을 찾아서 반환해줌.
	}
}
