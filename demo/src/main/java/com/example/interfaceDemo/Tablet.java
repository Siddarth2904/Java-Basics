package com.example.interfaceDemo;

import org.springframework.stereotype.Component;

@Component
public class Tablet implements SmartDevices {
    @Override
    public void build() {
        System.out.println("Tablet build");
    }
}
