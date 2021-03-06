/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.philips.cn.hr.pps;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.Arrays;

/**
 * @author 310095504
 */
public class App extends javax.swing.JFrame {

    /**
     * Creates new form App
     */
    public App() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        uploadBtn1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        filePath1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        filePath2 = new javax.swing.JTextField();
        uploadBtn2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        saveToPath = new javax.swing.JTextField();
        saveToBtn = new javax.swing.JButton();
        startCaclBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Philips China PPS Automation");
        setType(java.awt.Window.Type.UTILITY);

        uploadBtn1.setText("choose");
        uploadBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadBtn1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Employee basic salary file");

        jLabel2.setText("Employee AI file");

        uploadBtn2.setText("choose");
        uploadBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadBtn2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Save to");

        saveToBtn.setText("choose");
        saveToBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveToBtnActionPerformed(evt);
            }
        });

        startCaclBtn.setText("Start Calculation...");
        startCaclBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startCaclBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(startCaclBtn))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(72, 72, 72)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3))
                                                .addGap(42, 42, 42)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(filePath1)
                                                        .addComponent(filePath2)
                                                        .addComponent(saveToPath, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(uploadBtn1)
                                        .addComponent(uploadBtn2)
                                        .addComponent(saveToBtn))
                                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(filePath1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(uploadBtn1))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(filePath2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(uploadBtn2)))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(saveToPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(saveToBtn))
                                .addGap(36, 36, 36)
                                .addComponent(startCaclBtn)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void uploadBtn1ActionPerformed(java.awt.event.ActionEvent evt) {
        File file = chooseFile(filter, JFileChooser.FILES_ONLY);
        if (file != null) {
            this.filePath1.setText(file.getAbsolutePath());
        }
    }

    private void uploadBtn2ActionPerformed(java.awt.event.ActionEvent evt) {
        File file = chooseFile(filter, JFileChooser.FILES_ONLY);
        if (file != null) {
            this.filePath2.setText(file.getAbsolutePath());
        }
    }

    private void saveToBtnActionPerformed(java.awt.event.ActionEvent evt) {
        File file = chooseFile(JFileChooser.DIRECTORIES_ONLY);
        if (file != null) {
            this.saveToPath.setText(file.getAbsolutePath());
        }
    }

    private void startCaclBtnActionPerformed(java.awt.event.ActionEvent evt) {

        String f1 = this.filePath1.getText();
        String f2 = this.filePath2.getText();
        String saveTo = this.saveToPath.getText();

        StringBuffer message = new StringBuffer();

        if (!isInputValidate(f1, f2, saveTo)) {
            message.append("file path null is not allowed");
            JOptionPane.showMessageDialog(null, message);
//            System.exit(0);
            return;
        }

        System.out.println("going to execute application with parameters " + Arrays.asList(f1, f2, saveTo));

        JobExecution jobExecution = null;

        try {
            jobExecution = Application.execute(f1, f2, saveTo, false);
        } catch (Exception e) {
            e.printStackTrace();
            message.append(e.getMessage());
            JOptionPane.showMessageDialog(null, message);
            return;
        }

        if (jobExecution.getExitStatus().equals(ExitStatus.COMPLETED)) {
            //job completed;
            message.append("Job execution completed ,Please verify generated files in " );
            message.append(saveTo);
            JOptionPane.showMessageDialog(null, message);

        } else {
//            for (Throwable exception : jobExecution.getAllFailureExceptions()) {
//                message.append("cause:" + exception.getCause()).append("message " + exception.getMessage());
//            }
//            JOptionPane.showMessageDialog(null, message);

            for (StepExecution stepExecution:jobExecution.getStepExecutions()){
                if(!stepExecution.getExitStatus().equals(ExitStatus.COMPLETED)){
                    message.append(stepExecution.getFailureExceptions());
                    message.append(" occurred when executing ");
                    message.append(stepExecution.getStepName());
                    break;
                }
            }

            JOptionPane.showMessageDialog(null, message);
        }

//        System.exit(0);don't exit;
        return;


    }

    private boolean isInputValidate(String f1, String f2, String s) {
        if (f1 == null || f1 == "" || f2 == null || f2 == "" || s == null || s == "") {
            return false;
        } else
            return true;
    }

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
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    //    private javax.swing.JFileChooser fc = new javax.swing.JFileChooser();
    JFileChooser fc = new JFileChooser();

    String perferredDir = null;

    FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");

    private File chooseFile(int selectionMode) {
        return chooseFile(null, selectionMode);
    }

    private File chooseFile(FileNameExtensionFilter filter, int selectionMode) {

        if (filter != null) {
            fc.setFileFilter(filter);
        }

        fc.setFileSelectionMode(selectionMode);

        if (this.perferredDir != null) {
            fc.setSelectedFile(new File(this.perferredDir));
        }

        if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {

            File file = fc.getSelectedFile();
            this.perferredDir = file.getAbsolutePath();
            return file;
        }

        return null;

    }

    // Variables declaration - do not modify
    private javax.swing.JTextField filePath1;
    private javax.swing.JTextField filePath2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton saveToBtn;
    private javax.swing.JTextField saveToPath;
    private javax.swing.JButton startCaclBtn;
    private javax.swing.JButton uploadBtn1;
    private javax.swing.JButton uploadBtn2;
    // End of variables declaration                   
}
