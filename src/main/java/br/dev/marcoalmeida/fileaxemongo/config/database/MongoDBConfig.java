package br.dev.marcoalmeida.fileaxemongo.config.database;

import java.util.concurrent.TimeUnit;

import br.dev.marcoalmeida.fileaxemongo.config.database.mongo.MongoDbProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.Block;
import com.mongodb.MongoClientSettings;
import com.mongodb.connection.ConnectionPoolSettings;
import com.mongodb.connection.ConnectionPoolSettings.Builder;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class MongoDBConfig {

	private MongoDbProperties properties;

	public MongoDBConfig(MongoDbProperties properties) {
		this.properties = properties;
	}

    @Bean
    public MongoClientSettings mongoSettings() {
    	log.info("Configurando pool do mongodb com as configurações: {}", properties);
    	return MongoClientSettings.builder().applyToConnectionPoolSettings(new Block<ConnectionPoolSettings.Builder>() {

			@Override
			public void apply(Builder builder) {
				builder
				.minSize(properties.getMinimumIdle())
				.maxSize(properties.getMaximumPoolSize())
                .maxConnectionLifeTime(properties.getMaxLifeTime(), TimeUnit.MILLISECONDS)
                .maxConnectionIdleTime(properties.getIdleTimeout(), TimeUnit.MILLISECONDS)
                .maxWaitTime(properties.getConnectionTimeout(), TimeUnit.MILLISECONDS)
                ;
			}

        }).build();
    }
}
