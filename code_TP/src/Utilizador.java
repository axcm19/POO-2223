import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Utilizador {

    // --------------------- VARIAVEIS DE INSTANCIA ---------------------

    private static int codigo_sequencia = 0;   // variável de classe comum a todas as instâncias de Utilizador

    private int codigo; //fornecido pelo sistma
    private String email;
    private String password;
    private String nome;
    private String morada;
    private String numFiscal;
    private List<Artigo> artigosParaVenda;
    private List<Artigo> artigosComprados; // não deverá ser os artigos todos que possui? tipo inventário geral?
    private List<Artigo> artigosVendidos;

    // --------------------- CONSTRUTORES ---------------------

    public Utilizador() {
        this.codigo = codigo_sequencia++;;
        this.email = "";
        this.password = "";
        this.nome = "";
        this.morada = "";
        this.numFiscal = "";
        this.artigosParaVenda = new ArrayList<>();
        this.artigosComprados = new ArrayList<>();
        this.artigosVendidos = new ArrayList<>();
    }

    public Utilizador(String email, String password, String nome, String morada, String numFiscal, List<Artigo> artigosVenda, List<Artigo> artigosComprado, List<Artigo> artigosVendido) {
        this.codigo = codigo_sequencia++;;
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.morada = morada;
        this.numFiscal = numFiscal;
        for(Artigo a : artigosVenda) {
            this.artigosParaVenda.add(a.clone());
        }
        
        for(Artigo a2 : artigosComprado) {
            this.artigosComprados.add(a2.clone());
        }

        for(Artigo a3 : artigosVendido) {
            this.artigosVendidos.add(a3.clone());
        }
    }

    public Utilizador(Utilizador u) {
        this.codigo = u.getCodigo();
        this.email = u.getEmail();
        this.password = u.getPassword();
        this.nome = u.getNome();
        this.morada = u.getMorada();
        this.numFiscal = u.getNumFiscal();
        this.artigosParaVenda = u.getArtigosParaVenda();
        this.artigosComprados = u.getArtigosComprados();
        this.artigosVendidos = u.getArtigosVendidos();
        for(Artigo a : u.artigosParaVenda) {
            this.artigosParaVenda.add(a.clone());
        }
        
        for(Artigo a2 : u.artigosComprados){
            this.artigosComprados.add(a2.clone());
        }

        for(Artigo a3 : u.artigosVendidos) {
            this.artigosVendidos.add(a3.clone());
        }
    }

    // --------------------- GETTERS & SETTERS ---------------------

    public int getCodigo(){
        return this.codigo;
    }

    public String getEmail() {
        return this.email;
    }

    private String getPassword() {
        return this.password;
    }

    private String getNome() {
        return this.nome;
    }

    public String getMorada() {
        return this.morada;
    }

    private String getNumFiscal() {
        return this.numFiscal;
    }
    
    public ArrayList<Artigo> getArtigosParaVenda(){
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

    private ArrayList<Artigo> getArtigosVendidos(){
        ArrayList<Artigo> res = new ArrayList<>();
        for(Artigo art3 : this.artigosVendidos) {
            res.add(art3.clone());
        }

        return res;
    }

    private void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    private void setNumFiscal(String numFiscal) {
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

    private void setArtigosVendidos(ArrayList<Artigo> artigosVendidos2){
        this.artigosVendidos.clear();

        for(Artigo art : artigosVendidos2){
            this.artigosVendidos.add(art.clone());
        }
    }

    // --------------------- CLONE & EQUALS ---------------------

    public Utilizador clone() {
        return new Utilizador(this);
    }
    
    // ainda vou alterar isto tudo porque nao queria muito ter 3 ciclos 

    public String toString(){
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.artigosParaVenda.size(); i++) {
            sb.append(this.artigosParaVenda.get(i));
            if (i < this.artigosParaVenda.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        for (int j = 0; j < this.artigosComprados.size(); j++) {
            sb2.append(this.artigosComprados.get(j));
            if (j < this.artigosComprados.size() - 1) {
                sb2.append(", ");
            }
        }
        sb2.append("]");
        for (int k = 0; k < this.artigosVendidos.size(); k++) {
            sb3.append(this.artigosComprados.get(k));
            if (k < this.artigosVendidos.size() - 1) {
                sb3.append(", ");
            }
        }
        sb3.append("]");
        return "Codigo do Utilizador: " + this.codigo +
                "\nEmail: " + this.email +
                "\nNome do Utilizador: " + this.nome +
                "\nMorada: " + this.morada +
                "\nNumero Fiscal: " + this.numFiscal +
                "\nArtigos para Venda: " + sb +
                "\nArtigos Comprados: " + sb2 +
                "\nArtigos Vendidos: " + sb3; 
    }

    public boolean equals(Object o){
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Utilizador u = (Utilizador) o;
        return (this.codigo == u.getCodigo() && this.email == u.getEmail() && this.password == u.getPassword() && this.nome == u.getNome() && this.morada.equals(u.getMorada()) &&
                this.numFiscal == u.getNumFiscal() && this.artigosParaVenda.equals(u.getArtigosParaVenda()) && 
                this.artigosComprados.equals(u.getArtigosComprados()) && this.artigosVendidos.equals(u.getArtigosVendidos()));
    }
    
    // --------------------- OUTROS METODOS ---------------------

    public boolean comparaPassword(String pass){
        return this.password.equals(pass);
    }

    public Artigo buscaArtigo(String alfaNumerico){
        Iterator i = this.artigosParaVenda.iterator();
        while(i.hasNext()){
            Artigo le = (Artigo) i.next();
            if(Objects.equals(le.getAlfanumerico(), alfaNumerico)){
                return le;
            }
        }
        return null;
    }

    public void removeArtigo(String alfaNumerico){

        // assim já não dá
        Iterator i = this.artigosParaVenda.iterator();
        while(i.hasNext()){
            Artigo le = (Artigo) i.next();
            if(Objects.equals(le.getAlfanumerico(), alfaNumerico)){
                i.remove();
            }
        }
    }
}
