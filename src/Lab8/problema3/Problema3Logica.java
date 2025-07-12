package Lab8.problema3;

public class Problema3Logica {
  private String nombre;
    private int cedula;
    private double deposito;
    private double tasa;
    private int meses;
    private double intAnual;

    public Problema3Logica(String nombre, int cedula, double deposito) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.deposito = deposito;
    }

    public double getIntAnual() {
        return intAnual;
    }

    public void definirTasaAnual(int opcion) {
        switch (opcion) {
            case 1:
                meses = 12;
                tasa = 0.04;
                break;
            case 2:
                meses = 24;
                tasa = 0.045;
                break;
            case 3:
                meses = 36;
                tasa = 0.0455;
                break;
            case 4:
                meses = 48;
                tasa = 0.0475;
                break;
            case 5:
                meses = 60;
                tasa = 0.05;
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    public void calcularInteresAnual() {
        double n = meses / 12.0;
        intAnual = deposito * Math.pow(1 + tasa, n);
    }
}
