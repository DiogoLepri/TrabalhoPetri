public class ArvoreBinaria {

    private No raiz;


    public ArvoreBinaria() {
        this.raiz = null;
    }


    public void inserir(int valor) {
        No novoNo = new No(valor);
        if (this.raiz == null) {
            this.raiz = novoNo;
        } else {
            No atual = this.raiz;
            No pai = null;
            boolean esquerda = false;

            while (atual != null) {
                pai = atual;
                if (novoNo.getValor() < atual.getValor()) {
                    atual = atual.getEsq();
                    esquerda = true;
                } else {
                    atual = atual.getDir();
                    esquerda = false;
                }
            }

            if (esquerda) {
                pai.setEsq(novoNo);
            } else {
                pai.setDir(novoNo);
            }
        }
    }


    public boolean remover(int valor) {
        No atual = raiz;
        No pai = raiz;
        boolean isEsq = true;  // Verfica se o no atual é filho a esquerda do no pai

        while (atual.getValor() != valor) {
            pai = atual;
            if (valor < atual.getValor()) { // Vai para a subárvore esquerda
                isEsq = true;
                atual = atual.getEsq();
            } else { // Vai para a subárvore direita
                isEsq = false;
                atual = atual.getDir();
            }
            if (atual == null) {
                System.out.println("O nó a ser removido não foi encontrado na árvore.");
                return false;
            }
        }

        //O nó é uma folha  n
        if (atual.getEsq() == null && atual.getDir() == null) {
            if (atual == raiz) { // Se for a raiz, a árvore fica vazia
                raiz = null;
            } else if (isEsq) { // Remove o nó ajustando o ponteiro do pai
                pai.setEsq(null);
            } else {
                pai.setDir(null);
            }
        }
        //O nó tem apenas um filho (direita)
        else if (atual.getEsq() == null) {
            if (atual == raiz) { // Se for a raiz, a raiz é substituída pelo filho direito
                raiz = atual.getDir();
            } else if (isEsq) { // Se for filho esquerdo, o pai agora aponta para o filho direito
                pai.setEsq(atual.getDir());
            } else { // Se for filho direito, o pai agora aponta para o filho direito
                pai.setDir(atual.getDir());
            }
        }
        //O nó tem apenas um filho (esquerda)
        else if (atual.getDir() == null) {
            if (atual == raiz) { // Se for a raiz, a raiz é substituída pelo filho esquerdo
                raiz = atual.getEsq();
            } else if (isEsq) { // Se for filho esquerdo, o pai agora aponta para o filho esquerdo
                pai.setEsq(atual.getEsq());
            } else { // Se for filho direito, o pai agora aponta para o filho esquerdo
                pai.setDir(atual.getEsq());
            }
        }
        //O nó tem dois filhos
        else {
            No sucessor = obterSucessor(atual); // Encontra o sucessor do nó a ser removido
            if (atual == raiz) { // Se o nó é a raiz, a raiz é substituída pelo sucessor
                raiz = sucessor;
            } else if (isEsq) { // Se o nó é filho esquerdo, o sucessor ocupa o lugar dele
                pai.setEsq(sucessor);
            } else { // Se o nó é filho direito, o sucessor ocupa o lugar dele
                pai.setDir(sucessor);
            }
            sucessor.setEsq(atual.getEsq()); // O sucessor herda a subárvore esquerda do nó removido
        }
        return true;
    }
    // Método para encontrar o sucessor de um nó
    private No obterSucessor(No no) {
        No sucessorPai = no;
        No sucessor = no;
        No atual = no.getDir(); // Começa a busca pelo sucessor na subárvore direita

        // O sucessor é o menor valor na subárvore direita
        while (atual != null) {
            sucessorPai = sucessor;
            sucessor = atual;
            atual = atual.getEsq();
        }

        // Se o sucessor não for o filho direito direto do nó
        if (sucessor != no.getDir()) {
            sucessorPai.setEsq(sucessor.getDir());
            sucessor.setDir(no.getDir());
        }
        return sucessor;
    }




    public void preOrdem(No no) {
        if (no == null) {
            return;
        }
        System.out.println(no.getValor());
        preOrdem(no.getEsq());
        preOrdem(no.getDir());
    }

    public void emOrdem(No no) {
        if (no == null) {
            return;
        }
        emOrdem(no.getEsq());
        System.out.println(no.getValor());
        emOrdem(no.getDir());
    }

    public void posOrdem(No no) {
        if (no == null) {
            return;
        }
        posOrdem(no.getEsq());
        posOrdem(no.getDir());
        System.out.println(no.getValor());
    }


    public No getRaiz() {
        return raiz;
    }
}
