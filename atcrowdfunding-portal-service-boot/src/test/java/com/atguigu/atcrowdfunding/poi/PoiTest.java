package com.atguigu.atcrowdfunding.poi;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class PoiTest {
	

	public static void main(String[] args) {
		try {
			//测试数据：（再D盘下生成test.xls文件，并有多个sheet）
			OutputStream out = new FileOutputStream("D:\\test.xls");
			List<List<String>> data = new ArrayList<List<String>>();
			for (int i = 1; i < 5; i++) {
				List rowData = new ArrayList();
				rowData.add(String.valueOf(i));
				rowData.add("东霖柏鸿");
				data.add(rowData);
			}
			String[] headers = { "ID", "用户名" };
			ExportExcelUtils eeu = new ExportExcelUtils();
			HSSFWorkbook workbook = new HSSFWorkbook();
			eeu.exportExcel(workbook, 0, "上海", headers, data, out);
			eeu.exportExcel(workbook, 1, "深圳", headers, data, out);
			eeu.exportExcel(workbook, 2, "广州", headers, data, out);
			//原理就是将所有的数据一起写入，然后再关闭输入流。
			workbook.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
