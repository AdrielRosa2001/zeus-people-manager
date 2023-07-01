
package zeus.classes;

/**
 *
 * @author Adriel Rosa
 */
public class Aluno extends Pessoa{
    private String matricula;
    private double mensalidade;

    // Construtor
    
    public Aluno(){
        
    }
    
    public Aluno(String matricula, double mensalidade, int id, String usuario, String senha, String nome, int idade, String data_nascimento, String cpf, String email, String endereco, String telefone, int nivel_de_acesso, int status_da_conta, String pgt_rec_senha, String resp_rec_senha) {
        super(id, usuario, senha, nome, idade, data_nascimento, cpf, email, endereco, telefone, nivel_de_acesso, status_da_conta, pgt_rec_senha, resp_rec_senha);
        this.matricula = matricula;
        this.mensalidade = mensalidade;
    }
    

    // Getters e Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(double mensalidade) {
        this.mensalidade = mensalidade;
    }
}
