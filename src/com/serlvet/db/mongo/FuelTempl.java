package com.serlvet.db.mongo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.serlvet.db.mongo.schema.Fuel;
import com.serlvet.db.mongo.schema.FuelConsumption;

@Component
public class FuelTempl {
    @Autowired
    private MongoOperations mongoOps;

    public List<String> getCarByUsername(String username) {
        List<Fuel> fuels = mongoOps.find(new Query(Criteria.where("username").is(username)), Fuel.class);
        List<String> cars = new ArrayList();
        for (Fuel fuel : fuels) {
            cars.add(fuel.getCar());
        }
        return cars;
    }

    public List<Fuel> getFuelOneByUsername(String username) {
        Fuel fuel = mongoOps.findOne(new Query(Criteria.where("username").is(username)), Fuel.class);
        List<Fuel> fuels = new ArrayList();
        fuels.add(fuel);
        return fuels;
    }

    public List<Fuel> getFuelsByUsernameAndCar(String username, String car) {
        return mongoOps.find(new Query(Criteria.where("username").is(username).and("car").is(car)), Fuel.class);
    }

    public void saveFule(String username, String car, FuelConsumption fuelCon) {
        Query query = new Query(Criteria.where("username").is(username).and("car").is(car));
        Fuel fuel = mongoOps.findOne(query, Fuel.class);
        if (fuel == null) {
            List<FuelConsumption> fuelConsumption = new ArrayList<FuelConsumption>();
            fuelConsumption.add(fuelCon);
            mongoOps.save(new Fuel(username, car, fuelConsumption));
            return;
        }
        List<FuelConsumption> fuelTmp = fuel.getFuelConsumption();
        updateFuelConsumption(fuelTmp, fuelCon);
        Update update = new Update();
        update.set("fuelConsumption", fuelTmp);
        mongoOps.updateFirst(query, update, Fuel.class);
    }

    public void deleteFuelConsumption(String username, String car, String km) {
        Query query = new Query(Criteria.where("username").is(username).and("car").is(car));
        Fuel fuel = mongoOps.findOne(query, Fuel.class);
        if (fuel == null) {
            return;
        }
        List<FuelConsumption> fuelCons = fuel.getFuelConsumption();
        for (int index = 0; index < fuelCons.size(); index++) {
            if (fuelCons.get(index).getKm().equals(km)) {
                fuelCons.remove(index);
            }
        }
        Update update = new Update();
        update.set("fuelConsumption", fuelCons);
        mongoOps.updateFirst(query, update, Fuel.class);
    }

    private void updateFuelConsumption(List<FuelConsumption> fuelCons, FuelConsumption fuelCon) {
        for (FuelConsumption temp : fuelCons) {
            if (temp.getKm().equals(fuelCon.getKm())) {
                temp.setLiter(fuelCon.getLiter());
                return;
            }
        }
        fuelCons.add(fuelCon);
    }
}
