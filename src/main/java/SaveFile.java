
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class SaveFile {

    public void writeExcel(List<Camper> camperList, String excelFilePath) throws IOException
    {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        int rowCount = 0;

        for (Camper camper : camperList) {
            Row row = sheet.createRow(++rowCount);
            writeCamper(camper, row);
        }

        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            workbook.write(outputStream);
        }
    }

    private void writeCamper(Camper camper, Row row) {
        Cell cell = row.createCell(1);
        cell.setCellValue(camper.getFirstName());

        cell = row.createCell(2);
        cell.setCellValue(camper.getLastName());

        cell = row.createCell(3);
        cell.setCellValue(camper.getSession());

        cell = row.createCell(4);
        cell.setCellValue(camper.getMoneyPaid());

        cell = row.createCell(5);
        cell.setCellValue(camper.getMoneyOwes());

        cell = row.createCell(6);
        cell.setCellValue(camper.getNotes());
    }


}


