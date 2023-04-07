import java.util.ArrayList;
import java.util.List;

public class Utilizador {
    // ha qualquer cena aqui sobre o codigo mas nao percebi, é o ID de um utilizador?
    private String email;
    private String nome;
    private String morada;
    private String numFiscal;
    private List<Artigo> artigosParaVenda;
    private List<Artigo> artigosComprados;
    // falta me aqui uma cena para anotar as vendas feitas mas nao sei como fazer ainda (Array List?)

    // --------------------- CONSTRUTORES 

    public Utilizador() {
        this.email = "";
        this.nome = "";
        this.morada = "";
        this.numFiscal = "";
        this.artigosParaVenda = new ArrayList<>();
        this.artigosComprados = new ArrayList<>();
    }

    public Utilizador(String email, String nome, String morada, String numFiscal, List<Artigo> artigosParaVenda, List<Artigo> artigosComprados) {
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.numFiscal = numFiscal;
        setArtigosParaVenda(artigosParaVenda);
        setArtigosComprados(artigosComprados);
    }

    public Utilizador(Utilizador u) {
        this.email = u.getEmail();
        this.nome = u.getNome();
        this.morada = u.getMorada();
        this.numFiscal = u.getNumFiscal();
        this.artigosParaVenda = u.getArtigosParaVenda();
        this.artigosComprados = u.getArtigosComprados();
    }

    // --------------------- GETTERS & SETTERS

    public String getEmail() {
        return this.email;
    }

    public String getNome() {
        return this.nome;
    }

    public String getMorada() {
        return this.morada;
    }

    public String getNumFiscal() {
        return this.numFiscal;
    }
    
    public ArrayList<Artigo> getArtigosParaVenda() {
        ArrayList<Artigo> resultado = new ArrayList<>();
        for(Artigo a : this.artigosParaVenda) {
            resultado.add(a);
        }
        return resultado;
    }

    public ArrayList<Artigo> getArtigosComprados() {
        ArrayList<Artigo> resultado = new ArrayList<>();
        for(Artigo a : this.artigosComprados) {
            resultado.add(a);
        }
        return resultado;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumFiscal(String numFiscal) {
        this.numFiscal = numFiscal;
    }

    public void setArtigosParaVenda(List<Artigo> artigosParaVenda2) {
        this.artigosParaVenda = new ArrayList<>();
        for(Artigo a : this.artigosParaVenda) {
            this.artigosParaVenda.add(a);
        }
    }

    public void setArtigosComprados(List<Artigo> artigosComprados2) {
        this.artigosComprados = new ArrayList<>();
        for(Artigo a : this.artigosComprados) {
            this.artigosComprados.add(a);
        }
    }

    // --------------------- CLONE & EQUALS ---------------------

    /* 

    public String toString() {
        ;
    }

    */ 
}
