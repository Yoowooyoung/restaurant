package com.example.restaurant.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 모든 Entity가 상속받는 기본 클래스 (공통 필드인 index를 가짐)
@NoArgsConstructor  // 기본 생성자 자동 생성
@AllArgsConstructor  // 모든 필드를 받는 생성자 자동 생성
@Data  // Getter/Setter/toString/equals/hashCode 자동 생성
public class MemoryDbEntity {
    protected Integer index;  // 모든 Entity의 ID (Primary Key 역할)
}