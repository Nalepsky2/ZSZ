package com.zsz.utils;

import com.zsz.model.ERPSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    private static final String PATH= "src/main/resources/excel/allSystems.xlsx";

    public static List<ERPSystem> Reed() {
        final List<ERPSystem> systems = new ArrayList<ERPSystem>();

        try {
            final FileInputStream file = new FileInputStream(new File(PATH));
            final XSSFWorkbook workbook = new XSSFWorkbook(file);
            final XSSFSheet sheet = workbook.getSheetAt(0);

            sheet.removeRow(sheet.getRow(0));

            for (Row row : sheet) {
                if(isRowValid(row)){
                    final String name = row.getCell(0).getStringCellValue();
                    final Integer reviewCount = (int) row.getCell(1).getNumericCellValue();
                    final Double rating = Double.valueOf(row.getCell(2).getStringCellValue());
                    final Boolean mac = convertValueToBoolean(row.getCell(3).getStringCellValue());
                    final Boolean win = convertValueToBoolean(row.getCell(4).getStringCellValue());
                    final Boolean lin = convertValueToBoolean(row.getCell(5).getStringCellValue());
                    final Integer price = (int) row.getCell(6).getNumericCellValue();
                    final Boolean small = convertValueToBoolean(row.getCell(7).getStringCellValue());
                    final Boolean medium = convertValueToBoolean(row.getCell(8).getStringCellValue());
                    final Boolean large = convertValueToBoolean(row.getCell(9).getStringCellValue());

                    final ERPSystem system = new ERPSystem(name, reviewCount, rating, mac, win, lin, price, small, medium, large);

                    systems.add(system);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return systems;
    }

    private static Boolean isRowValid(Row row){
        for (Cell cell : row) {
            if (cell == null || cell.getCellType() == CellType.BLANK){
                return false;
            }
        }
        return true;
    }

    private static Boolean convertValueToBoolean(String s) {
        return s != null && !s.equals("nie") && !s.isEmpty();
    }
}
