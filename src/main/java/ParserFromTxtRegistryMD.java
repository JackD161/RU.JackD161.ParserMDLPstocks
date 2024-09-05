import java.util.ArrayList;

public class ParserFromTxtRegistryMD {

    public static void main(String[] args) {
        // локальные файлы
//        String fileIn = "P:\\УАС\\Холопкин\\Остатки МДЛП\\ФД\\СОБРАНО\\16_Республика Крым, г.о. Феодосия, г Феодосия, б-р Старшинова, д. 8\\отгружено после.txt";
//        String fileOutXls = "P:\\УАС\\Холопкин\\Остатки МДЛП\\ФД\\СОБРАНО\\16_Республика Крым, г.о. Феодосия, г Феодосия, б-р Старшинова, д. 8\\Отгружено_после_28_03_2021";
//        ParserFile4TxtRegistryMD parser = new ParserFile4TxtRegistryMD(fileIn, 1);
//        ArrayList<StockItem> stockItems = parser.getItems();
//        ExcellWriter.SaveData2File(fileOutXls, stockItems);
        String fileIn = "C:\\Users\\Batman\\Downloads\\RegistryAll.csv";
        String fileOutXls = "C:\\Users\\Batman\\Downloads\\RegistryAll";
        ParserFile4TxtRegistryMD parser = new ParserFile4TxtRegistryMD(fileIn, 2);
        ArrayList<StockItem> stockItems = parser.getItems();
        ExcellWriter.SaveData2File(fileOutXls, stockItems);
    }
}
