package Act4;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {

    private static ArrayList<Alumno> listaAlumnos = new ArrayList<>();
    private static ArrayList<Profesor> listaProfesores = new ArrayList<>();
    private static ArrayList<Curso> listaCursos = new ArrayList<>();
    private static ArrayList<Materia> listaMaterias = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ ESCUELA ===");
            System.out.println("1. Administrar Alumnos");
            System.out.println("2. Administrar Profesores");
            System.out.println("3. Administrar Cursos");
            System.out.println("4. Administrar Materias");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: menuAlumnos(sc); break;
                case 2: menuProfesores(sc); break;
                case 3: menuCursos(sc); break;
                case 4: menuMaterias(sc); break;
            }

        } while (opcion != 5);
    }

    // ================= ALUMNOS =================
    public static void menuAlumnos(Scanner sc){
        int op;
        do{
            System.out.println("\n=== MENÚ ALUMNOS ===");
            System.out.println("1. Registrar");
            System.out.println("2. Ver");
            System.out.println("3. Salir");
            op = sc.nextInt(); sc.nextLine();

            switch(op){
                case 1: registrarAlumno(sc); break;
                case 2: verAlumnos(); break;
            }
        }while(op!=3);
    }

    public static void registrarAlumno(Scanner sc){
        System.out.print("Matricula: ");
        String matricula = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Edad: ");
        int edad = sc.nextInt(); sc.nextLine();

        listaAlumnos.add(new Alumno(matricula,nombre,edad,null));
        System.out.println("Alumno registrado");
    }

    public static void verAlumnos(){
        if(listaAlumnos.isEmpty()) System.out.println("No hay alumnos");
        for(Alumno a: listaAlumnos){
            System.out.println(a.getMatricula()+" | "+a.getNombre()+" | "+a.getEdad());
        }
    }

    // ================= PROFESORES =================
    public static void menuProfesores(Scanner sc){
        int op;
        do{
            System.out.println("\n=== MENÚ PROFESORES ===");
            System.out.println("1. Registrar");
            System.out.println("2. Ver");
            System.out.println("3. Salir");
            op=sc.nextInt(); sc.nextLine();

            switch(op){
                case 1: registrarProfesor(sc); break;
                case 2: verProfesores(); break;
            }
        }while(op!=3);
    }

    public static void registrarProfesor(Scanner sc){
        System.out.print("Nomina: ");
        String nomina=sc.nextLine();

        System.out.print("Nombre: ");
        String nombre=sc.nextLine();

        System.out.print("Sueldo por hora: ");
        double sueldo=sc.nextDouble(); sc.nextLine();

        listaProfesores.add(new Profesor(nombre,nomina,sueldo,null));
        System.out.println("Profesor registrado");
    }

    public static void verProfesores(){
        if(listaProfesores.isEmpty()) System.out.println("No hay profesores");
        for(Profesor p: listaProfesores){
            System.out.println(p.getNumeroNomina()+" | "+p.getNombre());
        }
    }

    // ================= CURSOS =================
    public static void menuCursos(Scanner sc){
        int op;
        do{
            System.out.println("\n=== MENÚ CURSOS ===");
            System.out.println("1. Registrar");
            System.out.println("2. Ver");
            System.out.println("3. Agregar materia a curso");
            System.out.println("4. Salir");
            op=sc.nextInt(); sc.nextLine();

            switch(op){
                case 1: registrarCurso(sc); break;
                case 2: verCursos(); break;
                case 3: agregarMateriaACurso(sc); break;
            }
        }while(op!=4);
    }

    public static void registrarCurso(Scanner sc){
        System.out.print("Nombre curso: ");
        String nombre=sc.nextLine();

        listaCursos.add(new Curso(nombre));
        System.out.println("Curso registrado");
    }

    public static void verCursos(){
        if(listaCursos.isEmpty()) System.out.println("No hay cursos");

        for(int i=0;i<listaCursos.size();i++){
            System.out.println(i+" - "+listaCursos.get(i).getNombre());
            listaCursos.get(i).mostrarMaterias();
        }
    }

    public static void agregarMateriaACurso(Scanner sc){
        verCursos();
        System.out.print("Indice del curso: ");
        int i=sc.nextInt(); sc.nextLine();

        verMaterias();
        System.out.print("Indice materia: ");
        int j=sc.nextInt(); sc.nextLine();

        listaCursos.get(i).agregarMateria(listaMaterias.get(j));
        System.out.println("Materia agregada al curso");
    }

    // ================= MATERIAS =================
    public static void menuMaterias(Scanner sc){
        int op;
        do{
            System.out.println("\n=== MENÚ MATERIAS ===");
            System.out.println("1. Registrar");
            System.out.println("2. Ver");
            System.out.println("3. Salir");
            op=sc.nextInt(); sc.nextLine();

            switch(op){
                case 1: registrarMateria(sc); break;
                case 2: verMaterias(); break;
            }
        }while(op!=3);
    }

    public static void registrarMateria(Scanner sc){
        System.out.print("Nombre: ");
        String nombre=sc.nextLine();

        System.out.print("Clave: ");
        String clave=sc.nextLine();

        System.out.print("Creditos: ");
        int creditos=sc.nextInt(); sc.nextLine();

        listaMaterias.add(new Materia(nombre,clave,creditos,4));
        System.out.println("Materia registrada");
    }

    public static void verMaterias(){
        if(listaMaterias.isEmpty()) System.out.println("No hay materias");

        for(int i=0;i<listaMaterias.size();i++){
            System.out.println(i+" - "+listaMaterias.get(i).getNombre());
        }
    }
}

    
class Profesor {

    private String nombre;
    private String numeroNomina;
    private double sueldoPorHora;
    private Materia materia;

    public Profesor() {
        this.nombre = "";
        this.numeroNomina = "";
        this.sueldoPorHora = 0;
        this.materia = null; 
    }

    public Profesor(String nombre, String numeroNomina, double sueldoPorHora, Materia materia) {
        this.nombre = nombre;
        this.numeroNomina = numeroNomina;
        this.sueldoPorHora = sueldoPorHora;
        this.materia = materia; 
    }


    public Profesor(Profesor p) {
        this.nombre = p.nombre;
        this.numeroNomina = p.numeroNomina;
        this.sueldoPorHora = p.sueldoPorHora;
        this.materia = p.materia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroNomina() {
        return numeroNomina;
    }

    public double getSueldoPorHora() {
        return sueldoPorHora;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroNomina(String numeroNomina) {
        this.numeroNomina = numeroNomina;
    }

    public void setSueldoPorHora(double sueldoPorHora) {
        this.sueldoPorHora = sueldoPorHora;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double calcularSueldoSemanal(int horasImpartidas) {
        return sueldoPorHora * horasImpartidas;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Número de nómina: " + numeroNomina);
        System.out.println("Sueldo por hora: $" + sueldoPorHora);
        System.out.println("Materia: " + (materia != null ? materia : "Sin asignar"));
    }
}

class Alumno {

    private String matricula;
    private String nombre;
    private int edad;
    private Curso curso;


    public Alumno() {
        this.matricula = "";
        this.nombre = "";
        this.edad = 0;
        this.curso = null; 
    }


    public Alumno(String matricula, String nombre, int edad, Curso curso) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
    }


    public Alumno(Alumno a) {
        this.matricula = a.matricula;
        this.nombre = a.nombre;
        this.edad = a.edad;
        this.curso = new Curso(a.curso);
    }


    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; }
    
}

class Materia {

    private String nombre;
    private String clave;
    private int creditos;
    private int horasSemanales;

    public Materia() {
        this.nombre = "";
        this.clave = "";
        this.creditos = 0;
        this.horasSemanales = 0;
    }


    public Materia(String nombre, String clave, int creditos, int horasSemanales) {
        this.nombre = nombre;
        this.clave = clave;
        this.creditos = creditos;
        this.horasSemanales = horasSemanales;
    }


    public Materia(Materia m) {
        this.nombre = m.nombre;
        this.clave = m.clave;
        this.creditos = m.creditos;
        this.horasSemanales = m.horasSemanales;
    }


    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public String getClave() { 
        return clave; 
    }
    public void setClave(String clave) { 
        this.clave = clave; 
    }

    public int getCreditos() { 
        return creditos; 
    }
    public void setCreditos(int creditos) { 
        this.creditos = creditos; 
    }

    public int getHorasSemanales() { 
        return horasSemanales; 
    }
    public void setHorasSemanales(int horasSemanales) { 
        this.horasSemanales = horasSemanales; 
    }
}

class Curso {

    private String nombre;
    private ArrayList<Materia> materias;

    // Constructor vacío
    public Curso() {
        this.nombre = "";
        this.materias = new ArrayList<>();
    }

    // Constructor con nombre
    public Curso(String nombre) {
        this.nombre = nombre;
        this.materias = new ArrayList<>();
    }

    // Constructor de copia
    public Curso(Curso c) {
        this.nombre = c.nombre;
        this.materias = new ArrayList<>();

        for(Materia m : c.materias){
            this.materias.add(new Materia(m));
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<Materia> materias) {
        this.materias = materias;
    }

    public void agregarMateria(Materia m) {
        materias.add(m);
    }

    public void eliminarMateria(String nombreMateria) {
        materias.removeIf(m -> m.getNombre().equalsIgnoreCase(nombreMateria));
    }

    public void mostrarMaterias() {
        if(materias.isEmpty()) {
            System.out.println("No hay materias en el curso");
            return;
        }

        for(Materia m : materias) {
            System.out.println("Materia: " + m.getNombre() +
                               " | Clave: " + m.getClave() +
                               " | Créditos: " + m.getCreditos());
        }
    }

    public int calcularCreditosCurso() {
        int total = 0;

        for(Materia m : materias) {
            total += m.getCreditos();
        }

        return total;
    }
}
