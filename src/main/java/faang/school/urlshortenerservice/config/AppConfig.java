package faang.school.urlshortenerservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;

@Configuration
public class AppConfig {

    @Value("${hash-properties.max-local-cache-capacity}")
    private int maxLocalCacheCapacity;

    @Bean
    public ArrayBlockingQueue<String> hashCache() {
        return new ArrayBlockingQueue<>(maxLocalCacheCapacity);
    }
}
