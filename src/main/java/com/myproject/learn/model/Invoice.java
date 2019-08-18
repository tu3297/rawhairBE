package com.myproject.learn.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "invoices")
public class Invoice extends DateAudit {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column
	    private String code;
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name = "invoice_product",
	            joinColumns = @JoinColumn(name = "invoice_id"),
	            inverseJoinColumns = @JoinColumn(name = "product_id"))
	    private Set<Product> products = new HashSet<>();
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public Set<Product> getProduct() {
			return products;
		}
		public void setProduct(Set<Product> product) {
			this.products = product;
		}
		public Invoice() {
			super();
			// TODO Auto-generated constructor stub
		}
}
