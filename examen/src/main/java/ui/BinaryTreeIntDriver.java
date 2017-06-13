package ui;

import domain.BinaryTreeInt;

public class BinaryTreeIntDriver {
	public static void main(String[] args) {
		
		
		BinaryTreeInt node91 = new BinaryTreeInt(-1);

		BinaryTreeInt node5 = new BinaryTreeInt(5);
		BinaryTreeInt node50 = new BinaryTreeInt(50);
		BinaryTreeInt node2 = new BinaryTreeInt(2,node5,null);
		BinaryTreeInt node20 = new BinaryTreeInt(20,node50,null);
		BinaryTreeInt node7 = new BinaryTreeInt(7,null,node20);
		BinaryTreeInt node15 = new BinaryTreeInt(15,node7,node91);
		BinaryTreeInt node910 = new BinaryTreeInt(-10,node2,node15);
		BinaryTreeInt node3 = new BinaryTreeInt(3,node910,node7);

		System.out.print(node3.kinderSom());
		
	}

}
