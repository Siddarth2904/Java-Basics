package com.example.interfaceDemo;

import org.springframework.stereotype.Component;

@Component
public class MobileDeveloper {
    SmartDevices smtDevices;
    public MobileDeveloper(SmartDevices smtDevices) {
        this.smtDevices = smtDevices;
    }
    public void develop() {
        smtDevices.build();
    }
}
