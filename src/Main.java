public class Main {
    public static void main(String[] args) {
        Cliente andre = new Cliente();
        andre.setNome("André");

        Cliente papai = new Cliente();
        papai.setNome("Papai");

        Conta cc = new ContaCorrente(andre);
        Conta cp = new ContaPoupanca(papai);
        cc.depositar(100);
        cc.transferir(10, cp);

        cc.imprimirExtrato();
        cp.imprimirExtrato();
    }
}
