package DS;

class Stack<T>
{
	private DLL root;
	private class DLL{
		T data;
		DLL  next;
		DLL  prev;
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
	}

	public T peek()
	{
		return root.data;
	}

	public Boolean isEmpty()
	{
		return (root==null)?true:false;
	}
	
}


