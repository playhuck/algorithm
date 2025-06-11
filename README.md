# Spring-Test-Bed

Spring의 다양한 궁금증을 해결하고 실험해보는 테스트베드 프로젝트입니다.

## 🎯 프로젝트 목표

Spring Framework의 핵심 기능들을 직접 구현해보고, 실제 동작 원리를 이해하는 것이 목표입니다.

## 📚 현재 구현된 기능

### 1. 커스텀 @Transactional 구현 (`customtransactional` 패키지)

Spring의 `@Transactional` 어노테이션의 내부 구현을 직접 만들어 동작 원리를 이해합니다.

#### 주요 구성 요소:
- **`@CustomTransactional`**: 커스텀 트랜잭션 어노테이션
- **`CustomTransactionManager`**: 트랜잭션 생성, 커밋, 롤백 담당
- **`CustomTransactionalInterceptor`**: AOP를 통한 트랜잭션 인터셉터
- **`CustomTransactionSynchronizationManager`**: ThreadLocal 기반 트랜잭션 동기화

#### 지원하는 전파 정책:
- `REQUIRED`: 기존 트랜잭션 참여 또는 새로 생성
- `REQUIRES_NEW`: 항상 새 트랜잭션 생성
- `NESTED`: Savepoint를 이용한 중첩 트랜잭션

### 2. 전파 속성 비교 분석 (`propagation` 패키지)

커스텀 구현과 Spring 기본 구현의 동작을 비교 분석합니다.

#### 주요 기능:
- **실시간 트랜잭션 상태 추적**: ThreadLocal 상태 변화 모니터링
- **전파 속성별 동작 분석**: 각 전파 정책의 실제 동작 방식 확인
- **성능 비교**: 커스텀 vs Spring 구현체 성능 측정
- **예외 시나리오**: 롤백 범위와 예외 전파 동작 분석

## 🚀 실행 방법

### 1. 애플리케이션 실행
```bash
./gradlew bootRun
```

### 2. H2 데이터베이스 콘솔 접속
- URL: http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (비어있음)

### 3. API 엔드포인트 테스트

#### 커스텀 트랜잭션 테스트:
```bash
# REQUIRED 전파 정책
curl -X POST http://localhost:8080/api/transaction/propagation/custom/required

# REQUIRES_NEW 전파 정책  
curl -X POST http://localhost:8080/api/transaction/propagation/custom/requires-new
```

#### Spring 트랜잭션 테스트:
```bash
# REQUIRED 전파 정책
curl -X POST http://localhost:8080/api/transaction/propagation/spring/required

# REQUIRES_NEW 전파 정책
curl -X POST http://localhost:8080/api/transaction/propagation/spring/requires-new
```

#### 비교 분석:
```bash
# 전체 비교
curl -X POST http://localhost:8080/api/transaction/propagation/compare/all

# 예외 시나리오 비교
curl -X POST http://localhost:8080/api/transaction/propagation/compare/exception

# 복잡한 중첩 시나리오 비교
curl -X POST http://localhost:8080/api/transaction/propagation/compare/complex
```

### 4. 단위 테스트 실행
```bash
# 커스텀 트랜잭션 테스트
./gradlew test --tests PropagationDemoServiceTest

# Spring 트랜잭션 테스트  
./gradlew test --tests SpringTransactionalDemoServiceTest
```

## 📊 분석 기능

### 1. 트랜잭션 상태 스냅샷
- ThreadLocal 상태 변화 추적
- 트랜잭션 스택 깊이 분석
- Connection 사용 패턴 분석

### 2. 실행 흐름 분석
- 메서드 호출 순서와 트랜잭션 생명주기
- AOP 프록시 동작 과정
- 예외 발생 시 롤백 범위

### 3. 성능 비교
- 커스텀 vs Spring 구현체 성능 측정
- 전파 정책별 오버헤드 분석
- Connection Pool 사용량 모니터링

## 🔍 로그 분석

애플리케이션 실행 시 상세한 로그를 통해 다음을 확인할 수 있습니다:

1. **트랜잭션 생명주기**: 시작 → 실행 → 커밋/롤백
2. **ThreadLocal 상태 변화**: 트랜잭션 정보 바인딩/해제
3. **AOP 인터셉터 동작**: 프록시를 통한 메서드 가로채기
4. **Connection 관리**: 획득, 설정, 반환 과정
5. **전파 정책 적용**: 각 전파 정책의 실제 동작

## 🛠️ 기술 스택

- **Java 21**
- **Spring Boot 3.5.0**
- **Spring AOP**: 트랜잭션 인터셉터 구현
- **H2 Database**: 테스트용 인메모리 데이터베이스
- **Lombok**: 코드 간소화
- **JUnit 5**: 단위 테스트

## 📁 프로젝트 구조

```
src/main/java/com/side/springtestbed/
├── transactional/
│   ├── customtransactional/          # 커스텀 @Transactional 구현
│   │   ├── annotation/               # 어노테이션 정의
│   │   ├── aop/                     # AOP 인터셉터
│   │   ├── config/                  # 설정 클래스
│   │   └── core/                    # 핵심 트랜잭션 로직
│   └── propagation/                 # 전파 속성 비교 분석
│       ├── PropagationDemoService.java           # 커스텀 구현 데모
│       ├── SpringTransactionalDemoService.java   # Spring 구현 데모
│       ├── PropagationAnalyzer.java              # 커스텀 분석기
│       ├── SpringTransactionAnalyzer.java        # Spring 분석기
│       └── PropagationComparisonController.java  # REST API
└── SpringTestBedApplication.java
```

## 🎓 학습 포인트

이 프로젝트를 통해 다음을 학습할 수 있습니다:

1. **Spring AOP 동작 원리**: 프록시 패턴과 인터셉터 구현
2. **ThreadLocal 활용**: 스레드별 독립적인 트랜잭션 컨텍스트 관리
3. **트랜잭션 전파 메커니즘**: 중첩 트랜잭션과 스택 구조
4. **JDBC Connection 관리**: autoCommit, 격리수준, Savepoint
5. **예외 처리 패턴**: 롤백 조건과 예외 전파

## 🔮 향후 계획

- [ ] JTA를 이용한 분산 트랜잭션 구현
- [ ] 트랜잭션 이벤트 리스너 구현
- [ ] 캐싱 메커니즘 분석
- [ ] Spring Security 내부 구현 분석
- [ ] Bean 생명주기와 의존성 주입 분석

## 🤝 기여하기

궁금한 Spring 기능이나 구현해보고 싶은 내용이 있다면 이슈를 등록해주세요!
