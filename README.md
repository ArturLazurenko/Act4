# Ejercicios Prácticos - POO Intermedia

Estos ejercicios te permitirán practicar los conceptos de Programación Orientada a Objetos: constructores, encapsulación, relaciones entre clases y flujos de llamadas.

---

## Ejercicio 1: Sistema de Gestión de Veterinaria

### Enunciado del Problema

Una veterinaria necesita un programa para gestionar las mascotas que atienden, los servicios que ofrecen y los veterinarios que trabajan ahí. La información que se registra es la siguiente:

**Mascotas:** Nombre, especie (perro, gato, etc.), edad y peso. Cada mascota tiene un dueño asociado.

**Dueños:** Nombre, RFC y teléfono. Un dueño puede tener varias mascotas.

**Veterinarios:** Nombre, número de empleado, especialidad y años de experiencia.

**Servicios:** Nombre del servicio, precio y duración en minutos.

**Consultas:** Cada consulta es realizada por un veterinario a una mascota, utilizando un servicio específico. Cada consulta tiene una fecha y un costo total.

**Codigo**  
```java
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


```

### Requisitos del Ejercicio

1. **Modela las clases** necesarias con sus atributos y relaciones:
   - Una Mascota **pertenece a** un Dueño (asociación)
   - Un Veterinario **realiza** Consultas (asociación)
   - Una Mascota **recibe** Consultas (asociación)
   - Una Consulta **incluye** un Servicio (dependencia)

2. **Identifica el tipo de relación** entre cada par de clases y justifícalo.

3. **Crea el diagrama de secuencia** que muestre cómo se crea una consulta.

```
Usuario -> Dueño: crearDueño()
Usuario -> Mascota: crearMascota(dueño)
Dueño -> Mascota: agregarMascota()

Usuario -> Veterinario: crearVeterinario()
Usuario -> Servicio: crearServicio()

Usuario -> Consulta: crearConsulta(vet, mascota, servicio)
Consulta -> Servicio: getPrecio()
Servicio --> Consulta: precio
Consulta -> Consulta: calcularCosto()

```

4. **Implementa las clases** en Java con:
   - Constructor por defecto
   - Constructor con parámetros
   - Constructor de copia
   - Getters y setters
   - Métodos funcionales necesarios

5. **Crea un programa** donde se demuestre la creación de objetos.

```java
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

```

### Salida Esperada

```
=== Datos de la Mascota ===
Nombre: Max
Especie: Perro
Edad: 3 años
Peso: 15.5 kg
Dueño: Juan Pérez

=== Datos del Veterinario ===
Nombre: Dr. Lopez
Especialidad: Medicina Veterinaria General
Experiencia: 5 años

=== Consulta Realizada ===
Fecha: 2026-02-11
Servicio: Vacunación
Costo: $350.0
```

---

## Ejercicio 2: Sistema de Gimnasio (Código Incompleto)

### Enunciado del Problema

Un gimnasio necesita un sistema para administrar sus instalaciones, entrenadores y miembros. Los requisitos son:

**Miembros:** Nombre, edad, membresía (básica, premium) y el plan de entrenamiento que siguen.

**Entrenadores:** Nombre, especialidad y certificación. Un entrenador puede atender a varios miembros.

**Planes de Entrenamiento:** Nombre del plan, objetivo (pérdida de peso, musculación, etc.) y ejercicios asignados. Cada plan tiene exactamente 5 ejercicios.

**Ejercicios:** Nombre, series, repeticiones y duración en minutos.

### Instrucciones

Completa el código base que se proporciona a continuación. Debes:
- Completar los constructores faltantes
- Implementar los getters y setters
- Completar los métodos funcionales
- Añadir validación en los setters
- Crear el menú interactivo

**Código Base (COMPLETAR):**

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
public class Ejercicio {
    private String nombre;
    private int series;
    private int repeticiones;
    private int duracionMinutos;
    
    // =====================================================
    // CONSTRUCTOR POR DEFECTO (COMPLETAR)
    // Inicializa con valores predeterminados
    // =====================================================
    public Ejercicio() {
        // TODO: Inicializar atributos con valores por defecto
        // nombre = "Sin nombre"
        // series = 0
        // repeticiones = 0
        // duracionMinutos = 0
    }
    
    // =====================================================
    // CONSTRUCTOR CON PARÁMETROS (COMPLETAR)
    // Inicializa con valores específicos
    // =====================================================
    public Ejercicio(String nombre, int series, int repeticiones, int duracionMinutos) {
        // TODO: Asignar parámetros a atributos usando this
    }
    
    // =====================================================
    // CONSTRUCTOR DE COPIA (COMPLETAR)
    // Crea una copia de otro objeto Ejercicio
    // =====================================================
    public Ejercicio(Ejercicio otro) {
        // TODO: Copiar los valores del objeto otro
    }
    
    // =====================================================
    // GETTERS Y SETTERS (COMPLETAR)
    // =====================================================
    public String getNombre() {
        // TODO: Retornar nombre
    }
    
    public void setNombre(String nombre) {
        // TODO: Asignar nombre con validación (no null, no vacío)
    }
    
    public int getSeries() {
        // TODO: Retornar series
    }
    
    public void setSeries(int series) {
        // TODO: Asignar series con validación (debe ser mayor a 0)
    }
    
    public int getRepeticiones() {
        // TODO: Retornar repeticiones
    }
    
    public void setRepeticiones(int repeticiones) {
        // TODO: Asignar repeticiones con validación (debe ser mayor a 0)
    }
    
    public int getDuracionMinutos() {
        // TODO: Retornar duracionMinutos
    }
    
    public void setDuracionMinutos(int duracionMinutos) {
        // TODO: Asignar duracionMinutos con validación (debe ser mayor a 0)
    }
    
    // =====================================================
    // MÉTODO FUNCIONAL (COMPLETAR)
    // Calcula la duración total del ejercicio (series * repeticiones * 1 min)
    // =====================================================
    public int getDuracionTotal() {
        // TODO: Calcular duración total
        return 0; // Modificar
    }
    
    // =====================================================
    // MÉTODO PARA MOSTRAR INFORMACIÓN (COMPLETAR)
    // =====================================================
    public void mostrarInfo() {
        // TODO: Imprimir información del ejercicio formateada
    }
}

/**
 * Clase PlanEntrenamiento - Representa un plan de entrenamiento
 * 
 * Características:
 * - Tiene exactamente 5 ejercicios (COMPOSICIÓN)
 * - Un Plan pertenece a un Miembro
 */
class PlanEntrenamiento {
    private String nombrePlan;
    private String objetivo;
    private List<Ejercicio> ejercicios;  // Exactly 5 ejercicios
    private Miembro miembro;  // ASOCIACIÓN: Plan pertenece a un Miembro
    
    // =====================================================
    // CONSTRUCTORES (COMPLETAR)
    // =====================================================
    
    public PlanEntrenamiento() {
        // TODO: Inicializar lista vacía, nombre y objetivo por defecto
    }
    
    public PlanEntrenamiento(String nombrePlan, String objetivo, Miembro miembro) {
        // TODO: Asignar parámetros e inicializar lista con capacidad para 5
    }
    
    public PlanEntrenamiento(PlanEntrenamiento otro) {
        // TODO: Copiar todos los atributos (incluir copiar cada ejercicio)
    }
    
    // =====================================================
    // MÉTODO PARA AGREGAR EJERCICIO (COMPLETAR)
    // Agrega un ejercicio a la lista (máximo 5)
    // =====================================================
    public void agregarEjercicio(Ejercicio e) {
        // TODO: Agregar ejercicio a la lista si hay menos de 5
    }
    
    // =====================================================
    // MÉTODO FUNCIONAL (COMPLETAR)
    // Calcula la duración total de todos los ejercicios
    // =====================================================
    public int getDuracionTotalPlan() {
        // TODO: Sumar duraciones de todos los ejercicios
        return 0; // Modificar
    }
    
    // =====================================================
    // GETTERS Y SETTERS (COMPLETAR)
    // =====================================================
    public String getNombrePlan() {
        // TODO
    }
    
    public void setNombrePlan(String nombrePlan) {
        // TODO
    }
    
    public String getObjetivo() {
        // TODO
    }
    
    public void setObjetivo(String objetivo) {
        // TODO
    }
    
    public List<Ejercicio> getEjercicios() {
        // TODO
    }
    
    public Miembro getMiembro() {
        // TODO
    }
    
    public void setMiembro(Miembro miembro) {
        // TODO
    }
    
    public void mostrarInfoPlan() {
        // TODO: Mostrar información completa del plan
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
        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();  // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    // TODO: Crear y mostrar un miembro
                    break;
                case 2:
                    // TODO: Crear y mostrar un ejercicio
                    break;
                case 3:
                    // TODO: Crear un plan y agregar ejercicios
                    break;
                case 4:
                    // TODO: Crear un entrenador
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
```

### Menú del Programa Esperado

```
=== MENÚ GIMNASIO ===
1. Crear miembro
2. Crear ejercicio
3. Crear plan de entrenamiento
4. Crear entrenador
5. Salir
Elige una opción: 1

=== CREAR MIEMBRO ===
Nombre: Ana García
Edad: 25
Tipo de membresía (básica/premium): premium

Miembro creado exitosamente:
=== Datos del Miembro ===
Nombre: Ana García
Edad: 25
Membresía: premium
Plan: Sin asignar
```

### Ejemplo de Ejecución Completa

```
=== MENÚ GIMNASIO ===
1. Crear miembro
2. Crear ejercicio
3. Crear plan de entrenamiento
4. Crear entrenador
5. Salir
Elige una opción: 1

=== CREAR MIEMBRO ===
Nombre: Carlos Ruiz
Edad: 30
Tipo de membresía (básica/premium): premium
Miembro creado exitosamente.

=== MENÚ GIMNASIO ===
1. Crear miembro
2. Crear ejercicio
3. Crear plan de entrenamiento
4. Crear entrenador
5. Salir
Elige una opción: 2

=== CREAR EJERCICIO ===
Nombre del ejercicio: Sentadillas
Número de series: 4
Número de repeticiones: 12
Duración por serie (min): 2
Ejercicio creado exitosamente.

=== MENÚ GIMNASIO ===
1. Crear miembro
2. Crear ejercicio
3. Crear plan de entrenamiento
4. Crear entrenador
5. Salir
Elige una opción: 3

=== CREAR PLAN DE ENTRENAMIENTO ===
Nombre del plan: Plan de Fuerza
Objetivo: Musculación
=== AGREGAR EJERCICIOS (máx 5) ===

Ejercicio 1:
Nombre: Press Banca
Series: 4
Repeticiones: 10
Duración: 2

Ejercicio 2:
Nombre: Sentadillas
Series: 4
Repeticiones: 12
Duración: 2

... (agregar hasta 5 ejercicios)

Plan creado exitosamente:
=== Plan de Fuerza ===
Objetivo: Musculación
Duración total: XX minutos
Ejercicios:
1. Press Banca - 4x10 (XX min)
2. Sentadillas - 4x12 (XX min)
...

=== MENÚ GIMNASIO ===
1. Crear miembro
2. Crear ejercicio
3. Crear plan de entrenamiento
4. Crear entrenador
5. Salir
Elige una opción: 5

Saliendo del programa...
```

### Ayuda para Completar el Ejercicio

**Pistas para los constructores:**

```java
// Constructor por defecto de Ejercicio
public Ejercicio() {
    this.nombre = "Sin nombre";
    this.series = 0;
    this.repeticiones = 0;
    this.duracionMinutos = 0;
}

// Constructor con parámetros
public Ejercicio(String nombre, int series, int repeticiones, int duracionMinutos) {
    this.nombre = nombre;
    this.series = series;
    this.repeticiones = repeticiones;
    this.duracionMinutos = duracionMinutos;
}

// Constructor de copia
public Ejercicio(Ejercicio otro) {
    this.nombre = otro.nombre;
    this.series = otro.series;
    this.repeticiones = otro.repeticiones;
    this.duracionMinutos = otro.duracionMinutos;
}
```

**Pistas para validación de setters:**

```java
public void setNombre(String nombre) {
    if (nombre == null || nombre.trim().isEmpty()) {
        throw new IllegalArgumentException("El nombre no puede estar vacío");
    }
    this.nombre = nombre;
}

public void setSeries(int series) {
    if (series <= 0) {
        throw new IllegalArgumentException("Las series deben ser mayor a 0");
    }
    this.series = series;
}
```

**Pista para duración total:**

```java
public int getDuracionTotal() {
    // Cada repetición toma aproximadamente 1 minuto
    return series * repeticiones;
}
```

---

## Solución del Ejercicio 1 (Referencia)

### Diagrama de Clases

```
┌───────────────┐         ┌───────────────┐
│    Dueño      │    1    │    Mascota    │
├───────────────┤◄───────┤├───────────────┤
│ - nombre      │    *    │ - nombre      │
│ - rfc         │         │ - especie     │
│ - telefono    │         │ - edad        │
└───────────────┘         │ - peso        │
                          │ - dueño       │────► Dueño
                          └───────────────┘
                                 │
                                 │ realiza
                                 ▼
                          ┌───────────────┐
                          │   Consulta    │
                          ├───────────────┤
                          │ - fecha       │
                          │ - costoTotal  │
                          │ - mascota     │
                          │ - veterinario │
                          │ - servicio    │
                          └───────────────┘
                                 │
          ┌──────────────────────┼──────────────────────┐
          │                      │                      │
          ▼                      ▼                      ▼
   ┌───────────────┐    ┌───────────────┐    ┌───────────────┐
   │  Veterinario  │    │    Servicio   │    │    Mascota    │
   ├───────────────┤    ├───────────────┤    ├───────────────┤
   │ - nombre      │    │ - nombre      │    │ (ya definido) │
   │ - numEmpleado │    │ - precio      │    │               │
   │ - especialidad│    │ - duracion    │    │               │
   │ - experiencia │    └───────────────┘    └───────────────┘
   └───────────────┘
```

### Tipo de Relaciones

| Relación | Tipo | Justificación |
|----------|------|---------------|
| Mascota-Dueño | Asociación | La Mascota conoce a su Dueño, pero pueden existir independientemente |
| Consulta-Mascota | Asociación | Una Consulta es de una Mascota específica |
| Consulta-Veterinario | Asociación | Un Veterinario realiza varias Consultas |
| Consulta-Servicio | Dependencia | El Servicio se pasa como parámetro, no se guarda |

### Diagrama de Secuencia (Crear Consulta)

```
┌───────────────┐  ┌────────┐  ┌─────────┐  ┌───────────┐ ┌─────────┐
│    main()     │  │Dueño   │  │Mascota  │  │Veterinario│ │Servicio │
├───────────────┤  ├────────┤  ├─────────┤  ├───────────┤ ├─────────┤
│               │  │        │  │         │  │           │ │         │
│ new Dueño()   │─►│        │  │         │  │           │ │         │
│               │  │        │  │         │  │           │ │         │
│ new Mascota() │──────────►│  |         │  │           │ │         │
│               │  │        │  │         │  │           │ │         │
│ new Vet()     │──────────────────────────►│           │ │         │
│               │  │        │  │         │  │           │ │         │
│ new Servicio()│────────────────────────────────────────►│         │
│               │  │        │  │         │  │           │ │         │
│ new Consulta()│──────────────────────────────────────────────────►│
│  (masc,v,ser)││           │  │         │  │           │ │         │
│               │  │        │  │         │  │           │ │         │
│ consul.mostrar│──────────────────────────────────────────────────►│
└───────────────┘  └────────┘  └─────────┘  └───────────┘ └─────────┘
```

