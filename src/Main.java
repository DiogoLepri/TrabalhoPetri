import javax.sql.rowset.serial.SQLOutputImpl;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.inserir(6);
        arvoreBinaria.inserir(7);
        arvoreBinaria.inserir(3);
        arvoreBinaria.inserir(2);
        arvoreBinaria.inserir(18);
        arvoreBinaria.inserir(58);
        arvoreBinaria.inserir(63);
        System.out.println("Pré-ordem: ");
        arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
        System.out.println("Em ordem: ");
        arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());
        System.out.println("Pós ordem: ");
        arvoreBinaria.posOrdem(arvoreBinaria.getRaiz());




        System.out.println("\nRemovendo o nó folha 18:");
        arvoreBinaria.remover(18);
        arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());


        System.out.println("\nRemovendo o nó com um único filho (3):");
        arvoreBinaria.remover(3);
        arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());


        System.out.println("\nRemovendo a raiz (6):");
        arvoreBinaria.remover(6);
        arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());


        System.out.println("\nRemovendo o nó com dois filhos (7):");
        arvoreBinaria.remover(7);
        arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());
    }
}