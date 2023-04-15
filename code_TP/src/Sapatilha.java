import java.io.Serializable;

public class Sapatilha extends Artigo implements Serializable {

    //---------------------------------- VARIAVEIS DE INSTANCIA ----------------------------------


    public int tamanho;
    public String comoAperta; // pode ser "atacadores" ou "atilhos"
    public String cor;
    public String anoColecao;   // o ano para ser considerado novo é 2023


    //---------------------------------- CONSTRUTORES ----------------------------------


    public Sapatilha() {
        super();
        this.tamanho = 0;
        this.comoAperta = "";
        this.cor = "";
        this.anoColecao = "";
    }

    public Sapatilha(String estado, String descricao, String marca, double preco, double desconto, int previous_owner, Transportadora t,int tamanho, String comoAperta, String cor, String anoColecao) {
        super(estado, descricao, marca, preco, desconto, previous_owner, t);
        this.tamanho = tamanho;
        this.comoAperta = comoAperta;
        this.cor = cor;
        this.anoColecao = anoColecao;
    }

    public Sapatilha(Sapatilha sapatilha){
        super(sapatilha);
        this.tamanho = sapatilha.getTamanho();
        this.comoAperta = sapatilha.getComoAperta();
        this.cor = sapatilha.getCor();;
        this.anoColecao = sapatilha.getAnoColecao();;
    }


    //---------------------------------- GET'S E SET'S ----------------------------------


    private int getTamanho(){
        return this.tamanho;
    }

    private String getComoAperta(){
        return this.comoAperta;
    }

    private String getCor(){
        return this.cor;
    }

    private String getAnoColecao(){
        return this.anoColecao;
    }

    private void setTamanho(int tamanho){
        this.tamanho = tamanho;
    }

    private void setComoAperta(String comoAperta){
        this.comoAperta = comoAperta;
    }

    private void setCor(String cor){
        this.cor = cor;
    }

    private void setAnoColecao(String anoColecao){
        this.anoColecao = anoColecao;
    }


    //---------------------------------- CLONE / EQUALS ----------------------------------


    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Sapatilha le = (Sapatilha) o;
        return (super.equals(o) && this.tamanho == le.getTamanho() && this.comoAperta == le.getComoAperta() && this.cor == le.getCor() && this.anoColecao == le.getAnoColecao());
    }

    public Sapatilha clone(){
        return new Sapatilha(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("ARTIGO (Sapatilha): ").append("\n");
        sb.append(super.toString());

        String res = sb.toString();
        return res;
    }


    //---------------------------------- OUTROS METODOS ----------------------------------

    public double precoFinalArtigo() {
        double preco_final = 0;

        if(this.estado.equals("novo") && this.previous_owner <= 0) {
            if(this.tamanho <= 45){
                preco_final = this.preco + this.getTransportadora().calculaValorExpedicao();
            }
            if(this.tamanho > 45) {
                preco_final = this.preco - (this.preco * this.desconto) + this.getTransportadora().calculaValorExpedicao();
            }
        }

        if(this.estado.equals("usado") && this.previous_owner > 0) {
            preco_final = this.preco - (this.preco / this.previous_owner * this.desconto) + this.getTransportadora().calculaValorExpedicao();
        }
        return preco_final;
    }

}


