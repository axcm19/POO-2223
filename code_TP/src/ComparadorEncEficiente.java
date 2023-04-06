import java.util.Comparator;

public class ComparadorEncEficiente implements Comparator<Encomenda> {

    public int compare(Encomenda e1, Encomenda e2){
        return e1.compareTo(e2);
    }

}
