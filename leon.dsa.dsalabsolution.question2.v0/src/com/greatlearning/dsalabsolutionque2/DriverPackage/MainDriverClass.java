package com.greatlearning.dsalabsolutionque2.DriverPackage;

import com.greatlearning.dsalabsolutionque2.SupportClassesPacakge.BinarySearchTree;

public class MainDriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinarySearchTree bst1=new BinarySearchTree();
		bst1.insert(40);
		bst1.insert(20);
		bst1.insert(60);
		bst1.insert(10);
		bst1.insert(30);
		bst1.insert(50);
		bst1.insert(70);
		
		bst1.printSumPair(130);
		
		// Extra values to test program
//		bst1.printSumPair(60);
//		bst1.printSumPair(40);
//		bst1.printSumPair(70);
//		bst1.printSumPair(50);
//		bst1.printSumPair(500);
//		bst1.printSumPair(140);
	}

}
