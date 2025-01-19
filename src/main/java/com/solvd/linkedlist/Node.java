package com.solvd.linkedlist;

import com.solvd.linkedlist.product.Product;

public class Node<P extends Product> {
	private P product;
	private Node<P> previous;
	private Node<P> next;
	
	public Node() {
		
	}
	
	public Node(P product) {
		setProduct(product);
	}
	
	public P getProduct() {
		return product;
	}

	public void setProduct(P product) {
		this.product = product;
	}

	public Node<P> getPrevious() {
		return previous;
	}

	public void setPrevious(Node<P> previous) {
		this.previous = previous;
	}

	public Node<P> getNext() {
		return next;
	}

	public void setNext(Node<P> next) {
		this.next = next;
	}
}
