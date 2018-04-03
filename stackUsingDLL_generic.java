package programs;

import java.util.Scanner;

class Stack<T>
{
	private DLL root;
	private class DLL{
		T data;
		DLL  next;
		DLL  prev;
		//private Object root;
		//public DLL(){}
		public DLL(T data)
		{
			super();
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	public Stack() {
		super();
		this.root = null;
	}

	public void push(T data)
	{
		DLL temp = new DLL(data);
		if (root == null)
			root = temp;
		else
		{
			temp.next = root;
			root.prev = temp;
			root = temp;
		}
		//return root;
	}

	public void pop()
	{
		try
		{
			if (root.next != null)
			{
				DLL temp = root;
				root = root.next;
				temp.next = null;
				root.prev = null;
			}
			else
				root = root.next;
		}
		catch(Exception e)
		{
			System.err.println("Stack empty!!!");
		}
		//return root;
	}

	public T peek()
	{
		return root.data;
	}

	public Boolean isEmpty()
	{
		return (root==null)?true:false;
	}
	/*@Override
	public String toString(){
		return this.data.toString();
	}*/


}

public class stackUsingDLL_generic {

	public static void main(String args[])
	{
		Stack<Integer> stack = new Stack<Integer>();
		@SuppressWarnings("resource")
		Scanner in = new Scanner (System.in);
		System.out.println("Enter \n1.Push an element in the stack \n2.Pop out an element from the stack\n3.View topmost element of the stack");
		while (true)
		{
			int choice = in.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter the data to be entered into the stack ");
				stack.push(in.nextInt());
				break;
			case 2:
				stack.pop();
				break;
			case 3:
				if (!stack.isEmpty())
					System.out.println("The topmost element of the stack : "+stack.peek());
				else
					System.out.println("stack is empty");
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("Wrong choice entered");
				break;
			}
		}
		
	}
}
