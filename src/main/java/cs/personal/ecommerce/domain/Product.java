package cs.personal.ecommerce.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private long id;
	private Double price;
	private String name;
	@Enumerated(EnumType.STRING)
	private Category category;
	private String imageUpload;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getImageUpload() {
		return imageUpload;
	}
	public void setImageUpload(String imageUpload) {
		this.imageUpload = imageUpload;
	}
	
	
}
