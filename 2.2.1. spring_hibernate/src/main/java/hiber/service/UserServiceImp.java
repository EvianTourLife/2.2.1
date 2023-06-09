package hiber.service;

import hiber.config.AppConfig;
import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }
   @Transactional(readOnly = true)
   @Override
   public List <User> getUserByCar(String model, int series) {
      return  userDao.getUserByCar(model, series);
   }





//   @Transactional
//   @Override
//   public void add(Car car) {
//      userDao.add(car);
//   }
//   @Transactional(readOnly = true)
//   @Override
//   public List<Car> listCars() {
//      return userDao.listCars();
//   }

}
