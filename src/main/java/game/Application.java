package game;


import game.xo.XoGames;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        XoGames xoGames = context.getBean(XoGames.class);
        xoGames.startGame();
        //mvnw exec:java -Dexec.mainClass="game.Application"


    }
}
