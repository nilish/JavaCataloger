package goynaa.catalog;


import java.util.*;
public class Row {
	
	private int product_id;
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getInventory_id() {
		return inventory_id;
	}
	public void setInventory_id(int inventory_id) {
		this.inventory_id = inventory_id;
	}
	public String getProduct_title() {
		return product_title;
	}
	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public float getProduct_unit_price() {
		return product_unit_price;
	}
	public void setProduct_unit_price(float product_unit_price) {
		this.product_unit_price = product_unit_price;
	}
	public Date getDate_added() {
		return date_added;
	}
	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}
	public int getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	public String getImage_name() {
		return image_name;
	}
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
	public String getPlacement_name() {
		return placement_name;
	}
	public void setPlacement_name(String placement_name) {
		this.placement_name = placement_name;
	}
	private int inventory_id;
	private String product_title;
	private String product_description;
	private float product_unit_price;
	private Date date_added;
	private int product_quantity;
	private String image_name;
	private String placement_name;
	private String product_type;
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

}


