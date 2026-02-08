package com.example.restaurant.wishlist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// 계층 간 데이터 전달을 위한 객체 (Controller ↔ Service 간 데이터 전송용)
@NoArgsConstructor  // 기본 생성자 자동 생성 (JSON → 객체 변환 시 필요)
@AllArgsConstructor  // 모든 필드를 받는 생성자 자동 생성
@Data  // Getter/Setter/toString/equals/hashCode 자동 생성
public class WishListDto {
    private Integer index;  // 맛집 ID
    private String title;  // 맛집 이름
    private String category;  // 카테고리
    private String address;  // 지번 주소
    private String roadAddress;  // 도로명 주소
    private String homePageLink;  // 홈페이지 링크
    private String imageLink;  // 이미지 URL
    private boolean isVisit;  // 방문 여부
    private int visitCount;  // 방문 횟수
    private LocalDateTime lastVisitDate;  // 마지막 방문일
}