package carautopilot;

import java.time.LocalDate;

public class CurrentCar {
    public static void main(String[] args) {
        Car car = new Car(LocalDate.now(), Engine.DIESEL, 180, 20, 4, 3, 100);
        System.out.println(car);
        System.out.println();
        car.getWheel(0).wipeTire(50);
        car.removeAllPassenger();
        car.addPassenger();
        System.out.println(car);
    }


}