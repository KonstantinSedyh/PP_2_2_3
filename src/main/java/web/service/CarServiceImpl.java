package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {
    private List<Car> carsList;

    {
        carsList = new ArrayList<>();
        carsList.add(new Car("model1", "color1", "engine1"));
        carsList.add(new Car("model2", "color2", "engine2"));
        carsList.add(new Car("model3", "color3", "engine3"));
        carsList.add(new Car("model4", "color4", "engine4"));
        carsList.add(new Car("model5", "color5", "engine5"));
    }

    @Override
    public List<Car> getCarList() {
        return carsList;
    }
}
