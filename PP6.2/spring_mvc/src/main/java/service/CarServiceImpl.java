package service;

import model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarServis {
    @Override
    public List<Car> getListCar() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(1L,"ford",111));
        carList.add(new Car(2L,"oka",222));
        carList.add(new Car(3L,"lada",333));
        return carList;
    }
}
