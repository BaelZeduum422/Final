package com.Final;

public class Passenger {
    private String name;
    private CabinType cabinType;
    private Cruise cruise;

    public Passenger(String name, CabinType cabinType, Cruise cruise) {
        this.name = name;
        this.cabinType = cabinType;
        this.cruise = cruise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CabinType getCabinType() {
        return cabinType;
    }

    public void setCabinType(CabinType cabinType) {
        this.cabinType = cabinType;
    }

    public Cruise getCruise() {
        return cruise;
    }

    public void setCruise(Cruise cruise) {
        this.cruise = cruise;
    }

    @Override
    public String toString() {
        return "Passenger [name=" + name + ", cabinType=" + cabinType + ", cruise=" + cruise.getName() + "]";
    }
}
