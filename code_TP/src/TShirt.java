import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

public class TShirt extends Artigo{

    //---------------------------------- VARIAVEIS DE INSTANCIA ----------------------------------

    // dimensoes
    public String tamanho; // pode ser (S,M,L,XL)
    public String padrao; // pode ser (liso, riscas, palmeiras)


    //---------------------------------- CONSTRUTORES ----------------------------------


    public TShirt() {
        super();
        this.tamanho = "";
        this.padrao = "";
    }

    public TShirt(String estado, String descricao, String marca, double preco, double desconto, int previous_owner, String tamanho, String padrao) {
        super(estado, descricao, marca, preco, desconto, previous_owner);
        this.tamanho = tamanho;
        this.padrao = padrao;
    }

    public TShirt(TShirt tShirt){
        super(tShirt);
        this.tamanho = tShirt.getTamanho();
        this.padrao = tShirt.getPadrao();
    }


    //---------------------------------- GET'S E SET'S ----------------------------------


    private String getTamanho(){
        return this.tamanho;
    }

    private String getPadrao(){
        return this.padrao;
    }

    private void setTamanho(String tamanho){
        this.tamanho = tamanho;
    }

    private void setPadrao(String padrao){
        this.padrao = padrao;
    }


    //---------------------------------- CLONE / EQUALS ----------------------------------


    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        TShirt le = (TShirt) o;
        return (super.equals(o) && this.tamanho == le.getTamanho() && this.padrao == le.getPadrao());
    }

    public TShirt clone(){
        return new TShirt(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("ARTIGO (T-Shirt): ").append("\n");
        sb.append(super.toString());

        String res = sb.toString();
        return res;
    }


    //---------------------------------- OUTROS METODOS ----------------------------------

}
