import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Evento {

    private Date fechaEvento;
    private String horaInicio;
    private String horaFin;
    private String titulo;
    private Arena arena;
    private long diferenciaHoras;
    private Duration duracion;
    static Integer contadorEventos = 0;  

    public boolean agregar(Evento evento) {
       
        contadorEventos++;
        if(contadorEventos<=Constantes.MAXIMA_EVENTOS_DIA){            
            System.out.println("Se creo correctamente el Evento !!");                   
            System.out.println("--------------RESUMEN--------------------");
            System.out.println("Nombre del evento: "+evento.getTitulo());
            System.out.println("Hora inicio: "+evento.getHoraInicio());
            System.out.println("Hora fin: "+evento.getHoraFin());
            System.out.println("Eventos creados: "+contadorEventos);
            System.out.println("------------------------------------------");
            return true;
        }else{
            return false;
        }

       

        
    }

    public void eliminar(Integer idEvento) {
        // logica para aliminar evento
    }

    public void actualizarEvento(Integer idEvento, Object evento) {
        // logica para atualizar evento
    }

    private boolean validarCantidadEventos(Date fecha) {

        // logica para validarCantidad de eventos
        return true;
    }

    public boolean validarDuracionEventos(String horaInicioIngresada, String horaFinIngresada) {  
        try{
            LocalTime horaInicio = LocalTime.parse(horaInicioIngresada);                    
            LocalTime horaFin = LocalTime.parse(horaFinIngresada);        
            diferenciaHoras = ChronoUnit.HOURS.between(horaInicio, horaFin);
            duracion = Duration.between(horaInicio, horaFin);

            return duracion.toHours() <= Constantes.MAXIMA_DURACION_EVENTO;
            
        }catch(DateTimeParseException e){
            return false;
        }        
    }

    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getHoraInicio(){
        return horaInicio;
    }
    public void setHoraInicio(String horaInicio){
        this.horaInicio = horaInicio;
    }
     public String getHoraFin(){
        return horaFin;
    }
    public void setHoraFin(String horaFin){
        this.horaFin = horaFin;
    }

}