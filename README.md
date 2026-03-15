# Invest Wise 💰

**Course:** Software Engineering
**Project:** Investment Management System

---

# 📌 Project Overview

**Invest Wise** is a financial management application designed to help users manage their investments while supporting Islamic financial principles.

The system allows users to:

* User Registration & Login
* Asset Management
* Zakat Calculation
* Bank Account Simulation
* Financial Tracking

---

# 🔐 User Interaction Flow

## 1. Program Start

When the application starts, the user sees:

```text id="0xjiv2"
1. Sign Up
2. Login
Choose an option:
```

---

## 2. Sign Up Process

The system asks for:

```text id="6fjlwm"
UserID:
Enter name:
Enter email:
Enter password:
```

### Outcome

**Successful registration**

```text id="c6p9ik"
Registration successful! Redirecting to choose your profile page...
```

**Failed registration**

```text id="9v2x4r"
Registration failed due to system error. Please try again.
```

After registration, the user enters the Main Menu.

---

## 3. Login Process

```text id="ndnwhu"
Enter username:
Enter password:
```

### Outcome

**Successful login**

```text id="0psnlu"
Session created for user: [username]
Redirecting to Dashboard...
Welcome to your Dashboard!
```

**Failed login**

```text id="1o8sl2"
Login failed. Returning to main menu...
```

---

# 📋 Main Menu

```text id="uxj7x4"
1. Display Asset Options
2. Zakat Calc
3. Connect & Manage Bank Account
4. Exit
Choose an option:
```

---

# 💼 Asset Management

```text id="j6l75u"
--- Asset Controller Menu ---
1- Add asset
2- Edit asset
3- View assets
4- Delete asset
5- Exit
```

### Features

* **Add Asset** → Enter type, name, quantity, date, and price
* **Edit Asset** → Update asset details
* **View Assets** → Display saved assets
* **Delete Asset** → Remove selected asset

---

# 🕌 Zakat Calculation

This feature calculates zakat based on stored assets and displays a zakat report.

---

# 🏦 Bank Account Connection

Simulation steps:

* Select bank
* Enter card details
* Enter OTP (`1234`)
* Receive confirmation message

---

# 🧠 Class Overview

## AuthController

Handles authentication and registration.

### Methods

* `userExists()`
* `validateAndRegister()`
* `authenticate()`

---

## User

Handles signup and login interactions.

### Methods

* `Signup()`
* `clickLogin()`
* `submitLogin()`

---

## Asset

Represents financial assets.

### Attributes

* Type
* Name
* Quantity
* Purchase Date
* Purchase Price

---

## AssetController

Manages assets.

### Methods

* `addAsset()`
* `editAsset()`
* `viewAssets()`
* `deleteAsset()`

---

## AssetFactory

Creates asset objects.

---

## BankAccount

Simulates bank connection using Observer Pattern.

---

## BankObserver

Observer interface.

---

## BankLogger

Logs bank events.

---

## NotificationService

Sends simulated notifications.

---

# 🎯 Design Patterns Used

* Factory Pattern
* Observer Pattern

---

# 🔁 Program Behavior

The program continues running until the user selects **Exit**.
