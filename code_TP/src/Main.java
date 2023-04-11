import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void printTitle() {
        System.out.print("\n");
        System.out.print("---------------- Vintage v.1 ----------------\n");
        System.out.print("\n");
    }

    public static void printMenu() {
        System.out.print("\n");
        System.out.print("---------------------------------------------\n");
        System.out.print("  1) ...\n  " +
                "2) ...\n  " +
                "3) ...\n  " +
                "4) ...\n  " +
                "5) ...\n  " +
                "6) ...\n  " +
                "0) SAIR\n");
        System.out.print("---------------------------------------------\n");
        System.out.print("\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner escolha = new Scanner(System.in);

        // maps onde se vai guardar a informação retirada dos ficheiros que guardam o estado do programa
        Map<String, Artigo> artigoMap = new HashMap<>();
        Map<String, Utilizador> utilizadorMap = new HashMap<>();
        Map<String, Encomenda> encomendaMap = new HashMap<>();
        Map<String, Transportadora> transportadoraMap = new HashMap<>();
        LocalDate horaAtual = LocalDate.now();

        /*
        // criar Linha_Encomenda
        Linha_Encomenda le1 = new Linha_Encomenda("asdf_1", "Panelas", 19.23, 2, 0.05, 0.2);
        Linha_Encomenda le2 = new Linha_Encomenda("asdf_2", "Garfos", 4.5, 6, 0, 0.1);
        Linha_Encomenda le3 = new Linha_Encomenda("asdf_3", "Facas", 9.5, 12, 0, 0.1);

        // criar instâncias de EncEficiente
        ArrayList<Linha_Encomenda> encomendas = new ArrayList<>();
        encomendas.add(le1);
        encomendas.add(le2);
        encomendas.add(le3);
        Encomenda enc_1 = new Encomenda("Alfredo Paulo", 222111333,"Rua das Sirigaitas", "2016-03-02", encomendas);
        */

        // criar instância de GestorEncomendas
        GestorEncomendas gestorEncomendas = new GestorEncomendas();


        printTitle();

        printMenu();
        int opcao = escolha.nextInt();

        while (opcao != 0) {

            if (opcao == 1) {

                System.out.println("Alinea i");

                System.out.println(gestorEncomendas.todosCodigosEnc().toString());

                System.out.println();
            }

            if (opcao == 2) {

                System.out.println("Alinea ii");

                gestorEncomendas.addEncomenda(enc_1);

                System.out.println();
            }

            if (opcao == 3) {

                System.out.println("Alinea iii");
                System.out.println("---> Insere código de encomenda para procurar");

                int codEnc = sc.nextInt();

                System.out.println(gestorEncomendas.getEncomenda(codEnc));

                System.out.println();
            }

            if (opcao == 4) {

                System.out.println("Alinea iv");

                System.out.println("---> Insere código de encomenda para remover");

                int codEnc = sc.nextInt();

                gestorEncomendas.removeEncomenda(codEnc);

                System.out.println();
            }

            if (opcao == 5) {

                System.out.println("Alinea v");

                System.out.println("Mais produtos = " +gestorEncomendas.encomendaComMaisProdutos());

                System.out.println();
            }

            if (opcao == 6) {

                System.out.println("Alinea vi");
                System.out.println("---> Insere código de produto para procurar");

                String refProd = sc.next();

                System.out.println(gestorEncomendas.encomendasComProduto(refProd));

                System.out.println();
            }

            printMenu();
            opcao = escolha.nextInt();

        }
    }
}