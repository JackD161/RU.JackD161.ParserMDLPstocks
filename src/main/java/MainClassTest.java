import java.io.*;
import java.util.ArrayList;

public class MainClassTest {

    public static void main(String[] args) {
        // локальные файлы
        String fileIn = "C:\\Users\\holop\\IdeaProjects\\ru.JackD161.ParserMDLPstocks\\tmp\\stock922.txt";
        String fileOut = "C:\\Users\\holop\\IdeaProjects\\ru.JackD161.ParserMDLPstocks\\tmp\\stock922_out.csv";
        String fileOutXls = "C:\\Users\\holop\\IdeaProjects\\ru.JackD161.ParserMDLPstocks\\tmp\\stock922_out";
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
