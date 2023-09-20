// 여기 등록된 패키지의 하위를 뒤져서 스프링 bean으로 등록 (컴포넌트 스캔)
package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) { // 메인 메서드로부터 모든 것이 시작됨
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
