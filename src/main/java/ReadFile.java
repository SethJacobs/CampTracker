

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class ReadFile{

    private Object getCellValue(Cell cell) {
       // switch (cell.getCellType()) {
        //    case Cell.CELL_TYPE_STRING:
        //        return cell.getStringCellValue();

         //   case Cell.CELL_TYPE_BOOLEAN:
         //       return cell.getBooleanCellValue();
//
          //  case Cell.CELL_TYPE_NUMERIC:
           //     return cell.getNumericCellValue();

       // }
        if(cell.getCellType()== CellType.STRING)
        {
            return cell.getStringCellValue();
        }
        if(cell.getCellType()==CellType.BOOLEAN)
        {
            return cell.getBooleanCellValue();
        }
        if(cell.getCellType()==CellType.NUMERIC)
        {
            return cell.getNumericCellValue();
        }

        return null;
    }


    public LinkedList<Camper> readCamperFromExcelFile(String excelFilePath) throws IOException {
        LinkedList<Camper> listCampers = new LinkedList<Camper>();
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        Workbook workbook = new HSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();

        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            Camper aCamper = new Camper();

            while (cellIterator.hasNext()) {
                Cell nextCell = cellIterator.next();
                int columnIndex = nextCell.getColumnIndex();

                switch (columnIndex) {
                    case 1:
                        aCamper.setFirstName((String) getCellValue(nextCell));
                        break;
                    case 2:
                        aCamper.setLastName((String) getCellValue(nextCell));
                        break;
                    case 3:
                        aCamper.setSession((String) getCellValue(nextCell));
                        break;
                    case 4:
                        aCamper.setMoneyPaid((double)getCellValue(nextCell));
                        break;
                    case 5:
                        aCamper.setMoneyOwes((double)getCellValue(nextCell));
                        break;
                    case 6:
                        aCamper.setNotes((String) getCellValue(nextCell));


                }


            }
            listCampers.add(aCamper);
        }

        workbook.close();
        inputStream.close();

        return listCampers;
    }
}