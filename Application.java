package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;


/**
 * Created by sams on 2/27/2016.
 */
@SpringBootApplication
public class Application  implements CommandLineRunner{
    private static final Logger log = LoggerFactory.getLogger(Application.class);
    public static void main(String [] args){
        SpringApplication.run(Application.class);
    }
    @Override
    public void run(String... strings) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        log.info(quote.toString());
        System.exit(0);
    }

}
