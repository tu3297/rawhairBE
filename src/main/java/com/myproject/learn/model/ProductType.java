package com.myproject.learn.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "producttype")
public class ProductType {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column
	    private String name;
	    
	    @Column
	    private String description;
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
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
		public ProductType() {
			super();
			// TODO Auto-generated constructor stub
		}
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "product_type")
	    @JsonIgnore
		private Collection<Product> product;
		public Collection<Product> getProduct() {
			return product;
		}
		public void setProduct(Collection<Product> product) {
			this.product = product;
		}
		public ProductType(Long id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
}
