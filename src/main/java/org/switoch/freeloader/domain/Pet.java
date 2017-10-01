package org.switoch.freeloader.domain;

/**
 * Responsible for next properties: type, satiety, dirt, weight, name
 */
public class Pet {

	private String type;
	private float satiety;
	private int weight;
	private String name;
	private int dirt;

	public Pet(){
	}
	
	public Pet(String type) {
		super();
		this.type = type;
		this.satiety = 0;
	}

	public int getDirt() {
		return dirt;
	}

	public void setDirt(int dirt) {
		this.dirt = dirt;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getSatiety() {
		return this.satiety;
	}

	public void setSatiety(float satiety) {
		this.satiety = satiety;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addSatiety(double value){
		this.satiety += value;
	}

	@Override
	public String toString() {
		return "Pet[type=" + this.type + ", satiety=" + this.satiety + ", dirt"+ this.dirt + "]";
	}

}
