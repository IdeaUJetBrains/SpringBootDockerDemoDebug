package com.example.demo;

import entity.Entitybus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import rep.EntitybusRepository;

@SpringBootApplication(scanBasePackages =  { "entity", "rest"})
@EnableJpaRepositories("rep")
@EntityScan("entity")
public class DemoApplication implements CommandLineRunner
{

    @Autowired
    EntitybusRepository entitybusRepository;

    public static void main(String[] args)
    {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        // Getting all
        System.out.println("***** All *******");
        for(Entitybus st : entitybusRepository.findAll())
        {
            System.out.println(st);
        }

    }
}