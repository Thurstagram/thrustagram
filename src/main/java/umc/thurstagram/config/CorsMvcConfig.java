package umc.thurstagram.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**") // 모든 경로에 대해서
                .allowedOrigins("http://localhost:3000"); // 프론트 서버로부터 오는 요청은 허용.
    }
}
