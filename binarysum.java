import java.util.Scanner;
public class binarysum{
    public static void main (String[]args){
        Scanner sc=new Scanner(System.in);
        binarysum obj=new binarysum ();
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println(obj.adder(a,b));
        sc.close();
      
    }

    public int adder(int a, int b){
          int carry,sum=0;
        while(b!=0){
            sum=a^b;
            carry=(a&b)<<1;
            a=sum;
            b=carry;

        }
        return sum;
    }
}