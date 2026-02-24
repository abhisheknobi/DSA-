package Step8_BitManipulation;

public class DecToBinary {

    public static String func(int n){
        String res="";
        while(n!=1){
            if(n%2==0){
                res="0"+res;
            } else {
                res="1"+res;
            }
            n=n/2;
        }
        res="1"+res;
        return new StringBuilder(res).reverse().toString();


    }
    public static void main(String[] args) {
        int n=10;
        System.out.println(func(n));
        
    }
    
}
