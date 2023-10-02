package hello.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;

@Configuration
public class SpringConfig{
	
	// 스프링 빈을 직접 등록하겠다.
	@Bean
	public MemberService memberService() {
		return new MemberService();
	}
	
	@Bean
	public MemberRepository memberRepository() {
		// memberRepository는 인터페이스, MemoryMemberRepository가 구현체
		return new MemoryMemberRepository();
	}
}