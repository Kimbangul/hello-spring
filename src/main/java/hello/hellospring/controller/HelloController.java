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
	
	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name); // key, value
		
		return "hello-template";
	}
	
	@GetMapping("hello-string")
	@ResponseBody 
	 // http통신 body부의 데이터를 직접  넣어주겠다 라는 뜻 
	public String helloString (@RequestParam("name") String name) {
		return "hello" + name;
	}
	
	@GetMapping("hello-api")
	@ResponseBody
	public Hello HelloApi(@RequestParam("name") String name) {
		Hello hello = new Hello();
		hello.setName(name);
		return hello; // 객체 리턴 
	}
	static class Hello{
		private String name;
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
	}
}
