import java.util.ArrayList;
import java.util.Scanner;

/**
 * Controller class for managing user assets.
 * Handles adding, editing, viewing, and deleting assets through a console menu.
 *
 * @author Merehan
 */
public class AssetController {
    private Scanner scanner = new Scanner(System.in);
    private String user;
    private ArrayList<Asset> assets = new ArrayList<>();

    /**
     * Constructs a new AssetController for a specific user.
     *
     * @param user the username of the current user
     */
    public AssetController(String user){
        this.user = user;
    }

    /**
     * Displays the main asset controller menu and handles user choices.
     * Allows users to add, edit, view, or delete assets.
     */
    public void displayAssetOpthions(){
        while (true){
            System.out.println("\n--- Asset controller menu ---");
            System.out.println("1- Add asset");
            System.out.println("2- Edit asset");
            System.out.println("3- View assets");
            System.out.println("4- Delete asset");
            System.out.println("5- Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1 -> addAsset();
                case 2 -> editAsset();
                case 3 -> viewAssets();
                case 4 -> deleteAsset();
                case 5 -> {
                    System.out.println("Exiting");
                    return;
                }
                default -> System.out.println("Invalid choice");

            }
        }
    }

    /**
     * Prompts the user to enter asset details and adds a new asset to the list.
     */
    public void addAsset(){
        System.out.println("Select asset type:");
        System.out.println("1- Stocks");
        System.out.println("2- Real estate");
        System.out.println("3- Crypto");
        System.out.println("4- Gold");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        String type = null;
        switch (choice){
            case 1 -> type = "Stocks";
            case 2 -> type = "Real Estate";
            case 3 -> type = "Crypto";
            case 4 -> type = "Gold";
            default -> {
                System.out.println("Invalid type.");
                return;
            }
        }
        System.out.print("Asset name: ");
        String name = scanner.nextLine();

        System.out.print("Quantity: ");
        double quantity = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Purchase date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        System.out.print("Purchase price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        if(name.isEmpty() || quantity <= 0 || price <= 0 || date.isEmpty()){
            System.out.println("Invalid input. Asset not added");
            return;
        }
        Asset asset = new Asset(user, type, name, quantity, date, price);
        assets.add(asset);
        System.out.println("Asset added successfully");
    }

    /**
     * Edits an existing asset's name, quantity, purchase date, or price.
     * Displays current values and allows optional updates.
     */
    public void editAsset(){
        if (assets.isEmpty()){
            System.out.println("No assets to edit");
            return;
        }
        viewAssets();
        System.out.print("Enter the number of the asset to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if(index < 1 || index > assets.size()){
            System.out.println("invalid asset number");
            return;
        }
        Asset asset = assets.get(index - 1);

        System.out.print("New Name (leave empty to keep \"" + asset.getName() + "\"): ");
        String name = scanner.nextLine();
        if (!name.isEmpty())
            asset.setName(name);

        System.out.print("New Quantity (leave empty to keep " + asset.getQuantity() + "): ");
        String quantityStr = scanner.nextLine();
        if (!quantityStr.isEmpty())
            asset.setQuantity(Double.parseDouble(quantityStr));

        System.out.print("New Purchase Date (leave empty to keep \"" + asset.getPurchaseDate() + "\"): ");
        String date = scanner.nextLine();
        if (!date.isEmpty())
            asset.setPurchaseDate(date);

        System.out.print("New Purchase Price (leave empty to keep " + asset.getPurchasePrice() + "): ");
        String priceStr = scanner.nextLine();
        if (!priceStr.isEmpty())
            asset.setPurchasePrice(Double.parseDouble(priceStr));
        System.out.println("Asset updated");


    }

    /**
     * Displays all assets owned by the user.
     * If no assets are available, notifies the user.
     */
    public void viewAssets(){
        if(assets.isEmpty()){
            System.out.println("No assets to display.");
            return;
        }
        System.out.println("---your assets");
        for (int i = 0; i < assets.size(); ++i){
            System.out.println((i + 1) + " , " + assets.get(i));
        }
    }

    /**
     * Removes a selected asset from the user's list of assets.
     * Displays a list of assets for selection.
     */
    public void deleteAsset(){
        if (assets.isEmpty()){
            System.out.println("No assets to remove");
            return;
        }
        viewAssets();
        System.out.print("Enter the number of the asset to remove: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if(index < 1 || index > assets.size()){
            System.out.println("invalid asset number");
            return;
        }
        assets.remove(index-1);
        System.out.println("Asset removed successfully.");
    }

}
