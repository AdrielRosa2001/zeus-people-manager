/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package zeus.jPanels;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import zeus.conexaoDB.ConexaoDB;
import javax.swing.JOptionPane;
import zeus.classes.Admin;
import zeus.classes.Aluno;
import zeus.classes.Professor;

/**
 *
 * @author Adriel Rosa
 */
public class PPerfilAdmin extends javax.swing.JFrame {

    /**
     * Creates new form PCadastro
     */
    private String vem_de = null;
    private ConexaoDB conexao = new ConexaoDB();
    private String usuario = null;
    private String usuario_atual = null;
    private int nivel_acesso = 0;
    
    public PPerfilAdmin(String user) {
        initComponents();
        usuario = user;
        usuario_atual = user;
        carregarDadosCompletosAdmin();
        habilitaInputs();
        habilitarBotoes();
        
    }
    public PPerfilAdmin(String usuario_atu, String user, int nivel_de_acesso) {
        initComponents();
        usuario = user;
        nivel_acesso = nivel_de_acesso;
        usuario_atual = usuario_atu;
        
        if (nivel_de_acesso != 3){
            carregarDadosOcultos();
        } else {
            carregarDadosCompletos();
        }
        
    }

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
        jLabel1 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inputUser = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inputEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        inputEnd = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        comboboxTipoConta = new javax.swing.JComboBox<>();
        inputPass = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        inputNomeCompleto = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        inputTel = new javax.swing.JFormattedTextField();
        inputDataDeNascimento = new javax.swing.JFormattedTextField();
        inputCPF = new javax.swing.JFormattedTextField();
        btnPhoto = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        comboboxRecSenha = new javax.swing.JComboBox<>();
        inputRecSenha = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnSalvarDados = new javax.swing.JButton();
        btnApagarUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ZEUS - Cadastro de usuários");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("imagens/iconzeus.png")).getImage());
        setMinimumSize(new java.awt.Dimension(495, 620));

        jPanel1.setBackground(new java.awt.Color(0, 51, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(850, 620));

        jPanel2.setBackground(new java.awt.Color(135, 159, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Perfil do Usuário");

        btnVoltar.setBackground(new java.awt.Color(135, 159, 255));
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zeus/images/btn-voltar.png"))); // NOI18N
        btnVoltar.setBorder(null);
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVoltar)
                .addGap(115, 115, 115)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVoltar)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(135, 159, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Usuario:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Senha:");

        inputUser.setEditable(false);
        inputUser.setBackground(new java.awt.Color(188, 201, 255));
        inputUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputUserFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("E-mail:");

        inputEmail.setEditable(false);
        inputEmail.setBackground(new java.awt.Color(188, 201, 255));
        inputEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Telefone:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Data de nascimento:");

        inputEnd.setEditable(false);
        inputEnd.setBackground(new java.awt.Color(188, 201, 255));
        inputEnd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Tipo de conta:");

        comboboxTipoConta.setBackground(new java.awt.Color(188, 201, 255));
        comboboxTipoConta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboboxTipoConta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aluno", "Professor" }));
        comboboxTipoConta.setEnabled(false);

        inputPass.setEditable(false);
        inputPass.setBackground(new java.awt.Color(188, 201, 255));
        inputPass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("CPF:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Nome Completo:");

        inputNomeCompleto.setEditable(false);
        inputNomeCompleto.setBackground(new java.awt.Color(188, 201, 255));
        inputNomeCompleto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Endereço:");

        inputTel.setEditable(false);
        inputTel.setBackground(new java.awt.Color(188, 201, 255));
        try {
            inputTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        inputTel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        inputDataDeNascimento.setEditable(false);
        inputDataDeNascimento.setBackground(new java.awt.Color(188, 201, 255));
        try {
            inputDataDeNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        inputDataDeNascimento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        inputCPF.setEditable(false);
        inputCPF.setBackground(new java.awt.Color(188, 201, 255));
        try {
            inputCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        inputCPF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btnPhoto.setBackground(new java.awt.Color(23, 23, 255));
        btnPhoto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPhoto.setForeground(new java.awt.Color(255, 255, 255));
        btnPhoto.setText("Foto");
        btnPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(inputUser, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addComponent(jLabel3)
                                    .addComponent(inputPass))
                                .addGap(30, 30, 30))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(inputNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)
                            .addComponent(comboboxTipoConta, 0, 199, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(inputTel)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inputDataDeNascimento)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(inputCPF)
                                .addGap(30, 30, 30))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(inputEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(btnPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(2, 2, 2)
                                .addComponent(comboboxTipoConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputDataDeNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPhoto))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(135, 159, 255));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Pergunta de recuperação de senha:");

        comboboxRecSenha.setBackground(new java.awt.Color(188, 201, 255));
        comboboxRecSenha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboboxRecSenha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Onde seus pais se conhecera?", "Qual é o nome do seu melhor amigo de infância?", "Em que cidade você nasceu?", "Qual é o nome do seu primeiro professor?", "Qual é o nome do seu primeiro amor?", "Em que ano você se formou no ensino médio?", "Qual é o nome da sua avó materna?", "Qual é a sua comida favorita?", "Qual é o nome do seu primeiro animal de estimação?" }));
        comboboxRecSenha.setEnabled(false);

        inputRecSenha.setEditable(false);
        inputRecSenha.setBackground(new java.awt.Color(188, 201, 255));
        inputRecSenha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboboxRecSenha, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputRecSenha, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(11, 11, 11)
                .addComponent(comboboxRecSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputRecSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(135, 159, 255));

        btnSalvarDados.setBackground(new java.awt.Color(23, 23, 255));
        btnSalvarDados.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalvarDados.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvarDados.setText("Salvar dados");
        btnSalvarDados.setEnabled(false);
        btnSalvarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarDadosActionPerformed(evt);
            }
        });

        btnApagarUsuario.setBackground(new java.awt.Color(23, 23, 255));
        btnApagarUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnApagarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnApagarUsuario.setText("Apagar Usuário");
        btnApagarUsuario.setEnabled(false);
        btnApagarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalvarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnApagarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnApagarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btnSalvarDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(468, 552));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnSalvarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarDadosActionPerformed
        Admin admin = conexao.extrairAdmin(usuario);
        
        String senha = String.valueOf(inputPass.getPassword());
        String nome = inputNomeCompleto.getText();
        String data_nascimento = inputDataDeNascimento.getText();
        String cpf = inputCPF.getText();
        String email = inputEmail.getText();
        String endereco = inputEnd.getText();
        String telefone = inputTel.getText();
        String pgt_rec_senha = String.valueOf(comboboxRecSenha.getSelectedItem());
        String resp_rec_senha = inputRecSenha.getText();

        admin.setSenha(senha);
        admin.setNome(nome);
        admin.setData_nascimento(data_nascimento);
        admin.setCpf(cpf);
        admin.setEmail(email);
        admin.setEndereco(endereco);
        admin.setTelefone(telefone);
        admin.setPgt_rec_senha(pgt_rec_senha);
        admin.setResp_rec_senha(resp_rec_senha);
        
        boolean retorno = conexao.updateDadosAdmin(admin);
        
        if (retorno == true){
            this.dispose();
        }
    }//GEN-LAST:event_btnSalvarDadosActionPerformed

    private void inputUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputUserFocusLost
        
    }//GEN-LAST:event_inputUserFocusLost

    private void btnApagarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarUsuarioActionPerformed
        nivel_acesso = conexao.retornarNivelDeAcesso(usuario_atual);
        if (usuario_atual != usuario && nivel_acesso == 3){
            Admin admin = new Admin();
            admin = conexao.extrairAdmin(usuario);
            conexao.deletarUsuario(admin.getId(), admin.getNivel_de_acesso());
            JOptionPane.showMessageDialog(null, "Usuario apagado!", "Apagar usuário", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } else if(usuario_atual == usuario && nivel_acesso == 3){
            Admin admin = new Admin();
            admin = conexao.extrairAdmin(usuario);
            conexao.deletarUsuario(admin.getId(), admin.getNivel_de_acesso());
            JOptionPane.showMessageDialog(null, "Usuario apagado!", "Apagar usuário", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }else {
            JOptionPane.showMessageDialog(null, "Usuario não foi apagado!", "Apagar usuário", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnApagarUsuarioActionPerformed

    private void btnPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhotoActionPerformed
        if (inputNomeCompleto.getText() != ""){
            PPhotoPerfil pPhoto = new PPhotoPerfil(inputUser.getText(), inputNomeCompleto.getText());
            pPhoto.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null,"Digite o nome completo para adicionar uma foto!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPhotoActionPerformed
    
    private void habilitaInputs(){
        inputUser.setEditable(false);
        comboboxTipoConta.setEnabled(true);
        inputPass.setEditable(true);
        inputTel.setEditable(true);
        inputNomeCompleto.setEditable(true);
        inputDataDeNascimento.setEditable(true);
        inputCPF.setEditable(true);
        inputEmail.setEditable(true);
        inputEnd.setEditable(true);
        comboboxRecSenha.setEnabled(true);
        inputRecSenha.setEditable(true);
        
    }
    private void habilitarBotoes(){
        btnSalvarDados.setEnabled(true);
        btnApagarUsuario.setEnabled(true);
    }
    private void carregarDadosCompletosAdmin(){
        Admin admin = new Admin();
        admin = conexao.extrairAdmin(usuario);
        inputUser.setText(admin.getUsuario());
        comboboxTipoConta.setSelectedItem("Admin");
        inputPass.setText(admin.getSenha());
        inputTel.setText(String.format("%s", admin.getTelefone()));
        inputNomeCompleto.setText(admin.getNome());
        inputDataDeNascimento.setText(String.format("%s", admin.getData_nascimento()));
        inputCPF.setText(String.format("%s", admin.getCpf()));
        inputEmail.setText(admin.getEmail());
        inputEnd.setText(admin.getEndereco());
        comboboxRecSenha.setSelectedItem(admin.getPgt_rec_senha());
        inputRecSenha.setText(admin.getPgt_rec_senha());
    }
    private void carregarDadosCompletos(){
        Admin admin = new Admin();
        admin = conexao.extrairAdmin(usuario);
        inputUser.setText(admin.getUsuario());
        comboboxTipoConta.setSelectedItem("Admin");
        inputPass.setText(admin.getSenha());
        inputTel.setText(String.format("%s", admin.getTelefone()));
        inputNomeCompleto.setText(admin.getNome());
        inputDataDeNascimento.setText(String.format("%s", admin.getData_nascimento()));
        inputCPF.setText(String.format("%s", admin.getCpf()));
        inputEmail.setText(admin.getEmail());
        inputEnd.setText(admin.getEndereco());
        comboboxRecSenha.setEnabled(false);
        inputRecSenha.setText("*************");        

        comboboxRecSenha.setForeground(Color.red);
        inputRecSenha.setForeground(Color.red);
    }
    private void carregarDadosOcultos(){
        Admin admin = new Admin();
        admin = conexao.extrairAdmin(usuario);
        inputUser.setText(admin.getUsuario());
        comboboxTipoConta.setSelectedItem("Admin");
        inputPass.setText("***********");
        inputTel.setText(String.format("%s", admin.getTelefone()));
        inputNomeCompleto.setText(admin.getNome());
        inputDataDeNascimento.setText(String.format("%s", admin.getData_nascimento()));
        inputCPF.setText("000000000000");
        inputEmail.setText(admin.getEmail());
        inputEnd.setText("**************");
        comboboxRecSenha.setEnabled(false);
        inputRecSenha.setText("*****************");
        
        inputPass.setForeground(Color.red);
        inputCPF.setForeground(Color.red);
        inputEnd.setForeground(Color.red);
        comboboxRecSenha.setForeground(Color.red);
        inputRecSenha.setForeground(Color.red);
    }
    private void salvarDados(){
        // senha, nome, data_nascimento, idade, cpf, email, endereco, telefone, pgt_rec_senha, resp_rec_senha
        Admin admin = conexao.extrairAdmin(usuario);
        
        String senha = String.valueOf(inputPass.getPassword());
        String nome = inputNomeCompleto.getText();
        String data_nascimento = inputDataDeNascimento.getText();
        String cpf = inputCPF.getText();
        String email = inputEmail.getText();
        String endereco = inputEnd.getText();
        String telefone = inputTel.getText();
        String pgt_rec_senha = String.valueOf(comboboxRecSenha.getSelectedItem());
        String resp_rec_senha = inputRecSenha.getText();
        
        admin.setSenha(senha);
        admin.setNome(nome);
        admin.setData_nascimento(data_nascimento);
        admin.setCpf(cpf);
        admin.setEmail(email);
        admin.setEndereco(endereco);
        admin.setTelefone(telefone);
        admin.setPgt_rec_senha(pgt_rec_senha);
        admin.setResp_rec_senha(resp_rec_senha);
        
        boolean retorno = conexao.updateDadosAdmin(admin);
        
        if (retorno == true){
            this.dispose();
        }
    }

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PCadastro().setVisible(true);
            }
        });
    }
    */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApagarUsuario;
    private javax.swing.JButton btnPhoto;
    private javax.swing.JButton btnSalvarDados;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> comboboxRecSenha;
    private javax.swing.JComboBox<String> comboboxTipoConta;
    private javax.swing.JFormattedTextField inputCPF;
    private javax.swing.JFormattedTextField inputDataDeNascimento;
    private javax.swing.JTextField inputEmail;
    private javax.swing.JTextField inputEnd;
    private javax.swing.JTextField inputNomeCompleto;
    private javax.swing.JPasswordField inputPass;
    private javax.swing.JTextField inputRecSenha;
    private javax.swing.JFormattedTextField inputTel;
    private javax.swing.JTextField inputUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
