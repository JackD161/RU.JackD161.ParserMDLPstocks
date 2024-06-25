import java.io.*;
import java.util.ArrayList;

public class MainClassTest {

    public static void main(String[] args) {
        // локальные файлы
        String fileIn = "P:\\УАС\\Холопкин\\Остатки МДЛП\\Склад\\В обороте до 28 03 2021.txt";
        String fileOut = "~\\IdeaProjects\\ru.JackD161.ParserMDLPstocks\\tmp\\stock922_out.csv";
        String fileOutXls = "P:\\УАС\\Холопкин\\Остатки МДЛП\\Склад\\В_обороте_до_28_03_2021";
        ParserFile parser = new ParserFile(fileIn);
        ArrayList<StockItem> stockItems = parser.getItems();
        ExcellWriter.SaveData2File(fileOutXls, stockItems);
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileOut)));
            for (StockItem item : stockItems) {
            String out = item.getSgtin() + "\t" + item.getMnn() + "\t" + item.getTradeName() + "\t" + item.getFinanceType() + "\n";
            writer.write(out);
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("Файл не найден для записи");
        }
        catch (IOException e) {
            System.err.println("Ошибка записи файла");
        }
    }

}
