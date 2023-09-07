package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) { // 메인 메서드로부터 모든 것이 시작됨
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
