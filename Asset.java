/**
 * Represents a financial asset owned by a user.
 * This class stores essential details of an investment asset such as its type, name,
 * quantity, purchase date, and purchase price. It also allows calculation of the asset's
 * total value and Zakat amount using a strategy pattern.
 * Zakat calculation is handled by assigning a {@link ZakatStrategy} to this asset.
 *
 * Example types: "Stocks", "Real Estate", "Crypto", "Gold", etc.
 *
 * @author Merehan
 */
public class Asset {
    private String userName;
    private String type;
    private String name;
    private double quantity;
    private String purchaseDate;
    private double purchasePrice;
    private ZakatStrategy zakatStrategy;

    /**
     * Constructs a new Asset with the specified details.
     *
     * @param userName the username of the asset owner
     * @param type the type of the asset (ex, "Stocks", "Real Estate")
     * @param name the name of the asset
     * @param quantity the quantity of the asset
     * @param purchaseDate the purchase date in yyyy-mm-dd format
     * @param purchasePrice the purchase price per unit
     */
    public Asset(String userName, String type, String name, double quantity, String purchaseDate, double purchasePrice){
        this.userName = userName;
        this.type = type;
        this.name = name;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
    }

    /**
     * Default constructor for creating an empty Asset.
     */
    public Asset(){
    }

    /**
     * Sets the Zakat strategy to be used for calculating zakat.
     *
     * @param zakatStrategy the ZakatStrategy implementation to use
     */
    public void setZakatStrategy(ZakatStrategy zakatStrategy) {
        this.zakatStrategy = zakatStrategy;
    }

    /**
     * Calculates the zakat amount for this asset using the assigned strategy.
     *
     * @return the calculated zakat amount
     * @throws IllegalStateException if no zakat strategy is set
     */
    public double calculateZakat() {
        if (zakatStrategy == null) {
            throw new IllegalStateException("Zakat strategy not set.");
        }
        return zakatStrategy.calculateZakat(this);
    }

    /**
     * @return the username of the asset owner
     */
    public String getUserName(){
        return userName;
    }

    /**
     * @return the type of the asset (e.g., "Stocks", "Real Estate")
     */
    public String getType(){
        return type;
    }

    /**
     * @return the name of the asset
     */
    public String getName(){
        return name;
    }

    /**
     * @return the quantity of the asset
     */
    public double getQuantity(){
        return quantity;
    }

    /**
     * @return the purchase date of the asset in yyyy-mm-dd format
     */
    public String getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * @return the purchase price per unit of the asset
     */
    public double getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * Sets the name of the asset.
     *
     * @param name the new name of the asset
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the quantity of the asset.
     *
     * @param quantity the new quantity
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /**
     * Sets the purchase date of the asset.
     *
     * @param purchaseDate the new purchase date in yyyy-mm-dd format
     */
    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    /**
     * Sets the purchase price per unit of the asset.
     *
     * @param purchasePrice the new purchase price
     */
    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    /**
     * Calculates the total value of the asset.
     *
     * @return the total value = quantity * purchasePrice
     */
    public double totalValue(){
        return quantity * purchasePrice;
    }

    /**
     * Returns a formatted string containing key details of the asset.
     *
     * @return a string with asset name, type, quantity, date, and price
     */
    @Override
    public String toString(){
        return "Name: " + name + ", Type: " + type + ", Quantity: " + quantity +
                ", Date: " + purchaseDate + ", Price: " + purchasePrice;
    }
}
