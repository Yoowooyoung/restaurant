package com.example.restaurant.db;

import java.util.List;
import java.util.Optional;

// Repository가 가져야 할 기본 기능을 정의한 인터페이스 (CRUD 메서드 명세)
public interface MemoryDbRepositoryIfs<T> {
    Optional<T> findById(int index);  // ID로 조회
    T save(T entity);  // 저장 (추가/수정)
    void deleteById(int index);  // ID로 삭제
    List<T> findAll();  // 전체 조회
}