package com.example.restaurant.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 네이버 지역검색 API 응답 DTO
 * 맛집 검색 결과를 담는 컨테이너로, 검색된 맛집 정보 리스트(items)를 포함
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchLocalRes {

    private String lastBuildDate;   // API 응답 생성 시각
    private int total;              // 전체 검색 결과 개수
    private int start;              // 검색 시작 위치
    private int display;            // 반환된 검색 결과 개수
    private List<SearchLocalItem> items;  // 맛집 정보 리스트

    /**
     * 개별 맛집 정보
     * 이름, 주소, 카테고리, 전화번호, 지도 좌표 등 포함
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchLocalItem {
        private String title;        // 맛집 이름
        private String link;         // 맛집 상세 페이지 URL
        private String description;  // 설명
        private String category;     // 카테고리 (예: "음식점>한식")
        private String telephone;    // 전화번호
        private String address;      // 지번 주소
        private String roadAddress;  // 도로명 주소
        private int mapx;            // 지도 X 좌표
        private int mapy;            // 지도 Y 좌표
    }
}