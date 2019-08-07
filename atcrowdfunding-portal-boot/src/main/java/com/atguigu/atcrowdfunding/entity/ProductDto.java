package com.atguigu.atcrowdfunding.entity;


import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductDto implements Serializable {
	private static final long serialVersionUID = 6932649538854879183L;
	private Long id;
	private Long categoryId;
	private String name;
	private String subtitle;
	private String mainImage;
	private BigDecimal price;
	private Integer status;
	private String imageHost;
	private Integer stock;
	private String productCode;
	private Integer changeStock;
}
