

public class Linha_Encomenda {

    private String referencia;
    private String descricao;
    private double preco;
    private int quantidade;
    private double imposto;
    private double desconto;

    public Linha_Encomenda(){
        //construtor vazio mete tudo a NULL
    }

    public Linha_Encomenda(String referencia, String descricao, double preco, int quantidade, double imposto, double desconto){
        this.referencia = referencia;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.imposto = imposto;
        this.desconto = desconto;
    }

    public Linha_Encomenda(Linha_Encomenda le){
        this.referencia = le.getReferencia();
        this.descricao = le.getDescricao();
        this.preco = le.getPreco();
        this.quantidade = le.getQuantidade();
        this.imposto = le.getImposto();
        this.desconto = le.getDesconto();
    }

    //--------------------- GET'S E SET'S ---------------------

    public String getReferencia(){
        return this.referencia;
    }

    private String getDescricao(){
        return this.descricao;
    }

    private double getPreco() {
        return this.preco;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    private double getImposto(){
        return this.imposto;
    }

    private double getDesconto(){
        return this.desconto;
    }

    private void setReferencia(String referencia){
        this.referencia = referencia;
    }

    private void setDescricao(String descricao){
        this.descricao = descricao;
    }

    private void getPreco(double preco) {
        this.preco = preco;
    }

    public void getQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    private void setImposto(double imposto){
        this.imposto = imposto;
    }

    private void setDesconto(double desconto){
        this.desconto = desconto;
    }

    //--------------------- CLONE / EQUALS ---------------------

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Linha_Encomenda le = (Linha_Encomenda) o;
        return (this.referencia == le.getReferencia() && this.descricao == le.getDescricao() && this.preco == le.getPreco() &&
                this.quantidade == le.getQuantidade() && this.imposto == le.getImposto() && this.desconto == le.getDesconto());
    }

    public Linha_Encomenda clone(){
        return new Linha_Encomenda(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("LINHA ENCOMENDA: ").append(this.referencia).append("\n");

        String res = sb.toString();
        return res;
    }

    //--------------------- OUTROS METODOS ---------------------

    public double calculaValorLinhaEnc(){
        double res = 0;

        double com_imposto = this.preco + (this.preco * this.imposto);
        double com_desconto = this.preco - (this.preco * this.desconto);

        res = (this.preco * this.quantidade) + com_imposto - com_desconto;
        return res;
    }


    public double calculaValorDesconto(){
        double res = this.preco - (this.preco * this.desconto);
        return res;
    }

}
