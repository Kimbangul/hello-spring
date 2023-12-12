package hello.hellospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

// 스프링이 스프링 컨테이너에 서비스를 등록
public class MemberService {
	//domain 은 단순한 데이터 입출력에 가까운 느낌인 반면 service 는 좀더 비즈니스에 가까운 느낌 
	
	// final : 재정의, 수정 불가 
	private final MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) { // 생성자 주입
		this.memberRepository = memberRepository;
	}
	
	// 회원 가입 
	public Long join(Member member) {
		validateDuplicateMember(member); // 중복회원 검증 
		
		memberRepository.save(member);
		return member.getId();
	}
	
	// 같은 이름이 있는 중복회원은 가입 X 	
	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName())
			.ifPresent(m -> {
				throw new IllegalStateException("이미 존재하는 회원입니다.");
			}); 
		// ifPresent 는 Optional에 쓸 수 있는 메서드
		// memberRepository.findByName(member.getName()).ifPresent()식으로도 사용 가능
	}
	
	// 전체 회원 조회 
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}
	
	public Optional<Member> findOne(Long memberId){
		return memberRepository.findById(memberId);
	}
	
}
