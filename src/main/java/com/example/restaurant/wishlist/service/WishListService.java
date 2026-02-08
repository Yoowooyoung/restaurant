package com.example.restaurant.wishlist.service;

import com.example.restaurant.naver.NaverClient;
import com.example.restaurant.naver.dto.SearchImageReq;
import com.example.restaurant.naver.dto.SearchLocalReq;
import com.example.restaurant.wishlist.dto.WishListDto;
import com.example.restaurant.wishlist.entity.WishListEntity;
import com.example.restaurant.wishlist.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// 비즈니스 로직을 처리하는 서비스 (Controller와 Repository 사이의 중간 계층)
@Service  // 서비스 레이어의 빈으로 등록
@RequiredArgsConstructor  // final 필드의 생성자 자동 생성
public class WishListService {

    private final NaverClient naverClient;  // 네이버 API 호출 → NaverClient로 연결
    private final WishListRepository wishListRepository;  // 데이터 저장/조회 → WishListRepository로 연결

    // 맛집 검색: 네이버 지역검색 + 이미지검색 결과를 합쳐서 반환
    public WishListDto search(String query){
        // 1. 네이버 지역검색 API 호출 → NaverClient.searchLocal()로 연결
        var searchLocalReq = new SearchLocalReq();
        searchLocalReq.setQuery(query);
        var searchLocalRes = naverClient.searchLocal(searchLocalReq);

        if(searchLocalRes.getTotal() > 0){
            var localItem = searchLocalRes.getItems().stream().findFirst().get();

            // 2. 제목에서 HTML 태그 제거 (예: "<b>갈비집</b>" → "갈비집")
            var imageQuery = localItem.getTitle().replaceAll("<[^>]*>","");
            var searchImageReq = new SearchImageReq();
            searchImageReq.setQuery(imageQuery);

            // 3. 네이버 이미지검색 API 호출 → NaverClient.searchImage()로 연결
            var searchImageRes = naverClient.searchImage(searchImageReq);

            if(searchImageRes.getTotal() > 0){
                var imageItem = searchImageRes.getItems().stream().findFirst().get();

                // 4. 지역검색 결과 + 이미지 URL을 합쳐서 WishListDto 생성
                var result = new WishListDto();
                result.setTitle(localItem.getTitle());
                result.setCategory(localItem.getCategory());
                result.setAddress(localItem.getAddress());
                result.setRoadAddress(localItem.getRoadAddress());
                result.setHomePageLink(localItem.getLink());
                result.setImageLink(imageItem.getLink());  // 이미지가 안 보이면 .getThumbnail()로 변경
                return result;
            }
        }

        return new WishListDto();  // 검색 결과가 없으면 빈 DTO 반환
    }

    // 위시리스트 추가: DTO를 Entity로 변환 → Repository에 저장
    public WishListDto add(WishListDto wishListDto) {
        var entity = dtoToEntity(wishListDto);  // DTO → Entity 변환
        var saveEntity = wishListRepository.save(entity);  // Repository에 저장 (WishListRepository.save()로 연결)
        return entityToDto(saveEntity);  // Entity → DTO 변환 후 반환
    }

    // DTO를 Entity로 변환 (Controller에서 받은 데이터를 DB 저장용으로 변환)
    private WishListEntity dtoToEntity(WishListDto wishListDto){
        var entity = new WishListEntity();
        entity.setIndex(wishListDto.getIndex());
        entity.setTitle(wishListDto.getTitle());
        entity.setCategory(wishListDto.getCategory());
        entity.setAddress(wishListDto.getAddress());
        entity.setRoadAddress(wishListDto.getRoadAddress());
        entity.setHomePageLink(wishListDto.getHomePageLink());
        entity.setImageLink(wishListDto.getImageLink());
        entity.setVisit(wishListDto.isVisit());
        entity.setVisitCount(wishListDto.getVisitCount());
        entity.setLastVisitDate(wishListDto.getLastVisitDate());
        return entity;
    }

    // Entity를 DTO로 변환 (DB에서 꺼낸 데이터를 Controller로 전달하기 위해 변환)
    private WishListDto entityToDto(WishListEntity wishListEntity){
        var dto = new WishListDto();
        dto.setIndex(wishListEntity.getIndex());
        dto.setTitle(wishListEntity.getTitle());
        dto.setCategory(wishListEntity.getCategory());
        dto.setAddress(wishListEntity.getAddress());
        dto.setRoadAddress(wishListEntity.getRoadAddress());
        dto.setHomePageLink(wishListEntity.getHomePageLink());
        dto.setImageLink(wishListEntity.getImageLink());
        dto.setVisit(wishListEntity.isVisit());
        dto.setVisitCount(wishListEntity.getVisitCount());
        dto.setLastVisitDate(wishListEntity.getLastVisitDate());
        return dto;
    }

    // 전체 위시리스트 조회: Repository에서 가져온 Entity 리스트를 DTO 리스트로 변환
    public List<WishListDto> findAll() {
        return wishListRepository.findAll()  // Repository에서 전체 조회 (WishListRepository.findAll()로 연결)
                .stream()
                .map(it -> entityToDto(it))  // 각 Entity를 DTO로 변환
                .collect(Collectors.toList());
    }

    // 위시리스트 삭제: Repository의 deleteById 호출
    public void delete(int index) {
        wishListRepository.deleteById(index);  // WishListRepository.deleteById()로 연결
    }

    // 방문 기록 추가: Repository에서 찾아서 visitCount 증가
    public void addVisit(int index){
        var wishItem = wishListRepository.findById(index);  // Repository에서 조회 (WishListRepository.findById()로 연결)
        if(wishItem.isPresent()){
            var item = wishItem.get();
            item.setVisit(true);  // 방문 여부 true로 변경
            item.setVisitCount(item.getVisitCount()+1);  // 방문 횟수 1 증가
            // item.setLastVisitDate(LocalDateTime.now());  // 마지막 방문일 업데이트 (현재 미사용)
        }
    }
}