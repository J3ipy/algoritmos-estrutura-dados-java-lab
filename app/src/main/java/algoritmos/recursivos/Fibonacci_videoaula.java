package algoritmos.recursivos;

public class Fibonacci_videoaula {


    public static int fibonacciRecursivo(int n){
        if((n == 0) || (n == 1)){
            return n;
        }else{
            return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
        }
    }

    public static void main(String[] args){
        int n = 9;
        int resultado = fibonacciRecursivo(n);
        System.out.print(resultado);
    }
}
