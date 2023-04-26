import java.io.Serializable;
import java.time.LocalDate;


public class Fatura implements Serializable{
    
    private int faturaId;
    private LocalDate faturaData;
    private Encomenda encomenda;
    private double lucro;  // vai depender de para quem é a fatura ||| Fatura para comprador , Fatura para Vendedor ou Fatura para Shipping (?)
    private double total; 
    

    public Fatura(int faturaId, LocalDate faturaData, Encomenda encomenda, double lucro, double total) {
        this.faturaId = faturaId;
        this.faturaData = faturaData;
        this.encomenda = encomenda;
        this.lucro = lucro;
        this.total = total;
    }


    public int getFaturaId() {
        return this.faturaId;
    }


    public void setFaturaId(int FaturaId) {
        this.faturaId = faturaId;
    }


    public LocalDate getFaturaData() {
        return this.faturaData;
    }


    public void setFaturaData(LocalDate faturaData) {
        this.faturaData = faturaData;
    }


    public double getTotal() {
        return total;
    }


    public void setTotal(double total) {
        this.total = total;
    }


    public double getLucro() {
        return this.lucro;
    }


    public void setLucro(double lucro) {
        this.lucro = lucro;
    }


    public Encomenda getEnc() {
        return encomenda;
    }


    public void setEnc(Encomenda enc) {
        this.encomenda = enc;
    }


    @Override
    public String toString() {
        return "Invoice [ID = " + faturaId + ", Data de Emissão = " + faturaData + ", Encomenda = " + encomenda + ", Lucro = "
                + lucro + ", Valor Total = " + total + "]";
    }
    
    
    


}
