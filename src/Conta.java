import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
    protected static final int AGENCIA_PADRAO = 1;
    private int agencia;
    private int numero;
    private double saldo;
    private static int sequencial = 1;
    private Cliente cliente;
    private List<Operacao> historicoOperacoes;
    private final static String OPERACAO_SAQUE = "saque";
    private final static String OPERACAO_DEPOSITO = "deposito";
    private final static String OPERACAO_TRANSFERENCIA = "transferência";

    public Conta(Cliente cliente) {
        this.historicoOperacoes = new ArrayList<>();
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = Conta.sequencial++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor, boolean inserirNoHistoricoOperacoes) {
        this.saldo -= valor;
        if (inserirNoHistoricoOperacoes) {
            this.inserirOperacao(Conta.OPERACAO_SAQUE, valor);
        }
    }

    @Override
    public void depositar(double valor, boolean inserirNoHistoricoOperacoes) {
        this.saldo += valor;

        if (inserirNoHistoricoOperacoes) {
            this.inserirOperacao(Conta.OPERACAO_DEPOSITO, valor);
        }
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor, false);
        contaDestino.depositar(valor, false);
        this.inserirOperacao(Conta.OPERACAO_TRANSFERENCIA, valor);
    }

    public void imprimirInformacoesComuns() {
        System.out.println("Titular: " + this.cliente.getNome());
        System.out.println("Agência: " + this.getAgencia());
        System.out.println("Número: " + this.getNumero());
        System.out.println("Saldo: " + this.getSaldo());
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

    @Override
    public void inserirOperacao(String nomeOperacao, double valorOperacao) {
        Operacao operacao = new Operacao(nomeOperacao, valorOperacao);
        this.historicoOperacoes.add(operacao);
    }

    @Override
    public void imprimirHistoricoOperacoes() {
        System.out.println(this.historicoOperacoes);
    }
}
