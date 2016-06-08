/*
Little Bob loves chocolate, and he goes to a store with $N in his pocket. The price of each chocolate is $C. The store offers a discount: for every M wrappers he gives to the store, he gets one chocolate for free. How many chocolates does Bob get to eat?

Input Format: 
The first line contains the number of test cases, T. 
 lines follow, each of which contains three integers,N ,C , and M.

Output Format: 
Print the total number of chocolates Bob eats.

Constraints: 
 
1<=T<=1000
2<=N<=10^5
1<=C<=N
2<=M<=N 

Sample input

3
10 2 5
12 4 4
6 2 2
Sample Output

6
3
5
Explanation 
In the first case, he can buy 5 chocolates with \$10 and exchange the 5 wrappers to get one more chocolate. Thus, the total number of chocolates is 6.

In the second case, he can buy 3 chocolates for \$12. However, it takes 4 wrappers to get one more chocolate. He can't avail the offer and hence the total number of chocolates remains 3.

In the third case, he can buy 3 chocolates for \$6. Now he can exchange 2 of the 3 wrappers and get 1 additional piece of chocolate. Now he can use his 1 unused wrapper and the 1 wrapper of the new piece of chocolate to get one more piece of chocolate. So the total is 5.
 */
package Hackerrank;

import java.util.Scanner;

/**
 *
 * @author pulsefire
 */
public class ChocolateFeast {

    
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
        int N=sc.nextInt();
        int C=sc.nextInt();
        int M=sc.nextInt();
           int no_of_wrappers=N/C;
           int extraChocolate;
           int chocolates=no_of_wrappers;
           while(no_of_wrappers>=M)
           {
               extraChocolate=no_of_wrappers/M;
               chocolates+=extraChocolate;
               no_of_wrappers=no_of_wrappers%M+extraChocolate;
           }
        System.out.println(chocolates);
        }
    }
    
}
