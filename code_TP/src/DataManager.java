/*
ESTA CLASSE É RESPONSÁVEL POR TODOS OS MÉTODOS QUE PERMITEM SALVAR E RECUPERAR O ESTADO DO PROGRAMA
(MUITO INACABADO!!!)
 */

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class DataManager {

    //---------------------------------- VARIAVEIS DE INSTANCIA ----------------------------------

    // maps onde se vai guardar a informação retirada dos ficheiros que guardam o estado do programa
    private Map<String, Artigo> artigoMap;
    private Map<String, Utilizador> utilizadorMap;
    private Map<Integer, Encomenda> encomendaMap;
    private Map<String, Transportadora> transportadoraMap;
    private double vintageBank;


    //---------------------------------- CONSTRUTORES ----------------------------------


    public DataManager() {
        this.artigoMap = new HashMap<>();
        this.utilizadorMap = new HashMap<>();
        this.encomendaMap = new HashMap<>();
        this.transportadoraMap = new HashMap<>();
        this.vintageBank = 5000;
    }


    //---------------------------------- METODOS PARA GESTÃO DOS DADOS QUE ESTÃO CARREGADOS NO PROGRAMA ----------------------------------


    public void carregaUtilizadores() {
        
        // Transportadoras Disponiveis

        Transportadora fedex = new Transportadora("FedEx", 0.4, 0.55);
        Transportadora ctt = new Transportadora("CTT", 0.5, 0.45);
        Transportadora  chronopost = new Transportadora("Chronopost", 0.3, 0.8);

        this.transportadoraMap.put(fedex.getNomeTransportadora(), fedex);
        this.transportadoraMap.put(ctt.getNomeTransportadora(), ctt);
        this.transportadoraMap.put(chronopost.getNomeTransportadora(), chronopost);

        // Artigos Disponiveis 

        Artigo a1 = new Sapatilha("novo", "Sapatilhas muito bonitas", "Rebook", 32.45, 0.3, 0, fedex, 43, "atacadores", "vermelho", "2023");
        Artigo a2 = new TShirt("usado", "T-Shirt usada em bom estado", "Nike", 10.5, 0.1, 1, ctt, "S", "palmeiras");
        Artigo a3 = new Mala("usado", "Mala usada da gucci", "Gucci", 20.30, 0.2, 1, chronopost, 25,30,15, "couro", "2022");

        Artigo a4 = new Sapatilha("usado", "Sapatilhas usadas em bom estado", "Adidas", 20, 0.4, 1, ctt, 40, "atacadores", "brnaco", "2021");
        Artigo a5 = new TShirt("usado", "Camisola usada. Apenas rasgada num canto", "Gap", 7.5, 0.2, 2, chronopost, "M", "liso");
        Artigo a6 = new Mala("usado", "Pochete usada", "Bimba y Lola", 10.5, 0.25, 1, fedex, 10,20,5, "poliéster", "2022");

        Artigo a7 = new Sapatilha("usado", "Sapatos usados Michael Kors", "Michael Kors", 36, 0.23, 1, chronopost, 38, "atacadores", "preto", "2020");
        Artigo a8 = new TShirt("novo", "Camisola nova", "Guess", 33.99, 0.05, 0, fedex, "S", "riscas");
        Artigo a9 = new Mala("novo", "Mala nova da Desigual", "Desigual", 30, 0.15, 0, ctt, 18,22,10, "pele sintética", "2023");

        Artigo a10 = new Sapatilha("usado", "Botas de senhora usados", "Calvin Klein", 37, 0.11, 1, fedex, 39, "atilhos", "preto", "2022");
        Artigo a11 = new TShirt("usado", "Camisola com algum uso", "Boss", 7, 0.35, 1, ctt, "L", "liso");
        Artigo a12 = new Mala("usado", "Mala com alguns anos", "Moschino", 16.7, 0.5, 1, chronopost, 30,40,20, "feltro", "2019");

        Artigo a13 = new Sapatilha("usado", "Sapatos em bom estado", "Calvin Klein", 45, 0.35, 1, ctt, 41, "atilhos", "bege", "2020");
        Artigo a14 = new TShirt("usado", "T-Shirt em segunda mão", "Macron", 5.5, 0.18, 1, chronopost, "XL", "riscas");
        Artigo a15 = new Mala("usado", "Mala em segunda mão", "Latouche", 18, 0.1, 1, fedex, 20,25,15, "pele sintética", "2017");

        // Lista individual para cada vendedor

        List<Artigo> artigosParaVenda = new ArrayList<>();
        List<Artigo> artigosComprados = new ArrayList<>();
        List<Artigo> artigosVendidos = new ArrayList<>();

        List<Artigo> artigosParaVenda2 = new ArrayList<>();
        List<Artigo> artigosComprados2 = new ArrayList<>();
        List<Artigo> artigosVendidos2 = new ArrayList<>();

        List<Artigo> artigosParaVenda3 = new ArrayList<>();
        List<Artigo> artigosComprados3 = new ArrayList<>();
        List<Artigo> artigosVendidos3 = new ArrayList<>();

        List<Artigo> artigosParaVenda4 = new ArrayList<>();
        List<Artigo> artigosComprados4 = new ArrayList<>();
        List<Artigo> artigosVendidos4 = new ArrayList<>();

        List<Artigo> artigosParaVenda5 = new ArrayList<>();
        List<Artigo> artigosComprados5 = new ArrayList<>();
        List<Artigo> artigosVendidos5 = new ArrayList<>();

        // Artigos que cada vendedor está a disponibilizar

        artigosParaVenda.add(a1);
        artigosParaVenda.add(a2);
        artigosParaVenda.add(a3);

        artigosParaVenda2.add(a4);
        artigosParaVenda2.add(a5);
        artigosParaVenda2.add(a6);

        artigosParaVenda3.add(a7);
        artigosParaVenda3.add(a8);
        artigosParaVenda3.add(a9);

        artigosParaVenda4.add(a10);
        artigosParaVenda4.add(a11);
        artigosParaVenda4.add(a12);

        artigosParaVenda5.add(a13);
        artigosParaVenda5.add(a14);
        artigosParaVenda5.add(a15);

        // Informações de cada vendedor 
        
        Utilizador testUser = new Utilizador("user_mail", "user_pass", "user_name", "user_adress", "user_nif", artigosParaVenda, artigosComprados, artigosVendidos);
        this.utilizadorMap.put(testUser.getEmail(), testUser);
        Utilizador testUser2 = new Utilizador("afonso@mail.com", "afonso_pass", "Afonso", "Rua Afonsina", "234765189", artigosParaVenda2, artigosComprados2, artigosVendidos2);
        this.utilizadorMap.put(testUser2.getEmail(), testUser2);
        Utilizador testUser3 = new Utilizador("hugo@mail.com", "hugo_pass", "Hugo", "Largo Huguino", "345876809", artigosParaVenda3, artigosComprados3, artigosVendidos3);
        this.utilizadorMap.put(testUser3.getEmail(), testUser3);
        Utilizador testUser4 = new Utilizador("joao@mail.com", "joao_pass", "João", "Rua Joanzina", "365178321", artigosParaVenda4, artigosComprados4, artigosVendidos4);
        this.utilizadorMap.put(testUser4.getEmail(), testUser4);
        Utilizador testUser5 = new Utilizador("manuel@mail.com", "manuel_pass", "Emanuel", "Avenida Manuelina", "745213007", artigosParaVenda5, artigosComprados5, artigosVendidos5);
        this.utilizadorMap.put(testUser5.getEmail(), testUser5);
    }

    public boolean fazLogin(String email_input, String password_input){
        boolean resposta = false;
        if(this.utilizadorMap.containsKey(email_input) && this.utilizadorMap.get(email_input).comparaPassword(password_input)){
            resposta = true;
        }
        else{
            resposta = false;
        }
        return resposta;
    }

    public boolean fazRegisto(String email_input, String password_input, String nome_input, String morada_input, String numFiscal_input){
        boolean resposta = false;
        if(!this.utilizadorMap.containsKey(email_input)){
            //  o email passado como argumento NÃO existe no sistema logo pode-se criar nova conta

            List<Artigo> artigosParaVenda = new ArrayList<>();
            List<Artigo> artigosComprados = new ArrayList<>();
            List<Artigo> artigosVendidos = new ArrayList<>();
            Utilizador new_user = new Utilizador(email_input, password_input, nome_input, morada_input, numFiscal_input, artigosParaVenda, artigosComprados, artigosVendidos);

            this.utilizadorMap.put(email_input, new_user);
            resposta = true;
        }
        else{
            resposta = false;
        }
        return resposta;
    }
/*
    public boolean fazRegisto(String email_input, String password_input, String nome_input, String morada_input, String numFiscal_input){
        boolean resposta = false;
        if(!this.utilizadorMap.containsKey(email_input)){
            // verificar se o email e a password são válidos
            Pattern emailPattern = Pattern.compile("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
            Matcher emailMatcher = emailPattern.matcher(email_input);
            Pattern passwordPattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$");
            Matcher passwordMatcher = passwordPattern.matcher(password_input);
            
            if(emailMatcher.matches() && passwordMatcher.matches()) {
                // o email e a password são válidos, pode-se criar uma nova conta
                List<Artigo> artigosParaVenda = new ArrayList<>();
                List<Artigo> artigosComprados = new ArrayList<>();
                List<Artigo> artigosVendidos = new ArrayList<>();
                Utilizador new_user = new Utilizador(email_input, password_input, nome_input, morada_input, numFiscal_input, artigosParaVenda, artigosComprados, artigosVendidos);
    
                this.utilizadorMap.put(email_input, new_user);
                resposta = true;
            }
            else{
                resposta = false;
            }
        }
        else{
            resposta = false;
        }
        return resposta;
    }
    */


    public String printLoja(String email_userAtual){
        StringBuilder sb = new StringBuilder();

        sb.append("\n");
        sb.append("----------------------------------------------------------------------------------------------------------------------------------------").append("\n");

        for(Utilizador u : this.utilizadorMap.values()){
            if(!Objects.equals(u.getEmail(), email_userAtual)) {
                sb.append("\n");
                sb.append("Vendedor: " + u.getCodigo()).append("\n");
                sb.append(u.imprimeTodosArtigos());
                sb.append("\n");
            }
        }

        sb.append("----------------------------------------------------------------------------------------------------------------------------------------").append("\n");

        String res = sb.toString();
        return res;
    }

    public String printLoja2(){
        StringBuilder sb = new StringBuilder();
        double faturou = 0;

        sb.append("\n");
        sb.append("----------------------------------------------------------------------------------------------------------------------------------------").append("\n");

        for(Utilizador u : this.utilizadorMap.values()){
            sb.append("\n");
            sb.append("Vendedor: " +u.getCodigo()).append("\n");

            for(Artigo a : u.getArtigosVendidos()){
                faturou += a.precoFinalArtigo();
                sb.append("\t " + faturou + "\n");
            }
            sb.append("\n");
        }

        sb.append("----------------------------------------------------------------------------------------------------------------------------------------").append("\n");

        String res = sb.toString();
        return res;
    }

    public String printTransportadoras(){
        StringBuilder sb = new StringBuilder();

        sb.append("\n");
        sb.append("----------------------------------------------------------------------------------------------------------------------------------------").append("\n");
        sb.append("Transportadoras disponiveis no sistema:\n");

        for(Transportadora t : this.transportadoraMap.values()){
            sb.append("--> " +t.getNomeTransportadora()).append("\n");
        }

        sb.append("----------------------------------------------------------------------------------------------------------------------------------------").append("\n");

        String res = sb.toString();
        return res;
    }

    public String printEncomendas(){
        StringBuilder sb = new StringBuilder();

        sb.append("\n");
        sb.append("Encomendas atualmente no sistema:\n");

        for(Encomenda e : this.encomendaMap.values()){
            sb.append("--> " +e.toString()).append("\n");
        }

        String res = sb.toString();
        return res;
    }


    public void alteraEstadosEncomendas(LocalDate d){
        if(this.encomendaMap.isEmpty()){
            return;
        }
        else {
            for(Encomenda e : this.encomendaMap.values()) {
                if(e.passou48h(d)){
                    e.setEstado("expedida");
                    this.encomendaMap.put(e.getNumeroEncomenda(), e);
                }
            }
        }
    }


    public double getVintageBank(){
        return this.vintageBank;
    }


    public void parseInfoMala(Utilizador u, String infoMala) {
        // este metodo faz parse de uma string com a informação do novo artigo (mala) e adiciona-o à lista de artigos para venda do Utilizador u

        // parte comum a todos os artigos
        String[] splitString = infoMala.split(",");
        String estado = splitString[0].trim();
        String descricao = splitString[1].trim();
        String marca = splitString[2].trim();
        double preco = Double.parseDouble(splitString[3].trim());
        double desconto = Double.parseDouble(splitString[4].trim());
        int previousOwner = Integer.parseInt(splitString[5].trim());
        String nome_da_transportadora = splitString[6].trim();


        // parte especifica da mala
        double altura = Double.parseDouble(splitString[7].trim());
        double largura = Double.parseDouble(splitString[8].trim());
        double profundidade = Double.parseDouble(splitString[9].trim());
        String material = splitString[10].trim();
        String anoColecao = splitString[11].trim();

        if(!this.transportadoraMap.containsKey(nome_da_transportadora)){
            System.out.println("ERRO! Essa transportadora não existe!");
        }
        else {
            //busca a transportadora
            Transportadora t = getTransportadoraDataManager(nome_da_transportadora);

            Artigo new_artigo = new Mala(estado, descricao, marca, preco, desconto, previousOwner, t, altura, largura, profundidade, material, anoColecao);
            u.adicionaArtigo(new_artigo);
            this.utilizadorMap.put(u.getEmail(), u.clone());
        }
    }


    public void parseInfoSapatilha(Utilizador u, String infoSapatilha) {
        // este metodo faz parse de uma string com a informação do novo artigo (sapatilha) e adiciona-o à lista de artigos para venda do Utilizador u

        // parte comum a todos os artigos
        String[] splitString = infoSapatilha.split(",");
        String estado = splitString[0].trim();
        String descricao = splitString[1].trim();
        String marca = splitString[2].trim();
        double preco = Double.parseDouble(splitString[3].trim());
        double desconto = Double.parseDouble(splitString[4].trim());
        int previousOwner = Integer.parseInt(splitString[5].trim());
        String nome_da_transportadora = splitString[6].trim();

        // parte especifica da sapatilha
        int tamanho = Integer.parseInt(splitString[7].trim());
        String comoAperta = splitString[8].trim();
        String cor = splitString[9].trim();
        String anoColecao = splitString[10].trim();

        if(!this.transportadoraMap.containsKey(nome_da_transportadora)){
            System.out.println("ERRO! Essa transportadora não existe!");
        }
        else {
            //busca a transportadora
            Transportadora t = getTransportadoraDataManager(nome_da_transportadora);

            Artigo new_artigo = new Sapatilha(estado, descricao, marca, preco, desconto, previousOwner, t, tamanho, comoAperta, cor, anoColecao);
            u.adicionaArtigo(new_artigo);
            this.utilizadorMap.put(u.getEmail(), u.clone());
        }
    }


    public void parseInfoTShirt(Utilizador u, String infoTShirt) {
        // este metodo faz parse de uma string com a informação do novo artigo (t-shirt) e adiciona-o à lista de artigos para venda do Utilizador u

        // parte comum a todos os artigos
        String[] splitString = infoTShirt.split(",");
        String estado = splitString[0].trim();
        String descricao = splitString[1].trim();
        String marca = splitString[2].trim();
        double preco = Double.parseDouble(splitString[3].trim());
        double desconto = Double.parseDouble(splitString[4].trim());
        int previousOwner = Integer.parseInt(splitString[5].trim());
        String nome_da_transportadora = splitString[6].trim();

        // parte especifica da t-shirt
        String tamanho = splitString[7].trim();
        String padrao = splitString[8].trim();

        if(!this.transportadoraMap.containsKey(nome_da_transportadora)){
            System.out.println("ERRO! Essa transportadora não existe!");
        }
        else {
            //busca a transportadora
            Transportadora t = getTransportadoraDataManager(nome_da_transportadora);

            Artigo new_artigo = new TShirt(estado, descricao, marca, preco, desconto, previousOwner, t, tamanho, padrao);
            u.adicionaArtigo(new_artigo);
            this.utilizadorMap.put(u.getEmail(), u.clone());
        }
    }


    public void parseInfoTrans(String infoTransp) {
        String[] splitString = infoTransp.split(",");
        String nome = splitString[0].trim();
        double margemlucro = Double.parseDouble(splitString[1].trim());
        double imposto = Double.parseDouble(splitString[2].trim());

        Transportadora t = new Transportadora(nome, margemlucro, imposto);
        //System.out.println(t.toString());
        this.transportadoraMap.put(t.getNomeTransportadora(), t.clone());
    }


    private Artigo parseCodArtigo(String cod_artigo){
        String[] splitString = cod_artigo.split(",");
        int cod_vendedor = Integer.parseInt(splitString[0].trim());
        String alfanumerico_artigo = splitString[1].trim();
        Utilizador vendedor = new Utilizador();

        for(Utilizador u : this.utilizadorMap.values()){
            if(u.getCodigo() == cod_vendedor){
                vendedor = this.utilizadorMap.get(u.getEmail());
            }
        }

        Artigo new_artigo = this.utilizadorMap.get(vendedor.getEmail()).buscaArtigo(alfanumerico_artigo).clone();
        return new_artigo;
    }


    public double fazEncomenda(List<String> carrinho, String emailCliente,  String morada, String dataEncomenda){
        // faz o parse da lista de strings e cria uma lista de artigos
        Iterator i = carrinho.iterator();
        List<Artigo> artigosParaEncomenda = new ArrayList<>();
        Encomenda new_encomenda = new Encomenda(emailCliente, morada, dataEncomenda, "pendente", artigosParaEncomenda);

        while(i.hasNext()){
            String cod_artigo = (String) i.next();
            Artigo new_artigo = parseCodArtigo(cod_artigo);
            artigosParaEncomenda.add(new_artigo);
        }

        //adiciona os artigos, altera o estado e calcula o preço final
        new_encomenda.setEstado("pendente");
        new_encomenda.setArtigos(artigosParaEncomenda);
        double precoFinal = new_encomenda.calculaValorTotal();

        //altera o estado outra vez e devolve o preço final
        new_encomenda.setEstado("finalizada");
        this.encomendaMap.put(new_encomenda.getNumeroEncomenda(), new_encomenda);
        return precoFinal;
    }

    public String vendedorMaiorFaturacao(){
        double maior = -1;
        String res = "";
        Utilizador vend = new Utilizador();

        for(Utilizador vendedor : utilizadorMap.values()){
            if(vendedor.calculaFaturacaoVendedor() > maior){
                maior = vendedor.calculaFaturacaoVendedor();
            }
        }
        for(Utilizador vendedor : utilizadorMap.values()){
            if(vendedor.calculaFaturacaoVendedor() == maior){
                vend = vendedor.clone();
            }
        }
        res = "Vendedor que mais faturou: " + vend.getCodigo() + ", " + vend.getEmail();
        return res;
    }

    public Utilizador getUtilizador(String email_input){
        Utilizador u = new Utilizador();
        if(this.utilizadorMap.containsKey(email_input)){
            u = this.utilizadorMap.get(email_input).clone();
        }
        return u;
    }


    public Transportadora getTransportadoraDataManager(String nome_transportadora){
        Transportadora t = new Transportadora();
        if(this.transportadoraMap.containsKey(nome_transportadora)){
            t = this.transportadoraMap.get(nome_transportadora).clone();
        }
        return t;
    }


    //---------------------------------- METODOS PARA GUARDAR ESTADO DO PROGRAMA EM FICHEIROS ----------------------------------

    /*
    public static TreeSet<Artigo> loadArtigos() throws IOException, ClassNotFoundException {
        new File("artigos.bin");
        TreeSet<Artigo> artigos = null;
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("artigos.bin"));
        artigos = (TreeSet)input.readObject();
        input.close();
        return artigos;
    }

    public static List<Artigo> loadArtigos_STATIC() {

        Transportadora fedex = new Transportadora("FedEx", 0.4, 0.55);
        Transportadora ctt = new Transportadora("CTT", 0.5, 0.45);
        Transportadora  chronopost = new Transportadora(" Chronopost", 0.3, 0.8);

        // Sapatilhas
        Artigo a1 = new Sapatilha("novo", "Sapatilhas muito bonitas", "Rebook", 32.45, 0.3, 0, fedex, 43, "atacadores", "vermelho", "2023-02-27");
        Artigo a2 = new Sapatilha("novo", "Sapatilhas ainda mais bonitas", "Adidas", 44.50, 0.2, 0, ctt, 40, "atilhos", "verde", "2023-01-01");
        Artigo a3 = new Sapatilha("usado", "Sapatilhas um bocado usadas mais ainda boas", "Geox", 10, 0.1, 1, chronopost, 38, "atacadores", "branco", "2022-11-10");
        Artigo a4 = new Sapatilha("usado", "Sapatilhas usadas em bom estado", "Nike", 15, 0.15, 1, fedex, 41, "atacadores", "branco", "2018-09-12");
        Artigo a5 = new Sapatilha("novo", "Sapatilhas New Balance coleção 2023", "New Balance", 46.80, 0.2, 0, ctt, 42, "atacadores", "azul", "2023-03-10");
        Artigo a6 = new Sapatilha("novo", "Sapatilhas de boa marca", "Adidas", 35.60, 0.2, 0, chronopost, 46, "atilhos", "roxo", "2023-04-01");
        Artigo a7 = new Sapatilha("usado", "Sapatos em bom estado", "Calvin Klein", 45, 0.35, 1, ctt, 41, "atilhos", "bege", "2020-08-12");
        Artigo a8 = new Sapatilha("usado", "Botas usadas de qualidade", "Timberland", 21, 0.2, 2, fedex, 42, "atacadores", "castanho", "2019-11-12");
        Artigo a9 = new Sapatilha("usado", "Sapatilhas de corrida em bom estado", "Puma", 25, 0.22, 1, chronopost, 39, "atacadores", "amarelo", "2021-05-04");
        Artigo a10 = new Sapatilha("novo", "Sapatilhas novas da Nike", "Nike", 48, 0.19, 0, ctt, 40, "atacadores", "vermelho", "2023-05-04");
        Artigo a11 = new Sapatilha("usado", "Sapatos usados Michael Kors", "Michael Kors", 40, 0.23, 1, fedex, 38, "atacadores", "preto", "2020-04-23");
        Artigo a12 = new Sapatilha("usado", "Botas de senhora usados", "Calvin Klein", 37, 0.11, 1, chronopost, 39, "atilhos", "preto", "2022-06-13");
        Artigo a13 = new Sapatilha("novo", "Sapatilhas novas para menina", "Geox", 50, 0.2, 0, fedex, 31, "atacadores", "rosa", "2023-03-10");

        // T-Shirts
        Piloto p14 = new Piloto("Johnny Depp", "EUA", 6, 0.6);
        Piloto p15 = new Piloto("Volaré", "Espanha", 2, 0.8);
        Piloto p16 = new Piloto("Carlos Wet Floor", "Alemanha", 4, 1.0);
        Piloto p17 = new Piloto("Odete Peixoto", "Portugal", 4, 0.6);
        Piloto p18 = new Piloto("Olívia Palito", "Inglaterra", 3, 0.8);
        Piloto p19 = new Piloto("Woodie", "EUA", 7, 0.9);
        Piloto p20 = new Piloto("Andy Crescido", "EUA", 8, 0.7);
        Piloto p21 = new Piloto("Bela Adormecida", "Irlanda", 5, 0.3);
        Piloto p22 = new Piloto("Noddy", "Irlanda", 4, 0.5);
        Piloto p23 = new Piloto("Tunning", "Inglaterra", 6, 0.7);
        Piloto p24 = new Piloto("Joseph Tea", "Inglaterra", 7, 0.6);
        Piloto p25 = new Piloto("Marc Porshe", "França", 9, 0.5);
        Piloto p26 = new Piloto("Johnny Azeri", "Azerbeijão", 9, 0.5);

        // Malas
        Piloto p27 = new Piloto("James Dean", "EUA", 9, 0.9);
        Piloto p28 = new Piloto("James Dean Junior", "EUA", 8, 0.9);
        Piloto p29 = new Piloto("Rosa Mota", "Portugal", 7, 0.6);
        Piloto p30 = new Piloto("Rui Carro", "Portugal", 8, 0.3);
        Piloto p31 = new Piloto("Lisa Simpson", "EUA", 3, 0.6);
        Piloto p32 = new Piloto("Bart Simpson", "EUA", 5, 0.8);
        Piloto p33 = new Piloto("Kaname Kuran", "Japão", 5, 0.9);
        Piloto p34 = new Piloto("Yuki Kuran", "Japão", 2, 0.5);
        Piloto p35 = new Piloto("Leon Profession", "Cracóvia", 9, 0.4);
        Piloto p36 = new Piloto("Rose Deluxe", "Cracóvia", 9, 0.3);
        Piloto p37 = new Piloto("Jorge Sampaio", "Portugal", 4, 0.9);
        Piloto p38 = new Piloto("Paulo Portas", "Portugal", 4, 0.9);
        Piloto p39 = new Piloto("Marta Pocinhas", "Brasil", 5, 0.9);

        TreeSet<Utilizador> users = new TreeSet();
        participantes.add(c1);
        participantes.add(c2);
        participantes.add(c3);
        participantes.add(c4);
        participantes.add(c5);
        participantes.add(c6);
        participantes.add(c7);
        participantes.add(c8);
        participantes.add(c9);
        participantes.add(c10);
        participantes.add(c11);
        participantes.add(c12);
        participantes.add(c13);
        participantes.add(c14);
        participantes.add(c15);
        participantes.add(c16);
        participantes.add(c17);
        participantes.add(c18);
        participantes.add(c19);
        participantes.add(c20);
        return participantes;

    }

    public static TreeSet<Carro> loadParticipantesBasicos() {

        Carro c1 = new PC1(1, "Lamborghini", "Tó", 280, eq1, 0);
        Carro c2 = new PC1(2, "Porsche", "Henrique", 250, eq2, 0);
        Carro c3 = new PC1(3, "Ferrari", "Mariana", 350, eq3, 0);
        Carro c4 = new PC1Hibrido(9004, "VolksWagen", "Golf", 260, 160, eq4, 0);
        Carro c5 = new PC1Hibrido(9005, "Porsche", "Ambientalista", 300, 190, eq5, 0);
        Carro c6 = new PC2(6, "Porce", "Chines", 6000, 250, eq6, 0, 0.4);
        Carro c7 = new PC2(7, "Kitt", "Vemibuscar", 4500, 220, eq7, 0, 0.9);
        Carro c8 = new PC2(8, "Delorean", "Grey", 5000, 180, eq8, 0, 0.9);
        Carro c9 = new PC2Hibrido(9009, "Marcada", "Porreira", 4900, 250, 150, eq9, 0, 0.8);
        Carro c10 = new PC2Hibrido(9010, "Mercedes", "Racer", 5000, 290, 130, eq10, 0, 0.9);
        Carro c11 = new PC2Hibrido(9011, "Ford", "Consciente", 5500, 260, 260, eq11, 0, 0.7);
        Carro c12 = new PC2Hibrido(9012, "Ford", "Focado", 5000, 150, 179, eq12, 0, 0.9);
        Carro c13 = new GT(13, "Fiat", "Panda", 3500, 180, eq13, 0);
        Carro c14 = new GT(14, "Fiat", "Punto", 3000, 220, eq14, 0);
        Carro c15 = new GT(15, "Mazda", "Racing", 4500, 230, eq15, 0);
        Carro c16 = new GTHibrido(9016, "Mazda", "Friendly", 4000, 170, 140, eq16, 0);
        Carro c17 = new GTHibrido(9017, "Ford", "NewFriendly", 3800, 220, 170, eq17, 0);
        Carro c18 = new SC(18, "VolksWagen", "Lupo", 180, eq18, 0);
        Carro c19 = new SC(19, "Fiat", "Punto", 120, eq19, 0);
        Carro c20 = new SC(20, "Mazda", "ZZ", 150, eq20, 0);

        TreeSet<Utilizador> users = new TreeSet();
        participantes.add(c1);
        participantes.add(c2);
        participantes.add(c3);
        participantes.add(c4);
        participantes.add(c5);
        participantes.add(c6);
        participantes.add(c7);
        participantes.add(c8);
        participantes.add(c9);
        participantes.add(c10);
        participantes.add(c11);
        participantes.add(c12);
        participantes.add(c13);
        participantes.add(c14);
        participantes.add(c15);
        participantes.add(c16);
        participantes.add(c17);
        participantes.add(c18);
        participantes.add(c19);
        participantes.add(c20);
        return participantes;
    }

    public static Utilizadores loadUtilizadores() throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("users.bin"));
        Utilizadores users = (Utilizadores)input.readObject();
        input.close();
        return users;
    }

    public static Campeonato loadSavedGame(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream game = new ObjectInputStream(new FileInputStream(filename + ".bin"));
        int nCamp = (Integer)game.readObject();
        int nCorr = (Integer)game.readObject();
        TreeSet<Carro> parts = (TreeSet)game.readObject();
        ArrayList<Circuito> circs = (ArrayList)game.readObject();
        Classificacao classif = new Classificacao(parts);
        classif.setResultadosCampeonato(parts);
        ArrayList<Utilizador> jogad = (ArrayList)game.readObject();
        HashSet<Utilizador> apostCamp = (HashSet)game.readObject();
        Campeonato novo = new Campeonato(nCamp, circs, nCorr, parts, classif, jogad, apostCamp);
        game.close();
        return novo;
    }

    public static void saveCircuitosB(ArrayList<Circuito> circs1, ArrayList<Circuito> circs2) throws IOException {
        ObjectOutputStream fileParts = new ObjectOutputStream(new FileOutputStream("circuitos.bin", false));
        Iterator var3 = circs1.iterator();

        Circuito aux;
        while(var3.hasNext()) {
            aux = (Circuito)var3.next();
            aux.cleanApostadores();
        }

        var3 = circs2.iterator();

        while(var3.hasNext()) {
            aux = (Circuito)var3.next();
            aux.cleanApostadores();
        }

        fileParts.writeObject(circs1);
        fileParts.writeObject(circs2);
        fileParts.flush();
        fileParts.close();
    }

    public static void saveParticipantesB(TreeSet<Carro> parts) throws IOException {
        Iterator var1 = parts.iterator();

        while(var1.hasNext()) {
            Carro aux = (Carro)var1.next();
            aux.setVoltaDNF(0);
            aux.setTempoCorrida(0.0);
            aux.setPontos(0);
        }

        ObjectOutputStream fileParts = new ObjectOutputStream(new FileOutputStream("participantes.bin", false));
        fileParts.writeObject(parts);
        fileParts.flush();
        fileParts.close();
    }

    public static void saveGame(String filename, int nCamp, ArrayList<Circuito> circs, int nCorr, TreeSet<Carro> parts, Classificacao classif, ArrayList<Utilizador> jogad, HashSet<Utilizador> apostCamp) throws IOException {
        ObjectOutputStream gameA = new ObjectOutputStream(new FileOutputStream(filename + ".bin", false));
        gameA.writeObject(nCamp);
        gameA.writeObject(nCorr);
        gameA.writeObject(parts);
        gameA.writeObject(circs);
        gameA.writeObject(jogad);
        gameA.writeObject(apostCamp);
        gameA.flush();
        gameA.close();
    }

    public static void saveUtilizadores(Utilizadores bdjogadores, ArrayList<Utilizador> cUsers) throws IOException {
        Iterator var2 = cUsers.iterator();

        while(var2.hasNext()) {
            Utilizador utilizador = (Utilizador)var2.next();
            utilizador.cleanApostasActuais();
            bdjogadores.actualiza(utilizador);
        }

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("users.bin", false));
        output.writeObject(bdjogadores);
        output.flush();
        output.close();
    }
    */
}
