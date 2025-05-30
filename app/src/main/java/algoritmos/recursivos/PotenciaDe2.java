package algoritmos.recursivos;

public class PotenciaDe2 {
    public static int potenciaDe2Recursivo(int n){
        if(n == 0){
            return 1;
        }
        else{
            return 2 * potenciaDe2Recursivo(n -1);
        }
    }

    public static int potenciaDe2Iterativo(int n){
        int i, potencia = 1;
        if(n == 0){
            return 1;
        }
        else{
            for(i = 1; i <= n; i++){
                potencia = potencia * 2;
            }
            return potencia;
        }
    }

    public static void main (String[] args){
        int n = 20;
        

        //Medição do tempo para versão recursiva
        long inicioRecursivo = System.nanoTime();
        int resultadoRecursivo = potenciaDe2Recursivo(n);
        long fimRecursivo = System.nanoTime();
        long tempoRecursivo = fimRecursivo - inicioRecursivo;


        //Medição do tempo para versão iterativo
        long inicioIterativo = System.nanoTime();
        int resultadoIterativo= potenciaDe2Iterativo(n);
        long fimIterativo = System.nanoTime();
        long tempoIterativo = fimIterativo - inicioIterativo;

        //Apresentação dos resultados medidos
        System.out.println("Resultado Recursivo: " + resultadoRecursivo);
        System.out.println("Tempo Recursivo (ns): " + tempoRecursivo);
        System.out.println("Resultado Iterativo " + resultadoIterativo);
        System.out.println("Tempo Iterativo (ns): " + tempoIterativo);
        System.out.println("Diferença (ns): " + (tempoRecursivo - tempoIterativo));
    }
}
