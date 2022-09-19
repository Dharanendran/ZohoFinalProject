package ticketbooking;

import java.util.*;

public class program {
	public static void main(String[] args) {
		int[] input1 = {-1,1,-1,2};
		System.out.println(findSmallestPrimeIndex(input1));
	}

	public static int findSmallestPrimeIndex(int[] input1) {
		int res=-2;
		  if(input1.length==0)
		   return res;
		  
		  int min=Integer.MAX_VALUE;
		  System.out.print(min);
		  for(int i=input1.length-1;i>=0;i--) {
		   int p=0;
		   if(!(input1[i]>=2))
		    continue;
		   if(input1[i]==2)
		    return i;
		   
		   else {
		    for(int j=2;j<=input1[i]/2;j++) {
		     if(input1[i]%j==0)
		      p=1;
		    }
		    if(p==0 && input1[i]<min) {
		     min=input1[i];
		     res=i;
		    }
		   }
		  }
		  
		  if(min!=Integer.MAX_VALUE)
		   return res;
		  else
		   return -1;
	}

}