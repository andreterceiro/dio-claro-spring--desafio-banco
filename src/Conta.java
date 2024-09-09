public abstract class Conta implements IConta {
    protected static final int AGENCIA_PADRAO = 1;
    private int agencia;
    private int numero;
    private double saldo;
    private static int sequencial = 1;

    public Conta() {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = Conta.sequencial++;
    }

    @Override
    public void sacar(double valor) {
        this.saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return this.agencia;
    }

    public int getNumero() {
        return this.numero;
    }

    public double getSaldo() {
        return this.saldo;
    }    
}
