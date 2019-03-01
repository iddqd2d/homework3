package carautopilot;

import java.time.LocalDate;
import java.util.*;


public class Car {
    private final LocalDate dateOfManufacture;
    private Engine typeEngine;
    private int maxSpeed;
    private int timeRacing100;
    private int passengerCapacity;
    private int passengerInCar;
    private int speed;
    private List<CarWheel> wheels;
    private List<CarDoor> doors;

    public Car(LocalDate date) {
        this.dateOfManufacture = date;
        wheels = new ArrayList<>();
        doors = new ArrayList<>();
        addDoors();
        addWheels(4);
    }

    public Car(LocalDate date, Engine typeEngine, int maxSpeed, int timeRacing100, int passengerCapacity, int passengerInCar, int speed) {
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
        return (key >= 0 && doors.size() > key) ? doors.get(key) : null;
    }

    private void addDoors() {
        for (int i = 0; i < 4; i++) {
            this.doors.add(new CarDoor());
        }
    }

    public CarWheel getWheel(int key) {
        return (key >= 0 && wheels.size() > key) ? wheels.get(key) : null;
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