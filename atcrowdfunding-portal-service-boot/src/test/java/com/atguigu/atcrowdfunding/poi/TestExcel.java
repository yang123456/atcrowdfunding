package com.atguigu.atcrowdfunding.poi;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

public class TestExcel {

    public static void main(String[] args) throws IOException {

        HSSFWorkbook workbook = new HSSFWorkbook();

        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        HSSFSheet sheet = workbook.createSheet("sheet");

        HSSFRow row0 = sheet.createRow(0);
        HSSFCell cell_00 = row0.createCell(0);
        cell_00.setCellStyle(style);
        cell_00.setCellValue("日期");
        
        
        
        HSSFCell cell_01 = row0.createCell(1);
        cell_01.setCellStyle(style);
        cell_01.setCellValue("午别");

        
        CellRangeAddress region = new CellRangeAddress(0, 0, 0, 1);
        sheet.addMergedRegion(region);
        
        HSSFRow row1 = sheet.createRow(1);
        HSSFCell cell_10 = row1.createCell(0);
        cell_10.setCellStyle(style);
        cell_10.setCellValue("20180412");
        HSSFCell cell_11 = row1.createCell(1);
        cell_11.setCellStyle(style);
        cell_11.setCellValue("上午");

        HSSFRow row2 = sheet.createRow(2);
        HSSFCell cell_21 = row2.createCell(1);
        cell_21.setCellStyle(style);
        cell_21.setCellValue("下午");

        // 合并日期占两行(4个参数，分别为起始行，结束行，起始列，结束列)
        // 行和列都是从0开始计数，且起始结束都会合并
        // 这里是合并excel中日期的两行为一行
//        CellRangeAddress region = new CellRangeAddress(1, 2, 0, 0);
      

        File file = new File("E:\\demo.xls");
        FileOutputStream fout = new FileOutputStream(file);
        workbook.write(fout);
        fout.close();
    }

}
