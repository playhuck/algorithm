package com.side.springtestbed.transactional.customtransactional.config;

import com.side.springtestbed.transactional.customtransactional.core.CustomTransactionManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.sql.DataSource;

/**
 * 커스텀 트랜잭션 설정
 * - 커스텀 트랜잭션 매니저 빈 등록
 * - AOP 설정 활성화
 */
@Slf4j
@Configuration
@EnableAspectJAutoProxy
public class CustomTransactionConfig {
    
    /**
     * 커스텀 트랜잭션 매니저 빈 등록
     * - DataSource를 주입받아 트랜잭션 매니저 생성
     */
    @Bean
    public CustomTransactionManager customTransactionManager(DataSource dataSource) {
        log.info("[커스텀 트랜잭션 설정] CustomTransactionManager 빈 생성");
        return new CustomTransactionManager(dataSource);
    }
}
