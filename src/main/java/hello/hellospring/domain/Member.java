package hello.hellospring.domain;
// 저장소 생성 
public class Member {
	private Long id;
	private String name;
	
	public Long getId() {
		return id;
	} 
	
	public void setId(Long id) {
		this.id = id;
		}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
