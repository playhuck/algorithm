package com.side.springtestbed.transactional.propagation;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Spring 기본 @Transactional 전파 속성 테스트
 * - 실제 Spring 트랜잭션 매니저를 사용한 동작 검증
 * - TransactionSynchronizationManager를 통한 상태 분석
 */
@Slf4j
@SpringBootTest
class SpringTransactionalDemoServiceTest {
    
    @Autowired
    private SpringTransactionalDemoService springTransactionalDemoService;
    
    @Autowired
    private SpringTransactionAnalyzer springAnalyzer;
    
    @BeforeEach
    void setUp() {
        springAnalyzer.clearSnapshots();
        
        log.info("\n" + "🌱".repeat(50));
        log.info("Spring 트랜잭션 테스트 시작: {}", getCurrentTestName());
        log.info("🌱".repeat(50));
        
        // 테스트 시작 전 상태 확인
        assertFalse(TransactionSynchronizationManager.isActualTransactionActive(), 
            "테스트 시작 전에는 활성 트랜잭션이 없어야 함");
    }
    
    @AfterEach
    void tearDown() {
        // Spring 분석 리포트 생성
        springAnalyzer.generateSpringAnalysisReport();
        
        // 테스트 종료 후 트랜잭션 상태 확인
        assertFalse(TransactionSynchronizationManager.isActualTransactionActive(), 
            "테스트 완료 후에는 모든 트랜잭션이 정리되어야 함");
        
        log.info("\n" + "✅".repeat(50));
        log.info("Spring 트랜잭션 테스트 완료: {}", getCurrentTestName());
        log.info("✅".repeat(50));
    }
    
    /**
     * Spring REQUIRED 전파 정책 테스트
     */
    @Test
    void testSpringRequiredPropagation() {
        log.info("\n[Spring 테스트] REQUIRED 전파 정책 동작 확인");
        
        springAnalyzer.captureSnapshot("테스트 시작 전");
        
        assertDoesNotThrow(() -> {
            springTransactionalDemoService.requiredScenario();
        }, "REQUIRED 시나리오는 예외 없이 실행되어야 함");
        
        springAnalyzer.captureSnapshot("테스트 완료 후");
        springAnalyzer.validateSpringPropagationPattern("REQUIRED");
        
        log.info("[테스트 결과] Spring REQUIRED 전파 정책 테스트 성공");
    }
    
    /**
     * Spring REQUIRES_NEW 전파 정책 테스트
     */
    @Test
    void testSpringRequiresNewPropagation() {
        log.info("\n[Spring 테스트] REQUIRES_NEW 전파 정책 동작 확인");
        
        springAnalyzer.captureSnapshot("테스트 시작 전");
        
        assertDoesNotThrow(() -> {
            springTransactionalDemoService.requiresNewScenario();
        }, "REQUIRES_NEW 시나리오는 예외 없이 실행되어야 함");
        
        springAnalyzer.captureSnapshot("테스트 완료 후");
        springAnalyzer.validateSpringPropagationPattern("REQUIRES_NEW");
        
        log.info("[테스트 결과] Spring REQUIRES_NEW 전파 정책 테스트 성공");
    }
    
    /**
     * Spring NESTED 전파 정책 테스트
     */
    @Test
    void testSpringNestedPropagation() {
        log.info("\n[Spring 테스트] NESTED 전파 정책 동작 확인");
        
        springAnalyzer.captureSnapshot("테스트 시작 전");
        
        assertDoesNotThrow(() -> {
            springTransactionalDemoService.nestedScenario();
        }, "NESTED 시나리오는 예외 없이 실행되어야 함");
        
        springAnalyzer.captureSnapshot("테스트 완료 후");
        springAnalyzer.validateSpringPropagationPattern("NESTED");
        
        log.info("[테스트 결과] Spring NESTED 전파 정책 테스트 성공");
    }
    
    /**
     * Spring REQUIRES_NEW에서 예외 발생 시나리오 테스트
     */
    @Test
    void testSpringRequiresNewWithException() {
        log.info("\n[Spring 테스트] REQUIRES_NEW 예외 처리 시나리오");
        
        springAnalyzer.captureSnapshot("예외 테스트 시작 전");
        
        assertDoesNotThrow(() -> {
            springTransactionalDemoService.requiresNewWithExceptionScenario();
        }, "REQUIRES_NEW 예외 시나리오에서 외부 트랜잭션은 성공해야 함");
        
        springAnalyzer.captureSnapshot("예외 테스트 완료 후");
        springAnalyzer.validateSpringPropagationPattern("REQUIRES_NEW");
        
        log.info("[테스트 결과] Spring REQUIRES_NEW 예외 처리 테스트 성공");
    }
    
    /**
     * Spring REQUIRED에서 예외 발생 시나리오 테스트
     */
    @Test
    void testSpringRequiredWithException() {
        log.info("\n[Spring 테스트] REQUIRED 예외 처리 시나리오");
        
        springAnalyzer.captureSnapshot("REQUIRED 예외 테스트 시작 전");
        
        assertThrows(RuntimeException.class, () -> {
            springTransactionalDemoService.requiredWithExceptionScenario();
        }, "REQUIRED에서 예외 발생 시 외부로 예외가 전파되어야 함");
        
        springAnalyzer.captureSnapshot("REQUIRED 예외 테스트 완료 후");
        
        log.info("[테스트 결과] Spring REQUIRED 예외 처리 테스트 성공");
    }
    
    /**
     * Spring 복잡한 중첩 시나리오 테스트
     */
    @Test
    void testSpringComplexNestedScenario() {
        log.info("\n[Spring 테스트] 복잡한 중첩 시나리오 (3단계)");
        
        springAnalyzer.captureSnapshot("복잡한 중첩 테스트 시작 전");
        
        assertDoesNotThrow(() -> {
            springTransactionalDemoService.complexNestedScenario();
        }, "복잡한 중첩 시나리오는 예외 없이 실행되어야 함");
        
        springAnalyzer.captureSnapshot("복잡한 중첩 테스트 완료 후");
        
        assertTrue(springAnalyzer.getSnapshotCount() > 2, 
            "복잡한 시나리오에서는 상태 변화가 있어야 함");
        
        log.info("[테스트 결과] Spring 복잡한 중첩 시나리오 테스트 성공");
    }
    
    /**
     * Spring 혼합 전파 정책 테스트
     */
    @Test
    void testSpringMixedPropagationScenario() {
        log.info("\n[Spring 테스트] 혼합 전파 정책 시나리오");
        
        springAnalyzer.captureSnapshot("혼합 전파 테스트 시작 전");
        
        assertDoesNotThrow(() -> {
            springTransactionalDemoService.mixedPropagationScenario();
        }, "혼합 전파 정책 시나리오는 예외 없이 실행되어야 함");
        
        springAnalyzer.captureSnapshot("혼합 전파 테스트 완료 후");
        
        log.info("[테스트 결과] Spring 혼합 전파 정책 테스트 성공");
    }
    
    /**
     * Spring NEVER 전파 정책 테스트
     */
    @Test
    void testSpringNeverPropagationException() {
        log.info("\n[Spring 테스트] NEVER 전파 정책 예외 시나리오");
        
        springAnalyzer.captureSnapshot("NEVER 예외 테스트 시작 전");
        
        assertDoesNotThrow(() -> {
            springTransactionalDemoService.neverMethod();
        }, "트랜잭션이 없는 상태에서 NEVER는 성공해야 함");
        
        springAnalyzer.captureSnapshot("NEVER 단독 실행 후");
        springAnalyzer.validateSpringPropagationPattern("NEVER");
        
        log.info("[테스트 결과] Spring NEVER 전파 정책 테스트 성공");
    }
    
    /**
     * 현재 테스트 메서드 이름 획득
     */
    private String getCurrentTestName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}
