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
        System.out.print("  1) Entrar na loja \n  " +
                "2) Adicionar artigo para venda\n  " +
                "3) Listar os artigos que tenho para venda\n  " +
                "4) Registo dos artigos que comprei\n  " +
                "5) Registo dos artigos que já vendi\n  " +
                "6) Informação dos vendedores\n  " +
                "7) Mudar data/hora\n  " +
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner escolha = new Scanner(System.in);

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
        Encomenda enc_1 = new Encomenda("Alfredo Paulo", 222111333,"Rua das Sirigaitas", "2016-03-02", encomendas);


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

                    System.out.println(dados.printLoja()); // imprime o conteudo da loja

                    System.out.println("Escolher artigo introduza: 'num_vendedor, codigo_artigo'");
                    System.out.println("'Y' -> encomenda concluida");
                    System.out.println("'N' -> cancelar encomenda / sair da loja");

                    //preenchimento do carrinho de compras
                    while(!selecao.equals("Y")){
                        selecao = sc.next();
                        if(selecao.equals("N")){
                            carrinho.clear(); // limpa o carrinho de compras
                            System.out.println("Saiste da loja");
                            break;
                        }
                        if(selecao.equals("Y")){
                            double preco = dados.fazEncomenda(carrinho, user_atual.getEmail(), user_atual.getMorada(), dataAtual.toString());
                            System.out.println("Encomenda feita");
                            System.out.println("Preço final = " + preco + "€");
                            break;
                        }
                        else{
                            carrinho.add(selecao);
                        }
                        //double preco = dados.fazEncomenda(carrinho, user_atual.getEmail(), user_atual.getMorada(), dataAtual.toString());
                        //System.out.println("Encomenda feita");
                        //System.out.println("Preço final = " +preco+ "€");
                    }

                    System.out.println();
                }

                if (opcao == 2) {

                    System.out.println("Criar um novo artigo para vender");
                    System.out.println("Indique o tipo de artigo (Mala, Sapatilha, T-Shirt)");

                    String tipo = sc.next();
                    String infoArtigo = "";

                    if(tipo.equals("Mala")){
                        System.out.println("Insira numa linha a seguinte informação no formato '... ,..., ..., (etc)'");
                        System.out.println("'estado, descricao, marca, preço, desconto, quantos donos já teve, nome da transportadora, altura, largura, profundidade, material, ano da colecao'");
                        infoArtigo = sc.next();
                        dados.parseInfoMala(user_atual, infoArtigo);
                        System.out.println("Artigo(Mala) criado com sucesso! Verifique a lista de artigos que tem para venda.");
                    }
                    if(tipo.equals("Sapatilha")){
                        System.out.println("Insira numa linha a seguinte informação no formato '... ,..., ..., (etc)'");
                        System.out.println("'estado, descricao, marca, preço, desconto, quantos donos já teve, nome da transportadora, tamanho, como aperta, cor, ano da colecao'");
                        infoArtigo = sc.next();
                        dados.parseInfoSapatilha(user_atual, infoArtigo);
                        System.out.println("Artigo(Sapatilha) criado com sucesso! Verifique a lista de artigos que tem para venda.");
                    }
                    if(tipo.equals("T-Shirt")){
                        System.out.println("Insira numa linha a seguinte informação no formato '... ,..., ..., (etc)'");
                        System.out.println("'estado, descricao, marca, preço, desconto, quantos donos já teve, nome da transportadora, tamanho, padrão'");
                        infoArtigo = sc.next();
                        dados.parseInfoTShirt(user_atual, infoArtigo);
                        System.out.println("Artigo(T-Shirt) criado com sucesso! Verifique a lista de artigos que tem para venda.");
                    }
                    else{
                        System.out.println("ERRO! - Inseriu um tipo inexistente!");
                    }

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

                    //consultar loja

                    List<Utilizador> vendedores = new ArrayList<>(); // como é que posso fazer uma lista só com vendedores? será que os parâmetros que passei aos métodos são os corretos/mais fáceis de implementar?


                    String selecao = "";

                    System.out.println(dados.printLoja2()); // imprime o conteudo da loja

                    System.out.println("'1' -> Vendedor que mais faturou");
                    System.out.println("'0' -> Voltar");

                    while(!selecao.equals("1")){

                        selecao = sc.next();

                        if(selecao.equals("0")){
                            break;
                        }

                        if(selecao.equals("1")){

                            System.out.println("'1' -> Período de tempo");
                            System.out.println("'2' -> Desde sempre" );
                            selecao = sc.next();

                            if(selecao.equals("1")){
                                System.out.println("Introduza duas datas");
                                System.out.println("Desde: ");
                                String data1 = sc.next();
                                System.out.println("Até: ");
                                String data2 = sc.next();
                                Utilizador vendedor = dados.vendedorMaiorFaturacaoData(vendedores,data1,data2);
                                double faturacao = dados.calculaFaturacaoVendedor(vendedor);
                                System.out.println("O vendedor que mais faturou foi " + vendedor + "com" + faturacao + "€");
                                break;
                            }

                            if(selecao.equals("2")){
                                Utilizador vendedor = dados.vendedorMaiorFaturacao(vendedores);
                                double faturacao = dados.calculaFaturacaoVendedor(vendedor);
                                System.out.println("O vendedor que mais faturou foi " + vendedor.getCodigo() + " com " + faturacao + " €");
                                break;
                            }
                        }         
                    }

                    System.out.println();
                }

                if (opcao == 7) {
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




