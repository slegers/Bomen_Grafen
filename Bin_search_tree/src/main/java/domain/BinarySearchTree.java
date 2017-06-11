package domain;

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
			return true;
		}
		
		public boolean removeNode(E data){
			return true;
		}

		public E searchGreatest() {
			return null;
		}


		public E searchSmallest() {
			return null;
		}
}
