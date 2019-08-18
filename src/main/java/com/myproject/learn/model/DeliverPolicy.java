package com.myproject.learn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deliverpolicy")
public class DeliverPolicy {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column
	    private int product_type;
	    @Column
	    private String policy_return;
	    public String getPolicy_produce() {
			return policy_produce;
		}
		public void setPolicy_produce(String policy_produce) {
			this.policy_produce = policy_produce;
		}
		@Column
	    private String policy_produce;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public int getProduct_type() {
			return product_type;
		}
		public void setProduct_type(int product_type) {
			this.product_type = product_type;
		}
		public String getPolicy_return() {
			return policy_return;
		}
		public void setPolicy_return(String policy_return) {
			this.policy_return = policy_return;
		}
		public DeliverPolicy() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
}
