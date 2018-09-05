package DS;

import java.util.Scanner;

class AvlTree {
	
	Node root;
	private static Scanner ob;

	public  AvlTree(){
		root=null;
	}


	public Node insert(Node m,int data) {
		// TODO Auto-generated method stub
		if(m==null)
		{
			Node temp=new Node(data);
			m=temp;

		}
		else if(m.data>data)
		{
			m.left=insert(m.left,data);
		}
		else if(m.data<data)
		{
			m.right=insert(m.right,data);
		}
		else 
			return m;

		return rebalance(m);
	}

	private Node rotateLeft(Node m) {
		// TODO Auto-generated method stub
		Node y=m.right;
		Node temp;
		temp=y.left;

		//perform rotation
		y.left=m;
		m.right=temp;
		

		//Update height
		y.height=Math.max(height(y.left), height(y.right))+1;
		m.height=Math.max(height(m.left), height(m.right))+1;

		return y;
		
	}

	private Node rotateRight(Node m) {
		// TODO Auto-generated method stub
		Node y=m.left;
		Node temp;
		temp=y.right;

		//perform Rotation
		y.right=m;
		m.left=temp;

		//Update height
		y.height=Math.max(height(y.left), height(y.right))+1;
		m.height=Math.max(height(m.left), height(m.right))+1;

		return y;
	}
	
	//Method to calculate Balancing Factor 
	private int getBalance(Node m) {
		// TODO Auto-generated method stub
		if (m==null)
			return 0;
		return height(m.left)-height(m.right);
	}
	
	//Height of a node 
	private int height(Node right) {
		// TODO Auto-generated method stub
		if (right==null)
			return -1;

		return (right.height);
	}

	
	//Method to delete a Node from the AVL Tree
	public Node deleteNode(Node root2, int value) {
		// TODO Auto-generated method stub
		
		if (root2 == null)
			return root2;
		else if (root2.data < value)
			root2.right =  deleteNode(root2.right , value);
		else if (root2.data > value)
			root2.left = deleteNode(root2.left , value);
		else
		{
			if (root2.left==null)
				return root2.right;
			else if (root2.right == null)
				return root2.left;
			else
			{
				root2.data = findMax(root2.left);
				root2.left = deleteNode(root2.left , root2.data);
			}
		}
		return rebalance(root2);
	}
	
	public Node search (int key)
	{
		return search (root , key);
	}
	
	private Node search (Node root , int key)
	{
		if (root == null || root.data == key)
			return root;
		else if (root.data > key)
			return search (root.left , key);
		return search(root.right , key);
	}
	
	/*
	*Method to rebalance the tree
	*/
	private Node rebalance(Node root2)
	{
		//Updating height of every node
		root2.height=1+Math.max(height(root2.left), height(root2.right));
	
		//Calculating the balance factor
		int balance = getBalance(root2);

		//Solution to LL Problem
		if (balance>1 &&height(root.left.left) >= height(root.left.right))
			return rotateRight(root2);

		//Solution to RR Problem
		else if(balance<-1&&height(root.right.right) >= height(root.right.left))
			return rotateLeft(root2);

		//Solution to LR Problem
		else if(balance>1&&height(root.left.left) < height(root.left.right))
		{
			root2 = rotateRight(root2);
			return rotateLeft(root2);
			
		}

		//Solution to RL Problem
		else if(balance<-1&&height(root.right.right) <height(root.right.left))
		{
			root2 = rotateLeft(root2);
			return rotateRight(root2);
		}
		return root2;
	}
	
	
	/*
	*Finding Maximum value from the subtree
	*/
	private int findMax(Node right) {
		// TODO Auto-generated method stub
		if (right.right == null)
			return right.data;
		else
			return findMax(right.right);
	}

	
	//In-Order Traversal of the AVL Tree
	public  void toString(Node temp) 
	{
		// TODO Auto-generated method stub
		if(temp==null)
			return;
		toString (temp.left);
		System.out.print (temp.data+" ");
		toString (temp.right);
	}
}
