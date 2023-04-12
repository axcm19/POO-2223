import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void printTitle() {
        System.out.print("\n");
        System.out.print("---------------- Vintage v.1 ----------------\n");
        System.out.print("\n");
    }

    public static void printMenuLogin() {
        System.out.print("\n");
        System.out.print("---------------------------------------------\n");
        System.out.print("  1) Autenticar conta\n  " +
                "2) Registar nova conta\n  " +
                "0) SAIR\n");
        System.out.print("---------------------------------------------\n");
        System.out.print("\n");
    }

    public static void printMenu() {
        System.out.print("\n");
        System.out.print("---------------------------------------------\n");
        System.out.print("  1) Ver loja\n  " +
                "2) Fazer encomenda\n  " +
                "3) Listar só os artigos que tenho para venda\n  " +
                "4) Listar todo o meu inventário geral\n  " +
                "5) Registo dos artigos que comprei\n  " +
                "6) Mudar data/hora\n  " +
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
        Map<String, List<Artigo>> loja = new HashMap<>();   // Map<codUtilizador, Artigo>
        LocalDate horaAtual = LocalDate.now();

        /*
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

                System.out.println();
            }

            if (opcao == 2) {

                System.out.println();
            }

            if (opcao == 3) {

                System.out.println();
            }

            if (opcao == 4) {

                System.out.println();
            }

            if (opcao == 5) {

                System.out.println();
            }

            if (opcao == 6) {

                System.out.println();
            }

            printMenu();
            opcao = escolha.nextInt();

        }
    }
}