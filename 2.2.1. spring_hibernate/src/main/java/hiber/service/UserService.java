package hiber.service;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    void addCar(Car car);
    List<Car> listCars();
    User findUserFromModelAndSeries(String model, int series);
}
