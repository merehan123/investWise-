import java.util.*;

/**
 * The Main class provides a command-line interface for users to sign up, log in,
 * manage assets, calculate zakat, and connect to bank accounts.
 * It serves as the entry point for the Invest Wise application.
 */
public class Main {

    /**
     * Main method that runs the Invest Wise application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AuthController authController = new AuthController();

        while (true) {
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.print("Choose an option: ");
            int firstchoice = input.nextInt();
            input.nextLine();

            switch (firstchoice) {

                case 1:
                    /**
                     * Handles user sign-up by collecting and setting user data,
                     * then registering the user using the Signup method.
                     */
                    User sign = new User();
                    System.out.println("Sign Up:");

                    System.out.print("UserID:");
                    sign.setId(input.nextInt());
                    input.nextLine();

                    System.out.print("Enter name:");
                    sign.setName(input.nextLine());

                    System.out.print("Enter email:");
                    sign.setEmail(input.nextLine());

                    System.out.print("Enter password:");
                    sign.setPassword(input.nextLine());

                    sign.Signup(sign.getName(), sign.getEmail(), sign.getPassword());



                    // Post-registration menu
                    while (true) {
                        System.out.println("\nMain Menu:");
                        System.out.println("1. display asset options");
                        System.out.println("2.Zakat Calc");
                        System.out.println("3.Connect & Manage Bank Account ");
                        System.out.println("4. Exit");
                        System.out.print("Choose an option: ");
                        int choice2 = input.nextInt();
                        input.nextLine();

                        switch (choice2) {

                            case 1:
                                /**
                                 * Prompts user to enter a username and displays available asset options
                                 * via the AssetController class.
                                 */
                                Scanner scanner = new Scanner(System.in);
                                System.out.print("Enter your username: ");
                                String user = scanner.nextLine();
                                AssetController control = new AssetController(user);
                                control.displayAssetOpthions();
                                break;

                            case 2:
                                /**
                                 * Calculates zakat for various asset types (stocks, gold, and cash)
                                 * using the Strategy design pattern. Displays a detailed zakat report.
                                 */

                                ZakatOnStocksStrategy stocksStrategy = new ZakatOnStocksStrategy();
                                ZakatOnGoldStrategy goldStrategy = new ZakatOnGoldStrategy();
                                ZakatOnCashStrategy cashStrategy = new ZakatOnCashStrategy();

                                Asset stocks = AssetFactory.createAsset("user1", "Stocks", "Company A", 100, "2023-01-01", 50);
                                Asset gold = AssetFactory.createAsset("user1", "Gold", "Gold Bar", 2, "2023-01-01", 2000);
                                Asset cash = AssetFactory.createAsset("user1", "Cash", "Savings", 1, "2023-01-01", 10000);

                                double stocksZakat = stocksStrategy.calculateZakat(stocks);
                                double goldZakat = goldStrategy.calculateZakat(gold);
                                double cashZakat = cashStrategy.calculateZakat(cash);
                                double totalZakat = stocksZakat + goldZakat + cashZakat;
                                double totalAssets = stocks.totalValue() + gold.totalValue() + cash.totalValue();

                                // Generate report
                                System.out.println("=== Zakat Report ===");
                                System.out.printf("%-20s %-15s %-10s %-10s%n",
                                        "Asset", "Value", "Zakat", "Type");
                                System.out.println("------------------------------------------------");

                                System.out.printf("%-20s %-15.2f %-10.2f %-10s%n",
                                        stocks.getName(), stocks.totalValue(), stocksZakat, stocks.getType());
                                System.out.printf("%-20s %-15.2f %-10.2f %-10s%n",
                                        gold.getName(), gold.totalValue(), goldZakat, gold.getType());
                                System.out.printf("%-20s %-15.2f %-10.2f %-10s%n",
                                        cash.getName(), cash.totalValue(), cashZakat, cash.getType());

                                System.out.println("------------------------------------------------");
                                System.out.printf("%-20s %-15.2f %-10.2f%n",
                                        "TOTALS:", totalAssets, totalZakat);
                                System.out.println("================================================");
                                break;

                            case 3:
                                /**
                                 * Connects the user to their bank account and attaches a notification observer.
                                 * Demonstrates usage of the Observer design pattern.
                                 */
                                System.out.print("Enter your username to connect bank account: ");
                                String username = input.nextLine();
                                BankAccount bankAccount = new BankAccount(username);
                                NotificationService notification = new NotificationService(username);
                                bankAccount.addObserver(notification);
                                bankAccount.clickConnectBankAccount();
                                break;

                            case 4:
                                // Exit
                                System.out.println("Exiting the program...");
                                input.close();
                                return;

                            default:
                                System.out.println("Invalid choice, please try again.");
                                break;
                        }
                    }

                case 2:
                    /**
                     * Handles user login. If login is successful, shows the main menu.
                     * Otherwise, returns to the main screen.
                     */
                    User login = new User();
                    System.out.print("Enter username: ");
                    login.setName(input.nextLine());
                    System.out.print("Enter password: ");
                    login.setPassword(input.nextLine());
                    login.clickLogin();
                    if (!login.submitLogin(login.getName(), login.getPassword())) {
                        System.out.println("Login failed. Returning to main menu...\n");
                        break;
                    }


                    // Post-login menu
                    while (true) {
                        System.out.println("\nMain Menu:");
                        System.out.println("1. display asset options");
                        System.out.println("2.Zakat Calc");
                        System.out.println("3.Connect & Manage Bank Account ");
                        System.out.println("4. Exit");
                        System.out.print("Choose an option: ");
                        int choice3 = input.nextInt();
                        input.nextLine();

                        switch (choice3) {
                            case 1:
                                // Asset options
                                Scanner scanner = new Scanner(System.in);
                                System.out.print("Enter your username: ");
                                String user = scanner.nextLine();
                                AssetController control = new AssetController(user);
                                control.displayAssetOpthions();
                                break;

                            case 2:

                                // Zakat calculation using strategy pattern
                                ZakatOnStocksStrategy stocksStrategy = new ZakatOnStocksStrategy();
                                ZakatOnGoldStrategy goldStrategy = new ZakatOnGoldStrategy();
                                ZakatOnCashStrategy cashStrategy = new ZakatOnCashStrategy();

                                Asset stocks = AssetFactory.createAsset("user1", "Stocks", "Company A", 100, "2023-01-01", 50);
                                Asset gold = AssetFactory.createAsset("user1", "Gold", "Gold Bar", 2, "2023-01-01", 2000);
                                Asset cash = AssetFactory.createAsset("user1", "Cash", "Savings", 1, "2023-01-01", 10000);

                                double stocksZakat = stocksStrategy.calculateZakat(stocks);
                                double goldZakat = goldStrategy.calculateZakat(gold);
                                double cashZakat = cashStrategy.calculateZakat(cash);
                                double totalZakat = stocksZakat + goldZakat + cashZakat;
                                double totalAssets = stocks.totalValue() + gold.totalValue() + cash.totalValue();

                                // Generate report
                                System.out.println("=== Zakat Report ===");
                                System.out.printf("%-20s %-15s %-10s %-10s%n",
                                        "Asset", "Value", "Zakat", "Type");
                                System.out.println("------------------------------------------------");

                                System.out.printf("%-20s %-15.2f %-10.2f %-10s%n",
                                        stocks.getName(), stocks.totalValue(), stocksZakat, stocks.getType());
                                System.out.printf("%-20s %-15.2f %-10.2f %-10s%n",
                                        gold.getName(), gold.totalValue(), goldZakat, gold.getType());
                                System.out.printf("%-20s %-15.2f %-10.2f %-10s%n",
                                        cash.getName(), cash.totalValue(), cashZakat, cash.getType());

                                System.out.println("------------------------------------------------");
                                System.out.printf("%-20s %-15.2f %-10.2f%n",
                                        "TOTALS:", totalAssets, totalZakat);
                                System.out.println("================================================");
                                break;

                            case 3:
                                // Bank connection
                                System.out.print("Enter your username to connect bank account: ");
                                String username = input.nextLine();
                                BankAccount bankAccount = new BankAccount(username);
                                NotificationService notification = new NotificationService(username);
                                bankAccount.addObserver(notification);
                                bankAccount.clickConnectBankAccount();
                                break;

                            case 4:
                                // Exit
                                System.out.println("Exiting the program...");
                                input.close();
                                return;

                            default:
                                System.out.println("Invalid choice, please try again.");
                        }

                    }

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
