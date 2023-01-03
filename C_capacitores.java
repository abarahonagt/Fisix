
package UI;

import java.text.MessageFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class C_capacitores extends javax.swing.JFrame {

    DefaultTableModel modelo0 = new DefaultTableModel();
    DefaultTableModel modelo1 = new DefaultTableModel();
    int filas0;
    int filas1;
    
    Calcular farad = new Calcular();
    
    public C_capacitores() {
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
        InterfazResultados();
        
    }
    
     public void InterfazTabla (){
    
        //se crean los espacion a usar en la tabla
        this.tb_capacitancias.setModel(modelo0);
        this.modelo0.addColumn( "C (F)" );
        this.modelo0.addColumn( "Q (C)" );
        this.modelo0.addColumn( "V (V)" );
  
    } 
    
    public void InterfazResultados(){
        //se crea tabla resultados
        this.tb_equivalencias.setModel(modelo1);
        this.modelo1.addColumn( "VT (V)" );
        this.modelo1.addColumn( "QT (C)" );
        this.modelo1.addColumn( "CT (F)" );
    }

   public void LlenadoTablaEquivalenciasParalelo(){
        
        //obtener VT
        double VT;
        VT = Double.parseDouble(String.valueOf(tb_capacitancias.getValueAt(1,2)));
        //fin de VT

        //suma de la columna carga
        double fila=0;
        double QT=0;
            
            for(int i=0; i<tb_capacitancias.getRowCount(); i++){
                fila=Double.parseDouble(String.valueOf(tb_capacitancias.getValueAt(i, 1)));
                QT+=fila;
            }
        //fin de la columna carga
        
        //calculo de CT
        double CT;
        CT= QT/VT; 
        //Fin calculo cT

        //Mostrar datos de la tabla
        this.modelo1.addRow(new Object[]{VT, QT, String.format("%.2f", CT)});

    }
   
    public void LLenadoNormal(){
        
        

        //Calculo voltaje
        double fila=0;
        double VT=0;
            
            for(int i=0; i<tb_capacitancias.getRowCount(); i++){
                fila=Double.parseDouble(String.valueOf(tb_capacitancias.getValueAt(i, 2)));
                VT+=fila;
            }
        //fin de voltaje
        
        //obtener CT
        double CT=0;
        double fila2=0;
        double aux=0;
        double sum=0;
        
        for(int i=0; i<tb_capacitancias.getRowCount(); i++){
                fila2=Double.parseDouble(String.valueOf(tb_capacitancias.getValueAt(i, 0)));
                aux= Math.pow(fila2,-1);
                sum += aux;
                CT=Math.pow(sum,-1); 
            }
        //fin de CT
        
        //obtener QT
        double QT;
        QT = CT*VT;
  
        //fin de QT
        
        this.modelo1.addRow(new Object[]{String.format("%.2f", VT), String.format("%.2f", QT), String.format("%.2f", CT)});
        
    }
    
    public void LlenadoTablaEquivalenciasSerie(){
     

        //Calculo voltaje
        double VT;
        VT = Double.parseDouble(String.valueOf(tb_capacitancias.getValueAt(0,2)));
        //fin de voltaje
        
        //obtener CT
        double CT=0;
        double fila2=0;
        double aux=0;
        double sum=0;
        
        for(int i=0; i<tb_capacitancias.getRowCount(); i++){
                fila2=Double.parseDouble(String.valueOf(tb_capacitancias.getValueAt(i, 0)));
                aux= Math.pow(fila2,-1);
                sum += aux;
                CT=Math.pow(sum,-1); 
            }
        //fin de CT
        
        //obtener QT
        double QT;
        QT = CT*VT;
  
        //fin de QT
        
        double V=0; //qt/c
        double C=1;
            for(int i=0; i<tb_capacitancias.getRowCount();i++)
            {
                C = Double.parseDouble(String.valueOf(tb_capacitancias.getValueAt(i,0)));
                V=(double)(QT/C);
                
                 //Mostrar datos de la tabla
                this.modelo0.addRow(new Object[]{String.format("%.2f",C),String.format("%.2f",QT),String.format("%.2f",V)});
                this.modelo1.addRow(new Object[]{String.format("%.2f", VT), String.format("%.2f", QT), String.format("%.2f", CT)});
            }
        
        //Mostrar datos de la tabla
        
       
        
      
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_fondo = new javax.swing.JPanel();
        lb_encabezado = new javax.swing.JLabel();
        cb_tCircuito = new RSMaterialComponent.RSComboBoxMaterial();
        cb_vCalcular = new RSMaterialComponent.RSComboBoxMaterial();
        txt_capacitancia = new RSMaterialComponent.RSTextFieldIconUno();
        txt_carga = new RSMaterialComponent.RSTextFieldIconUno();
        txt_voltaje = new RSMaterialComponent.RSTextFieldIconUno();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_capacitancias = new javax.swing.JTable();
        pn_menu = new javax.swing.JPanel();
        bt_calcular = new rojerusan.RSButtonIconI();
        bt_limpiar = new rojerusan.RSButtonIconI();
        bt_imprimir = new rojerusan.RSButtonIconI();
        bt_agregar = new rojerusan.RSButtonIconI();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_equivalencias = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fisix | Calculo de circuitos de capacitores");

        pn_fondo.setBackground(new java.awt.Color(102, 102, 102));

        lb_encabezado.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lb_encabezado.setForeground(new java.awt.Color(255, 255, 255));
        lb_encabezado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/capacitor.png"))); // NOI18N
        lb_encabezado.setText("Calculo de circuito de capacitores");
        lb_encabezado.setToolTipText("Esto solo es un titulo... no hay nada que ver aqui");

        cb_tCircuito.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elige el tipo de circuito", "Paralelo", "Serie" }));
        cb_tCircuito.setToolTipText("Selecciona el tipo de circuito a trabajar");
        cb_tCircuito.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        cb_vCalcular.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona el valor a calcular", "Voltaje (V)", "Carga (Q)", "Capacitancia (C)" }));
        cb_vCalcular.setToolTipText("Selecciona el valor que no se conoce en la ecuacion");
        cb_vCalcular.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cb_vCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_vCalcularActionPerformed(evt);
            }
        });

        txt_capacitancia.setForeground(new java.awt.Color(102, 102, 102));
        txt_capacitancia.setToolTipText("Ingresa el valor de la capacitancia (Faradios)");
        txt_capacitancia.setBorderColor(new java.awt.Color(153, 153, 153));
        txt_capacitancia.setColorIcon(new java.awt.Color(153, 153, 153));
        txt_capacitancia.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txt_capacitancia.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHEVRON_RIGHT);
        txt_capacitancia.setPlaceholder("Valor de Capacitancia (F)");

        txt_carga.setForeground(new java.awt.Color(102, 102, 102));
        txt_carga.setToolTipText("Ingresa el valor de la carga (Columbs)");
        txt_carga.setBorderColor(new java.awt.Color(153, 153, 153));
        txt_carga.setColorIcon(new java.awt.Color(153, 153, 153));
        txt_carga.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txt_carga.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHEVRON_RIGHT);
        txt_carga.setPlaceholder("Valor de la Carga (C)");

        txt_voltaje.setForeground(new java.awt.Color(102, 102, 102));
        txt_voltaje.setToolTipText("Ingresa el valor deL voltaje (V)");
        txt_voltaje.setBorderColor(new java.awt.Color(153, 153, 153));
        txt_voltaje.setColorIcon(new java.awt.Color(153, 153, 153));
        txt_voltaje.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txt_voltaje.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHEVRON_RIGHT);
        txt_voltaje.setPlaceholder("Valor del Voltaje");

        tb_capacitancias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tb_capacitancias);

        pn_menu.setBackground(new java.awt.Color(51, 51, 51));

        bt_calcular.setBackground(new java.awt.Color(51, 51, 51));
        bt_calcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calcular.png"))); // NOI18N
        bt_calcular.setToolTipText("Calcular valores equivalentes del circuito");
        bt_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_calcularActionPerformed(evt);
            }
        });

        bt_limpiar.setBackground(new java.awt.Color(51, 51, 51));
        bt_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/limpiar.png"))); // NOI18N
        bt_limpiar.setToolTipText("Limpiar la tabla");
        bt_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_limpiarActionPerformed(evt);
            }
        });

        bt_imprimir.setBackground(new java.awt.Color(51, 51, 51));
        bt_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimir.png"))); // NOI18N
        bt_imprimir.setToolTipText("Imprimir tabla en PDF");
        bt_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imprimirActionPerformed(evt);
            }
        });

        bt_agregar.setBackground(new java.awt.Color(51, 51, 51));
        bt_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar.png"))); // NOI18N
        bt_agregar.setToolTipText("Calcular valor para la resistencia actual");
        bt_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_agregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_menuLayout = new javax.swing.GroupLayout(pn_menu);
        pn_menu.setLayout(pn_menuLayout);
        pn_menuLayout.setHorizontalGroup(
            pn_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_menuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(220, Short.MAX_VALUE))
        );
        pn_menuLayout.setVerticalGroup(
            pn_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_menuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_calcular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tb_equivalencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tb_equivalencias);

        javax.swing.GroupLayout pn_fondoLayout = new javax.swing.GroupLayout(pn_fondo);
        pn_fondo.setLayout(pn_fondoLayout);
        pn_fondoLayout.setHorizontalGroup(
            pn_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_fondoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_fondoLayout.createSequentialGroup()
                        .addComponent(lb_encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(pn_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pn_fondoLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(pn_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_vCalcular, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .addComponent(txt_capacitancia, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .addComponent(txt_carga, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .addComponent(txt_voltaje, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .addComponent(cb_tCircuito, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                        .addGap(128, 128, 128)
                        .addGroup(pn_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))))
        );
        pn_fondoLayout.setVerticalGroup(
            pn_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_fondoLayout.createSequentialGroup()
                .addGroup(pn_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_fondoLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lb_encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pn_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pn_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pn_fondoLayout.createSequentialGroup()
                        .addComponent(cb_tCircuito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(cb_vCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_capacitancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_carga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_voltaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_fondoLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_fondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_vCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_vCalcularActionPerformed

    }//GEN-LAST:event_cb_vCalcularActionPerformed

    private void bt_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_calcularActionPerformed

        if (cb_tCircuito.getSelectedIndex()==1){  //1= al indice "paralelo"
            LlenadoTablaEquivalenciasParalelo();
        }

        if(cb_tCircuito.getSelectedIndex()==2){   //2= al indice "serie"
            LLenadoNormal();
            if(cb_vCalcular.getSelectedIndex()==2){
                LlenadoTablaEquivalenciasSerie();
            }
            
        }

    }//GEN-LAST:event_bt_calcularActionPerformed

    private void bt_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_limpiarActionPerformed
        int pregunta = JOptionPane.showConfirmDialog(pn_fondo, "¿Estas seguro de eliminar el contenido de la tabla?",
            "Fisix pregunta: ¿Realmente deseas hacer esto?",JOptionPane.OK_CANCEL_OPTION,QUESTION_MESSAGE);

        if(pregunta == JOptionPane.OK_OPTION){
            //limipa tabla capacitancias
            int fila = tb_capacitancias.getRowCount();
            for(int i = fila-1; i>=0; i--){
                modelo0.removeRow(i);
            }

            //limpia tabla equivalencias
            int fila1 = tb_equivalencias.getRowCount();
            for(int i = fila1-1; i>=0; i--){
                modelo1.removeRow(i);
            }
        }

        if(pregunta ==JOptionPane.CANCEL_OPTION){
            //no hara nada, igual que lo que puedes hacer para que ella vuelva a tu lado.
        }

    }//GEN-LAST:event_bt_limpiarActionPerformed

    private void bt_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_agregarActionPerformed
        String variable0 = (String)cb_tCircuito.getSelectedItem();
        String variable1 = (String)cb_vCalcular.getSelectedItem();

        if (variable0.equals("Paralelo")){

            if(variable1.equals("Voltaje (V)")){
                Double C = Double.parseDouble(txt_capacitancia.getText());
                Double Q = Double.parseDouble(txt_carga.getText());

                farad.voltaje1(C, Q);
                txt_voltaje.setText(String.valueOf(farad.voltaje1));

                this.modelo0.addRow(new Object[]{this.txt_capacitancia.getText(), this.txt_carga.getText(),
                    this.txt_voltaje.getText()});
            txt_carga.setText("");
            txt_voltaje.setText("");
            txt_capacitancia.setText("");
        }//fin if volataje

        if(variable1.equals("Carga (Q)")){
            Double C = Double.parseDouble(txt_capacitancia.getText());
            Double V = Double.parseDouble(txt_voltaje.getText());

            farad.carga(C,V);
            txt_carga.setText(String.valueOf(farad.carga));

            this.modelo0.addRow(new Object[]{this.txt_capacitancia.getText(), this.txt_carga.getText(),
                this.txt_voltaje.getText()});
        txt_carga.setText("");
        txt_voltaje.setText("");
        txt_capacitancia.setText("");
        }//fin if carga

        if(variable1.equals("Capacitancia (C)")){
            Double Q = Double.parseDouble(txt_carga.getText());
            Double V = Double.parseDouble(txt_voltaje.getText());

            farad.capacitancia(Q,V);
            txt_capacitancia.setText(String.valueOf(String.format("%.2f", farad.capacitancia)));

            this.modelo0.addRow(new Object[]{this.txt_capacitancia.getText(), this.txt_carga.getText(),
                this.txt_voltaje.getText()});
        txt_carga.setText("");
        txt_voltaje.setText("");
        txt_capacitancia.setText("");
        }//fin if capacitancia

        }//fin if paralelo

        //Inician los calculos para circuito en serie
        if(variable0.equals("Serie")){

            if(variable1.equals("Voltaje (V)")){
                Double C = Double.parseDouble(txt_capacitancia.getText());
                Double Q = Double.parseDouble(txt_carga.getText());

                farad.voltaje1(C, Q);
                txt_voltaje.setText(String.valueOf(farad.voltaje1));

                this.modelo0.addRow(new Object[]{this.txt_capacitancia.getText(), this.txt_carga.getText(),
                    this.txt_voltaje.getText()});
            txt_carga.setText("");
            txt_voltaje.setText("");
            txt_capacitancia.setText("");
        }//fin if volataje

        if(variable1.equals("Carga (Q)")){
            Double C = Double.parseDouble(txt_capacitancia.getText());
            Double V = Double.parseDouble(txt_voltaje.getText());
      
            this.modelo0.addRow(new Object[]{this.txt_capacitancia.getText(),null, this.txt_voltaje.getText()});
      
        txt_carga.setText("");
        txt_voltaje.setText("");
        txt_capacitancia.setText("");
        }//fin if carga

        if(variable1.equals("Capacitancia (C)")){
            Double Q = Double.parseDouble(txt_carga.getText());
            Double V = Double.parseDouble(txt_voltaje.getText());

            farad.capacitancia(Q,V);
            txt_capacitancia.setText(String.valueOf(String.format("%.2f", farad.capacitancia)));

            this.modelo0.addRow(new Object[]{this.txt_capacitancia.getText(), this.txt_carga.getText(),
                this.txt_voltaje.getText()});
        txt_carga.setText("");
        txt_voltaje.setText("");
        txt_capacitancia.setText("");
        }//fin if capacitancia
        }
    }//GEN-LAST:event_bt_agregarActionPerformed

    private void bt_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimirActionPerformed
 MessageFormat header = new MessageFormat("Valores del Circuito de Capacitores | FISIX UMG");
        MessageFormat footer = new MessageFormat("Proyecto Final de Fisica II | Pagina{0,number,integer}");
        
        try{
            tb_capacitancias.print(JTable.PrintMode.NORMAL,header,footer);
            tb_equivalencias.print(JTable.PrintMode.NORMAL,header,footer);
           }catch(java.awt.print.PrinterException e){
            System.err.format("Error de impresion", e.getMessage());
        }      
    }//GEN-LAST:event_bt_imprimirActionPerformed

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
            java.util.logging.Logger.getLogger(C_capacitores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(C_capacitores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(C_capacitores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(C_capacitores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new C_capacitores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonIconI bt_agregar;
    private rojerusan.RSButtonIconI bt_calcular;
    private rojerusan.RSButtonIconI bt_imprimir;
    private rojerusan.RSButtonIconI bt_limpiar;
    private RSMaterialComponent.RSComboBoxMaterial cb_tCircuito;
    private RSMaterialComponent.RSComboBoxMaterial cb_vCalcular;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_encabezado;
    private javax.swing.JPanel pn_fondo;
    private javax.swing.JPanel pn_menu;
    private javax.swing.JTable tb_capacitancias;
    private javax.swing.JTable tb_equivalencias;
    private RSMaterialComponent.RSTextFieldIconUno txt_capacitancia;
    private RSMaterialComponent.RSTextFieldIconUno txt_carga;
    private RSMaterialComponent.RSTextFieldIconUno txt_voltaje;
    // End of variables declaration//GEN-END:variables
}
