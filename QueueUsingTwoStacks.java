package DS;
import java.util.Scanner;
import java.util.Stack;

class Queue
{

	private Stack<Integer> q = new Stack<Integer>();
	private Stack<Integer> temp = new Stack<Integer>();


	public void enqueue(int val)
	{
		q.push(val);
	}

	public void dequeue()
	{

		if(temp.isEmpty()){
			while (!q.isEmpty())
			{
				temp.push(q.pop());
			}
		}
		temp.pop();

	}

	public Integer printHead()
	{

		if(temp.isEmpty())
		{
			while (!q.isEmpty())
			{
				temp.push(q.pop());
			}
		}
		return temp.peek();
	}

}
