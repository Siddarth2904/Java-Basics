package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComputerDevloper {
    @Autowired
    Laptop laptop;
    @Autowired
    Desktop desktop;
    public ComputerDevloper(Laptop laptop, Desktop desktop) {
        this.laptop=laptop;
        this.desktop=desktop;
    }
    public void develop(){
        System.out.println("Devloper build");
        laptop.build();
        desktop.build();
    }
}
