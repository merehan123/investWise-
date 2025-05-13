/**
 * Zakat calculation strategy for stock assets.
 *
 * <p>This class provides an implementation of the {@link ZakatStrategy} interface
 * specifically for calculating zakat on stocks.</p>
 *
 * <p>Zakat is calculated as 2.5% of the total value of the stocks,
 * in accordance with common Islamic finance principles.</p>
 *
 * <p>Used as part of the Strategy design pattern to allow flexible calculation
 * for different types of assets.</p>
 */
public class ZakatOnStocksStrategy implements ZakatStrategy {

    /**
     * Calculates zakat on a stock asset.
     *
     * @param asset the stock asset
     * @return the zakat amount, calculated as 2.5% of the asset's total value
     */
    @Override
    public double calculateZakat(Asset asset) {
        return asset.totalValue() * 0.025; // 2.5% for stocks
    }
}
