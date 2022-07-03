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
      Car car = new Car("Kia", 333);
      Car car1 = new Car("Lada", 222);
      Car car2 = new Car("BMW", 111);

      userService.add(new User(car, "User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User(car1, "USer2", "Lastname2", "user2@mail.ru"));
      userService.add(new User(car2, "User3", "Lastname3", "user3@mail.ru"));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      context.close();
   }
}
