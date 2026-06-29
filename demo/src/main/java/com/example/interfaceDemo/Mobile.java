package com.example.interfaceDemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Mobile implements SmartDevices {
    @Override
    public void build() {
        System.out.println("Mobile build");
    }
}
