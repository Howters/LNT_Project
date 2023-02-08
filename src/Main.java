import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

abstract class Vehicle {
    private String brand;
    private String name;
    private String licenseNumber;
    private int topSpeed;
    private int gasCapacity;
    private int numWheels;
    private String vehicleType;
    private String specialData;

    public Vehicle(String brand, String name, String licenseNumber, int topSpeed, int gasCapacity, int numWheels, String vehicleType, String specialData) {
        this.brand = brand;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.topSpeed = topSpeed;
        this.gasCapacity = gasCapacity;
        this.numWheels = numWheels;
        this.vehicleType = vehicleType;
        this.specialData = specialData;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public int getGasCapacity() {
        return gasCapacity;
    }

    public int getNumWheels() {
        return numWheels;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getSpecialData() {
        return specialData;
    }

    abstract void display();
}

class Car extends Vehicle {
    private int numEntertainmentSystems;

    public Car(String brand, String name, String licenseNumber, int topSpeed, int gasCapacity, int numWheels, String vehicleType, String specialData, int numEntertainmentSystems) {
        super(brand, name, licenseNumber, topSpeed, gasCapacity, numWheels, vehicleType, specialData);
        this.numEntertainmentSystems = numEntertainmentSystems;
    }

    public int getNumEntertainmentSystems() {
        return numEntertainmentSystems;
    }

    @Override
    void display() {
        System.out.println("Brand: " + getBrand());
        System.out.println("Name: " + getName());
        System.out.println("License Number: " + getLicenseNumber());
        System.out.println("Top Speed: " + getTopSpeed());
        System.out.println("Gas Capacity: " + getGasCapacity());
        System.out.println("Number of Wheels: " + getNumWheels());
        System.out.println("Vehicle Type: " + getVehicleType());
        System.out.println("Special Data: " + getSpecialData());
        System.out.println("Number of Entertainment Systems: " + getNumEntertainmentSystems());
    }
}

class Motorcycle extends Vehicle {
    private int numHelmets;

    public Motorcycle(String brand, String name, String licenseNumber, int topSpeed, int gasCapacity, int numWheels, String vehicleType, String specialData, int numHelmets) {
        super(brand, name, licenseNumber, topSpeed,gasCapacity, numWheels, vehicleType, specialData);
        this.numHelmets = numHelmets;
    }public int getNumHelmets() {
        return numHelmets;
    }

    @Override
    void display() {
        System.out.println("Brand: " + getBrand());
        System.out.println("Name: " + getName());
        System.out.println("License Number: " + getLicenseNumber());
        System.out.println("Top Speed: " + getTopSpeed());
        System.out.println("Gas Capacity: " + getGasCapacity());
        System.out.println("Number of Wheels: " + getNumWheels());
        System.out.println("Vehicle Type: " + getVehicleType());
        System.out.println("Special Data: " + getSpecialData());
        System.out.println("Number of Helmets: " + getNumHelmets());
    }
}
public class Main {
static ArrayList<Vehicle> vehicles = new ArrayList<>();

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean run = true;
    while (run) {
        System.out.println("1. Add Vehicle");
        System.out.println("2. View Vehicle List");
        System.out.println("3. View Vehicle Details");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                addVehicle(sc);
                break;
            case 2:
                viewVehicleList();
                break;
            case 3:
                viewVehicleDetails(sc);
                break;
            case 4:
                run = false;
                break;
            default:
                System.out.println("Invalid Choice! Please try again.");
                break;
        }
    }
}
public static void viewVehicleDetails(Scanner sc) {
    if (vehicles.size() == 0) {
        System.out.println("No vehicles found.");
        return;
    }

    System.out.println("List of vehicles:");
    for (int i = 0; i < vehicles.size(); i++) {
        System.out.println(i + 1 + ". " + vehicles.get(i).getName());
    }
    System.out.print("Enter the vehicle number to view details: ");
    int vehicleNumber = sc.nextInt();
    if (vehicleNumber < 1 || vehicleNumber > vehicles.size()) {
        System.out.println("Invalid vehicle number.");
        return;
    }

    Vehicle selectedVehicle = vehicles.get(vehicleNumber - 1);
    System.out.println("Vehicle details:");
    selectedVehicle.display();
}


public static void viewVehicleList() {
    if (vehicles.size() == 0) {
        System.out.println("No vehicles found.");
        return;
    }

    System.out.println("List of vehicles:");
    System.out.println("No.\tName\t\tType");
    for (int i = 0; i < vehicles.size(); i++) {
        System.out.println((i + 1) + "\t" + vehicles.get(i).getName() + "\t\t" + vehicles.get(i).getVehicleType());
    }
}



private static void addVehicle(Scanner sc) {
    System.out.print("Enter Type of Vehicle (Car/Motorcycle): ");
    String type = sc.next();
    System.out.print("Enter Brand: ");
    String brand = sc.next();
    System.out.print("Enter Name: ");
    String name = sc.next();
    System.out.print("Enter License Number (Capital Letter + 1-4 digits + 1-3 Capital Letters): ");
    String licenseNumber = sc.next();
    while (!Pattern.matches("[A-Z]\\d{1,4}[A-Z]{1,3}", licenseNumber)) {
        System.out.println("Invalid License Number Format! Please try again.");
        System.out.print("Enter License Number (Capital Letter + 1-4 digits + 1-3 Capital Letters): ");
        licenseNumber = sc.next();
    }
    System.out.print("Enter Top Speed: ");
    int topSpeed = sc.nextInt();
    System.out.print("Enter Gas Capacity: ");
    int gasCapacity = sc.nextInt();
    System.out.print("Enter Number of Wheels: ");
    int numWheels = sc.nextInt();
    System.out.print("Enter Vehicle Type: ");
    String vehicleType = sc.next();
    System.out.print("Enter Special Data: ");
    String specialData = sc.next();
    if (type.equals("Car")) {
        System.out.print("Enter Number of Entertainment Systems: ");
        int numEntertainmentSystems = sc.nextInt();
        vehicles.add(new Car(brand, name, licenseNumber, topSpeed, gasCapacity, numWheels, vehicleType, specialData, numEntertainmentSystems));
    } else if (type.equals("Motorcycle")) {
        System.out.print("Enter Number of Helmets: ");
        int numHelmets = sc.nextInt();
        vehicles.add(new Motorcycle(brand, name, licenseNumber, topSpeed, gasCapacity, numWheels, vehicleType, specialData, numHelmets));
    } else {
        System.out.println("Invalid Type!");
    }
    if (type.equalsIgnoreCase("Car")) {
    System.out.print("Enter Number of Entertainment Systems: ");
    int numEntertainmentSystems = sc.nextInt();
    vehicles.add(new Car(brand, name, licenseNumber, topSpeed, gasCapacity, numWheels, vehicleType, specialData, numEntertainmentSystems));
} else if (type.equalsIgnoreCase("Motorcycle")) {
    System.out.print("Enter Number of Helmets: ");
    int numHelmets = sc.nextInt();
    vehicles.add(new Motorcycle(brand, name, licenseNumber, topSpeed, gasCapacity, numWheels, vehicleType, specialData, numHelmets));
}}}



