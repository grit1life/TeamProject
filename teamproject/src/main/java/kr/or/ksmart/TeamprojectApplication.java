package kr.or.ksmart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "kr.or.ksmart")
public class TeamprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamprojectApplication.class, args);
	}

}
