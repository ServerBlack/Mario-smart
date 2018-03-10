package Vista;

import IA.*;

import java.awt.GridLayout;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ventana extends javax.swing.JFrame {

    private int[][] matriz = new int[10][10];
    private JLabel[][] matrizBotones = new JLabel[10][10];
    private ImageIcon mario;
    private int x;
    private int y;
    private int xf;
    private int yf;    

    public Ventana() throws IOException {

        super("Inteligencia artificial");
        initComponents();

        comboBoxBusqueda.addItem("Amplitud");
        comboBoxBusqueda.addItem("Costo uniforme");
        comboBoxBusqueda.addItem("Profundidad evitando ciclos");

        panelMatriz.setLayout(new GridLayout(10, 10));
        crearMatriz();
        llenarMatriz();

        estadoInicial();       
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaReporte = new javax.swing.JTextArea();
        labelReporte = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelMatrizLayout = new javax.swing.GroupLayout(panelMatriz);
        panelMatriz.setLayout(panelMatrizLayout);
        panelMatrizLayout.setHorizontalGroup(
            panelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 601, Short.MAX_VALUE)
        );
        panelMatrizLayout.setVerticalGroup(
            panelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

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

        textAreaReporte.setColumns(20);
        textAreaReporte.setRows(5);
        jScrollPane1.setViewportView(textAreaReporte);

        labelReporte.setText("Reporte");

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonRecargar)
                    .addComponent(buttonBuscar)
                    .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(comboBoxBusqueda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboBoxTipo, 0, 228, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(labelTitulo)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelBotonesLayout.createSequentialGroup()
                        .addComponent(labelReporte)
                        .addGap(78, 78, 78)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addComponent(labelReporte)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelBotones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelMatriz, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cambiarEstado(){
        
        mario = new ImageIcon("/home/ivan/NetBeansProjects/Mario-smart/Mario-smart/sources/D/6.png");
    }
    
    private void estadoInicial(){
        
        mario = new ImageIcon("/home/ivan/NetBeansProjects/Mario-smart/Mario-smart/sources/D/2.png");
    }
    
    private void meta(){
        
        mario = new ImageIcon("/home/ivan/NetBeansProjects/Mario-smart/Mario-smart/sources/D/7.png");
    }
    
    private void crearMatriz(){
        
        for(int i = 0; i < 10; i++){
            
            for(int j = 0; j < 10; j++){
                
                JLabel boton = new JLabel();
                boton.setSize(60, 60);
                matrizBotones[i][j] = boton;
                panelMatriz.add(boton);
            }
        }
    }
    
    private void llenarMatriz() throws FileNotFoundException, IOException {

        File archivo = new File("/home/ivan/NetBeansProjects/Mario-smart/Mario-smart/sources/A/Input.txt");
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);

        String linea = br.readLine();
        int j = 0;

        while (linea != null) {

            String[] values = linea.split(" ");

            for (int i = 0; i < 10; i++) { 
                                
                matriz[j][i] = Integer.parseInt(values[i]);                
                ImageIcon imagen = new ImageIcon("/home/ivan/NetBeansProjects/Mario-smart/Mario-smart/sources/D/" + values[i].charAt(0) + ".png"); 
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
        
        textAreaReporte.setText("Tiempo: " + tDiferencia + "\nNodos: " + algoritmos.getNodosExpandidos() + "\nProfundidad: " + algoritmos.getProfundidadArbol() );
    }//GEN-LAST:event_buttonBuscarMouseClicked

    private void buttonRecargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRecargarMouseClicked

        try {
            
            llenarMatriz();
            
        } catch (IOException ex){
            
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.paintAll(this.getGraphics());
        
        buttonRecargar.setEnabled(false);
        buttonBuscar.setEnabled(true);
    }//GEN-LAST:event_buttonRecargarMouseClicked

    public void hacerCamino(Nodo hoja){
        
        String camino = hoja.getCamino();
        
        if(camino.equals("F")){
            
            // Fallo.
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
                    
                    meta();
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

            buttonRecargar.setEnabled(true);
        }
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
    private javax.swing.JComboBox<String> comboBoxTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelReporte;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelMatriz;
    private javax.swing.JTextArea textAreaReporte;
    // End of variables declaration//GEN-END:variables
}
