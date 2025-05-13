/**
 * Strategy interface for calculating zakat on different types of assets.
 * Implementations of this interface provide specific zakat calculation
 * logic for various asset types such as stocks, gold, or cash.
 */
public interface ZakatStrategy {

    /**
     * Calculates zakat for a given asset.
     *
     * @param asset the asset to calculate zakat on
     * @return the calculated zakat amount
     */
    double calculateZakat(Asset asset);
}
