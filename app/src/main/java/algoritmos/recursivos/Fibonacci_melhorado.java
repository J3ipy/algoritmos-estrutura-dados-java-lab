package algoritmos.recursivos;

public class Fibonacci_melhorado {

    // Complexidade: O(log n)
    private static long[] fibPair(int n) {
        if (n == 0) {
            // F(0)=0, F(1)=1
            return new long[]{0, 1};
        }
        // Desloca os bits de n uma posição à direita (divide por 2, descarta resto), Dividi por 2
        long[] half = fibPair(n >> 1);
        long a = half[0]; // F(k)
        long b = half[1]; // F(k+1)

        // c = F(2k) | F(2k) = F(k) [2F(k+1) − F(k)]
        // d = F(2k+1) = F(k)² + F(k+1)²
        long c = a * (2 * b - a);
        long d = a * a + b * b;

        if ((n & 1) == 0) {
            // n par: retorna [F(2k), F(2k+1)]
            return new long[]{c, d};
        } else {
            // n ímpar: retorna [F(2k+1), F(2k+2)]
            return new long[]{d, c + d};
        }
    }

    /** Retorna F(n) */
    public static long compute(int n) {
        return fibPair(n)[0];
    }
}
