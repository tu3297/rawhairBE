package com.myproject.learn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "imageDetail")
public class ImageDetail {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column
	    private String id_product;
	    @Column
	    private String ref_key;
	    @Column
	    private String image_url;
		public String getImage_url() {
			return image_url;
		}
		public void setImage_url(String image_url) {
			this.image_url = image_url;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getId_info() {
			return id_product;
		}
		public void setId_info(String id_info) {
			this.id_product = id_info;
		}
		public String getImg_url() {
			return ref_key;
		}
		public void setImg_url(String ref_key) {
			this.ref_key = ref_key;
		}
		public ImageDetail() {
			super();
			// TODO Auto-generated constructor stub
		}
}
