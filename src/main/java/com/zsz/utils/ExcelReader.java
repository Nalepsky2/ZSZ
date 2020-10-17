package com.zsz.utils;

import com.zsz.model.AllERPSystem;
import com.zsz.model.TopERPSystem;
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
    private static final String PATH_ALL = "src/main/resources/excel/allSystems.xlsx";
    private static final String PATH_TOP= "src/main/resources/excel/topSystems.xlsx";

    public static List<AllERPSystem> Reed() {
        final List<AllERPSystem> systems = new ArrayList<>();

        try {
            final FileInputStream file = new FileInputStream(new File(PATH_ALL));
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

                    final AllERPSystem system = new AllERPSystem(name, reviewCount, rating, mac, win, lin, price, small, medium, large);

                    systems.add(system);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return systems;
    }

    public static List<TopERPSystem> ReedTop() {
        final List<TopERPSystem> systems = new ArrayList<>();

        try {
            final FileInputStream file = new FileInputStream(new File(PATH_TOP));
            final XSSFWorkbook workbook = new XSSFWorkbook(file);
            final XSSFSheet sheet = workbook.getSheetAt(0);

            sheet.removeRow(sheet.getRow(0));

            for (Row row : sheet) {
                if(isRowValid(row)){
                    final String name = row.getCell(0).getStringCellValue();
                    final Double easeOfUse = row.getCell(1).getNumericCellValue();
                    final Double ValueForMoney = row.getCell(2).getNumericCellValue();
                    final Double CustomerSupport = row.getCell(3).getNumericCellValue();
                    final Double Functionality = row.getCell(4).getNumericCellValue();

                    final TopERPSystem system = new TopERPSystem(name, easeOfUse, ValueForMoney, CustomerSupport, Functionality);

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
