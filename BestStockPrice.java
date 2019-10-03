package DCP;

import java.util.Scanner;

public class BestStockPrice {

	public static void main(String args[]) {
		Scanner sc  = new Scanner(System.in);
		String line = sc.nextLine();
		String[] linelets = line.split(" ");
		int[] top=new int[linelets.length];
		int[] left=new int[linelets.length];
		int[][] ans = new int[left.length][top.length];
		int[][] from = new int[left.length][top.length];
		for(int i=0;i<linelets.length;i++) {
			top[i]=Integer.parseInt(linelets[i]);
			left[i]=Integer.parseInt(linelets[i]);
		}
		//logic
		for(int i=0;i<left.length;i++) {
			for(int j=0;j<top.length;j++) {
				if(j<=i) {
					if(i!=0) {
						ans[i][j]=ans[i-1][j];
						from[i][j]=from[i-1][j];
					}else {
						ans[i][j]=0;
						from[i][j]=0;
					}
					
				}else {
					int diff = top[j]-left[i];
					if(i>0) {
						if(diff>ans[i-1][j]) {
							ans[i][j]=diff;
							from[i][j]=i;
						}else {
							ans[i][j]=ans[i-1][j];
							from[i][j]=from[i-1][j];
						}
					}else {
						ans[i][j]=diff;
					}
					
				}
			}
		}
		
		for(int i=0;i<left.length;i++) {
			for(int j=0;j<top.length;j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
		
		for(int i=0;i<left.length;i++) {
			for(int j=0;j<top.length;j++) {
				System.out.print(from[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(left[from[left.length-1][left.length-1]]);
	}
}
