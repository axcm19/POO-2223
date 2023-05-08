package UI;

import SubData.Vintage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

    public static void printLoadMenu() {
        System.out.print("\n");
        System.out.print("----------------------------------------------\n");
        System.out.print("  1) Iniciar Vintage sem estado\n  " +
                "2) Carregar ficheiro de estado\n  " +
                "0) SAIR\n");
        System.out.print("----------------------------------------------\n");
        System.out.print("\n");
    }

    public static void printQuerie1() {
        System.out.print("\n");
        System.out.print("----------------------------------------------\n");
        System.out.print("  1) ...desde sempre?\n  " +
                "2) ...entre determinado periodo?\n  ");
        System.out.print("----------------------------------------------\n");
        System.out.print("\n");
    }

    public static void printQueries() {
        System.out.print("\n");
        System.out.print("----------------------------------------------\n");
        System.out.print("  1) Qual o vendedor que mais faturou...\n  " +
                "2) Qual a transportadora com maior volume de facturação...\n  " +
                "3) Listar as encomendas do sistema\n  " +
                "4) Listar as faturas do sistema\n  " +
                "5) Ordenar os maiores vendedores do sistema durante um certo período\n  " +
                "6) Ordenar os maiores compradores do sistema durante um certo período\n  " +
                "7) Quanto dinheiro ganhou o Vintage no seu funcionamento?\n  " +
                "8) Listar todos os artigos que passaram pelo sistema\n  ");
        System.out.print("----------------------------------------------\n");
        System.out.print("\n");
    }

    public static void printMenu(LocalDate dataAtual) {
        System.out.print("\n");
        System.out.print("-------------------------- TIME:"+ dataAtual.toString() +" --\n");
        System.out.print("  ---OPÇÕES DE UTILIZADOR---\n  " +
                "1) Entrar na loja\n  " +
                "2) Adicionar artigo para venda\n  " +
                "3) Remover artigo para venda\n  " +
                "4) Listar os artigos que tenho para venda\n  " +
                "5) Registo de todos os artigos que comprei\n  " +
                "6) Registo de todos os artigos que já vendi\n  " +
                "7) A minha conta\n  " +
                "8) Fazer devolução de encomenda\n  " +
                "\n" +
                "  ---OPÇÕES DE SISTEMA---\n" +
                "  9) Criar nova transportadora\n  " +
                "10) Queries ao sistema\n  " +
                "11) Guardar estado\n  " +
                "12) Mudar data/hora\n  " +
                "0) SAIR\n");
        System.out.print("----------------------------------------------\n");
        System.out.print("\n");
    }

    public void run() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        Scanner escolha = new Scanner(System.in);
        Scanner escolha_query = new Scanner(System.in);
        Scanner escolha_1 = new Scanner(System.in);

        LocalDate dataAtual = LocalDate.now(); // sempre inicializado com a data atual do computador
        boolean login_yes = false;
        boolean load_yes = false;
        String filename = "";

        printTitle();
        Vintage dados = new Vintage();

        printLoadMenu();
        String opcao_load = escolha.nextLine();

        while (load_yes == false) {
            if (opcao_load.equals("1")) {

                System.out.println("Insira o nome do ficheiro de estado onde vai querer guardar a informação...");
                filename = sc.nextLine();

                dados = new Vintage();
                //dados.carregaUtilizadores(); // Esta linha está aqui caso o ficheiro de estado desapareça (precaução)
                load_yes = true;

                System.out.println();
            }

            if (opcao_load.equals("2")) {

                System.out.println("Insira o nome do ficheiro de estado...");
                filename = sc.nextLine();

                dados = Vintage.carregaEstado(filename);
                dados.alteraEstadosEncomendas(dataAtual);
                dados.ultimoNumeroFatura();
                dados.ultimoNumeroEncomenda();
                dados.ultimoCodigoArtigo();
                dados.ultimoCodigoUtilizador();

                load_yes = true;

                System.out.println();
            }

            if (opcao_load.equals("0")) {

                System.out.println("Saindo...");
                System.out.println();
                return;
            }

        }

        printMenuLogin();
        String opcao_login = escolha.nextLine();

        while (login_yes == false) {

            if (opcao_login.equals("1")) {

                String email_input = "";
                String password_input = "";
                System.out.println("Insira o seu email...");
                email_input = sc.nextLine();
                System.out.println("Insira a sua password...");
                password_input = sc.nextLine();

                if(dados.fazLogin(email_input, password_input)){
                    System.out.println("Autenticado com sucesso!");
                    login_yes = true;
                    dados.trocaArtigosParaTodasEncomendasUserAtual();
                    dados.trocaArtigosParaTodasEncomendas();
                    break;
                }
                else{
                    System.out.println("Erro de autenticação!");
                }

                System.out.println();
            }

            if (opcao_login.equals("2")) {

                String email_input = "";
                String password_input = "";
                String nome_input = "";
                String morada_input = "";
                String numFiscal_input = "";

                System.out.println("Insira o email da nova conta...");
                email_input = sc.nextLine();
                System.out.println("Insira a password da nova conta...");
                password_input = sc.nextLine();
                System.out.println("Insira o seu nome...");
                nome_input = sc.nextLine();
                System.out.println("Insira a sua morada...");
                morada_input = sc.nextLine();
                System.out.println("Insira o seu número fiscal...");
                numFiscal_input = sc.nextLine();

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

            if (opcao_login.equals("0")) {

                System.out.println("Saindo...");
                System.out.println();
                return;
            }

            printMenuLogin();
            opcao_login = escolha.nextLine();

        }


        printMenu(dataAtual);
        String opcao = escolha.nextLine();

        if (login_yes == true) {
            while (!opcao.equals("0")) {
                if (opcao.equals("1")) {
                    //consultar loja

                    List<String> carrinho = new ArrayList<>();
                    String selecao = "";

                    System.out.println(dados.printLoja()); // imprime o conteudo da loja excluindo os artigos do user_atual

                    System.out.println("Escolher artigo introduza: 'num_vendedor, codigo_artigo'");
                    System.out.println("'Y' -> encomenda concluida");
                    System.out.println("'N' -> cancelar encomenda / sair da loja");

                    //preenchimento do carrinho de compras
                    while(true){
                        selecao = sc.nextLine();
                        if(selecao.equals("N")){
                            carrinho.clear(); // limpa o carrinho de compras
                            System.out.println("Saiste da loja");
                            break;
                        }
                        if(selecao.equals("Y")){
                            double preco = dados.fazEncomenda(carrinho, dataAtual.toString());
                            dados.removeArtigoVendedorAposVenda(carrinho);

                            System.out.println("Encomenda finalizada --> será expedida após 48 horas");
                            System.out.printf("Preço final = %.2f €",preco); // imprime no formato arrendondado

                            break;
                        }
                        else{
                            carrinho.add(selecao);
                        }
                    }

                    System.out.println();
                }

                if (opcao.equals("2")) {

                    System.out.println("Criar um novo artigo para vender");
                    System.out.println("Indique o tipo de artigo (Mala, Sapatilha, T-Shirt)\n");

                    System.out.println(dados.printTransportadoras());

                    String tipo = sc.nextLine();
                    String infoArtigo = "";

                    if(tipo.equals("Mala")){
                        System.out.println("Insira numa linha a seguinte informação no formato '...,...,...,(etc)'");
                        System.out.println("'estado,descricao,marca,preço,desconto,quantos donos já teve,nome da transportadora,altura,largura,profundidade,material,ano da colecao'");
                        infoArtigo = sc.nextLine();
                        dados.parseInfoMala(infoArtigo);
                        System.out.println("Artigo(Mala) criado com sucesso! Verifique a lista de artigos que tem para venda.");
                    }
                    else if(tipo.equals("Sapatilha")){
                        System.out.println("Insira numa linha a seguinte informação no formato '...,...,...,(etc)'");
                        System.out.println("'estado,descricao,marca,preço,desconto,quantos donos já teve,nome da transportadora,tamanho,como aperta,cor,ano da colecao'");
                        infoArtigo = sc.nextLine();
                        dados.parseInfoSapatilha(infoArtigo);
                        System.out.println("Artigo(Sapatilha) criado com sucesso! Verifique a lista de artigos que tem para venda.");
                    }
                    else if(tipo.equals("T-Shirt")){
                        System.out.println("Insira numa linha a seguinte informação no formato '...,...,...,(etc)'");
                        System.out.println("'estado,descricao,marca,preço,desconto,quantos donos já teve,nome da transportadora,tamanho,padrão'");
                        infoArtigo = sc.nextLine();
                        dados.parseInfoTShirt(infoArtigo);
                        System.out.println("Artigo(T-Shirt) criado com sucesso! Verifique a lista de artigos que tem para venda.");
                    }
                    else{
                        System.out.println("ERRO! - Inseriu um tipo inexistente!");
                    }

                    System.out.println();
                }

                if (opcao.equals("3")) {
                    //remover um artigo da lista de artigos para venda

                    System.out.println("Insira o codigo do artigo...");
                    String cod_art = sc.nextLine();
                    dados.removeArtigoUtilizador(cod_art);
                    System.out.println("Artigo removido com sucesso!");
                    System.out.println();
                }

                if (opcao.equals("4")) {

                    System.out.println("Lista dos artigos que tenho para venda:");
                    System.out.println(dados.printInfoLista(1));
                    System.out.println();
                }

                if (opcao.equals("5")) {

                    System.out.println("Lista dos artigos comprei:");
                    System.out.println(dados.printInfoLista(2));
                    System.out.println();
                }

                if (opcao.equals("6")) {

                    System.out.println("Lista dos artigos que vendi:");
                    System.out.println(dados.printInfoLista(3));
                    System.out.println();
                }

                if (opcao.equals("7")) {

                    System.out.println(dados.printInfoUser());
                    System.out.println();
                }

                if (opcao.equals("8")) {
                    //devolver encomenda
                    System.out.println("Insira codiga de encomenda...");
                    String cod = sc.nextLine();
                    String res = dados.fazDevolucao(Integer.parseInt(cod), dataAtual);
                    System.out.println(res);
                    System.out.println();
                }

                if (opcao.equals("9")) {

                    String infoTrans = "";

                    System.out.println("Criar uma nova transportadora");
                    System.out.println("Insira numa linha a seguinte informação no formato '...,...,...'");
                    System.out.println("'nome,margem de lucro,imposto'");
                    infoTrans = sc.nextLine();
                    dados.parseInfoTrans(infoTrans);
                    System.out.println(dados.printTransportadoras());
                    System.out.println("Transportadora criada com sucesso!");

                    System.out.println();
                }

                if (opcao.equals("10")) {

                    printQueries();
                    String opcao_query = escolha_query.nextLine();

                    if (opcao_query.equals("1")) {
                        // Qual o vendedor que mais faturou?
                        printQuerie1();
                        String opcao_1 = escolha_1.nextLine();

                        if (opcao_1.equals("1")) {
                            String res = dados.vendedorMaiorFaturacao(LocalDate.parse("2000-01-01"), dataAtual);
                            System.out.println(res);
                            System.out.println();
                        }
                        if (opcao_1.equals("2")) {
                            System.out.println("Insira duas datas no formato 'AAAA-MM-DD'");
                            String data1 = sc.nextLine();
                            String data2 = sc.nextLine();
                            String res = dados.vendedorMaiorFaturacao(LocalDate.parse(data1), LocalDate.parse(data2));
                            System.out.println(res);
                            System.out.println();
                        }

                        System.out.println();
                    }
                    if (opcao_query.equals("2")) {
                        // Qual a transportadora com maior volume de facturação?
                        printQuerie1();
                        String opcao_2 = escolha_1.nextLine();

                        if (opcao_2.equals("1")) {
                            String res = dados.transportadoraMaiorFaturacao(LocalDate.parse("2000-01-01"), dataAtual);
                            System.out.println(res);
                            System.out.println();
                        }
                        if (opcao_2.equals("2")) {
                            System.out.println("Insira duas datas no formato 'AAAA-MM-DD'");
                            String data1 = sc.nextLine();
                            String data2 = sc.nextLine();
                            String res = dados.transportadoraMaiorFaturacao(LocalDate.parse(data1), LocalDate.parse(data2));
                            System.out.println(res);
                            System.out.println();
                        }

                        System.out.println();
                    }
                    if (opcao_query.equals("3")) {
                        // Listar as encomendas do sistema
                        String res = dados.printEncomendas();
                        System.out.println(res);
                        System.out.println();
                    }
                    if (opcao_query.equals("4")) {
                        // Listar as faturas do sistema
                        String res = dados.printFaturas();
                        System.out.println(res);
                        System.out.println();
                    }
                    if (opcao_query.equals("5")) {
                        // Ordenar os maiores vendedores do sistema durante um certo período
                        System.out.println("Insira duas datas no formato 'AAAA-MM-DD'");
                        String data1 = sc.nextLine();
                        String data2 = sc.nextLine();
                        String res = dados.ordenaVendedores(LocalDate.parse(data1), LocalDate.parse(data2));
                        System.out.println(res);
                        System.out.println();
                    }
                    if (opcao_query.equals("6")) {
                        // Ordenar os maiores compradores do sistema durante um certo período
                        System.out.println("Insira duas datas no formato 'AAAA-MM-DD'");
                        String data1 = sc.nextLine();
                        String data2 = sc.nextLine();
                        String res = dados.ordenaCompradores(LocalDate.parse(data1), LocalDate.parse(data2));
                        System.out.println(res);
                        System.out.println();
                    }
                    if (opcao_query.equals("7")) {
                        // Quanto dinheiro ganhou o Vintage no seu funcionamento?
                        System.out.println("Ganhos da vintage = " +dados.getVintageBank()+ "€");
                        System.out.println();
                    }
                    if (opcao_query.equals("8")) {
                        // Listar todos os artigos que existem ou já existiram no sistema
                        String res = dados.printArtigos();
                        System.out.println(res);
                        System.out.println();
                    }

                }

                if (opcao.equals("11")) {
                    //guardar estado do sistema num ficheiro
                    System.out.println("Guardando no ficheiro " +filename+ "...");
                    //if() {
                        dados.guardaEstado(filename);
                        System.out.println("Estado guardado com sucesso!");
                    //}
                    //else{
                      //  System.out.println("ERRO! A data que inseriu é anterior à data atual");
                    //}
                    System.out.println();
                }

                if (opcao.equals("12")) {
                    //mudar data do sistema
                    System.out.println("Insira string no formato 'AAAA-MM-DD'");
                    String data_inserida = sc.nextLine();
                    if(LocalDate.parse(data_inserida).isAfter(dataAtual)) {
                        dataAtual = LocalDate.parse(data_inserida);
                        dados.alteraEstadosEncomendas(dataAtual);
                        System.out.println("Data mudada com sucesso!");
                        dados.trocaArtigosParaTodasEncomendasUserAtual();
                        dados.trocaArtigosParaTodasEncomendas();
                    }
                    else{
                        System.out.println("ERRO! A data que inseriu é anterior à data atual");
                    }
                    System.out.println();
                }


                printMenu(dataAtual);
                opcao = escolha.nextLine();

            }
        }
    }

}
