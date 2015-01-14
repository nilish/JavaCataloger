package goynaa.product;

public class Product_theclass {
	
	
	private int product_id;
	public Product_theclass(int product_id){
		this.product_id = product_id;
		
	}
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String[] getCatagory() {
		return catagory;
	}
	public void setCatagory(String[] catagory) {
		this.catagory = catagory;
	}
	public String[] getMaterial_metal() {
		return material_metal;
	}
	public void setMaterial_metal(String[] material_metal) {
		this.material_metal = material_metal;
	}
	public String[] getMaterial_stone() {
		return material_stone;
	}
	public void setMaterial_stone(String[] material_stone) {
		this.material_stone = material_stone;
	}
	public String[] getMaterial_non_metal() {
		return material_non_metal;
	}
	public void setMaterial_non_metal(String[] material_non_metal) {
		this.material_non_metal = material_non_metal;
	}
	public String[] getDesign() {
		return design;
	}
	public void setDesign(String[] design) {
		this.design = design;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	public String[] getColor() {
		return color;
	}
	public void setColor(String[] color) {
		this.color = color;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCountry_origin() {
		return country_origin;
	}
	public void setCountry_origin(String country_origin) {
		this.country_origin = country_origin;
	}
	public String getBody_piece() {
		return body_piece;
	}
	public void setBody_piece(String body_piece) {
		this.body_piece = body_piece;
	}
	double price;
	String [] catagory;
	String [] material_metal;
	String [] material_stone;
	String [] material_non_metal;
	String [] design;
	String size;
	String shape;
	String[] color;
	String supplier;	
	String description;
	String country_origin;
	String body_piece;
	String image_path;
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
}










    
