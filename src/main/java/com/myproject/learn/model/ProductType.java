package com.myproject.learn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	    @Column
	    private Integer color;
		public Integer getColor() {
			return color;
		}
		public void setColor(Integer color) {
			this.color = color;
		}
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
		public ProductType(Long id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
}
