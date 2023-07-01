/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package zeus.jPanels;

import zeus.conexaoDB.ConexaoDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import zeus.classes.Admin;
import zeus.classes.Aluno;
import zeus.classes.Professor;

/**
 *
 * @author Adriel Rosa
 */
public class PLogin extends javax.swing.JFrame {

    /**
     * Creates new form FrameZeusLogin
     */
    
    
    public PLogin() {
        initComponents();
        new ImageIcon();
        //this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("imagens/iconzeus.png")).getImage());
    }
    
    
    //PLogin painel_login = new PLogin();
    //PCadastro painel_cadastro = new PCadastro();
    
    private ConexaoDB conexao = new ConexaoDB();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        logoImg = new javax.swing.JLabel();
        inputUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnEsqueci = new javax.swing.JButton();
        btnEntrar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        inputPass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ZEUS - Login");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("imagens/iconzeus.png")).getImage());
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 51, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBackground(new java.awt.Color(135, 159, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zeus/images/logo.png"))); // NOI18N
        jPanel2.add(logoImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 28, -1, -1));

        inputUser.setBackground(new java.awt.Color(188, 201, 255));
        inputUser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        inputUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputUserKeyPressed(evt);
            }
        });
        jPanel2.add(inputUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 121, 252, -1));
        inputUser.getAccessibleContext().setAccessibleName("campoUser");
        inputUser.getAccessibleContext().setAccessibleParent(inputUser);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Usuário:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Senha:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 164, -1, -1));

        btnEsqueci.setBackground(new java.awt.Color(135, 159, 255));
        btnEsqueci.setForeground(new java.awt.Color(0, 0, 153));
        btnEsqueci.setText("Esqueci a senha");
        btnEsqueci.setActionCommand("Esqueci a senha.");
        btnEsqueci.setBorder(null);
        btnEsqueci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEsqueciActionPerformed(evt);
            }
        });
        jPanel2.add(btnEsqueci, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 234, -1, -1));

        btnEntrar.setBackground(new java.awt.Color(23, 23, 255));
        btnEntrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 112, 35));

        btnCadastrar.setBackground(new java.awt.Color(23, 23, 255));
        btnCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Cadastrar-se");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 270, 128, 35));

        inputPass.setBackground(new java.awt.Color(188, 201, 255));
        inputPass.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        inputPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputPassKeyPressed(evt);
            }
        });
        jPanel2.add(inputPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 195, 252, -1));

        jButton1.setBackground(new java.awt.Color(135, 159, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Sobre");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 70, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(427, 399));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        // TODO add your handling code here:
        /*
        PPanel s = new PPanel();
        s.setVisible(true);
        */
        validar_e_entrar();
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        PCadastro painel_cadastro = new PCadastro("login");
        painel_cadastro.setVisible(true);
        //this.setVisible(false);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnEsqueciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsqueciActionPerformed
        PRecsenha painel_rec_senha = new PRecsenha();
        painel_rec_senha.setVisible(true);
        //this.setVisible(false);
    }//GEN-LAST:event_btnEsqueciActionPerformed

    private void inputPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputPassKeyPressed
        //Campo Senha
        if (evt.getKeyCode() == 10){
            validar_e_entrar();
        }
    }//GEN-LAST:event_inputPassKeyPressed

    private void inputUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputUserKeyPressed
        //Campo Usuario
        if (evt.getKeyCode() == 10){
            validar_e_entrar();
        }
    }//GEN-LAST:event_inputUserKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PAbout pAbout = new PAbout();
        pAbout.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void validar_e_entrar(){
        String campoUser = inputUser.getText();
        String campoPass = String.valueOf(inputPass.getPassword());
        String usuario = null;
        String senha = null;
        String queryManual = String.format(
                "SELECT usuario, senha FROM pessoa WHERE usuario = '%s'", 
                campoUser);
        ResultSet loginRetorno = conexao.retornarLogin(queryManual);
        try {
            while(loginRetorno.next()){
                usuario = loginRetorno.getString("usuario");
                senha = loginRetorno.getString("senha");
            }
            if (campoUser.equals(usuario) && campoPass.equals(senha)){
                JOptionPane.showMessageDialog(null, String.format(
                        "Bem vindo! %s", 
                        usuario), 
                        "Login", 
                        JOptionPane.INFORMATION_MESSAGE);
                int nivel_de_acesso = conexao.validarTipoPessoa(usuario);
                if (nivel_de_acesso == 1){
                    Aluno aluno = conexao.extrairAluno(usuario);
                    PPanel painel_main = new PPanel(aluno);
                    painel_main.setVisible(true);
                    this.dispose();
                } else if(nivel_de_acesso == 2){
                    Professor professor = conexao.extrairProfessor(usuario);
                    PPanel painel_main = new PPanel(professor);
                    painel_main.setVisible(true);
                    this.dispose();
                } else if(nivel_de_acesso == 3){
                    Admin admin = conexao.extrairAdmin(usuario);
                    PPanel painel_main = new PPanel(admin);
                    painel_main.setVisible(true);
                    this.dispose();
                }
                
                
                
            } else {
                JOptionPane.showMessageDialog(
                        null, 
                        "Usuário ou senha inválido!", 
                        "ERRO", 
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                    null, 
                    "Usuário ou senha inválido!", 
                    "ERRO", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnEsqueci;
    private javax.swing.JPasswordField inputPass;
    private javax.swing.JTextField inputUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel logoImg;
    // End of variables declaration//GEN-END:variables
}