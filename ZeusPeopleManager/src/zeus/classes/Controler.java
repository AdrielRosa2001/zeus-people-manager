
package zeus.classes;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import zeus.conexaoDB.ConexaoDB;
import zeus.jPanels.PPanel;

/**
 *
 * @author Adriel Rosa
 */
public class Controler {
    
    
    
    public List<Pessoa> read(){
        
        List<Pessoa> pessoas = new ArrayList<>();
        
        try {
            ConexaoDB conexao = new ConexaoDB();
            String query = "SELECT * FROM pessoa";
            ResultSet resultados = conexao.retornarDadosDB(query);
            while (resultados.next()){
                Pessoa pessoa = new Pessoa(
                        resultados.getInt("id"),
                        resultados.getString("usuario"),
                        resultados.getString("senha"),
                        resultados.getString("nome"),
                        resultados.getInt("idade"),
                        resultados.getString("data_nascimento"),
                        resultados.getString("cpf"),
                        resultados.getString("email"),
                        resultados.getString("endereco"),
                        resultados.getString("telefone"),
                        resultados.getInt("nivel_de_acesso"),
                        resultados.getInt("status_da_conta"),
                        resultados.getString("pgt_rec_senha"),
                        resultados.getString("resp_rec_senha")
                );
                pessoas.add(pessoa);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pessoas;
        
    }
    
    public boolean verificacaoCpf(JTextField inputCpf,String cpf) {
        int num_cpf = 0, soma = 0, num = 10;
        char[] char_cpf = cpf.toCharArray();

        ///Validando o primeiro digito
        for(int i = 0; i < 9; i++) {
                num_cpf = Character.getNumericValue(char_cpf[i]);

                if(num >= 2) {
                        soma += num_cpf * num;
                        num--;
                }
        }
        int tot = (soma * 10) % 11;


        int soma2 = 0, num2 = 11, cont = 0;

        ///Validando o segundo digito
        for(int i = 0; i < 10; i++) {
                num_cpf = Character.getNumericValue(char_cpf[i]);

                if(num2 >= 2) {
                        soma2 += num_cpf * num2;
                        num2--;
                }

                if(char_cpf[i] == char_cpf[i + 1]) {
                        cont++;
                }
        }
        int tot2 = (soma2 * 10) % 11;


        if(tot == Character.getNumericValue(char_cpf[9]) && tot2 == Character.getNumericValue(char_cpf[10]) && cont < 7) {
                inputCpf.setForeground(Color.black);
                return true;
        }
        JOptionPane.showMessageDialog(null, "CPF inválido!", "Verificação de CPC", JOptionPane.ERROR_MESSAGE);
        inputCpf.setForeground(Color.red);
        return false;
    }
    
}
