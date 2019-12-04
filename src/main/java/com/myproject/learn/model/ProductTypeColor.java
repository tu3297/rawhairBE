package com.myproject.learn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producttypecolor")
public class ProductTypeColor {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column
	    private Integer ptId;
	    @Column
	    private Integer colorId;
	    @Column
	    private String useYn;
		public String getUseYn() {
			return useYn;
		}
		public void setUseYn(String useYn) {
			this.useYn = useYn;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Integer getPtId() {
			return ptId;
		}
		public ProductTypeColor() {
			super();
			// TODO Auto-generated constructor stub
		}
		public void setPtId(Integer ptId) {
			this.ptId = ptId;
		}
		public Integer getColorId() {
			return colorId;
		}
		public void setColorId(Integer colorId) {
			this.colorId = colorId;
		}
}
