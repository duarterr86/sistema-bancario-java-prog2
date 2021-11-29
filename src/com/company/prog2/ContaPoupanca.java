package com.company.prog2;

public class ContaPoupanca extends ContaBancaria {
    private double rendimento = 0.5;
    private int SaquesMensais = 3;

    public ContaPoupanca(Pessoa Titular, Banco Banco, int NroConta, double Saldo, String senha) {
        super(Titular, Banco, NroConta, Saldo, senha);
    }


    public void Info() {
        System.out.println("=== Informações da conta: ");
        System.out.println("Banco: " + this.Banco.getNome());
        System.out.println("Número da conta: " + this.NroConta);
        System.out.println("Nome do cliente: " + this.Titular.nome + " " + this.Titular.sobrenome);
        System.out.println("Saldo: " + this.Saldo);
        System.out.println("Rendimento mensal: " + this.rendimento + "%");
        System.out.println("Saques restantes no mês: " + this.SaquesMensais);
    }

    public void NovoMes() {
        double RendimentoContaMes = this.Saldo * (this.rendimento / 100);
        this.Saldo += RendimentoContaMes;
        SaquesMensais = 3;
        System.out.println("=== Rendimentos da poupança no mes: ");
        System.out.println("Rendimentos: R$ " + RendimentoContaMes);
        System.out.println("Saldo atual: R$ " + this.Saldo);
        System.out.println("Saques restantes no mês: " + SaquesMensais);
    }

    public void Saque() {
        if (SaquesMensais == 0) {
            System.out.println("Limite de saques no mês excedido. Operação cancelada!");
        } else {
            System.out.println("Digite o valor que deseja sacar: ");
            double ValorSaque = teclado.nextDouble();
            if (ValorSaque <= this.Saldo) {
                this.Saldo -= ValorSaque;
                SaquesMensais--;
                System.out.println("Saque de R$ " + ValorSaque + " efetuado com sucesso!");
                System.out.println("Saldo atualizado: R$ " + this.Saldo);
                System.out.println("Saques restantes no mês: " + SaquesMensais);
            } else {
                System.out.println("Saldo insuficiente. Operação cancelada!");
            }
        }
    }

    public void Saque(double ValorSaque) {
        if (SaquesMensais == 0) {
            System.out.println("Limite de saques no mês excedido. Operação cancelada!");
        } else {
            if (ValorSaque <= this.Saldo) {
                this.Saldo -= ValorSaque;
                SaquesMensais--;
                System.out.println("Saque de R$ " + ValorSaque + " efetuado com sucesso!");
                System.out.println("Saldo atualizado: R$ " + this.Saldo);
                System.out.println("Saques restantes no mês: " + SaquesMensais);
            } else {
                System.out.println("Saldo insuficiente. Operação cancelada!");
            }
        }
    }


}
