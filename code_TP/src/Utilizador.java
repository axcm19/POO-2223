import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Objects;

public class Utilizador {

    // --------------------- VARIAVEIS DE INSTANCIA ---------------------

    // ha qualquer cena aqui sobre o codigo mas nao percebi, é o ID de um utilizador?
    private String email;
    private String nome;
    private String morada;
    private String numFiscal;
    private List<Artigo> artigosParaVenda;
    private List<Artigo> artigosComprados;
    // falta me aqui uma cena para anotar as vendas feitas mas nao sei como fazer ainda (Array List?)

    // --------------------- CONSTRUTORES ---------------------

    public Utilizador() {
        this.email = "";
        this.nome = "";
        this.morada = "";
        this.numFiscal = "";
        this.artigosParaVenda = new ArrayList<>();
        this.artigosComprados = new ArrayList<>();
    }

    public Utilizador(String email, String nome, String morada, String numFiscal, List<Artigo> artigosVenda, List<Artigo> artigosComprado) {
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.numFiscal = numFiscal;
        for(Artigo a : artigosVenda) {
            this.artigosParaVenda.add(a.clone());
        }
        
        for(Artigo a2 : artigosComprado) {
            this.artigosComprados.add(a2.clone());
        }
    }

    public Utilizador(Utilizador u) {
        this.email = u.getEmail();
        this.nome = u.getNome();
        this.morada = u.getMorada();
        this.numFiscal = u.getNumFiscal();
        this.artigosParaVenda = u.getArtigosParaVenda();
        this.artigosComprados = u.getArtigosComprados();
        for(Artigo a : u.artigosParaVenda) {
            this.artigosParaVenda.add(a.clone());
        }
        
        for(Artigo a2 : u.artigosComprados){
            this.artigosComprados.add(a2.clone());
        }
    }

    // --------------------- GETTERS & SETTERS ---------------------

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
    
    private ArrayList<Artigo> getArtigosParaVenda(){
        ArrayList<Artigo> res = new ArrayList<>();
        for(Artigo art : this.artigosParaVenda){
            res.add(art.clone());
        }

        return res;
    }

    private ArrayList<Artigo> getArtigosComprados(){
        ArrayList<Artigo> res = new ArrayList<>();
        for(Artigo art2 : this.artigosComprados){
            res.add(art2.clone());
        }

        return res;
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

    private void setArtigosParaVenda(ArrayList<Artigo> artigosParaVenda2){
        this.artigosParaVenda.clear();

        for(Artigo art : artigosParaVenda2){
            this.artigosParaVenda.add(art.clone());
        }
    }

    private void setArtigosComprados(ArrayList<Artigo> artigosComprados2){
        this.artigosComprados.clear();

        for(Artigo art : artigosComprados2){
            this.artigosComprados.add(art.clone());
        }
    }

    // --------------------- CLONE & EQUALS ---------------------

    public Utilizador clone() {
        return new Utilizador(this);
    }

    public boolean equals(Object o){
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Utilizador u = (Utilizador) o;
        return (this.email == u.getEmail() &&
                this.nome == u.getNome() &&
                this.morada.equals(u.getMorada()) &&
                this.numFiscal == u.getNumFiscal() &&
                this.artigosParaVenda.equals(u.getArtigosParaVenda()) &&
                this.artigosComprados.equals(u.getArtigosComprados()));
    }
    
    // --------------------- OUTROS METODOS ---------------------
}
