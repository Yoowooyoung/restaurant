package com.example.restaurant.wishlist.entity;

import com.example.restaurant.db.MemoryDbEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// 위시리스트 테이블과 매핑되는 Entity (DB에 저장되는 데이터 구조)
@NoArgsConstructor  // 기본 생성자 자동 생성
@AllArgsConstructor  // 모든 필드를 받는 생성자 자동 생성
@Data  // Getter/Setter/toString/equals/hashCode 자동 생성
public class WishListEntity extends MemoryDbEntity {

    private String title;  // 맛집 이름
    private String category;  // 카테고리 (예: "한식>고기구이")
    private String address;  // 지번 주소
    private String roadAddress;  // 도로명 주소
    private String homePageLink;  // 홈페이지 링크
    private String imageLink;  // 이미지 URL
    private boolean isVisit;  // 방문 여부
    private int visitCount;  // 방문 횟수
    private LocalDateTime lastVisitDate;  // 마지막 방문일
}