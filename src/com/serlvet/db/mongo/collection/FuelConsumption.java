package com.serlvet.db.mongo.collection;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.serlvet.webflow.agent.FuelAgent;
import com.serlvet.webflow.agent.UserAgent;

//@Document
//@CompoundIndexes({
//    @CompoundIndex(def = "{'km' : 1 }", unique = true)
//})
@ComponentScan(basePackages = "com.serlvet.webflow.agent")
@Document(collection = "#{@fuelAgent.getCollectionName()}_device")
public class FuelConsumption implements Serializable {
    @Autowired
    private FuelAgent fuelAgent;
    @Indexed(unique = true)
    String km;
    String liter;

    public FuelConsumption(String km, String liter) {
        this.km = km;
        this.liter = liter;
    }

    public void setKm(String km) {
        this.km = km;
    }
    public String getKm() {
        return this.km;
    }

    public void setLiter(String liter) {
        this.liter = liter;
    }
    public String getLiter() {
        return this.liter;
    }
}
