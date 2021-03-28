package com.example.programmers;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class ProgrammersApplication {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("programmers.xml");
        Programmers p = (Programmers) ac.getBean("senior");
        Programmers a = (Programmers) ac.getBean("junior");
        Programmers c = (Programmers) ac.getBean("middle");
        System.out.println(p.doProgrammers());
        System.out.println(a.doProgrammers());
        System.out.println(c.doProgrammers());
    }

}
