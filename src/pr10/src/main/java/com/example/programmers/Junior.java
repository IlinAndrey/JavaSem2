package com.example.programmers;

import org.springframework.stereotype.Component;

@Component
public class Junior implements Programmers {

    public String doProgrammers() {
        return "Junior";
    }


}
