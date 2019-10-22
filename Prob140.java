package DCP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Prob140 {

	public static void main(String args[]) {
		Stack<Integer> st = new Stack<Integer>();
		Scanner sc = new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		LinkedList<Integer> input = new LinkedList<Integer>();
		for(int i=0;i<n;i++) {
			int inp = Integer.parseInt(sc.nextLine());
			input.add(inp);
		}
		Collections.sort(input);
		System.out.println(input);
		int i=0;
		int prev=0;
		while(i<input.size()-1) {
			if(input.get(i+1)!=prev) {
				st.add(input.get(i));
			}else {
				st.pop();
			}
			System.out.println(st);
			prev=input.get(i);
			i++;
		}
		System.out.println(st);
	}
}
