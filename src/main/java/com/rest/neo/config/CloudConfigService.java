package com.rest.neo.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
@RefreshScope
public class CloudConfigService {

    @Value("${const.profile}")
    private String profile;

    @Value("${const.test-key}")
    private String testKey;

    @Bean
    public void profileConfig() {
        this.getConfig();
    }

    public Map<String, Object> getConfig() {
        Map<String, Object> configMap = new HashMap<>();
        log.info("==> config-info: profile={}, testKey={}", profile, testKey);

        configMap.put("profile", profile);
        configMap.put("testKey", testKey);

        return configMap;
    }

}

