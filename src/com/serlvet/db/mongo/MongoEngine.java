package com.serlvet.db.mongo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.serlvet.config.MongoConfig;

public class MongoEngine {

    private MongoOperations mongoOps;

    public MongoEngine() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
        MongoOperations mongoOps = (MongoOperations) ctx.getBean("mongoTemplate");
    }
    
    public void setMongoOps(MongoOperations mongoOps) {
        this.mongoOps = mongoOps;
    }
    
    public MongoOperations getMongoOps() {
        return this.mongoOps;
    }
}
