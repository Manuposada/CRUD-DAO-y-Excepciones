package actividad1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import controller.FuncionariosController;
import data.FuncionariosDao;
import domain.Funcionarios;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.MouseEvent;




public class Ventana1 extends javax.swing.JFrame {

    private FuncionariosController funcionariosController;
    
    private void actualizarFuncionario(int idEmpleado, String columna, Object nuevoValor) {
    FuncionariosDao funcionariosDao;
    try {
        funcionariosDao = new FuncionariosDao();
        Funcionarios funcionario = funcionariosDao.obtenerFuncionarioPorID(idEmpleado);

        if (funcionario != null) {
            // Actualiza el valor en el objeto Funcionarios
            switch (columna) {
                case "Nombre/s":
                    funcionario.setNombres((String) nuevoValor);
                    break;
                case "Apellido/s":
                    funcionario.setApellidos((String) nuevoValor);
                    break;
                // Agrega más casos según las columnas que puedas actualizar
            }

            // Actualiza el funcionario en la base de datos
            funcionariosDao.actualizarFuncionario(funcionario);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "Hubo un error al actualizar el funcionario en la base de datos.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}
    
    public Ventana1() {
        initComponents();
        
        // Agrega un manejador de eventos a la tabla para detectar doble clic en las celdas
    tablaFuncionarios.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                int row = tablaFuncionarios.rowAtPoint(e.getPoint());
                int column = tablaFuncionarios.columnAtPoint(e.getPoint());

                // Obtén el ID del empleado (asumiendo que está en la primera columna)
                int idEmpleado = (int) tablaFuncionarios.getValueAt(row, 0);

                // Obtén el nombre de la columna
                String columnName = tablaFuncionarios.getColumnName(column);

                // Pide al usuario el nuevo valor
                String nuevoValor = JOptionPane.showInputDialog("Ingrese el nuevo valor para " + columnName + ":");
                
                // Actualiza el funcionario en la base de datos
                if (nuevoValor != null && !nuevoValor.isEmpty()) {
                    actualizarFuncionario(idEmpleado, columnName, nuevoValor);

                    // Actualiza la tabla en la interfaz gráfica
                    DefaultTableModel model = (DefaultTableModel) tablaFuncionarios.getModel();
                    model.setValueAt(nuevoValor, row, column);
                }
            }
        }
    });
        
        try {
        funcionariosController = new FuncionariosController();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        tfApellido = new javax.swing.JTextField();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        tfTipoDocumento = new javax.swing.JTextField();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        tfNumerodocumento = new javax.swing.JTextField();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        tfEstadoCivil = new javax.swing.JTextField();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        tfGenero = new javax.swing.JTextField();
        javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
        tfDireccion = new javax.swing.JTextField();
        javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
        tfTelefono = new javax.swing.JTextField();
        javax.swing.JLabel jLabel10 = new javax.swing.JLabel();
        tfFechaNacimiento = new javax.swing.JTextField();
        javax.swing.JButton btnCrear = new javax.swing.JButton();
        javax.swing.JButton btnBorrar = new javax.swing.JButton();
        javax.swing.JButton btnEliminar = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tablaFuncionarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Actividad1");
        setMinimumSize(new java.awt.Dimension(850, 747));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista de Funcionarios:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Funcionario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Light", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel2.setOpaque(false);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre:");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Apellido/s:");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Tipo de Documento:");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Número de Documento: ");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Estado Civil:");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Género:");

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Dirección:");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Teléfono:");

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Fecha de Nacimiento:");

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfFechaNacimiento)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfApellido)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfNombre)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfNumerodocumento)
                    .addComponent(tfTipoDocumento)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfEstadoCivil)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfGenero)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfDireccion)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfTelefono)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNumerodocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnBorrar))
                .addGap(66, 66, 66))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBorrar, btnCrear});

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        tablaFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre/s", "Apellido/s", "Tipo de Documento", "Número de Documento", "Estado Civíl", "Género", "Dirección", "Teléfono", "Fecha de Nacimiento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaFuncionarios);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actualizarTablaFuncionarios() {
    DefaultTableModel model = (DefaultTableModel) tablaFuncionarios.getModel();
    model.setRowCount(0); // Limpiar la tabla antes de agregar los nuevos datos

    try {
        // Obtener la lista actualizada de funcionarios desde la base de datos
        List<Funcionarios> funcionarios = funcionariosController.obtenerFuncionarios();

        // Agregar los funcionarios a la tabla
        for (Funcionarios funcionario : funcionarios) {
            model.addRow(new Object[] { funcionario.getIDEmpleado(), funcionario.getNombres(),
                    funcionario.getApellidos(), funcionario.getTipoIdentificacion(),
                    funcionario.getNumeroIdentificacion(), funcionario.getEstadoCivil(), funcionario.getGenero(),
                    funcionario.getDireccion(), funcionario.getTelefono(), funcionario.getFechaNacimiento() });
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al actualizar la tabla de funcionarios", "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}

    
    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        
    String NumeroDocumento = tfNumerodocumento.getText();
    String TipoDocumento = tfTipoDocumento.getText();
    String Nombres = tfNombre.getText();
    String Apellidos = tfApellido.getText();
    String EstadoCivil = tfEstadoCivil.getText();
    String Genero = tfGenero.getText();
    String Direccion = tfDireccion.getText();
    String Telefono = tfTelefono.getText();
    String FechaNacimiento = tfFechaNacimiento.getText();

    if (NumeroDocumento.isEmpty() || TipoDocumento.isEmpty() || Nombres.isEmpty() || Apellidos.isEmpty()
            || EstadoCivil.isEmpty() || Genero.isEmpty() || Direccion.isEmpty() || Telefono.isEmpty()
            || FechaNacimiento.isEmpty()) {

        JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos", "Intenta de nuevo",
                JOptionPane.ERROR_MESSAGE);

    } else {
        // Crear un nuevo objeto Funcionarios con los datos del formulario
        Funcionarios nuevoFuncionario = new Funcionarios();
        nuevoFuncionario.setNumeroIdentificacion(Integer.parseInt(NumeroDocumento));
        nuevoFuncionario.setTipoIdentificacion(TipoDocumento);
        nuevoFuncionario.setNombres(Nombres);
        nuevoFuncionario.setApellidos(Apellidos);
        nuevoFuncionario.setEstadoCivil(EstadoCivil);
        nuevoFuncionario.setGenero(Genero);
        nuevoFuncionario.setDireccion(Direccion);
        nuevoFuncionario.setTelefono(Integer.parseInt(Telefono));
        nuevoFuncionario.setFechaNacimiento(FechaNacimiento);

        // Agregar el nuevo funcionario a la base de datos
        try {
            funcionariosController.agregarFuncionario(nuevoFuncionario);
            JOptionPane.showMessageDialog(this, "Nuevo funcionario agregado correctamente", "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);

            // Actualizar la tabla de funcionarios
            actualizarTablaFuncionarios();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al agregar el funcionario a la base de datos", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_btnCrearActionPerformed

    
    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
      
        tfNumerodocumento.setText("");
        tfTipoDocumento.setText("");
        tfNombre.setText("");
        tfApellido.setText("");
        tfEstadoCivil.setText("");
        tfGenero.setText("");
        tfDireccion.setText("");
        tfTelefono.setText("");
        tfFechaNacimiento.setText("");
        
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        int row = tablaFuncionarios.getSelectedRow();
        
        if (row < 0) {
            JOptionPane.showMessageDialog(this,
                    "No se ha seleccionado ningun funcionario. Por favor selecicone alguno.",
                    "Seleccione un funcionario",
                    JOptionPane.ERROR_MESSAGE);
            
        } else {
            
            DefaultTableModel model = (DefaultTableModel) tablaFuncionarios.getModel();
        int idEmpleado = (int) model.getValueAt(row, 0); // Asumiendo que la primera columna es el ID del empleado
        model.removeRow(row);

        // Ahora llama al método eliminarFuncionario de tu FuncionariosDao
        FuncionariosDao funcionariosDao;
        try {
            funcionariosDao = new FuncionariosDao();
            funcionariosDao.eliminarFuncionario(idEmpleado);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Hubo un error al eliminar el funcionario de la base de datos.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        DefaultTableModel model = (DefaultTableModel) tablaFuncionarios.getModel();
        Vector<Vector> tableData = model.getDataVector();
        
        try {
            
            FileOutputStream file = new FileOutputStream("file.bin");
            ObjectOutputStream output = new ObjectOutputStream(file);
            
            output.writeObject(tableData);
            
            output.close();
            file.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        try {
            
            FileInputStream file = new FileInputStream("file.bin");
            ObjectInputStream input = new ObjectInputStream(file);
            
            Vector<Vector> tableData = (Vector<Vector>) input.readObject();
            
            input.close();
            file.close();
            
            DefaultTableModel model = (DefaultTableModel) tablaFuncionarios.getModel();
            for (int i = 0; i< tableData.size(); i++) {
                Vector row = tableData.get(i);
                model.addRow (new Object[] {row.get(0), row.get(1), row.get(2), row.get(3)});
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_formWindowOpened

    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable tablaFuncionarios;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfEstadoCivil;
    private javax.swing.JTextField tfFechaNacimiento;
    private javax.swing.JTextField tfGenero;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfNumerodocumento;
    private javax.swing.JTextField tfTelefono;
    private javax.swing.JTextField tfTipoDocumento;
    // End of variables declaration//GEN-END:variables
}
