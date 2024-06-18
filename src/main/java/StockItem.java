public class StockItem {
    private final String sgtin; // SGTIN
    private final String mnn; // МНН
    private final String tradeName; // Торговое найменование
    private final String financeType; // Тип финансирования

    public StockItem(String sgtin, String mnn, String tradeName, String financeType) {
        this.sgtin = sgtin;
        this.mnn = mnn;
        this.tradeName = tradeName;
        this.financeType = financeType;
    }

    public String getSgtin() {
        return sgtin;
    }

    public String getMnn() {
        return mnn;
    }

    public String getTradeName() {
        return tradeName;
    }

    public String getFinanceType() {
        return financeType;
    }
}
