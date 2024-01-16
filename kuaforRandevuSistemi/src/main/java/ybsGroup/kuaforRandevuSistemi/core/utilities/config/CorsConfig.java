package ybsGroup.kuaforRandevuSistemi.core.utilities.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**") // Tüm yollar için
	                    .allowedOrigins("http://127.0.0.1:5500") // İzin verilen kökenler
	                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // İzin verilen metodlar
	                    .allowedHeaders("*") // İzin verilen başlıklar
	                    .allowCredentials(true);
	        }
	    };
	}
}
