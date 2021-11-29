package com.company.prog2;

import java.util.Scanner;

public abstract class ContaBancaria {
    Scanner teclado = new Scanner(System.in);

    protected Pessoa Titular;
    protected Banco Banco;
    protected int NroConta;
    protected double Saldo;
    protected String senha;

    public ContaBancaria(Pessoa Titular, Banco Banco, int NroConta, double Saldo, String senha) {
        this.Titular = Titular;
        this.Banco = Banco;
        this.NroConta = NroConta;
        this.Saldo = Saldo;
        this.senha = senha;
    }

    public void Saque(double ValorSacado) {
        boolean ConfirmaSenha = this.VerificaSenha();
        if (ConfirmaSenha) {
            if (this.Saldo > ValorSacado) {
                this.Saldo -= ValorSacado;
                System.out.println("Saque de R$ " + ValorSacado + " realizado com sucesso");
                System.out.println("Seu saldo atualizado é de: R$ " + this.Saldo);
            } else {
                System.out.println("Saldo insuficiente. Operação cancelada!");
            }
        } else {
            System.out.println("Senha incorreta. Operação cancelada!");
        }
    }

    public void Saque() {
        boolean ConfirmaSenha = this.VerificaSenha();
        if (ConfirmaSenha) {
            System.out.println("Digite o valor deseja sacar: ");
            double ValorSacado = teclado.nextDouble();
            if (this.Saldo > ValorSacado) {
                this.Saldo -= ValorSacado;
                System.out.println("Saque de R$ " + ValorSacado + " realizado com sucesso");
                System.out.println("Seu saldo atualizado é de: R$ " + this.Saldo);
            } else {
                System.out.println("Saldo insuficiente. Operação cancelada!");
            }
        } else {
            System.out.println("Senha incorreta. Operação cancelada!");
        }
    }

    public void Deposito(double ValorDeposito) {
        this.Saldo += ValorDeposito;
        System.out.println("Depósito de R$ " + ValorDeposito + " realizado com sucesso!");
        System.out.println("Seu saldo atualizado é de R$: " + this.Saldo);
    }

    public void Deposito() {
        System.out.println("Digite o valor que será depositado: ");
        double ValorDeposito = teclado.nextDouble();
        this.Saldo += ValorDeposito;
        System.out.println("Depósito de R$ " + ValorDeposito + " realizado com sucesso!");
        System.out.println("Seu saldo atualizado é de R$: " + this.Saldo);
    }

    public boolean VerificaSenha(String SenhaInformada) {
        if (this.senha.equals(SenhaInformada)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean VerificaSenha() {
        System.out.println("Digite a sua senha: ");
        String SenhaInformada = teclado.nextLine();
        if (this.senha.equals(SenhaInformada)) {
            return true;
        } else {
            return false;
        }
    }
}

