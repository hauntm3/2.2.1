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

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));


      User user1 = new User("John", "Doe", "john@example.com");
      User user2 = new User("Bob", "Bobski", "bob@example.com");
      User user3 = new User("Elena", "Petrovna", "elena@example.com");

      Car car1 = new Car("Tesla", 2021);
      Car car2 = new Car("Toyota", 51);
      Car car3 = new Car("Lada", 777);

      user1.setCar(car3);
      user2.setCar(car1);
      user3.setCar(car2);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);

      System.out.println("Поиск пользователя по его машине: " + userService.findUserBycar("Toyota", 51));

//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println("Car : " + user.getCar());
//         System.out.println();
//      }

      context.close();
   }
}
