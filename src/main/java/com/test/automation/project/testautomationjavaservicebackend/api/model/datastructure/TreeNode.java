package com.test.automation.project.testautomationjavaservicebackend.api.model.datastructure;

import java.util.ArrayList;

public class TreeNode<T> implements Comparable<TreeNode<T>> {

	private T element;

	private TreeNode<T> left, right;

	public TreeNode(T element) {
		setElement(element);
		this.left = null;
		this.right = null;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	public String toString() {
		return element.toString();
	}

	public boolean equals(Object obj) {
		return this.element.equals(((TreeNode)obj).getElement());
	}

	public ArrayList<T> inorder(ArrayList<T> accum) {
		if (getLeft() != null) {
			left.inorder(accum);
		}
		accum.add(element);
		if (getRight() != null) {
			right.inorder(accum);
		}
		return accum;
	}

	public int compareTo(TreeNode<T> node) {
		if (node.getElement().hashCode() == this.getElement().hashCode()) {
			return 0;

		} else if (node.getElement().hashCode() > this.getElement()
				.hashCode()) {

			return -1;

		} else {

			return 1;

		}

	}

	public boolean isLeaf() {
		return (left == null && right == null);
	}

	public boolean isLessThan(TreeNode<T> node) {
		return (this.compareTo(node) < 0);
	}

	public void addElement(T element) {
		TreeNode<T> newNode = new TreeNode<T>(element);
		if (isLeaf()) {
			if (isLessThan(newNode)) {
				setRight(newNode);
			} else {
				setLeft(newNode);
			}
		} else if (isLessThan(newNode)) {
			if (right == null) {
				setRight(newNode);
			} else {
				right.addElement(element);
			}
		} else {
			if (left == null) {
				setLeft(newNode);
			} else {
				left.addElement(element);
			}
		}
	}

}
