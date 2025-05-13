/**
 * Represents a user in the system with capabilities to sign up, log in,
 * and perform basic validation.
 */
public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private final AuthController authController = new AuthController();

    /**
     * Default constructor.
     */
    User() {}

    // Setters

    /**
     * Sets the user's ID.
     * @param id the user's ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the user's name.
     * @param name the user's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the user's email address.
     * @param email the user's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the user's password.
     * @param password the user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    // Getters

    /**
     * Gets the user's ID.
     * @return the user's ID
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the user's name.
     * @return the user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the user's email.
     * @return the user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the user's password.
     * @return the user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Validates the provided email format.
     * @param email the email to validate
     * @return true if valid, false otherwise
     */
    public boolean validateEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    /**
     * Validates the user's name is not empty or null.
     * @param name the name to validate
     * @return true if valid, false otherwise
     */
    public boolean validateName(String name) {
        return name != null && !name.isEmpty();
    }

    /**
     * Validates that the password is at least 6 characters
     * and contains both letters and digits.
     * @param password the password to validate
     * @return true if valid, false otherwise
     */
    public boolean validatePassword(String password) {
        if (password == null || password.length() < 6) {
            return false;
        }

        boolean hasLetter = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) hasLetter = true;
            else if (Character.isDigit(c)) hasDigit = true;

            if (hasLetter && hasDigit) return true;
        }

        return false;
    }

    /**
     * Attempts to sign up the user by validating input and registering via AuthController.
     * @param name the user's name
     * @param email the user's email
     * @param password the user's password
     */
    public void Signup(String name, String email, String password) {
        AuthController controller = new AuthController();

        if (controller.userExists(name)) {
            System.out.println("Username already exists. redirect to your profile page.");
            return;
        }

        if (validateName(name) && validatePassword(password) && validateEmail(email)) {
            controller.validateAndRegister(this);
            System.out.println("Registration successful! Redirecting to choose your profile page...");
        } else {
            System.out.println("Registration failed due to system error. Please try again.");
        }
    }

    /**
     * Triggers the login flow using the stored name and password.
     */
    public void clickLogin() {
        submitLogin(this.name, this.password);
    }

    /**
     * Simulates session generation for the user.
     * @param user the user's name
     */
    public void generateSession(String user) {
        System.out.println("Session created for user: " + user);
    }

    /**
     * Redirects the user to the dashboard.
     */
    public void redirectToDashboard() {
        System.out.println("Redirecting to Dashboard...");
        displayDashboard();
    }

    /**
     * Displays the user's dashboard.
     */
    public void displayDashboard() {
        System.out.println("Welcome to your Dashboard!");
    }

    /**
     * Submits login credentials for authentication.
     * @param username the user's name
     * @param password the user's password
     */
    public boolean submitLogin(String username, String password) {
        if (authController.authenticate(username, password)) {
            generateSession(username);
            redirectToDashboard();
            return true;
        } else {
            System.out.println("Invalid username or password");
            return false;
        }
    }

}