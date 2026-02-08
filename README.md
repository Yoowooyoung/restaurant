# 🍽️ 맛집 WISH LIST 프로젝트 - 완전 학습 패키지

## 📦 패키지 구성

이 패키지는 Spring Boot 기반 맛집 검색/위시리스트 관리 프로젝트의 **완전한 학습 자료**를 제공합니다.

---

## 📚 문서 구성 (5개)

### 📘 필수 학습 문서

#### 1. **README.md** (본 파일)
- 프로젝트 전체 개요
- 빠른 시작 가이드
- 파일 구조 설명
- 핵심 기능 요약

#### 2. **01_전체_기능_목록.md** (12KB)
```
✓ 프로젝트의 7가지 주요 기능 상세 설명
✓ 각 기능의 API 엔드포인트
✓ 기능별 사용 시나리오
✓ 기능 간 의존 관계 다이어그램
✓ 향후 확장 가능 기능 제안
```

**학습 목표:**
- 프로젝트가 무엇을 하는지 파악
- REST API 구조 이해
- 사용자 시나리오 학습

---

#### 3. **02_상세_실행_과정.md** (47KB) ⭐ **핵심 문서**
```
✓ 엔티티 생성 과정 (Spring Boot 시작부터)
✓ CREATE 상세 과정 (파일→메서드→코드 라인 단위)
✓ READ 상세 과정 (전체 조회 + 개별 조회)
✓ UPDATE 상세 과정 (방문 기록 추가)
✓ DELETE 상세 과정 (위시리스트 삭제)
✓ HTTP 메서드별 실행 흐름 (GET/POST/DELETE)
✓ 전체 프로세스 흐름도
```

**학습 목표:**
- **요청사항 완벽 반영**: 각 CRUD 동작을 "A파일의 A코드 → B파일의 B로직" 방식으로 상세 설명
- 메모리 DB 상태 변화 추적
- 데이터 변환 과정 이해 (JSON → DTO → Entity)
- Spring MVC 실행 흐름 완전 파악

**예시 (CREATE 과정 중 일부):**
```
1단계: HTTP 요청 수신
  파일: ApiController.java
  메서드: add()
  코드: @PostMapping("") → wishListService.add(dto) 호출
  ↓
2단계: Service 레이어 - DTO → Entity 변환
  파일: WishListService.java
  메서드: add()
  코드: dtoToEntity(dto) → repository.save(entity) → entityToDto(saved)
  ↓
3단계: Repository 레이어 - 실제 저장
  파일: MemoryDbRepositoryAbstract.java
  메서드: save()
  코드: index++ → entity.setIndex(index) → db.add(entity)
  ...
```

---

#### 4. **00_Dependencies_가이드.md** (7.5KB)
```
✓ 프로젝트 의존성 전체 설명
✓ Spring Boot Starter Web/Thymeleaf/Lombok
✓ Maven/Gradle 설정 예시
✓ Lombok 어노테이션 완전 가이드
✓ IDE별 Lombok 설치 방법
```

**학습 목표:**
- 프로젝트가 사용하는 라이브러리 이해
- pom.xml / build.gradle 작성법 학습
- Lombok 동작 원리 파악

---

#### 5. **01_CRUD_동작_가이드.md** (11KB)
```
✓ CRUD 개념 설명
✓ HTTP 메서드별 역할 (GET/POST/PUT/DELETE)
✓ 각 CRUD의 코드 흐름 요약
✓ API 요청/응답 예시
✓ DTO vs Entity 차이
✓ JPA 전환 시 변경사항
```

**학습 목표:**
- REST API 설계 원칙 이해
- HTTP 메서드 선택 기준 학습
- 메모리 DB vs 실제 DB 차이 파악

---

#### 6. **02_Entity_생성_가이드.md** (8.8KB)
```
✓ Entity 계층 구조 (MemoryDbEntity → WishListEntity)
✓ Entity 생성 단계별 가이드
✓ 필드 타입 결정 방법
✓ Lombok 어노테이션 활용
✓ JPA Entity로 전환 방법
✓ Best Practices
```

**학습 목표:**
- Entity 설계 방법론
- Lombok을 활용한 코드 간소화
- 실제 DB 전환 준비

---

## 💻 Java 소스 코드 (11개)

### 🔷 애플리케이션 계층
- **RestaurantApplication.java** - Spring Boot 시작점

### 🔷 Controller 계층
- **PageController.java** - 웹 페이지 뷰 렌더링
- **ApiController.java** - REST API 엔드포인트

### 🔷 Service 계층
- **WishListService.java** - 비즈니스 로직 + DTO↔Entity 변환

### 🔷 Repository 계층
- **WishListRepository.java** - 위시리스트 저장소
- **MemoryDbRepositoryAbstract.java** - CRUD 구현체
- **MemoryDbRepositoryIfs.java** - Repository 인터페이스

### 🔷 Entity/DTO 계층
- **MemoryDbEntity.java** - Entity 부모 클래스
- **WishListEntity.java** - 위시리스트 엔티티
- **WishListDto.java** - 데이터 전송 객체

### 🔷 외부 API 연동
- **NaverClient.java** - 네이버 검색 API 클라이언트

**모든 Java 파일은 각 코드 라인마다 1~2줄 간단한 주석 포함**

---

## 🎯 권장 학습 순서

### 📖 초급 학습자 (Spring Boot 처음 접하는 경우)

```
1단계: README.md
  └─ 프로젝트 전체 파악

2단계: 00_Dependencies_가이드.md
  └─ 사용 기술 이해

3단계: RestaurantApplication.java
  └─ 시작점 확인

4단계: 01_전체_기능_목록.md
  └─ 어떤 기능이 있는지 파악

5단계: PageController.java → ApiController.java
  └─ REST API 구조 학습

6단계: 02_Entity_생성_가이드.md
  └─ Entity 개념 학습

7단계: WishListEntity.java → WishListDto.java
  └─ 데이터 모델 확인

8단계: WishListService.java
  └─ 비즈니스 로직 이해

9단계: 01_CRUD_동작_가이드.md
  └─ CRUD 흐름 요약 학습

10단계: 02_상세_실행_과정.md
  └─ 전체 프로세스 완전 이해
```

---

### 📖 중급 학습자 (Spring Boot 경험 있는 경우)

```
1단계: 01_전체_기능_목록.md
  └─ 프로젝트 기능 빠르게 파악

2단계: ApiController.java
  └─ REST API 엔드포인트 확인

3단계: 02_상세_실행_과정.md
  └─ CREATE/READ/UPDATE/DELETE 전체 흐름 학습
  └─ 각 단계별 파일/메서드/코드 추적

4단계: WishListService.java
  └─ 비즈니스 로직 + DTO↔Entity 변환 분석

5단계: MemoryDbRepositoryAbstract.java
  └─ CRUD 구현 로직 분석

6단계: NaverClient.java
  └─ 외부 API 연동 방법 학습
```

---

## 🔍 핵심 학습 포인트

### 1. Spring Boot MVC 패턴
```
Controller (요청 수신)
    ↓
Service (비즈니스 로직)
    ↓
Repository (데이터 저장)
    ↓
Memory DB (ArrayList)
```

### 2. REST API 설계
```
GET    /api/restaurant/search    → 검색
GET    /api/restaurant/all       → 전체 조회
POST   /api/restaurant           → 추가
POST   /api/restaurant/{index}   → 방문 기록
DELETE /api/restaurant/{index}   → 삭제
```

### 3. 데이터 변환 흐름
```
JSON (프런트엔드)
  ↓ @RequestBody
WishListDto (Controller)
  ↓ dtoToEntity()
WishListEntity (Service)
  ↓ save()
ArrayList (메모리 DB)
```

### 4. Lombok 활용
```java
@Data                   // Getter, Setter 자동 생성
@NoArgsConstructor      // 기본 생성자
@AllArgsConstructor     // 전체 생성자
@RequiredArgsConstructor // final 필드 생성자 (DI용)
@Slf4j                  // 로거 자동 생성
```

### 5. Optional 패턴
```java
Optional<Entity> result = repository.findById(index);
if (result.isPresent()) {
    Entity entity = result.get();
    // 엔티티 사용
}
```

---

## 🚀 실행 방법

### 1. 의존성 설치
```bash
./mvnw clean install
# 또는
./gradlew build
```

### 2. 애플리케이션 실행
```bash
./mvnw spring-boot:run
# 또는
./gradlew bootRun
```

### 3. 접속
- 메인 페이지: http://localhost:8080/pages/main
- API 테스트:
  ```bash
  # 전체 조회
  curl http://localhost:8080/api/restaurant/all
  
  # 검색
  curl "http://localhost:8080/api/restaurant/search?query=갈비집"
  ```

---

## 🐛 이미지 표시 이슈 해결

**문제:** 화면에 이미지가 안 뜨는 현상

**원인:** 네이버 이미지 API의 `link` 필드는 원본 이미지로, 외부 사이트의 핫링크 방지 정책으로 CORS 오류 발생

**해결 방법:** `WishListService.java` 48번 라인 수정
```java
// ❌ 기존 (원본 이미지)
result.setImageLink(imageItem.getLink());

// ✅ 수정 (썸네일 이미지)
result.setImageLink(imageItem.getThumbnail());
```

---

## 📊 프로젝트 통계

| 항목 | 수치 |
|-----|------|
| Java 파일 | 11개 |
| 학습 문서 | 5개 (총 86KB) |
| 주요 기능 | 7개 |
| REST API | 5개 |
| 코드 라인 | ~1,200줄 |

---

## 💡 향후 학습 방향

### 1단계: 메모리 DB → 실제 DB 전환
```java
// H2 Database 추가
implementation 'com.h2database:h2'
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'

// Entity에 JPA 어노테이션 추가
@Entity
@Table(name = "wish_list")
public class WishListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // ...
}
```

### 2단계: 테스트 코드 작성
```java
@SpringBootTest
class WishListServiceTest {
    @Autowired
    private WishListService service;
    
    @Test
    void testAdd() {
        // Given
        WishListDto dto = new WishListDto();
        dto.setTitle("테스트 맛집");
        
        // When
        WishListDto result = service.add(dto);
        
        // Then
        assertNotNull(result.getIndex());
    }
}
```

### 3단계: 예외 처리 추가
```java
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleNotFound(EntityNotFoundException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }
}
```

### 4단계: Swagger API 문서 자동 생성
```java
// build.gradle
implementation 'org.springdoc:springdoc-openapi-ui:1.7.0'

// 접속: http://localhost:8080/swagger-ui.html
```

---

## 🎓 추천 학습 자료

### Spring Boot 공식 문서
- https://spring.io/projects/spring-boot
- https://spring.io/guides

### Lombok
- https://projectlombok.org/features/

### REST API 설계
- https://restfulapi.net/

### JPA
- https://spring.io/projects/spring-data-jpa

---

## 📝 학습 체크리스트

### 기본 개념
- [ ] Spring Boot 프로젝트 구조 이해
- [ ] MVC 패턴 이해
- [ ] REST API 개념 이해
- [ ] HTTP 메서드 (GET/POST/DELETE) 차이 이해

### 코드 이해
- [ ] 애플리케이션 시작 과정 이해
- [ ] Controller 동작 방식 이해
- [ ] Service 레이어 역할 이해
- [ ] Repository 패턴 이해
- [ ] DTO vs Entity 차이 이해

### CRUD 흐름
- [ ] CREATE 전체 흐름 추적 가능
- [ ] READ 전체 흐름 추적 가능
- [ ] UPDATE 전체 흐름 추적 가능
- [ ] DELETE 전체 흐름 추적 가능

### 심화 학습
- [ ] Lombok 어노테이션 활용법 숙지
- [ ] Optional 패턴 이해
- [ ] Stream API 활용법 이해
- [ ] 의존성 주입 (DI) 개념 이해

---

## 🤝 학습 팁

### 1. 디버거 활용
IntelliJ IDEA에서 breakpoint 설정 후 단계별 실행:
```
ApiController.add() → F8 (한 줄씩 실행)
  → wishListService.add() → F7 (메서드 안으로)
  → repository.save() → F7
```

### 2. 로그 확인
`application.yaml`에 추가:
```yaml
logging:
  level:
    com.example.restaurant: DEBUG
```

### 3. Postman으로 API 테스트
```
GET http://localhost:8080/api/restaurant/all

POST http://localhost:8080/api/restaurant
Body: {
  "title": "테스트 맛집",
  "category": "음식점>한식",
  ...
}
