public class NotificationService implements BankObserver {
    private String username;

    public NotificationService(String username) {
        this.username = username;
    }

    @Override
    public void update(String username) {
        System.out.println("Notification: Bank account connected successfully for user " + username);
    }
}
