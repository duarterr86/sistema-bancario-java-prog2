package com.company.prog2;

import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
    private String Nome;
    private String CNPJ;
    private int NroBanco;
    ArrayList<ContaBancaria> ContasBancarias = new ArrayList<ContaBancaria>();
    Scanner teclado = new Scanner(System.in);

    public String getNome() {
        return Nome;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public int getNroBanco() {
        return NroBanco;
    }

    public int NroBanco() {
        return NroBanco;
    }

    public Banco(String Nome, String CNPJ, int NroBanco) {
        this.Nome = Nome;
        this.CNPJ = CNPJ;
        this.NroBanco = NroBanco;
    }

    public void InfoBanco() {
        System.out.println("=== Informações do Banco: ");
        System.out.println("Nome: " + this.Nome);
        System.out.println("CNPJ: " + this.CNPJ);
        System.out.println("Número do Banco: " + this.NroBanco);
    }

    public void CriarConta() {
        boolean opcaoValida = false;
        while (!opcaoValida) {
            System.out.println("Entrando no cadastro de contas! ");
            System.out.println("Escolha uma das opções: ");
            System.out.println("1 - Criar conta corrente");
            System.out.println("2 - Criar conta poupança");
            System.out.println("0 - Voltar ao menu anterior");

            int menu = teclado.nextInt();
            switch (menu) {
                case 1: {
                    ContaCorrente conta;
                    Pessoa titular;
                    Banco banco;
                    int nroconta, idade;
                    double saldo;
                    String senha, nome, sobrenome, cpf;

                    System.out.println("Digite o nome do cliente: ");
                    teclado.nextLine();
                    nome = teclado.nextLine();
                    System.out.println("Digite o sobrenome do cliente: ");
                    sobrenome = teclado.nextLine();
                    System.out.println("Digite a idade do cliente: ");
                    idade = teclado.nextInt();
                    System.out.println("Digite o CPF do cliente: ");
                    teclado.nextLine();
                    cpf = teclado.nextLine();
                    titular = new Pessoa(nome, sobrenome, idade, cpf);

                    banco = new Banco(this.Nome, this.CNPJ, this.getNroBanco());

                    System.out.println("Digite o Número da conta: ");
                    nroconta = teclado.nextInt();
                    System.out.println("Digite o saldo da conta: ");
                    saldo = teclado.nextDouble();
                    System.out.println("Digite a senha da conta: ");
                    teclado.nextLine();
                    senha = teclado.nextLine();

                    conta = new ContaCorrente(titular, banco, nroconta, saldo, senha);
                    ContasBancarias.add(conta);
                    System.out.println("Conta cadastrada com sucesso!");
                    System.out.println(" ");
                    conta.Info();
                    continue;
                    //pessoa.ContasBancarias.add(conta_nova);
                    //this.ContasBancarias.add(conta_nova);
                }
                case 2: {
                    System.out.println("Entrando no cadastro de conta poupança...");
                    ContaPoupanca conta;
                    Pessoa titular;
                    Banco banco;
                    int nroconta, idade;
                    double saldo;
                    String senha, nome, sobrenome, cpf;

                    System.out.println("Digite o nome do cliente: ");
                    teclado.nextLine();
                    nome = teclado.nextLine();
                    System.out.println("Digite o sobrenome do cliente: ");
                    sobrenome = teclado.nextLine();
                    System.out.println("Digite a idade do cliente: ");
                    idade = teclado.nextInt();
                    System.out.println("Digite o CPF do cliente: ");
                    teclado.nextLine();
                    cpf = teclado.nextLine();
                    titular = new Pessoa(nome, sobrenome, idade, cpf);

                    banco = new Banco(this.Nome, this.CNPJ, this.getNroBanco());

                    System.out.println("Digite o Número da conta: ");
                    nroconta = teclado.nextInt();
                    System.out.println("Digite o saldo da conta: ");
                    saldo = teclado.nextDouble();
                    System.out.println("Digite a senha da conta: ");
                    teclado.nextLine();
                    senha = teclado.nextLine();

                    conta = new ContaPoupanca(titular, banco, nroconta, saldo, senha);
                    ContasBancarias.add(conta);
                    System.out.println("Conta cadastrada com sucesso!");
                    System.out.println(" ");
                    conta.Info();
                    break;
                }
                case 0: {
                    opcaoValida = true;
                    System.out.println("Voltando ao menu anterior");
                    continue;
                }
                default: {
                    opcaoValida = false;
                    System.out.println("Opção inválida. Tente novamente");
                    continue;
                }
            }
        }
    }

    public void InfoContas() {
        if (ContasBancarias.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada!");
        } else {
            int i;
            for (i = 0; i < ContasBancarias.size(); i++) {
                System.out.println(" ");
                System.out.println("Número da conta: " + ContasBancarias.get(i).NroConta);
                System.out.println("Nome do cliente: " + ContasBancarias.get(i).Titular.nome +
                        " " + ContasBancarias.get(i).Titular.sobrenome);
                System.out.println("Saldo: " + ContasBancarias.get(i).Saldo);
                System.out.println(" ");
            }
        }
    }

    public void FecharConta() {
        if (ContasBancarias.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada!");
        } else {
            System.out.println("Digite o número da conta: ");
            int nrocontafechamento = teclado.nextInt();
            int i;
            for (i = 0; i < ContasBancarias.size(); i++) {
                if (ContasBancarias.get(i).NroConta == nrocontafechamento) {
                    ContasBancarias.remove(i);
                    System.out.println("Conta encerrada com sucesso!");
                } else {
                    System.out.println("Conta não encontrada!");
                }
            }
        }
    }
}
