package com.serlvet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;

@Configuration
@EnableMongoRepositories(basePackages = "com.serlvet.db.mongo.repository")
@ComponentScan(basePackages = { "com.serlvet.db.mongo" })
public class MongoConfig extends AbstractMongoConfiguration {
    @Autowired
    private ApplicationContext appContext;

    @Override
    protected String getDatabaseName() {
        return "serlvet";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("10.5.161.5", new MongoClientOptions.Builder().connectTimeout(60000).build());
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoDbFactory factory = mongoDbFactory();

        // MongoMappingContext mongoMappingContext = new MongoMappingContext();
        // mongoMappingContext.setApplicationContext(appContext);

        // remoce `_class`
        MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(factory),
                mongoMappingContext());
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));

        return new MongoTemplate(factory, converter);
    }

    @Bean
    public MongoMappingContext mongoMappingContext() {
        MongoMappingContext mappingContext = new MongoMappingContext();
        mappingContext.setApplicationContext(appContext);
        return mappingContext;
    }
}