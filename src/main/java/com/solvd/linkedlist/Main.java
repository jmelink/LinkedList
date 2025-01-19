package com.solvd.linkedlist;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.linkedlist.product.Bread;
import com.solvd.linkedlist.product.Chicken;
import com.solvd.linkedlist.product.Milk;
import com.solvd.linkedlist.product.Product;

public class Main {

	private final static Logger LOGGER = LogManager.getLogger(Main.class.getClass());
	
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, InstantiationException, IllegalArgumentException, NoSuchMethodException, SecurityException {
		Bread bread1 = new Bread("Bread", 42331, "Loaf", 1.79, 2.99, 10);
		Bread bread2 = new Bread("Bread", 42331, "Loaf", 1.79, 2.99, 4);
		Bread bread3 = new Bread("Bread", 42334, "Half-Loaf", 1.09, 1.99, 7);
		Chicken chicken = new Chicken("Chicken", 31533, "3lb Bag", 8.29, 11.99, 60);
		Milk milk1 = new Milk("Milk", 25749, "Gallon", 2.39, 2.89, 6);
		Milk milk2 = new Milk("Milk", 25750, "Gallon", 2.39, 2.29, 1);
		
		LinkedList<Product> productList = new LinkedList<Product>();
		productList.insert(bread1, 0);
		productList.insert(chicken, 1);
		productList.insert(milk2, 2);
		printList(productList);
		
		productList.remove(2);
		printList(productList);
		
		productList.insert(milk1, 1);
		printList(productList);
		
		productList.insert(bread2, 0);
		printList(productList);
		
		productList.remove(2);
		printList(productList);
		
		productList.insert(bread3, 3);
		printList(productList);
		
		productList.remove(0);
		printList(productList);
		
		productList.remove(2);
		printList(productList);
		
		productList.remove(1);
		printList(productList);
		
		testReflection();
	}
	
	public static void printList(LinkedList<Product> list)
    {
        Node<Product> currentNode = list.getHeadNode();
        LOGGER.info("LinkedList: ");

        while (currentNode != null) {
            LOGGER.info(currentNode.getProduct().toString());
            currentNode = currentNode.getNext();
            if (currentNode != null) {
            	LOGGER.info("-----");
            }
        }
    }
	
	public static void testReflection() throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, InstantiationException, IllegalArgumentException, NoSuchMethodException, SecurityException {
		LOGGER.info("---------- Reflection ----------");
		
		Class<?> chickenClass = Class.forName("com.solvd.linkedlist.product.Chicken");
		Constructor<?>[] productConstructors = chickenClass.getConstructors();
		Field[] productFields = chickenClass.getSuperclass().getDeclaredFields();
		Chicken reflectionProduct = ((Chicken) productConstructors[1].newInstance("Fresh Chicken", 5555, "EA", 5.55, 11.11, 5));
		LOGGER.info(reflectionProduct.getName());
		Double reflectionMargin = (Double) chickenClass.getSuperclass().getDeclaredMethod("calculateMargin", (Class<?>[]) null).invoke(reflectionProduct, (Object[]) null);
		LOGGER.info(reflectionMargin);
		productFields[3].trySetAccessible();
		LOGGER.info(productFields[3].get(reflectionProduct));
	}

}
