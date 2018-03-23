package HackerRank;

import java.util.Scanner;

public class Kaprekar_Num {
	public static void main(String args[])
	{
		Scanner in = new Scanner (System.in);
		int lwr_limit = in.nextInt();
		int upr_limit = in.nextInt();
		for (int i = lwr_limit;i <= upr_limit;i++)
		{
			int num = i;//in.nextInt();
			long sqr = (long)num*num;//System.out.println(sqr);
			int digits = count_No_digits(num);
			int ld = (int) (sqr % Math.pow(10,digits));
			int rd = (int)(sqr / Math.pow(10,digits));	//System.out.println(ld+" "+rd);	
			if (ld+rd == num)
				System.out.print(num+" ");
			//else
			//System.out.println("Not a Kaprekar number");
		}
		in.close();
	}

	private static int count_No_digits(int num) {
		// TODO Auto-generated method stub
		int count = 0;
		while (num != 0)
		{
			count++;
			num/=10;
		}
		return count;
	}

}
