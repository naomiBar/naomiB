package food;


public class StroreStatisticts {

	public static void main(String[] args) {

		Store store = new Store();
		createStore(store);

		System.out.println("amountFruits: " + amountFoods(store.getFruits()));
		System.out.println("amountVegetables: " + amountFoods(store.getVegetables()));
		
		System.out.println("\n\t For Fruits");
		showWeight(store.getFruits());
		System.out.println("\n\t For Vegetables");
		showWeight(store.getVegetables());
		
		System.out.println("\n\t Fruits");
		printFruits(store.getFruits());
		
		System.out.println("\n\t Vegetables");
		printFruits(store.getVegetables());
	}

	private static void createStore(Store store) {
		String[] tastes = { "sweet", "spicy", "bitter", "sour" };
		for (int i = 0; i < 100; i++) {
			double weight = (Math.random() * 6);
			String taste = tastes[(int) (Math.random() * 4)];
			if ((Math.random()) > 0.5) {
				Fruit fruit;
				if ((Math.random()) > 0.5) {
					fruit = new Apple(weight, taste);
				} else {
					fruit = new Strawbery(weight, taste);
				}
				store.addFruit(fruit);
			} else {
				Vegetable vegetable;
				if ((Math.random()) > 0.5) {
					vegetable = new Carrot(weight, taste);
				} else {
					vegetable = new Tomato(weight, taste);
				}
				store.addVegetable(vegetable);
			}
		}
	}


	private static int amountFoods(Food[] foods) {
		int sum = 0;
		for (int i = 0; i < foods.length; i++) {
			if(foods[i] != null) {
				sum++;
			}
		}
		return sum;
	}

	private static void printFruits(Food[] foods) {
		for (int i = 0; i < amountFoods(foods); i++) {
			System.out.println(foods[i]);			
		}
	}

	private static void showWeight(Food[] foods) {
		double weightMax = foods[0].getWeight();
		double weightMin = foods[0].getWeight();
		double sum = 0; 
		for (int i = 0; i < amountFoods(foods); i++) {
			double weight = foods[i].getWeight();
			if(weight>weightMax) {
				weightMax = weight;
			}
			if(weight<weightMin) {
				weightMin = weight;
			}
			sum+=weight;
		}
		System.out.println("weightMax: " + weightMax);
		System.out.println("weightMin: " + weightMin);
		System.out.println("weightAvg: " + sum/amountFoods(foods));
	}

}
