package com.dai.common.utils.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MZExcelUtils {
    public static Workbook getWorkBookFromFile(File file) throws IOException {
        return WorkbookFactory.create(file);
    }

    public static Workbook getWorkBookFromFile(String filePath) throws IOException {
        return WorkbookFactory.create(new File(filePath));
    }

    public static Sheet getFirstSheet(Workbook workbook) {
        return workbook.getSheetAt(0);
    }

    public static List<String> getHeaders(Workbook workbook) {
        List<String> headers = new LinkedList<>();
        Row firstRow = workbook.getSheetAt(0).getRow(0);
        for (Cell cell : firstRow) {
            headers.add(cell.getStringCellValue());
        }
        return headers;
    }

    //TODO 判断如果有空单元格把表头分开了，需不需要列出来tips: 通过trim处理单元格然后与“”对比
    public static List<String> getHeaders(Workbook workbook, int sheetNum) {
        List<String> headers = new LinkedList<>();
        Row firstRow = workbook.getSheetAt(sheetNum).getRow(0);
        for (Cell cell : firstRow) {
            headers.add(cell.getStringCellValue());
        }
        return headers;
    }

    public static String getCellValue(Cell cell) {
        if (cell.getCellType().equals(CellType.STRING)) {
            return cell.getStringCellValue();
        } else if (cell.getCellType().equals(CellType.BLANK)) {
            return "";
        } else {
            return cell.getNumericCellValue() + "";
        }
    }

    public static void generateFile(String filePath, XSSFWorkbook outputWorkbook) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(filePath);
        outputWorkbook.write(outputStream);
        System.out.println("==================" + outputWorkbook + "文件生成完毕==================");
        outputStream.close();
    }
}
