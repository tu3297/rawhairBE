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
@Table(name = "color")
public class Color {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column
	    private String name;
	    @Column
	    private String code;
	    
		public String getColorCode() {
			return code;
		}
		public void setColorCode(String colorCode) {
			this.code = colorCode;
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
		public Color() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Color(Long id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
	    
}
