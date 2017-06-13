package domain;

public class BinaryTreeInt {
	private Integer data;
	private BinaryTreeInt leftTree,rightTree;
	
	public BinaryTreeInt(int data){
		this.data = data;
		this.leftTree = null;
		this.rightTree = null;
	}
	public BinaryTreeInt(Integer data, BinaryTreeInt leftTree,BinaryTreeInt rightTree){
		this.data = data;
		this.leftTree = leftTree;
		this.rightTree = rightTree;
	}
	public int getData(){
		return data;
	}
	public boolean isVeelvoudVanVijf(){
		return data % 5 == 0;
	}
	public int kinderSom(){
		if(leftTree == null && rightTree == null){
			return 0;
		}
		if(isVeelvoudVanVijf()){
			if(leftTree != null){
				if(rightTree != null){
					return leftTree.getData() + rightTree.getData() + leftTree.kinderSom() + rightTree.kinderSom(); 
				}else{
					return leftTree.getData() + leftTree.kinderSom();
				}
			}
		}else{
			if(leftTree != null){
				return leftTree.kinderSom();
			}else if(rightTree != null){
				return rightTree.kinderSom();
			}else{
				return 0;
			}
		}
		return 0;
	}
	
}
