public class Artigo {

    private static int codigo = -1;   // variável de classe comum a todas as instâncias de Artigo

    //----------------- Variaveis de Instancia -----------------

    private String alfanumerico; // codigo unico a cada artigo
    private String estado;  // pode ser "novo" ou "usado"
    private String descricao;
    private String marca;
    private double preco;
    private double desconto;
    private int previous_owner; // só é relevante se o estado for usado

    //----------------- Construtores -----------------

    public Artigo(){
        this.alfanumerico = "ART-" + codigo++;
        this.estado = "";
        this.descricao = "";
        this.marca = "";
    }


}
