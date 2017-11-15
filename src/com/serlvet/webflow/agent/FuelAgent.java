package com.serlvet.webflow.agent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import com.serlvet.db.mongo.FuelTempl;
import com.serlvet.db.mongo.schema.Fuel;
import com.serlvet.db.mongo.schema.FuelConsumption;
import com.serlvet.exception.CarNotFoundException;

@Component
public class FuelAgent {
    @Autowired
    private FuelTempl fuelTempl;
    @Autowired
    private UserAgent userAgent;

    public List<String> getCarByUsername() {
        return fuelTempl.getCarByUsername(userAgent.getUserInfo().getUsername());
    }

    public List<Fuel> getData() {
        List<Fuel> fuels = fuelTempl.getFuelOneByUsername(userAgent.getUserInfo().getUsername());
        return fuels;
        // return fuelTempl.getFuelsByUsername(userAgent.getUserInfo().getUsername());
    }
    // public List<Fuel> getData(String car) throws CarNotFoundException {
    // List<Fuel> fuels =
    // fuelTempl.getFuelsByUsername(userAgent.getUserInfo().getUsername());
    // if (fuels.size() == 0) {
    // throw new CarNotFoundException(car);
    // }
    // return fuels;
    // }

    public List<Fuel> getDataByCar(String car) throws CarNotFoundException {
        List<Fuel> fuels = fuelTempl.getFuelsByUsernameAndCar(userAgent.getUserInfo().getUsername(), car);
        if (fuels.size() == 0) {
            throw new CarNotFoundException(car);
        }
        return fuels;
    }

    public void modifyData(String car, String km, String liter) {
        fuelTempl.saveFule(userAgent.getUserInfo().getUsername(), car, new FuelConsumption(km, liter));
    }

    public String addData(String username, String car, String km, String liter) {
        try {
            fuelTempl.saveFule(username, car, new FuelConsumption(km, liter));
            return "success";
        } catch (DuplicateKeyException e) {
            return "duplicateKey";
        }
    }

    public void removeData(String car, String km) {
        fuelTempl.deleteFuelConsumption(userAgent.getUserInfo().getUsername(), car, km);
    }

    public String deleteData(String username, String car, String km) {
        fuelTempl.deleteFuelConsumption(username, car, km);
        return "success";
    }
}
