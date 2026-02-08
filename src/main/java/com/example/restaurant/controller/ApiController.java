package com.example.restaurant.controller;

import com.example.restaurant.wishlist.dto.WishListDto;
import com.example.restaurant.wishlist.service.WishListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// REST API를 제공하는 컨트롤러 (JSON 데이터를 주고받음)
@Slf4j  // 로그 출력을 위한 log 객체 자동 생성
@RestController  // 모든 메서드가 JSON 형태로 응답을 반환
@RequestMapping("/api/restaurant")  // 기본 URL: /api/restaurant
@RequiredArgsConstructor  // final 필드의 생성자를 자동으로 만들어줌 (의존성 주입)
public class ApiController {

    // WishListService를 주입받아 비즈니스 로직 처리
    private final WishListService wishListService;

    // [READ] GET /api/restaurant/search?query=갈비집
    // 네이버 API로 맛집을 검색 → WishListService.search()로 연결
    @GetMapping("/search")
    public WishListDto search(@RequestParam String query){
        return wishListService.search(query);  // WishListService로 전달
    }

    // [CREATE] POST /api/restaurant
    // 요청 본문(JSON)을 받아서 위시리스트에 추가 → WishListService.add()로 연결
    @PostMapping("")
    public WishListDto add(@RequestBody WishListDto wishListDto){
        log.info("위시리스트 추가: {}", wishListDto);  // 로그 출력
        return wishListService.add(wishListDto);  // WishListService로 전달
    }

    // [READ] GET /api/restaurant/all
    // 저장된 모든 위시리스트 조회 → WishListService.findAll()로 연결
    @GetMapping("/all")
    public List<WishListDto> findAll(){
        return wishListService.findAll();  // WishListService로 전달
    }

    // [DELETE] DELETE /api/restaurant/1
    // URL의 {index}를 받아서 해당 맛집 삭제 → WishListService.delete()로 연결
    @DeleteMapping("/{index}")
    public void delete(@PathVariable int index){
        wishListService.delete(index);  // WishListService로 전달
    }

    // [UPDATE] POST /api/restaurant/1
    // URL의 {index}를 받아서 방문 기록 추가 → WishListService.addVisit()로 연결
    @PostMapping("/{index}")
    public void addVisit(@PathVariable int index){
        wishListService.addVisit(index);  // WishListService로 전달
    }

}