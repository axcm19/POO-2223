package SubUI;

import SubArtigo.Artigo;
import SubData.DataManager;
import SubUtilizador.Utilizador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuUI {

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

    public static void printQueries() {
        System.out.print("\n");
        System.out.print("----------------------------------------------\n");
        System.out.print("  1) Qual o vendedor que mais faturou desde sempre?\n  " +
                "2) Qual a transportadora com maior volume de facturação?\n  " +
                "3) Listar as encomendas do sistema\n  " +
                "4) Ordenar os maiores vendedores do sistema durante um certo período\n  " +
                "5) Ordenar os maiores compradores do sistema durante um certo período\n  " +
                "6) Quanto dinheiro ganhou o Vintage no seu funcionamento?\n  ");
        System.out.print("----------------------------------------------\n");
        System.out.print("\n");
    }

    public static void printMenu(LocalDate dataAtual) {
        System.out.print("\n");
        System.out.print("-------------------------- TIME:"+ dataAtual.toString() +" --\n");
        System.out.print("  ---OPÇÕES DE UTILIZADOR---\n  " +
                "1) Entrar na loja\n  " +
                "2) Adicionar artigo para venda\n  " +
                "3) Listar os artigos que tenho para venda\n  " +
                "4) Registo dos artigos que comprei\n  " +
                "5) Registo dos artigos que já vendi\n  " +
                "6) A minha conta\n  " +
                "\n" +
                "  ---OPÇÕES DE SISTEMA---\n" +
                "  7) Criar nova transportadora\n  " +
                "8) Queries ao sistema\n  " +
                "9) Mudar data/hora\n  " +
                "0) SAIR\n");
        System.out.print("----------------------------------------------\n");
        System.out.print("\n");
    }
    public static void printArtigosParaVenda(Map<String, Utilizador> utilizadorMap, int loja_escolhida) {
        for (Artigo art : utilizadorMap.get(loja_escolhida).getArtigosParaVenda()) {
            art.toString();
        }
        System.out.println();
        System.out.println("Introduza o código dos artigos que quer adicionar ao carrinho");
        System.out.println("0 - regressar");
        System.out.print("\n");
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        Scanner escolha = new Scanner(System.in);
        Scanner escolha_query = new Scanner(System.in);

        LocalDate dataAtual = LocalDate.now(); // sempre inicializado com a data atual do computador
        boolean login_yes = false;
        Utilizador user_atual = new Utilizador();

        //carrgar dados para o sistema
        DataManager dados = new DataManager();
        dados.carregaUtilizadores();

        /*
        // criar instâncias de EncEficiente
        ArrayList<Linha_Encomenda> encomendas = new ArrayList<>();
        encomendas.add(le1);
        encomendas.add(le2);
        encomendas.add(le3);
        SubEncomenda.Encomenda enc_1 = new SubEncomenda.Encomenda("Alfredo Paulo", 222111333,"Rua das Sirigaitas", "2016-03-02", encomendas);


        // criar instância de GestorEncomendas
        GestorEncomendas gestorEncomendas = new GestorEncomendas();
        */

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

                if(dados.fazLogin(email_input, password_input)){
                    System.out.println("Autenticado com sucesso!");
                    user_atual = dados.getUtilizador(email_input);
                    login_yes = true;
                    break;
                }
                else{
                    System.out.println("Erro de autenticação!");
                }

                System.out.println();
            }

            if (opcao_login == 2) {

                String email_input = "";
                String password_input = "";
                String nome_input = "";
                String morada_input = "";
                String numFiscal_input = "";

                System.out.println("Insira o email da nova conta...");
                email_input = sc.next();
                System.out.println("Insira a password da nova conta...");
                password_input = sc.next();
                System.out.println("Insira o seu nome...");
                nome_input = sc.next();
                System.out.println("Insira a sua morada...");
                morada_input = sc.next();
                System.out.println("Insira o seu número fiscal...");
                numFiscal_input = sc.next();

                if(dados.fazRegisto(email_input, password_input, nome_input, morada_input, numFiscal_input)){
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
                    //consultar loja

                    List<String> carrinho = new ArrayList<>();
                    String selecao = "";

                    System.out.println(dados.printLoja(user_atual.getEmail())); // imprime o conteudo da loja excluindo os artigos do user_atual

                    System.out.println("Escolher artigo introduza: 'num_vendedor, codigo_artigo'");
                    System.out.println("'Y' -> encomenda concluida");
                    System.out.println("'N' -> cancelar encomenda / sair da loja");

                    //preenchimento do carrinho de compras
                    while(true){
                        selecao = sc.next();
                        if(selecao.equals("N")){
                            carrinho.clear(); // limpa o carrinho de compras
                            System.out.println("Saiste da loja");
                            break;
                        }
                        if(selecao.equals("Y")){
                            double preco = dados.fazEncomenda(carrinho, user_atual.getEmail(), user_atual.getMorada(), dataAtual.toString());

                            System.out.println("SubEncomenda.Encomenda finalizada --> será expedida após 48 horas");
                            //System.out.println("Preço final = " + preco + "€");
                            System.out.printf("Preço final = %.2f €",preco); // imprime no formato arrendondado

                            break;
                        }
                        else{
                            carrinho.add(selecao);
                        }
                    }

                    System.out.println();
                }

                if (opcao == 2) {

                    System.out.println("Criar um novo artigo para vender");
                    System.out.println("Indique o tipo de artigo (SubArtigo.Mala, SubArtigo.Sapatilha, T-Shirt)\n");

                    System.out.println(dados.printTransportadoras());

                    String tipo = sc.next();
                    String infoArtigo = "";

                    if(tipo.equals("SubArtigo.Mala")){
                        System.out.println("Insira numa linha a seguinte informação no formato '...,...,...,(etc)'");
                        System.out.println("'estado,descricao,marca,preço,desconto,quantos donos já teve,nome da transportadora,altura,largura,profundidade,material,ano da colecao'");
                        infoArtigo = sc.next();
                        dados.parseInfoMala(user_atual, infoArtigo);
                        //System.out.println("User:" + user_atual.toString());
                        System.out.println("SubArtigo.Artigo(SubArtigo.Mala) criado com sucesso! Verifique a lista de artigos que tem para venda.");
                    }
                    else if(tipo.equals("SubArtigo.Sapatilha")){
                        System.out.println("Insira numa linha a seguinte informação no formato '...,...,...,(etc)'");
                        System.out.println("'estado,descricao,marca,preço,desconto,quantos donos já teve,nome da transportadora,tamanho,como aperta,cor,ano da colecao'");
                        infoArtigo = sc.next();
                        dados.parseInfoSapatilha(user_atual, infoArtigo);
                        //System.out.println("User:" + user_atual.toString());
                        System.out.println("SubArtigo.Artigo(SubArtigo.Sapatilha) criado com sucesso! Verifique a lista de artigos que tem para venda.");
                    }
                    else if(tipo.equals("T-Shirt")){
                        System.out.println("Insira numa linha a seguinte informação no formato '...,...,...,(etc)'");
                        System.out.println("'estado,descricao,marca,preço,desconto,quantos donos já teve,nome da transportadora,tamanho,padrão'");
                        infoArtigo = sc.next();
                        dados.parseInfoTShirt(user_atual, infoArtigo);
                        //System.out.println("User:" + user_atual.toString());
                        System.out.println("SubArtigo.Artigo(T-Shirt) criado com sucesso! Verifique a lista de artigos que tem para venda.");
                    }
                    else{
                        System.out.println("ERRO! - Inseriu um tipo inexistente!");
                    }

                    System.out.println();
                }

                if (opcao == 3) {

                    System.out.println("Lista dos artigos que tenho para venda:");
                    System.out.println(user_atual.printInfoLista(1));
                    System.out.println();
                }

                if (opcao == 4) {

                    System.out.println("Lista dos artigos comprei:");
                    System.out.println(user_atual.printInfoLista(2));
                    System.out.println();
                }

                if (opcao == 5) {

                    System.out.println("Lista dos artigos que vendi:");
                    System.out.println(user_atual.printInfoLista(3));
                    System.out.println();
                }

                if (opcao == 6) {

                    System.out.println(user_atual.printInfoUser());
                    System.out.println();
                }

                if (opcao == 7) {

                    String infoTrans = "";

                    System.out.println("Criar uma nova transportadora");
                    System.out.println("Insira numa linha a seguinte informação no formato '...,...,...'");
                    System.out.println("'nome,margem de lucro,imposto'");
                    infoTrans = sc.next();
                    dados.parseInfoTrans(infoTrans);
                    System.out.println(dados.printTransportadoras());
                    System.out.println("SubEncomenda.Transportadora criada com sucesso!");

                    System.out.println();
                }

                if (opcao == 8) {

                    printQueries();
                    int opcao_query = escolha_query.nextInt();

                    if (opcao_query == 1) {
                        // Qual o vendedor que mais faturou desde sempre?
                        String res = dados.vendedorMaiorFaturacao();
                        System.out.println(res);
                        System.out.println();
                    }
                    if (opcao_query == 2) {
                        // Qual a transportadora com maior volume de facturação?
                        System.out.println();
                    }
                    if (opcao_query == 3) {
                        // Listar as encomendas do sistema
                        String res = dados.printEncomendas();
                        System.out.println(res);
                        System.out.println();
                    }
                    if (opcao_query == 4) {
                        // Ordenar os maiores vendedores do sistema durante um certo período
                        System.out.println();
                    }
                    if (opcao_query == 5) {
                        // Ordenar os maiores compradores do sistema durante um certo período
                        System.out.println();
                    }
                    if (opcao_query == 6) {
                        // Quanto dinheiro ganhou o Vintage no seu funcionamento?
                        System.out.println("Ganhos da vintage = " +dados.getVintageBank()+ "€");
                        System.out.println();
                    }

                }

                if (opcao == 9) {
                    //mudar data do sistema
                    System.out.println("Insira string no formato 'AA-MM-DD'");
                    String data_inserida = sc.next();
                    if(LocalDate.parse(data_inserida).isAfter(dataAtual)) {
                        dataAtual = LocalDate.parse(data_inserida);
                        dados.alteraEstadosEncomendas(dataAtual);
                        System.out.println("Data mudada com sucesso!");
                    }
                    else{
                        System.out.println("ERRO! A data que inseriu é anterior à data atual");
                    }
                    System.out.println();
                }


                printMenu(dataAtual);
                opcao = escolha.nextInt();

            }
        }
    }

}
