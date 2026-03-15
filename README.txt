# Invest Wise

## Overview

**Invest Wise** is a financial management application that helps users manage investments in a structured way while supporting Islamic finance concepts such as zakat calculation.

The system allows users to:

* Register and log in securely
* Manage financial assets
* Calculate zakat
* Simulate bank account connection
* Track user investment data

---

# User Interaction Flow

## 1. Program Start

When the application starts, the main entry menu appears:

```text
1. Sign Up
2. Login
Choose an option:
```

---

## 2. Sign Up Process

If the user selects **Option 1 – Sign Up**, the system requests:

```text
UserID:
Enter name:
Enter email:
Enter password:
```

### Possible Outcomes

**Successful registration**

```text
Registration successful! Redirecting to choose your profile page...
```

**Failed registration**

```text
Registration failed due to system error. Please try again.
```

After successful registration, the user is redirected to the **Main Menu**.

---

## 3. Login Process

If the user selects **Option 2 – Login**, credentials are required:

```text
Enter username:
Enter password:
```

### Possible Outcomes

**Successful login**

```text
Session created for user: [username]
Redirecting to Dashboard...
Welcome to your Dashboard!
```

**Failed login**

```text
Login failed. Returning to main menu...
```

---

# Main Menu

```text
1. Display Asset Options
2. Zakat Calc
3. Connect & Manage Bank Account
4. Exit
Choose an option:
```

---

# Main Features

## Option 1: Asset Management

```text
Enter your username:
```

Then:

```text
--- Asset Controller Menu ---
1- Add asset
2- Edit asset
3- View assets
4- Delete asset
5- Exit
Choice:
```

### Asset Operations

* **Add Asset:** Enter asset type, name, quantity, purchase date, and price
* **Edit Asset:** Modify existing asset details
* **View Assets:** Display all assets
* **Delete Asset:** Remove selected asset
* **Exit:** Return to Main Menu

---

## Option 2: Zakat Calculation

Calculates zakat based on stored assets and displays a formatted zakat report.

---

## Option 3: Connect & Manage Bank Account

```text
Enter your username to connect bank account:
```

### Bank Simulation Flow

* Select a bank
* Enter card details
* Enter OTP (**1234**)
* Receive confirmation message

---

## Option 4: Exit

```text
Exiting the program...
```

---

# Invalid Input Handling

If the user enters an invalid choice:

```text
Invalid choice, please try again.
```

The system returns to the menu.

---

# Looping Behavior

The application continues running until the user explicitly chooses **Exit**.

---

# Class Overview

## AuthController

Handles authentication and user registration using `users.txt`.

### Methods

* `userExists(String username)`
* `validateAndRegister(String id, String name, String email, String password)`
* `authenticate(String username, String password)`

---

## User

Represents application users and manages sign-up/login.

### Methods

* `Signup()`
* `clickLogin()`
* `submitLogin(String username, String password)`
* `isValidEmail(String email)`
* `isValidPassword(String password)`
* `isValidName(String name)`

---

## Main

Entry point of the application.

### Method

* `main(String[] args)`

---

## Asset

Represents a financial asset.

### Attributes

* Type
* Name
* Quantity
* Purchase Date
* Purchase Price

### Method

* `calculateValue()`

---

## AssetController

Handles asset operations.

### Methods

* `displayAssetOptions()`
* `addAsset()`
* `editAsset()`
* `viewAssets()`
* `deleteAsset()`

---

## AssetFactory

Creates Asset objects centrally.

### Method

* `createAsset(String type, String name, int quantity, String date, double price)`

---

## BankAccount

Simulates bank account connection and implements Observer pattern subject.

### Methods

* `clickConnectBankAccount()`
* `attach(BankObserver)`
* `detach(BankObserver)`
* `notifyObservers(String event)`

---

## BankObserver

Observer interface for bank events.

### Method

* `update(String event)`

---

## BankLogger

Logs bank events.

### Method

* `update(String event)`

---

## NotificationService

Simulates notifications for bank events.

### Method

* `update(String event)`

---

# Design Patterns Used

* Factory Pattern
* Observer Pattern

---
