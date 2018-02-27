package main.java.vn.omi.entity;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id")
	private int id;	

	@Column(name="item_id")
	private String itemId;
	@Column(name="item_total")
	private String item_total;
	@Column(name="quantity")
	private String quantity;


	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItem_total() {
		return item_total;
	}

	public void setItem_total(String item_total) {
		this.item_total = item_total;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}
