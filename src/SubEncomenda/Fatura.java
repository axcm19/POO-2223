package SubEncomenda;

import SubArtigo.Artigo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Fatura implements Serializable{

    private static int num_sequencia = 0;


    //---------------------------------- VARIAVEIS DE INSTANCIA ----------------------------------


    private int faturaId;
    private LocalDate faturaData; // igual à data de encomenda
    private int numeroEncomenda;
    private String nome_vendedor;
    private String nif_vendedor;
    private String nome_comprador; // do user_atual
    private String nif_comprador; // do user_atual
    private double preco_artigo;
    private double preco_expedicao; //
    private String nomeTransportadora;
    private String codArtigo;


    // -------------------- CONSTRUTORES --------------------


    public Fatura() {
        this.faturaId = num_sequencia++;
        this.numeroEncomenda = 0;
        this.nome_vendedor = "";
        this.nif_vendedor = "";
        this.nome_comprador = "";
        this.nif_comprador = "";
        this.preco_artigo = 0;
        this.preco_expedicao = 0;
        this.nomeTransportadora = "";
        this.codArtigo = "";
    }

    public Fatura(LocalDate dataEncomenda, int numeroEncomenda, String nome_vendedor, String nif_vendedor, String nome_comprador, String nif_comprador, double preco_artigo, double preco_expedicao, String nomeTransportadora,String codArtigo) {
        this.faturaId = num_sequencia++;
        this.faturaData = dataEncomenda;
        this.numeroEncomenda = numeroEncomenda;
        this.nome_vendedor = nome_vendedor;
        this.nif_vendedor = nif_vendedor;
        this.nome_comprador = nome_comprador;
        this.nif_comprador = nif_comprador;
        this.preco_artigo = preco_artigo;
        this.preco_expedicao = preco_expedicao;
        this.nomeTransportadora = nomeTransportadora;
        this.codArtigo = codArtigo;
    }

    public Fatura(Fatura fat) {
        this.faturaId = fat.getFaturaId();
        this.faturaData = fat.getFaturaData();
        this.numeroEncomenda = fat.getNumeroEncomenda();
        this.nome_vendedor = fat.getNomeVendedor();
        this.nif_vendedor = fat.nif_vendedor;
        this.nome_comprador = fat.getNomeComprador();
        this.nif_comprador = fat.getNifComprador();
        this.preco_artigo = fat.getPrecoArtigo();
        this.preco_expedicao = fat.getPrecoExpedicao();
        this.nomeTransportadora = fat.getNomeTransportadora();
        this.codArtigo = fat.getCodArtigo();
    }


    // -------------------- GETTERS & SETTERS --------------------


    public int getFaturaId() {
        return this.faturaId;
    }


    public void setFaturaId(int faturaId) {
        this.faturaId = faturaId;
    }


    public LocalDate getFaturaData() {
        return this.faturaData;
    }


    public void setFaturaData(LocalDate faturaData) {
        this.faturaData = faturaData;
    }

    public int getNumeroEncomenda() {
        return this.numeroEncomenda;
    }

    public void setNumeroEncomenda(int numeroEncomenda) {
        this.numeroEncomenda = numeroEncomenda;
    }
    
    public String getNomeVendedor() {
        return this.nome_vendedor;
    }

    public void setNomeVendedor(String nome_vendedor) {
        this.nome_vendedor = nome_vendedor;
    }

    public String getNifVendedor() {
        return this.nif_vendedor;
    }

    public void setNifVendedor(String nif_vendedor) {
        this.nif_vendedor = nif_vendedor;
    }

    public String getNomeComprador() {
        return this.nome_comprador;
    }

    public void setNomeComprador(String nome_comprador) {
        this.nome_comprador = nome_comprador;
    }
    
    public String getNifComprador() {
        return this.nif_comprador;
    }

    public void setNifComprador(String nif_comprador) {
        this.nif_comprador = nif_comprador;
    }

    public double getPrecoArtigo() {
        return this.preco_artigo;
    }

    public void setPrecoArtigo(double preco_artigo) {
        this.preco_artigo = preco_artigo;
    }

    public double getPrecoExpedicao() {
        return this.preco_expedicao;
    }

    public void setPrecoExpedicao(double preco_expedicao) {
        this.preco_expedicao = preco_expedicao;
    }

    public String getNomeTransportadora() {
        return this.nomeTransportadora;
    }

    public void setNomeTransportadora(String nomeTransportadora) {
        this.nomeTransportadora = nomeTransportadora;
    }

    public String getCodArtigo() {
        return this.codArtigo;
    }

    public void setCodArtigo(String codArtigo) {
        this.codArtigo = codArtigo;
    }


    //--------------------- CLONE / EQUALS ---------------------


    public String toString() {
        String sValue1 = (String) String.format("%.2f", this.preco_artigo);
        String sValue2 = (String) String.format("%.2f", this.preco_expedicao);

        StringBuilder sb = new StringBuilder();
        sb.append("Nª FATURA: ").append(this.faturaId).append(" | ENC-").append(this.numeroEncomenda).append(" | ").append(this.codArtigo).append(" | ").append(this.faturaData.toString()).append("\n");
        sb.append("Vendedor: ").append(this.nome_vendedor).append(" | ").append(this.nif_vendedor).append("\n");
        sb.append("Comprador: ").append(this.nome_comprador).append(" | ").append(this.nif_comprador).append("\n");
        sb.append("Preço: ").append(sValue1).append("\n");
        sb.append("Transportadora: ").append(this.nomeTransportadora).append(" | ").append(sValue2).append("\n");

        String res = sb.toString();
        return res;
    }

    public Fatura clone(){
        return new Fatura(this);
    }


    //---------------------------------- OUTROS METODOS ----------------------------------


    public boolean comparaDatas(LocalDate d1, LocalDate d2){
        boolean res;

        if(this.faturaData.isAfter(d1) && this.faturaData.isBefore(d2)){
            res = true;
        }
        else if(this.faturaData.isEqual(d1) && this.faturaData.isBefore(d2)){
            res = true;
        }
        else if(this.faturaData.isAfter(d1) && this.faturaData.isEqual(d2)){
            res = true;
        }
        else{
            res = false;
        }

        return res;
    }


}
