
package UI;

import java.text.MessageFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Abner
 */
public class C_RLC extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo1 = new DefaultTableModel();
    int filas;
    int filas1;
    
    Calcular RLC = new Calcular(); 
    
    public C_RLC() {
        initComponents();
        
        //edicion de ventana circuito
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono_principal.png")).getImage());
        this.setLocationRelativeTo(this);
        rsutilities.RSUtilities.setCentrarVentana(this);
        rsutilities.RSUtilities.setMoverVentana(this);
        rsutilities.RSUtilities.setOpaqueVentana(this, false);
        this.dispose();
        //fin de la edicion de ventana circuito
        
        InterfazTabla();
        InterfazTabla2();
    }
  
    public void InterfazTabla (){

        //se crean los espacion a usar en la tabla
        this.tb_RLC.setModel(modelo);
        this.modelo.addColumn( "V (V)" );
        this.modelo.addColumn( "Freq (φ)" );
        this.modelo.addColumn( "R (Ω)" );
        this.modelo.addColumn( "L (H)" );
        this.modelo.addColumn( "C (F)" );
        this.modelo.addColumn( "XL (Ω)" );
        this.modelo.addColumn( "XC (Ω)" );
        this.modelo.addColumn( "Z (Ω)" );
        this.modelo.addColumn( "I (A)" );
        this.modelo.addColumn( "ω" );
        this.modelo.addColumn( "θ (°)" );
    } 
    public void InterfazTabla2 (){

        //se crean los espacion a usar en la tabla
        this.tb_RLC2.setModel(modelo1);
        this.modelo1.addColumn( "IR (A)" );
        this.modelo1.addColumn( "IL (A)" );
        this.modelo1.addColumn( "IC (A)" );
        this.modelo1.addColumn( "VR (V)" );
        this.modelo1.addColumn( "VL (V)" );
        this.modelo1.addColumn( "VC (V)" );      
    }
    
    public void LlenarTabla2(){
        
            Double V = Double.parseDouble(txt_voltaje.getText());
            Double Freq = Double.parseDouble(txt_frecuencia.getText());
            Double R = Double.parseDouble(txt_resistencia.getText());
            Double L = Double.parseDouble(txt_inductancia.getText());
            Double C = Double.parseDouble(txt_capacitancia.getText());
            
            RLC.VR(R);
            RLC.VL(L);
            RLC.VC(C);
        this.modelo1.addRow(new Object[]{String.format("%.2f",RLC.IR), String.format("%.2f", RLC.IL), String.format("%.2f", RLC.IC),
                                this.txt_voltaje.getText(),this.txt_voltaje.getText(),this.txt_voltaje.getText()});
    }
    
    public void LlenarTabla3(){
        
            Double V = Double.parseDouble(txt_voltaje.getText());
            Double Freq = Double.parseDouble(txt_frecuencia.getText());
            Double R = Double.parseDouble(txt_resistencia.getText());
            Double L = Double.parseDouble(txt_inductancia.getText());
            Double C = Double.parseDouble(txt_capacitancia.getText());
            
            RLC.VR(R);
            RLC.VL(L);
            RLC.VC(C);
        this.modelo1.addRow(new Object[]{String.format("%.2f",RLC.I), String.format("%.2f", RLC.I), String.format("%.2f", RLC.I),
                                String.format("%.2f",RLC.VR),String.format("%.2f",RLC.VL),String.format("%.2f",RLC.VC)});
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_fondo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lb_encabezado = new javax.swing.JLabel();
        bt_limpiar1 = new rojerusan.RSButtonIconI();
        bt_imprimir1 = new rojerusan.RSButtonIconI();
        bt_agregar1 = new rojerusan.RSButtonIconI();
        cb_tCircuito = new RSMaterialComponent.RSComboBoxMaterial();
        txt_voltaje = new RSMaterialComponent.RSTextFieldIconUno();
        txt_frecuencia = new RSMaterialComponent.RSTextFieldIconUno();
        txt_resistencia = new RSMaterialComponent.RSTextFieldIconUno();
        txt_inductancia = new RSMaterialComponent.RSTextFieldIconUno();
        txt_capacitancia = new RSMaterialComponent.RSTextFieldIconUno();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_RLC = new javax.swing.JTable();
        lb_onda = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_RLC2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fisix | Circuitos RLC");

        pn_fondo.setBackground(new java.awt.Color(0, 102, 102));

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        lb_encabezado.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lb_encabezado.setForeground(new java.awt.Color(255, 255, 255));
        lb_encabezado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/circuito.png"))); // NOI18N
        lb_encabezado.setText("Fisix | Circuitos RLC ");
        lb_encabezado.setToolTipText("Es otro titulo mas, no le busques tres patas al gato >:/");

        bt_limpiar1.setBackground(new java.awt.Color(0, 51, 51));
        bt_limpiar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/limpiar.png"))); // NOI18N
        bt_limpiar1.setToolTipText("Limpiar la tabla");
        bt_limpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_limpiar1ActionPerformed(evt);
            }
        });

        bt_imprimir1.setBackground(new java.awt.Color(0, 51, 51));
        bt_imprimir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimir.png"))); // NOI18N
        bt_imprimir1.setToolTipText("Imprimir tabla en PDF");
        bt_imprimir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imprimir1ActionPerformed(evt);
            }
        });

        bt_agregar1.setBackground(new java.awt.Color(0, 51, 51));
        bt_agregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calcular.png"))); // NOI18N
        bt_agregar1.setToolTipText("Calcular valor actual");
        bt_agregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_agregar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lb_encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_agregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_limpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_imprimir1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_agregar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_imprimir1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_limpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lb_encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        cb_tCircuito.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona el tipo de circuito", "Paralelo", "Serie" }));
        cb_tCircuito.setToolTipText("¿En serio necesitas mas explicaciones? Por eso te dejo tu novia.");
        cb_tCircuito.setColorMaterial(new java.awt.Color(0, 102, 102));
        cb_tCircuito.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txt_voltaje.setForeground(new java.awt.Color(51, 51, 51));
        txt_voltaje.setToolTipText("Ingresa el voltaje total del circuito");
        txt_voltaje.setBorderColor(new java.awt.Color(0, 153, 153));
        txt_voltaje.setColorIcon(new java.awt.Color(0, 153, 153));
        txt_voltaje.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txt_voltaje.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHEVRON_RIGHT);
        txt_voltaje.setPlaceholder("Ingresa el voltaje (ε)");

        txt_frecuencia.setForeground(new java.awt.Color(51, 51, 51));
        txt_frecuencia.setToolTipText("Ingresa la frecuencia (φ)");
        txt_frecuencia.setBorderColor(new java.awt.Color(0, 153, 153));
        txt_frecuencia.setColorIcon(new java.awt.Color(0, 153, 153));
        txt_frecuencia.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txt_frecuencia.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHEVRON_RIGHT);
        txt_frecuencia.setPlaceholder("Ingresa la frecuencia (φ)");

        txt_resistencia.setForeground(new java.awt.Color(51, 51, 51));
        txt_resistencia.setToolTipText("Ingresa el valor de la Resistencia (Ω)");
        txt_resistencia.setBorderColor(new java.awt.Color(0, 153, 153));
        txt_resistencia.setColorIcon(new java.awt.Color(0, 153, 153));
        txt_resistencia.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txt_resistencia.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHEVRON_RIGHT);
        txt_resistencia.setPlaceholder("Ingresa la resistencia (Ω)");

        txt_inductancia.setForeground(new java.awt.Color(51, 51, 51));
        txt_inductancia.setToolTipText("Ingresa el valor de la inductancia (H)");
        txt_inductancia.setBorderColor(new java.awt.Color(0, 153, 153));
        txt_inductancia.setColorIcon(new java.awt.Color(0, 153, 153));
        txt_inductancia.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txt_inductancia.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHEVRON_RIGHT);
        txt_inductancia.setPlaceholder("Ingresa la inductancia (H)");

        txt_capacitancia.setForeground(new java.awt.Color(51, 51, 51));
        txt_capacitancia.setToolTipText("Ingresa el valor de la capacitancia (F)");
        txt_capacitancia.setBorderColor(new java.awt.Color(0, 153, 153));
        txt_capacitancia.setColorIcon(new java.awt.Color(0, 153, 153));
        txt_capacitancia.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txt_capacitancia.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHEVRON_RIGHT);
        txt_capacitancia.setPlaceholder("Ingresa la capacitancia (F)");

        tb_RLC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tb_RLC);

        lb_onda.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lb_onda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/onda.png"))); // NOI18N
        lb_onda.setToolTipText("Efecto predominante");

        tb_RLC2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tb_RLC2);

        javax.swing.GroupLayout pn_fondoLayout = new javax.swing.GroupLayout(pn_fondo);
        pn_fondo.setLayout(pn_fondoLayout);
        pn_fondoLayout.setHorizontalGroup(
            pn_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pn_fondoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pn_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(pn_fondoLayout.createSequentialGroup()
                        .addComponent(cb_tCircuito, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pn_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_voltaje, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(txt_inductancia, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pn_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pn_fondoLayout.createSequentialGroup()
                                .addComponent(txt_frecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_resistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pn_fondoLayout.createSequentialGroup()
                                .addComponent(txt_capacitancia, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lb_onda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jScrollPane2))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        pn_fondoLayout.setVerticalGroup(
            pn_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_fondoLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pn_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cb_tCircuito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_voltaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_frecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_resistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pn_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_inductancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_capacitancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_onda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pn_fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_limpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_limpiar1ActionPerformed
        int pregunta = JOptionPane.showConfirmDialog(pn_fondo, "¿Estas seguro de eliminar el contenido de la tabla?",
            "Fisix pregunta: ¿Realmente deseas hacer esto?",JOptionPane.OK_CANCEL_OPTION,QUESTION_MESSAGE);

        if(pregunta == JOptionPane.OK_OPTION){
            //limipa tabla capacitancias
            int fila = tb_RLC.getRowCount();
            for(int i = fila-1; i>=0; i--){
                modelo.removeRow(i);
            }
            
            int fila1 = tb_RLC2.getRowCount();
            for(int i = fila1-1; i>=0; i--){
                modelo1.removeRow(i);
            }

        }

        if(pregunta ==JOptionPane.CANCEL_OPTION){
            //no hara nada, igual que lo que puedes hacer para que ella vuelva a tu lado.
        }
    }//GEN-LAST:event_bt_limpiar1ActionPerformed

    private void bt_imprimir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimir1ActionPerformed
        MessageFormat header = new MessageFormat("Valores del Circuito RLC | FISIX UMG");
        MessageFormat footer = new MessageFormat("Proyecto Final de Fisica II | Pagina{0,number,integer}");

        try{
            tb_RLC.print(JTable.PrintMode.NORMAL,header,footer);
            tb_RLC.print(JTable.PrintMode.NORMAL,header,footer);
        }catch(java.awt.print.PrinterException e){
            System.err.format("Error de impresion", e.getMessage());
        }
    }//GEN-LAST:event_bt_imprimir1ActionPerformed

    private void bt_agregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_agregar1ActionPerformed
        String variable = (String)cb_tCircuito.getSelectedItem();
        

        if (variable.equals("Paralelo")){
            
            Double V = Double.parseDouble(txt_voltaje.getText());
            Double Freq = Double.parseDouble(txt_frecuencia.getText());
            Double R = Double.parseDouble(txt_resistencia.getText());
            Double L = Double.parseDouble(txt_inductancia.getText());
            Double C = Double.parseDouble(txt_capacitancia.getText());
            
            RLC.w(Freq);
            RLC.xl(L);
            RLC.xc(C);
            RLC.IT(V,R); 
            RLC.Z(R);
            
            if(RLC.IC > RLC.IL){
                lb_onda.setText("Circuito capacitivo");
            }else{
                lb_onda.setText("Circuito inductivo");
            }
                        
            this.modelo.addRow(new Object[]{this.txt_voltaje.getText(), this.txt_frecuencia.getText(), this.txt_resistencia.getText(),
                               this.txt_inductancia.getText(), this.txt_capacitancia.getText(),String.format("%.2f", RLC.xl),String.format("%.2f", RLC.xc),
                               String.format("%.2f", RLC.Z), String.format("%.2f", RLC.IT),String.format("%.2f", RLC.w),String.format("%.2f", RLC.angulo)});
           
            LlenarTabla2();
            
        }//fin if paralelo

        //Inician los calculos para circuito en serie
        if(variable.equals("Serie")){
            
            Double V = Double.parseDouble(txt_voltaje.getText());
            Double Freq = Double.parseDouble(txt_frecuencia.getText());
            Double R = Double.parseDouble(txt_resistencia.getText());
            Double L = Double.parseDouble(txt_inductancia.getText());
            Double C = Double.parseDouble(txt_capacitancia.getText());
            
            RLC.w(Freq);
            RLC.xl(L);
            RLC.xc(C); 
            RLC.Z(R);
            RLC.I(V);
            
            if(RLC.IC > RLC.IL){
                lb_onda.setText("Circuito capacitivo");
            }else{
                lb_onda.setText("Circuito inductivo");
            }
                        
            this.modelo.addRow(new Object[]{this.txt_voltaje.getText(), this.txt_frecuencia.getText(), this.txt_resistencia.getText(),
                               this.txt_inductancia.getText(), this.txt_capacitancia.getText(),String.format("%.2f", RLC.xl),String.format("%.2f", RLC.xc),
                               String.format("%.2f", RLC.Z), String.format("%.2f", RLC.I),String.format("%.2f", RLC.w),String.format("%.2f", RLC.angulo1)});
           
            LlenarTabla3();
            
        }
    }//GEN-LAST:event_bt_agregar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(C_RLC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(C_RLC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(C_RLC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(C_RLC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new C_RLC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonIconI bt_agregar1;
    private rojerusan.RSButtonIconI bt_imprimir1;
    private rojerusan.RSButtonIconI bt_limpiar1;
    private RSMaterialComponent.RSComboBoxMaterial cb_tCircuito;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_encabezado;
    private javax.swing.JLabel lb_onda;
    private javax.swing.JPanel pn_fondo;
    private javax.swing.JTable tb_RLC;
    private javax.swing.JTable tb_RLC2;
    private RSMaterialComponent.RSTextFieldIconUno txt_capacitancia;
    private RSMaterialComponent.RSTextFieldIconUno txt_frecuencia;
    private RSMaterialComponent.RSTextFieldIconUno txt_inductancia;
    private RSMaterialComponent.RSTextFieldIconUno txt_resistencia;
    private RSMaterialComponent.RSTextFieldIconUno txt_voltaje;
    // End of variables declaration//GEN-END:variables
}
