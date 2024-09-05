import java.io.*;
import java.util.ArrayList;

public class ParserFile4TxtRegistryMD {
    private final ArrayList<StockItem> items;
    private final ArrayList<String> lines;
    private final String fileName;

    public ParserFile4TxtRegistryMD(String fileName, int i) {
        this.fileName = fileName;
        items = new ArrayList<>();
        lines = new ArrayList<>();
        readFile();
        clear();
        if (i == 1) {
            infillStockItemsFromTxtRegistryMD();
        }
        else {
            infillStockItemsFromTxtRegistryGlobal();
        }
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
    private void clear() {
        lines.removeIf(String::isEmpty);
    }
    private String getString() {
        String string = lines.get(0);
        lines.remove(0);
        return string;
    }
    private void infillStockItemsFromTxtRegistryMD() {
        while (!lines.isEmpty()) {
            items.add(new StockItem(getString(), getString(), getString(), getString(), getString(), getString()));
        }
    }
    private void infillStockItemsFromTxtRegistryGlobal() {
        while (!lines.isEmpty()) {
            String[] str = getString().split(",");
            items.add(new StockItem(str[0].replaceAll("\"", ""), str[5].replaceAll("\"", ""), str[3].replaceAll("\"", ""), str[1].replaceAll("\"", ""), str[2].replaceAll("\"", ""), getTypeFinans(str[6].replaceAll("\"", "")), getNameFromMD(str[4].replaceAll("\"", ""))));
        }
    }
    private String getTypeFinans(String str) {
        return switch(str) {
            case "1" -> "Собственные средства";
            case "2" -> "Средства федерального бюджета";
            case "3" -> "Средства регионального бюджета";
            default -> "Неизвестно";
        };
    }
    private String getNameFromMD(String str) {
        return switch(str) {
            case("00000000518234") -> "Аптека_1_ФД";
            case("00000000492594") -> "Аптека_2_ФД";
            case("00000000492593") -> "Аптека_3_ФД";
            case("00000000492592") -> "Аптека_4_ФД";
            case("00000000510776") -> "Аптечный_пункт_6_ФД";
            case("00000000509782") -> "Аптечный_пункт_8_ФД";
            case("00000000498942") -> "Аптека_11_ФД";
            case("00000000499920") -> "Аптека_12_ФД";
            case("00000000509978") -> "Аптека_13_ФД";
            case("00000000509370") -> "Аптечный_пункт_14_ФД";
            case("00000000501763") -> "Аптека_15_ФД";
            case("00000000508757") -> "Аптечный_пункт_17_ФД";
            case("00000000511413") -> "Аптека_18_ФД";
            case("00000000511414") -> "Аптечный_пункт_20_ФД";
            case("00000000513160") -> "Аптека_21_ФД";
            case("00000000537762") -> "Аптека_22_ФД";
            case("00000000517118") -> "Аптека_25_ФД";
            case("00000000519248") -> "Аптека_70_ФД";
            case("00000000154088") -> "Аптечный_пункт_1_Аптеки_70_Ф";
            case("00000000154089") -> "Аптечный_пункт_2_Аптеки_74_Ф";
            case("00000000142319") -> "Аптечный_пункт_2_Ремонтное_Ф";
            case("00000000142314") -> "Аптека_70_Ф";
            case("00000000109663") -> "Аптека_75_Ф";
            case("00000000109738") -> "Аптека_78_Ф";
            case("00000000154090") -> "Аптека_81_Ф";
            case("00000000154351") -> "Аптека_82_Ф";
            case("00000000109704") -> "Аптека_86_Ф";
            case("00000000142322") -> "Аптека_92_Ф";
            case("00000000142325") -> "Аптека_94_Ф";
            case("00000000154085") -> "Аптека_95_Ф";
            case("00000000170327") -> "Аптека_96_Ф";
            case("00000000225100") -> "Аптека_97_ф";
            case("00000000224937") -> "Аптека_99_Ф";
            case("00000000154093") -> "Аптека_185_Ф";
            case("00000000109696") -> "Аптека_197_OLD_Ф";
            case("00000000477626") -> "Аптека_197_NEW_Ф";
            case("00000000276434") -> "Аптека_222_Ф";
            case("00000000154339") -> "Аптека_225_Ф";
            case("00000000109693") -> "Аптека_231_Ф";
            case("00000000154342") -> "Аптека_271_Ф";
            case("00000000154344") -> "Аптека_300_Ф";
            case("00000000451104") -> "Аптечный_пункт_321_Ф";
            case("00000000109737") -> "Аптека_334_Ф";
            case("00000000154345") -> "Аптека_345_Ф";
            case("00000000451108") -> "Аптека_361_Ф";
            case("00000000154347") -> "Аптека_406_Ф";
            case("00000000451107") -> "Аптека_501_Ф";
            case("00000000474192") -> "Аптека_721_Ф";
            case("00000000451106") -> "Аптека_922_Ф";
            case("00000000520889") -> "Склад_Фармация_Дона";
            case("00000000109665") -> "Склад_Фармация";
            default -> str;
        };
    }
    public ArrayList<StockItem> getItems() {
        return items;
    }
}
