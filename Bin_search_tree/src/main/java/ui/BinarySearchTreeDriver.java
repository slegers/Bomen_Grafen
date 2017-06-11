package ui;

import domain.BinarySearchTree;

public class BinarySearchTreeDriver {

	public static void main(String[] args) {
		BinarySearchTree<Integer> boom = new BinarySearchTree<>();
		boom.addNode(6);
		boom.addNode(4);
		boom.addNode(8);
		boom.addNode(3);
		boom.addNode(5);
		boom.addNode(7);
		boom.addNode(9);
		boom.addNode(10);
		boom.addNode(11);

		boom.removeNode(9);
		boom.printInOrder();
		System.out.println();

		boom.ruimOp();

		boom.printInOrder();
		System.out.println();
		System.out.println("De grootste waarde uit deze boom = " + boom.searchGreatest());
		System.out.println("De kleinste waarde uit deze boom = " + boom.searchSmallest());
	}

}
