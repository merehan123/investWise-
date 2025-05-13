Invest Wise – User Interaction  
1. Program Start 
When you run the Invest Wise application, the first screen will display the main entry 
menu: 
1. Sign Up   
2. Login   
Choose an option: 
 
2. Sign Up Process (Option 1) 
If you select Option 1 – Sign Up, the system will guide you through the registration 
process. You will be asked to provide the following information: 
Sign Up:   
UserID:   
Enter name:   
Enter email:   
Enter password: 
Outcome: 
 Successful registration: 
Registration successful! Redirecting to choose your profile page... 
 Failed registration: 
Registration failed due to system error. Please try again. 
After successful registration, or if you're already registered, the system will take you to 
the Main Menu: 
Main Menu:   
1. display asset options   
2. Zakat Calc   
3. Connect & Manage Bank Account   
4. Exit   
Choose an option: 
 
2. Login Process (Option 2) 
If you already have an account, select Option 2 – Login. 
You’ll be asked to enter your credentials: 
Enter username:   
Enter password: 
Outcome: 
 Successful login: 
 Session created for user: [username]   
 Redirecting to Dashboard...   
 Welcome to your Dashboard! 
 Login failed: 
 Login failed. Returning to main menu... 
You’ll be returned to the initial Sign Up/Login menu. 
 
3. Main Menu Options 
Option 1: Display Asset Options 
You’ll be prompted to enter your username: 
Enter your username: 
Then, the Asset Management Menu will appear: --- Asset Controller Menu ---   
1- Add asset   
2- Edit asset   
3- View assets   
4- Delete asset   
5- Exit   
Choice: 
Menu Details: 
 Add asset: 
You’ll be asked to enter the asset's type, name, quantity, purchase date, and 
price. 
 Edit asset: 
A list of your current assets will be displayed. You can select one and update its 
details. 
 View assets: 
Displays all the assets you’ve added. 
 Delete asset: 
Select an asset from the list to delete it. 
 Exit: 
Returns you to the Main Menu. 
 
Option 2: Zakat Calc 
This option triggers the Zakat Calculation feature. 
The system calculates the zakat due on your assets (using real or sample data), and 
displays a formatted zakat report in the console. 
 
Option 3: Connect & Manage Bank Account 
You’ll be asked to enter your username: 
Enter your username to connect bank account: 
Then, a simulated bank connection flow follows: 
 A list of banks will be shown. 
 You’ll select a bank. 
 Enter sample card details (simulation). 
 Enter a One-Time Password (OTP) – for demonstration purposes, the OTP is 
fixed as "1234". 
 A confirmation message will be shown upon successful simulation. 
 
Option 4: Exit 
This option will terminate the program with the message: 
Exiting the program... 
 
Invalid Choices 
If you enter a number that’s not part of the menu options, you’ll see: 
Invalid choice, please try again. 
Then the main menu will be shown again. 
 
 
5. Looping Behavior 
The program is designed to run continuously until the user explicitly chooses to Exit. 
After completing any action (sign-up, login, asset management, zakat calculation, or 
bank linking), the system will always redirect you to the appropriate menu to continue 
your session. 
 
 
Invest Wise – Class Overview 
1. AuthController Class 
Purpose: 
Handles user authentication and registration. 
Stores user data in a text file (users.txt). 
Key Methods: 
 userExists(String username): Checks if a username is already registered. 
 validateAndRegister(String id, String name, String email, String password): 
Registers a new user by validating input and saving it. 
 authenticate(String username, String password): Validates user login credentials. 
 
2. User Class 
Purpose: 
Represents a user in the application, encapsulates personal details, and manages sign
up/login. 
Key Methods: 
 Signup(): Collects input and calls AuthController.validateAndRegister(). 
 clickLogin(): Initiates login interaction. 
 submitLogin(String username, String password): Calls 
AuthController.authenticate() for login. 
 isValidEmail(String email): Validates email format. 
 isValidPassword(String password): Validates password strength or format. 
 isValidName(String name): Validates name format. 
 
3. Main Class 
Purpose: 
Acts as the entry point of the Invest Wise application. Manages program flow and 
menus. 
Key Methods: 
 main(String[] args): Displays main menu (Sign Up / Login) and handles 
navigation based on user input. 
 
4. Asset Class 
Purpose: 
Represents a user’s financial asset with essential attributes. 
Attributes: 
 Type, Name, Quantity, Purchase Date, Purchase Price. 
Key Methods: 
 calculateValue(): Returns the total value of the asset (quantity * purchase price). 
 Standard getters and setters for each attribute. 
 
5. AssetController Class 
Purpose: 
Handles user asset operations like adding, editing, viewing, and deleting assets. 
Key Methods: 
 displayAssetOptions(): Displays the asset management menu. 
 addAsset(): Prompts the user to input asset details and adds it. 
 editAsset(): Allows editing of existing asset details. 
 viewAssets(): Displays the list of the user's assets. 
 deleteAsset(): Deletes a selected asset. 
 
6. AssetFactory Class 
Purpose: 
Creates Asset objects through centralized logic. 
Key Methods: 
 createAsset(String type, String name, int quantity, String date, double price): 
Returns a new Asset object based on provided parameters. 
 
7. BankAccount Class 
Purpose: 
Simulates the connection of a bank account and implements the Subject role in the 
Observer pattern. 
Key Methods: 
 clickConnectBankAccount(): Handles bank selection, card details, and OTP 
entry. 
 attach(BankObserver): Registers an observer. 
 detach(BankObserver): Removes an observer. 
 notifyObservers(String event): Notifies all registered observers about an event. 
 
8. BankObserver Interface 
Purpose: 
Defines a standard update() method to be implemented by classes that wish to observe 
bank account events. 
Key Method: 
 update(String event): Called when an event occurs in BankAccount. 
 
9. BankLogger Class 
Purpose: 
Implements BankObserver to log bank-related events. 
Key Method: 
 update(String event): Outputs a log message to the console when notified of a 
bank event. 
 
10. NotificationService Class 
Purpose: 
Implements BankObserver to simulate sending notifications to users about bank 
account events. 
Key Method: 
 update(String event): Prints a notification message when a bank event occurs. 
