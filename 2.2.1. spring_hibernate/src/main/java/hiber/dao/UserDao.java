package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao <T>{
   void add(User user);
   List<User> listUsers();

   List <User> getUserByCar(String model, int series);


//   void add(Car car);
//   List<Car> listCars();
}
