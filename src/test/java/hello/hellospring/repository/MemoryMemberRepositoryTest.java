package hello.hellospring.repository;

import java.util.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;

class MemoryMemberRepositoryTest {
	// 모든 테스트는 순서대로 실행되지 않는다. (서로 의존관계가 없음)
	// 이전에 저장했던 객체가 나와버림
	// 테스트 후 데이터를 클리어해줘야 함
	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	@AfterEach // 메서드가 끝나고 나서 실행된다는 뜻
	public void afterEach() {
		repository.clearStore();
	}
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");
		
		repository.save(member);
		
		Member result = repository.findById(member.getId()).get(); // Optional 값은 get() 메서드로 꺼낸다.
		// System.out.println(result == member);
		// Assertions.assertEquals(member, result); // 기대값과 실제값
		
		Assertions.assertThat(member).isEqualTo(result);
	}
	
	@Test
	public void findByName() {
		Member member = new Member();
		member.setName("spring1");
		repository.save(member);
		
		Member member2 = new Member();
		member.setName("member2");
		repository.save(member2);
		
		Member result = repository.findByName("member2").get();
		
		Assertions.assertThat(result).isEqualTo(member);
	}
	
	@Test
	public void findAll() {
		Member member = new Member();
		member.setName("spring1");
		repository.save(member);
		
		Member member2 = new Member();
		member.setName("member2");
		repository.save(member2);
		
		List<Member> result = repository.findAll();
		
		Assertions.assertThat(result.size()).isEqualTo(2);
	}
	
	

}
