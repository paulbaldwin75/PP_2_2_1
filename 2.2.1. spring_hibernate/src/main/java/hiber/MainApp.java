package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Paul", "Baldwin", "paulbaldwin@mail.ru", new Car("AUDI", 5)));
      userService.add(new User("Ksu", "Baldwin", "user2@mail.ru", new Car("BMW", 540)));
      userService.add(new User("Ivan", "Petrov", "user3@mail.ru", new Car("BMW", 320)));
      userService.add(new User("Sergey", "Ivanov", "user4@mail.ru", new Car("LADA", 21099)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+ user.getId());
         System.out.println("First Name = "+ user.getFirstName());
         System.out.println("Last Name = "+ user.getLastName());
         System.out.println("Email = "+ user.getEmail());
         System.out.println("Car model = " + user.getCar().getModel());
         System.out.println("Car series = " + user.getCar().getSeries());
         System.out.println();
      }
      try {
         System.out.println(userService.findUserFromModelAndSeries("AUDI", 5));
      } catch (NoResultException e) {
         System.out.println("Нет пользователя с такой машиной.");
      }
      context.close();
   }
}
