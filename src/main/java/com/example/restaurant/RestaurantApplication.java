package com.example.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Spring Boot 애플리케이션의 시작점 - main 메서드가 있는 클래스
@SpringBootApplication  // 자동 설정, 컴포넌트 스캔, 설정 클래스 기능을 모두 활성화
public class RestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);  // 애플리케이션 실행 (내장 톰캣 서버 시작)
	}

}