/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.evilpotro.ui;

import mx.itson.evilpotro.entidades.Alumno;
import mx.itson.evilpotro.entidades.RegistroAcademico;

import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * The type Progreso academico.
 */
public class ProgresoAcademico extends javax.swing.JDialog {

    /**
     * The Id.
     */
    int id;

    /**
     * Instantiates a new Progreso academico.
     *
     * @param parent the parent 
     * @param modal  the modal 
     * @param id     the id es un numero entero asignado para el alumno 
     * El matodo permite llenar los campos del dialog
     */
    public ProgresoAcademico(java.awt.Frame parent, boolean modal, int id) {
        super(parent, modal);
        initComponents();
        this.id = id;
        cargarCampos();
    }

    /**
     * Cargar campos.
     *  Obtendra la informacion para los campos del dialog
     */
    public void cargarCampos() {
        System.out.println("Hola");
        if (id != 0) {
            try {
                Alumno alumno = Alumno.obtenerPorId(id);
                lblNombre.setText(alumno.getNombre() + " " + alumno.getApellidos());
                lblEmail.setText(alumno.getEmail());
                lblTelefono.setText(String.valueOf(alumno.getTelefono()));
                lblCampus.setText(alumno.getCampus());
                lblFechaNacimiento.setText(String.valueOf(alumno.getFechaNacimiento()));
                lblCarrera.setText(alumno.getCarrera());
                lblPromedio.setText(String.valueOf(RegistroAcademico.calcularPromedio(id)));
                lblProgreso.setText(String.valueOf(RegistroAcademico.calcularProgreso(id)));
                lblReprobadas.setText(String.valueOf(RegistroAcademico.calcularReprobadas(id)));

                List<RegistroAcademico> registrosAcademicos = RegistroAcademico.obtenerClasesPorId(id);
                DefaultTableModel modelo = (DefaultTableModel) tblMaterias.getModel();
                modelo.setRowCount(0);
                for (RegistroAcademico registro : registrosAcademicos) {
                    modelo.addRow(new Object[]{
                            registro.getCurso().getSemestre(),
                            registro.getCurso().getTitulo(),
                            registro.getCalificacion(),});
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("No hay id");
            this.dispose();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMaterias = new javax.swing.JTable();
        lblCarrera = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblProgreso = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblPromedio = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
        lblFechaNacimiento = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblCampus = new javax.swing.JLabel();
        lblNombre2 = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblReprobadas = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblMaterias.setAutoCreateRowSorter(true);
        tblMaterias.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String[]{
                        "Semestre", "Materia", "Calificación"
                }
        ));
        jScrollPane1.setViewportView(tblMaterias);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 470, 350));

        lblCarrera.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCarrera.setForeground(new java.awt.Color(255, 0, 0));
        lblCarrera.setText("ISW");
        jPanel1.add(lblCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, 70, -1));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Carrera:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, 60, -1));

        lblProgreso.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblProgreso.setForeground(new java.awt.Color(255, 0, 0));
        lblProgreso.setText("66");
        jPanel1.add(lblProgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 340, 70, -1));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Nombre del Alumno: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Promedio:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, -1, -1));

        lblPromedio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblPromedio.setForeground(new java.awt.Color(255, 0, 0));
        lblPromedio.setText("8.83");
        jPanel1.add(lblPromedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 290, 70, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Progreso:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, -1, 20));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 480, -1, -1));

        lblNombre.setForeground(new java.awt.Color(255, 0, 0));
        lblNombre.setText("Diego Castro Arce");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Correo Electronico: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        lblEmail.setForeground(new java.awt.Color(255, 0, 0));
        lblEmail.setText("diego.castro@potros.itson.edu.mx");
        jPanel1.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, -1));

        lblNombre1.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblNombre1.setForeground(new java.awt.Color(255, 0, 0));
        lblNombre1.setText("Fecha de inscripcion:");
        jPanel1.add(lblNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, -1, -1));

        lblFechaNacimiento.setForeground(new java.awt.Color(255, 0, 0));
        lblFechaNacimiento.setText("2022-15-21");
        jPanel1.add(lblFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 90, -1));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Campus:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, -1, -1));

        lblCampus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCampus.setForeground(new java.awt.Color(255, 0, 0));
        lblCampus.setText("Guaymas");
        jPanel1.add(lblCampus, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 73, -1));

        lblNombre2.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblNombre2.setForeground(new java.awt.Color(255, 0, 0));
        lblNombre2.setText("Telefono:");
        jPanel1.add(lblNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, -1, -1));

        lblTelefono.setForeground(new java.awt.Color(255, 0, 0));
        lblTelefono.setText("6221526431");
        jPanel1.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 100, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Reprobadas:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, -1, -1));

        lblReprobadas.setForeground(new java.awt.Color(255, 0, 0));
        lblReprobadas.setText("11");
        jPanel1.add(lblReprobadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 390, 70, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/itson/evilpotro/assets/evilpotro.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    /**
     * Main.
     *
     * @param args the args
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
            java.util.logging.Logger.getLogger(ProgresoAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProgresoAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProgresoAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProgresoAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProgresoAcademico dialog = new ProgresoAcademico(new javax.swing.JFrame(), true, 0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCampus;
    private javax.swing.JLabel lblCarrera;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblProgreso;
    private javax.swing.JLabel lblPromedio;
    private javax.swing.JLabel lblReprobadas;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTable tblMaterias;
    // End of variables declaration//GEN-END:variables
}
