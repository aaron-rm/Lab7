package Lab7.problema1;

public class Problema1 {

    //PROBLEMA1
    String palabra = Entrada.leerPalabra();

                if (palabra == null || palabra.isEmpty()) {
        System.out.println("No se ingresó una palabra válida.");
        return;
    }

    char[] vocales = ProcesadorVocales.obtenerVocales(palabra);

                if (vocales.length == 0) {
        System.out.println("No se encontraron vocales.");
        return;
    }

    // Convertir a String[] para el JList
    String[] vocalesStr = new String[vocales.length];
                for (int i = 0; i < vocales.length; i++) {
        vocalesStr[i] = String.valueOf(vocales[i]);
    }

    // Mostrar en JList
    JFrame frame = new JFrame("Vocales Encontradas");
    JList<String> lista = new JList<>(vocalesStr);
    JScrollPane scrollPane = new JScrollPane(lista);

                frame.add(scrollPane);
                frame.setSize(300, 200);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
}
}
