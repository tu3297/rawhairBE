package com.myproject.learn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_info")
public class ProductInfo {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column
	    private String detail;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getDetail() {
			return detail;
		}
		public void setDetail(String detail) {
			this.detail = detail;
		}
		 @OneToOne(mappedBy = "info")
		 private Product product;
		public ProductInfo(Long id, String detail) {
			super();
			this.id = id;
			this.detail = detail;
		}
		public ProductInfo() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
}
