import java.io.Serializable;

public class Mala extends Artigo implements Serializable {


    //---------------------------------- VARIAVEIS DE INSTANCIA ----------------------------------

    // dimensoes
    public double altura;
    public double largura;
    public double profundidade;

    public String material;
    public String anoColecao; // o ano para ser considerado novo é 2023


    //---------------------------------- CONSTRUTORES ----------------------------------


    public Mala() {
        super();
        this.altura = 0;
        this.largura = 0;
        this.profundidade = 0;
        this.material = "";
        this.anoColecao = "";
    }

    public Mala(String estado, String descricao, String marca, double preco, double desconto, int previous_owner, Transportadora t, double altura, double largura, double profundidade, String material, String anoColecao) {
        super(estado, descricao, marca, preco, desconto, previous_owner, t);
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
        this.material = material;
        this.anoColecao = anoColecao;
    }

    public Mala(Mala mala){
        super(mala);
        this.altura = mala.getAltura();
        this.largura = mala.getLargura();
        this.profundidade = mala.getProfundidade();
        this.material = mala.getMaterial();
        this.anoColecao = mala.getAnoColecao();
    }


    //---------------------------------- GET'S E SET'S ----------------------------------


    private double getAltura(){
        return this.altura;
    }

    private double getLargura(){
        return this.largura;
    }

    private double getProfundidade(){
        return this.profundidade;
    }

    private String getMaterial(){
        return this.material;
    }

    private String getAnoColecao(){
        return this.anoColecao;
    }

    private void setAltura(double altura){
        this.altura = altura;
    }

    private void setLargura(double largura){
        this.largura = largura;
    }

    private void setProfundidade(double profundidade){
        this.profundidade = profundidade;
    }

    private void setMaterial(String material){
        this.material = material;
    }

    private void setAnoColecao(String anoColecao){
        this.anoColecao = anoColecao;
    }


    //---------------------------------- CLONE / EQUALS ----------------------------------


    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Mala le = (Mala) o;
        return (super.equals(o) && this.altura == le.getAltura() && this.largura == le.getLargura() && this.profundidade == le.getProfundidade() &&
                this.material == le.getMaterial() && this.anoColecao == le.getAnoColecao());
    }

    public Mala clone(){
        return new Mala(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("ARTIGO (Mala): ");

        sb.append("Codigo: ").append(this.alfanumerico);
        sb.append(" | Estado: ").append(this.estado);
        sb.append(" | Descrição: ").append(this.descricao);
        sb.append(" | Marca: ").append(this.marca);
        sb.append(" | Preço: ").append(this.preco);
        sb.append(" | Desconto: ").append(this.desconto);
        sb.append(" | Quantos donos já teve: ").append(this.previous_owner);

        sb.append(" | Dimensão: ").append(this.altura).append("x").append(this.largura).append("x").append(this.profundidade);
        sb.append(" | Material: ").append(this.material);
        sb.append(" | Ano de coleção: ").append(this.anoColecao).append(" |\n");
        //sb.append("\t---> Transportadora: ").append(this.transportadora.toString()).append("\n"); --> em principio o utilizador não precisa de saber quem faz o transporte

        String res = sb.toString();
        return res;
    }




    //---------------------------------- OUTROS METODOS ----------------------------------

    private double calculaDescontoMala(double altura, double largura, double profundidade) {
        // Calcula o volume da mala
        double volume = altura * largura * profundidade;

        // Calcula o desconto proporcionalmente inverso com base no volume
        double desconto = 100.0 / volume; // Valor inversamente proporcional ao volume
        return desconto;
    }

    public double precoFinalArtigo() {
        double preco_final = 0;
        if(this.estado.equals("novo") && this.previous_owner <= 0) {
            preco_final = this.preco + this.getTransportadora().calculaValorExpedicao();
        }
        if(this.estado.equals("usado") && this.previous_owner > 0) {
            double desconto = calculaDescontoMala(this.getAltura(), this.getLargura(), this.getProfundidade());
            preco_final = this.preco - (this.preco / this.previous_owner * desconto) + this.getTransportadora().calculaValorExpedicao();
        }
        return preco_final;
    }

}
