package parkingsystem;

import java.util.Scanner;

public class ParkingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carSlots = 100;
        int motorcycleSlots = 100;
        int bicycleSlots = 100;

        Vehicle[] vehicles = new Vehicle[300]; 
        int vehicleCount = 0;
        int enteredCount = 0;
        int deletedCount = 0;

        while (true) {
            System.out.println("Enter action (Enter/Exit/Print/ExitProgram): ");
            String action = scanner.nextLine();

            if (action.equalsIgnoreCase("ExitProgram")) {
                break;
            }

            if (action.equalsIgnoreCase("Enter")) {
                System.out.println("Enter vehicle type (Car/Motorcycle/Bicycle): ");
                String type = scanner.nextLine();

                if (!type.equalsIgnoreCase("Car") && !type.equalsIgnoreCase("Motorcycle") 
                        && !type.equalsIgnoreCase("Bicycle")) {
                    System.out.println("Invalid vehicle type. Please enter a valid type.");
                    continue;
                }

                int availableSlots = 0;
                if (type.equalsIgnoreCase("Car")) {
                    availableSlots = carSlots - vehicleCount;
                } else if (type.equalsIgnoreCase("Motorcycle")) {
                    availableSlots = motorcycleSlots - vehicleCount;
                } else if (type.equalsIgnoreCase("Bicycle")) {
                    availableSlots = bicycleSlots - vehicleCount;
                }

                if (availableSlots <= 0) {
                    System.out.println("Sorry, no available slots for " + type + " at the moment.");
                    continue;
                }

                System.out.println("Enter vehicle ID: ");
                int id = Integer.parseInt(scanner.nextLine());

                System.out.println("Enter duration (hours): ");
                int duration = Integer.parseInt(scanner.nextLine());

                Vehicle vehicle;

                if (type.equalsIgnoreCase("Car")) {
                    vehicle = new Car(id, duration);
                } else if (type.equalsIgnoreCase("Motorcycle")) {
                    vehicle = new Motorcycle(id, duration);
                } else {
                    vehicle = new Bicycle(id, duration);
                }

                vehicles[vehicleCount] = vehicle;
                vehicleCount++;
                enteredCount++;

                System.out.println("Vehicle parked. Parking fee: " + vehicle.calculateParkingFee() + " tk");
                System.out.println("Available " + type + " slots: " + (availableSlots - 1));
            } else if (action.equalsIgnoreCase("Exit")) {
                System.out.println("Enter vehicle ID to exit: ");
                int exitId = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < vehicleCount; i++) {
                    if (vehicles[i] != null && vehicles[i].getId() == exitId) {
                        int parkingFee = vehicles[i].calculateParkingFee();
                        String vehicleType = vehicles[i].getType();
                        
                        if (vehicleType.equalsIgnoreCase("Car")) {
                            carSlots++;
                        } else if (vehicleType.equalsIgnoreCase("Motorcycle")) {
                            motorcycleSlots++;
                        } else if (vehicleType.equalsIgnoreCase("Bicycle")) {
                            bicycleSlots++;
                        }
                        
                        System.out.println("Vehicle with ID " + exitId + " exited. Parking fee: " + parkingFee + " tk");
                        deletedCount++;
                        vehicles[i] = null;
                    }
                }
            } else if (action.equalsIgnoreCase("Print")) {
                System.out.println("Printing parking details:");
                for (int i = 0; i < vehicleCount; i++) {
                    Vehicle vehicle = vehicles[i];
                    if (vehicle != null) {
                        System.out.println("Vehicle Type: " + vehicle.getType() + ", ID: " + vehicle.getId() +
                                ", Duration: " + vehicle.getDuration() + " hours, Parking Fee: " + vehicle.calculateParkingFee() + " tk");
                    }
                }
            } else {
                System.out.println("Invalid action. Please enter a valid action.");
            }
        }

        System.out.println("Total entered vehicles: " + enteredCount);
        System.out.println("Total deleted vehicles: " + deletedCount);
    }
}
