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

                return "Hello "+ name + "a visité "+ nbredeVisite;
            }
                catch (Exception e) {

    /**
     * @return A greeting message that includes the value of the "APP_USER" environment variable, or "World" if it is not set.
     */
    @GetMapping("/")
    public String hello() {
        try {
            String appUser = System.getenv("APP_USER");
            String name = (appUser == null || appUser.isEmpty()) ? "World" : appUser;

            String base = String.format("Hello %s!", name);
            return base;

        } catch (Exception e) {

            return "Error: " + e.getMessage();
        }
    }
}
