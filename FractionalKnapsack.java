import java.util.*;
public class FractionalKnapsack {
    public static void main(String args[])
    {
        int n;
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter the number of items");
        n=scn.nextInt();
        int w[]=new int[n];
        int p[]=new int[n];
        System.out.println("Enter the weights of the items");
        for(int i=0;i<n;i++)
        {
            w[i]=scn.nextInt();
        }
        System.out.println("Enter the profits of the items");
        for(int i=0;i<n;i++)
        {
            p[i]=scn.nextInt();
        }
        System.out.println("Enter the capacity of the knapsack");
        int c=scn.nextInt();
        double r[]=new double[n];
        for(int i=0;i<n;i++)
        {
            r[i]=(double)p[i]/w[i];
        }
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(r[i]<r[j])
                {
                    double temp=r[i];
                    r[i]=r[j];
                    r[j]=temp;
                    int temp1=w[i];
                    w[i]=w[j];
                    w[j]=temp1;
                    int temp2=p[i];
                    p[i]=p[j];
                    p[j]=temp2;
                }
            }
        }
        double profit=0;
        for(int i=0;i<n;i++)
        {
            if(c>=w[i])
            {
                profit+=p[i];
                c-=w[i];
            }
            else
            {
                profit+=r[i]*c;
                break;
            }
        }
        System.out.println("The maximum profit is "+profit);
    }
}
