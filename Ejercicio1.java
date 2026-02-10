package Act4;
import java.util.ArrayList;
import java.util.List;


public class Ejercicio1 {
    
}

class Mascota {
    private String nombreM;
    private String especie;
    private int edad;
    private int peso;
    private Dueño dueño;

    // Constructor vacío
    public Mascota() {
    }

    // Constructor con parámetros
    public Mascota(String nombreM, String especie, int edad, int peso, Dueño dueño) {
        this.nombreM = nombreM;
        this.especie = especie;
        this.edad = edad;
        this.peso = peso;
        this.dueño = dueño;
    }

    // Getters y Setters
    public String getNombreM() {
        return nombreM;
    }

    public void setNombreM(String nombreM) {
        this.nombreM = nombreM;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Dueño getDueño() {
        return dueño;
    }

    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }
}



class Dueño {
    private String nombreD;
    private String RFC;
    private int numero;
    private List<Mascota> mascotas;

    // Constructor vacío
    public Dueño() {
        this.mascotas = new ArrayList<>();
    }

    // Constructor con parámetros
    public Dueño(String nombreD, String RFC, int numero) {
        this.nombreD = nombreD;
        this.RFC = RFC;
        this.numero = numero;
        this.mascotas = new ArrayList<>();
    }

    // Método para agregar una mascota
    public void agregarMascota(Mascota mascota) {
        mascotas.add(mascota);
        mascota.setDueño(this); // relación bidireccional
    }

    // Getters y Setters
    public String getNombreD() {
        return nombreD;
    }

    public void setNombreD(String nombreD) {
        this.nombreD = nombreD;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}

class Veterinario {
    private String nombreV;
    private int numV;
    private String especialidad;
    private int añosDE;

    // Constructor vacío
    public Veterinario() {
    }

    // Constructor con parámetros
    public Veterinario(String nombreV, int numV, String especialidad, int añosDE) {
        this.nombreV = nombreV;
        this.numV = numV;
        this.especialidad = especialidad;
        this.añosDE = añosDE;
    }

    // Getters y Setters
    public String getNombreV() {
        return nombreV;
    }

    public void setNombreV(String nombreV) {
        this.nombreV = nombreV;
    }

    public int getNumV() {
        return numV;
    }

    public void setNumV(int numV) {
        this.numV = numV;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getAñosDE() {
        return añosDE;
    }

    public void setAñosDE(int añosDE) {
        this.añosDE = añosDE;
    }
}


class Servicio {
    private String nomServi;
    private int precio;
    private int min;

    // Constructor vacío
    public Servicio() {
    }

    // Constructor con parámetros
    public Servicio(String nomServi, int precio, int min) {
        this.nomServi = nomServi;
        this.precio = precio;
        this.min = min;
    }

    // Getters y Setters
    public String getNomServi() {
        return nomServi;
    }

    public void setNomServi(String nomServi) {
        this.nomServi = nomServi;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}


class Consulta {
    
}