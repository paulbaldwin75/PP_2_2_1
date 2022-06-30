package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;

import java.util.List;

public interface UserDao {
   Session getSession();
   void add(User user);
   List<User> listUsers();
   void addCar(Car car);
   List<Car> listCars();
   User findUserFromModelAndSeries(String model, int series);
}
