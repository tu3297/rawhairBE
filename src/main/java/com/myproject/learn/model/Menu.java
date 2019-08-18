package com.myproject.learn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menus")
public class Menu {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	private int order_num;
	@Column
	private int parent_id;
	@Column
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getOrder() {
		return order_num;
	}
	public void setOrder(int order) {
		this.order_num = order;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Menu(Long id, int order, int parent_id, String name) {
		super();
		this.id = id;
		this.order_num = order;
		this.parent_id = parent_id;
		this.name = name;
	}
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
