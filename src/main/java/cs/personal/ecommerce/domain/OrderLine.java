package cs.personal.ecommerce.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class OrderLine {
	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	private Member member;
	@OneToMany
	private List<Product> products;
	private double price;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
