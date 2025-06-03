package estruturas.naolineares.dinamicas.arvorebinaria;

public class AppArvoreBinaria {
    public static void main(String[] args) {

        // Criando Nós
        INoArvoreBinaria<String> raiz = new NoArvoreBinaria<>("A");
        INoArvoreBinaria<String> noB = new NoArvoreBinaria<>("B");
        INoArvoreBinaria<String> noC = new NoArvoreBinaria<>("C");
        INoArvoreBinaria<String> noD = new NoArvoreBinaria<>("D");
        INoArvoreBinaria<String> noE = new NoArvoreBinaria<>("E");
        INoArvoreBinaria<String> noF = new NoArvoreBinaria<>("F");
        INoArvoreBinaria<String> noG = new NoArvoreBinaria<>("G");
        INoArvoreBinaria<String> noH = new NoArvoreBinaria<>("H");

        // Montando a estrutura da árvore:
        //      A
        //     / \
        //    B   C
        //   / \   \
        //  E   D   F
        //         / \
        //        G   H
        raiz.definirNoEsquerdo(noB);
        raiz.definirNoDireito(noC);
        noB.definirNoEsquerdo(noE);
        noB.definirNoDireito(noD);
        noC.definirNoDireito(noF);
        noF.definirNoEsquerdo(noG);
        noF.definirNoDireito(noH);

        // Cria a Árvore
        IArvoreBinaria<String> arvore = new ArvoreBinariaSimples<>(raiz);

        System.out.println("## Propriedades da Árvore ##");
        System.out.println("Árvore Vazia: " + arvore.estaVazia());         // Esperado: false
        System.out.println("Tamanho da árvore: " + arvore.tamanho());       // Esperado: 8
        System.out.println("Altura da árvore: " + arvore.altura());        // Esperado: 3
        System.out.println("Grau da árvore: " + arvore.grau());           // Esperado: 2
        System.out.println("Número de arestas: " + arvore.arestas());      // Esperado: 7
        System.out.println("Nível do nó 'A': " + arvore.nivelNo("A"));    // Esperado: 0
        System.out.println("Nível do nó 'F': " + arvore.nivelNo("F"));    // Esperado: 2
        System.out.println("Nível do nó 'H': " + arvore.nivelNo("H"));    // Esperado: 3

        System.out.println("\n## Percursos na Árvore ##");

        System.out.print("Pré-Ordem:     ");
        arvore.percorrerPreOrdem(dado -> System.out.print(dado + " "));  // Esperado: A B E D C F G H
        System.out.println();

        System.out.print("Em-Ordem:      ");
        arvore.percorrerEmOrdem(dado -> System.out.print(dado + " "));   // Esperado: E B D A C G F H
        System.out.println();

        System.out.print("Pós-Ordem:     ");
        arvore.percorrerPosOrdem(dado -> System.out.print(dado + " "));  // Esperado: E D B G H F C A
        System.out.println();

        System.out.print("Ordem em Nível: ");
        arvore.percorrerEmOrdemNivel(dado -> System.out.print(dado + " ")); // Esperado: A B C E D F G H
        System.out.println();
    }
}