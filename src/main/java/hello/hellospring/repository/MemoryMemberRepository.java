package hello.hellospring.repository;

import java.util.*;

import hello.hellospring.domain.Member;

// implements : 인터페이스를 구체적으로 구현하는 키워드 
public class MemoryMemberRepository implements MemberRepository {
	
	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0L; // 키값을 생성해 주는 역할 

	@Override
	public Member save(Member member) {
		 member.setId(++sequence);
		 store.put(member.getId(), member); // map 에 저장 
		 return member;
	}

	@Override
	public Optional<Member> findById(Long Id) {
		return Optional.ofNullable(store.get(Id)); // null 일 수 있는경우 
	}

	@Override
	public Optional<Member> findByName(String name) {
		return store.values().stream() //루프를 돌며 하나 찾아지면 반환
		.filter(member -> member.getName().equals(name))
		.findAny();
	}

	@Override
	public List<Member> findAll() {
		return new ArrayList<>(store.values());
	}

	public void clearStore() {
		store.clear();
	}
}
