package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//***********************SERVER***********************
@SpringBootApplication
public class HelloSpringApplication {

	//main method 실행 -> index.html(Welcome page) -> HelloController.java -> hello.html
	public static void main(String[] args) {

		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
