package packageprueba;

public class claseSub {
    //solo muestra horario, para saber que ingreso al paquete packageprueba, y luego a la claseSub
    public java.time.LocalTime horaActual;

    public claseSub() {
        // Inicializa la hora en el momento de crear el objeto
        this.horaActual = java.time.LocalTime.now();
    }

    public void metodoSub() {
        horaActual = java.time.LocalTime.now();
        System.out.println("Hora Actual: " + horaActual);
    }


}
