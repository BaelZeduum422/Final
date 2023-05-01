import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CruiseSystem {
    
    private static Scanner scanner = new Scanner(System.in);
    private static List<Ship> ships = new ArrayList<>();
    private static List<Cruise> cruises = new ArrayList<>();
    private static List<Passenger> passengers = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the Luxury Vacation Cruise System!");
        while (true) {
            printMenu();
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("x")) {
                System.out.println("Exiting system...");
                break;
            } else if (choice.equals("1")) {
                addShip();
            } else if (choice.equals("2")) {
                editShip();
            } else if (choice.equals("3")) {
                addCruise();
            } else if (choice.equals("4")) {
                editCruise();
            } else if (choice.equals("5")) {
                addPassenger();
            } else if (choice.equals("6")) {
                editPassenger();
            } else if (choice.equalsIgnoreCase("a")) {
                printShipNames();
            } else if (choice.equalsIgnoreCase("b")) {
                printInServiceList();
            } else if (choice.equalsIgnoreCase("c")) {
                printShipFullList();
            } else if (choice.equalsIgnoreCase("d")) {
                printCruiseList();
            } else if (choice.equalsIgnoreCase("e")) {
                printCruiseDetails();
            } else if (choice.equalsIgnoreCase("f")) {
                printPassengerList();
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("[1] Add Ship                   [A] Print Ship Names");
        System.out.println("[2] Edit Ship                   [B] Print Ship In Service List");
        System.out.println("[3] Add Cruise              [C] Print Ship Full List");
        System.out.println("[4] Edit Cruise               [D] Print Cruise List");
        System.out.println("[5] Add Passenger      [E] Print Cruise Details");
        System.out.println("[6] Edit Passenger       [F] Print Passenger List");
        System.out.println("[x] Exit System");
    }
    
    private static void addShip() {
        System.out.println("Enter the ship's name:");
        String name = scanner.nextLine();
        if (getShip(name) != null) {
            System.out.println("Ship already exists.");
            return;
        }
        Ship ship = new Ship(name);
        ships.add(ship);
        System.out.println("Ship added successfully.");
    }
    
    private static void editShip() {
        System.out.println("Enter the ship's name:");
        String name = scanner.nextLine();
        Ship ship = getShip(name);
        if (ship == null) {
            System.out.println("Ship not found.");
            return;
        }
        System.out.println("Enter the ship's new name:");
        String newName = scanner.nextLine();
        if (getShip(newName) != null) {
            System.out.println("Ship already exists.");
            return;
        }
        ship.setName(newName);
        System.out.println("Ship edited successfully.");
    }

    private static void addCruise() {
        System.out.println("Enter the cruise's name:");
        String name = scanner.nextLine();
        if (getCruise(name) != null) {
            System.out.println("Cruise already exists.");
            return;
        }
        System.out.println("Enter the name of the ship for the cruise:");
        ships.add(ship);
    }

    private static void editShip() {
        System.out.println("Enter the ship's name:");
        String shipName = scanner.nextLine();

        Ship ship = getShip(shipName);

        if (ship == null) {
            System.out.println("Ship not found.");
            return;
        }

        System.out.println("Enter the new name (leave blank to keep current):");
        String newName = scanner.nextLine();
        if (!newName.isBlank()) {
            ship.setName(newName);
        }

        System.out.println("Enter the number of Balcony cabins (leave blank to keep current):");
        String newBalconyCabinCountString = scanner.nextLine();
        if (!newBalconyCabinCountString.isBlank()) {
            try {
                int newBalconyCabinCount = Integer.parseInt(newBalconyCabinCountString);
                ship.setBalconyCabinCount(newBalconyCabinCount);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Balcony cabin count must be an integer.");
            }
        }

        System.out.println("Enter the number of Ocean View cabins (leave blank to keep current):");
        String newOceanViewCabinCountString = scanner.nextLine();
        if (!newOceanViewCabinCountString.isBlank()) {
            try {
                int newOceanViewCabinCount = Integer.parseInt(newOceanViewCabinCountString);
                ship.setOceanViewCabinCount(newOceanViewCabinCount);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Ocean View cabin count must be an integer.");
            }
        }

        System.out.println("Enter the number of Suite cabins (leave blank to keep current):");
        String newSuiteCabinCountString = scanner.nextLine();
        if (!newSuiteCabinCountString.isBlank()) {
            try {
                int newSuiteCabinCount = Integer.parseInt(newSuiteCabinCountString);
                ship.setSuiteCabinCount(newSuiteCabinCount);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Suite cabin count must be an integer.");
            }
        }

        System.out.println("Enter the number of Interior cabins (leave blank to keep current):");
        String newInteriorCabinCountString = scanner.nextLine();
        if (!newInteriorCabinCountString.isBlank()) {
            try {
                int newInteriorCabinCount = Integer.parseInt(newInteriorCabinCountString);
                ship.setInteriorCabinCount(newInteriorCabinCount);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Interior cabin count must be an integer.");
            }
        }

        System.out.println("Ship updated.");
    }

    private static void addCruise() {
        System.out.println("Enter the cruise's name:");
        String cruiseName = scanner.nextLine();

        Ship ship = chooseShip();
        if (ship == null) {
            System.out.println("No ship available. Please add a ship first.");
            return;
        }

        Cruise cruise = new Cruise(cruiseName, ship);
        cruises.add(cruise);

        System.out.println("Cruise added.");
    }

    private static void editCruise() {
        System.out.println("Enter the cruise's name:");
        String cruiseName = scanner.nextLine();

        Cruise cruise = getCruise(cruiseName);

        if (cruise == null) {
            System.out.println("Cruise not found.");
            return;
        }

        System.out.println("Enter the new name (leave blank to keep current):");
        String newName = scanner.nextLine();
        if (!newName.isBlank()) {
            cruise.setName(newName);
        }

        System.out.println("Enter the new departure date (YYYY-MM-DD) (leave blank to keep current):");
        String newDepartureDateString = scanner.nextLine();
        if (!newDepartureDateString.isBlank()) {
            try {
                LocalDate newDepartureDate = LocalDate.parse(newDepartureDateString);
                cruise.setDepartureDate(newDepartureDate);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid input. Date must be in the format YYYY-MM-DD.");
            }
        }

        System.out.println("Enter the new return date (YYYY-MM-DD) (leave blank to keep current):");
        String newReturnDateString = scanner.nextLine();
        if (!newReturnDateString.isBlank()) {
            try {
                LocalDate newReturnDate = LocalDate.parse(newReturnDateString);
                cruise.setReturnDate(newReturnDate);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid input. Date must be in the format YYYY-MM-DD.");
            }
        }

        System.out.println("Enter the new price (leave blank to keep current):");
        String newPriceString = scanner.nextLine();
        if (!newPriceString.isBlank()) {
            try {
                double newPrice = Double.parseDouble(newPriceString);
                cruise.setPrice(newPrice);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Price must be a number.");
            }
        }

        System.out.println("Cruise updated.");
    }
    private static void editPassenger() {
        System.out.println("Enter the passenger's name:");
        String name = scanner.nextLine();

        Passenger passenger = getPassenger(name);

        if (passenger == null) {
            System.out.println("Passenger not found.");
            return;
        }

        System.out.println("Enter the passenger's new cabin type:");
        String cabinType = scanner.nextLine();
        passenger.setCabinType(cabinType);

        System.out.println("Passenger updated successfully.");
    }

    private static Ship getShip(String name) {
        for (Ship ship : ships) {
            if (ship.getName().equalsIgnoreCase(name)) {
                return ship;
            }
        }
        return null;
    }

    private static Cruise getCruise(String name) {
        for (Cruise cruise : cruises) {
            if (cruise.getName().equalsIgnoreCase(name)) {
                return cruise;
            }
        }
        return null;
    }

    private static Passenger getPassenger(String name) {
        for (Passenger passenger : passengers) {
            if (passenger.getName().equalsIgnoreCase(name)) {
                return passenger;
            }
        }
        return null;
    }

    private static void printShipNames() {
        System.out.println("Ships:");
        for (Ship ship : ships) {
            System.out.println("- " + ship.getName());
        }
    }

    private static void printInServiceList() {
        System.out.println("Ships In Service:");
        for (Ship ship : ships) {
            if (ship.isInService()) {
                System.out.println("- " + ship.getName());
            }
        }
    }

    private static void printShipFullList() {
        System.out.println("Ships:");
        for (Ship ship : ships) {
            System.out.println("- " + ship.getName() + " (" + ship.getPassengerCapacity() + " passengers)");
        }
    }

    private static void printCruiseList() {
        System.out.println("Cruises:");
        for (Cruise cruise : cruises) {
            System.out.println("- " + cruise.getName() + " (" + cruise.getShip().getName() + ")");
        }
    }

    private static void printCruiseDetails() {
        System.out.println("Enter the cruise's name:");
        String cruiseName = scanner.nextLine();

        Cruise cruise = getCruise(cruiseName);

        if (cruise == null) {
            System.out.println("Cruise not found.");
            return;
        }

        System.out.println(cruise.getName() + " (" + cruise.getShip().getName() + ")");
        System.out.println("Passengers:");
        for (Passenger passenger : cruise.getPassengers()) {
            System.out.println("- " + passenger.getName() + " (" + passenger.getCabinType() + ")");
        }
    }

    private static void printPassengerList() {
        System.out.println("Passengers:");
        for (Passenger passenger : passengers) {
            System.out.println(passenger.getName() + " (" + passenger.getCabinType() + ") on " + passenger.getCruise().getName() + " (" + passenger.getCruise().getShip().getName() + ")");
        }
    }
    private static void addShip() {
        System.out.println("Enter the ship's name:");
        String shipName = scanner.nextLine();

        Ship ship = getShip(shipName);

        if (ship != null) {
            System.out.println("Ship already exists.");
            return;
        }

        ship = new Ship(shipName);
        ships.add(ship);

        System.out.println("Ship added successfully.");
    }

    private static void editShip() {
        System.out.println("Enter the ship's name:");
        String shipName = scanner.nextLine();

        Ship ship = getShip(shipName);

        if (ship == null) {
            System.out.println("Ship not found.");
            return;
        }

        System.out.println("Enter the new name (leave blank to keep current):");
        String newName = scanner.nextLine();

        if (!newName.isEmpty()) {
            Ship existingShip = getShip(newName);
            if (existingShip != null) {
                System.out.println("Ship with name " + newName + " already exists.");
                return;
            }
            ship.setName(newName);
        }

        System.out.println("Ship edited successfully.");
    }

    private static void addCruise() {
        System.out.println("Enter the cruise's name:");
        String cruiseName = scanner.nextLine();

        Cruise cruise = getCruise(cruiseName);

        if (cruise != null) {
            System.out.println("Cruise already exists.");
            return;
        }

        System.out.println("Enter the ship's name:");
        String shipName = scanner.nextLine();

        Ship ship = getShip(shipName);

        if (ship == null) {
            System.out.println("Ship not found.");
            return;
        }

        cruise = new Cruise(cruiseName, ship);
        cruises.add(cruise);

        System.out.println("Cruise added successfully.");
    }

    private static void editCruise() {
        System.out.println("Enter the cruise's name:");
        String cruiseName = scanner.nextLine();

        Cruise cruise = getCruise(cruiseName);

        if (cruise == null) {
            System.out.println("Cruise not found.");
            return;
        }

        System.out.println("Enter the new name (leave blank to keep current):");
        String newName = scanner.nextLine();

        if (!newName.isEmpty()) {
            Cruise existingCruise = getCruise(newName);
            if (existingCruise != null) {
                System.out.println("Cruise with name " + newName + " already exists.");
                return;
            }
            cruise.setName(newName);
        }

        System.out.println("Enter the new ship's name (leave blank to keep current):");
        String newShipName = scanner.nextLine();

        if (!newShipName.isEmpty()) {
            Ship newShip = getShip(newShipName);
            if (newShip == null) {
                System.out.println("Ship not found.");
                return;
            }
            cruise.setShip(newShip);
        }

        System.out.println("Cruise edited successfully.");
    }

    private static void addPassenger() {
        System.out.println("Enter the passenger's name:");
        String name = scanner.nextLine();

        System.out.println("Enter the cabin type (Balcony, Ocean View, Suite, Interior):");
        String type = scanner.nextLine();

        System.out.println("Enter the cruise's name:");
        String cruiseName = scanner.nextLine();

        Cruise cruise = getCruise(cruiseName);

        if (cruise == null) {
            System.out.println("Cruise not found.");
            return;
        }

        if (cruise.isFull()) {
            System.out.println("Cruise is full.");
            return;
        }

        Passenger passenger = new Passenger(name, type, cruise);
        passengers.add(passenger);

        System
        private static Ship getShip(String name) {
            for (Ship ship : ships) {
                if (ship.getName().equalsIgnoreCase(name)) {
                    return ship;
                }
            }
            return null;
        }

        private static Cruise getCruise(String name) {
            for (Cruise cruise : cruises) {
                if (cruise.getName().equalsIgnoreCase(name)) {
                    return cruise;
                }
            }
            return null;
        }

        private static Passenger getPassenger(String name) {
            for (Passenger passenger : passengers) {
                if (passenger.getName().equalsIgnoreCase(name)) {
                    return passenger;
                }
            }
            return null;
        }

        public static void main(String[] args) {
            System.out.println("Welcome to the Luxury Vacation Cruise system!");

            while (true) {
                displayMenu();
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("x")) {
                    System.out.println("Exiting system...");
                    break;
                } else if (choice.equals("1")) {
                    addShip();
                } else if (choice.equals("2")) {
                    editShip();
                } else if (choice.equals("3")) {
                    addCruise();
                } else if (choice.equals("4")) {
                    editCruise();
                } else if (choice.equals("5")) {
                    addPassenger();
                } else if (choice.equals("6")) {
                    editPassenger();
                } else if (choice.equalsIgnoreCase("a")) {
                    printShipNames();
                } else if (choice.equalsIgnoreCase("b")) {
                    printInServiceList();
                } else if (choice.equalsIgnoreCase("c")) {
                    printShipFullList();
                } else if (choice.equalsIgnoreCase("d")) {
                    printCruiseList();
                } else if (choice.equalsIgnoreCase("e")) {
                    printCruiseDetails();
                } else if (choice.equalsIgnoreCase("f")) {
                    printPassengerList();
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
        private static void editPassenger() {
            System.out.println("Enter the passenger's name:");
            String passengerName = scanner.nextLine();

            Passenger passenger = getPassenger(passengerName);

            if (passenger == null) {
                System.out.println("Passenger not found.");
                return;
            }

            System.out.println("Edit passenger " + passenger.getName() + ":");
            System.out.println("[1] Name");
            System.out.println("[2] Cabin Type");

            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                System.out.println("Enter new name:");
                String newName = scanner.nextLine();
                passenger.setName(newName);
                System.out.println("Passenger updated.");
            } else if (choice.equals("2")) {
                System.out.println("Enter new cabin type (Balcony, Ocean View, Suite, Interior):");
                String newCabinType = scanner.nextLine();
                if (newCabinType.equalsIgnoreCase("Balcony")) {
                    passenger.setCabinType(CabinType.BALCONY);
                } else if (newCabinType.equalsIgnoreCase("Ocean View")) {
                    passenger.setCabinType(CabinType.OCEAN_VIEW);
                } else if (newCabinType.equalsIgnoreCase("Suite")) {
                    passenger.setCabinType(CabinType.SUITE);
                } else if (newCabinType.equalsIgnoreCase("Interior")) {
                    passenger.setCabinType(CabinType.INTERIOR);
                } else {
                    System.out.println("Invalid cabin type.");
                    return;
                }
                System.out.println("Passenger updated.");
            } else {
                System.out.println("Invalid choice.");
            }
        }
