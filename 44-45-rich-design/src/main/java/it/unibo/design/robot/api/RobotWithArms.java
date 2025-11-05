package it.unibo.design.robot.api;

public interface RobotWithArms extends Robot{
    //picks an object, returns true if the action is successful
    boolean pickUp();

    //drops an object, returns true if the action is successful
    boolean dropDown();

    //returns the number of objects this robot is currently transporting
    int getCarriedItemsCount();
}