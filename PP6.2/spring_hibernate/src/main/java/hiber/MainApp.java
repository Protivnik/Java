package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carServis =context.getBean(CarService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru",new Car("adwq",465)));
      userService.add(new User("User4", "Lastname45", "user4@mail.ru",new Car("adwq1",46522)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru",new Car("adwq1",4652)));
      carServis.add(new Car("ada",111));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car.model = " + user.getCarUser().getName());
         System.out.println("Car.number = " + user.getCarUser().getSeries());

         System.out.println();
      }
      List<User> userList =userService.listUsers();
      System.out.println(userService.getUserByCar("adwq",465));
      context.close();
   }
}
