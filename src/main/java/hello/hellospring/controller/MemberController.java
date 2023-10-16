package hello.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hello.hellospring.service.MemberService;

// 스프링 컨테이너에서 스프링 bean이 관리됨
// 컨트롤러를 통해 외부 요청을 받고, 서비스에서 비즈니스 로직을 만들고, 리포지토리에서 데이터를 저장

@Controller
public class MemberController {
	private final MemberService memberService;
	
	// @Autowired private MemberService memberService; // 필드 주입
	
	// @Autowired 를 통한 DI는 helloController, MemberService 등과 같이 스프링이 관리하는 객체에서만 동작한다.
	// 스프링 빈으로 등록하지 않고 내가 직접 생성한 객체에서는 동작하지 않는다.
	
	/*
	 * @Autowired public void setMemberService(Memberservice memberService) { // setter 주입
	 * 누군가 멤버 컨트롤러를 호출했을 때 퍼블릭으로 열려 있어야 함.
	 * this.memberService = memberService; }
	 */
	 
	@Autowired
	public MemberController(MemberService memberService) {		// 의존관계가 실행중에 동적으로 변하는 경우는 거의 없으므로, 생성자 주입을 권장함.
		//  @Autowired 사용으로 스프링 컨테이너에서 memberservice 를 연결해줌 (의존성 주입)
		this.memberService = memberService;
	}
	
}
