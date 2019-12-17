package com.myproject.learn.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "product")
public class Product {
        @Id
	    private String id;
	    @Column
	    private String color;
		@Column
		private Integer product_type;
		@Column(name = "size")
		private Integer size;
	    @Column
	    private Integer info;
	    @Column
	    private String code;   
	    @Column
	    private String price;
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public Product() {
			super();
			// TODO Auto-generated constructor stub
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String name) {
			this.color = name;
		}
		public Integer getProduct_type() {
			return product_type;
		}
		public void setProduct_type(Integer product_type) {
			this.product_type = product_type;
		}
		public Integer getSize() {
			return size;
		}
		public void setSize(Integer size) {
			this.size = size;
		}
	    
	    
}
