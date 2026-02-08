package com.example.restaurant.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 네이버 이미지검색 API 응답 DTO
 * 이미지 검색 결과를 담는 컨테이너로, 검색된 이미지 정보 리스트(items)를 포함
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchImageRes {

    private String lastBuildDate;   // API 응답 생성 시각
    private int total;              // 전체 검색 결과 개수
    private int start;              // 검색 시작 위치
    private int display;            // 반환된 검색 결과 개수
    private List<SearchImageItem> items;  // 이미지 정보 리스트

    /**
     * 개별 이미지 정보
     * 이미지 제목, 원본 링크, 썸네일, 크기 정보 포함
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchImageItem {
        private String title;       // 이미지 제목
        private String link;        // 원본 이미지 URL
        private String thumbnail;   // 썸네일 이미지 URL (프로젝트에서 사용)
        private String sizeheight;  // 이미지 높이
        private String sizewidth;   // 이미지 너비
    }
}