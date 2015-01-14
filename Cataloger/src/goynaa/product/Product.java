package goynaa.product;

import java.util.ArrayList;
import java.util.List;

public class Product {

	private String product_title;
	private String product_description;
	private List<String> colors;
	private List<String> images;
	private String campaign_image;
	private double weight;
	protected String type;
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void setCampaign(String image){
		this.campaign_image = image;
	}


	private int product_id;

	public List<String> getColors() {
		return colors;
	}

	public void setColors(List<String> colors) {
		this.colors = colors;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images2) {
		this.images = images2;
	}
	
	public String getCampaignImage(){
		return campaign_image;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
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
	
	
	public Product() {
		super();
	}

}