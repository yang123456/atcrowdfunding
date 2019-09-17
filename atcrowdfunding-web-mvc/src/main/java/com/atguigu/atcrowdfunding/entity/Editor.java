package com.atguigu.atcrowdfunding.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * Created on 2018/3/4 0004.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class Editor {

    private Integer id;

    private String content;

    private String textContent="";

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    
    public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getTextContent() {
		return textContent;
	}



	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}



	public Date getCreateTime() {
		return createTime;
	}



	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}



	@Override
    public String toString() {
        return "Editor{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
