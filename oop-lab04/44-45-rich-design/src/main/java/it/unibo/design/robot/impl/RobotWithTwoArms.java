package it.unibo.design.robot.impl;

import it.unibo.design.robot.api.RobotWithArms;

public class RobotWithTwoArms extends BaseRobot implements RobotWithArms {
    public static final double TRANSPORT_OBJECT_CONSUMPTION = 0.1;

    private BaseArm leftArm;
    private BaseArm rightArm;
    private int numItem;

    public RobotWithTwoArms(String robotName) {
        super(robotName);
        this.leftArm = new BaseArm("leftArm");
        this.rightArm = new BaseArm("rightArm");
        this.numItem = 0;
    }

    protected double getBatteryRequirementForMovement(){
        return super.getBatteryRequirementForMovement() + getCarriedItemsCount() * TRANSPORT_OBJECT_CONSUMPTION;
    }

    private void doPickUp(final BaseArm arm) {
        if (isBatteryEnough(arm.getConsumptionForPickUp()) && !arm.isGrabbing()) {
            log(arm + " is picking an object");
            arm.pickUp();
            consumeBattery(arm.getConsumptionForPickUp());
        } else {
            log("Can not grab (battery=" + this.getBatteryLevel() + "," + arm + " isGrabbing=" + arm.isGrabbing() + ")");
        }
    }

    public boolean pickUp() {
        if (rightArm.isGrabbing()) {
            if (leftArm.isGrabbing()) {
                return false;
            }
            doPickUp(leftArm);
        } else {
            doPickUp(rightArm);
        }
        return true;
    }

    private void doRelease(final BaseArm arm) {
        if (isBatteryEnough(arm.getConsumptionForDropDown()) && arm.isGrabbing()) {
            this.log(arm + " is releasing an object");
            arm.dropDown();
            this.consumeBattery(arm.getConsumptionForDropDown());
        } else {
            log("Can not release (batteryLevel=" + this.getBatteryLevel() + "," + arm + " isGrabbing="
                    + arm.isGrabbing() + ")");
        }
    }

    public boolean dropDown() {
        if (leftArm.isGrabbing()) {
            doRelease(leftArm);
            return true;
        }
        if (rightArm.isGrabbing()) {
            doRelease(rightArm);
            return true;
        }
        return false;
    }

    public int getCarriedItemsCount() {
        return (leftArm.isGrabbing() ? 1 : 0) + (rightArm.isGrabbing() ? 1 : 0);
    }
   
}
