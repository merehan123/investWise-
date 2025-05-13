import java.io.*;

/**
 * AuthController handles user authentication and registration.
 * It stores user data in a local text file (users.txt) using CSV format.
 * @author shahed
 */
public class AuthController {
    private final String FILE_NAME = "users.txt";

    /**
     * Checks if a username already exists in the system.
     *
     * @param username the username to check for existence
     * @return true if the username exists, false otherwise
     */
    public boolean userExists(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            // If file doesn't exist yet, assume no users exist
            return false;
        }
        return false;
    }

    /**
     * Validates and registers a new user by writing their details to a file.
     *
     * @param user the user object containing name, email, and password
     * @return true if registration is successful, false otherwise
     */
    public boolean validateAndRegister(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(user.getName().trim() + "," + user.getEmail().trim() + "," + user.getPassword().trim());
            writer.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
            return false;
        }
    }

    /**
     * Authenticates a user by checking username and password against stored data.
     *
     * @param username the entered username
     * @param password the entered password
     * @return true if credentials are valid, false otherwise
     */
    public boolean authenticate(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3 && parts[0].equals(username)) {
                    return parts[2].equals(password);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return false;
    }
}
