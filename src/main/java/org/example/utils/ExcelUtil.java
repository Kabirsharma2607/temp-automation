package org.example.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtil {

    private Workbook workbook;
    private Sheet sheet;

    public ExcelUtil(String filePath, String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheet(sheetName);
    }

    public String getCellValueByColumnName(int rowIndex, String columnName) {
        Row headerRow = sheet.getRow(0); // Assuming the first row is the header
        Map<String, Integer> columnMap = new HashMap<>();

        for (Cell cell : headerRow) {
            columnMap.put(cell.getStringCellValue().trim(), cell.getColumnIndex());
        }

        Integer columnIndex = columnMap.get(columnName);
        if (columnIndex == null) {
            throw new IllegalArgumentException("Column '" + columnName + "' not found in the Excel sheet.");
        }

        Row row = sheet.getRow(rowIndex);
        if (row == null) {
            throw new IllegalArgumentException("Row " + rowIndex + " does not exist in the Excel sheet.");
        }

        Cell cell = row.getCell(columnIndex);
        return getCellValue(cell);
    }


    private String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "";
        }
    }


    public void close() throws IOException {
        workbook.close();
    }
}
