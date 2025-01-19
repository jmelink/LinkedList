package com.solvd.linkedlist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.linkedlist.product.Product;

public class LinkedList<P extends Product> {
	private Node<P> headNode;
	
	private final static Logger LOGGER = LogManager.getLogger(LinkedList.class.getClass());
	
	public LinkedList() {
		
	}
	
	public Node<P> getHeadNode() {
		return headNode;
	}

	public void setHeadNode(Node<P> node) {
		this.headNode = node;
	}

	public void insert(P data, Integer index) {
		LOGGER.info("Insert " + data.toString() + " at index " + index);
		
		Node<P> node = new Node<P>(data);
		
		// If the head node doesn't exist, the node being added becomes the head node.
		if (getHeadNode() == null) {
			setHeadNode(node);
			getHeadNode().setPrevious(null);
			getHeadNode().setNext(null);
		} else {
			// Traverse the list to reach either the index or the end of the list (whichever is hit first)
			// to add the node into the index provided
			Integer incrementer = 0;
			Node<P> currentNode = getHeadNode();
			while (incrementer < index) {
				if (currentNode.getNext() != null) {
					currentNode = currentNode.getNext();
				} else {
					if (currentNode != null) {
						incrementer++;
					}
				}
				incrementer++;
			}
			
			if (currentNode.getPrevious() == null && incrementer == 0) {
				setHeadNode(node);
				getHeadNode().setPrevious(null);
				getHeadNode().setNext(currentNode);
				currentNode.setPrevious(getHeadNode());
			} else if (currentNode.getNext() == null && incrementer > index) {
				node.setPrevious(currentNode);
				node.setNext(null);
				currentNode.setNext(node);
			} else {
				node.setPrevious(currentNode.getPrevious());
				node.setNext(currentNode);
				currentNode.getPrevious().setNext(node);
				currentNode.setPrevious(node);
			}
		}
	}
	
	public void remove(Integer index) {
		LOGGER.info("Remove node at index " + index);
		if (getHeadNode() != null) {
			Integer incrementer = 0;
			Node<P> nodeToRemove = getHeadNode();
			while (incrementer < index && nodeToRemove.getNext() != null) {
				nodeToRemove = nodeToRemove.getNext();
				incrementer++;
			}
			
			// If the head node is being removed, else if the tail node is being removed, else a middle node is being removed
			if (nodeToRemove.getNext() != null && nodeToRemove.getPrevious() == null) {
				setHeadNode(nodeToRemove.getNext());
				getHeadNode().setNext(nodeToRemove.getNext().getNext());
			} else if (nodeToRemove.getNext() == null && nodeToRemove.getPrevious() != null) {
				nodeToRemove.getPrevious().setNext(null);
				nodeToRemove.setPrevious(null);
			} else {
				nodeToRemove.getPrevious().setNext(nodeToRemove.getNext());
				nodeToRemove.getNext().setPrevious(nodeToRemove.getPrevious());
				nodeToRemove.setPrevious(null);
				nodeToRemove.setNext(null);
			}
		} else {
			LOGGER.info("There are no elements in the list to remove.");
		}
	}
}
