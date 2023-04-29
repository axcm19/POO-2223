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
        return numeroEncomenda;
    }

    public void setNumeroEncomenda(int numeroEncomenda) {
        this.numeroEncomenda = numeroEncomenda;
    }
    
    public String getNomeVendedor() {
        return nome_vendedor;
    }

    public void setNomeVendedor(String nome_vendedor) {
        this.nome_vendedor = nome_vendedor;
    }

    public String getNifVendedor() {
        return nif_vendedor;
    }

    public void setNifVendedor(String nif_vendedor) {
        this.nif_vendedor = nif_vendedor;
    }

    public String getNomeComprador() {
        return nome_comprador;
    }

    public void setNomeComprador(String nome_comprador) {
        this.nome_comprador = nome_comprador;
    }
    
    public String getNifComprador() {
        return nif_comprador;
    }

    public void setNifComprador(String nif_comprador) {
        this.nif_comprador = nif_comprador;
    }

    public double getPreçoArtigo() {
        return preço_artigo;
    }

    public void setPreçoArtigo(double preço_artigo) {
        this.preço_artigo = preço_artigo;
    }

    public double getPreçoExpedicao() {
        return preço_expedicao;
    }

    public void setPreçoExpedicao(double preço_expedicao) {
        this.preço_expedicao = preço_expedicao;
    }

    public String getNomeTransportadora() {
        return nomeTransportadora;
    }

    public void setNomeTransportadora(String nomeTransportadora) {
        this.nomeTransportadora = nomeTransportadora;
    }

    public String getCodArtigo() {
        return codArtigo;
    }

    public void setCodArtigo(String codArtigo) {
        this.codArtigo = codArtigo;
    }

    @Override
    public String toString() {
        return "Fatura [ID = " + faturaId + ", Data de Emissão = " + faturaData + ", Encomenda = " + encomenda + ", Lucro = "
                + lucro + ", Valor Total = " + total + "]";
    }
    
    
    


}
