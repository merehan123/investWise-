/**
 * Factory class for creating {@link Asset} objects.
 * <p>
 * This class encapsulates the creation logic of Asset objects and helps decouple
 * the instantiation process from client code. It is especially useful when applying
 * the Factory Design Pattern.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 *     Asset asset = AssetFactory.createAsset("user1", "Stocks", "Apple", 10, "2024-01-01", 150.0);
 * }</pre>
 * </p>
 *
 * @author Merehan
 */
public class AssetFactory {

    /**
     * Creates and returns a new {@link Asset} instance using the provided details.
     *
     * @param user the username of the asset owner
     * @param type the type of the asset (ex, "Stocks", "Real Estate", etc.)
     * @param name the name of the asset
     * @param quantity the quantity of the asset
     * @param date the purchase date in yyyy-mm-dd format
     * @param price the purchase price per unit
     * @return a new Asset object with the given attributes
     */
    public static Asset createAsset(String user, String type, String name, double quantity, String date, double price) {
        return new Asset(user, type, name, quantity, date, price);
    }
}
