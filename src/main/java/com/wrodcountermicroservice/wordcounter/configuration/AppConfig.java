package com.wrodcountermicroservice.wordcounter.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wrodcountermicroservice.wordcounter.domain.Translator;

@Configuration
public class AppConfig {

    @Bean
    public Translator thirdPartyTranslator() {
        return new Translator();
    }
}
