package br.dev.marcoalmeida.fileaxemongo.config.database.mongo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ConfigurationProperties("spring.data.mongodb.properties")
@Lazy
@Getter
@Setter
@ToString
@NoArgsConstructor
public class MongoDbProperties {
    private int connectionTimeout;
    private int minimumIdle;
    private int maximumPoolSize;
    private int idleTimeout;
    private int maxLifeTime;
}
