package com.example.programmers;

import org.springframework.stereotype.Component;

@Component
public class Senior implements Programmers {

    public String doProgrammers() {
        return "Senior";
    }


}
