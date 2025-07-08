package Lab8.problema2;

import javax.swing.*;
import java.awt.event.ActionListener;


//Imprima en un ListBox los números palíndromos que hay en un rango definido por
//el usuario. Un número palíndromo es aquel que se lee igual de izquierda a
//derecha que de derecha a izquierda. Ejemplo: 353, 12321, 9009.


public class Problema2 extends JFrame{
    private JButton botonVolver;
    private JPanel JPProblema2;
    private JButton botonSiguiente;
    private JList<Integer> list1;
    private JTextField txtInferior;
    private JTextField txtSuperior;
    private JTextArea indicaciones;
    private JLabel resultado;
    private JScrollPane JSPResultado;
    private JCheckBox checkBoxExtra;
    private DefaultListModel<Integer> listModel;

    public Problema2(){
        setTitle("Problema 2");
        setSize(720,480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(getJPProblema2());
        list1.setVisible(false);
        listModel = new DefaultListModel<>();
        resultado.setVisible(false);
        JSPResultado.setVisible(false);
        checkBoxExtra.setVisible(false);


        botonSiguiente.addActionListener(ActionListener->{
            listModel.clear();
            resultado.setVisible(false);
            JSPResultado.setVisible(false);
            try {
                int inicio = Integer.parseInt(txtInferior.getText());
                int fin = Integer.parseInt(txtSuperior.getText());

                if (inicio > fin){
                    throw new ArithmeticException();
                }

                for (int i = inicio; i <= fin; i++) {
                    if (checkBoxExtra.isSelected()){
                        if (i > -10 && i < 10){
                            continue;
                        }else if (esPalindromo(i)) {
                            listModel.addElement(i);
                        }
                    }else if (esPalindromo(i)) {
                        listModel.addElement(i);
                    }
                }
                resultado.setVisible(true);
                list1.setModel(listModel);
                list1.setVisible(true);
                JSPResultado.setVisible(true);
                checkBoxExtra.setVisible(true);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese números válidos.");
            }
            catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(null, "El límite inferior no puede ser mayor al límite superior");
            }
            catch (NullPointerException ex){
                JOptionPane.showMessageDialog(null, "No existen palindromos en este rango");
            }


        });

        botonVolver.addActionListener(ActionListener->{
            this.dispose();
        });


    }

    public JPanel getJPProblema2() {
        return JPProblema2;
    }

    private boolean esPalindromo(int n){
        String original = String.valueOf(Math.abs(n));
        String reverso = new StringBuilder(original).reverse().toString();
        return original.equals(reverso);
    }

}
