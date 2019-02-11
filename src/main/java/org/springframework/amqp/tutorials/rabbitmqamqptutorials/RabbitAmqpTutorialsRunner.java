package org.springframework.amqp.tutorials.rabbitmqamqptutorials;

import org.springframework.amqp.tutorials.rabbitmqamqptutorials.tut2.Tut2Sender;
import org.springframework.amqp.tutorials.rabbitmqamqptutorials.tut6.Tut6Client;
import org.springframework.amqp.tutorials.rabbitmqamqptutorials.tut6.Tut6Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;

public class RabbitAmqpTutorialsRunner implements CommandLineRunner {

    //@Value("${tutorial.client.duration:0}")
    @Value("${tutorial.client.duration:60000}")
    private int duration;

    @Autowired
    private ConfigurableApplicationContext ctx;

    //@Autowired
    //private Tut1Sender sender;

    //@Autowired
    //private Tut2Sender sender;

    @Autowired
    private Tut6Client sender;

    @Override
    public void run(String... arg0) throws Exception{
        System.out.println("Ready .... running for "+ duration + "ms");
        sender.send();
        Thread.sleep(duration);
        ctx.close();
    }

}
