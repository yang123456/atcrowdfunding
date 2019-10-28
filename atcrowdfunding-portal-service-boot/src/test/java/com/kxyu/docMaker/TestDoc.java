package com.kxyu.docMaker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.RenderData;
import com.deepoove.poi.data.TableRenderData;
import com.deepoove.poi.data.TextRenderData;
import com.deepoove.poi.render.RenderAPI;

public class TestDoc {

	public static void main(String[] args) throws Exception {
		ArrayList<Object> ch_info = new ArrayList<>();
		File file = new File("C:\\Users\\ykx\\codes\\demo\\src\\main\\resources\\chemotherapeutics.txt");
		Map<String, Object> datas = new HashMap<String, Object>();
		List<RenderData> list = new ArrayList<RenderData>();
		list.add(new TextRenderData("FFD39B", "疾病"));
		list.add(new TextRenderData("FFD39B", "药物"));
		list.add(new TextRenderData("FFD39B", "基因"));
		list.add(new TextRenderData("FFD39B", "rs"));
		list.add(new TextRenderData("FFD39B", "证据等级"));
		list.add(new TextRenderData("FFD39B", "基因型"));
		list.add(new TextRenderData("FFD39B", "临床指导"));
		datas.put("name", "老王");
		datas.put("age", "80");
		datas.put("sex", "男");
		datas.put("table", list);
		ArrayList<Object> readChemotherapyData1 = ReaderLocalFiles.readChemotherapyData1(ch_info, file);
		TableRenderData tableRenderData = new TableRenderData(list, readChemotherapyData1,"no datas", 8600);

		// 读取模板，进行渲染
		XWPFTemplate doc = XWPFTemplate.create("D:/DATA/test121.docx");
		RenderAPI.render(doc, datas);

		// 输出渲染后的文件
		FileOutputStream out = new FileOutputStream("D:/DATA/output.docx");
		doc.write(out);
		out.flush();
		out.close();
	}
}
