# 🚗 Car Rental System

### 📜 Overview
The **Car Rental System** is a simple console-based application developed in Java. This system allows users to rent and return cars while managing customer and car records efficiently. It demonstrates core object-oriented programming concepts such as classes, objects, and encapsulation.

### ✨ Features
- **🚗 Rent a Car**: Browse available cars and rent one for a specified duration.
- **🔄 Return a Car**: Return a rented car and update its availability status.
- **📋 Manage Records**: Maintain records of cars, customers, and rental transactions.

### 🛠️ Installation and Usage

#### Prerequisites
- Java Development Kit (JDK) installed on your machine.

#### Steps to Run
1. **Clone the repository**:
    ```bash
    git clone https://github.com/yourusername/car-rental-system.git
    ```
2. **Navigate to the project directory**:
    ```bash
    cd car-rental-system
    ```
3. **Compile the Java files**:
    ```bash
    javac Main.java
    ```
4. **Run the application**:
    ```bash
    java Main
    ```

### Example Usage

```plaintext
=====Car Rental System=====
1. Rent a Car
2. Return a Car
3. Exit
Enter your choice: 1

=====Rent a Car=====

Enter your name: John Doe

Available Cars:
C001 Toyota Corolla
C002 Honda Civic
C003 Mahindra Thar
Enter Car Id You Want To Rent: C002
Enter Number of Days: 3

=====Rental Details=====
Car Id: C002
Car Brand: Honda
Car Model: Civic
Rental Days: 3
Total Price: 4500.0
=====Customer Details=====
Customer Id: C001
Customer Name: John Doe

Confirm Rental (Y/N): Y
Car Rented Successfully
