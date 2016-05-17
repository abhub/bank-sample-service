package fr.clevermind;

import fr.clevermind.domain.Bank;
import fr.clevermind.repository.BankRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@RestController
public class BankSampleServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(BankSampleServiceApplication.class, args);
    }


    @RequestMapping("/")
    public String home() {
        return "Welcome to first CleverMind Conf";
    }

    @Bean
    HealthIndicator indicator() {

        return () -> Health.status("Clevermind, great place to work").build();
    }

    @Bean
    CommandLineRunner runner(BankRepository bankRepository) {
        return args -> {
            System.out.println("Run specifique code after context completed");
            final Random random = new Random();

            List<String> locations = Arrays.asList("Paris,Lyon,Nice,Nordeaux,Marseille".split(","));

            Arrays.asList("SG,LCL,CA,BNP".split(","))
                    .stream()
                    .forEach(s -> {
                        final String location = locations.get(random.nextInt(locations.size()));
                        bankRepository.save(new Bank(s, location, random.nextInt()));
                    });


            bankRepository.findAll()
                    .stream()
                    .forEach(System.out::println);

            bankRepository.findByBankName("LCL")
                    .stream()
                    .forEach(
                            System.out::println
                    );
        };
    }

    @Bean
    ApplicationRunner applicationRunner() {
        return (args) -> {
            args.getOptionNames()
                    .forEach(s -> System.out.println(s + " with value " + args.getOptionValues(s)));
        };
    }
}
