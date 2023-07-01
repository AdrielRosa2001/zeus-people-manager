
package zeus.classes;

/**
 *
 * @author Adriel Rosa
 */
public class Pessoa{
    
    private int id;
    private String usuario;
    private String senha;
    private String nome;
    private int idade;
    private String data_nascimento;
    private String cpf;
    private String email;
    private String endereco;
    private String telefone;
    private int nivel_de_acesso; // 1 nivel basico - 2 nivel avançado
    private int status_da_conta; // 1 ativa - 2 inativa - 3 desativada
    private String pgt_rec_senha;
    private String resp_rec_senha;

    public Pessoa(){
        
    }
    
    public Pessoa(int id, String usuario, String senha, String nome, int idade, String data_nascimento, String cpf, String email, String endereco, String telefone, int nivel_de_acesso, int status_da_conta, String pgt_rec_senha, String resp_rec_senha) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.idade = idade;
        this.data_nascimento = data_nascimento;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.nivel_de_acesso = nivel_de_acesso;
        this.status_da_conta = status_da_conta;
        this.pgt_rec_senha = pgt_rec_senha;
        this.resp_rec_senha = resp_rec_senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setNivel_de_acesso(int nivel_de_acesso) {
        this.nivel_de_acesso = nivel_de_acesso;
    }

    public void setStatus_da_conta(int status_da_conta) {
        this.status_da_conta = status_da_conta;
    }

    public void setPgt_rec_senha(String pgt_rec_senha) {
        this.pgt_rec_senha = pgt_rec_senha;
    }

    public void setResp_rec_senha(String resp_rec_senha) {
        this.resp_rec_senha = resp_rec_senha;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getNivel_de_acesso() {
        return nivel_de_acesso;
    }

    public int getStatus_da_conta() {
        return status_da_conta;
    }

    public String getPgt_rec_senha() {
        return pgt_rec_senha;
    }

    public String getResp_rec_senha() {
        return resp_rec_senha;
    }
    

}
