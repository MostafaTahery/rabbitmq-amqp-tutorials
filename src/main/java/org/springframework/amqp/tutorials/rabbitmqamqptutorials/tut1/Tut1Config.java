package org.springframework.amqp.tutorials.rabbitmqamqptutorials.tut1;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"hello-world","tut1"})
@Configuration
public class Tut1Config {

    @Bean
    public Queue hello(){
       return new Queue("hello",false);
    }

   @Profile("receiver")
    @Bean
    public Tut1Receiver receiver(){
        return new Tut1Receiver();
    }

   @Profile("receiver")
    @Bean
    public Tut1Sender sender(){
        return new Tut1Sender();
    }

}
