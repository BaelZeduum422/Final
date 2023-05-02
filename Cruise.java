package com.Final;

import java.util.ArrayList;
import java.util.Arrays;

public class Cruise {
    private String name;
    private Ship ship;
    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    private int maxPassengers;
    private int[] cabinCapacity;

    public Cruise(String name, Ship ship, int maxPassengers) {
        this.name = name;
        this.ship = ship;
        this.maxPassengers = maxPassengers;
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
        int totalPassengers = 0;
        for (int i = 0; i < cabinCapacity.length; i++) {
            totalPassengers += cabinCapacity[i];
        }
        return totalPassengers == maxPassengers;
    }


    public int getCabinCapacity(CabinType cabinTypeIndex) {
        int cabinIndex = ship.getCabinTypeIndex(cabinTypeIndex);
        if (cabinIndex == -1) {
            return 0;
        }
        return ship.getCabinCapacity(cabinTypeIndex);
    }

    public boolean addPassenger(Passenger passenger, CabinType cabinType) {
        if (isFull()) {
            return false;
        }

        int cabinIndex = ship.getCabinTypeIndex(cabinType);
        if (cabinIndex == -1) {
            return false;
        }

        if (cabinCapacity[cabinIndex] >= getCabinCapacity(cabinType)) {
            return false;
        }

        passengers.add(passenger);
        cabinCapacity[cabinIndex]++;

        return true;
    }

    @Override
    public String toString() {
        return "Cruise [name=" + name + ", ship=" + ship + ", passengers=" + passengers + "]";
    }
}
