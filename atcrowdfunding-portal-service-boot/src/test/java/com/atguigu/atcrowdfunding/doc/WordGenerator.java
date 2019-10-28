package com.atguigu.atcrowdfunding.doc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
 
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ClassUtils;
 
import freemarker.template.Configuration;
import freemarker.template.Template;
 
/**
 * word模板工具类
* <p>Title: WordGenerator</p>  
* <p>Description: </p>  
* @author terry.peng
 */
public class WordGenerator { 
	
	
	public static void main(String[] args) throws Exception {
		//获得数据，系统相关，就不展示了，下面写死一些数据为例  
        Map<String, Object> map = new HashMap<String, Object>();//将对象存入map中
        map.put("meetingTitle","会议标题");  
        map.put("username","会议发起人");
        map.put("takeParkIn","参会人员");
        map.put("allSummary","概要");
        map.put("duration","会议持续时间");
        map.put("place","会议地点");
        map.put("content","会议内容"); 
        createDoc(null, null, map, "销售合同.doc", "testRS.ftl");
	}
	
	
	
	
	
	private static Configuration configuration=null; 
	//private static final String templateFolder = WordGenerator.class.getClass().getResource("").getPath()+"/ftl/";  
	//private static final String templateFolder = WordGenerator.class.getClass().getResource("/" + ClassUtils.convertClassNameToResourcePath(WordGenerator.class.getPackage().getName())).getFile() + "/ftl";
	private static final String templateFolder = "D:/ftl";
	static{ 
		configuration=new Configuration(); 
		configuration.setDefaultEncoding("utf-8"); 
		try { 
			configuration.setDirectoryForTemplateLoading(new File(templateFolder));
		} catch (IOException e) { 
			e.printStackTrace();//throw new RuntimeException(e); 
		} 
	} 
	
	private WordGenerator() { 
		throw new AssertionError(); 
	} 
	
	/**
	 * 下载合同
	 * @param map 要填充的数据模型
	 * @param docName 下载保存的名称(例如：销售合同.doc)
	 * @param ftlFile ftl模板名称(例如：sellerContract.ftl)
	 * @throws Exception
	 */
	public static void downContract(HttpServletRequest request, HttpServletResponse response, Map<?, ?> map,String docName,String ftlFile) throws Exception {  
		File file = null;  
		FileInputStream fin = null;  
        ServletOutputStream out = null;  
        try {
        	setDownloadHeader(request, response, docName);//设置下载头
	        
	        // 调用工具类的createDoc方法生成Word文档  
	        file = createDoc(request,response,map,docName,ftlFile);  
	        fin = new FileInputStream(file.getAbsolutePath());  
	        out = response.getOutputStream();  
	        int len = 0;
			byte[] buf = new byte[1024];
			while ((len = fin.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
			out.flush();
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			throw new Exception(e.getMessage(), e);
        } finally {  
            if(fin != null) {
            	try {
					fin.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
            }  
            if(out != null) {
            	 try {
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				} 
            } 
            if(file != null) {
            	try {
					file.delete();// 删除临时文件  
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }  
        }  
    }
	
	/**
	 * 导入ftl并创建doc 
	 * @param request
	 * @param response
	 * @param dataMap
	 * @param docName
	 * @param ftlFile
	 * @return
	 * @throws IOException
	 */
	public static File createDoc(HttpServletRequest request, HttpServletResponse response,Map<?, ?> dataMap, String docName,String ftlFile) throws IOException { 
		Template template = configuration.getTemplate(ftlFile);
		String name = templateFolder + File.separator + (int) (Math.random() * 100000) + docName; 
		File file = new File(name); 
		try { // 这个地方不能使用FileWriter因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开 
			Writer writer = new OutputStreamWriter(new FileOutputStream(file), "utf-8"); 
			template.process(dataMap, writer); 
			// 关闭流
			writer.flush();
			writer.close(); 
		} catch (Exception ex) { 
			ex.printStackTrace();
		} 
		return file; 
	} 
	
	/** object转map
	 * <p>Title: objectToMap</p>  
	 * <p>Description: </p>  
	 * @param obj
	 * @return
	 */
	public static Map<?, ?> objectToMap(Object obj) {
	    if (obj == null) {
	      return null;
	    }
	    return new org.apache.commons.beanutils.BeanMap(obj);
	 }
	
	/**
	 * map转Object
	 * <p>Title: mapToObject</p>  
	 * <p>Description: </p>  
	 * @param map
	 * @param beanClass 
	 * @return
	 * @throws Exception
	 */
	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass)
		      throws Exception {
	    if (map == null)
	      return null;
	    Object obj = beanClass.newInstance();
	    org.apache.commons.beanutils.BeanUtils.populate(obj, map);
	    return obj;
	}
	
	 /**
     * 
     * @param request
     * @param response
     * @param fileName
     */
    public static void setDownloadHeader(HttpServletRequest request, HttpServletResponse response, String fileName) {
    	 String userAgent = request.getHeader("User-Agent");
         boolean isIE = (userAgent != null) && (userAgent.toLowerCase().indexOf("msie") != -1);
 
         response.setHeader("Pragma", "No-cache");
         response.setHeader("Cache-Control", "must-revalidate, no-transform");
         response.setDateHeader("Expires", 0L);
 
         response.setContentType("application/x-download");
         
         try {
        	 if (isIE) {
            	 fileName = new String(fileName.getBytes("gb2312"), "iso-8859-1");
                 response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
             } else {
            	 fileName = new String(fileName.getBytes("gb2312"), "iso-8859-1");
                 response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
             }
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
}
