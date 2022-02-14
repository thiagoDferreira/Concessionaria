
public class Pagamento {
    private double taxa,valorParcela,precoTotal;

    public Pagamento() {
    }

    public Pagamento (double valorParcela, double taxa,double precoTotal) {
        this.precoTotal = precoTotal;
        this.valorParcela = valorParcela;
        this.taxa = taxa;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(double parcela) {
        this.valorParcela = parcela;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
}
