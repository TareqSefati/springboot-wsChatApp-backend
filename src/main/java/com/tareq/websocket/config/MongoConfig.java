package com.tareq.websocket.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {
    @Value("${spring.data.mongodb.uri}")
    private String mongoDbConnectionString;

    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoDatabaseFactory());
    }

    @Bean
    public SimpleMongoClientDatabaseFactory mongoDatabaseFactory(){
        return new SimpleMongoClientDatabaseFactory(MongoClients.create(mongoDbConnectionString), "DbWSChatApp");
    }
}
