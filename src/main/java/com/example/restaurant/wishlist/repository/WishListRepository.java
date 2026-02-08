package com.example.restaurant.wishlist.repository;

import com.example.restaurant.db.MemoryDbRepositoryAbstract;
import com.example.restaurant.wishlist.entity.WishListEntity;
import org.springframework.stereotype.Repository;

// 데이터 접근을 담당하는 Repository (DB와 통신하는 계층)
@Repository  // Repository 레이어의 빈으로 등록
public class WishListRepository extends MemoryDbRepositoryAbstract<WishListEntity> {
    // MemoryDbRepositoryAbstract를 상속받아 CRUD 기능을 자동으로 사용 가능
    // - save(): 데이터 저장 (MemoryDbRepositoryAbstract.save()로 연결)
    // - findById(): ID로 조회 (MemoryDbRepositoryAbstract.findById()로 연결)
    // - findAll(): 전체 조회 (MemoryDbRepositoryAbstract.findAll()로 연결)
    // - deleteById(): 삭제 (MemoryDbRepositoryAbstract.deleteById()로 연결)
}