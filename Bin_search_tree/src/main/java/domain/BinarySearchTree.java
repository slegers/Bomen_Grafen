package domain;

import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> {
		private E data;
		private BinarySearchTree<E> leftTree, rightTree;
		
		public BinarySearchTree(){
		}
		
		
		private  BinarySearchTree(E data){
			this.data = data;
		}
		
		public void printInOrder() {
			if (this.data!=null){
				if (leftTree!=null) leftTree.printInOrder();
				System.out.print(this.data + " ");
				if(rightTree!=null) rightTree.printInOrder();
			}
		}
		
		public boolean lookup(E data){
			if ( data == null || this.data == null) return false;
			else {
				if (data.compareTo(this.data) == 0) return true;
				else if (data.compareTo(this.data) <  0){
					return (this.leftTree == null?false:leftTree.lookup(data));
				}
				else {
					return (this.rightTree == null? false: rightTree.lookup(data));
				}
			}
		}
		
		public boolean addNode(E data){
			if(data == null){
				return false;
			}else if(this.data ==null){
				this.data = data;
				return true;
			}else{
				if(this.data.compareTo(data) ==0){
					return false;
				}else if(data.compareTo(this.data) <0){
					if(leftTree == null){
						leftTree = new BinarySearchTree<E>(data);
					}else{
						leftTree.addNode(data);
					}
				}else{
					if(rightTree== null){
						rightTree = new BinarySearchTree<E>(data);
					}else{
						rightTree.addNode(data);
					}
				}
				return true;
			}
		}
		public boolean isLeaf(){
			if(this.leftTree==null && this.rightTree == null){
				return true;
			}return false;
		}

		public boolean removeNode(E data){
			if (data == null || this.data == null)
				return false;
			else if (data.compareTo(this.data) == 0){
				if (this.isLeaf()){
					this.data = null;
				}
			else if (this.leftTree != null){
				E grootsteLinks = leftTree.searchGreatest();
				this.data = grootsteLinks;
				this.leftTree.removeNode(grootsteLinks);
			} else{
				E kleinsteRechts = rightTree.searchSmallest();
				this.data = kleinsteRechts;
				this.rightTree.removeNode(kleinsteRechts);
			}
			return true;

			} else if (data.compareTo(this.data) < 0) {
				if (this.leftTree == null)
					return false;
				else
					return this.leftTree.removeNode(data);
			}else if (this.rightTree == null)
				return false;
			else
				return this.rightTree.removeNode(data);
		}

	public void ruimOp() {
		if (this.leftTree != null) {
			if (this.leftTree.data == null) {
				this.leftTree = null;
			} else {
			//ruim de linkerboom verder op
				this.leftTree.ruimOp();
			}
		}
		if (this.rightTree != null) {
			if (this.rightTree.data == null) { //ouder heeft rechterkind met data null
				this.rightTree = null; //verwijder het rechterkind
			} else {
				//ruim de rechterboom verder op
				this.rightTree.ruimOp(); }
		}

	}
	public ArrayList<E> getPath(E waarde) {
		if (data == null) {
			throw new IllegalArgumentException();

		}
		ArrayList<E> pad = new ArrayList<>(); pad.add(this.data);
		if (this.data.compareTo(waarde) == 0) {
			//knoop met waarde gevonden
			return pad;
		} else {
			ArrayList<E> deelpad = new ArrayList<>();

			if (this.data.compareTo(waarde) > 0) {
				//als er een pad is, zit het in de linkerboom
				if (this.leftTree == null) {
					//onderaan de boom, geen pad gevonden return null;
				}
				deelpad = this.leftTree.getPath(waarde);
			} else {
				//als er een pad is, zit het in de rechterboom
				if (this.rightTree == null) { //onderaan de boom, geen pad gevonden return null;
				}
				deelpad = this.rightTree.getPath(waarde);
			}
			if (deelpad == null) {
				return null;
			} pad.addAll(deelpad); return pad;
		}
	}

	public E searchGreatest() {
			if (rightTree == null) {
				return this.data;
			}
			return rightTree.searchGreatest();
		}

	public E searchSmallest() {
			if (leftTree == null) {
				return this.data;
			}
			return leftTree.searchSmallest();
		}
}
