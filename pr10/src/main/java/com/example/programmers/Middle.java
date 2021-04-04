package com.example.programmers;

import org.springframework.stereotype.Component;

@Component
public class Middle implements Programmers {

    public String doProgrammers() {
        return "Middle";
    }


}
