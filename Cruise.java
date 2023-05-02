package com.Final;

import java.util.ArrayList;
import java.util.Arrays;

public class Cruise {
    private String name;
    private Ship ship;
    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    private int maxPassengers = 5;
    private int[] cabinCapacity;

    public Cruise(String name, Ship ship) {
        this.name = name;
        this.ship = ship;
        this.cabinCapacity = new int[ship.getCabinCount()];
        Arrays.fill(this.cabinCapacity, 0); // fill all cabins with 0 passengers
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
        this.cabinCapacity = new int[ship.getCabinCount()];
        Arrays.fill(this.cabinCapacity, 0); // fill all cabins with 0 passengers
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public int getAvailableCabinCount() {
        int totalCabinCount = ship.getCabinCount();
        int usedCabinCount = passengers.size();

        return totalCabinCount - usedCabinCount;
    }

    public boolean isFull() {
        return getAvailableCabinCount() == 0 || passengers.size() >= maxPassengers;
    }

    public int[] getCabinCapacity() {
        return cabinCapacity;
    }

    public void setCabinCapacity(int[] cabinCapacity) {
        this.cabinCapacity = cabinCapacity;
    }

    @Override
    public String toString() {
        return "Cruise [name=" + name + ", ship=" + ship + ", passengers=" + passengers + "]";
    }
}
