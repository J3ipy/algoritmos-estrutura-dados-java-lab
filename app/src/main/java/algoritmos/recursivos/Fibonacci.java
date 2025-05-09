package main.java.algoritmos.recursivos;

public class Fibonacci {

    //Utilizei o cache para que a função possa reusar valores que já foram calculados, reduzindo redundância computacional (Memoization)
    //Complexidade O(n), por conta da utilização da Memorização
    //Se não usasse iria gerar uma ávore exponencial de chamadas | T(n) = T(n - 1) + T(n - 2) + O(1) => T(n) = O(alfa^n)
    private static long[] cache;

    private static long fibonacci(int n){
        // Caso base se n == 0, retorna 0, se n == 1, retorna 1
        if(n <= 1){
            return n;
        }
        // se o cache na posição n já foi preenchido, retorna o valor imediatamente
        if(cache[n] != 0){
            return cache[n];
        }
        
        //lógica da sequência de Fibonacci 0, 1, 1, 2, 3, 5, 8... 
        // f(n) = f(n - 1) + f(n - 2)
        // F(0) = 0, F(1) = 1, F(n)= F(n−1) + F(n−2), n≥2.
        long n_numerofibonacci = (fibonacci(n - 1) + fibonacci(n - 2));

        //armazena o valor na posição n do cache
        cache[n] = n_numerofibonacci;

        //retorna o valor encontrado
        return n_numerofibonacci;
    }

    //Fiz esse metodo compute por conta de segurança
    public static long compute(int n){
        if (cache == null || cache.length <= n){
            cache = new long[n + 1];
        }
        return fibonacci(n);
    }
}
