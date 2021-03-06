package com.atguigu.atcrowdfunding.poi;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;
 
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.Region;

import com.atguigu.atcrowdfunding.domain.User;
import com.google.common.collect.Lists;
 
/**数据导出Excel
 * 2018/9/10
 * @author
 *https://www.cnblogs.com/interesting-whh/p/11096930.html
 */
public class DataToExcel2 {
     
    private DataToExcel2(){}
     
    /**
     * 导出Excel
     * @param response 你懂的
     * @param excelFile Excel文件
     * @param fileName 导出的文件名
     */
    public static void export(HttpServletResponse response , HSSFWorkbook excelFile , String fileName) {
        //写入excel表
        response.reset();
        response.setContentType( "application/octet-stream;charset=GBK" );
        response.setCharacterEncoding("GBK");
        response.setHeader( "Content-Disposition", "attachment;filename=" + processExcelFilename(fileName) + ".xls" );
        try {
            excelFile.write(response.getOutputStream( ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    
   
    /**
     * 导出Excel
     * @param response 你懂的
     * @param fileName 导出的文件名
     * @param columnWidth 列宽
     * @param rowName 表头
     * @param dataList 数据以List<List<String>>组织
     */
    public static void export(HttpServletResponse response , String fileName , int columnWidth ,
            String sheetName , String[] rowName, List<List<String>> dataList){
        HSSFWorkbook excelFile = null;
        try {
            excelFile = toExcel(excelFile, sheetName, columnWidth, rowName, dataList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        export(response, excelFile, fileName);
    }
    /**
     * 导出Excel
     * @param response 你懂的
     * @param fileName 导出的文件名
     * @param columnWidth 列宽
     * @param rowName 表头
     * @param dataList 数据以List<List<String>>组织
     * @throws IOException 
     */
    public static void export(String fileName , int columnWidth ,
    		String sheetName , String[] rowName, List<List<String>> dataList) throws IOException{
    	HSSFWorkbook excelFile = null;
    	try {
    		excelFile = toExcel(excelFile, sheetName, columnWidth, rowName, dataList);
    	} catch (IOException e) {
    		throw new RuntimeException(e);
    	}
     	File file = new File("E:\\demo.xls");
 	    FileOutputStream fout = new FileOutputStream(file);
 	    excelFile.write(fout);
	    fout.close(); 
    }
     
 
    /**
     * 堆叠转换成Excel文件
     * @param excelFile 堆叠Excel文件，传null则新建
     * @param table Table
     * @param sheetName SheetName
     * @param columnWidth 列宽
     * @return 堆叠后的Excel文件
     * @throws IOException
     */
    public static HSSFWorkbook toExcel(HSSFWorkbook excelFile, String sheetName , int columnWidth
            , String[] rowName, List<List<String>> dataList) throws IOException{
        // 声明一个工作薄
        if (excelFile == null){
            excelFile = new HSSFWorkbook();
        }
        // 生成标题样式
        @SuppressWarnings("unused")
        HSSFCellStyle titleStyle = getTitleStyle( excelFile );
        // 生成标题行样式
        @SuppressWarnings("unused")
        HSSFCellStyle titleRowStyle = getRowTitleStyle( excelFile );
        // 生成数据样式
        HSSFCellStyle cellRowStyle = getCellStyle( excelFile );
        //高亮格式
        HSSFCellStyle styleLight = styleLight(excelFile);
         
        int sheetNum = (int)dataList.size()/40;
        if(dataList.size()%40!=0){
            sheetNum++;
        }
        System.out.println("sheetnum="+sheetNum);
        
        //合并单元格的例子
        //表头样式设置
//        HSSFRow row0 = sheet.createRow(0);
//        createMyCells(0,19,row0,titleRowStyle);
//        sheet.addMergedRegion(getMyRegion(0, 2, 0, 0));
//        addMyTitle(row0, 0, "跟进人名称");
//        sheet.addMergedRegion(getMyRegion(0, 2, 1, 1));
//        addMyTitle(row0, 1, "名义欠款金额合计");
//        sheet.addMergedRegion(getMyRegion(0, 0, 2, 7));
//        addMyTitle(row0, 2, "超期欠款");
//        sheet.addMergedRegion(getMyRegion(0, 0, 8, 13));
//        addMyTitle(row0, 8, "超期合同数量");
//        sheet.addMergedRegion(getMyRegion(0, 0, 14, 18));
//        addMyTitle(row0, 14, "超期欠款合同数量");
//         
//        HSSFRow row1 = sheet.createRow(1);
//        createMyCells(0,19,row1,titleRowStyle);
//        sheet.addMergedRegion(getMyRegion(1, 2, 2, 2));
//        addMyTitle(row1, 2, "超期欠款金额合计");
//        sheet.addMergedRegion(getMyRegion(1, 1, 3, 7));
//        addMyTitle(row1, 3, "超期时间/月");
//        sheet.addMergedRegion(getMyRegion(1, 2, 8, 8));
//        addMyTitle(row1, 8, "超期合同数量合计");
//        sheet.addMergedRegion(getMyRegion(1, 1, 9, 13));
//        addMyTitle(row1, 9, "超期时间/月");
//        sheet.addMergedRegion(getMyRegion(1, 2, 14, 14));
//        addMyTitle(row1, 14, "1万以下");
//        sheet.addMergedRegion(getMyRegion(1, 2, 15, 15));
//        addMyTitle(row1, 15, "1万至5万");
//        sheet.addMergedRegion(getMyRegion(1, 2, 16, 16));
//        addMyTitle(row1, 16, "5万至10万");
//        sheet.addMergedRegion(getMyRegion(1, 2, 17, 17));
//        addMyTitle(row1, 17, "10万至30万");
//        sheet.addMergedRegion(getMyRegion(1, 2, 18, 18));
//        addMyTitle(row1, 18, "30万以上");
//        
        for(int k = 0; k < sheetNum; k++){
            //创建一个sheet
            HSSFSheet sheet = excelFile.createSheet();
//            excelFile.setSheetName(excelFile.getNumberOfSheets() - 1, sheetName+k+"",(short)1);
            excelFile.setSheetName(excelFile.getNumberOfSheets() - 1, sheetName+k+"");
            sheet.setDefaultColumnWidth((short) (columnWidth));
            //Build Excel
            if(rowName!=null && rowName.length>0) {
                //设置表头
                int columnNum = rowName.length;
                HSSFRow rowRowName = sheet.createRow(0);                // 在索引0的位置创建行
                 
                // 将列头设置到sheet的单元格中
                for(int n=0;n<columnNum;n++){
                    HSSFCell  cellRowName = rowRowName.createCell((short)n);//创建列头对应个数的单元格
                    cellRowName.setCellType( HSSFCell.CELL_TYPE_STRING );
                    cellRowName.setCellValue(rowName[n]);//设置列头单元格的值
                    cellRowName.setCellStyle(titleRowStyle);
                }
            }
            
            System.out.println(k);
            int fromIndex=k*40;
            int toIndex=(k+1)*40;
            if(toIndex>dataList.size()) {
            	toIndex=dataList.size();
            }
            List<List<String>> subList = dataList.subList(fromIndex,toIndex);
            System.out.println("szie="+subList.size());
            System.out.println("fromIndex="+fromIndex);
            System.out.println("toIndex="+toIndex);
            
            
            int rowIndex = 1;
            for(int index = 0; index < subList.size(); index++){
                List<String> dl = subList.get(index);
                System.out.println(dl);
                HSSFRow row = sheet.createRow(rowIndex);
                HSSFCellStyle cellstyle = cellRowStyle;
                if(rowIndex%2==1){
                    cellstyle = styleLight;
                }
                for(int i = 0; i < dl.size(); i++) {
                    addCell_whh(row, cellstyle,  dl.get(i), i);
                }
                rowIndex++;
            }
        }
        return excelFile;
    }
     
    private static Region getMyRegion(int rf,int rt,int cf,int ct){
        Region region = new Region();
        region.setRowFrom(rf);
        region.setRowTo(rt);
        region.setColumnFrom((short) cf);
        region.setColumnTo((short) ct);
        return region;
    }
    private static void createMyCells(int from,int to,HSSFRow rowRowName, HSSFCellStyle titleRowStyle){
        for(int i = from; i < to; i++){
            HSSFCell  cellRowName = rowRowName.createCell((short)i);
//            cellRowName.setEncoding( HSSFCell.ENCODING_UTF_16 );
            cellRowName.setCellType( HSSFCell.CELL_TYPE_STRING );
            cellRowName.setCellStyle(titleRowStyle);
        }
    }
     
    public static void addCell_whh(HSSFRow row, HSSFCellStyle cellstyle,  String text, int n){
        HSSFCell cell = row.createCell((short)n);
        cell.setCellStyle(cellstyle);
//        cell.setEncoding( HSSFCell.ENCODING_UTF_16 );
        cell.setCellType( HSSFCell.CELL_TYPE_STRING );
        cell.setCellValue(text);
    }
     
    /**
     * 生成标题样式
     * @param workbook
     * @return
     */
    public static HSSFCellStyle getTitleStyle(HSSFWorkbook workbook){
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.LIGHT_ORANGE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
         
        style.setBottomBorderColor(HSSFColor.GREY_50_PERCENT.index);
        style.setRightBorderColor(HSSFColor.GREY_50_PERCENT.index);
        style.setLeftBorderColor(HSSFColor.GREY_50_PERCENT.index);
        style.setTopBorderColor(HSSFColor.GREY_50_PERCENT.index);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.VIOLET.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);
         
        return style;
    }
     
    /**
     * 生成行标题样式
     * @param workbook
     * @return
     */
    public static HSSFCellStyle getRowTitleStyle(HSSFWorkbook workbook){
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.LIGHT_ORANGE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
         
        style.setBottomBorderColor(HSSFColor.GREY_50_PERCENT.index);
        style.setRightBorderColor(HSSFColor.GREY_50_PERCENT.index);
        style.setLeftBorderColor(HSSFColor.GREY_50_PERCENT.index);
        style.setTopBorderColor(HSSFColor.GREY_50_PERCENT.index);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
//        font.setColor(HSSFColor.VIOLET.index);
        font.setFontHeightInPoints((short) 10);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);
         
        return style;
    }
     
    /**
     * 生成数据样式
     * @param workbook
     * @return
     */
    public static HSSFCellStyle getCellStyle(HSSFWorkbook workbook){
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(HSSFColor.WHITE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
         
        style.setBottomBorderColor(HSSFColor.GREY_50_PERCENT.index);
        style.setRightBorderColor(HSSFColor.GREY_50_PERCENT.index);
        style.setLeftBorderColor(HSSFColor.GREY_50_PERCENT.index);
        style.setTopBorderColor(HSSFColor.GREY_50_PERCENT.index);
        // 生成另一个字体
        HSSFFont font = workbook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式
        style.setFont(font);
         
        return style;
    }
     
    /**
     * 高亮格式
     * @param workbook
     * @return
     */
    public static HSSFCellStyle styleLight(HSSFWorkbook workbook){
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
        //HSSFColor.SKY_BLUE;
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
         
        style.setBottomBorderColor(HSSFColor.GREY_50_PERCENT.index);
        style.setRightBorderColor(HSSFColor.GREY_50_PERCENT.index);
        style.setLeftBorderColor(HSSFColor.GREY_50_PERCENT.index);
        style.setTopBorderColor(HSSFColor.GREY_50_PERCENT.index);
        // 生成另一个字体
        HSSFFont font = workbook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式
        style.setFont(font);
         
        return style;
    }
     
    /**
     * 预处理导出文件名
     * @param str
     * @return
     */
    public static String processExcelFilename(String str){
        try {
            return java.net.URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "No Name";
    }
     
    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
    	DataToExcel2 dataToExcel=new DataToExcel2();
    	//测试数据：（再D盘下生成test.xls文件，并有多个sheet）
    	 File file = new File("E:\\demo.xls");
        List<List<String>> dataList = new ArrayList<List<String>>();
        List<String> list = Lists.newArrayList();
        
        List<User> queryList = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            User user1=new User(i, "编号00"+i, i);
            queryList.add(user1);
		}
        
        for (int i = 0; i < queryList.size(); i++) {
			List rowData = new ArrayList();
			rowData.add(queryList.get(i).getId()+"");
			rowData.add(queryList.get(i).getName()+"");
			rowData.add(queryList.get(i).getAge()+"");
			dataList.add(rowData);
		}
        
//        for (int i = 1; i < 50; i++) {
//
//			List rowData = new ArrayList();
//			rowData.add(String.valueOf(i));
//			rowData.add("编号00"+i);
//			rowData.add("东霖柏鸿"+i);
//			dataList.add(rowData);
//		}
        
        
        dataList.add(list);
        String [] headers= {"id","编号","姓名"};
        dataToExcel.export("safasf", 30, "用户信息", headers, dataList);
    }
 
}