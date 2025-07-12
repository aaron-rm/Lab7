package Lab8.problema3;
import Lab8.problema3.Problema3Logica;

public class Problema3 {
  import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InteresAnual {

    private JPanel panelPrincipal;
    private JTextField txtNombre;
    private JTextField txtCedula;
    private JTextField txtMonto;

    private JButton bCalcular;
    private JLabel lbRespuesta;
    private JRadioButton rb12;
    private JRadioButton rb24;
    private JRadioButton rb36;
    private JRadioButton rb48;
    private JRadioButton rb60;
    private JButton bLimpiar;

    public InteresAnual() {

        bCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int opcion = 0;
                    if (rb12.isSelected()) opcion = 1;
                    else if (rb24.isSelected()) opcion = 2;
                    else if (rb36.isSelected()) opcion = 3;
                    else if (rb48.isSelected()) opcion = 4;
                    else if (rb60.isSelected()) opcion = 5;

                    if (opcion == 0) {
                        JOptionPane.showMessageDialog(null, "Debe seleccionar un plazo.");
                        return;
                    }

                    String nombre = txtNombre.getText();
                    String cedulaStr = txtCedula.getText();
                    String depositoStr = txtMonto.getText().trim();

                    if (nombre.isEmpty() || cedulaStr.isEmpty() || depositoStr.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
                        return;
                    }

                    if (nombre.matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "El nombre debe ser letras, no números.");
                        return;
                    }

                    if (!cedulaStr.matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "La cédula debe contener sólo números.");
                        return;
                    }

                    if (cedulaStr.length() > 12) {
                        JOptionPane.showMessageDialog(null, "La cédula no puede tener más de 12 dígitos.");
                        return;
                    }

                    int cedula = Integer.parseInt(cedulaStr);
                    double deposito;

                    try {
                        deposito = Double.parseDouble(depositoStr);
                        if (deposito < 2000) {
                            JOptionPane.showMessageDialog(null, "El depósito mínimo es B/.2000.00.");
                            return;
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Error: El depósito ingresado no es válido.");
                        return;
                    }

                    Problema3 cliente = new Problema3(nombre, cedula, deposito);
                    cliente.definirTasaAnual(opcion);
                    cliente.calcularInteresAnual();

                    lbRespuesta.setForeground(Color.BLUE);
                    lbRespuesta.setText("El interés al plazo seleccionado es B/." +
                            String.format("%.2f", cliente.getIntAnual()));

                } catch (NumberFormatException err) {
                    lbRespuesta.setForeground(Color.red);
                    lbRespuesta.setText("Error. Datos Incorrectos ");
                }
            }
        });

        bLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion = JOptionPane.showConfirmDialog(
                        null,
                        "¿Estás seguro de que deseas limpiar todos los campos?",
                        "Confirmar limpieza",
                        JOptionPane.YES_NO_OPTION
                );

                if (opcion == JOptionPane.YES_OPTION) {
                    txtNombre.setText("");
                    txtCedula.setText("");
                    txtMonto.setText("");
                    rb12.setSelected(false);
                    rb24.setSelected(false);
                    rb36.setSelected(false);
                    rb48.setSelected(false);
                    rb60.setSelected(false);
                    lbRespuesta.setText(""); 
                }
            }
        });
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
}
