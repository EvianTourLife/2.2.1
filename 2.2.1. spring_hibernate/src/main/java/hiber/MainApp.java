package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      Car car1 = new Car("Mazda", 2020);
      Car car2 = new Car("Mercedes", 2022);
      Car car3 = new  Car("BMW", 2015);
      Car car4 = new Car("Tesla", 2023);

      userService.add(new User("Andrew", "Chuzkin", "Andrew@mail.ru",car1));
      userService.add(new User("Mark", "Mask", "Mark2@mail.ru",car2));
      userService.add(new User("Leo", "Smith", "Leo3@mail.ru",car3));
      userService.add(new User("Pier", "Black", "Pier4@mail.ru",car4));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      System.out.println(userService.getUserByCar("Mazda", 2020));
      System.out.println(userService.getUserByCar("EmptyCar", 1));



      context.close();
   }
}

