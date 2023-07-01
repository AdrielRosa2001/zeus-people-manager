
package zeus.conexaoDB;

//import com.sun.jdi.connect.spi.Connection;
//import java.io.IOException;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import zeus.classes.Admin;
import zeus.classes.Pessoa;
import zeus.classes.Professor;
import zeus.classes.Aluno;
import zeus.jPanels.PPanel;

/**
 *
 * @author Adriel Rosa
 */
public class ConexaoDB {
    
    private String url = "jdbc:mysql://localhost:3306/zeusdb";
    private String usuarioDB = "root";
    private String senhaDB = "123456";
    
    public Statement iniciarConexao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, usuarioDB, senhaDB);
            Statement stmt = conexao.createStatement();
            return stmt;
        } catch (ClassNotFoundException ex) {
            System.out.println(String.format("Erro ao iniciar conexão: %s", ex));
        } catch (SQLException ex) {
            System.out.println(String.format("Erro ao iniciar conexão: %s", ex));
        }
        return null;
        
    }
    public static void fecharConexão(Connection con){
        
            try {
                if (con != null){
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("error ao fechar conexão");
            }
    }
    public static void fecharConexão(Connection con, PreparedStatementWrapper stmt){
        
        fecharConexão(con);
            try {
                if (stmt != null){
                    stmt.close();
                }
            } catch (SQLException ex) {
                System.out.println("error ao fechar conexão");
            }
    }
    public static void fecharConexão(Connection con, PreparedStatementWrapper stmt, ResultSet rst){
        
        fecharConexão(con, stmt);
            try {
                if (rst != null){
                    rst.close();
                }
            } catch (SQLException ex) {
                System.out.println("error ao fechar conexão");
            }
    }
    
    public void cadastrarNewUserDB(String queryManualDB1){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, usuarioDB, senhaDB);
            //String query_manual = "";
            conexao.createStatement().executeUpdate(queryManualDB1);
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver de banco de dados não encontrado!");
        } catch (SQLException ex) {
            System.out.println("Algo deu errado na conexão com o banco!" + ex.getMessage());
        } 
    }
    public void cadastrarNewUserDB(String queryManualDB1, String queryManualDB2){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, usuarioDB, senhaDB);
            //String query_manual = "";
            conexao.createStatement().executeUpdate(queryManualDB1);
            conexao.createStatement().executeUpdate(queryManualDB2);
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver de banco de dados não encontrado!");
        } catch (SQLException ex) {
            System.out.println("Algo deu errado na conexão com o banco!" + ex.getMessage());
        } 
    }
    public ResultSet retornarLogin(String queryManualDB){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, usuarioDB, senhaDB);
            ResultSet rsPessoa = conexao.createStatement().executeQuery(queryManualDB);
            return rsPessoa;
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver de banco de dados não encontrado!");
        } catch (SQLException ex) {
            System.out.println("Algo deu errado na conexão com o banco!" + ex.getMessage());
        }
        return null;
    }
    
    public int retornarNivelDeAcesso(String usuario){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, usuarioDB, senhaDB);
            String queryManualDB = String.format("SELECT nivel_de_acesso FROM pessoa WHERE usuario = '%s'", usuario);
            ResultSet rsPessoa = conexao.createStatement().executeQuery(queryManualDB);
            while (rsPessoa.next()){
                return rsPessoa.getInt("nivel_de_acesso");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver de banco de dados não encontrado!");
        } catch (SQLException ex) {
            System.out.println("Algo deu errado na conexão com o banco!" + ex.getMessage());
        }
        return 0;
    }
    public ResultSet retornarDadosDB(String queryManualDB){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, usuarioDB, senhaDB);
            ResultSet rsPessoa = conexao.createStatement().executeQuery(queryManualDB);
            return rsPessoa;
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver de banco de dados não encontrado!");
        } catch (SQLException ex) {
            System.out.println("Algo deu errado na conexão com o banco!" + ex.getMessage());
        }
        return null;
    }
    public String extrairString(ResultSet rst, String coluna){
        try {
            while(rst.next()){
                return rst.getString(coluna);
            }
        } catch (SQLException ex) {
            System.out.println(String.format("Erro ao retornar valor: ", ex));
        }
        return null;
    }
    public String buscarPessoaTipo(String tipo_de_dado, String dado){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, usuarioDB, senhaDB);
            //String query_manual = "";
            String query = String.format("SELECT usuario FROM pessoa WHERE %s = '%s';", tipo_de_dado, dado);
            ResultSet rsPessoa = conexao.createStatement().executeQuery(query);
            while(rsPessoa.next()){
                return rsPessoa.getString("usuario");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver de banco de dados não encontrado!");
        } catch (SQLException ex) {
            System.out.println("Algo deu errado na conexão com o banco!" + ex.getMessage());
        }
        return null;
    }
    public String buscarPessoa(String coluna, String dado){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, usuarioDB, senhaDB);
            //String query_manual = "";
            String query = String.format("SELECT * FROM pessoa WHERE %s = '%s';", coluna, dado);
            ResultSet rsPessoa = conexao.createStatement().executeQuery(query);
            while(rsPessoa.next()){
                return rsPessoa.getString("usuario");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver de banco de dados não encontrado!");
        } catch (SQLException ex) {
            System.out.println("Algo deu errado na conexão com o banco!" + ex.getMessage());
        }
        return null;
    }
    
    public int validarTipoPessoa(String usuario){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, usuarioDB, senhaDB);
            //String query_manual = "";
            String query = String.format("SELECT nivel_de_acesso FROM pessoa WHERE usuario = '%s'", usuario);
            ResultSet rsPessoa = conexao.createStatement().executeQuery(query);
            while(rsPessoa.next()){
                return rsPessoa.getInt("nivel_de_acesso");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver de banco de dados não encontrado!");
        } catch (SQLException ex) {
            System.out.println("Algo deu errado na conexão com o banco!" + ex.getMessage());
        }
        return 0;
    }
    public Professor extrairProfessor(String usuario){
        Professor professor = new Professor();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, usuarioDB, senhaDB);
            String query = String.format("SELECT * FROM pessoa WHERE usuario = '%s';", usuario);
            ResultSet rsProfessor = conexao.createStatement().executeQuery(query);
            while(rsProfessor.next()){
                professor.setId(rsProfessor.getInt("id"));
                professor.setUsuario(rsProfessor.getString("usuario"));
                professor.setSenha(rsProfessor.getString("senha"));
                professor.setNome(rsProfessor.getString("nome"));
                professor.setData_nascimento(rsProfessor.getString("data_nascimento"));
                professor.setIdade(rsProfessor.getInt("idade"));
                professor.setCpf(rsProfessor.getString("cpf"));
                professor.setEmail(rsProfessor.getString("email"));
                professor.setEndereco(rsProfessor.getString("endereco"));
                professor.setTelefone(rsProfessor.getString("telefone"));
                professor.setNivel_de_acesso(rsProfessor.getInt("nivel_de_acesso"));
                professor.setStatus_da_conta(rsProfessor.getInt("status_da_conta"));
                professor.setPgt_rec_senha(rsProfessor.getString("pgt_rec_senha"));
                professor.setPgt_rec_senha(rsProfessor.getString("resp_rec_senha"));
                
            }
            query = String.format("SELECT * FROM professor WHERE id_pessoa = '%s';", professor.getId());
            ResultSet rsProfessor2 = conexao.createStatement().executeQuery(query);
            while(rsProfessor2.next()){
                professor.setMateriaLecionada(rsProfessor2.getString("materia_lecionada"));
                professor.setSalario(rsProfessor2.getDouble("salario"));
            }
            return professor;
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver de banco de dados não encontrado!");
        } catch (SQLException ex) {
            System.out.println("Algo deu errado na conexão com o banco!" + ex.getMessage());
        }
        return null;
    }
    
    public Aluno extrairAluno(String usuario){
        Aluno aluno = new Aluno();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, usuarioDB, senhaDB);
            String query = String.format("SELECT * FROM pessoa WHERE usuario = '%s';", usuario);
            ResultSet rsAluno = conexao.createStatement().executeQuery(query);
            while(rsAluno.next()){
                aluno.setId(rsAluno.getInt("id"));
                aluno.setUsuario(rsAluno.getString("usuario"));
                aluno.setSenha(rsAluno.getString("senha"));
                aluno.setNome(rsAluno.getString("nome"));
                aluno.setData_nascimento(rsAluno.getString("data_nascimento"));
                aluno.setIdade(rsAluno.getInt("idade"));
                aluno.setCpf(rsAluno.getString("cpf"));
                aluno.setEmail(rsAluno.getString("email"));
                aluno.setEndereco(rsAluno.getString("endereco"));
                aluno.setTelefone(rsAluno.getString("telefone"));
                aluno.setNivel_de_acesso(rsAluno.getInt("nivel_de_acesso"));
                aluno.setStatus_da_conta(rsAluno.getInt("status_da_conta"));
                aluno.setPgt_rec_senha(rsAluno.getString("pgt_rec_senha"));
                aluno.setPgt_rec_senha(rsAluno.getString("resp_rec_senha"));
                
            }
            query = String.format("SELECT * FROM aluno WHERE id_pessoa = '%s';", aluno.getId());
            ResultSet rsProfessor2 = conexao.createStatement().executeQuery(query);
            while(rsProfessor2.next()){
                aluno.setMatricula(rsProfessor2.getString("matricula"));
                aluno.setMensalidade(rsProfessor2.getDouble("mensalidade"));
            }
            return aluno;
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver de banco de dados não encontrado!");
        } catch (SQLException ex) {
            System.out.println("Algo deu errado na conexão com o banco!" + ex.getMessage());
        }
        return null;
    }
    public Admin extrairAdmin(String usuario){
        Admin admin = new Admin();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, usuarioDB, senhaDB);
            String query = String.format("SELECT * FROM pessoa WHERE usuario = '%s';", usuario);
            ResultSet rsAdmin = conexao.createStatement().executeQuery(query);
            while(rsAdmin.next()){
                admin.setId(rsAdmin.getInt("id"));
                admin.setUsuario(rsAdmin.getString("usuario"));
                admin.setSenha(rsAdmin.getString("senha"));
                admin.setNome(rsAdmin.getString("nome"));
                admin.setData_nascimento(rsAdmin.getString("data_nascimento"));
                admin.setIdade(rsAdmin.getInt("idade"));
                admin.setCpf(rsAdmin.getString("cpf"));
                admin.setEmail(rsAdmin.getString("email"));
                admin.setEndereco(rsAdmin.getString("endereco"));
                admin.setTelefone(rsAdmin.getString("telefone"));
                admin.setNivel_de_acesso(rsAdmin.getInt("nivel_de_acesso"));
                admin.setStatus_da_conta(rsAdmin.getInt("status_da_conta"));
                admin.setPgt_rec_senha(rsAdmin.getString("pgt_rec_senha"));
                admin.setPgt_rec_senha(rsAdmin.getString("resp_rec_senha"));
                
            }
            return admin;
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver de banco de dados não encontrado!");
        } catch (SQLException ex) {
            System.out.println("Algo deu errado na conexão com o banco!" + ex.getMessage());
        }
        return null;
    }
    public boolean updateDadosAdmin(Admin admin){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, usuarioDB, senhaDB);
            // senha, nome, data_nascimento, idade, cpf, email, endereco, telefone, pgt_rec_senha, resp_rec_senha
            String queryM = String.format("UPDATE pessoa SET senha = '%s' WHERE usuario = '%s' ", admin.getSenha(), admin.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET nome = '%s' WHERE usuario = '%s' ", admin.getNome(), admin.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET data_nascimento = '%s' WHERE usuario = '%s' ", admin.getData_nascimento(), admin.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET idade = %s WHERE usuario = '%s' ", admin.getIdade(), admin.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET cpf = '%s' WHERE usuario = '%s' ", admin.getCpf(), admin.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET email = '%s' WHERE usuario = '%s' ", admin.getEmail(), admin.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET endereco = '%s' WHERE usuario = '%s' ", admin.getEndereco(), admin.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET telefone = '%s' WHERE usuario = '%s' ", admin.getTelefone(), admin.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET pgt_rec_senha = '%s' WHERE usuario = '%s' ", admin.getPgt_rec_senha(), admin.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET resp_rec_senha = '%s' WHERE usuario = '%s' ", admin.getResp_rec_senha(), admin.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!", "Alteração de dados", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver de banco de dados não encontrado!");
            JOptionPane.showMessageDialog(null, "Houve um arro ao tentar salvar!", "Alteração de dados", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            System.out.println("Algo deu errado na conexão com o banco!" + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Houve um arro ao tentar salvar!", "Alteração de dados", JOptionPane.ERROR_MESSAGE);
        } 
        return false;
    }
    public boolean updateDadosAluno(Aluno aluno){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, usuarioDB, senhaDB);
            //String query_manual = "";
            // senha, nome, data_nascimento, idade, cpf, email, endereco, telefone, pgt_rec_senha, resp_rec_senha
            String queryM = String.format("UPDATE pessoa SET senha = '%s' WHERE usuario = '%s' ", aluno.getSenha(), aluno.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET nome = '%s' WHERE usuario = '%s' ", aluno.getNome(), aluno.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET data_nascimento = '%s' WHERE usuario = '%s' ", aluno.getData_nascimento(), aluno.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET idade = %s WHERE usuario = '%s' ", aluno.getIdade(), aluno.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET cpf = '%s' WHERE usuario = '%s' ", aluno.getCpf(), aluno.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET email = '%s' WHERE usuario = '%s' ", aluno.getEmail(), aluno.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET endereco = '%s' WHERE usuario = '%s' ", aluno.getEndereco(), aluno.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET telefone = '%s' WHERE usuario = '%s' ", aluno.getTelefone(), aluno.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET pgt_rec_senha = '%s' WHERE usuario = '%s' ", aluno.getPgt_rec_senha(), aluno.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET resp_rec_senha = '%s' WHERE usuario = '%s' ", aluno.getResp_rec_senha(), aluno.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE aluno SET matricula = '%s' WHERE id_pessoa = %s ", aluno.getMatricula(), aluno.getId());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE aluno SET mensalidade = %s WHERE id_pessoa = %s ", aluno.getMensalidade(), aluno.getId());
            conexao.createStatement().executeUpdate(queryM);
            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!", "Alteração de dados", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver de banco de dados não encontrado!");
            JOptionPane.showMessageDialog(null, "Houve um arro ao tentar salvar!", "Alteração de dados", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            System.out.println("Algo deu errado na conexão com o banco!" + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Houve um arro ao tentar salvar!", "Alteração de dados", JOptionPane.ERROR_MESSAGE);
        } 
        return false;
    }
    public boolean updateDadosProfessor(Professor professor){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, usuarioDB, senhaDB);
            //String query_manual = "";
            // senha, nome, data_nascimento, idade, cpf, email, endereco, telefone, pgt_rec_senha, resp_rec_senha
            String queryM = String.format("UPDATE pessoa SET senha = '%s' WHERE usuario = '%s';", professor.getSenha(), professor.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET nome = '%s' WHERE usuario = '%s';", professor.getNome(), professor.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET data_nascimento = '%s' WHERE usuario = '%s';", professor.getData_nascimento(), professor.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET idade = %s WHERE usuario = '%s';", professor.getIdade(), professor.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET cpf = '%s' WHERE usuario = '%s';", professor.getCpf(), professor.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET email = '%s' WHERE usuario = '%s';", professor.getEmail(), professor.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET endereco = '%s' WHERE usuario = '%s';", professor.getEndereco(), professor.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET telefone = '%s' WHERE usuario = '%s';", professor.getTelefone(), professor.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET pgt_rec_senha = '%s' WHERE usuario = '%s';", professor.getPgt_rec_senha(), professor.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE pessoa SET resp_rec_senha = '%s' WHERE usuario = '%s';", professor.getResp_rec_senha(), professor.getUsuario());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE professor SET materia_lecionada = '%s' WHERE id_pessoa = %s;", professor.getMateriaLecionada(), professor.getId());
            conexao.createStatement().executeUpdate(queryM);
            queryM = String.format("UPDATE professor SET salario = %s WHERE id_pessoa = %s;", professor.getSalario(), professor.getId());
            conexao.createStatement().executeUpdate(queryM);
            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!", "Alteração de dados", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver de banco de dados não encontrado!");
            JOptionPane.showMessageDialog(null, "Houve um arro ao tentar salvar!", "Alteração de dados", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            System.out.println("Algo deu errado na conexão com o banco!" + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Houve um arro ao tentar salvar!", "Alteração de dados", JOptionPane.ERROR_MESSAGE);
        } 
        return false;
    }
    public void deletarUsuario(int id, int nivel_de_acesso){
        //DELETE FROM pessoa WHERE id = %s;
        //DELETE FROM professor where id_pessoa = %s;
        if (nivel_de_acesso == 1){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conexao;
                try {
                    conexao = DriverManager.getConnection(url, usuarioDB, senhaDB);
                    String queryM = "";
                    queryM = String.format("DELETE FROM aluno WHERE id_pessoa = %s;", id);
                    conexao.createStatement().executeUpdate(queryM);
                    conexao.close();
                    conexao = DriverManager.getConnection(url, usuarioDB, senhaDB);
                    queryM = String.format("DELETE FROM pessoa WHERE id = %s;", id);
                    conexao.createStatement().executeUpdate(queryM);
                } catch (SQLException ex) {
                    try {
                        conexao = DriverManager.getConnection(url, usuarioDB, senhaDB);
                        String queryM = "";
                        queryM = String.format("DELETE FROM pessoa WHERE id = %s;", id);
                        conexao.createStatement().executeUpdate(queryM);
                    } catch (SQLException zx) {
                        System.out.println("Erro ao deletar dados"+zx.getMessage());
                    }
                }
                
            } catch (ClassNotFoundException ex) {
                System.out.println("Erro ao deletar dados"+ex.getMessage());
            }
        } else if (nivel_de_acesso == 2) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conexao;
                try {
                    conexao = DriverManager.getConnection(url, usuarioDB, senhaDB);
                    String queryM = "";
                    queryM = String.format("DELETE FROM professor WHERE id_pessoa = %s;", id);
                    conexao.createStatement().executeUpdate(queryM);
                    conexao.close();
                    conexao = DriverManager.getConnection(url, usuarioDB, senhaDB);
                    queryM = String.format("DELETE FROM pessoa WHERE id = %s;", id);
                    conexao.createStatement().executeUpdate(queryM);
                    
                } catch (SQLException ex) {
                    try {
                        conexao = DriverManager.getConnection(url, usuarioDB, senhaDB);
                        String queryM = "";
                        queryM = String.format("DELETE FROM pessoa WHERE id = %s;", id);
                        conexao.createStatement().executeUpdate(queryM);
                    } catch (SQLException zx) {
                        System.out.println("Erro ao deletar dados"+zx.getMessage());
                    }
                }
                
            } catch (ClassNotFoundException ex) {
                System.out.println("Erro ao deletar dados"+ex.getMessage());
            }
        } else if (nivel_de_acesso == 3) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conexao;
                try {
                    conexao = DriverManager.getConnection(url, usuarioDB, senhaDB);
                    String queryM = String.format("DELETE FROM pessoa WHERE id = %s;", id);
                    conexao.createStatement().executeUpdate(queryM);
                } catch (SQLException ex) {
                    System.out.println("Erro ao deletar dados"+ex.getMessage());
                }
                
            } catch (ClassNotFoundException ex) {
                System.out.println("Erro ao deletar dados"+ex.getMessage());
            }
        }
    }
    
    
}
