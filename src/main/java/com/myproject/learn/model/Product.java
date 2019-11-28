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
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column
	    private String name;
		@Column
		private Integer product_type;
		@Column(name = "size")
		private Integer size;
	    @Column
	    private Integer info;
	    @Column
	    private String code;
		public Product() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
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
