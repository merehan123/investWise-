/**
 * Zakat calculation strategy for cash assets.
 *This strategy calculates zakat as 2.5% of the total value of the cash asset,
 * following standard Islamic zakat principles.
 *Implements the {@link ZakatStrategy} interface as part of the Strategy design pattern,
 * allowing flexible application of zakat rules depending on asset type.
 */
public class ZakatOnCashStrategy implements ZakatStrategy {

    /**
     * Calculates zakat on a cash asset.
     *
     * @param asset the cash asset
     * @return the zakat amount, calculated as 2.5% of the asset's total value
     */
    @Override
    public double calculateZakat(Asset asset) {
        return asset.totalValue() * 0.025; // 2.5% for cash
    }
}
