package hu.kalee.diplomacy.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Profile("local")
@Configuration
public class CorsConfig {
    private static final Logger LOG = LoggerFactory.getLogger(CorsConfig.class);
    private static final String HTTP_LOCALHOST_4200 = "http://localhost:3000";

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        LOG.info("CORS config is set");
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/regions").allowedOrigins(HTTP_LOCALHOST_4200);
                registry.addMapping("/nations").allowedOrigins(HTTP_LOCALHOST_4200);
                registry.addMapping("/units").allowedOrigins(HTTP_LOCALHOST_4200);
                registry.addMapping("/commands").allowedOrigins(HTTP_LOCALHOST_4200);
            }
        };
    }
}


