import java.util.ArrayList;

public class MainClassTest {

    public static void main(String[] args) {
        // локальные файлы
        String fileIn = "P:\\УАС\\Холопкин\\Остатки МДЛП\\1_Сальск\\отгружен после 28 марта.txt";
        String fileOutXls = "P:\\УАС\\Холопкин\\Остатки МДЛП\\1_Сальск\\Отгружен_до_28_03_2021";
        ParserFile parser = new ParserFile(fileIn);
        ArrayList<StockItem> stockItems = parser.getItems();
        ExcellWriter.SaveData2File(fileOutXls, stockItems);
    }

}
