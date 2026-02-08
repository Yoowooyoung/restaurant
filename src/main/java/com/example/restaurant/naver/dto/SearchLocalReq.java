package com.example.restaurant.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * 네이버 지역검색 API 요청 DTO
 * 맛집 검색 시 사용되며, 검색어와 정렬 옵션을 HTTP 쿼리 파라미터로 변환
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchLocalReq {

    private String query = "";      // 검색어 (예: "강남 갈비집")
    private int display = 1;        // 검색 결과 개수
    private int start = 1;          // 검색 시작 위치
    private String sort = "random"; // 정렬 방식 (random: 정확도순)

    // DTO를 HTTP 쿼리 파라미터(MultiValueMap)로 변환
    public MultiValueMap<String, String> toMultiValueMap(){
        var map = new LinkedMultiValueMap<String, String>();

        map.add("query",query);
        map.add("display",String.valueOf(display));
        map.add("start", String.valueOf(start));
        map.add("sort",sort);
        return map;
    }
}