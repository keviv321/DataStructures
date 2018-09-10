package HackerRank;

import java.util.Scanner;

public class GameOfTwoStacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		int games = in.nextInt();
		int stck1[] , stck2[] , sum;
		while (games-- > 0)
		{
			stck1 = new int[in.nextInt()];
			stck2 = new int[in.nextInt()];
			sum = in.nextInt();
			for (int i = 0 ; i < stck1.length ; i++)
				stck1[i] = in.nextInt();
			for (int i = 0 ; i < stck2.length ; i++)
				stck2[i] = in.nextInt();
			gaming(stck1 , stck2 ,sum);
		}
		in.close();
	}

	private static void gaming(int[] stck1, int[] stck2, int x) {
		// TODO Auto-generated method stub
		int top1 = 0 , top2 = 0 , sum = 0;
		int len1 = stck1.length;
		int len2 = stck2.length;
		int count = 0 ;
		while (top1 < len1 && sum+stck1[top1] <= x)
		{
			sum += stck1[top1];
			top1++;
		}
		count = top1;
		while (top2 < len2 && top1 >= 0)
		{
			sum += stck2[top2];
			top2++;
			while (sum > x && top1 > 0)
			{
				top1--;
				sum -= stck1[top1];
			}
			if (sum <= x && top1+top2 > count)
				count = top1 + top2;
		}
		System.out.println(count);
	}

}
