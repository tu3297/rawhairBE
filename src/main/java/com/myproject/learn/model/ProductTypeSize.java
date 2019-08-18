package com.myproject.learn.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ProductTypeSize {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column
	    private Long type_id;
	    @Column
	    private Long size_id;
	    @Column
	    private Long price;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getType_id() {
			return type_id;
		}
		public void setType_id(Long type_id) {
			this.type_id = type_id;
		}
		public Long getSize_id() {
			return size_id;
		}
		public void setSize_id(Long size_id) {
			this.size_id = size_id;
		}
		public Long getPrice() {
			return price;
		}
		public void setPrice(Long price) {
			this.price = price;
		}
		public ProductTypeSize() {
			super();
			// TODO Auto-generated constructor stub
		}
		public ProductTypeSize(Long id, Long type_id, Long size_id, Long price) {
			super();
			this.id = id;
			this.type_id = type_id;
			this.size_id = size_id;
			this.price = price;
		}
	    
	    
}
