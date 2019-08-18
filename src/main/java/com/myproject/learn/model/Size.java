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
@Table(name = "size")
public class Size {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column
	    private int ptoductType;
	    @Column
	    private String length;
	    @Column
	    private String sizeFrontals;
	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "size")
		@JsonIgnore
		private Collection<Product> product;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Size() {
			super();
			// TODO Auto-generated constructor stub
		}
		public String getLength() {
			return length;
		}
		public void setLength(String length) {
			this.length = length;
		}
		public String getSizeFrontals() {
			return sizeFrontals;
		}
		public void setSizeFrontals(String sizeFrontals) {
			this.sizeFrontals = sizeFrontals;
		}
}
