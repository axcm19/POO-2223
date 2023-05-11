package SubData;

import SubArtigo.Artigo;
import SubArtigo.Mala;
import SubArtigo.Sapatilha;
import SubArtigo.TShirt;
import SubEncomenda.Encomenda;
import SubEncomenda.Fatura;
import SubEncomenda.Transportadora;
import SubUtilizador.Utilizador;

import java.io.*;
import java.time.LocalDate;
import java.util.*;


public class Vintage implements Serializable {

    //---------------------------------- VARIAVEIS DE INSTANCIA ----------------------------------

    private static final long serialVersionUID = 2916140161489104192L;

    // maps onde se vai guardar a informação retirada dos ficheiros que guardam o estado do programa

    private Map<String, Artigo> artigoMap;  //guarda uma copia de todos os artigos que existem ou já existiram no Vintage (não é suposto iterar isto)
    private Map<String, Utilizador> utilizadorMap;
    private Map<Integer, Encomenda> encomendaMap;
    private Map<String, Transportadora> transportadoraMap;
    private Map<Integer, Fatura> faturasMap;
    private double vintageBank;
    private Utilizador user_atual; // utilizador que está atualmente a usar o Vintage
    private LocalDate dataAtual;


    //---------------------------------- CONSTRUTORES ----------------------------------


    public Vintage() {
        this.artigoMap = new HashMap<>();
        this.utilizadorMap = new HashMap<>();
        this.encomendaMap = new HashMap<>();
        this.transportadoraMap = new HashMap<>();
        this.faturasMap = new HashMap<>();
        this.vintageBank = 5000;
        this.user_atual = new Utilizador();
        this.dataAtual = null;
    }


    //---------------------------------- METODOS PARA GESTÃO DOS DADOS QUE ESTÃO CARREGADOS NO PROGRAMA ----------------------------------


    public void carregaDados() {
        // ESTE MÉTODO SÓ SERVE PARA CARREGAR DADOS RAPIDAMENTE PARA O SISTEMA CASO SE PERCA O FICHEIRO BINÁRIO ORIGINAL!!!
        
        // Transportadoras Disponiveis

        Transportadora fedex = new Transportadora("FedEx", 0.4, 0.55);
        Transportadora ctt = new Transportadora("CTT", 0.5, 0.45);
        Transportadora  chronopost = new Transportadora("Chronopost", 0.3, 0.8);

        this.transportadoraMap.put(fedex.getNomeTransportadora(), fedex);
        this.transportadoraMap.put(ctt.getNomeTransportadora(), ctt);
        this.transportadoraMap.put(chronopost.getNomeTransportadora(), chronopost);

        // Artigos Disponiveis 

        Artigo a1 = new Sapatilha("novo", "Sapatilhas muito bonitas", "Rebook", 32.45, 0, fedex, 0.3,43, "atacadores", "vermelho", "2023");
        Artigo a2 = new TShirt("usado", "T-Shirt usada em bom estado", "Nike", 10.5, 1, ctt, "S", "palmeiras");
        Artigo a3 = new Mala("usado", "Mala usada da gucci", "Gucci", 20.30, 1, chronopost, 25,30,15, "couro", "2022");

        Artigo a4 = new Sapatilha("usado", "Sapatilhas usadas em bom estado", "Adidas", 20, 1, ctt, 0.4,40, "atacadores", "branco", "2021");
        Artigo a5 = new TShirt("usado", "Camisola usada. Apenas rasgada num canto", "Gap", 7.5, 2, chronopost, "M", "liso");
        Artigo a6 = new Mala("usado", "Pochete usada", "Bimba y Lola", 10.5, 1, fedex, 10,20,5, "poliéster", "2022");

        Artigo a7 = new Sapatilha("usado", "Sapatos usados Michael Kors", "Michael Kors", 36, 1, chronopost, 0.23,38, "atacadores", "preto", "2020");
        Artigo a8 = new TShirt("novo", "Camisola nova", "Guess", 33.99, 0, fedex, "S", "riscas");
        Artigo a9 = new Mala("novo", "Mala nova da Desigual", "Desigual", 30, 0, ctt, 18,22,10, "pele sintética", "2023");

        Artigo a10 = new Sapatilha("usado", "Botas de senhora usados", "Calvin Klein", 37, 1, fedex, 0.11,39, "atilhos", "preto", "2022");
        Artigo a11 = new TShirt("usado", "Camisola com algum uso", "Boss", 7, 1, ctt, "L", "liso");
        Artigo a12 = new Mala("usado", "Mala com alguns anos", "Moschino", 16.7, 1, chronopost, 30,40,20, "feltro", "2019");

        Artigo a13 = new Sapatilha("usado", "Sapatos em bom estado", "Calvin Klein", 45, 1, ctt, 0.35,41, "atilhos", "bege", "2020");
        Artigo a14 = new TShirt("usado", "T-Shirt em segunda mão", "Macron", 5.5, 1, chronopost, "XL", "riscas");
        Artigo a15 = new Mala("usado", "Mala em segunda mão", "Latouche", 18, 1, fedex, 20,25,15, "pele sintética", "2017");


        this.artigoMap.put(a1.getAlfanumerico(), a1.clone());
        this.artigoMap.put(a2.getAlfanumerico(), a2.clone());
        this.artigoMap.put(a3.getAlfanumerico(), a3.clone());
        this.artigoMap.put(a4.getAlfanumerico(), a4.clone());
        this.artigoMap.put(a5.getAlfanumerico(), a5.clone());
        this.artigoMap.put(a6.getAlfanumerico(), a6.clone());
        this.artigoMap.put(a7.getAlfanumerico(), a7.clone());
        this.artigoMap.put(a8.getAlfanumerico(), a8.clone());
        this.artigoMap.put(a9.getAlfanumerico(), a9.clone());
        this.artigoMap.put(a10.getAlfanumerico(), a10.clone());
        this.artigoMap.put(a11.getAlfanumerico(), a11.clone());
        this.artigoMap.put(a12.getAlfanumerico(), a12.clone());
        this.artigoMap.put(a13.getAlfanumerico(), a13.clone());
        this.artigoMap.put(a14.getAlfanumerico(), a14.clone());
        this.artigoMap.put(a15.getAlfanumerico(), a15.clone());

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
        
        Utilizador testUser = new Utilizador("carmelita@mail.com", "carmelita_pass", "Carmelita", "Largo Dos Carmeleiros", "531897402", artigosParaVenda, artigosComprados, artigosVendidos);
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
            this.user_atual = this.utilizadorMap.get(email_input).clone();
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


    public String printLoja(){
        StringBuilder sb = new StringBuilder();

        sb.append("\n");
        sb.append("----------------------------------------------------------------------------------------------------------------------------------------").append("\n");

        for(Utilizador u : this.utilizadorMap.values()){
            if(!Objects.equals(u.getEmail(), this.user_atual.getEmail())) {
                sb.append("\n");
                sb.append("Vendedor: " + u.getCodigo() + " - " +u.getNome()).append("\n");
                sb.append(u.imprimeTodosArtigos());
                sb.append("\n");
            }
        }

        sb.append("----------------------------------------------------------------------------------------------------------------------------------------").append("\n");

        String res = sb.toString();
        return res;
    }

    public String printTransportadoras(){
        StringBuilder sb = new StringBuilder();

        sb.append("\n");
        sb.append("-----------------------------------------------------------").append("\n");
        sb.append("Transportadoras disponiveis no sistema:\n");

        for(Transportadora t : this.transportadoraMap.values()){
            sb.append("--> " +t.getNomeTransportadora()).append("\n");
        }

        sb.append("-----------------------------------------------------------").append("\n");

        String res = sb.toString();
        return res;
    }


    public String printArtigos(){
        StringBuilder sb = new StringBuilder();

        sb.append("\n");
        sb.append("-----------------------------------------------------------").append("\n");
        sb.append("Registo de todos os artigos que existiram ou existem no sistema:\n");

        for(Artigo a : this.artigoMap.values()){
            sb.append("--> " +a.toString()).append("\n");
        }

        sb.append("-----------------------------------------------------------").append("\n");

        String res = sb.toString();
        return res;
    }


    public String printFaturas(){
        StringBuilder sb = new StringBuilder();

        sb.append("\n");
        sb.append("Faturas no sistema:\n");

        for(Fatura f : this.faturasMap.values()){
            sb.append("--> " +f.toString()).append("\n");
        }


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


    public void alteraEstadosEncomendas(){
        if(this.encomendaMap.isEmpty()){
            return;
        }
        else {
            for(Encomenda e : this.encomendaMap.values()) {
                if(e.passou48h(this.dataAtual)){
                    e.setEstado("expedida");
                    this.encomendaMap.put(e.getNumeroEncomenda(), e);
                }
            }
        }
    }


    public double getVintageBank(){
        return this.vintageBank;
    }


    public String parseInfoMala(String infoMala) {
        // este metodo faz parse de uma string com a informação do novo artigo (mala) e adiciona-o à lista de artigos para venda do SubUtilizador.Utilizador u
        String res = "";

        // parte comum a todos os artigos
        String[] splitString = infoMala.split(",");
        String estado = splitString[0].trim();
        String descricao = splitString[1].trim();
        String marca = splitString[2].trim();
        double preco = Double.parseDouble(splitString[3].trim());
        //double desconto = Double.parseDouble(splitString[4].trim());
        int previousOwner = Integer.parseInt(splitString[4].trim());
        String nome_da_transportadora = splitString[5].trim();

        // parte especifica da mala
        double altura = Double.parseDouble(splitString[6].trim());
        double largura = Double.parseDouble(splitString[7].trim());
        double profundidade = Double.parseDouble(splitString[8].trim());
        String material = splitString[9].trim();
        String anoColecao = splitString[10].trim();

        if(!this.transportadoraMap.containsKey(nome_da_transportadora)){
            res = "ERRO! Essa transportadora não existe!";
        }

        else if(estado.equals("novo") || estado.equals("usado")) {

            if (estado.equals("novo") && previousOwner >= 1) {
                res = "ERRO! Um artigo novo não pode ter donos anteriores!";
            }
            else if (estado.equals("usado") && previousOwner <= 0) {
                res = "ERRO! Indicou que o artigo é usado mas o número de donos anteriores não é válido!";
            }
            else {
                //busca a transportadora
                Transportadora t = getTransportadoraDataManager(nome_da_transportadora);

                Artigo new_artigo = new Mala(estado, descricao, marca, preco, previousOwner, t, altura, largura, profundidade, material, anoColecao);
                this.user_atual.adicionaArtigo(new_artigo);
                this.artigoMap.put(new_artigo.getAlfanumerico(), new_artigo.clone());
                this.utilizadorMap.put(this.user_atual.getEmail(), this.user_atual.clone());
                res = "Artigo(Mala) criado com sucesso! Verifique a lista de artigos que tem para venda.";
            }
        }
        else {
            res = "ERRO! O artigo tem de ser 'novo' ou 'usado'!";
        }
        return res;
    }


    public String parseInfoSapatilha(String infoSapatilha) {
        // este metodo faz parse de uma string com a informação do novo artigo (sapatilha) e adiciona-o à lista de artigos para venda do SubUtilizador.Utilizador u
        String res = "";

        // parte comum a todos os artigos
        String[] splitString = infoSapatilha.split(",");
        String estado = splitString[0].trim();
        String descricao = splitString[1].trim();
        String marca = splitString[2].trim();
        double preco = Double.parseDouble(splitString[3].trim());
        int previousOwner = Integer.parseInt(splitString[4].trim());
        String nome_da_transportadora = splitString[5].trim();

        // parte especifica da sapatilha
        double desconto = Double.parseDouble(splitString[6].trim());
        int tamanho = Integer.parseInt(splitString[7].trim());
        String comoAperta = splitString[8].trim();
        String cor = splitString[9].trim();
        String anoColecao = splitString[10].trim();

        if(!this.transportadoraMap.containsKey(nome_da_transportadora)){
            res = "ERRO! Essa transportadora não existe!";
        }

        else if(!comoAperta.equals("atilhos") && !comoAperta.equals("atacadores")){
            res = "ERRO! A sapatilha só pode ter 'atilhos' ou 'atacadores'!";
        }

        else if(estado.equals("novo") || estado.equals("usado") ) {

                if (estado.equals("novo") && previousOwner >= 1) {
                    res = "ERRO! Um artigo novo não pode ter donos anteriores!";
                }
                else if (estado.equals("usado") && previousOwner <= 0) {
                    res = "ERRO! Indicou que o artigo é usado mas o número de donos anteriores não é válido!";
                }
                else {
                //busca a transportadora
                Transportadora t = getTransportadoraDataManager(nome_da_transportadora);

                Artigo new_artigo = new Sapatilha(estado, descricao, marca, preco, previousOwner, t, desconto, tamanho, comoAperta, cor, anoColecao);
                this.user_atual.adicionaArtigo(new_artigo);
                this.artigoMap.put(new_artigo.getAlfanumerico(), new_artigo.clone());
                this.utilizadorMap.put(this.user_atual.getEmail(), this.user_atual.clone());
                res = "Artigo(Sapatilha) criado com sucesso! Verifique a lista de artigos que tem para venda.";
            }
        }
        else {
            res = "ERRO! O artigo tem de ser 'novo' ou 'usado'!";
        }
        return res;
    }


    public String parseInfoTShirt(String infoTShirt) {
        // este metodo faz parse de uma string com a informação do novo artigo (t-shirt) e adiciona-o à lista de artigos para venda do SubUtilizador.Utilizador u
        String res = "";

        // parte comum a todos os artigos
        String[] splitString = infoTShirt.split(",");
        String estado = splitString[0].trim();
        String descricao = splitString[1].trim();
        String marca = splitString[2].trim();
        double preco = Double.parseDouble(splitString[3].trim());
        //double desconto = Double.parseDouble(splitString[4].trim());
        int previousOwner = Integer.parseInt(splitString[4].trim());
        String nome_da_transportadora = splitString[5].trim();

        // parte especifica da t-shirt
        String tamanho = splitString[6].trim();
        String padrao = splitString[7].trim();

        if(!this.transportadoraMap.containsKey(nome_da_transportadora)){
            res = "ERRO! Essa transportadora não existe!";
        }

        else if(!padrao.equals("liso") && !padrao.equals("riscas") && !padrao.equals("palmeiras")){
            res = "ERRO! A t-shirt só pode ter padrão 'liso', 'riscas' ou 'palmeiras'!";
        }

        else if(estado.equals("novo") || estado.equals("usado") ) {

            if (estado.equals("novo") && previousOwner >= 1) {
                res = "ERRO! Um artigo novo não pode ter donos anteriores!";
            }
            else if (estado.equals("usado") && previousOwner <= 0) {
                res = "ERRO! Indicou que o artigo é usado mas o número de donos anteriores não é válido!";
            }
            else {
                //busca a transportadora
                Transportadora t = getTransportadoraDataManager(nome_da_transportadora);

                Artigo new_artigo = new TShirt(estado, descricao, marca, preco, previousOwner, t, tamanho, padrao);
                this.user_atual.adicionaArtigo(new_artigo);
                this.artigoMap.put(new_artigo.getAlfanumerico(), new_artigo.clone());
                this.utilizadorMap.put(this.user_atual.getEmail(), this.user_atual.clone());
                res = "Artigo(T-Shirt) criado com sucesso! Verifique a lista de artigos que tem para venda.";
            }
        }
        else {
            res = "ERRO! O artigo tem de ser 'novo' ou 'usado'!";
        }
        return res;
    }


    public void parseInfoTrans(String infoTransp) {
        String[] splitString = infoTransp.split(",");
        String nome = splitString[0].trim();
        double margemlucro = Double.parseDouble(splitString[1].trim());
        double imposto = Double.parseDouble(splitString[2].trim());

        Transportadora t = new Transportadora(nome, margemlucro, imposto);
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


    private Fatura criaFatura(String cod_artigo, LocalDate dataEncomenda, int numeroEncomenda){
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
        Fatura new_fatura = new Fatura(dataEncomenda, numeroEncomenda, vendedor.getNome(), vendedor.getNumFiscal(), this.user_atual.getNome(), this.user_atual.getNumFiscal(), new_artigo.getPreco(), new_artigo.getTransportadora().calculaValorExpedicao(), new_artigo.getTransportadora().getNomeTransportadora(), new_artigo.getAlfanumerico());
        return new_fatura;
    }


    public void removeArtigoVendedorAposVenda(List<String> carrinho){
        // faz o parse da lista de strings e remove os artigos dos vendedores após pagar a encomenda
        Iterator i = carrinho.iterator();

        while(i.hasNext()){
            String cod_artigo = (String) i.next();

            String[] splitString = cod_artigo.split(",");
            int cod_vendedor = Integer.parseInt(splitString[0].trim());
            String alfanumerico_artigo = splitString[1].trim();
            Utilizador vendedor = new Utilizador();

            for(Utilizador u : this.utilizadorMap.values()){
                if(u.getCodigo() == cod_vendedor){
                    vendedor = this.utilizadorMap.get(u.getEmail());
                }
            }

            vendedor.removeArtigoAposVenda(alfanumerico_artigo);
        }
    }


    public void removeArtigoUtilizador(String alfanumerico_artigo){
        this.user_atual.removeArtigo(alfanumerico_artigo, 1);
        this.utilizadorMap.put(this.user_atual.getEmail(), this.user_atual.clone());
    }


    public double fazEncomenda(List<String> carrinho){
        // faz o parse da lista de strings e cria uma lista de artigos
        Iterator i = carrinho.iterator();
        List<Artigo> artigosParaEncomenda = new ArrayList<>();
        Encomenda new_encomenda = new Encomenda(this.user_atual.getEmail(), this.user_atual.getMorada(), this.dataAtual.toString(), "pendente", artigosParaEncomenda);

        while(i.hasNext()){
            String cod_artigo = (String) i.next();
            Artigo new_artigo = parseCodArtigo(cod_artigo);
            Fatura new_fatura = criaFatura(cod_artigo, new_encomenda.getDataEncomenda(), new_encomenda.getNumeroEncomenda());
            artigosParaEncomenda.add(new_artigo);
            this.faturasMap.put(new_fatura.getFaturaId(), new_fatura);
        }

        //adiciona os artigos, altera o estado e calcula o preço final
        new_encomenda.setEstado("pendente");
        new_encomenda.setArtigos(artigosParaEncomenda);
        double precoFinal = new_encomenda.calculaValorTotal();

        //altera o estado outra vez e devolve o preço final
        new_encomenda.setEstado("finalizada");
        this.encomendaMap.put(new_encomenda.getNumeroEncomenda(), new_encomenda);
        this.vintageBank += new_encomenda.calculaTaxaServico();

        return precoFinal;
    }

    public String fazDevolucao(int codigoEnc){
        String res = "";

        if (!this.encomendaMap.containsKey(codigoEnc)) {
            res = "Essa encomenda não existe!";
            return res;
        }
        else {

            Encomenda enc = this.encomendaMap.get(codigoEnc).clone();

            if(!enc.getEmailCliente().equals(this.user_atual.getEmail())){
                res = "Não foi você que fez esta encomenda logo não a pode devolver!";
            }

            else if(enc.getDevolvido().equals("sim")){
                res = "Você já devolveu esta encomenda!";
            }

            else if(!enc.getEstado().equals("expedida") ){
                res = "Impossivel devolver esta encomenda! Ainda não foi expedida!";
            }

            else if(enc.getEstado().equals("expedida") && enc.passou96h(this.dataAtual)){
                res = "Impossivel devolver esta encomenda! Já ultrapassou o limite de tempo estipulado!";
            }

            else if(enc.getEstado().equals("expedida") && !enc.passou96h(this.dataAtual)){
                List<Fatura> filtro = new ArrayList<>();

                //filtragem das faturas que têm o numero de encomenda procurado
                for(Fatura fat : this.faturasMap.values()){
                    if(fat.getNumeroEncomenda() == enc.getNumeroEncomenda()){
                        filtro.add(fat.clone());
                    }
                }

                //map que associa codigos de artigos a nomes de vendedores
                Map<String, String> pares = new HashMap<>(); // Map<cod_art, nome_vendedor>
                //Map<String, String> pares2 = new HashMap<>(); // Map<cod_art, nome_comprador>

                //preenchimento do map
                for(Fatura fatura : filtro){
                    String nome_comprador = fatura.getNomeComprador();
                    String nome_vendedor = fatura.getNomeVendedor();
                    String cod_art = fatura.getCodArtigo();
                    pares.put(cod_art, nome_vendedor);
                    //pares2.put(cod_art, nome_comprador);
                }

                /*
                // remove os artigos da lista de comprados do comprador
                for(Map.Entry entry : pares2.entrySet()){
                    String nome = (String) entry.getValue();
                    Utilizador comprador = getUtilizadorByName(nome);

                    Artigo art = this.artigoMap.get(entry.getKey()).clone();
                    comprador.removeArtigo(art.getAlfanumerico(), 2);
                    this.utilizadorMap.put(comprador.getEmail(), comprador.clone());

                }*/

                //adicionar os artigos novamente aos vendedores
                for(Map.Entry entry : pares.entrySet()){
                    String nome = (String) entry.getValue();
                    Utilizador vendedor = getUtilizadorByName(nome);
                    Artigo art = this.artigoMap.get(entry.getKey()).clone();

                    vendedor.adicionaArtigo(art.clone());
                    vendedor.removeArtigo(art.getAlfanumerico(), 3);
                    this.user_atual.removeArtigo(art.getAlfanumerico(), 2);
                    this.utilizadorMap.put(vendedor.getEmail(), vendedor.clone());
                    this.utilizadorMap.put(this.user_atual.getEmail(), this.user_atual.clone());

                    enc.setDevolvido("sim");
                    this.encomendaMap.put(enc.getNumeroEncomenda(), enc.clone());
                    res = "Devolução concluida!";
                }

            }

        }
        return res;
    }

    public String ordenaVendedores(LocalDate data1, LocalDate data2){
        String res = "";
        List<Fatura> filtro = new ArrayList<>();
        Map<String, Double> acumuladores = new HashMap<>();

        for(Fatura fat : this.faturasMap.values()){
            if(fat.comparaDatas(data1, data2)){
                filtro.add(fat.clone());
            }
        }

        for(Fatura fatura : filtro){
            String nome_vendedor = fatura.getNomeVendedor();
            double preco_artigo = fatura.getPrecoArtigo();
            double preco_acumulado = acumuladores.getOrDefault(nome_vendedor, 0.0);
            acumuladores.put(nome_vendedor, preco_acumulado + preco_artigo);
        }

        List<Map.Entry<String, Double>> lista = new ArrayList<>(acumuladores.entrySet());
        lista.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        StringBuilder sb = new StringBuilder();
        sb.append("\n");

        Iterator it = lista.iterator();
        while(it.hasNext()){
            Map.Entry e = (Map.Entry) it.next();
            String sValue1 = (String) String.format("%.2f", e.getValue());
            sb.append("Vendedor: ").append(e.getKey()).append(" | Quanto lucrou: ").append(sValue1).append("€\n");
        }

        res = sb.toString();
        return res;
    }


    public String ordenaCompradores(LocalDate data1, LocalDate data2){
        String res = "";
        List<Fatura> filtro = new ArrayList<>();
        Map<String, Double> acumuladores = new HashMap<>();

        for(Fatura fat : this.faturasMap.values()){
            if(fat.comparaDatas(data1, data2)){
                filtro.add(fat.clone());
            }
        }

        for(Fatura fatura : filtro){
            String nome_comprador = fatura.getNomeComprador();
            double preco_artigo = fatura.getPrecoArtigo();
            double preco_acumulado = acumuladores.getOrDefault(nome_comprador, 0.0);
            acumuladores.put(nome_comprador, preco_acumulado + preco_artigo);
        }

        List<Map.Entry<String, Double>> lista = new ArrayList<>(acumuladores.entrySet());
        lista.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        StringBuilder sb = new StringBuilder();
        sb.append("\n");

        Iterator it = lista.iterator();
        while(it.hasNext()){
            Map.Entry e = (Map.Entry) it.next();
            String sValue1 = (String) String.format("%.2f", e.getValue());
            sb.append("Comprador: ").append(e.getKey()).append(" | Quanto gastou: ").append(sValue1).append("€\n");
        }

        res = sb.toString();
        return res;
    }


    public String vendedorMaiorFaturacao(LocalDate data1, LocalDate data2){
        double maior = -1;
        String res = "";
        List<Fatura> filtro = new ArrayList<>();
        Map<String, Double> acumuladores = new HashMap<>();
        String vendedor_final = "";

        for(Fatura fat : this.faturasMap.values()){
            if(fat.comparaDatas(data1, data2)){
                filtro.add(fat.clone());
            }
        }

        for(Fatura fatura : filtro){
            String nome_vendedor = fatura.getNomeVendedor();
            double preco_artigo = fatura.getPrecoArtigo();
            double preco_acumulado = acumuladores.getOrDefault(nome_vendedor, 0.0);
            acumuladores.put(nome_vendedor, preco_acumulado + preco_artigo);
        }

        for(String vendedor : acumuladores.keySet()){
            double acumulado = acumuladores.get(vendedor);
            if (acumulado > maior) {
                maior = acumulado;
                vendedor_final = vendedor;
            }
        }

        String sValue1 = (String) String.format("%.2f", maior);
        res = "Vendedor que mais faturou: " + vendedor_final + "| Total acumulado = " + sValue1+ "€";
        return res;
    }


    public String transportadoraMaiorFaturacao(LocalDate data1, LocalDate data2){
        double maior = -1;
        String res = "";
        List<Fatura> filtro = new ArrayList<>();
        Map<String, Double> acumuladores = new HashMap<>();
        String transportadora_final = "";

        for(Fatura fat : this.faturasMap.values()){
            if(fat.comparaDatas(data1, data2)){
                filtro.add(fat.clone());
            }
        }

        for(Fatura fatura : filtro){
            String nome_transp = fatura.getNomeTransportadora();
            double preco_expedicao = fatura.getPrecoExpedicao();
            double preco_acumulado = acumuladores.getOrDefault(nome_transp, 0.0);
            acumuladores.put(nome_transp, preco_acumulado + preco_expedicao);
        }

        for(String t : acumuladores.keySet()){
            double acumulado = acumuladores.get(t);
            if (acumulado > maior) {
                maior = acumulado;
                transportadora_final = t;
            }
        }
        String sValue1 = (String) String.format("%.2f", maior);
        res = "Transportadora que mais faturou: " + transportadora_final + "| Total acumulado = " + sValue1 + "€";
        return res;
    }


    private Utilizador getUtilizador(String email_input){
        Utilizador u = new Utilizador();
        if(this.utilizadorMap.containsKey(email_input)){
            u = this.utilizadorMap.get(email_input).clone();
        }
        return u;
    }


    private Utilizador getUtilizadorByName(String nome){
        Utilizador res = new Utilizador();
        for(Utilizador user : this.utilizadorMap.values()){
            if(user.getNome().equals(nome)){
                res = new Utilizador(user.clone());
                break;
            }
        }
        return res;
    }


    private Transportadora getTransportadoraDataManager(String nome_transportadora){
        Transportadora t = new Transportadora();
        if(this.transportadoraMap.containsKey(nome_transportadora)){
            t = this.transportadoraMap.get(nome_transportadora).clone();
        }
        return t;
    }


    public void trocaArtigosParaTodasEncomendasUserAtual(){

        if(this.encomendaMap.isEmpty()){
            return;
        }
        else {
            for (Encomenda e : this.encomendaMap.values()) {
                if (Objects.equals(e.getEstado(), "expedida") && Objects.equals(e.getEmailCliente(), this.user_atual.getEmail())) {
                    Iterator it = e.getArtigos().iterator();

                    while (it.hasNext()) {
                        Artigo a = (Artigo) it.next();
                        this.user_atual.adicionaArtigoComprado(a.clone());
                        this.utilizadorMap.put(this.user_atual.getEmail(), this.user_atual.clone());
                    }
                }
            }
        }
    }

    public void trocaArtigosParaTodasEncomendas(){

        if(this.encomendaMap.isEmpty()){
            return;
        }

        else {
            for(Encomenda e : this.encomendaMap.values()) {
                if(Objects.equals(e.getEstado(), "expedida") && !Objects.equals(e.getEmailCliente(), this.user_atual.getEmail())){
                    Iterator it = e.getArtigos().iterator();

                    while(it.hasNext()){
                        Artigo a = (Artigo) it.next();
                        this.utilizadorMap.get(e.getEmailCliente()).adicionaArtigoComprado(a.clone());
                    }
                }
            }
        }
    }


    public void ultimoNumeroFatura(){
        int res = this.faturasMap.size();
        Fatura.atualizaNumeroSequencia(res);
    }


    public void ultimoNumeroEncomenda(){
        int res = this.encomendaMap.size();
        Encomenda.atualizaNumeroSequencia(res);
    }


    public void ultimoCodigoArtigo(){
        int res = this.artigoMap.size();
        Artigo.atualizaCodigo(res);
    }

    public void ultimoCodigoUtilizador(){
        int res = this.utilizadorMap.size();
        Utilizador.atualizaCodigo(res+1);
    }

    public String printInfoLista(int option){ // 1 - artigosParaVenda; 2 - Lista de artigosComprados; 3 - Lista de artigosVendidos
        return this.user_atual.printInfoLista(option);
    }

    public String printInfoUser(){
        return this.user_atual.printInfoUser();
    }

    public void setDataAtual(LocalDate novaData){
        this.dataAtual = novaData;
    }

    public LocalDate getDataAtual(){
        return this.dataAtual;
    }


    //---------------------------------- METODOS PARA GUARDAR ESTADO DO PROGRAMA EM FICHEIROS ----------------------------------


    public void guardaEstado(String filename) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }

    public static Vintage carregaEstado(String filename)throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Vintage v = (Vintage) ois.readObject();
        ois.close();
        return v;
    }

}
