package carautopilot;

import java.util.*;

public class CurrentCar {
    public static void main(String[] args) {
        Car car = new Car(new Date(), Engine.DIESEL, 180, 20, 4, 3, 100);
        System.out.println(car);
        System.out.println();
        car.getWheel(0).wipeTire(50);
        car.getDoor(3).changeStateWindow();
        car.removePassenger();
        System.out.println(car);
    }


}