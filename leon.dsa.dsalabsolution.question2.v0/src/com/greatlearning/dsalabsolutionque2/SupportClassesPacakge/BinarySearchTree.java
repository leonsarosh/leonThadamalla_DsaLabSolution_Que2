package com.greatlearning.dsalabsolutionque2.SupportClassesPacakge;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class BinarySearchTree {
	
	// BST Node
	public static class Node{
		int nodeData;
		Node left,right;
		public Node (int nodeData) {
			this.nodeData=nodeData;
		}
	}
	
	private Node root;
	
	// Inserting new Node
	public Node insert(int nodeData) {
		if(root==null) {
			root=new Node(nodeData);
			return root;
		}
		return insert(root,nodeData);
	}
	
	private Node insert(Node node, int nodeData) {
		if(node==null) {
			node=new Node(nodeData);
			return node;
		}
		
		if(nodeData<node.nodeData) {
			node.left=insert(node.left,nodeData);
			return node;
		}
		
		if(nodeData>node.nodeData) {
			node.right=insert(node.right,nodeData);
			return node;
		} else {
			System.out.println("Duplicate values not allowed. "+nodeData+" is already present.");
			return node;
		}
	}
	
	// Finding and printing the pair of nodes in BST whose sum is the given sum
	// In case of multiple pairs whose sum equals the given value, the pair [sum/2,sum/2] is not considered since for a pair values need to be distinct, also duplicate values are not allowed in a HashSet
	public void printSumPair(int sum) {
		Set<Set<Integer>> pairs=new HashSet<>(); // Creating a set to collect the pairs of eligible nodes, in case there are multiple eligible pairs
		printSumPair(root,sum,new HashSet<>(),pairs);
		if(pairs.size()==0) {
			System.out.println("No pairs found");
		} else if(pairs.size()==1) {
			System.out.print("Pair is ");
			pairs.forEach(System.out::print);
			System.out.println();
		} else {
			System.out.print("Pairs are ");
			pairs.forEach(System.out::print);
			System.out.println();
		}
	}
	
	public boolean printSumPair(Node node,int sum, Set<Integer> set,Set<Set<Integer>> pairs) {
		if(node==null) {
			return false;
		}
		
		if(printSumPair(node.left,sum,set,pairs)) {
			return true;
		}
		
		if(set.contains(sum-node.nodeData)) {
			LinkedHashSet<Integer> pair=new LinkedHashSet<>(); // Using LinkedHashSet here to preserve the order in which the elements are added in the pair set
			pair.add(sum-node.nodeData);
			pair.add(node.nodeData);
			pairs.add(pair);
		} else {
			set.add(node.nodeData); // Collecting checked nodes in a set for comparison in next iteration
		}
		return printSumPair(node.right,sum,set,pairs);
	}
}
