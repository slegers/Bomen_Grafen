package domain;

import java.util.ArrayList;

/**
 * Created by yanice on 11/06/2017.
 */
public class BinaryMaxHeap<E extends Comparable<E>> {
    private ArrayList<E> values = new ArrayList<>();

    public void print() {
        System.out.println(values);
    }

    public E getMax() {
        if (this.values.size() == 0) {
            throw new IllegalStateException();
        } else {
            return this.values.get(0);
        }
    }

    public boolean addValue(E value){
        if (value == null){
            throw new IllegalArgumentException();
        }
        values.add(value);//achteraan toevoegen
        this.bubbleUp();//bubbleUp vanaf de laatste zie slides theorie
        return true;
    }

    private void bubbleUp() {
        int index = values.size()-1;
        while(heeftOuder(index) && ouder(index).compareTo(values.get(index)) < 0){
            wisselOm(index,indexOuder(index));
            index = indexOuder(index);
        }
    }
    private void wisselOm(int i, int j) {
        //wissel i-de en j-de element in de ArrayList om
        E hulp = this.values.get(i);
        this.values.set(i, this.values.get(j));
        this.values.set(j, hulp);
    }

    private boolean heeftOuder(int index) {
        if(index >=1){
            return true;
        }return false;
    }

    private E ouder(int index){
        return values.get(indexOuder(index));
    }

    private int indexOuder(int index) {
        return (index-1)/2;
    }

    public E removeGrootste() {
        E res = this.getMax();// res bevat de grootste = eerste element van de lijst
        this.values.set(0, this.values.get(this.values.size()-1));// verwissel eerste met de laatste
        this.values.remove(this.values.size()-1); // verwijder de laatste
        this.bubbleDown(); // bubble down van eerste naar beneden zie theorie
        return res;
    }


    private void bubbleDown() {
        int index = 0;
        boolean i = true;
        while(heeftLinkerKind(index) && i){
            //welk kind is het grootst?
            int indexGrootsteKind = indexLinkerKind(index);

            if (heeftRechterKind(index)
                    && values.get(indexGrootsteKind).compareTo(values.get(indexRechterKind(index))) > 0) {
                indexGrootsteKind = indexRechterKind(index);
            }
            //vergelijk ouderwaarde met waarde van grootste kind
            if (values.get(index).compareTo(values.get(indexGrootsteKind)) > 0) { //foute volgorde, wissel om
                this.wisselOm(index, indexGrootsteKind);
            } else {
                //volgorde OK, while lus mag stoppen
                i = false;
            }
            //vertrek nu vanuit de index van het kleinste kind
            index = indexGrootsteKind;
        }

    }

    private int indexLinkerKind(int i) {
        return 2 * i + 1;
    }

    private int indexRechterKind(int i) {
        return 2 * i + 2;
    }

    private boolean heeftLinkerKind(int i) {
        return indexLinkerKind(i) < values.size();
    }

    private boolean heeftRechterKind(int i) {
        return indexRechterKind(i) < values.size();
    }




    public ArrayList<E> getPath(E value) {
        int index = this.values.indexOf(value);
        if (index == -1) {
            //value komt niet voor in de heap
            return null;
        } else {
            //value zit in heap, index = plaats van eerste voorkomen
            ArrayList<E> pad = new ArrayList<>(); pad.add(value);
            while (index > 0) {
                //we zijn nog niet aan de wortel
                index = (index - 1)/2; //ouder
                pad.add(0, this.values.get(index));
            }
            return pad;
        }
    }
}


