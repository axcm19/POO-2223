/*
 * Cada artigo terá uma transportadora atribuida (o vendedor é que
 * decide que transportadora é que vai estar associcada a cada artigo)
 */

import java.io.Serializable;

public class Transportadora implements Serializable {
    private String nomeTransportadora;
    private double margemLucro;
    private double imposto;
    //private double valorBase;
    
// -------------------- CONSTRUTORES --------------------

// Construtor Vazio
    public Transportadora(){
        this.nomeTransportadora = " ";
        // variável para cada transportadora
        this.margemLucro = 0;
        // imposto já deve estar pré-definido para cada transportadora (nao sei se precisa de ser uma variável de instância);
        this.imposto = 0;
        // para calcular este preco de expedição precisamos do valor base da encomenda e da margem de lucro e do impsosto.
        // o problema aqui é que para saber o valor base da encomenda, precisamos de saber quantas encomendas é que são.
        // ha um valor base diferente para cada tipo de encomenda:
        // pequenas (1 artigo)
        // médias (2 a 5 artigos)
        // grandes (mais de 5 artigos)
        //this.valorBase = 0;
        // portanto, temos que decidir onde é que esta quantidade de artigos vai ficar. na encomenda, ou aqui mesmo na transportadora?
    }

// Construtor Parametrizado
    public Transportadora(String nomeTransportadora, double margemLucro, double imposto){
        this.nomeTransportadora = nomeTransportadora;
        this.margemLucro = margemLucro;
        this.imposto = imposto;
        //this.valorBase = valorBase;
    }

// Construtor Copia
    public Transportadora(Transportadora t){
        this.nomeTransportadora = t.getNomeTransportadora();
        this.margemLucro = t.getMargemLucro();
        this.imposto = t.getImposto();
        //this.valorBase = t.getValorBase();
    }

// -------------------- GETTERS & SETTERS --------------------

    private String getNomeTransportadora(){
        return this.nomeTransportadora;
    }

    private void setNomeTransportadora(String nomeTransportadora) {
        this.nomeTransportadora = nomeTransportadora;
    }

    private double getMargemLucro(){
        return this.margemLucro;
    }

    private void setMargemLucro(int margemLucro){
        this.margemLucro = margemLucro;
    }

    private double getImposto(){
        return this.imposto;
    }

    private void setImposto(int imposto){
        this.imposto = imposto;
    }

    //private double getValorBase(){
    //    return this.valorBase;
    //}

    //private void setValorBase(int valorBase){
     //   this.valorBase = valorBase;
    //}

//--------------------- CLONE / EQUALS ---------------------

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Transportadora t = (Transportadora) o;
        return (this.nomeTransportadora == t.getNomeTransportadora() 
        && this.margemLucro == t.getMargemLucro()
        && this.imposto == t.getImposto());
        //&& this.valorBase == t.getValorBase());
    }

    public Transportadora clone(){
        return new Transportadora(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("TRANSPORTADORA: " + this.nomeTransportadora + "\n");
        sb.append("Valor Expedição: " + this.calculaValorExpedicao());
        String res = sb.toString();
        return res;
    }

    public int compareTo(Transportadora t){
        // comparação feita pelo nome da Transportadora 
        return this.nomeTransportadora.compareTo(t.getNomeTransportadora());
    }

// -------------------- OUTROS MÉTODOS --------------------

    public double calculaValorExpedicao(){
        double precoExpedicao = (/*this.getValorBase() **/ this.getMargemLucro() * (1 + this.getImposto())) * 0.9;
        return precoExpedicao;   
    }



}
