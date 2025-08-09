package ways;

//找质数

public class test2 {
    public static void main(String[] args) {
        int a = 101;
        int b = 200;
        System.out.println(a + "到" + b + "之间的质数：" );
        findPrime(a,b);
    }

    public static void findPrime(int a,int b){
        for (int i = a; i <= b; i++){
            for(int j = 2; j <= i; j++){
                if(i % j == 0 && j != i){
                    break;
                }
                else if(j == i){
                    System.out.print(j + " ");
                }
            }
        }
    }
}
