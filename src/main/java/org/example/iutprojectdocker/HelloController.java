package org.example.iutprojectdocker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import redis.clients.jedis.Jedis;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {

        //Récupération du nom
        String appUser = System.getenv("APP_USER");
        
        String name = (appUser == null || appUser.isEmpty()) ? "World" : appUser;


        
        try {
            return "Hello World";
            
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
