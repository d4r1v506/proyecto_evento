import java.util.ArrayList;
import java.util.List;

public class Arena {
    private int foro;
    private String localidad;
    private List<Entradas> tipoEntrada = new ArrayList<>();
    private Entradas entrada = new Entradas();

    public int getForo() {
        return foro;
    }

    public void setForo(int foro) {
        this.foro = foro;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Entradas getEntrada() {
        return entrada;
    }

    public void generarEntradas() {
        if (validarEntradaTipo(entrada.getTipo()) && validarEntradaPrecio(entrada)) {
            tipoEntrada.add(entrada);
        }
    }

    private boolean validarEntradaTipo(String tipo) {
        for (Entradas entrada : tipoEntrada) {
            if (entrada.getTipo().equals(tipo)) {
                return false;
            }
        }
        return true;
    }

    private boolean validarEntradaPrecio(Entradas nuevaEntrada) {
        if (tipoEntrada.isEmpty()) {
            return true;
        }

        for (Entradas entrada : tipoEntrada) {
            if (nuevaEntrada.getTipo().equals("General") && entrada.getTipo().equals("Tribuna")) {
                return nuevaEntrada.getPrecio() < entrada.getPrecio();
            } else if (nuevaEntrada.getTipo().equals("Tribuna") && entrada.getTipo().equals("Piso")) {
                return nuevaEntrada.getPrecio() < entrada.getPrecio();
            } else if (nuevaEntrada.getTipo().equals("Piso") && entrada.getTipo().equals("VIP")) {
                return nuevaEntrada.getPrecio() < entrada.getPrecio();
            }
        }
        return true;
    }

}
