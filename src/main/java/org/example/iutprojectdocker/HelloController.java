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

        
            try (Jedis jedis = new Jedis("redis", 6379)) {
                // Incrémentation du nombre du compteur "hits" dans le Redis
                Long count = jedis.incr("hits");
                String nbredeVisite = "A été visité " + count + " fois"  ;

                return "Hello "+ name + "a visité "+ nbreVisite;
            }
                catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
