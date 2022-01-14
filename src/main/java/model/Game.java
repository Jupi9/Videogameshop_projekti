package model;
import java.io.Serializable;
import java.math.BigDecimal;

public class Game implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int gameid;
	private BigDecimal age;
	private String gamename;
	private BigDecimal price;
	private String category;
	private String gamepic;
	




public Game(int gameid, String gamename,  String category, BigDecimal age, BigDecimal price,  String gamepic) {
	this.gameid = gameid;
	this.gamename = gamename;
	this.category = category;
	this.age = age;
	this.price = price;
	this.gamepic = gamepic;
}


public int getGameid() {
	return gameid;
}


public void setGameid(int gameid) {
	this.gameid = gameid;
}


public BigDecimal getAge() {
	return age;
}


public void setAge(BigDecimal age) {
	this.age = age;
}


public String getGamename() {
	return gamename;
}


public void setGamename(String gamename) {
	this.gamename = gamename;
}


public BigDecimal getPrice() {
	return price;
}


public void setPrice(BigDecimal price) {
	this.price = price;
}


public String getCategory() {
	return category;
}


public void setCategory(String category) {
	this.category = category;
}


public String getGamepic() {
	return gamepic;
}


public void setGamepic(String gamepic) {
	this.gamepic = gamepic;
}
}