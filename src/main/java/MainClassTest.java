import java.util.ArrayList;

public class MainClassTest {

    public static void main(String[] args) {
        // локальные файлы
        String fileIn = "P:\\УАС\\Холопкин\\Остатки МДЛП\\ФД\\СОБРАНО\\16_Республика Крым, г.о. Феодосия, г Феодосия, б-р Старшинова, д. 8\\отгружено после.txt";
        String fileOutXls = "P:\\УАС\\Холопкин\\Остатки МДЛП\\ФД\\СОБРАНО\\16_Республика Крым, г.о. Феодосия, г Феодосия, б-р Старшинова, д. 8\\Отгружено_после_28_03_2021";
        ParserFile parser = new ParserFile(fileIn);
        ArrayList<StockItem> stockItems = parser.getItems();
        ExcellWriter.SaveData2File(fileOutXls, stockItems);
    }
}
