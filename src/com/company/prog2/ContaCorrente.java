package com.company.prog2;

public class ContaCorrente extends ContaBancaria {
    protected double TaxasMensais = 1.2;

    public ContaCorrente(Pessoa Titular, Banco Banco, int NroConta, double Saldo, String senha) {
        super(Titular, Banco, NroConta, Saldo, senha);
    }

    public void Info() {
        System.out.println("=== Informações da conta: ");
        System.out.println("Banco: " + this.Banco.getNome());
        System.out.println("Número da conta: " + this.NroConta);
        System.out.println("Nome do cliente: " + this.Titular.nome + " " + this.Titular.sobrenome);
        System.out.println("Saldo: " + this.Saldo);
        System.out.println("Taxas mensais: " + this.TaxasMensais);
    }

    public void NovoMes() {
        this.Saldo -= TaxasMensais;
        System.out.println("Taxas cobradas: R$ " + this.TaxasMensais);
        System.out.println("Seu saldo atual é de: R$ " + this.Saldo);
    }
}
