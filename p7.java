package cs21as07;

import java.util.Scanner;

/**
 * CS21 Assignment 07 Binary Search Tree
 * filename: p7.java
 * main file for assignment 07
 *
 * @author Joseph Chung, materialstuff@live.com jjchung
 * @version 1.0
 */

public class p7 {
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		String input = "";
		Scanner stdin = new Scanner(System.in);
		while(stdin.hasNextLine()) {
			input = stdin.nextLine().trim();
			if (input.substring(0).contains("#"))
				input = input.substring(0, input.indexOf("#")).trim();
			String[] arr = input.split(" ");
			if (arr.length > 0) {
				switch(arr[0]) {			
				case "search":
					if (arr.length == 2 && arr[1].matches("\\d+"))
						tree.searchNode(Integer.valueOf(arr[1]));
					break;			
				case "insert":
					if (arr.length == 2 && arr[1].matches("\\d+"))
						tree.insertNode(Integer.valueOf(arr[1]));
					break;			
				case "delete":
					if (arr.length == 2 && arr[1].matches("\\d+"))
						tree.deleteNode(Integer.valueOf(arr[1]));
					break;				
				case "min":
					if (arr.length == 1)
						tree.getMin();
					break;			
				case "max":
					if (arr.length == 1)
						tree.getMax();
					break;			
				case "predecessor":
					if (arr.length == 2 && arr[1].matches("\\d+"))
						tree.getPredecessor(Integer.valueOf(arr[1]));
					break;				
				case "successor":
					if (arr.length == 2 && arr[1].matches("\\d+"))
						tree.getSuccessor(Integer.valueOf(arr[1]));
					break;
				case "inorder":
					if (arr.length == 1)
						tree.printInOrder();
					break;
				case "preorder":
					if (arr.length == 1)
						tree.printPreOrder();
					break;
				case "postorder":
					if (arr.length == 1)
						tree.printPostOrder();
					break;
				}
			}
		}
	}
}
