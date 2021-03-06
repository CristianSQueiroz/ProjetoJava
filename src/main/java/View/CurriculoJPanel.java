/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CurriculoController;
import Model.Curriculo;
import java.util.Enumeration;
import java.util.HashMap;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class CurriculoJPanel extends javax.swing.JPanel {

        private String usuarioNM;
        private Curriculo curriculo;
    /**
     * MODO DE CADASTRO -> variavel curriculo ser nula e o modo de edição true
     * MODO DE CONSULTA -> variavel curriculo possuir informações e o 
     * modo de edição ser falso
     * MODO DE ATUALIZAÇÃO -> variavel curriculo possuir informações e o
     * modo de edição ser true
     */
    public CurriculoJPanel(String usuarioNM,Curriculo curriculo,boolean editMode) {
        this.usuarioNM = usuarioNM;
        this.curriculo = curriculo;
        initComponents();
        Init();
        if(curriculo!= null){
            CarregarCurriculo();
        }
        BloquearCampos(editMode);
    }
    
    
    //Bloquear ou nao os campos, ele vai alterar o texto do botao cadastrar/atualizar 
    public void BloquearCampos(boolean editMode){
       nomeCompletoJTF.setEditable(editMode);
       dataJTF.setEditable(editMode);
       jTextArea1.setEditable(editMode);
       generoJComboBox.setEnabled(editMode);
       escolaridadeJCB.setEnabled(editMode);
       BloquearJRadioButton(javaScriptBG,editMode);
       BloquearJRadioButton(SQLBG,editMode);
       BloquearJRadioButton(CSharpBG,editMode);
       BloquearJRadioButton(GitHubBG,editMode);
       if(curriculo== null){
           cadastrarButton.setText("Cadastrar");
           cadastrarButton.setEnabled(true);
           limparJButton.setEnabled(true);
       }else{
           if(editMode){
               cadastrarButton.setText("Atualizar");
           }
           cadastrarButton.setEnabled(editMode);
           limparJButton.setEnabled(editMode);
       }
    }
    
    //Método para bloquear ou não os radioButtons
    private void BloquearJRadioButton(ButtonGroup bg ,boolean editMode){
        try{
            Enumeration<AbstractButton> enumButtons = bg.getElements();
            //Loop para Percorrer todos os elementos da 'Lista'
            //com a condição de 'executar enquanto houver elementos nessa lista'
            while(enumButtons.hasMoreElements()){
                //Percorrendo a lista e pegando o proximo elemento
                //Guardando o valor e fazendo a conversão do botão abstrato para RadioButton
                JRadioButton rb = (JRadioButton)enumButtons.nextElement();
                rb.setEnabled(editMode);
            }
        } catch(Exception e){
            //deu exception
        } 
    }
    
    
    //preencher as informações do curriculo na tela
    public void CarregarCurriculo(){
        nomeCompletoJTF.setText(curriculo.getNomeCompleto());
        dataJTF.setText(curriculo.getDataNascimento());
        jTextArea1.setText(curriculo.getExperienciasAdd());
        generoJComboBox.setSelectedItem(curriculo.getGenero());
        escolaridadeJCB.setSelectedItem(curriculo.getEscolaridade());
       
        SetSelectionOn(javaScriptBG,curriculo.GetExperienciaJS());
        SetSelectionOn(SQLBG,curriculo.GetExperienciaSQL());
        SetSelectionOn(CSharpBG,curriculo.GetExperienciaCSharp());
        SetSelectionOn(GitHubBG,curriculo.GetExperienciaGitHub());
    }
    
    private void SetSelectionOn(ButtonGroup bg , int index){
        //Limpa Qualquer seleção deste grupo
        bg.clearSelection();
        try{
            Enumeration<AbstractButton> enumButtons = bg.getElements();
            //0 - Iniciante
            //1 - Regular
            //2 - Avançado
            
            //Iniciando o contador;
            int count = 0;
            //Loop para Percorrer todos os elementos da 'Lista'
            //com a condição de 'executar enquanto houver elementos nessa lista'
            while(enumButtons.hasMoreElements()){
                //Percorrendo a lista e pegando o proximo elemento
                //Guardando o valor e fazendo a conversão do botão abstrato para RadioButton
                JRadioButton rb = (JRadioButton)enumButtons.nextElement();
                //Fazendo a verificação se o index é o mesmo do RadioButton
                if(count == index){
                    //Selecionando o RadioButton
                    rb.setSelected(true);
                    //Sair do Loop
                    return;
                }
                //Caso não seja o mesmo index desejado, incrementa o contador e volta ao inicio do loop
                count++;
            }
        } catch(Exception e){
            //deu exception
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

        javaScriptBG = new javax.swing.ButtonGroup();
        SQLBG = new javax.swing.ButtonGroup();
        CSharpBG = new javax.swing.ButtonGroup();
        GitHubBG = new javax.swing.ButtonGroup();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        escolaridadeJCB = new javax.swing.JComboBox<>();
        cadastrarButton = new javax.swing.JButton();
        inicianteJS = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        regularJS = new javax.swing.JRadioButton();
        limparJButton = new javax.swing.JButton();
        avancadoJS = new javax.swing.JRadioButton();
        inicianteSQL = new javax.swing.JRadioButton();
        regularSQL = new javax.swing.JRadioButton();
        avancadoSQL = new javax.swing.JRadioButton();
        inicianteC = new javax.swing.JRadioButton();
        regularC = new javax.swing.JRadioButton();
        avancadoC = new javax.swing.JRadioButton();
        inicianteGIT = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomeCompletoJTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dataJTF = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        generoJComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        regularGIT = new javax.swing.JRadioButton();
        avancadoGIT = new javax.swing.JRadioButton();

        jLabel6.setText("Java Script ->");

        jLabel7.setText("SQL ->");

        jLabel8.setText("C# ->");

        jLabel9.setText("Github->");

        jLabel10.setText("Experiencias Adicionais:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel11.setText("Escolaridade:");

        escolaridadeJCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Segundo grau imcompleto", "Segundo grau completo", "Tecnico imcompleto", "Tecnico completo", "Superior imcompleto", "Superior completo" }));

        cadastrarButton.setText("Cadastrar");
        cadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarButtonActionPerformed(evt);
            }
        });

        inicianteJS.setText("Iniciante");

        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        regularJS.setText("Regular");

        limparJButton.setText("Limpar");
        limparJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparJButtonActionPerformed(evt);
            }
        });

        avancadoJS.setText("Avançado");

        inicianteSQL.setText("Iniciante");

        regularSQL.setText("Regular");

        avancadoSQL.setText("Avançado");

        inicianteC.setText("Iniciante");

        regularC.setText("Regular");

        avancadoC.setText("Avançado");

        inicianteGIT.setText("Iniciante");

        jLabel1.setText("Cadastro Curriculo");

        jLabel2.setText("Nome:");

        jLabel3.setText("Data de nascimento:");

        try {
            dataJTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("Genero:");

        generoJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));

        jLabel5.setText("Experiencia");

        regularGIT.setText("Regular");

        avancadoGIT.setText("Avançado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dataJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nomeCompletoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(39, 39, 39)
                                    .addComponent(jLabel5))
                                .addComponent(generoJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(escolaridadeJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel11)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(inicianteSQL)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(regularSQL)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(avancadoSQL))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(inicianteJS)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(regularJS)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(avancadoJS))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(inicianteC)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(regularC)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(avancadoC))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(inicianteGIT)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(regularGIT)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(avancadoGIT))))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(cadastrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(limparJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomeCompletoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dataJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(generoJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(escolaridadeJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inicianteJS)
                    .addComponent(regularJS)
                    .addComponent(avancadoJS)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(inicianteSQL)
                    .addComponent(regularSQL)
                    .addComponent(avancadoSQL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(inicianteC)
                    .addComponent(regularC)
                    .addComponent(avancadoC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(inicianteGIT)
                    .addComponent(regularGIT)
                    .addComponent(avancadoGIT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limparJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(283, 283, 283))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarButtonActionPerformed
        Cadastrar();
    }//GEN-LAST:event_cadastrarButtonActionPerformed

    //Metodo para cadastrar ou atualizar os dados do curriculo
     private void Cadastrar(){
        String nomeCompleto = nomeCompletoJTF.getText().trim();
        String dataNascimento = dataJTF.getText().trim();
        String genero = generoJComboBox.getSelectedItem().toString();
        String escolaridade = escolaridadeJCB.getSelectedItem().toString();
        String experienciasAdd = jTextArea1.getText().trim();
        Curriculo curriculoTemp = new Curriculo(this.usuarioNM,
                nomeCompleto, 
                dataNascimento, 
                genero,
                escolaridade,
                getExperiencias(), 
                experienciasAdd);
        //caso não possua curriculo enviado pela tela anterior cadastra
        //caso possua atualizada
        if(curriculo == null){
            if(CurriculoController.GetInstance().Cadastrar(curriculoTemp)){
                CloseJPanel();
            }    
        }else{
            if(CurriculoController.GetInstance().Atualizar(curriculoTemp)){
                CloseJPanel();
            }    
        }
    }
    
    
    private HashMap getExperiencias(){
        //Pegar Valores dos Radios Buttons;
        HashMap<String,Integer> valores = new HashMap<>();
        //Pegando buttao selecionado do grupo Java Script e colocando no HashMap
        valores.put("JavaScript", GetSelectedRadioButton(javaScriptBG.getElements()));
        //Pegando buttao selecionado do grupo SQL e colocando no HashMap
        valores.put("SQL", GetSelectedRadioButton(SQLBG.getElements()));
        //Pegando buttao selecionado do grupo C# e colocando no HashMap
        valores.put("CSharp", GetSelectedRadioButton(CSharpBG.getElements()));
        //Pegando buttao selecionado do grupo GitHUB e colocando no HashMap
        valores.put("GitHub", GetSelectedRadioButton(GitHubBG.getElements()));
        //Retornando o HashMap já preenchido com as informações;
        return valores;
    }
    
    private int GetSelectedRadioButton(Enumeration<AbstractButton> enumButtons){
        try{
            //0 - Iniciante
            //1 - Regular
            //2 - Avançado
            
            //Iniciando o contador;
            int count = 0;
            //Loop para Percorrer todos os elementos da 'Lista'
            //com a condição de 'executar enquanto houver elementos nessa lista'
            while(enumButtons.hasMoreElements()){
                //Percorrendo a lista e pegando o proximo elemento
                //Guardando o valor e fazendo a conversão do botão abstrato para RadioButton
                JRadioButton rb = (JRadioButton)enumButtons.nextElement();
                //Fazendo a verificação se o RadioButton está selecionado
                if(rb.isSelected()){
                    //Caso esteja selecionado interrompe o metodo e retorno o valor da posição da lista
                    return count;
                }
                //Caso não esteja selecionado, incrementa o contador e volta ao inicio do loop
                count++;
            }
        } catch(Exception e){
            //deu exception
        } 
        //Retorna o valor Padrão (Iniciante) caso o usuario não tenha selecionado a experiencia
        return 0;
    }
    
    
    private void limparJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparJButtonActionPerformed
        nomeCompletoJTF.setText("");
        dataJTF.setText("");
        jTextArea1.setText("");
        generoJComboBox.setSelectedIndex(0);
        escolaridadeJCB.setSelectedIndex(0);
        javaScriptBG.clearSelection();
        SQLBG.clearSelection();
        CSharpBG.clearSelection();
        GitHubBG.clearSelection();
    }//GEN-LAST:event_limparJButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CloseJPanel();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CloseJPanel(){
           this.setVisible(false);        // TODO add your handling code here:
    }
    
    //Adicionar os Radios Buttons nos grupos
    public void Init(){
        //Java Script
        javaScriptBG.add(inicianteJS);
        javaScriptBG.add(regularJS);
        javaScriptBG.add(avancadoJS);
        //SQL
        SQLBG.add(inicianteSQL);
        SQLBG.add(regularSQL);
        SQLBG.add(avancadoSQL);
        //C#
        CSharpBG.add(inicianteC);
        CSharpBG.add(regularC);
        CSharpBG.add(avancadoC);
        //GIT
        GitHubBG.add(inicianteGIT);
        GitHubBG.add(regularGIT);
        GitHubBG.add(avancadoGIT);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup CSharpBG;
    private javax.swing.ButtonGroup GitHubBG;
    private javax.swing.ButtonGroup SQLBG;
    private javax.swing.JRadioButton avancadoC;
    private javax.swing.JRadioButton avancadoGIT;
    private javax.swing.JRadioButton avancadoJS;
    private javax.swing.JRadioButton avancadoSQL;
    private javax.swing.JButton cadastrarButton;
    private javax.swing.JFormattedTextField dataJTF;
    private javax.swing.JComboBox<String> escolaridadeJCB;
    private javax.swing.JComboBox<String> generoJComboBox;
    private javax.swing.JRadioButton inicianteC;
    private javax.swing.JRadioButton inicianteGIT;
    private javax.swing.JRadioButton inicianteJS;
    private javax.swing.JRadioButton inicianteSQL;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.ButtonGroup javaScriptBG;
    private javax.swing.JButton limparJButton;
    private javax.swing.JTextField nomeCompletoJTF;
    private javax.swing.JRadioButton regularC;
    private javax.swing.JRadioButton regularGIT;
    private javax.swing.JRadioButton regularJS;
    private javax.swing.JRadioButton regularSQL;
    // End of variables declaration//GEN-END:variables
}
