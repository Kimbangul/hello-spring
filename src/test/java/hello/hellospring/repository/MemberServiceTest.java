package hello.hellospring.repository;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;

class MemberServiceTest {
	MemberService memberService;
	MemoryMemberRepository memberRepository;
	
	@AfterEach
	public void afterEach() {
		memberRepository.clearStore();
	}
	
	@BeforeEach
	public void beforeEach() {
		// 각 테스트 실행 전 실행
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}

	@Test
	void Join() {
		// given
		Member member = new Member();
		member.setName("spring");
		
		// when
		Long saveId = memberService.Join(member);
		
		// then
		Member findMember = memberService.findOne(saveId).get();
		Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
	}
	
	@Test
	public void 중복회원예외() {
		// given
		Member member1 = new Member();
		member1.setName("spring");
		
		Member member2 = new Member();
		member2.setName("spring");
		
		// when
		memberService.Join(member1);
		
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.Join(member2));
		
		Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		
//		try {
//			memberService.Join(member2);
//			fail();
//		} catch(IllegalStateException e) {
//			Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//		}
		
		
		// then
	}
	
	@Test
	void findMembers() {
		
	}
	
	@Test
	void findOne() {
		
	}
}
