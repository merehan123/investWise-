/**
 * Represents a financial asset owned by a user.
 * Each asset has a type, name, quantity, purchase date, and purchase price.
 * Used for tracking investments in the system.
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

    /**
     * Constructs a new Asset with the specified details.
     *
     * @param userName the username of the owner
     * @param type the type of the asset (e.g., Stocks, Real Estate)
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
    public Asset(){

    }

    /** @return the username of the asset owner */
    public String getUserName(){
        return userName;
    }

    /** @return the type of the asset */
    public String getType(){
        return type;
    }

    /** @return the name of the asset */
    public String getName(){
        return name;
    }

    /** @return the quantity of the asset */
    public double getQuantity(){
        return quantity;
    }

    /** @return the purchase date of the asset */
    public String getPurchaseDate() {
        return purchaseDate;
    }

    /** @return the purchase price per unit of the asset */
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
     * @param purchaseDate the new purchase date (yyyy-mm-dd)
     */
    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    /**
     * Sets the purchase price per unit.
     *
     * @param purchasePrice the new purchase price
     */
    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    /**
     * Calculates the total value of the asset.
     *
     * @return total value = quantity * purchasePrice
     */
    public double totalValue(){
        return quantity * purchasePrice;
    }

    /**
     * Returns a string representation of the asset details.
     *
     * @return a formatted string containing asset info
     */
    @Override
    public String toString(){
        return "Name: " + name + ", Type: " + type + ", Quantity: " + quantity + ", Date: " + purchaseDate + ", Price: " + purchasePrice;
    }
}
