import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void printTitle() {
        System.out.print("\n");
        System.out.print("---------------- Vintage v.1 -----------------\n");
        System.out.print("\n");
    }

    public static void printMenuLogin() {
        System.out.print("\n");
        System.out.print("----------------------------------------------\n");
        System.out.print("  1) Autenticar conta\n  " +
                "2) Registar nova conta\n  " +
                "0) SAIR\n");
        System.out.print("----------------------------------------------\n");
        System.out.print("\n");
    }

    public static void printMenu(LocalDate dataAtual) {
        System.out.print("\n");
        System.out.print("-------------------------- TIME:"+ dataAtual.toString() +" --\n");
        System.out.print("  1) Ver loja\n  " +
                "2) Fazer encomenda\n  " +
                "3) Listar os artigos que tenho para venda\n  " +
                "4) Registo dos artigos que comprei\n  " +
                "5) Registo dos artigos que já vendi\n  " +
                "6) Mudar data/hora\n  " +
                "0) SAIR\n");
        System.out.print("----------------------------------------------\n");
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
        LocalDate dataAtual = LocalDate.now(); // sempre inicializado com a data atual do computador
        boolean login_yes = false;

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

        printMenuLogin();
        int opcao_login = escolha.nextInt();

        while (login_yes == false) {

            if (opcao_login == 1) {

                String email_input = "";
                String password_input = "";
                System.out.println("Insira o seu email...");
                email_input = sc.next();
                System.out.println("Insira a sua password...");
                password_input = sc.next();

                if(utilizadorMap.containsKey(email_input) && utilizadorMap.get(email_input).comparaPassword(password_input)){
                    System.out.println("Autenticado com sucesso!");
                    login_yes = true;
                }
                else{
                    System.out.println("Erro de autenticação!");
                }

                System.out.println();
            }

            if (opcao_login == 2) {

                String email_input = "";
                String password_input = "";
                System.out.println("Insira o email da nova conta...");
                email_input = sc.next();
                System.out.println("Insira a password da nova conta...");
                password_input = sc.next();

                if(utilizadorMap.containsKey(email_input) && utilizadorMap.get(email_input).comparaPassword(password_input)){
                    System.out.println("Registo feito com sucesso!");
                    System.out.println("Experimente autenticar-se com os valores que inseriu anteriormente.");
                }
                else{
                    System.out.println("Erro de registo!");
                    System.out.println("Talvez os valores que inseriu já estejam a ser utilizados. Tente de novo.");
                }

                System.out.println();
            }

            if (opcao_login == 0) {

                System.out.println("Saindo...");
                System.out.println();
                return;
            }

            printMenuLogin();
            opcao_login = escolha.nextInt();

        }


        printMenu(dataAtual);
        int opcao = escolha.nextInt();

        if (login_yes == true) {
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
                    //mudar data do sistema
                    System.out.println("Insira string no formato 'AA-MM-DD'");
                    String data_inserida = sc.next();
                    dataAtual = LocalDate.parse(data_inserida);
                    System.out.println("Data mudada com sucesso!");
                    System.out.println();
                }

                printMenu(dataAtual);
                opcao = escolha.nextInt();

            }
        }
    }
}