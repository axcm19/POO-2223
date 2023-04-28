package SubEncomendas;

import java.util.Comparator;

public class ComparadorEncomenda implements Comparator<Encomenda> {

    public int compare(Encomenda e1, Encomenda e2){
        return e1.compareTo(e2);
    }

}
