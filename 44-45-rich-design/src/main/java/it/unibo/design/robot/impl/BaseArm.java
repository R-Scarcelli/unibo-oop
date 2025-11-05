package it.unibo.design.robot.impl;

public class BaseArm {

    private static final double PICK_UP_CONSUMPTION = 12.5;
    private static final double DROP_DOWN_CONSUMPTION = 13.0;

    private final String name;
    private boolean isUsed;

    public BaseArm(String name) {
        this.name = name;
        this.isUsed = false;
    }

    public boolean isGrabbing() {
        return isUsed;
    }

    public void pickUp() {
        if(!isUsed) {
            isUsed = true;
        }
        
    }

    public void dropDown() {
        if(isUsed) {
            isUsed = false;
        }
    }

    public double getConsumptionForPickUp() {
        return PICK_UP_CONSUMPTION;
    }

    public double getConsumptionForDropDown() {
        return DROP_DOWN_CONSUMPTION;
    }
}
