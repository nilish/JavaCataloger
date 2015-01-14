package goynaa.product;

import java.util.ArrayList;
import java.util.List;

public class Jewelry extends Product{
	
	public List<String> getBase_materials() {
		return base_materials;
	}
	public void setBase_materials(ArrayList<String> base_materials) {
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
	private List<String> base_materials;
	private String[] stones;
	private double width;
	public List<String> getColors() {
		return colors;
	}
	public void setColors(List<String> colors) {
		this.colors = colors;
	}
	public String getCampaign_image() {
		return campaign_image;
	}
	public void setCampaign_image(String campaign_image) {
		this.campaign_image = campaign_image;
	}
	private double length;
	private String[] shapes;
	private String[] placements;
	private String[] styles;
	private String size;
	private List<String> colors;
	private String campaign_image;
}
