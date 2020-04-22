package Alteration;

import Alteration.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.ls.LSOutput;

import java.util.List;

@SpringBootApplication
//@EnableJpaAuditing
public class Pp8Application {

    public static void main(String[] args) {
        SpringApplication.run(Pp8Application.class, args);

//		RestTemplate restTemplate = new RestTemplate();
//		User page =  restTemplate.getForObject("http://localhost:8081/adminS/rest/user/1", User.class);
//        System.out.println(page);
//
//        ResponseEntity<User[]> response =
//                restTemplate.getForEntity(
//                        "http://localhost:8081/adminS/rest/user",
//                        User[].class);
//        User[] employees = response.getBody();
//        System.out.println(employees);
    }


}
