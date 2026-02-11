package Act4;
import java.util.ArrayList;
import java.util.List;


public class Ejercicio1 {

    public static void main(String[] args) {

        
        Dueño dueño = new Dueño("Juan Pérez", 
        "LOPJ040728HDFRZN09", 
        "3312345678");


        Mascota mascota = new Mascota("Max", 
        "Perro", 
        3, 
        15.5, dueño);
        dueño.agregarMascota(mascota);


        Veterinario vet = new Veterinario(
                "Dr. Lopez",
                "3311112233",
                "Medicina Veterinaria General",
                5
        );


        Servicio servicio = new Servicio("Vacunación", 
        350.00, 20);

        
        Consulta consulta = new Consulta(vet, mascota, servicio, 
            "2026-02-11");

        
        System.out.println("=== Datos de la Mascota ===");
        System.out.println("Nombre: " + mascota.getNombreM());
        System.out.println("Especie: " + mascota.getEspecie());
        System.out.println("Edad: " + mascota.getEdad() + " años");
        System.out.println("Peso: " + mascota.getPeso() + " kg");
        System.out.println("Dueño: " + mascota.getDueño().getNombreD());

        System.out.println("\n=== Datos del Veterinario ===");
        System.out.println("Nombre: " + vet.getNombreV());
        System.out.println("Especialidad: " + vet.getEspecialidad());
        System.out.println("Experiencia: " + vet.getAñosDE() + " años");

        System.out.println("\n=== Consulta Realizada ===");
        System.out.println("Fecha: " + consulta.getFecha());
        System.out.println("Servicio: " + consulta.getServicio().getNomServi());
        System.out.println("Costo: $" + consulta.getCostoTotal());
    }
}



class Mascota {
    private String nombreM;
    private String especie;
    private int edad;
    private double peso;
    private Dueño dueño;

    public Mascota() {}

  
    public Mascota(String nombreM, String especie, int edad, double peso, Dueño dueño) {
        this.nombreM = nombreM;
        this.especie = especie;
        this.edad = edad;
        this.peso = peso;
        this.dueño = dueño;
    }

    public Mascota(Mascota m) {
        this.nombreM = m.nombreM;
        this.especie = m.especie;
        this.edad = m.edad;
        this.peso = m.peso;
        this.dueño = m.dueño;
    }

    public String getNombreM() { return nombreM; }
    public void setNombreM(String nombreM) { this.nombreM = nombreM; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public Dueño getDueño() { return dueño; }
    public void setDueño(Dueño dueño) { this.dueño = dueño; }
}

class Dueño {
    private String nombreD;
    private String RFC;
    private String telefono;
    private List<Mascota> mascotas;

    public Dueño() {
        mascotas = new ArrayList<>();
    }

    public Dueño(String nombreD, String RFC, String telefono) {
        this.nombreD = nombreD;
        this.RFC = RFC;
        this.telefono = telefono;
        mascotas = new ArrayList<>();
    }


    public Dueño(Dueño d) {
        this.nombreD = d.nombreD;
        this.RFC = d.RFC;
        this.telefono = d.telefono;
        this.mascotas = new ArrayList<>(d.mascotas);
    }

    public void agregarMascota(Mascota m) {
        mascotas.add(m);
        m.setDueño(this);
    }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getNombreD() { return nombreD; }
}


class Veterinario {
    private String nombreV;
    private String telefono; 
    private String especialidad;
    private int añosDE;

    public Veterinario() {}

    public Veterinario(String nombreV, String telefono, String especialidad, int añosDE) {
        this.nombreV = nombreV;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.añosDE = añosDE;
    }


    public Veterinario(Veterinario v) {
        this.nombreV = v.nombreV;
        this.telefono = v.telefono;
        this.especialidad = v.especialidad;
        this.añosDE = v.añosDE;
    }

    public String getTelefono() { return telefono; }
    public String getNombreV() { return nombreV; }
    public String getEspecialidad() { return especialidad; }
    public int getAñosDE() { return añosDE; }
}


class Servicio {
    private String nomServi;
    private double precio;
    private int min;

    public Servicio() {}

    public Servicio(String nomServi, double precio, int min) {
        this.nomServi = nomServi;
        this.precio = precio;
        this.min = min;
    }

    public Servicio(Servicio s) {
        this.nomServi = s.nomServi;
        this.precio = s.precio;
        this.min = s.min;
    }

    public String getNomServi() { return nomServi; }
    public double getPrecio() { return precio; }
}


class Consulta {
    private Veterinario veterinario;
    private Mascota mascota;
    private Servicio servicio;
    private String fecha;
    private double costoTotal;

    public Consulta() {
    }

    public Consulta(Veterinario veterinario, Mascota mascota, Servicio servicio, String fecha) {
        this.veterinario = veterinario;
        this.mascota = mascota;
        this.servicio = servicio;
        this.fecha = fecha;
        this.costoTotal = servicio.getPrecio(); 
    }

    public void calcularCosto() {
        this.costoTotal = servicio.getPrecio();
    }


    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
        calcularCosto();
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }
}
