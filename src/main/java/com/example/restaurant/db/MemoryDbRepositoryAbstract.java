package com.example.restaurant.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// 메모리에 데이터를 저장하는 Repository 구현체 (실제 CRUD 로직이 있음)
abstract public class MemoryDbRepositoryAbstract<T extends MemoryDbEntity> implements MemoryDbRepositoryIfs<T> {

    private final List<T> db = new ArrayList<>();  // 데이터를 저장하는 리스트 (메모리 DB 역할)
    private int index = 0;  // 자동 증가 ID (1, 2, 3, ...)

    // ID로 데이터 찾기 (예: index=1인 데이터 찾기)
    @Override
    public Optional<T> findById(int index) {
        return db.stream().filter(it -> it.getIndex() == index).findFirst();  // 리스트에서 index가 일치하는 요소 찾기
    }

    // 데이터 저장 (없으면 추가, 있으면 수정)
    @Override
    public T save(T entity) {
        var optionalEntity = db.stream().filter(it -> it.getIndex() == entity.getIndex()).findFirst();

        if(optionalEntity.isEmpty()){
            // 새로운 데이터 추가 (INSERT)
            index++;  // ID 자동 증가
            entity.setIndex(index);
            db.add(entity);  // 리스트에 추가
            return entity;

        }else{
            // 기존 데이터 수정 (UPDATE)
            var preIndex = optionalEntity.get().getIndex();
            entity.setIndex(preIndex);
            deleteById(preIndex);  // 기존 데이터 삭제
            db.add(entity);  // 새 데이터 추가
            return entity;
        }
    }

    // ID로 데이터 삭제 (예: index=1인 데이터 삭제)
    @Override
    public void deleteById(int index) {
        var optionalEntity = db.stream().filter(it -> it.getIndex() == index).findFirst();
        if(optionalEntity.isPresent()){
            db.remove(optionalEntity.get());  // 리스트에서 제거
        }
    }

    // 전체 데이터 조회 (리스트 전체 반환)
    @Override
    public List<T> findAll() {
        return db;
    }
}