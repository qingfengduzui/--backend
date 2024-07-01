package org.example.test_second;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("org.example.test_second.mapper")
@EnableCaching
public class TestSecondApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSecondApplication.class, args);
	}

}
