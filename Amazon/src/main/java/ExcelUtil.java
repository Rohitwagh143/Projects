    import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtil {
    public static String read_excel() throws IOException {
        String path="C:\\Users\\91978\\Desktop\\data1.xlsx";
        FileInputStream fis =new FileInputStream(path);
        Workbook wb = new XSSFWorkbook(fis) ;//.xlsx
        Sheet sheet1=wb.getSheetAt(0);//select the particular sheet index(starting from 0)

        Row row=sheet1.getRow(0);
        Cell cell=row.getCell(0);
        String data=cell.getStringCellValue();
        return data;
    }
}
