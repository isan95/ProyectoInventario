/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author POLANCO
 */
public class GenerateCheckIn extends javax.swing.JPanel {

    /**
     * Creates new form GenerateCheckIn
     */
    public GenerateCheckIn() {
        initComponents();
    }

    public JTable getjTableProductCheckIn() {
        return jTableProductCheckIn;
    }

    public void setjTableProductCheckIn(JTable jTableProductCheckIn) {
        this.jTableProductCheckIn = jTableProductCheckIn;
    }

    public JTextField getjTextClient() {
        return jTextClient;
    }

    public void setjTextClient(JTextField jTextClient) {
        this.jTextClient = jTextClient;
    }

    public JTextField getjTextData() {
        return jTextData;
    }

    public void setjTextData(JTextField jTextData) {
        this.jTextData = jTextData;
    }

    public JTextField getjTextIVA() {
        return jTextIVA;
    }

    public void setjTextIVA(JTextField jTextIVA) {
        this.jTextIVA = jTextIVA;
    }

    public JTextField getjTextNCheckIn() {
        return jTextNCheckIn;
    }

    public void setjTextNCheckIn(JTextField jTextNCheckIn) {
        this.jTextNCheckIn = jTextNCheckIn;
    }

    public JTextField getjTextNIT() {
        return jTextNIT;
    }

    public void setjTextNIT(JTextField jTextNIT) {
        this.jTextNIT = jTextNIT;
    }

    public JTextField getjTextSubTotal() {
        return jTextSubTotal;
    }

    public void setjTextSubTotal(JTextField jTextSubTotal) {
        this.jTextSubTotal = jTextSubTotal;
    }

    public JTextField getjTextTotal() {
        return jTextTotal;
    }

    public void setjTextTotal(JTextField jTextTotal) {
        this.jTextTotal = jTextTotal;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductCheckIn = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextClient = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextData = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextNCheckIn = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextSubTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextIVA = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextNIT = new javax.swing.JTextField();

        jTableProductCheckIn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cant", "Producto", "Prec. unit", "Prec. tot"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProductCheckIn.setAutoscrolls(false);
        jScrollPane1.setViewportView(jTableProductCheckIn);
        jTableProductCheckIn.getAccessibleContext().setAccessibleParent(null);

        jLabel1.setText("Cliente");

        jTextClient.setEditable(false);

        jLabel2.setText("Fecha");

        jTextData.setEditable(false);

        jLabel3.setText("N° Factura");

        jTextNCheckIn.setEditable(false);

        jLabel4.setText("Subtotal");

        jTextSubTotal.setEditable(false);

        jLabel5.setText("IVA");

        jTextIVA.setEditable(false);

        jLabel6.setText("Total");

        jTextTotal.setEditable(false);

        jLabel7.setText("Nit");

        jTextNIT.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextClient, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextNCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextData)
                            .addComponent(jTextNIT, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextSubTotal)
                            .addComponent(jTextIVA)
                            .addComponent(jTextTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextNCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextNIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jTextIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProductCheckIn;
    private javax.swing.JTextField jTextClient;
    private javax.swing.JTextField jTextData;
    private javax.swing.JTextField jTextIVA;
    private javax.swing.JTextField jTextNCheckIn;
    private javax.swing.JTextField jTextNIT;
    private javax.swing.JTextField jTextSubTotal;
    private javax.swing.JTextField jTextTotal;
    // End of variables declaration//GEN-END:variables
}