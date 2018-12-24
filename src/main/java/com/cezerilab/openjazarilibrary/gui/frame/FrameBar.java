/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cezerilab.openjazarilibrary.gui.frame;

import com.cezerilab.openjazarilibrary.factory.FactoryImageProcess;
import com.cezerilab.openjazarilibrary.core.CMatrix;
import com.cezerilab.openjazarilibrary.factory.FactoryUtils;
import java.awt.image.BufferedImage;
import java.io.File;
import com.cezerilab.openjazarilibrary.gui.panel.PanelBar;

/**
 *
 * @author BAP1
 */
public class FrameBar extends javax.swing.JFrame {

    private CMatrix cm;


    public FrameBar(CMatrix cm) {
        super(cm.name+"|Histogram");
        cm.name+="|Histogram";
        this.cm =cm;
        initComponents();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_plot = new com.cezerilab.openjazarilibrary.gui.panel.PanelBar(cm);
        jPanel2 = new javax.swing.JPanel();
        btn_dataGrid = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        txt_dpi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel_plot.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panel_plotLayout = new javax.swing.GroupLayout(panel_plot);
        panel_plot.setLayout(panel_plotLayout);
        panel_plotLayout.setHorizontalGroup(
            panel_plotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
        );
        panel_plotLayout.setVerticalGroup(
            panel_plotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_dataGrid.setText("Data Grid");
        btn_dataGrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dataGridActionPerformed(evt);
            }
        });

        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        txt_dpi.setText("300");

        jLabel2.setText("dpi");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btn_dataGrid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_dpi, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(363, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btn_dataGrid)
                .addComponent(btn_save)
                .addComponent(txt_dpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_plot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_plot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_dataGridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dataGridActionPerformed
        CMatrix cm = getHistogramPanel().getMatrix();
        new FrameDataGrid(cm).setVisible(true);
    }//GEN-LAST:event_btn_dataGridActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        savePanel();
    }//GEN-LAST:event_btn_saveActionPerformed

    public PanelBar getHistogramPanel() {
        return (PanelBar) panel_plot;
    }
    
    public void setHistogramData(CMatrix cmx){
        this.cm = cmx.getHistogram();
        getHistogramPanel().setMatrix(cm);
    }

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dataGrid;
    private javax.swing.JButton btn_save;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panel_plot;
    private javax.swing.JTextField txt_dpi;
    // End of variables declaration//GEN-END:variables

    private void savePanel() {
        PanelBar cp = getHistogramPanel();
        int dpi = Integer.parseInt(txt_dpi.getText());
        double scale = dpi / 96.0;
        cp.setSize((int) (cp.getWidth() * scale), (int) (cp.getHeight() * scale));
        File file = FactoryUtils.getFileFromChooser();
        if (file != null) {
            FactoryImageProcess.saveGridImage(FactoryImageProcess.getBufferedImage(getHistogramPanel()), file.getAbsolutePath());
        } else {
            FactoryUtils.showMessage("kaydedilemedi CPlotFrame.savePanel()");
        }
        cp.setSize((int) (cp.getWidth() / scale), (int) (cp.getHeight() / scale));
    }


}
