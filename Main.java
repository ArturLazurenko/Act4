package Act4;

public class Main {
    public static void main(String[] args) {

        Materia materia1 = new Materia("A","a1234",7,20);
        Materia materia2 = new Materia("B","a4321",6,15);
        Materia materia3 = new Materia("C","a2134",5,17);

        Curso curso = new Curso("Semestre 1", materia1, materia2, materia3);

        Alumno alumno = new Alumno("Yo","AL12345678",19,curso);

        Profesor profesor = new Profesor("Profe","1234",500,materia1);

        System.out.println("=== Datos del curso ===");
        System.out.println("Nombre: " + curso.getNombre());
        System.out.println("Materias: " + curso.getMateria1().getNombre() + ", " + curso.getMateria2().getNombre() + ", " + curso.getMateria3().getNombre());
        System.out.println("Creditos " + curso.calcularCreditosCurso());
        
        System.out.println("=== Datos del alumno ===");
        System.out.println("Matricula: " + alumno.getMatricula());
        System.out.println("Nombre: " + alumno.getNombre());
        System.out.println("Edad: " + alumno.getEdad());
        System.out.println("Curso: " + alumno.getCurso().getNombre());


        System.out.println("=== Datos del profesor ===");
        System.out.println("Nomina: " + profesor.getNumeroNomina());
        System.out.println("Nombre: " + profesor.getNombre());
        System.out.println("Sueldo x hora: " + profesor.getSueldoPorHora());
        System.out.println("Materia: " + profesor.getMateria().getNombre());
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
    private Materia materia1;
    private Materia materia2;
    private Materia materia3;


    public Curso() {
        this.nombre = "";
        this.materia1 = new Materia();
        this.materia2 = new Materia();
        this.materia3 = new Materia();
    }
    public Curso(String nombre, Materia m1, Materia m2, Materia m3) {
        this.nombre = nombre;
        this.materia1 = new Materia(m1);
        this.materia2 = new Materia(m2);
        this.materia3 = new Materia(m3);
    }


    public Curso(Curso c) {
        this.nombre = c.nombre;
        this.materia1 = new Materia(c.materia1);
        this.materia2 = new Materia(c.materia2);
        this.materia3 = new Materia(c.materia3);
    }


    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public Materia getMateria1() { 
        return materia1; 
    }
    public void setMateria1(Materia materia1) { 
        this.materia1 = materia1; 
    }

    public Materia getMateria2() { 
        return materia2; 
    }
    public void setMateria2(Materia materia2) { 
        this.materia2 = materia2; 
    }

    public Materia getMateria3() { 
        return materia3; 
    }
    public void setMateria3(Materia materia3) { 
        this.materia3 = materia3; 
    }


    public int calcularCreditosCurso() {
        return materia1.getCreditos() +
               materia2.getCreditos() +
               materia3.getCreditos();
    }
}
