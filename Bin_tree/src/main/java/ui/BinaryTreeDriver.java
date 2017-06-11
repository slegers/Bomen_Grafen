package ui;

import domain.BinaryTree;

import java.util.ArrayList;

public class BinaryTreeDriver {

	public static void main(String[] args) {
		BinaryTree<String> nodeD = new BinaryTree<>("D");
		BinaryTree<String> nodeF = new BinaryTree<>("F");
		BinaryTree<String> nodeB = new BinaryTree<>("B");
		BinaryTree<String> nodeH = new BinaryTree<>("H");
		
		// knoop A heeft links D en rechts F
		BinaryTree<String> nodeA = new BinaryTree<>("A",nodeD, nodeF);
		// knoop E heeft links H
		BinaryTree<String> nodeE = new BinaryTree<>("E",nodeH,null);
		// knoop G heeft links E en rechts B
		BinaryTree<String> nodeG = new BinaryTree<>("G",nodeE, nodeB);
		
		// boom heeft root C en heeft links A en rechts G
		BinaryTree<String> boom = new BinaryTree<>("C",nodeA, nodeG);
		System.out.println("Pre order");
		boom.printPreorder();
		System.out.println("In order");
		boom.printInOrder();
		System.out.println("Post order");
		boom.printPostOrder();
		System.out.println();
		System.out.print("counts: " + boom.countNodes());
		System.out.println();
		System.out.print("depth: " + boom.getDepth());
		System.out.println();
		System.out.print("leafs: " + boom.countLeaves());
		System.out.println();
		System.out.print("dataleafs: " + boom.getDataLeaves());
		System.out.println();
		System.out.print("dataleafs: " + boom.getDataLeaves());
		System.out.println();
		System.out.print("dataleafs: " + boom.contains("Z"));
	}


}
