package food;

public class Store {

	private Fruit[] fruits = new Fruit[100];
	private Vegetable[] vegetables = new Vegetable[100];
	
	public void addFruit(Fruit fruit) {
		for (int i = 0; i < fruits.length; i++) {
			if(fruits[i] == null) {
				fruits[i] = fruit;
				return;
			}
		}
	}
	
	public void addVegetable(Vegetable vegetable) {
		for (int i = 0; i < vegetables.length; i++) {
			if(vegetables[i] == null) {
				vegetables[i] = vegetable;
				return;
			}
		}
	}

	public Fruit[] getFruits() {
		return fruits;
	}

	public Vegetable[] getVegetables() {
		return vegetables;
	}
	
	
}
