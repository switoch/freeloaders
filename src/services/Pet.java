package services;

/**
 * Responsible for next properties: type, satiety weight, name
 */
public class Pet {

	private String type;
	private int satiety;
	private int weight;
	private String name;

	public Pet(String type) {
		super();
		this.type = type;
		this.satiety = 0;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSatiety() {
		return satiety;
	}

	public void setSatiety(int satiety) {
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

	@Override
	public String toString() {
		return "Pet[type=" + this.type + ", satiety=" + this.satiety + "]";
	}

}
