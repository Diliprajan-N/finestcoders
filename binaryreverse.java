public class binaryreverse {
    public static void main(String[]args){
        int num =2147483644;
        int decimal=0;
        StringBuilder sb=new StringBuilder();
     for (int i = 31; i >= 0; i--) {
          int bit = (num >> i) & 1;
           sb.append(bit);
        
}
       sb.reverse();
        System.out.println(sb);
        for(int i=0;i<sb.length();i++){
            int bit=sb.charAt(sb.length()-1-i)-'0';
            decimal+=bit*Math.pow(2,i);
        }
        System.out.println(sb);
        System.out.println(decimal);
    }
}