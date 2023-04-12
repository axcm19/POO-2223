/*
Uma encomenda refere-se a várias linhas de encomenda
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Encomenda implements Comparable<Encomenda> {


    //---------------------------------- VARIAVEIS DE INSTANCIA ----------------------------------

    private static int num_sequencia = 0;   // variável de classe comum a todas as instâncias de Encomenda

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

    public Encomenda(String emailCliente, int NIF, String morada, String dataEncomenda, String estado, List<Artigo>artigos){
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


    private String getEmailCliente(){
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

    private String getEstado(){
        return this.estado;
    }

    private List<Artigo>  getArtigos(){
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

    private void setEstado(String estado){
        this.estado = estado;
    }

    private void setArtigos(List<Artigo> new_artigos){
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
        sb.append("ENCOMENDA: ").append(this.numeroEncomenda).append("\n");
        sb.append("---> ").append(this.artigos.toString()).append("\n");

        String res = sb.toString();
        return res;
    }

    public int compareTo(Encomenda e){
        // comparação feita pelo nome do cliente
        return this.emailCliente.compareTo(e.getEmailCliente());
    }


    //---------------------------------- OUTROS METODOS ----------------------------------


    public double calculaValorTotal(){
        double res = 0;

        for(Artigo art : this.artigos){
            res += art.precoFinalArtigo();
        }

        return res;
    }

    public int numeroTotalArtigos(){
        return this.artigos.size();
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

}
