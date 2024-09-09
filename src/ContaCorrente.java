public class ContaCorrente extends Conta {
    @Override
    public void imprimirExtrato() {
        System.out.println("========== Extrato da conta corrente ==========");
        super.imprimirInformacoesComuns();
    }
}
