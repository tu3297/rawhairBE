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
	    @ManyToOne(optional = false)
		@JoinColumn(name = "product_type")
		private ProductType product_type;
	    @ManyToOne(optional = false)
		@JoinColumn(name = "color")
		private Color color;
	    @ManyToOne(optional = false)
		@JoinColumn(name = "size")
		private Size size;
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "info_id", referencedColumnName = "id")
	    private ProductInfo info;
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
		public ProductType getProduct_type() {
			return product_type;
		}
		public void setProduct_type(ProductType product_type) {
			this.product_type = product_type;
		}
		public Color getColor() {
			return color;
		}
		public void setColor(Color color) {
			this.color = color;
		}
		public Size getSize() {
			return size;
		}
		public void setSize(Size size) {
			this.size = size;
		}
	    
	    
}
