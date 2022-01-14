package model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Item implements Serializable {

	private Game gameid;
	private int quantity;

	public Item() {
	}

	public Item(Game gameid, int quantity) {
		this.gameid = gameid;
		this.quantity = quantity;
	}

	public Game getProduct() {
		return gameid;
	}

	public void setProduct(Game gameid) {
		this.gameid = gameid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}