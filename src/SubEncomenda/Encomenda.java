package SubEncomenda;/*
Uma encomenda refere-se a várias linhas de encomenda
 */

import SubArtigo.Artigo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Encomenda implements Comparable<Encomenda>, Serializable {


    //---------------------------------- VARIAVEIS DE INSTANCIA ----------------------------------

    private static int num_sequencia = 0;   // variável de classe comum a todas as instâncias de SubEncomenda.Encomenda

    private String emailCliente;
    private String morada;
    private int numeroEncomenda;
    private LocalDate dataEncomenda;
    private String estado; //(pendente, finalizada e expedida)
    private List<Artigo> artigos = new ArrayList<>();


    //---------------------------------- CONSTRUTORES ----------------------------------

    public Encomenda(){
        this.numeroEncomenda = num_sequencia++;
        this.estado = "pendente";
    }

    public Encomenda(String emailCliente, String morada, String dataEncomenda, String estado, List<Artigo>artigos){
        this.emailCliente = emailCliente;
        this.morada = morada;
        this.numeroEncomenda = num_sequencia++;
        this.dataEncomenda = LocalDate.parse(dataEncomenda);
        this.estado = estado;

        for(Artigo art : artigos){
            this.artigos.add(art.clone());
        }
    }

    public Encomenda(Encomenda e){
        this.emailCliente = e.getEmailCliente();
        this.morada = e.getMorada();
        this.numeroEncomenda = e.getNumeroEncomenda();
        this.dataEncomenda = e.getDataEncomenda();
        this.estado = e.getEstado();

        for(Artigo art : e.artigos){
            this.artigos.add(art.clone());
        }
    }


    //---------------------------------- GET'S E SET'S ----------------------------------


    public String getEmailCliente(){
        return this.emailCliente;
    }

    private String getMorada(){
        return this.morada;
    }

    public int getNumeroEncomenda(){
        return this.numeroEncomenda;
    }

    public LocalDate getDataEncomenda(){
        return this.dataEncomenda;
    }

    public String getEstado(){
        return this.estado;
    }

    public List<Artigo>  getArtigos(){
        List<Artigo> res = new ArrayList<>();

        for(Artigo art : this.artigos){
            res.add(art.clone());
        }

        return res;
    }

    private void setEmailCliente(String emailCliente){
        this.emailCliente = emailCliente;
    }

    private void setMorada(String morada){
        this.morada = morada;
    }

    private void setDataEncomenda(String dataEncomenda){
        this.dataEncomenda = LocalDate.parse(dataEncomenda);
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    public void setArtigos(List<Artigo> new_artigos){
        this.artigos.clear();

        for(Artigo art : new_artigos){
            this.artigos.add(art.clone());
        }
    }


    //---------------------------------- CLONE / EQUALS ----------------------------------


    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Encomenda le = (Encomenda) o;
        return (this.emailCliente == le.getEmailCliente() && this.morada == le.getMorada() &&
                this.numeroEncomenda == le.getNumeroEncomenda() && this.dataEncomenda == le.getDataEncomenda() && this.artigos == le.getArtigos());
    }

    public Encomenda clone(){
        return new Encomenda(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nª ENCOMENDA: ").append(this.numeroEncomenda).append(" - Email do cliente: ").append(this.emailCliente);
        sb.append(" - Estado: ").append(this.estado).append(" - Data: ").append(this.dataEncomenda.toString()).append("\n");

        if(this.artigos == null) {
            sb.append("");
        }
        else {
            for (Artigo a : this.artigos) {
                sb.append("\t " + a.toString());
            }
        }

        String res = sb.toString();
        return res;
    }

    public int compareTo(Encomenda e){
        // comparação feita pelo nome do cliente
        return this.emailCliente.compareTo(e.getEmailCliente());
    }


    //---------------------------------- OUTROS METODOS ----------------------------------


    public int numeroTotalArtigos(){
        return this.artigos.size();
    }

    public double calculaValorTotal(){
        double res = 0;
        int quantosArt = this.numeroTotalArtigos();
        double valorBase = 0;

        if(quantosArt == 1){
            valorBase = 1.99;
        }
        if(quantosArt > 1 && quantosArt <= 5){
            valorBase = 2.99;
        }
        if(quantosArt > 5){
            valorBase = 3.5;
        }

        for(Artigo art : this.artigos){
            res += art.precoFinalArtigo() + valorBase;
        }

        return res;
    }

    public double calculaTaxaServico(){
        double res = 0;

        for(Artigo art : this.artigos){
            if(Objects.equals(art.getEstado(), "usado")){
                res += 0.25;
            }
            if(Objects.equals(art.getEstado(), "novo")){
                res += 0.5;
            }
        }

        return res;
    }

    public boolean existeArtigoEncomenda(String alfanumericoArtigo){
        boolean res = false;

        for(Artigo art : this.artigos){
            if(Objects.equals(art.getAlfanumerico(), alfanumericoArtigo)){
                res = true;
            }
        }

        return res;
    }

    public void adicionaArtigo(Artigo artigo){
        Artigo novo = artigo.clone();
        this.artigos.add(novo);
    }

    public void removeArtigo(String alfanumericoArtigo){

        /*
        //---> feito desta forma pode dar erro de excepção!!!

        for(Linha_Encomenda enc : this.linhas_enco){
            if(enc.getReferencia().equals(codProd)){
                this.linhas_enco.remove(enc);
            }
        }
        */

        // assim já não dá
        Iterator i = this.artigos.iterator();
        while(i.hasNext()){
            Artigo art = (Artigo) i.next();
            if(Objects.equals(art.getAlfanumerico(), alfanumericoArtigo)){
                i.remove();
            }
        }
    }

    public boolean passou48h(LocalDate d){
        // testa se passaram 48h (2 dias) entre a data da encomenda e a data passada como argumento
        boolean res;
        long dif = ChronoUnit.DAYS.between(this.dataEncomenda, d);

        if(dif >= 2){
            res = true;
        }
        else{
            res = false;
        }

        return res;
    }

}
