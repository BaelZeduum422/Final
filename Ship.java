package com.Final;

public class Ship {
    private String name;
    private int balconyCabinCount;
    private int oceanViewCabinCount;
    private int suiteCabinCount;
    private int interiorCabinCount;
    private boolean inService;

    public Ship(String name) {
        this.name = name;
        // Initialize cabin counts to zero
        this.balconyCabinCount = 0;
        this.oceanViewCabinCount = 0;
        this.suiteCabinCount = 0;
        this.interiorCabinCount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalconyCabinCount() {
        return balconyCabinCount;
    }

    public void setBalconyCabinCount(int balconyCabinCount) {
        this.balconyCabinCount = balconyCabinCount;
    }

    public int getOceanViewCabinCount() {
        return oceanViewCabinCount;
    }

    public void setOceanViewCabinCount(int oceanViewCabinCount) {
        this.oceanViewCabinCount = oceanViewCabinCount;
    }

    public int getSuiteCabinCount() {
        return suiteCabinCount;
    }

    public void setSuiteCabinCount(int suiteCabinCount) {
        this.suiteCabinCount = suiteCabinCount;
    }

    public int getInteriorCabinCount() {
        return interiorCabinCount;
    }

    public void setInteriorCabinCount(int interiorCabinCount) {
        this.interiorCabinCount = interiorCabinCount;
    }

    public int getCabinCount() {
        return balconyCabinCount + oceanViewCabinCount + suiteCabinCount + interiorCabinCount;
    }

    public boolean isInService() {
        return inService;
    }

    public void setInService(boolean inService) {
        this.inService = inService;
    }

    public int getPassengerCapacity() {
        return balconyCabinCount * 2 + oceanViewCabinCount * 2 + suiteCabinCount * 4 + interiorCabinCount * 2;
    }

    public int getCabinTypeIndex(CabinType cabinType) {
        switch (cabinType) {
            case BALCONY:
                return 0;
            case OCEAN_VIEW:
                return 1;
            case SUITE:
                return 2;
            case INTERIOR:
                return 3;
            default:
                return -1;
        }
    }

    public int getCabinCapacity(CabinType cabinType) {
        switch (cabinType) {
            case BALCONY:
                return getBalconyCabinCount() * 2;
            case OCEAN_VIEW:
                return getOceanViewCabinCount() * 2;
            case SUITE:
                return getSuiteCabinCount() * 4;
            case INTERIOR:
                return getInteriorCabinCount() * 2;
            default:
                return -1;
        }
    }


    @Override
    public String toString() {
        return "Ship [name=" + name + ", balconyCabinCount=" + balconyCabinCount + ", oceanViewCabinCount="
                + oceanViewCabinCount + ", suiteCabinCount=" + suiteCabinCount + ", interiorCabinCount="
                + interiorCabinCount + ", inService=" + inService + "]";
    }
}
