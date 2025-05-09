package main.java;
import main.java.algoritmos.recursivos.Fibonacci;
//import main.java.algoritmos.recursivos.Fibonacci_melhorado;

public class App {
    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i <= n; i++) {
            System.out.print(Fibonacci.compute(i) + " "); // ou Fibonacci_melhorado.compute(i)
        }
    }
}
