package Vista;

import IA.*;
import java.awt.GridLayout;
import java.io.*;
import java.util.logging.*;
import javax.swing.*;

public class Ventana extends javax.swing.JFrame {

    private int[][] matriz = new int[10][10];
    private JLabel[][] matrizBotones = new JLabel[10][10];
    private ImageIcon mario;
    private int x;
    private int y;
    private int xf;
    private int yf;
    private String personaje;  
    private int mundo;

    public Ventana() throws IOException {

        super("Inteligencia artificial");
        this.setResizable(false);
        initComponents();

        comboBoxBusqueda.addItem("Amplitud");
        comboBoxBusqueda.addItem("Costo uniforme");
        comboBoxBusqueda.addItem("Profundidad evitando ciclos");
        
        personaje = "M";
        mundo = 0;
        textAreaReporte.setEditable(false);
        textAreaReporte.setLineWrap(true);
        textAreaReporte.setWrapStyleWord(true);

        panelMatriz.setLayout(new GridLayout(10, 10));
        crearMatriz();
        llenarMatriz();

        estadoInicial();  
        cambiarTema();
        
        buttonRecargar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMatriz = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        comboBoxTipo = new javax.swing.JComboBox<>();
        comboBoxBusqueda = new javax.swing.JComboBox<>();
        buttonBuscar = new javax.swing.JButton();
        buttonRecargar = new javax.swing.JButton();
        labelReporte = new javax.swing.JLabel();
        comboBoxPersonaje = new javax.swing.JComboBox<>();
        comboBoxInputs = new javax.swing.JComboBox<>();
        labelTema = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaReporte = new javax.swing.JTextArea();
        label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMatriz.setBackground(new java.awt.Color(254, 254, 254));
        panelMatriz.setPreferredSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout panelMatrizLayout = new javax.swing.GroupLayout(panelMatriz);
        panelMatriz.setLayout(panelMatrizLayout);
        panelMatrizLayout.setHorizontalGroup(
            panelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        panelMatrizLayout.setVerticalGroup(
            panelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        panelBotones.setBackground(new java.awt.Color(254, 254, 254));

        labelTitulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelTitulo.setText("Mario smart");

        comboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No informada", "Informada" }));
        comboBoxTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxTipoItemStateChanged(evt);
            }
        });

        buttonBuscar.setText("Buscar");
        buttonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonBuscarMouseClicked(evt);
            }
        });

        buttonRecargar.setText("Recargar");
        buttonRecargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRecargarMouseClicked(evt);
            }
        });

        labelReporte.setText("Reporte");

        comboBoxPersonaje.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mario", "Goku" }));
        comboBoxPersonaje.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxPersonajeItemStateChanged(evt);
            }
        });

        comboBoxInputs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mundo 1", "Mundo 2", "Mundo 3", "Mundo 4", "Mundo 5" }));
        comboBoxInputs.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxInputsItemStateChanged(evt);
            }
        });

        textAreaReporte.setColumns(20);
        textAreaReporte.setRows(3);
        jScrollPane1.setViewportView(textAreaReporte);

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(labelTitulo)
                .addGap(0, 78, Short.MAX_VALUE))
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBotonesLayout.createSequentialGroup()
                        .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBotonesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(buttonRecargar)
                                        .addComponent(buttonBuscar)
                                        .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(comboBoxBusqueda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(comboBoxTipo, 0, 228, Short.MAX_VALUE)))
                                    .addComponent(comboBoxPersonaje, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboBoxInputs, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelTema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panelBotonesLayout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(labelReporte)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(labelTitulo)
                .addGap(33, 33, 33)
                .addComponent(comboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comboBoxBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonRecargar)
                .addGap(18, 18, 18)
                .addComponent(comboBoxPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelTema, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(comboBoxInputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelReporte)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(panelMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelMatriz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cambiarEstado(){
        
        mario = new ImageIcon("/home/ivanmtoroc/NetBeansProjects/Mario-smart/Mario-smart/sources/" + personaje + "/6.png");                
    }
    
    private void cambiarTema(){
        
        labelTema.setIcon(new ImageIcon("/home/ivanmtoroc/NetBeansProjects/Mario-smart/Mario-smart/sources/" + personaje + "/10.png"));
    
        if(personaje.equals("D")){
            
            labelTitulo.setText("Goku smart");
        }        
        else {
            
            labelTitulo.setText("Mario smart");
        }
    }
    
    private void estadoInicial(){
        
        mario = new ImageIcon("/home/ivanmtoroc/NetBeansProjects/Mario-smart/Mario-smart/sources/" + personaje + "/2.png");
    }
    
    private void meta(boolean estado){
        
        if(estado){
         
            mario = new ImageIcon("/home/ivanmtoroc/NetBeansProjects/Mario-smart/Mario-smart/sources/" + personaje + "/7.png");
        }
        else {
                    
            mario = new ImageIcon("/home/ivanmtoroc/NetBeansProjects/Mario-smart/Mario-smart/sources/" + personaje + "/8.png");
        }
    }
    
    private void crearMatriz(){
        
        for(int i = 0; i < 10; i++){
            
            for(int j = 0; j < 10; j++){
                
                JLabel boton = new JLabel();
                matrizBotones[i][j] = boton;
                panelMatriz.add(boton);
            }
        }
    }
    
    private void llenarMatriz() throws FileNotFoundException, IOException {

        File archivo = new File("/home/ivanmtoroc/NetBeansProjects/Mario-smart/Mario-smart/sources/A/Input" + mundo +".txt");
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);

        String linea = br.readLine();
        int j = 0;

        while (linea != null) {

            String[] values = linea.split(" ");

            for (int i = 0; i < 10; i++) { 
                                
                matriz[j][i] = Integer.parseInt(values[i]);                
                ImageIcon imagen = new ImageIcon("/home/ivanmtoroc/NetBeansProjects/Mario-smart/Mario-smart/sources/" + personaje + "/" + values[i].charAt(0) + ".png"); 
                matrizBotones[j][i].setIcon(imagen);                

                if (matriz[j][i] == 2) {

                    x = j;
                    y = i;
                }
                
                if (matriz[j][i] == 5) {

                    xf = j;
                    yf = i;
                }
            }

            linea = br.readLine();
            j++;
        }
        
        estadoInicial();
    }

    private void comboBoxTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxTipoItemStateChanged

        comboBoxBusqueda.removeAllItems();

        if (comboBoxTipo.getSelectedIndex() == 0) {

            comboBoxBusqueda.addItem("Amplitud");
            comboBoxBusqueda.addItem("Costo uniforme");
            comboBoxBusqueda.addItem("Profundidad evitando ciclos");
        } else {

            comboBoxBusqueda.addItem("Avara");
            comboBoxBusqueda.addItem("A*");
        }
    }//GEN-LAST:event_comboBoxTipoItemStateChanged

    private void buttonBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonBuscarMouseClicked

        buttonBuscar.setEnabled(false);        

        Busqueda algoritmos = new Busqueda(matriz);
        Nodo hoja;
        
        long tInicio = System.currentTimeMillis();
        
        if (comboBoxTipo.getSelectedIndex() == 0){

            if (comboBoxBusqueda.getSelectedIndex() == 0){

                hoja = algoritmos.amplitud(x, y);
            }
            
            else if (comboBoxBusqueda.getSelectedIndex() == 1){

                hoja = algoritmos.costoUniforme(x, y);
            }
            
            else {

                hoja = algoritmos.profundidad(x, y);
            }            
        }
        
        else {

            if (comboBoxBusqueda.getSelectedIndex() == 0){

                hoja = algoritmos.avara(x, y, xf, yf);
            }
            
            else {

                hoja = algoritmos.aEstrella(x, y, xf, yf);               
            }           
        }
        
        long tFinal = System.currentTimeMillis();
        hacerCamino(hoja);
        long tDiferencia = tFinal - tInicio;
        
        textAreaReporte.setText(" Tiempo de computo: " + tDiferencia + " ms.\n Nodos expandidos: " + algoritmos.getNodosExpandidos() + ".\n Profundidad del arbol: " + algoritmos.getProfundidadArbol() + ".");
    }//GEN-LAST:event_buttonBuscarMouseClicked

    private void buttonRecargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRecargarMouseClicked

        recargar();
    }//GEN-LAST:event_buttonRecargarMouseClicked

    private void comboBoxPersonajeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxPersonajeItemStateChanged
        
        if(comboBoxPersonaje.getSelectedIndex() == 0){
            
            personaje = "M";
        }
        else {
            
            personaje = "D";
        }
        
        cambiarTema();
        recargar();        
    }//GEN-LAST:event_comboBoxPersonajeItemStateChanged

    private void comboBoxInputsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxInputsItemStateChanged
        
        if(comboBoxInputs.getSelectedIndex() == 0){
            
            mundo = 0;
        }
        else if(comboBoxInputs.getSelectedIndex() == 1){
            mundo = 1;
        }
        else if(comboBoxInputs.getSelectedIndex() == 2){
            mundo = 2;
        }
        else if(comboBoxInputs.getSelectedIndex() == 3){
            mundo = 3;
        }
        else {
            mundo = 4;
        }
        
        recargar();
        
    }//GEN-LAST:event_comboBoxInputsItemStateChanged

    public void recargar(){
        
        try {
            llenarMatriz();
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.paintAll(this.getGraphics());
        
        buttonRecargar.setEnabled(false);
        buttonBuscar.setEnabled(true);
        textAreaReporte.setText("");
    }
    
    public void hacerCamino(Nodo hoja){
        
        String camino = hoja.getCamino();
        
        if(camino.equals("F")){
                       
            textAreaReporte.setText(" Se presento una falla, no existe un camino.");
        }
        
        else {

            String[] values = camino.split(",");

            for (int i = 0; i < values.length; i++){

                matrizBotones[x][y].setIcon(null);
                
                if (values[i].equals("U")) {

                    x--;
                }                 
                else if (values[i].equals("D")) {

                    x++;
                }                 
                else if (values[i].equals("R")) {

                    y++;
                }                
                else {

                    y--;
                }
                
                if(matriz[x][y] == 3){
                    
                    cambiarEstado();
                }
                
                if(matriz[x][y] == 5){
                    
                    meta(hoja.getEstado());
                }
                
                matrizBotones[x][y].setIcon(mario);

                try {

                    Thread.sleep(1000);
                }                 
                catch (InterruptedException ex){

                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }

                this.paintAll(this.getGraphics());
            }            
        }
        
        buttonRecargar.setEnabled(true);
    }        

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

                    new Ventana().setVisible(true);
                } catch (IOException ex) {

                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JButton buttonRecargar;
    private javax.swing.JComboBox<String> comboBoxBusqueda;
    private javax.swing.JComboBox<String> comboBoxInputs;
    private javax.swing.JComboBox<String> comboBoxPersonaje;
    private javax.swing.JComboBox<String> comboBoxTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel labelReporte;
    private javax.swing.JLabel labelTema;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelMatriz;
    private javax.swing.JTextArea textAreaReporte;
    // End of variables declaration//GEN-END:variables
}