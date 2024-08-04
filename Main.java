import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car {
    private String carId;
    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean isAvailable;

    public Car(String carId, String brand, String model, double basePricePerDay) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = true;
    }

    public String getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public double calculatePrice(int rentalDays) {
        return basePricePerDay * rentalDays;
    }

    public void rent() {
        isAvailable = false;
    }

    public void returnCar() {
        isAvailable = true;
    }
}

class Customer {
    private String customerName;
    private String customerId;

    public Customer(String customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }
}

class Rental {
    private Car car;
    private Customer customer;
    private int days;
    private double totalPrice;

    public Rental(Car car, Customer customer, int days) {
        this.car = car;
        this.customer = customer;
        this.days = days;
        this.totalPrice = car.calculatePrice(days);
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalSystem() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentCar(Car car, Customer customer, int days) {
        if (car.isAvailable()) {
            car.rent();
            rentals.add(new Rental(car, customer, days));
            System.out.println("Car Rented Successfully");
        } else {
            System.out.println("Car is not available for rent.");
        }
    }

    public void returnCar(Car car) {
        Rental rentalToRemove = null;
        for (Rental rental : rentals) {
            if (rental.getCar() == car) {
                rentalToRemove = rental;
                break;
            }
        }
        if (rentalToRemove != null) {
            rentals.remove(rentalToRemove);
            car.returnCar();
            System.out.println("Car Returned Successfully");
        } else {
            System.out.println("Car was not rented.");
        }
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("=====Car Rental System=====");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume new line

            if (choice == 1) {
                System.out.println("\n=====Rent a Car=====\n");
                System.out.println("Enter your name:");
                String customerName = sc.nextLine();
                System.out.println("\nAvailable Cars:");
                for (Car car : cars) {
                    if (car.isAvailable()) {
                        System.out.println(car.getCarId() + " " + car.getBrand() + " " + car.getModel());
                    }
                }
                System.out.println("Enter Car Id You Want To Rent:");
                String carId = sc.nextLine();
                System.out.println("Enter Number of Days:");
                int days = sc.nextInt();
                sc.nextLine();
                Customer customer = new Customer("C00" + (customers.size() + 1), customerName);
                addCustomer(customer);

                Car selectedCar = null;
                for (Car car : cars) {
                    if (car.getCarId().equals(carId)) {
                        selectedCar = car;
                        break;
                    }
                }
                if (selectedCar != null) {
                    double totalPrice = selectedCar.calculatePrice(days);
                    System.out.println("=====Rental Details=====");
                    System.out.println("Car Id: " + selectedCar.getCarId());
                    System.out.println("Car Brand: " + selectedCar.getBrand());
                    System.out.println("Car Model: " + selectedCar.getModel());
                    System.out.println("Rental Days: " + days);
                    System.out.println("Total Price: " + totalPrice);
                    System.out.println("=====Customer Details=====");
                    System.out.println("Customer Id: " + customer.getCustomerId());
                    System.out.println("Customer Name: " + customer.getCustomerName());

                    System.out.println("Confirm Rental (Y/N):");
                    String confirm = sc.nextLine();
                    if (confirm.equalsIgnoreCase("Y")) {
                        rentCar(selectedCar, customer, days);
                    } else {
                        System.out.println("Car Rent Cancelled");
                    }
                }
            } else if (choice == 2) {
                System.out.println("\n=====Return a Car=====\n");
                System.out.println("Enter Car Id You Want To Return:");
                String carId = sc.nextLine();
                Car selectedCar = null;
                for (Car car : cars) {
                    if (car.getCarId().equals(carId)) {
                        selectedCar = car;
                        break;
                    }
                }
                if (selectedCar != null) {
                    returnCar(selectedCar);
                }
            } else if (choice == 3) {
                System.out.println("Thank you for using our system.");
                break;
            } else {
                System.out.println("Invalid Choice. Please Try Again.");
            }
        }
        sc.close();
    }
}

public class Main {
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();
        Car car1 = new Car("C001", "Toyota", "Corolla", 1000);
        Car car2 = new Car("C002", "Honda", "Civic", 1500);
        Car car3 = new Car("C003", "Mahindra", "Thar", 1800);

        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);

        rentalSystem.menu();
    }
}
