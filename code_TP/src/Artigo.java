public abstract class Artigo {

    private static int codigo = -1;   // variável de classe comum a todas as instâncias de Artigo


    //---------------------------------- VARIAVEIS DE INSTANCIA ----------------------------------


    String alfanumerico; // codigo unico a cada artigo
    String estado;  // pode ser "novo" ou "usado"
    String descricao;
    String marca;
    double preco;
    double desconto;
    int previous_owner; // só é relevante se o estado for usado
    Transportadora transportadora;


    //---------------------------------- CONSTRUTORES ----------------------------------


    public Artigo(){
        this.alfanumerico = "ART-" + codigo++;
        this.estado = "";
        this.descricao = "";
        this.marca = "";
        this.preco = 0;
        this.desconto = 0;
        this.previous_owner = 0;
        this.transportadora = new Transportadora();
    }

    public Artigo(String estado, String descricao, String marca, double preco, double desconto, int previous_owner, Transportadora t){
        this.alfanumerico = "ART-" + codigo++;
        this.estado = estado;
        this.descricao = descricao;
        this.marca = marca;
        this.preco = preco;
        this.desconto = desconto;
        this.previous_owner = previous_owner;
        this.transportadora = t.clone();
    }

    public Artigo(Artigo artigo){
        this.alfanumerico = artigo.getAlfanumerico();
        this.estado = artigo.getEstado();
        this.descricao = artigo.getDescricao();
        this.marca = artigo.getMarca();
        this.preco = artigo.getPreco();
        this.desconto = artigo.getDesconto();
        this.previous_owner = artigo.getPreviousOwner();
        this.transportadora = artigo.getTransportadora();
    }


    //---------------------------------- GET'S E SET'S ----------------------------------


    public String getAlfanumerico(){
        return this.alfanumerico;
    }

    private String getEstado(){
        return this.estado;
    }

    private String getDescricao(){
        return this.descricao;
    }

    private String getMarca(){
        return this.marca;
    }

    private double getPreco(){
        return this.preco;
    }

    private double getDesconto(){
        return this.desconto;
    }

    private int getPreviousOwner(){
        return this.previous_owner;
    }

    private Transportadora getTransportadora(){
        return this.transportadora.clone();
    }

    private void setEstado(String estado){
        this.estado = estado;
    }

    private void setDescricao(String descricao){
        this.descricao =  descricao;
    }

    private void setMarca(String marca){
        this.marca = marca;
    }

    private void setPreco(double preco){
        this.preco = preco;
    }

    private void setDesconto(double desconto){
        this.desconto = desconto;
    }

    private void setPreviousOwner(int previous_owner){
        this.previous_owner = previous_owner;
    }

    private void setTransportadora(Transportadora t){
        this.transportadora = t.clone();
    }


    //---------------------------------- CLONE / EQUALS ----------------------------------


    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Artigo le = (Artigo) o;
        return (this.alfanumerico == le.getAlfanumerico() && this.estado == le.getEstado() && this.descricao == le.getDescricao() &&
                this.marca == le.getMarca() && this.preco == le.getPreco() && this.desconto == le.getDesconto() &&
                this.previous_owner == le.getPreviousOwner() && this.transportadora.equals(le.getTransportadora()));
    }

    public abstract Artigo clone();

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("\t---> Codigo: ").append(this.alfanumerico).append("\n");
        sb.append("\t---> Estado: ").append(this.estado).append("\n");
        sb.append("\t---> Descrição: ").append(this.descricao).append("\n");
        sb.append("\t---> Marca: ").append(this.marca).append("\n");
        sb.append("\t---> Preço: ").append(this.preco).append("\n");
        sb.append("\t---> Desconto: ").append(this.desconto).append("\n");
        sb.append("\t---> Quantos donos já teve: ").append(this.previous_owner).append("\n");
        sb.append("\t---> Transportadora: ").append(this.transportadora.toString()).append("\n");

        String res = sb.toString();
        return res;
    }


    //---------------------------------- OUTROS METODOS ----------------------------------

    public abstract double precoFinalArtigo();
}
