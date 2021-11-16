package com.dai.common.utils.tools;

import com.dai.common.utils.excel.MZExcelUtils;
import com.dai.common.utils.gps.MZGpsUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FindGaoDeLocationByCityAndName {
    public static void main(String[] args) throws Exception {
        XSSFWorkbook new_workbook = new XSSFWorkbook();
        XSSFSheet new_sheet = new_workbook.createSheet("高德接口");

        Workbook workbook = MZExcelUtils.getWorkBookFromFile("D:\\JavaProjects\\Json\\file.xlsx");
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            XSSFRow new_row = new_sheet.createRow(new_sheet.getLastRowNum() + 1);
            for (Cell cell : row) {
                int cellIndex = cell.getColumnIndex();
                if (cell.getCellType() == CellType.BLANK) {
                    break;
                } else {
                    switch (cell.getCellType()) {
                        case STRING:
                            new_row.createCell(cellIndex).setCellValue(cell.getStringCellValue());
                            new_row.getCell(cellIndex).setCellType(CellType.STRING);
                            break;
                        case NUMERIC:
                            new_row.createCell(cellIndex).setCellValue(cell.getNumericCellValue());
                            new_row.getCell(cellIndex).setCellType(CellType.NUMERIC);
                            break;
                    }
                }
            }
            // 获取高德数据
            String city = row.getCell(0).getStringCellValue();
            String keyWord = row.getCell(2).getStringCellValue();
            String address = row.getCell(4).getStringCellValue();
            MZGpsUtils.GaoDePoi gaoDePoi = MZGpsUtils.getLocationFromGaoDeApiByKeywordAndCity(address + " " + keyWord, city);
            if (gaoDePoi != null && gaoDePoi.getPois().size() > 0) {
                MZGpsUtils.Pois poi = gaoDePoi.getPois().get(0);
                String gaodeCity = poi.getCityname();
                String gaodeRegion = poi.getAdname();
                String gaodename = poi.getName();
                String gaodeAddress = poi.getAddress();

                double gaodeLongitude = poi.getLongitude();
                double gaodeLatitude = poi.getLatitude();
                double jmtoolLongitude = row.getCell(5).getNumericCellValue();
                double jmtoolLatitude = row.getCell(6).getNumericCellValue();
                double distance = MZGpsUtils.getDistance(jmtoolLongitude, jmtoolLatitude, gaodeLongitude, gaodeLatitude);
                new_row.createCell(row.getLastCellNum() + 1).setCellValue(gaodeCity);
                new_row.createCell(row.getLastCellNum() + 2).setCellValue(gaodeRegion);
                new_row.createCell(row.getLastCellNum() + 3).setCellValue(gaodename);
                new_row.createCell(row.getLastCellNum() + 4).setCellValue(gaodeAddress);
                new_row.createCell(row.getLastCellNum() + 5).setCellValue(gaodeLongitude);
                new_row.createCell(row.getLastCellNum() + 6).setCellValue(gaodeLatitude);
                new_row.createCell(row.getLastCellNum() + 7).setCellValue(distance);
            }
        }
        MZExcelUtils.generateFile("D:\\JavaProjects\\mozi\\mozi-common\\mozi-common-utils\\src\\main\\java\\com\\dai\\common\\utils\\tools\\out.xlsx", new_workbook);
    }
}
