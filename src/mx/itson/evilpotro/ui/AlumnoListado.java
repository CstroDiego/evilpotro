/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.evilpotro.ui;

import mx.itson.evilpotro.entidades.Alumno;

import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * Interfaz grafica principal de la aplicacion
 *
 * @author Julio Blanco
 * @author Alejandra Medina
 * @author Diego Castro
 */
public class AlumnoListado extends javax.swing.JFrame {

    /**
     * Inicializa los componentes de la interfaz
     */
    public AlumnoListado() {
        initComponents();
    }

    /**
     * Cargara los datos de la base de datos en los campos correspondientes
     */
    public void cargar() {
        List<Alumno> alumnos = Alumno.obtenerTodos();
        DefaultTableModel modelo = (DefaultTableModel) tblAlumnos.getModel();
        modelo.setRowCount(0);
        for (Alumno alumno : alumnos) {
            modelo.addRow(new Object[]{
                alumno.getId(),
                alumno.getNombre(),
                alumno.getApellidos(),
                alumno.getEmail(),
                alumno.getTelefono(),
                alumno.getCampus(),
                alumno.getFechaInscripcion(),
                alumno.getCarrera()
            });
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlumnos = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnProgeso = new javax.swing.JMenu();
        btnProgreso = new javax.swing.JMenuItem();
        btnEditar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/itson/evilpotro/assets/evilpotro.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellodos", "Email", "Telefono", "Campus", "Fecha de inscripción", "Carrera"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAlumnos);
        if (tblAlumnos.getColumnModel().getColumnCount() > 0) {
            tblAlumnos.getColumnModel().getColumn(0).setResizable(false);
            tblAlumnos.getColumnModel().getColumn(0).setPreferredWidth(0);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 870, 281));

        btnProgeso.setText("Alumno");

        btnProgreso.setText("Consultar progreso");
        btnProgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProgresoActionPerformed(evt);
            }
        });
        btnProgeso.add(btnProgreso);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        btnProgeso.add(btnEditar);

        jMenuBar1.add(btnProgeso);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila = tblAlumnos.getSelectedRow();
        AlumnoFormulario formulario = new AlumnoFormulario(this, true, (int) tblAlumnos.getValueAt(fila, 0));
        formulario.setVisible(true);
        cargar();

    }//GEN-LAST:event_btnEditarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargar();
        tblAlumnos.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblAlumnos.getColumnModel().getColumn(0).setMinWidth(0);
        tblAlumnos.getColumnModel().getColumn(0).setMaxWidth(0);
    }//GEN-LAST:event_formWindowOpened

    private void btnProgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProgresoActionPerformed
        int fila = tblAlumnos.getSelectedRow();
        ProgresoAcademico progreso = new ProgresoAcademico(this, true, (int) tblAlumnos.getValueAt(fila, 0));
        progreso.setVisible(true);
        cargar();
    }//GEN-LAST:event_btnProgresoActionPerformed

    /**
     * Metodo principal
     *
     * @param args Los argumentos de la linea de comandos
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
            java.util.logging.Logger.getLogger(AlumnoListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlumnoListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlumnoListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlumnoListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlumnoListado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnEditar;
    private javax.swing.JMenu btnProgeso;
    private javax.swing.JMenuItem btnProgreso;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAlumnos;
    // End of variables declaration//GEN-END:variables
}
