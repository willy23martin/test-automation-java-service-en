package com.test.automation.project.testautomationjavaservicebackend.api.model.datastructure;

import java.util.ArrayList;


public class BinaryTree<T> {

	private TreeNode<T> root;
	
	public BinaryTree(){
		root =null;
	}

	public TreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}
	
	public boolean isEmpty(){
		return (root ==null);
	}
	
	public void addElement(T elemento){
		if(isEmpty()){
			setRoot(new TreeNode<T>(elemento));
		}else{
			root.addElement(elemento);
		}
	}
	
	public ArrayList<T> inorder(){
		ArrayList<T> inorder=new ArrayList<T>();
		return root.inorder(inorder);
	}
	
}
