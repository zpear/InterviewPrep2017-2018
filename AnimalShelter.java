import java.util.LinkedList;

/*
 * Animal shelter holds only cats and dogs. Operates on FIFO basis.
 * People can adopt oldest overall animal, or choose oldest cat/dog.
 * Create data structure to maintain this system using built in 
 * LinkedList data structure.
 */
public class AnimalShelter {
	public static class Animal {
		private boolean dog;
		private int age;
	
		/*
		 * d == true if Animal is a dog,
		 * false if Animal is a cat
		 */
		public Animal(boolean d) {
			dog = d;
		}
		public boolean isDog() {
			return dog;
		}
		public void setAge(int x) {
			age = x;
		}
		public int getAge() {
			return age;
		}
	}
	
	private LinkedList<Animal> dogs;
	private LinkedList<Animal> cats;
	private int count;
	
	public AnimalShelter() {
		dogs = new LinkedList<Animal>();
		cats = new LinkedList<Animal>();
		count = 0;
	}
	public void enque(Animal a) {
		count++;
		a.setAge(count);
		if (a.isDog()) {
			dogs.add(a);
		} else {
			cats.add(a);
		}
	}
	
	public Animal dequeueDog() {
		if (dogs.size() != 0) {
			return dogs.removeFirst();
		} else {
			return null;
		}
	}
	
	public Animal dequeueCat() {
		if (cats.size() != 0) {
			return cats.removeFirst();
		} else {
			return null;
		}
	}
	
	public Animal dequeueAny() {
		
		if (dogs.size() == 0 && cats.size() != 0) {
			return dequeueCat();
		} else if (cats.size() == 0 && dogs.size() != 0) {
			return dequeueDog();
		} else if (cats.size() == 0 && dogs.size() == 0) {
			return null;
		}
		
		Animal d = dogs.peekFirst();
		Animal c = cats.peekFirst();
		if (d.getAge() < c.getAge()) {
			return dequeueDog();
		} else {
			return dequeueCat();
		}
	}
	
	public static void main(String[] args) {
		AnimalShelter test = new AnimalShelter();
		
		for (int i = 0; i < 10; i++) {
			Animal a;
			
			if (i%3 == 0) {
				a = new Animal(true);
			} else {
				a = new Animal(false);
			}
			test.enque(a);
		}
		System.out.println();
		
		Animal x;
	
		// Selectively comment-out to test as needed
		while ((x = test.dequeueCat()) != null) {
			System.out.println(x.getAge());
		}
		while ((x = test.dequeueDog()) != null) {
			System.out.println(x.getAge());
		}
		
		while ((x = test.dequeueAny()) != null) {
			System.out.println(x.getAge());
		}
	}
}
