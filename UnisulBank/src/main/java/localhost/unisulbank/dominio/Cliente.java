/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package localhost.unisulbank.dominio;

/**
 *
 * @author Herik
 */
public class Cliente {
    private int conta;
    private String nome;
    private double saldo;
    
    public Cliente(int conta, String nome, double saldo) {
        this.conta = conta;
        this.nome = nome;
        this.saldo = saldo;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

   
}
