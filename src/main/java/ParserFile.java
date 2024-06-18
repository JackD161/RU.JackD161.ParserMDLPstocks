import java.io.*;
import java.util.ArrayList;

public class ParserFile {
    private final ArrayList<StockItem> items;
    private final String fileName;
    int cnt = 0;

    public ParserFile(String fileName) {
        this.fileName = fileName;
        items = new ArrayList<>();
        readFile();
    }

    private void readFile() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            while (reader.ready()) {
                String sgtin = getString(reader);
                String mnn = getString(reader);
                String tradeName = getString(reader);
                String financeType = getString(reader);
                items.add(new StockItem(sgtin, mnn, tradeName, financeType));
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("Файл не обнаружен");
        }
        catch (IOException e) {
            System.err.println("Файл не готов для чтения");
        }
    }
    private String getString(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        if (line.isEmpty()) {
            cnt++;
            getString(reader);
        }
        else {
            return line;
        }
        return line;
    }

    public ArrayList<StockItem> getItems() {
        return items;
    }
    public int getCnt() {
        return cnt;
    }
}
