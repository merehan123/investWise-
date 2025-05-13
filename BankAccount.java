import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * The BankAccount class simulates the process of linking a user's bank account
 * by choosing from a list of banks, entering card details, and verifying via OTP.
 * @author shahed
 */
public class BankAccount {
    private String userName;
    private String bankAccountLinked;
    private List<BankObserver> observers = new ArrayList<>();


    /**
     * Constructs a new BankAccount for the given user.
     *
     * @param userName The name of the user.
     */
    public BankAccount(String userName) {

        this.userName = userName;
    }

    public void addObserver(BankObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BankObserver observer) {
        observers.remove(observer);
    }


    /**
     * Starts the process of linking a bank account.
     * It includes selecting a valid bank, entering card information, verifying OTP,
     * and linking the selected bank account.
     */
    public void clickConnectBankAccount() {
        Scanner input = new Scanner(System.in);

        String[] banks = {
                "National Bank of Egypt (NBE)",
                "Banque Misr",
                "Commercial International Bank (CIB)",
                "Banque du Caire",
                "QNB Alahli",
                "AlexBank"
        };

        showBankSelectionPage(banks);
        System.out.print("Enter bank name exactly as listed: ");
        String bankName = input.nextLine();

        if (!isBankAvailable(bankName, banks)) {
            showErrorMessage("Bank name not recognized.");
            return;
        }

        showCardInputForm();
        System.out.print("Enter 16-digit card number: ");
        String cardInfo = input.nextLine();

        if (!verifyCardDetails(cardInfo)) {
            showErrorMessage("Invalid card details.");
            return;
        }

        submitCardDetails(cardInfo);
        promptOTPVerification();
        System.out.print("Enter OTP: ");
        String otpCode = input.nextLine();

        if (!verifyOTP(otpCode)) {
            showErrorMessage("Incorrect OTP.");
            return;
        }

        linkBankAccount(bankName);
    }

    private void notifyObservers(String message) {
        for (BankObserver observer : observers) {
            observer.update(message);
        }
    }


    /**
     * Displays the list of available banks to the user.
     *
     * @param banks An array of available bank names.
     */
    private void showBankSelectionPage(String[] banks) {
        System.out.println("Available Banks:");
        for (String bank : banks) {
            System.out.println("- " + bank);
        }
    }

    /**
     * Checks whether the entered bank name matches one in the list.
     *
     * @param name  The bank name entered by the user.
     * @param banks The list of available banks.
     * @return True if the bank is in the list, false otherwise.
     */
    private boolean isBankAvailable(String name, String[] banks) {
        for (String bank : banks) {
            if (bank.equalsIgnoreCase(name.trim())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Prompts the user to enter card information.
     */
    private void showCardInputForm() {
        System.out.println("Please enter your card details.");
    }

    /**
     * Simulates submission of card details.
     *
     * @param cardInfo The card number entered by the user.
     */
    private void submitCardDetails(String cardInfo) {
        System.out.println("Submitting card: " + cardInfo);
    }

    /**
     * Displays a message indicating that the OTP was sent.
     */
    private void promptOTPVerification() {
        System.out.println("OTP has been sent to your phone.");
    }

    /**
     * Displays an error message to the user.
     *
     * @param message The error message content.
     */
    private void showErrorMessage(String message) {
        System.out.println("Error: " + message);
    }

    /**
     * Verifies the card number format.
     *
     * @param cardInfo The card number entered by the user.
     * @return True if the card is exactly 16 digits, false otherwise.
     */
    private boolean verifyCardDetails(String cardInfo) {
        return cardInfo != null && cardInfo.length() == 16;
    }

    /**
     * Verifies the entered OTP code.
     *
     * @param otpCode The OTP code entered by the user.
     * @return True if OTP is "1234", false otherwise.
     */
    private boolean verifyOTP(String otpCode) {
        return otpCode.equals("1234"); // Fixed OTP for demo purposes
    }

    /**
     * Links the bank account to the user.
     *
     * @param bankName The name of the bank to be linked.
     */
    private void linkBankAccount(String bankName) {
        this.bankAccountLinked = bankName;
        System.out.println("Bank account linked to: " + bankName);
    }

}
