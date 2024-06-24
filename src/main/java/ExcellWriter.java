import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcellWriter {

        public static void SaveData2File(String fileName, ArrayList<StockItem> items) {
            try
            {
                XSSFWorkbook workbook = new XSSFWorkbook();
                Sheet sheet = workbook.createSheet("Stocks");
                Row title = sheet.createRow(0);
                title.createCell(0).setCellValue("SGTIN");
                title.createCell(1).setCellValue("МНН");
                title.createCell(2).setCellValue("Торговое название");
                title.createCell(3).setCellValue("Тип финансирования");
                for (int rows = 1; rows <= items.size(); rows++) {
                    Row row = sheet.createRow(rows);
                    StockItem item = items.get(rows - 1);
                    row.createCell(0).setCellValue(item.getSgtin());
                    row.createCell(1).setCellValue(item.getMnn());
                    row.createCell(2).setCellValue(item.getTradeName());
                    row.createCell(3).setCellValue(item.getFinanceType());
                }
                try (FileOutputStream out = new FileOutputStream(fileName + ".xlsx")) {
                    workbook.write(out);
                }  // Работа с файлом завершена, он закрыт
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
