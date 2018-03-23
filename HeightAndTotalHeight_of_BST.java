package HackerRank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HeightAndTotalHeight_of_BST {
	Node root;
	private static Scanner in;
	//private static int sum =0;
	
	public HeightAndTotalHeight_of_BST() {
		//super();
		root = null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int item;
		HeightAndTotalHeight_of_BST tree = new HeightAndTotalHeight_of_BST();
		in=new Scanner(System.in);
		int n = in.nextInt();
		int output [] = new int[2];
		//int tree_array[] = new int [n];
		for (int i =0; i<n ; i++)
		{
			//tree_array[i] = in.nextInt();
			tree.root=tree.insert(tree.root,in.nextInt());
		}
		output = tree.heightAndTotalHeight(tree.root);
		for (int i = 0;i<2;i++)
			System.out.println(output[i]);
	}

	private Node insert(Node m, int data) {
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
		return m;
	}
	private int[] heightAndTotalHeight(Node root) {
        // Write your code here.
		int arr[] = new int[2];
		 arr[0] = height(root);
         arr[1] = totalHeight(root);
         return arr;
    }
	
	private int totalHeight(Node root2) {
		// TODO Auto-generated method stub
		if(root == null) return -1;
		Queue <Node>Q=new LinkedList<Node>();
		Q.add(root); int sum =0; 
		//while there is at least one discovered node
		while(!Q.isEmpty()) {
			Node current = Q.peek();
			Q.remove(); // removing the element at front
			//System.out.print(current.data+" ");//current->data<<" ";
			sum+=height(current);
			if(current.left != null) 
				Q.add(current.left);
			if(current.right != null) 
				Q.add(current.right);
		}
		//System.out.println();
		return sum;
	}

	
	
	private int height(Node root) {
      	// Write your code here.
        if(root==null)
            return -1;
        int lftHeight=height(root.left);
        int rightHeight=height(root.right);
        return (Math.max(lftHeight,rightHeight)+1);
    }


}
