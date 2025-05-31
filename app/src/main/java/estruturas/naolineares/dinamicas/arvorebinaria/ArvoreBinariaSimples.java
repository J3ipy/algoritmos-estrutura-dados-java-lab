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

    //OK
    @Override
    public int tamanho() {
        if (this.estaVazia()) {
            return 0;
        }
        return this.noRaiz.tamanho();
    }

    //OK
    @Override
    public int altura() {
        if (this.estaVazia()) {
            return -1;
        }

        return this.noRaiz.altura();
    }

    //OK
    @Override
    public int grau() {
        if (this.estaVazia()) {
            return -1;
        }
        return calcularGrauMaximoRecursivo(obterNoRaiz());
    }

    //OK
    private int calcularGrauMaximoRecursivo(INoArvoreBinaria<T> no) {
        if (no == null) {
            return 0; // Grau mínimo para comparação
        }
        int grauDoNoAtual = no.grau();
        if (no.obterNoEsquerdo() != null) grauDoNoAtual++;
        if (no.obterNoDireito()  != null) grauDoNoAtual++;

        int grauMaxEsq = calcularGrauMaximoRecursivo(no.obterNoEsquerdo());
        int grauMaxDir = calcularGrauMaximoRecursivo(no.obterNoDireito());

        return Math.max(grauDoNoAtual, Math.max(grauMaxEsq, grauMaxDir));
    }

    //OK
    @Override
    public int arestas() {
        if (this.estaVazia()) {
            return -1;
        }
        return this.tamanho() - 1; //(N - 1) - N: Número de nós
    }

    // Pensando em como fazer isso 
    public int nivelNo(T dado) {
        if (this.estaVazia()) {
            return -1;
        }
        return 0;
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

    //OK
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

    //OK
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

    // em dúvida
    @Override
    public void percorrerEmOrdemNivel(Consumer<T> acao) {
        //pensando em como fazer isso
    }

}