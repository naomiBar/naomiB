package food;

public abstract class Food {

	private double weight;
	private String taste;
	
	public Food() {
	}
	
	public Food(double weight, String taste) {
		this.weight = weight;
		this.taste = taste;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() +" [weight=" + weight + ", taste=" + taste + "]";
	}
	
	
	
	
	
}
