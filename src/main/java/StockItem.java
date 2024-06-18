public class StockItem {
    private String sgtin; // SGTIN
    private String mnn; // МНН
    private String tradeName; // Торговое найменование
    private String financeType; // Тип финансирования

    public StockItem(String sgtin, String mnn, String tradeName, String financeType) {
        this.sgtin = sgtin;
        this.mnn = mnn;
        this.tradeName = tradeName;
        this.financeType = financeType;
    }
}
