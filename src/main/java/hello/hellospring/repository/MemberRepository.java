package hello.hellospring.repository;

import java.util.List;
import java.util.Optional;

import hello.hellospring.domain.Member;

public interface MemberRepository {
	Member save(Member member);
	
	Optional<Member> findById(Long Id); // Optional ->결과가 없으면 null로 반환 
	Optional<Member> findByName(String name);
	
	List<Member> findAll();
}
