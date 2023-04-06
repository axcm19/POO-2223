import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GestorEncomendas {

    private Map<Integer, EncEficiente> encomendasMap;

    public GestorEncomendas(){
        this.encomendasMap = new HashMap<>();
    }

    public GestorEncomendas(Map<Integer, EncEficiente> novoMapEncomendas){

        for(Map.Entry<Integer, EncEficiente> entry : novoMapEncomendas.entrySet()){

            //limpar o map existente caso esteja preenchido
            if(this.encomendasMap != null){
                this.encomendasMap.clear();
            }

            int key = entry.getKey();
            EncEficiente enc = entry.getValue().clone();
            this.encomendasMap.put(key, enc);
        }
    }

    public GestorEncomendas(GestorEncomendas ge){

        Map<Integer, EncEficiente> buscaEncomendas = ge.getEncomendasMap();

        for(Map.Entry<Integer, EncEficiente> entry : buscaEncomendas.entrySet()){

            //limpar o map existente caso esteja preenchido
            if(this.encomendasMap != null){
                this.encomendasMap.clear();
            }

            int key = entry.getKey();
            EncEficiente enc = entry.getValue().clone();
            this.encomendasMap.put(key, enc);
        }

    }


    //--------------------- GET'S E SET'S ---------------------

    private Map<Integer, EncEficiente> getEncomendasMap(){
        Map<Integer, EncEficiente> buscaEncomendas = new HashMap<>();

        for(Map.Entry<Integer, EncEficiente> entry : this.encomendasMap.entrySet()){

            int key = entry.getKey();
            EncEficiente enc = entry.getValue().clone();
            buscaEncomendas.put(key, enc);
        }

        return  buscaEncomendas;
    }

    //--------------------- CLONE / EQUALS ---------------------

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        GestorEncomendas ge = (GestorEncomendas) o;
        return (this.encomendasMap == ge.getEncomendasMap());
    }

    public GestorEncomendas clone(){
        return new GestorEncomendas(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("GESTOR_ENCOMENDAS: ");
        sb.append("---> ").append(this.encomendasMap.toString()).append("\n");

        String res = sb.toString();
        return res;
    }

    //--------------------- OUTROS METODOS ---------------------

    public Set<Integer> todosCodigosEnc(){
        return this.encomendasMap.keySet();
    }

    void addEncomenda(EncEficiente enc){
        if(this.encomendasMap.containsValue(enc)){
            System.out.println("ERRO! Essa encomenda já existe!");
        }
        else{
            this.encomendasMap.put(enc.getNumeroEncomenda(), enc.clone());
        }
    }

    public EncEficiente getEncomenda(Integer codEnc){
        EncEficiente res = new EncEficiente();
        if(this.encomendasMap.containsKey(codEnc)){
            res = this.encomendasMap.get(codEnc).clone();
        }

        return res;
    }

    public void removeEncomenda(Integer codEnc){
        if(this.encomendasMap.containsKey(codEnc)){
            this.encomendasMap.remove(codEnc);
        }
        else {
            System.out.println("ERRO! Essa encomenda não existe no sistema!");
        }
    }

    public Integer encomendaComMaisProdutos(){
        int res = 0;
        int maior = 0;

        for(Map.Entry<Integer, EncEficiente> entry : this.encomendasMap.entrySet()){
            int produtos = entry.getValue().numeroTotalProdutos();

            if (produtos >= maior){
                maior = produtos;
                res = entry.getKey();
            }
        }

        return res;
    }

    public Set<Integer> encomendasComProduto(String codProd){
        Set<Integer> res = new HashSet<>();

        for(Map.Entry<Integer, EncEficiente> entry : this.encomendasMap.entrySet()){
            if(entry.getValue().existeProdutoEncomenda(codProd)){
                res.add(entry.getKey());
            }
        }

        return res;
    }

    public Set<Integer> encomendasAposData(LocalDate d){
        Set<Integer> res = new HashSet<>();

        for(Map.Entry<Integer, EncEficiente> entry : this.encomendasMap.entrySet()){
            LocalDate data = entry.getValue().getDataEncomenda();

            if(data.isAfter(d)){
                res.add(entry.getKey());
            }
        }

        return res;
    }

    public EncEficiente encomendaMaiorValor(){
        EncEficiente res = new EncEficiente();
        double valorMaior = 0;
        int keyResultado = 0;

        for(Map.Entry<Integer, EncEficiente> entry : this.encomendasMap.entrySet()){
            double valor = entry.getValue().calculaValorTotal();

            if(valor >= valorMaior) {
                valorMaior = valor;
                keyResultado = entry.getKey();
            }
        }
        res = this.encomendasMap.get(keyResultado).clone();

        return res;
    }



}
