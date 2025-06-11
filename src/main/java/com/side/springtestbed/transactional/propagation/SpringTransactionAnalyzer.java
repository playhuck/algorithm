package com.side.springtestbed.transactional.propagation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Spring 트랜잭션 분석기
 * - Spring의 TransactionSynchronizationManager를 사용한 분석
 * - 실제 Spring 트랜잭션의 동작을 추적하고 분석
 */
@Slf4j
@Component
public class SpringTransactionAnalyzer {
    
    /**
     * Spring 트랜잭션 상태 스냅샷
     */
    public static class SpringTransactionSnapshot {
        public final long timestamp;
        public final String threadName;
        public final long threadId;
        public final boolean isActualTransactionActive;
        public final boolean isSynchronizationActive;
        public final String transactionName;
        public final boolean isReadOnly;
        public final Integer isolationLevel;
        public final int synchronizationCount;
        public final String location;
        public final Map<String, Object> resourceMap;
        
        public SpringTransactionSnapshot(String location) {
            this.timestamp = System.currentTimeMillis();
            Thread currentThread = Thread.currentThread();
            this.threadName = currentThread.getName();
            this.threadId = currentThread.getId();
            this.isActualTransactionActive = TransactionSynchronizationManager.isActualTransactionActive();
            this.isSynchronizationActive = TransactionSynchronizationManager.isSynchronizationActive();
            this.transactionName = TransactionSynchronizationManager.getCurrentTransactionName();
            this.isReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
            this.isolationLevel = TransactionSynchronizationManager.getCurrentTransactionIsolationLevel();
            this.synchronizationCount = isSynchronizationActive ? 
                TransactionSynchronizationManager.getSynchronizations().size() : 0;
            this.location = location;
            this.resourceMap = new ConcurrentHashMap<>(TransactionSynchronizationManager.getResourceMap());
        }
        
        @Override
        public String toString() {
            return String.format(
                "[%s] Thread[%d:%s] Active[%s] Sync[%s] Name[%s]",
                location, threadId, threadName, isActualTransactionActive, 
                isSynchronizationActive, transactionName != null ? transactionName : "null"
            );
        }
    }
    
    private final List<SpringTransactionSnapshot> snapshots = new ArrayList<>();
    
    /**
     * 현재 Spring 트랜잭션 상태 캡처
     */
    public SpringTransactionSnapshot captureSnapshot(String location) {
        SpringTransactionSnapshot snapshot = new SpringTransactionSnapshot(location);
        snapshots.add(snapshot);
        
        log.info("[Spring 스냅샷 캡처] {}", snapshot);
        return snapshot;
    }
    
    /**
     * Spring 트랜잭션 분석 리포트 생성
     */
    public void generateSpringAnalysisReport() {
        log.info("\n" + "=".repeat(100));
        log.info("Spring 트랜잭션 전파 분석 리포트");
        log.info("=".repeat(100));
        
        if (snapshots.isEmpty()) {
            log.info("분석할 스냅샷이 없습니다.");
            return;
        }
        
        // 1. 기본 통계
        generateSpringBasicStatistics();
        
        // 2. 트랜잭션 활성화 패턴 분석
        analyzeTransactionActivationPattern();
        
        // 3. 동기화 상태 분석
        analyzeSynchronizationPattern();
        
        // 4. 리소스 바인딩 분석
        analyzeResourceBinding();
        
        // 5. 시간순 상세 분석
        generateSpringTimelineAnalysis();
        
        log.info("=".repeat(100));
    }
    
    /**
     * Spring 트랜잭션 기본 통계
     */
    private void generateSpringBasicStatistics() {
        log.info("\n[1. Spring 트랜잭션 기본 통계]");
        log.info("총 스냅샷 수: {}", snapshots.size());
        
        long totalExecutionTime = snapshots.isEmpty() ? 0 : 
            snapshots.get(snapshots.size() - 1).timestamp - snapshots.get(0).timestamp;
        log.info("총 실행 시간: {}ms", totalExecutionTime);
        
        long activeTransactionCount = snapshots.stream()
            .mapToLong(s -> s.isActualTransactionActive ? 1 : 0)
            .sum();
        log.info("활성 트랜잭션 스냅샷: {}/{}", activeTransactionCount, snapshots.size());
        
        long synchronizationActiveCount = snapshots.stream()
            .mapToLong(s -> s.isSynchronizationActive ? 1 : 0)
            .sum();
        log.info("동기화 활성 스냅샷: {}/{}", synchronizationActiveCount, snapshots.size());
        
        // 사용된 트랜잭션 이름들
        snapshots.stream()
            .map(s -> s.transactionName)
            .filter(name -> name != null)
            .distinct()
            .forEach(name -> log.info("사용된 트랜잭션 이름: {}", name));
    }
    
    /**
     * 트랜잭션 활성화 패턴 분석
     */
    private void analyzeTransactionActivationPattern() {
        log.info("\n[2. 트랜잭션 활성화 패턴 분석]");
        
        for (int i = 0; i < snapshots.size(); i++) {
            SpringTransactionSnapshot snapshot = snapshots.get(i);
            String pattern = "";
            
            if (i > 0) {
                SpringTransactionSnapshot prev = snapshots.get(i - 1);
                
                if (!prev.isActualTransactionActive && snapshot.isActualTransactionActive) {
                    pattern = " 🟢 트랜잭션 시작";
                } else if (prev.isActualTransactionActive && !snapshot.isActualTransactionActive) {
                    pattern = " 🔴 트랜잭션 종료";
                } else if (snapshot.isActualTransactionActive) {
                    pattern = " 🟡 트랜잭션 진행중";
                } else {
                    pattern = " ⚪ 트랜잭션 없음";
                }
            }
            
            log.info("{}. [{}] 상태: {}{}", 
                i + 1, snapshot.location, 
                snapshot.isActualTransactionActive ? "ACTIVE" : "INACTIVE", pattern);
        }
    }
    
    /**
     * 동기화 상태 분석
     */
    private void analyzeSynchronizationPattern() {
        log.info("\n[3. 동기화 상태 분석]");
        
        for (SpringTransactionSnapshot snapshot : snapshots) {
            log.info("[{}] 동기화: {}, 동기화 객체 수: {}", 
                snapshot.location, 
                snapshot.isSynchronizationActive ? "활성" : "비활성",
                snapshot.synchronizationCount);
        }
    }
    
    /**
     * 리소스 바인딩 분석
     */
    private void analyzeResourceBinding() {
        log.info("\n[4. 리소스 바인딩 분석]");
        
        for (SpringTransactionSnapshot snapshot : snapshots) {
            log.info("[{}] 바인딩된 리소스 수: {}", 
                snapshot.location, snapshot.resourceMap.size());
            
            if (!snapshot.resourceMap.isEmpty()) {
                snapshot.resourceMap.forEach((key, value) -> {
                    log.info("  - {}: {}", 
                        key.getClass().getSimpleName(), 
                        value.getClass().getSimpleName());
                });
            }
        }
    }
    
    /**
     * 시간순 상세 분석
     */
    private void generateSpringTimelineAnalysis() {
        log.info("\n[5. Spring 트랜잭션 시간순 상세 분석]");
        
        long baseTime = snapshots.isEmpty() ? 0 : snapshots.get(0).timestamp;
        
        for (int i = 0; i < snapshots.size(); i++) {
            SpringTransactionSnapshot snapshot = snapshots.get(i);
            long relativeTime = snapshot.timestamp - baseTime;
            
            log.info("\n시점 {}: +{}ms", i + 1, relativeTime);
            log.info("  위치: {}", snapshot.location);
            log.info("  스레드: {}[{}]", snapshot.threadName, snapshot.threadId);
            log.info("  활성 트랜잭션: {}", snapshot.isActualTransactionActive);
            log.info("  동기화 활성: {}", snapshot.isSynchronizationActive);
            log.info("  트랜잭션 이름: {}", snapshot.transactionName != null ? snapshot.transactionName : "없음");
            log.info("  읽기 전용: {}", snapshot.isReadOnly);
            log.info("  격리 수준: {}", snapshot.isolationLevel != null ? 
                getIsolationLevelName(snapshot.isolationLevel) : "기본값");
            log.info("  동기화 객체 수: {}", snapshot.synchronizationCount);
            log.info("  바인딩된 리소스 수: {}", snapshot.resourceMap.size());
        }
    }
    
    /**
     * Spring 전파 정책 패턴 검증
     */
    public void validateSpringPropagationPattern(String propagationType) {
        log.info("\n[Spring 전파 정책 패턴 검증: {}]", propagationType);
        
        switch (propagationType.toUpperCase()) {
            case "REQUIRED":
                validateSpringRequiredPattern();
                break;
            case "REQUIRES_NEW":
                validateSpringRequiresNewPattern();
                break;
            case "NESTED":
                validateSpringNestedPattern();
                break;
            case "NOT_SUPPORTED":
                validateSpringNotSupportedPattern();
                break;
            case "NEVER":
                validateSpringNeverPattern();
                break;
            default:
                log.warn("알 수 없는 전파 정책: {}", propagationType);
        }
    }
    
    private void validateSpringRequiredPattern() {
        boolean hasActiveTransactions = snapshots.stream()
            .anyMatch(s -> s.isActualTransactionActive);
        
        if (hasActiveTransactions) {
            log.info("✅ REQUIRED 패턴 검증 성공: 트랜잭션이 활성화됨");
        } else {
            log.error("❌ REQUIRED 패턴 검증 실패: 활성 트랜잭션이 감지되지 않음");
        }
    }
    
    private void validateSpringRequiresNewPattern() {
        long uniqueTransactionNames = snapshots.stream()
            .map(s -> s.transactionName)
            .filter(name -> name != null)
            .distinct()
            .count();
        
        if (uniqueTransactionNames > 1) {
            log.info("✅ REQUIRES_NEW 패턴 검증 성공: 여러 트랜잭션이 감지됨 ({}개)", uniqueTransactionNames);
        } else {
            log.warn("⚠️ REQUIRES_NEW 패턴 주의: 단일 트랜잭션만 감지됨");
        }
    }
    
    private void validateSpringNestedPattern() {
        validateSpringRequiredPattern();
    }
    
    private void validateSpringNotSupportedPattern() {
        boolean hasSynchronizationChanges = false;
        for (int i = 1; i < snapshots.size(); i++) {
            if (snapshots.get(i - 1).isSynchronizationActive != snapshots.get(i).isSynchronizationActive) {
                hasSynchronizationChanges = true;
                break;
            }
        }
        
        if (hasSynchronizationChanges) {
            log.info("✅ NOT_SUPPORTED 패턴 검증 성공: 동기화 상태 변화 감지됨");
        } else {
            log.warn("⚠️ NOT_SUPPORTED 패턴 주의: 동기화 상태 변화가 감지되지 않음");
        }
    }
    
    private void validateSpringNeverPattern() {
        boolean hasActiveTransaction = snapshots.stream()
            .anyMatch(s -> s.isActualTransactionActive);
        
        if (!hasActiveTransaction) {
            log.info("✅ NEVER 패턴 검증 성공: 활성 트랜잭션이 없음");
        } else {
            log.error("❌ NEVER 패턴 검증 실패: 활성 트랜잭션이 감지됨 (예외가 발생해야 함)");
        }
    }
    
    private String getIsolationLevelName(int isolationLevel) {
        switch (isolationLevel) {
            case java.sql.Connection.TRANSACTION_NONE:
                return "NONE";
            case java.sql.Connection.TRANSACTION_READ_UNCOMMITTED:
                return "READ_UNCOMMITTED";
            case java.sql.Connection.TRANSACTION_READ_COMMITTED:
                return "READ_COMMITTED";
            case java.sql.Connection.TRANSACTION_REPEATABLE_READ:
                return "REPEATABLE_READ";
            case java.sql.Connection.TRANSACTION_SERIALIZABLE:
                return "SERIALIZABLE";
            default:
                return "UNKNOWN(" + isolationLevel + ")";
        }
    }
    
    /**
     * 스냅샷 초기화
     */
    public void clearSnapshots() {
        snapshots.clear();
        log.info("[Spring 스냅샷 초기화] 모든 스냅샷이 삭제되었습니다.");
    }
    
    /**
     * 현재 저장된 스냅샷 개수 반환
     */
    public int getSnapshotCount() {
        return snapshots.size();
    }
}
