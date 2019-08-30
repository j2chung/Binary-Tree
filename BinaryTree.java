package cs21as07;

/**
 * CS21 Assignment 07 Binary Search Tree
 * filename: BinaryTree.java
 * Binary Tree for assignment 07
 *
 * @author Joseph Chung, materialstuff@live.com jjchung
 * @version 1.0
 */

public class BinaryTree {
	class Node {
		private int key; //data
		private Node left;
		private Node right;
		private Node parent;
		
		Node() {
			left = right = parent = null;
		}
	}
	
	private Node root;
	
	BinaryTree() {
		root = null;
	}
	

	private String inOrder(Node x, StringBuilder sb) {
		if (x == null) return "";
		inOrder(x.left, sb);
		sb.append(x.key + " ");
		inOrder(x.right, sb);
		return sb.toString();
	}
	
	private String preOrder(Node x, StringBuilder sb) {
		if (x == null) return "";
		sb.append(x.key + " ");
		preOrder(x.left, sb);
		preOrder(x.right, sb);
		return sb.toString();
	}
	
	private String postOrder(Node x, StringBuilder sb) {
		if (x == null) return "";
		postOrder(x.left, sb);
		postOrder(x.right , sb);
		sb.append(x.key + " ");
		return sb.toString();
	}
	
	private Node search(Node x, int key) {
		if (x == null || x.key == key) return x;
		if (key < x.key) {
			return search(x.left, key);
		} else {
			return search(x.right, key);
		}
	}
	
	private Node min(Node x) {
		while(x.left != null)
			x = x.left;
		return x;
	}
	
	private Node max(Node x) {
		while(x.right != null)
			x = x.right;
		return x;
	}
	
	private Node successor(Node x) {
		if (x.right != null) 
			return min(x.right);
		Node temp = x.parent;
		while (temp != null && x == temp.right) {
			x = temp;
			temp = temp.parent;
		}
		return temp;
	}
	
	private Node predecessor(Node x) {
		if (x.left != null) 
			return max(x.left);
		Node temp = x.parent;
		while (temp != null && x == temp.left) {
			x = temp;
			temp = temp.parent;
		}
		return temp;
	}
	
	private void insert(Node n) {
		Node parent = null;
		Node temp = root;
		while (temp != null) {
			parent = temp;
			if (n.key < temp.key) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		n.parent = parent;
		if (parent == null) {
			root = n;
			return;
		}
		if (n.key < parent.key) {
			parent.left = n;
		} else {
			parent.right = n;
		}
	}

	
	private void delete(Node n) {
		Node x;
		Node target;
		if (n.left == null || n.right == null) {
			target = n;
		} else {
			target = successor(n);
		}
		if (target.left != null) {
			x = target.left;
		} else {
			x = target.right;
		}
		if (x != null) {
			x.parent = target.parent;
		}
		if (target.parent == null) {
			root = x;
		} else if (target == target.parent.left) {
			target.parent.left = x;
		} else {
			if (target != n) {
				n = target;
			}
		}
	}
	
	public void printInOrder() {
		StringBuilder sb = new StringBuilder();
		System.out.println("inorder traversal:\n" + inOrder(root, sb).trim());
	}
	
	public void printPreOrder() {
		StringBuilder sb = new StringBuilder();
		System.out.println("preorder traversal:\n" + preOrder(root, sb).trim());
	}
	
	public void printPostOrder() {
		StringBuilder sb = new StringBuilder();
		System.out.println("postorder traversal:\n" + postOrder(root, sb).trim());
	}
	
	public void getMin() {
		if (root != null) {
			System.out.println("min is " + min(root).key + ".");
		}
	}
	
	public void getMax() {
		if (root != null) {
			System.out.println("max is " + max(root).key + ".");
		}
	}
	
	public void getSuccessor(int key) {
		Node temp = search(root, key);
		if(temp != null && successor(temp) != null) {
			System.out.println(key + " successor is " + successor(temp).key); 
		} else {
			System.out.println("no successor for " + key + ".");
		}
	}
	
	public void getPredecessor(int key) {
		Node temp = search(root, key);
		if(temp != null && predecessor(temp) != null) {
			System.out.println(key + " predecessor is " + predecessor(temp).key); 
		} else {
			System.out.println("no predecessor for " + key + ".");
		}
	}
	
	public void searchNode(int key) {
		if (search(root, key) != null) {
			System.out.println(key + " found.");
		} else {
			System.out.println(key + " not found.");
		}
	}
	
	public void insertNode(int key) {
		Node temp = new Node();
		temp.key = key;
		insert(temp);
		System.out.println("inserted " + key + ".");
	}
	
	public void deleteNode(int key) {
		Node temp = search(root, key);
		if (temp == null) {
			System.out.println(key + " - not found.");
		} else { 
			delete(temp);
			System.out.println("deleted " + key + ".");
		}
	}
}
