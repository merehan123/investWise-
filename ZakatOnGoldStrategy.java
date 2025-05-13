/**
 * Zakat calculation strategy for gold assets.
 * This strategy calculates zakat as 2.5% of the total value of the gold asset,
 * in accordance with common zakat rules for precious metals.
 *Implements the {@link ZakatStrategy} interface as part of the Strategy design pattern.
 */
public class ZakatOnGoldStrategy implements ZakatStrategy {

    /**
     * Calculates zakat on a gold asset.
     *
     * @param asset the gold asset
     * @return the zakat amount, calculated as 2.5% of the asset's total value
     */
    @Override
    public double calculateZakat(Asset asset) {
        return asset.totalValue() * 0.025; // 2.5% for gold
    }
}
