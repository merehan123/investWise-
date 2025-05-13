public class BankLogger implements BankObserver {
    @Override
    public void update(String message) {
        System.out.println("BankLogger received update: " + message);
    }
}
