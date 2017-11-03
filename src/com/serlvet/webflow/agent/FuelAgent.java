package com.serlvet.webflow.agent;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.serlvet.db.mongo.collection.Fuel;
import com.serlvet.db.mongo.collection.FuelConsumption;
import com.serlvet.exception.CarNotFoundException;

@Component
public class FuelAgent {
    @Autowired
    private MongoOperations mongoOps;
    @Autowired
    private UserAgent userAgent;

    public List<Fuel> getData(String car) throws CarNotFoundException {
        // Fuel fuel = mongoOps.findByUsername(userAgent.getUserInfo().getUsername(),
        // Fuel.class);
        List<Fuel> fuels = mongoOps
                .find(new Query(Criteria.where("username").is(userAgent.getUserInfo().getUsername())), Fuel.class);
        if (fuels.size() == 0) {
            throw new CarNotFoundException(car);
        }
        return fuels;
    }

//    public String addData(String username, String car, String km, String liter) {
//        try {
//            List<FuelConsumption> fuelConsumption = new ArrayList<FuelConsumption>();
//            fuelConsumption.add(new FuelConsumption(km, liter));
//            mongoOps.save(new Fuel(username, car, fuelConsumption));
//            return "success";
//        } catch (DuplicateKeyException e) {
//            return "duplicateKey";
//        }
//    }
    public String addData(String username, String car, String km, String liter) {
        try {
            mongoOps.save(new FuelConsumption(km, liter), String.format("fuel_%s_%s", username, car));
            return "success";
        } catch (DuplicateKeyException e) {
            return "duplicateKey";
        }
    }
    
    public String getCollectionName() {
        return "123";
    }
}


