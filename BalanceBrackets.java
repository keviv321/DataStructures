package HackerRank;

import java.util.Scanner;
import java.util.Stack;

public class BalanceBrackets {
	Stack<Character> brackets;

	public static void main(String[] args) {
		BalanceBrackets bb;
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		in.skip("[\r\n]+");
		for (int a0 = 0; a0 < t; a0++) {
			bb = new BalanceBrackets();
			String s = in.nextLine();
			bb.brackets = new Stack<Character>();
			String result = bb.isBalanced(s);
			System.out.println( result);
		}
		in.close();
	}

	private String isBalanced(String s) {
		if (s.length() % 2 == 0) {
			Character c, c1;
			for (int i = 0; i < s.length(); i++) {
				c = s.charAt(i);
				if (c.equals('(') || c.equals ('{') || c.equals('['))
					brackets.push(c);
				else {
					if (brackets.isEmpty())
						return "NO";
					else {
						c1 = brackets.pop();
						String b = c1 + "" + c;
						if (b.equals( "{}") || b.equals ("[]") ||  b.equals("()")) {

						} else
							return "NO";

					}

				}

			}
			if(brackets.isEmpty())
				return "YES";
			else
				return "NO";

		} else
			return "NO";

	}

}
