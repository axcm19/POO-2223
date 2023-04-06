import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio_4 {

    public static void printMenu() {
        System.out.print("-----------------------------------\n");
        System.out.print("  1) Códigos de encomenda existentes\n  " +
                "2) Adiciona mais uma encomenda ao sistema\n  " +
                "3) Dá um código de encomenda e devolve a informação respectiva\n  " +
                "4) Remove uma encomenda dado o seu código\n  " +
                "5) Determina a encomenda com mais produtos encomendados\n  " +
                "6) Determina todas as encomendas em que um determinado produto está presente\n  " +
                "7) Determina todas as encomendas com data posterior a uma data fornecida\n  " +
                "8) Determina a encomenda de maior valor\n  " +
                "9) Ordenação das encomendas por quantidade crescente de produtos\n  " +
                "10) Ordenação, por ordem decrescente de valor de encomenda\n  " +
                "11) Calcula um map em que associa cada código de produto à lista das encomendas em que foi referida\n  " +
                "12) Imprime GestorEncomendas (só porque que sim)\n  " +
                "0) SAIR\n");
        System.out.print("-----------------------------------\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner escolha = new Scanner(System.in);

        // criar Linha_Encomenda
        Linha_Encomenda le1 = new Linha_Encomenda("asdf_1", "Panelas", 19.23, 2, 0.05, 0.2);
        Linha_Encomenda le2 = new Linha_Encomenda("asdf_2", "Garfos", 4.5, 6, 0, 0.1);
        Linha_Encomenda le3 = new Linha_Encomenda("asdf_3", "Facas", 9.5, 12, 0, 0.1);

        // criar instâncias de EncEficiente
        ArrayList<Linha_Encomenda> encomendas = new ArrayList<>();
        encomendas.add(le1);
        encomendas.add(le2);
        encomendas.add(le3);
        EncEficiente enc_1 = new EncEficiente("Alfredo Paulo", 222111333,"Rua das Sirigaitas", "2016-03-02", encomendas);

        // criar instância de GestorEncomendas
        GestorEncomendas gestorEncomendas = new GestorEncomendas();


        System.out.println("------ FICHA 5 - EXERCICIO 4 ------\n");

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

            if (opcao == 7) {

                System.out.println("Alinea vii");

                String input = sc.next();
                LocalDate data = LocalDate.parse(input);

                System.out.println(gestorEncomendas.encomendasAposData(data));

                System.out.println();
            }

            if (opcao == 8) {

                System.out.println("Alinea viii");

                System.out.println("Maior valor = " +gestorEncomendas.encomendaMaiorValor());

                System.out.println();
            }

            if (opcao == 9) {

                System.out.println("Alinea ix");


                System.out.println();
            }

            if (opcao == 10) {

                System.out.println("Alinea x");


                System.out.println();
            }

            if (opcao == 11) {

                System.out.println("Alinea xi");


                System.out.println();
            }

            if (opcao == 12) {

                System.out.println("Alinea xii");

                System.out.println(gestorEncomendas.toString());

                System.out.println();
            }

            printMenu();
            opcao = escolha.nextInt();

        }
    }
}