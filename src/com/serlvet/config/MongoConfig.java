package com.serlvet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

public class MongoConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        // TODO Auto-generated method stub
        return "serlvet";
    }

    @Override
    public Mongo mongo() throws Exception {
        // TODO Auto-generated method stub
        return new MongoClient("10.5.161.137");
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), getDatabaseName());
    }
}
