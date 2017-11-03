package com.serlvet.db.mongo.collection;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fuels")
@CompoundIndexes({
    @CompoundIndex(def = "{'username' : 1, 'car': 1}", unique = true),
    @CompoundIndex(def = "{'fuelConsumption.km' : 1 }", unique = true)
})
public class Fuel implements Serializable {
    @Id
    private String id;

    @Indexed
    String username;
    String car;
//    String km;
//    String liter;
    List<FuelConsumption> fuelConsumption;

    //public Fuel(String username, String car, String km, String liter) {
    public Fuel(String username, String car, List<FuelConsumption> fuelConsumption) {
        this.username = username;
        this.car = car;
//        this.km = km;
//        this.liter = liter;
        this.fuelConsumption = fuelConsumption;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }

    public void setCar(String car) {
        this.car = car;
    }
    public String getCar() {
        return this.car;
    }

//    public void setKm(String km) {
//        this.km = km;
//    }
//    public String getKm() {
//        return this.km;
//    }
//
//    public void setLiter(String liter) {
//        this.liter = liter;
//    }
//    public String getLiter() {
//        return this.liter;
//    }

    public void setFuelConsumption(List<FuelConsumption> fuelConsumption) {
      this.fuelConsumption = fuelConsumption;
  }
  public List<FuelConsumption> getFuelConsumption() {
      return this.fuelConsumption;
  }
}
