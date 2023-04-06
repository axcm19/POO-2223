/*
Uma encomenda refere-se a várias linhas de encomenda
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Encomenda implements Comparable<Encomenda> {


    //---------------------------------- VARIAVEIS DE INSTANCIA ----------------------------------


    private String nomeCliente;
    private int NIF;
    private String morada;
    private int numeroEncomenda;
    private static int num_sequencia = 0;   // variável de classe comum a todas as instâncias de EncEficiente
    private LocalDate dataEncomenda;
    private ArrayList<Linha_Encomenda> linhas_enco = new ArrayList<>();


    //---------------------------------- CONSTRUTORES ----------------------------------


    public Encomenda(){
        numeroEncomenda = num_sequencia++;
    }

    public Encomenda(String nomeCliente, int NIF, String morada, String dataEncomenda, ArrayList<Linha_Encomenda>linhas){
        this.nomeCliente = nomeCliente;
        this.NIF = NIF;
        this.morada = morada;
        this.numeroEncomenda = num_sequencia++;
        this.dataEncomenda = LocalDate.parse(dataEncomenda);

        for(Linha_Encomenda enc : linhas){
            this.linhas_enco.add(enc.clone());
        }
    }

    public Encomenda(Encomenda e){
        this.nomeCliente = e.getNomeCliente();
        this.NIF = e.getNIF();
        this.morada = e.getMorada();
        numeroEncomenda = num_sequencia++;
        this.dataEncomenda = e.getDataEncomenda();

        for(Linha_Encomenda enc : e.linhas_enco){
            this.linhas_enco.add(enc.clone());
        }
    }


    //---------------------------------- GET'S E SET'S ----------------------------------


    private String getNomeCliente(){
        return this.nomeCliente;
    }

    private int getNIF(){
        return this.NIF;
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

    private ArrayList<Linha_Encomenda>  getLinhas_enco(){
        ArrayList<Linha_Encomenda> res = new ArrayList<>();

        for(Linha_Encomenda enc : this.linhas_enco){
            res.add(enc.clone());
        }

        return res;
    }

    private void setNomeCliente(String nomeCliente){
        this.nomeCliente = nomeCliente;
    }

    private void setNIF(int NIF){
        this.NIF = NIF;
    }

    private void setMorada(String morada){
        this.morada = morada;
    }

    private void setDataEncomenda(String dataEncomenda){
        this.dataEncomenda = LocalDate.parse(dataEncomenda);
    }

    private void setLinhas_enco(ArrayList<Linha_Encomenda> linhas){
        this.linhas_enco.clear();

        for(Linha_Encomenda enc : linhas){
            this.linhas_enco.add(enc.clone());
        }
    }


    //---------------------------------- CLONE / EQUALS ----------------------------------


    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Encomenda le = (Encomenda) o;
        return (this.nomeCliente == le.getNomeCliente() && this.NIF == le.getNIF() && this.morada == le.getMorada() &&
                this.numeroEncomenda == le.getNumeroEncomenda() && this.dataEncomenda == le.getDataEncomenda() && this.linhas_enco == le.getLinhas_enco());
    }

    public Encomenda clone(){
        return new Encomenda(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ENCOMENDA_EFICIENTE: ").append(this.numeroEncomenda).append("\n");
        sb.append("---> ").append(this.linhas_enco.toString()).append("\n");

        String res = sb.toString();
        return res;
    }

    public int compareTo(Encomenda e){
        // comparação feita pelo nome do cliente
        return this.nomeCliente.compareTo(e.getNomeCliente());
    }


    //---------------------------------- OUTROS METODOS ----------------------------------


    public double calculaValorTotal(){
        double res = 0;

        for(Linha_Encomenda le : this.linhas_enco){
            res += le.calculaValorLinhaEnc();
        }

        return res;
    }

    public double calculaValorDesconto(){
        double res = 0;

        for(Linha_Encomenda le : this.linhas_enco){
            res += le.calculaValorDesconto();
        }

        return res;
    }

    public int numeroTotalProdutos(){
        int res = 0;

        for(Linha_Encomenda le : this.linhas_enco){
            res += le.getQuantidade();
        }

        return res;
    }

    public boolean existeProdutoEncomenda(String refProduto){
        boolean res = false;

        for(Linha_Encomenda le : this.linhas_enco){
            if(Objects.equals(le.getReferencia(), refProduto)){
                res = true;
            }
        }

        return res;
    }

    public void adicionaLinha(Linha_Encomenda linha){
        Linha_Encomenda nova = linha.clone();
        this.linhas_enco.add(nova);
    }

    public void removeProduto(String codProd){

        /*
        //---> feito desta forma pode dar erro de excepção!!!

        for(Linha_Encomenda enc : this.linhas_enco){
            if(enc.getReferencia().equals(codProd)){
                this.linhas_enco.remove(enc);
            }
        }
        */

        // assim já não dá
        Iterator i = this.linhas_enco.iterator();
        while(i.hasNext()){
            Linha_Encomenda le = (Linha_Encomenda) i.next();
            if(Objects.equals(le.getReferencia(), codProd)){
                i.remove();
            }
        }
    }

}
