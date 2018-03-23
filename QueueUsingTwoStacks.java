package HackerRank;

//import java.util.LinkedList;
//import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

@SuppressWarnings("serial")
public class QueueUsingTwoStacks {
	//Stack <Integer> Q;



	public static void main(String args[])
	{
		Queue enqueue = new Queue();
		Scanner in=new Scanner(System.in);
		int queries=in.nextInt();
		int choice;Integer value;
		while(queries-->0)
		{
			//ob=new QueueUsingTwoStacks();
			//ob.Q=new Stack<Integer>();
			choice=in.nextInt();
			if (choice==1)
			{
				value=in.nextInt();
				enqueue.push(value);
			}
			else if(choice==2)
			{
				enqueue.pop();
			}
			else if(choice==3)
				System.out.println(enqueue.peek());//ob.Q.peek();
		}

		in.close();
	}
}

class Queue extends Stack<Integer>{

	@Override
	public  Integer peek() {
		// TODO Auto-generated method stub
		Stack <Integer> dequeue=new Stack <Integer>();

		while(!super.isEmpty())
		{
			dequeue.push(super.pop());
		}
		Integer ob = dequeue.peek();
		while(!dequeue.isEmpty())
		{
			this.push(dequeue.pop());
		}
		return ob;
	}



	@Override
	public  Integer pop() {
		// TODO Auto-generated method stub
		Stack <Integer> obj=new Stack <Integer>();
		Integer i;
		while(!this.isEmpty())
		{
			i=super.pop();
			obj.push(i);
		}
		Integer o=obj.pop();
		while(!obj.isEmpty())
		{
			i=obj.pop();
			super.push(i);
		}
		return o;
	}

}
