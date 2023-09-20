package hello.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hello.hellospring.service.MemberService;

@Controller
// 스프링 컨테이너에서 스프링 bean이 관리됨
// 컨트롤러를 통해 외부 요청을 받고, 서비스에서 비즈니스 로직을 만들고, 리포지토리에서 데이터를 저장
public class MemberController {
	private final MemberService memberService;
	 
	
	@Autowired
	public MemberController(MemberService memberService) {		
		//  @Autowired 사용으로 스프링 컨테이너에서 memberservice 를 연결해줌 (의존성 주입)
		this.memberService = memberService;
	}
	
}
