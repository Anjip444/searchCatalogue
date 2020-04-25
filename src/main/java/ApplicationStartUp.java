import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.beans.EventHandler;

@SpringBootConfiguration
public class ApplicationStartUp {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =SpringApplication.run(ApplicationStartUp.class, args);

        //System.out.println(ctx.getBean(EventHandler.class).getAction());
    }
}
