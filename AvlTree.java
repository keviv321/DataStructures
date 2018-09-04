package HackerRank;

import java.util.Scanner;

public class AvlTree {
	Node root;
	private static Scanner ob;

	public  AvlTree(){
		root=null;
	}


	private Node insert(Node m,int data) {
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

		m.height=1+Math.max(height(m.left), height(m.right));
		//System.out.println(m.height);
		int balance=getBalance(m);

		//LL Problem
		if (balance>1 &&height(root.left.left) >= height(root.left.right))
			return rotateRight(m);

		//RR Problem
		else if(balance<-1&&height(root.right.right) >= height(root.right.left))
			return rotateLeft(m);

		//LR Problem
		else if(balance>1&&height(root.left.left) < height(root.left.right))
		{
			m = rotateRight(m);
			return rotateLeft(m);
			
		}

		//RL Problem
		else if(balance<-1&&height(root.right.right) <height(root.right.left))
		{
			m = rotateLeft(m);
			return rotateRight(m);
		}
		return m;


	}

	private Node rotateLeft(Node m) {
		Node y=m.right;
		Node temp;//=null;
		//if (y!=null)
			temp=y.left;

		//perform rotation
		y.left=m;
		m.right=temp;
		

		//Update height
		y.height=Math.max(height(y.left), height(y.right))+1;
		m.height=Math.max(height(m.left), height(m.right))+1;

		return y;
		// TODO Auto-generated method stub

	}

	private Node rotateRight(Node m) {
		// TODO Auto-generated method stub
		Node y=m.left;
		Node temp;//=null;
		//if (y!=null)
			temp=y.right;

		//perform Rotation
		y.right=m;
		m.left=temp;

		//Update height
		y.height=Math.max(height(y.left), height(y.right))+1;
		m.height=Math.max(height(m.left), height(m.right))+1;

		return y;
	}

	private int getBalance(Node m) {
		// TODO Auto-generated method stub
		if (m==null)
			return 0;
		return height(m.left)-height(m.right);
	}

	private int height(Node right) {
		// TODO Auto-generated method stub
		if (right==null)
			return -1;

		return (right.height);
	}

	public static void main(String args[])
	{
		AvlTree brnch = new AvlTree();
		//brnch.root=null;
		ob=new Scanner(System.in);
		int choice,value;
		while(true)
		{
			System.out.println("Enter your choice");
			choice=ob.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter the node value");
				value=ob.nextInt();
				brnch.root=brnch.insert(brnch.root,value);
				break;
			case 2:
				brnch.printTree(brnch.root);
				System.out.println();
				break;
			case 3:
				System.out.println("Enter the value to be deleted");
				value = ob.nextInt();
				brnch.root = brnch.deleteNode(brnch.root , value);
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Input");
				break;
			}
		}
		//in.close();
	}

	private Node deleteNode(Node root2, int value) {
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
		root2.height=1+Math.max(height(root2.left), height(root2.right));
		//System.out.println(m.height);
		int balance=getBalance(root2);

		//LL Problem
		if (balance>1 &&height(root.left.left) >= height(root.left.right))
			return rotateRight(root2);

		//RR Problem
		else if(balance<-1&&height(root.right.right) >= height(root.right.left))
			return rotateLeft(root2);

		//LR Problem
		else if(balance>1&&height(root.left.left) < height(root.left.right))
		{
			root2 = rotateRight(root2);
			return rotateLeft(root2);
			
		}

		//RL Problem
		else if(balance<-1&&height(root.right.right) <height(root.right.left))
		{
			root2 = rotateLeft(root2);
			return rotateRight(root2);
		}
		
		return root2;
	}
	
	private int findMax(Node right) {
		// TODO Auto-generated method stub
		if (right.right == null)
			return right.data;
		else
			return findMax(right.right);
		//return right.data;
	}


	private  void printTree(Node temp) //In-Order Traversal
	{
		// TODO Auto-generated method stub
		if(temp==null)
			return;
		printTree(temp.left);
		System.out.print(temp.data+" ");
		printTree(temp.right);
	}
	
	

}
