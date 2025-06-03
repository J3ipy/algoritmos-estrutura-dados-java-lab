package estruturas.naolineares.dinamicas.arvorebinaria;

import java.util.function.Consumer;

public class ArvoreBinariaSimples<T> implements IArvoreBinaria<T> {

    private INoArvoreBinaria<T> noRaiz;

    public ArvoreBinariaSimples() {
    }

    public ArvoreBinariaSimples(INoArvoreBinaria<T> noRaiz) {
        this.noRaiz = noRaiz;
    }

    @Override
    public INoArvoreBinaria<T> obterNoRaiz() {
        return this.noRaiz;
    }

    @Override
    public void definirNoRaiz(INoArvoreBinaria<T> noRaiz) {
        this.noRaiz = noRaiz;
    }

    // OK
    @Override
    public int tamanho() {
        if (this.estaVazia()) {
            return 0;
        }
        return this.noRaiz.tamanho();
    }

    // OK
    @Override
    public int altura() {
        if (this.estaVazia()) {
            return -1;
        }

        return this.noRaiz.altura();
    }

    // OK
    @Override
    public int grau() {
        if (this.estaVazia()) {
            return -1;
        }
        return calcularGrauMaximoRecursivo(obterNoRaiz());
    }

    // OK
    private int calcularGrauMaximoRecursivo(INoArvoreBinaria<T> no) {
        if (no == null) {
            return 0; // Grau mínimo para comparação
        }

        int grauDoNoAtual = no.grau();

        int grauMaxEsq = calcularGrauMaximoRecursivo(no.obterNoEsquerdo());
        int grauMaxDir = calcularGrauMaximoRecursivo(no.obterNoDireito());

        return Math.max(grauDoNoAtual, Math.max(grauMaxEsq, grauMaxDir));
    }

    // OK
    @Override
    public int arestas() {
        if (this.estaVazia()) {
            return -1;
        }
        return this.tamanho() - 1; // (N - 1) - N: Número de nós
    }

    // OK
    public int nivelNo(T dado) {
        return encontrarNivelNoRecursivo(this.noRaiz, dado, 0);
    }

    private int encontrarNivelNoRecursivo(INoArvoreBinaria<T> noAtual, T dado, int nivelAtual) {
        if (noAtual == null) {
            return -1; // Dado não encontrado neste caminho ou árvore/subárvore vazia
        }

        // Tratamento para dados nulos e comparação com equals para objetos
        if (dado == null) {
            if (noAtual.obterDado() == null) {
                return nivelAtual; // Encontrou um nó com dado nulo
            }
        } else if (dado.equals(noAtual.obterDado())) {
            return nivelAtual; // Dado encontrado
        }

        // Procura na subárvore esquerda
        int nivelEsquerdo = encontrarNivelNoRecursivo(noAtual.obterNoEsquerdo(), dado, nivelAtual + 1);
        if (nivelEsquerdo != -1) {
            return nivelEsquerdo; // Dado encontrado na subárvore esquerda
        }

        // Procura na subárvore direita (só se não encontrou na esquerda)
        return encontrarNivelNoRecursivo(noAtual.obterNoDireito(), dado, nivelAtual + 1);
    }

    @Override
    public void percorrerPreOrdem(Consumer<T> acao) {
        percorrerPreOrdem(this.noRaiz, acao);
    }

    private void percorrerPreOrdem(INoArvoreBinaria<T> no, java.util.function.Consumer<T> acao) {
        if (no == null)
            return;
        acao.accept(no.obterDado());
        percorrerPreOrdem(no.obterNoEsquerdo(), acao);
        percorrerPreOrdem(no.obterNoDireito(), acao);
    }

    // OK
    @Override
    public void percorrerEmOrdem(Consumer<T> acao) {
        percorrerEmOrdem(this.noRaiz, acao);
    }

    private void percorrerEmOrdem(INoArvoreBinaria<T> no, Consumer<T> acao) {
        if (no == null)
            return;
        percorrerEmOrdem(no.obterNoEsquerdo(), acao);
        acao.accept(no.obterDado());
        percorrerEmOrdem(no.obterNoDireito(), acao);
    }

    // OK
    @Override
    public void percorrerPosOrdem(Consumer<T> acao) {
        percorrerPosOrdem(this.noRaiz, acao);
    }

    private void percorrerPosOrdem(INoArvoreBinaria<T> no, Consumer<T> acao) {
        if (no == null) {
            return;
        }
        percorrerPosOrdem(no.obterNoEsquerdo(), acao);
        percorrerPosOrdem(no.obterNoDireito(), acao);
        acao.accept(no.obterDado());
    }

    // OK
    @Override
    public void percorrerEmOrdemNivel(Consumer<T> acao) {
        if (this.estaVazia()) {
            return;
        }
        int h = altura(); // Pega a altura da árvore
        for (int i = 0; i <= h; i++) {
            processarNivelAtual(this.noRaiz, i, acao);
        }
    }

    private void processarNivelAtual(INoArvoreBinaria<T> no, int nivel, Consumer<T> acao) {
        if (no == null) {
            return;
        }
        if (nivel == 0) { // Se este é o nível que queremos processar
            acao.accept(no.obterDado());
        } else if (nivel > 0) {
            processarNivelAtual(no.obterNoEsquerdo(), nivel - 1, acao);
            processarNivelAtual(no.obterNoDireito(), nivel - 1, acao);
        }
    }
}