/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zeus.classes;

/**
 *
 * @author Adriel Rosa
 */
public class Professor extends Pessoa {
    private String materiaLecionada;
    private double salario;

    // Construtor

    public Professor() {
    }

    
    public Professor(String materiaLecionada, double salario, int id, String usuario, String senha, String nome, int idade, String data_nascimento, String cpf, String email, String endereco, String telefone, int nivel_de_acesso, int status_da_conta, String pgt_rec_senha, String resp_rec_senha) {
        super(id, usuario, senha, nome, idade, data_nascimento, cpf, email, endereco, telefone, nivel_de_acesso, status_da_conta, pgt_rec_senha, resp_rec_senha);
        this.materiaLecionada = materiaLecionada;
        this.salario = salario;
    }
    

    // Getters e Setters
    public String getMateriaLecionada() {
        return materiaLecionada;
    }

    public void setMateriaLecionada(String materiaLecionada) {
        this.materiaLecionada = materiaLecionada;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
}
