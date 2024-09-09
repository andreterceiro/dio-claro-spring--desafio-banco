public interface IConta {
    void sacar(double valor, boolean inserirNoHistoricoOperacoes);
    void depositar(double valor, boolean inserirNoHistoricoOperacoes);
    void transferir(double valor, IConta contaDestino);
    void imprimirExtrato();
    void inserirOperacao(String nomeOperacao, double valorOperacao);
    void imprimirHistoricoOperacoes();
}
