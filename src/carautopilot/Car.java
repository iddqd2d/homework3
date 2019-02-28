package carautopilot;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;

import static javax.swing.text.html.HTML.Tag.HEAD;

public class Car {
    private final String dateOfManufacture;
    private Engine typeEngine;
    private int maxSpeed;
    private int timeRacing100;
    private int passengerCapacity;
    private int passengerInCar;
    private int speed;
    private LinkedList<CarWheel> wheels;
    private LinkedList<CarDoor> doors;

    Car(Date date) {
        this.dateOfManufacture = date.toString();
        wheels = new LinkedList<>();
        doors = new LinkedList<>();
        addDoors();
        addWheels(4);
    }

    Car(Date date, Engine typeEngine, int maxSpeed, int timeRacing100, int passengerCapacity, int passengerInCar, int speed) {
        this(date);
        this.typeEngine = typeEngine;
        this.maxSpeed = maxSpeed;
        this.timeRacing100 = timeRacing100;
        this.passengerCapacity = passengerCapacity;
        this.passengerInCar = passengerInCar;
        this.speed = speed;

    }

    public void changeSpeed(int speed) {
        if (getCurrentMaxSpeed() <= speed) {
            this.speed = speed;
        } else this.speed = getCurrentMaxSpeed();
    }

    public boolean addPassenger() {
        if (this.passengerInCar < this.passengerCapacity) {
            this.passengerInCar++;
            return true;
        } else return false;
    }

    public boolean removePassenger() {
        if (this.passengerInCar > 1) {
            this.passengerInCar--;
            return true;
        } else return false;
    }

    public void removeAllPassenger() {
        this.passengerInCar = 0;
    }

    public CarDoor getDoor(int key) {
        return doors.get(key);
    }

    private void addDoors() {
        for (int i = 0; i < 4; i++) {
            this.doors.add(new CarDoor());
        }
    }

    public CarWheel getWheel(int key) {
        return wheels.get(key);
    }

    public void removeAllWheels() {
        wheels.clear();
    }

    public void addWheels(int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.wheels.add(new CarWheel());
        }
    }

    public int getCurrentMaxSpeed() {
        return (passengerInCar != 0) ? (int) (maxSpeed * Collections.min(wheels).getStateTire()) : 0;
    }


    @Override
    public String toString() {
        return
                "date of manufacture: " + dateOfManufacture
                        + "\nEngine: " + typeEngine
                        + "\nFactory maximum speed: " + maxSpeed
                        + "\nSeconds to 100 km/h: " + timeRacing100
                        + "\nPassenger capacity: " + passengerCapacity
                        + "\nPassenger in car: " + passengerInCar
                        + "\nCurrent speed: " + speed
                        + "\nCurrent maximum speed: " + getCurrentMaxSpeed();
    }
}

enum Engine {
    PETROL,
    DIESEL,
    GAS
}