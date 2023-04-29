package SubEncomenda;

import java.io.Serializable;
import java.time.LocalDate;


public class Fatura implements Serializable{

    private static int num_sequencia = 0;

    private int faturaId;
    private LocalDate faturaData; // igual à data de encomenda
    private int numeroEncomenda;
    private String nome_vendedor;
    private String nif_vendedor;
    private String nome_comprador; // do user_atual
    private String nif_comprador; // do user_atual
    private double preço_artigo;
    private double preço_expedicao; //
    private String nomeTransportadora;
    private String codArtigo;


    public Fatura() {
        this.faturaId = num_sequencia++;
        this.numeroEncomenda = 0;
        this.nome_vendedor = "";
        this.nif_vendedor = "";
        this.nome_comprador = "";
        this.nif_comprador = "";
        this.preço_artigo = 0;
        this.preço_expedicao = 0;
        this.codArtigo = "";
    }

    public Fatura(LocalDate dataEncomenda, int numeroEncomenda, String nome_vendedor, String nif_vendedor, String nome_comprador, String nif_comprador, double preço_artigo, double preço_expedicao, String codArtigo) {
        this.faturaId = num_sequencia++;
        this.faturaData = dataEncomenda;
        this.numeroEncomenda = numeroEncomenda;
        this.nome_vendedor = nome_vendedor;
        this.nif_vendedor = nif_vendedor;
        this.nome_comprador = nome_comprador;
        this.nif_comprador = nif_comprador;
        this.preço_artigo = preço_artigo;
        this.preço_expedicao = preço_expedicao;
        this.codArtigo = codArtigo;
    }


    public int getFaturaId() {
        return this.faturaId;
    }


    public void setFaturaId(int FaturaId) {
        this.faturaId = faturaId;
    }


    public LocalDate getFaturaData() {
        return this.faturaData;
    }


    public void setFaturaData(LocalDate faturaData) {
        this.faturaData = faturaData;
    }


    public double getTotal() {
        return total;
    }


    public void setTotal(double total) {
        this.total = total;
    }


    public double getLucro() {
        return this.lucro;
    }


    public void setLucro(double lucro) {
        this.lucro = lucro;
    }


    public Encomenda getEnc() {
        return encomenda;
    }


    public void setEnc(Encomenda enc) {
        this.encomenda = enc;
    }


    @Override
    public String toString() {
        return "Invoice [ID = " + faturaId + ", Data de Emissão = " + faturaData + ", SubEncomenda.Encomenda = " + encomenda + ", Lucro = "
                + lucro + ", Valor Total = " + total + "]";
    }
    
    
    


}
