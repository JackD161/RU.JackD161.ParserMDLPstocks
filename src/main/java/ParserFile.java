import java.io.*;
import java.util.ArrayList;

public class ParserFile {
    private final ArrayList<StockItem> items;
    private final ArrayList<String> lines;
    private final String fileName;

    public ParserFile(String fileName) {
        this.fileName = fileName;
        items = new ArrayList<>();
        lines = new ArrayList<>();
        readFile();
        clear(lines);
        infillStockItems();
    }

    private void readFile() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            while(reader.ready()) {
            lines.add(reader.readLine());
            }
            }
        catch (FileNotFoundException e) {
            System.err.println("Файл не обнаружен");
        }
        catch (IOException e) {
            System.err.println("Файл не готов для чтения");
        }
    }
    private void clear(ArrayList<String> lines) {
        lines.removeIf(String::isEmpty);
    }
    private String getString(ArrayList<String> lines) {
        String string = lines.get(0);
        lines.remove(0);
        return string;
    }
    private void infillStockItems() {
        while (!lines.isEmpty()) {
            String sgtin = getString(lines);
            String mnn = getString(lines);
            String tradeName = getString(lines);
            String financeType = getString(lines);
            String seria = getString(lines);
            String expireDate = getString(lines);
            items.add(new StockItem(sgtin, mnn, tradeName, financeType, seria, expireDate));
        }
    }
    public ArrayList<StockItem> getItems() {
        return items;
    }
}
