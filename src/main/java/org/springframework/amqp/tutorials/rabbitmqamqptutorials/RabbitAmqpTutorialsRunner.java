package org.springframework.amqp.tutorials.rabbitmqamqptutorials;

import org.springframework.amqp.tutorials.rabbitmqamqptutorials.tut1.Tut1Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan({""})
public class RabbitAmqpTutorialsRunner implements CommandLineRunner {

    @Value("${tutorial.client.duration:0}")
    private int duration;

    @Autowired
    private ConfigurableApplicationContext ctx;

    @Autowired
    private Tut1Sender sender;

    @Override
    public void run(String... arg0) throws Exception{
        System.out.println("Ready .... running for "+ duration + "ms");
        sender.send();
        Thread.sleep(duration);
        ctx.close();
    }
}
