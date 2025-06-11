package com.side.springtestbed.transactional.propagation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 전파 속성 비교 컨트롤러
 * - Custom과 Spring @Transactional의 동작 비교
 * - 실시간으로 트랜잭션 상태 변화 확인
 */
@Slf4j
@RestController
@RequestMapping("/api/transaction/propagation")
public class PropagationComparisonController {
    
    @Autowired
    private PropagationDemoService customService;
    
    @Autowired
    private SpringTransactionalDemoService springService;
    
    @Autowired
    private PropagationAnalyzer customAnalyzer;
    
    @Autowired
    private SpringTransactionAnalyzer springAnalyzer;
    
    /**
     * Custom @Transactional REQUIRED 시나리오 실행
     */
    @PostMapping("/custom/required")
    public String executeCustomRequired() {
        log.info("\n" + "🔧".repeat(50));
        log.info("Custom @Transactional REQUIRED 시나리오 실행");
        log.info("🔧".repeat(50));
        
        try {
            customAnalyzer.clearSnapshots();
            customAnalyzer.captureSnapshot("API 호출 시작");
            
            customService.requiredScenario();
            
            customAnalyzer.captureSnapshot("API 호출 완료");
            customAnalyzer.generateAnalysisReport();
            customAnalyzer.validatePropagationPattern("REQUIRED");
            
            return "Custom REQUIRED 시나리오 실행 성공";
            
        } catch (Exception e) {
            log.error("Custom REQUIRED 시나리오 실행 실패", e);
            return "Custom REQUIRED 시나리오 실행 실패: " + e.getMessage();
        }
    }
    
    /**
     * Spring @Transactional REQUIRED 시나리오 실행
     */
    @PostMapping("/spring/required")
    public String executeSpringRequired() {
        log.info("\n" + "🌱".repeat(50));
        log.info("Spring @Transactional REQUIRED 시나리오 실행");
        log.info("🌱".repeat(50));
        
        try {
            springAnalyzer.clearSnapshots();
            springAnalyzer.captureSnapshot("API 호출 시작");
            
            springService.requiredScenario();
            
            springAnalyzer.captureSnapshot("API 호출 완료");
            springAnalyzer.generateSpringAnalysisReport();
            springAnalyzer.validateSpringPropagationPattern("REQUIRED");
            
            return "Spring REQUIRED 시나리오 실행 성공";
            
        } catch (Exception e) {
            log.error("Spring REQUIRED 시나리오 실행 실패", e);
            return "Spring REQUIRED 시나리오 실행 실패: " + e.getMessage();
        }
    }
    
    /**
     * Custom @Transactional REQUIRES_NEW 시나리오 실행
     */
    @PostMapping("/custom/requires-new")
    public String executeCustomRequiresNew() {
        log.info("\n" + "🔧".repeat(50));
        log.info("Custom @Transactional REQUIRES_NEW 시나리오 실행");
        log.info("🔧".repeat(50));
        
        try {
            customAnalyzer.clearSnapshots();
            customAnalyzer.captureSnapshot("API 호출 시작");
            
            customService.requiresNewScenario();
            
            customAnalyzer.captureSnapshot("API 호출 완료");
            customAnalyzer.generateAnalysisReport();
            customAnalyzer.validatePropagationPattern("REQUIRES_NEW");
            
            return "Custom REQUIRES_NEW 시나리오 실행 성공";
            
        } catch (Exception e) {
            log.error("Custom REQUIRES_NEW 시나리오 실행 실패", e);
            return "Custom REQUIRES_NEW 시나리오 실행 실패: " + e.getMessage();
        }
    }
    
    /**
     * Spring @Transactional REQUIRES_NEW 시나리오 실행
     */
    @PostMapping("/spring/requires-new")
    public String executeSpringRequiresNew() {
        log.info("\n" + "🌱".repeat(50));
        log.info("Spring @Transactional REQUIRES_NEW 시나리오 실행");
        log.info("🌱".repeat(50));
        
        try {
            springAnalyzer.clearSnapshots();
            springAnalyzer.captureSnapshot("API 호출 시작");
            
            springService.requiresNewScenario();
            
            springAnalyzer.captureSnapshot("API 호출 완료");
            springAnalyzer.generateSpringAnalysisReport();
            springAnalyzer.validateSpringPropagationPattern("REQUIRES_NEW");
            
            return "Spring REQUIRES_NEW 시나리오 실행 성공";
            
        } catch (Exception e) {
            log.error("Spring REQUIRES_NEW 시나리오 실행 실패", e);
            return "Spring REQUIRES_NEW 시나리오 실행 실패: " + e.getMessage();
        }
    }
    
    /**
     * Custom과 Spring 비교 실행
     */
    @PostMapping("/compare/all")
    public String executeComparison() {
        log.info("\n" + "⚔️".repeat(50));
        log.info("Custom vs Spring @Transactional 비교 실행");
        log.info("⚔️".repeat(50));
        
        StringBuilder result = new StringBuilder();
        
        try {
            // 1. Custom REQUIRED
            log.info("\n=== Custom REQUIRED 실행 ===");
            customAnalyzer.clearSnapshots();
            customService.requiredScenario();
            customAnalyzer.generateAnalysisReport();
            result.append("✅ Custom REQUIRED 성공\n");
            
            // 2. Spring REQUIRED  
            log.info("\n=== Spring REQUIRED 실행 ===");
            springAnalyzer.clearSnapshots();
            springService.requiredScenario();
            springAnalyzer.generateSpringAnalysisReport();
            result.append("✅ Spring REQUIRED 성공\n");
            
            // 3. Custom REQUIRES_NEW
            log.info("\n=== Custom REQUIRES_NEW 실행 ===");
            customAnalyzer.clearSnapshots();
            customService.requiresNewScenario();
            customAnalyzer.generateAnalysisReport();
            result.append("✅ Custom REQUIRES_NEW 성공\n");
            
            // 4. Spring REQUIRES_NEW
            log.info("\n=== Spring REQUIRES_NEW 실행 ===");
            springAnalyzer.clearSnapshots();
            springService.requiresNewScenario();
            springAnalyzer.generateSpringAnalysisReport();
            result.append("✅ Spring REQUIRES_NEW 성공\n");
            
            result.append("\n📊 모든 비교 테스트 완료! 로그를 확인하세요.");
            
            return result.toString();
            
        } catch (Exception e) {
            log.error("비교 실행 중 오류 발생", e);
            return "❌ 비교 실행 실패: " + e.getMessage();
        }
    }
    
    /**
     * 예외 시나리오 비교
     */
    @PostMapping("/compare/exception")
    public String executeExceptionComparison() {
        log.info("\n" + "💥".repeat(50));
        log.info("예외 시나리오 비교 실행");
        log.info("💥".repeat(50));
        
        StringBuilder result = new StringBuilder();
        
        try {
            // 1. Custom REQUIRES_NEW 예외 시나리오
            log.info("\n=== Custom REQUIRES_NEW 예외 시나리오 ===");
            customAnalyzer.clearSnapshots();
            customService.requiresNewWithExceptionScenario();
            customAnalyzer.generateAnalysisReport();
            result.append("✅ Custom REQUIRES_NEW 예외 처리 성공\n");
            
        } catch (Exception e) {
            result.append("❌ Custom REQUIRES_NEW 예외 처리 실패: ").append(e.getMessage()).append("\n");
        }
        
        try {
            // 2. Spring REQUIRES_NEW 예외 시나리오
            log.info("\n=== Spring REQUIRES_NEW 예외 시나리오 ===");
            springAnalyzer.clearSnapshots();
            springService.requiresNewWithExceptionScenario();
            springAnalyzer.generateSpringAnalysisReport();
            result.append("✅ Spring REQUIRES_NEW 예외 처리 성공\n");
            
        } catch (Exception e) {
            result.append("❌ Spring REQUIRES_NEW 예외 처리 실패: ").append(e.getMessage()).append("\n");
        }
        
        result.append("\n💥 예외 시나리오 비교 완료!");
        return result.toString();
    }
    
    /**
     * 복잡한 중첩 시나리오 비교
     */
    @PostMapping("/compare/complex")
    public String executeComplexComparison() {
        log.info("\n" + "🏗️".repeat(50));
        log.info("복잡한 중첩 시나리오 비교 실행");
        log.info("🏗️".repeat(50));
        
        StringBuilder result = new StringBuilder();
        
        try {
            // 1. Custom 복잡한 중첩
            log.info("\n=== Custom 복잡한 중첩 시나리오 ===");
            customAnalyzer.clearSnapshots();
            customService.complexNestedScenario();
            customAnalyzer.generateAnalysisReport();
            result.append("✅ Custom 복잡한 중첩 성공 (스냅샷: ")
                  .append(customAnalyzer.getSnapshotCount()).append("개)\n");
            
            // 2. Spring 복잡한 중첩
            log.info("\n=== Spring 복잡한 중첩 시나리오 ===");
            springAnalyzer.clearSnapshots();
            springService.complexNestedScenario();
            springAnalyzer.generateSpringAnalysisReport();
            result.append("✅ Spring 복잡한 중첩 성공 (스냅샷: ")
                  .append(springAnalyzer.getSnapshotCount()).append("개)\n");
            
            result.append("\n🏗️ 복잡한 중첩 시나리오 비교 완료!");
            
        } catch (Exception e) {
            log.error("복잡한 중첩 시나리오 비교 실패", e);
            result.append("❌ 복잡한 중첩 시나리오 비교 실패: ").append(e.getMessage());
        }
        
        return result.toString();
    }
    
    /**
     * 분석기 상태 초기화
     */
    @DeleteMapping("/clear")
    public String clearAnalyzers() {
        customAnalyzer.clearSnapshots();
        springAnalyzer.clearSnapshots();
        
        log.info("🧹 모든 분석기 상태 초기화 완료");
        return "모든 분석기 상태가 초기화되었습니다.";
    }
    
    /**
     * 현재 분석기 상태 조회
     */
    @GetMapping("/status")
    public String getAnalyzerStatus() {
        StringBuilder status = new StringBuilder();
        status.append("📊 분석기 상태\n");
        status.append("Custom 분석기 스냅샷: ").append(customAnalyzer.getSnapshotCount()).append("개\n");
        status.append("Spring 분석기 스냅샷: ").append(springAnalyzer.getSnapshotCount()).append("개\n");
        
        return status.toString();
    }
}
