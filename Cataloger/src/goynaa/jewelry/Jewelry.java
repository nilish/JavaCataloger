package goynaa.jewelry;

public class Jewelry {
	
	public String[] getColors() {
		return colors;
	}
	public void setColors(String[] colors) {
		this.colors = colors;
	}
	public String[] getImages() {
		return images;
	}
	public void setImages(String[] images) {
		this.images = images;
	}
	public String[] getBase_materials() {
		return base_materials;
	}
	public void setBase_materials(String[] base_materials) {
		this.base_materials = base_materials;
	}
	public String[] getStones() {
		return stones;
	}
	public void setStones(String[] stones) {
		this.stones = stones;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String[] getShapes() {
		return shapes;
	}
	public void setShapes(String[] shapes) {
		this.shapes = shapes;
	}
	public String[] getPlacements() {
		return placements;
	}
	public void setPlacements(String[] placements) {
		this.placements = placements;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String[] getStyles() {
		return styles;
	}
	public void setStyles(String[] styles) {
		this.styles = styles;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
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

	private String product_title;
	private String product_description;
	private String[] colors;
	private String[] images;
	private String[] base_materials;
	private String[] stones;
	private double width;
	private double length;
	private double weight;
	private String[] shapes;
	private String[] placements;
	private String type;
	private String[] styles;
	private String size;
	private int product_id;
}
