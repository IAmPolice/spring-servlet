package com.serlvet.db.mongo.schema;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;

public class FuelConsumption implements Serializable {
    @Indexed
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
