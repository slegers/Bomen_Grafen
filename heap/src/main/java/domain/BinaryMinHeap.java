package domain;

import java.util.ArrayList;

public class BinaryMinHeap<E extends Comparable<E>> {
	private ArrayList<E> values = new ArrayList<>();
	
	public void print() {
		System.out.println(values);
	}

	public E getMin() {
		//TO DO zie oefening 3
		return null;
	}
	public boolean addValue(E value){
		if (value == null) throw new IllegalArgumentException();
		values.add(value);//achteraan toevoegen
		this.bubbleUp();//bubbleUp vanaf de laatste zie slides theorie
		return true;
	}

	private void bubbleUp() {
		//TO DO : oefening 4
	}
	
	public E removeSmallest(){
			E res = this.getMin();// res bevat de kleinste = eerste element van de lijst
			this.values.set(0, this.values.get(this.values.size()-1));// verwissel eerste met de laatste
			this.values.remove(this.values.size()-1); // verwijder de laatste
			this.bubbleDown(); // bubble down van eerste naar beneden zie theorie
			return res;
	}

	private void bubbleDown() {
		// TODO zie oefening 5
	}

	public ArrayList<E> getPath(E value) {
		// TODO zie oefening 6; 
		return null;
	}
}
