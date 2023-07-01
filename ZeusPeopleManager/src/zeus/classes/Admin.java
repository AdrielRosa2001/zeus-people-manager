/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zeus.classes;

public class Admin extends Pessoa{
    public Admin(){
        
    }
    public Admin(int id, String usuario, String senha, String nome, int idade, String data_nascimento, String cpf, String email, String endereco, String telefone, int nivel_de_acesso, int status_da_conta, String pgt_rec_senha, String resp_rec_senha){
        super(0, usuario, senha, nome, 0, data_nascimento, cpf, email, endereco, telefone, 0, 0, pgt_rec_senha, resp_rec_senha);
    }
}
