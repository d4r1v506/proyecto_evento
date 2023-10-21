import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Integer valorIngresado = 0;
    static String nombreEvento;
    static Date fechaEvento;
    static String horaInicioIngresada;
    static String horaFinIngresada;
    static Evento evento;

    public static void main(String[] args) {

        System.out.println("-------------------------------------");
        System.out.println("| Bienvenido al Sistema de Eventos  |");
        System.out.println("-------------------------------------");

        llamarMenu();

    }

    public static void llamarMenu() {
        do {
            System.out.println("1. Crar Evento");
            System.out.println("2. Crear Entrada");
            System.out.println("3. Crear Arena");
            System.out.println("4. Salir");
            System.out.print("FAVOR INGRESE UNA OPCION: ");

            if (scanner.hasNextInt()) {
                valorIngresado = scanner.nextInt();
                scanner.nextLine();
                if (valorIngresado < 1 || valorIngresado > 4) {
                    System.out.println("ERROR! Opcion no valida. Por favor, ingrese una opcion valida (1, 2, 3 o 4).");
                    System.out.println("------------------------------------------");
                }
            } else {
                System.out.println("ERROR! Entrada no valida, ingrese un numero");
                System.out.println("------------------------------------------");
                scanner.nextLine();
                valorIngresado = 0;
            }
        } while (valorIngresado < 1 || valorIngresado > 4);

        switch (valorIngresado) {
            case Constantes.OPCION_EVENTO:
                System.out.println("Vamos a crear un Evento");
                System.out.print("INGRESE EL NOMBRE DEL EVENTO: ");
                nombreEvento = scanner.nextLine();
                do {
                    do {
                        System.out.print("INGRESE LA HORA DE INICIO (HH:mm): ");
                        horaInicioIngresada = scanner.nextLine();
                    } while (!validarHoraIngresada(horaInicioIngresada));

                    do {
                        System.out.print("INGRESE LA HORA FIN (HH:mm):");
                        horaFinIngresada = scanner.nextLine();
                    } while (!validarHoraIngresada(horaFinIngresada));
                    evento = new Evento();
                    if (!evento.validarDuracionEventos(horaInicioIngresada, horaFinIngresada)) {
                        System.out.println("ERROR! la duracion del evento no puede superar las "
                                + Constantes.MAXIMA_DURACION_EVENTO + " horas");
                        System.out.println("------------------------------------------");
                    }
                } while (!evento.validarDuracionEventos(horaInicioIngresada, horaFinIngresada));
                evento.setTitulo(nombreEvento);
                evento.setHoraInicio(horaInicioIngresada);
                evento.setHoraFin(horaFinIngresada);

                if (!evento.agregar(evento)) {
                    System.out.println("Error! Solo se puede crear maximo 2 eventos");
                }
                System.out.print("salir al menu? (y/n): ");
                String salirMenu = scanner.nextLine();
                if (salirMenu.equals("y")) {
                    llamarMenu();
                } else {
                    System.out.println("saliendo del sistema... ");
                }
                break;
            case Constantes.OPCION_ENTRADA:
                System.out.println("Vamos a crear Entrada");
                break;
            case Constantes.OPCION_ARENA:
                System.out.println("Vamos a crear Arena");
                break;
            case Constantes.OPCION_SALIR:
                System.out.println("Saliendo del sistema....");
                break;
        }
        scanner.close();
    }

    public static boolean validarHoraIngresada(String hora) {
        Pattern pattern = Pattern.compile(Constantes.FORMATO_HORA);
        Matcher matcher = pattern.matcher(hora);

        if (!matcher.matches()) {
            System.out.println("Formato de hora incorrecto. Por favor, ingrese la hora en el formato HH:mm.");
            return false;
        }
        return true;
    }

}
