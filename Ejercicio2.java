package Act4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio2 {
   

}


/**
 * Clase Ejercicio - Representa un ejercicio físico
 * 
 * COMPLETA:
 * - Constructor por defecto
 * - Constructor con parámetros
 * - Constructor de copia
 * - Getters y setters
 * - Método para mostrar información
 */
class Ejercicio { 
    private String nombre;
    private int series;
    private int repeticiones;
    private int duracionMinutos;
    
    public Ejercicio() {
        this.nombre = "Sin nombre";
        this.series = 0;
        this.repeticiones = 0;
        this.duracionMinutos = 0;
    }
    
    public Ejercicio(String nombre, int series, int repeticiones, int duracionMinutos) {
        setNombre(nombre);
        setSeries(series);
        setRepeticiones(repeticiones);
        setDuracionMinutos(duracionMinutos);
    }
    
    public Ejercicio(Ejercicio otro) {
        if (otro != null) {
            this.nombre = otro.nombre;
            this.series = otro.series;
            this.repeticiones = otro.repeticiones;
            this.duracionMinutos = otro.duracionMinutos;
        }
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        }
    }
    
    public int getSeries() {
        return series;
    }
    
    public void setSeries(int series) {
        if (series > 0) {
            this.series = series;
        }
    }
    
    public int getRepeticiones() {
        return repeticiones;
    }
    
    public void setRepeticiones(int repeticiones) {
        if (repeticiones > 0) {
            this.repeticiones = repeticiones;
        }
    }
    
    public int getDuracionMinutos() {
        return duracionMinutos;
    }
    
    public void setDuracionMinutos(int duracionMinutos) {
        if (duracionMinutos > 0) {
            this.duracionMinutos = duracionMinutos;
        }
    }
    
    public int getDuracionTotal() {
        return series * repeticiones;
    }
    
    public void mostrarInfo() {
        System.out.println("Ejercicio: " + nombre);
        System.out.println("Series: " + series);
        System.out.println("Repeticiones: " + repeticiones);
        System.out.println("Duración total: " + getDuracionTotal() + " minutos");
        System.out.println("----------------------");
    }
}

class PlanEntrenamiento {
    private String nombrePlan;
    private String objetivo;
    private List<Ejercicio> ejercicios;  
    private Miembro miembro;
    
    public PlanEntrenamiento() {
        this.nombrePlan = "Plan básico";
        this.objetivo = "Sin objetivo";
        this.ejercicios = new ArrayList<>();
    }
    
    public PlanEntrenamiento(String nombrePlan, String objetivo, Miembro miembro) {
        this.nombrePlan = nombrePlan;
        this.objetivo = objetivo;
        this.miembro = miembro;
        this.ejercicios = new ArrayList<>(5);
    }
    
    public PlanEntrenamiento(PlanEntrenamiento otro) {
        if (otro != null) {
            this.nombrePlan = otro.nombrePlan;
            this.objetivo = otro.objetivo;
            this.miembro = otro.miembro;
            
            this.ejercicios = new ArrayList<>();
            for (Ejercicio e : otro.ejercicios) {
                this.ejercicios.add(new Ejercicio(e));
            }
        }
    }
    
    public void agregarEjercicio(Ejercicio e) {
        if (e != null && ejercicios.size() < 5) {
            ejercicios.add(e);
        } else {
            System.out.println("No se pueden agregar más ejercicios (máximo 5).");
        }
    }
    
    public int getDuracionTotalPlan() {
        int total = 0;
        
        for (Ejercicio e : ejercicios) {
            total += e.getDuracionTotal();
        }
        
        return total;
    }
    
    public String getNombrePlan() {
        return nombrePlan;
    }
    
    public void setNombrePlan(String nombrePlan) {
        if (nombrePlan != null && !nombrePlan.trim().isEmpty()) {
            this.nombrePlan = nombrePlan;
        }
    }
    
    public String getObjetivo() {
        return objetivo;
    }
    
    public void setObjetivo(String objetivo) {
        if (objetivo != null && !objetivo.trim().isEmpty()) {
            this.objetivo = objetivo;
        }
    }
    
    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }
    
    public Miembro getMiembro() {
        return miembro;
    }
    
    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }
    
    public void mostrarInfoPlan() {
        System.out.println("=== PLAN DE ENTRENAMIENTO ===");
        System.out.println("Nombre: " + nombrePlan);
        System.out.println("Objetivo: " + objetivo);
        System.out.println("Total ejercicios: " + ejercicios.size());
        System.out.println("Duración total del plan: " + getDuracionTotalPlan() + " minutos");
        System.out.println("\nEjercicios:");
        
        for (Ejercicio e : ejercicios) {
            e.mostrarInfo();
        }
    }
}

/**
 * Clase Miembro - Representa un miembro del gimnasio
 */
class Miembro {
    private String nombre;
    private int edad;
    private String tipoMembresia;  // "básica" o "premium"
    private PlanEntrenamiento plan;  // ASOCIACIÓN: Miembro tiene un Plan
    
    // Constructores
    public Miembro() {
        this.nombre = "Sin nombre";
        this.edad = 0;
        this.tipoMembresia = "básica";
    }
    
    public Miembro(String nombre, int edad, String tipoMembresia) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipoMembresia = tipoMembresia;
    }
    
    public Miembro(Miembro otro) {
        this.nombre = otro.nombre;
        this.edad = otro.edad;
        this.tipoMembresia = otro.tipoMembresia;
        // No copiamos el plan (cada miembro tiene su propio plan)
    }
    
    // Getters y setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        if (edad < 0 || edad > 120) {
            throw new IllegalArgumentException("Edad no válida");
        }
        this.edad = edad;
    }
    
    public String getTipoMembresia() {
        return tipoMembresia;
    }
    
    public void setTipoMembresia(String tipoMembresia) {
        if (!tipoMembresia.equals("básica") && !tipoMembresia.equals("premium")) {
            throw new IllegalArgumentException("Tipo de membresía inválido");
        }
        this.tipoMembresia = tipoMembresia;
    }
    
    public PlanEntrenamiento getPlan() {
        return plan;
    }
    
    public void setPlan(PlanEntrenamiento plan) {
        this.plan = plan;
    }
    
    // Método funcional
    public boolean tienePlanActivo() {
        return plan != null;
    }
    
    public void mostrarInfo() {
        System.out.println("=== Datos del Miembro ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Membresía: " + tipoMembresia);
        if (plan != null) {
            System.out.println("Plan: " + plan.getNombrePlan());
        }
    }
}

/**
 * Clase Entrenador - Representa un entrenador del gimnasio
 */
class Entrenador {
    private String nombre;
    private String especialidad;
    private String certificacion;
    
    // Constructores
    public Entrenador() {
        this.nombre = "Sin nombre";
        this.especialidad = "General";
        this.certificacion = "Ninguna";
    }
    
    public Entrenador(String nombre, String especialidad, String certificacion) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.certificacion = certificacion;
    }
    
    public Entrenador(Entrenador otro) {
        this.nombre = otro.nombre;
        this.especialidad = otro.especialidad;
        this.certificacion = otro.certificacion;
    }
    
    // Getters y setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getEspecialidad() {
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public String getCertificacion() {
        return certificacion;
    }
    
    public void setCertificacion(String certificacion) {
        this.certificacion = certificacion;
    }
    
    public void mostrarInfo() {
        System.out.println("=== Datos del Entrenador ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Certificación: " + certificacion);
    }
}

/**
 * Menú Interactivo - Completa este método
 */
class MenuGimnasio {
    private static Scanner sc = new Scanner(System.in);
    

    public static void main(String[] args) {
        List<Ejercicio> listaEjercicios = new ArrayList<>();
    Miembro miembroActual = null;
        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();  // Limpiar buffer
            

            switch (opcion) {
                case 1:
                    System.out.println("=== CREAR MIEMBRO ===");

                    sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Tipo de membresía (básica/premium): ");
                    String tipo = sc.nextLine();

                    Miembro miembro = new Miembro(nombre, edad, tipo);

                    System.out.println("\nMiembro creado:");
                    miembro.mostrarInfo();

                    

        break;
                

                case 2:
                    System.out.println("=== CREAR MIEMBRO ===");

                    sc.nextLine();
                    System.out.print("Nombre del ejercicio: ");
                    String nombreE = sc.nextLine();

                    System.out.print("Cuantas series?: ");
                    int series = sc.nextInt();

                    System.out.print("Cuantas repeticiones?: ");
                    int repes = sc.nextInt();

                    System.out.print("Cuanto va a durar(en min)?: ");
                    int min = sc.nextInt();

                    Ejercicio ejercicio = new Ejercicio(nombreE,series,repes,min);
                    System.out.println("\\nEjercicio creado:");
                    ejercicio.mostrarInfo();
                    
                    listaEjercicios.add(ejercicio);



                    break;
                case 3:
                    if (miembroActual == null) {
                        System.out.println("Primero debes crear un miembro.");
                        break;
                    }

                    if (listaEjercicios.isEmpty()) {
                        System.out.println("Primero debes crear ejercicios.");
                        break;
                    }

                    sc.nextLine();

                    System.out.println("=== CREAR PLAN DE ENTRENAMIENTO ===");

                    System.out.print("Nombre del plan: ");
                    String nombrePlan = sc.nextLine();

                    System.out.print("Objetivo: ");
                    String objetivo = sc.nextLine();

                    PlanEntrenamiento plan = new PlanEntrenamiento(nombrePlan, objetivo, miembroActual);

                    for (Ejercicio e : listaEjercicios) {
                        plan.agregarEjercicio(e);
                    }

                    miembroActual.setPlan(plan);

                    System.out.println("\nPlan creado correctamente.");
                    plan.mostrarInfoPlan();

                    break;
                case 4:
                    System.out.println("=== CREAR ENTRENADOR ===");

                    sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombreEntre = sc.nextLine();

                    System.out.print("Especialidad: ");
                    String especialidad = sc.nextLine();

                    System.out.print("Certificacion: ");
                    String cercificacion = sc.nextLine();

                    Entrenador entrenador = new Entrenador(nombreEntre,especialidad,cercificacion);


                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 5);
    }
    
    public static void mostrarMenu() {
        System.out.println("\n=== MENÚ GIMNASIO ===");
        System.out.println("1. Crear miembro");
        System.out.println("2. Crear ejercicio");
        System.out.println("3. Crear plan de entrenamiento");
        System.out.println("4. Crear entrenador");
        System.out.println("5. Salir");
        System.out.print("Elige una opción: ");
    }
}