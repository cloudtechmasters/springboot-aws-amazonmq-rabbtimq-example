package org.example;

import java.util.Arrays;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
/**
 * Hello world!
 *
 */
@ComponentScan(basePackages = {"org.example"})
public class App {
    @Autowired
    RabbitTemplate template;
    @Autowired
    DirectExchange directExchange;
    public static final String ROUTING_KEY = "old.car";

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


    @PostMapping(value = "/sendMessageToAmazonMQ")
    public String sendMessageToAmazonMQ(@RequestBody User userDataToBeSent) {
        /*template.convertSendAndReceiveAsType(
                directExchange.getName(),
                ROUTING_KEY,
                carDto,
                new ParameterizedTypeReference<>() {
                });*/
        System.out.println("data before sending to rabbitmq");
        template.convertAndSend(directExchange.getName(), ROUTING_KEY, userDataToBeSent);
        System.out.println("data sent to rabbitmq");
        return "message sent";
    }
}
