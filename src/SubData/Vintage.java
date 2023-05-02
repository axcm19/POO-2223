package SubData;/*
ESTA CLASSE É RESPONSÁVEL POR TODOS OS MÉTODOS QUE PERMITEM SALVAR E RECUPERAR O ESTADO DO PROGRAMA
(MUITO INACABADO!!!)
 */

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
    private Map<String, Artigo> artigoMap;
    private Map<String, Utilizador> utilizadorMap;
    private Map<Integer, Encomenda> encomendaMap;
    private Map<String, Transportadora> transportadoraMap;
    private Map<Integer, Fatura> faturasMap;
    private double vintageBank;


    //---------------------------------- CONSTRUTORES ----------------------------------


    public Vintage() {
        this.artigoMap = new HashMap<>();
        this.utilizadorMap = new HashMap<>();
        this.encomendaMap = new HashMap<>();
        this.transportadoraMap = new HashMap<>();
        this.faturasMap = new HashMap<>();
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
        Artigo a3 = new Mala("usado", "SubArtigo.Mala usada da gucci", "Gucci", 20.30, 0.2, 1, chronopost, 25,30,15, "couro", "2022");

        Artigo a4 = new Sapatilha("usado", "Sapatilhas usadas em bom estado", "Adidas", 20, 0.4, 1, ctt, 40, "atacadores", "brnaco", "2021");
        Artigo a5 = new TShirt("usado", "Camisola usada. Apenas rasgada num canto", "Gap", 7.5, 0.2, 2, chronopost, "M", "liso");
        Artigo a6 = new Mala("usado", "Pochete usada", "Bimba y Lola", 10.5, 0.25, 1, fedex, 10,20,5, "poliéster", "2022");

        Artigo a7 = new Sapatilha("usado", "Sapatos usados Michael Kors", "Michael Kors", 36, 0.23, 1, chronopost, 38, "atacadores", "preto", "2020");
        Artigo a8 = new TShirt("novo", "Camisola nova", "Guess", 33.99, 0.05, 0, fedex, "S", "riscas");
        Artigo a9 = new Mala("novo", "SubArtigo.Mala nova da Desigual", "Desigual", 30, 0.15, 0, ctt, 18,22,10, "pele sintética", "2023");

        Artigo a10 = new Sapatilha("usado", "Botas de senhora usados", "Calvin Klein", 37, 0.11, 1, fedex, 39, "atilhos", "preto", "2022");
        Artigo a11 = new TShirt("usado", "Camisola com algum uso", "Boss", 7, 0.35, 1, ctt, "L", "liso");
        Artigo a12 = new Mala("usado", "SubArtigo.Mala com alguns anos", "Moschino", 16.7, 0.5, 1, chronopost, 30,40,20, "feltro", "2019");

        Artigo a13 = new Sapatilha("usado", "Sapatos em bom estado", "Calvin Klein", 45, 0.35, 1, ctt, 41, "atilhos", "bege", "2020");
        Artigo a14 = new TShirt("usado", "T-Shirt em segunda mão", "Macron", 5.5, 0.18, 1, chronopost, "XL", "riscas");
        Artigo a15 = new Mala("usado", "SubArtigo.Mala em segunda mão", "Latouche", 18, 0.1, 1, fedex, 20,25,15, "pele sintética", "2017");

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
                List<SubArtigo.Artigo> artigosParaVenda = new ArrayList<>();
                List<SubArtigo.Artigo> artigosComprados = new ArrayList<>();
                List<SubArtigo.Artigo> artigosVendidos = new ArrayList<>();
                SubUtilizador.Utilizador new_user = new SubUtilizador.Utilizador(email_input, password_input, nome_input, morada_input, numFiscal_input, artigosParaVenda, artigosComprados, artigosVendidos);
    
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
        // este metodo faz parse de uma string com a informação do novo artigo (mala) e adiciona-o à lista de artigos para venda do SubUtilizador.Utilizador u

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
        // este metodo faz parse de uma string com a informação do novo artigo (sapatilha) e adiciona-o à lista de artigos para venda do SubUtilizador.Utilizador u

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
        // este metodo faz parse de uma string com a informação do novo artigo (t-shirt) e adiciona-o à lista de artigos para venda do SubUtilizador.Utilizador u

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


    private Fatura criaFatura(String cod_artigo, LocalDate dataEncomenda, int numeroEncomenda, String nome_cliente, String nif_cliente){
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
        Fatura new_fatura = new Fatura(dataEncomenda, numeroEncomenda, vendedor.getNome(), vendedor.getNumFiscal(), nome_cliente, nif_cliente, new_artigo.getPreco(), new_artigo.getTransportadora().calculaValorExpedicao(), new_artigo.getTransportadora().getNomeTransportadora(), new_artigo.getAlfanumerico());
        return new_fatura;
    }


    public void removeArtigoVendedor(List<String> carrinho){
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

            vendedor.removeArtigo(alfanumerico_artigo);
        }
    }


    public double fazEncomenda(List<String> carrinho, String emailCliente,  String morada, String dataEncomenda, Utilizador user_atual){
        // faz o parse da lista de strings e cria uma lista de artigos
        Iterator i = carrinho.iterator();
        List<Artigo> artigosParaEncomenda = new ArrayList<>();
        Encomenda new_encomenda = new Encomenda(emailCliente, morada, dataEncomenda, "pendente", artigosParaEncomenda);

        while(i.hasNext()){
            String cod_artigo = (String) i.next();
            Artigo new_artigo = parseCodArtigo(cod_artigo);
            Fatura new_fatura = criaFatura(cod_artigo, new_encomenda.getDataEncomenda(), new_encomenda.getNumeroEncomenda(), user_atual.getNome(), user_atual.getNumFiscal());
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


    public void trocaArtigosParaTodasEncomendasUserAtual(Utilizador user_atual){

        if(this.encomendaMap.isEmpty()){
            return;
        }
        /*
        else {
            for(Encomenda e : this.encomendaMap.values()) {
                if(Objects.equals(e.getEstado(), "expedida")){
                    Iterator it = e.getArtigos().iterator();

                    while(it.hasNext()){
                        Artigo a = (Artigo) it.next();
                        this.utilizadorMap.get(e.getEmailCliente()).adicionaArtigoComprado(a.clone());
                    }
                }
            }
        }*/
        else {
            for (Encomenda e : this.encomendaMap.values()) {
                if (Objects.equals(e.getEstado(), "expedida") && Objects.equals(e.getEmailCliente(), user_atual.getEmail())) {
                    Iterator it = e.getArtigos().iterator();

                    while (it.hasNext()) {
                        Artigo a = (Artigo) it.next();
                        user_atual.adicionaArtigoComprado(a.clone());
                        this.utilizadorMap.put(user_atual.getEmail(), user_atual);
                    }
                }
            }
        }
    }

    public void trocaArtigosParaTodasEncomendas(Utilizador user_atual){

        if(this.encomendaMap.isEmpty()){
            return;
        }

        else {
            for(Encomenda e : this.encomendaMap.values()) {
                if(Objects.equals(e.getEstado(), "expedida") && !Objects.equals(e.getEmailCliente(), user_atual.getEmail())){
                    Iterator it = e.getArtigos().iterator();

                    while(it.hasNext()){
                        Artigo a = (Artigo) it.next();
                        this.utilizadorMap.get(e.getEmailCliente()).adicionaArtigoComprado(a.clone());
                    }
                }
            }
        }
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
