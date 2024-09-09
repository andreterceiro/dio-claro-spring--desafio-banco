class Operacao {
    private String nome;
    private double valor;

    public Operacao(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }
    
    public String getNome() {
        return this.nome;
    }

    public double getValor() {
        return this.valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String toString() {
        return "Operação: [nome='" + this.getNome() + "', valor='" + this.getValor() + "']";
    }
}