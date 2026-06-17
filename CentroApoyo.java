import java.util.List;
import java.util.Scanner;


public class CentroApoyo {

    record Estudiante(String nombre, String curso, double nota) {}

    static final List<Estudiante> estudiantes = List.of(
            new Estudiante("ana", "calculo", 5.5),
            new Estudiante("luis", "calculo", 3.2),
            new Estudiante("maria", "calculo", 6.1),
            new Estudiante("pedro", "calculo", 2.8),
            new Estudiante("sofia", "calculo", 4.0),
            new Estudiante("diego", "programacion", 6.5),
            new Estudiante("camila", "programacion", 3.9),
            new Estudiante("tomas", "programacion", 5.0),
            new Estudiante("valentina", "programacion", 2.5),
            new Estudiante("nicolas", "programacion", 4.8),
            new Estudiante("javiera", "estadistica", 6.0),
            new Estudiante("matias", "estadistica", 3.5),
            new Estudiante("isidora", "estadistica", 5.8),
            new Estudiante("sebastian", "estadistica", 1.9),
            new Estudiante("catalina", "estadistica", 4.2),
            new Estudiante("andres", "fisica", 5.1),
            new Estudiante("francisca", "fisica", 3.0),
            new Estudiante("ignacio", "fisica", 6.3),
            new Estudiante("paula", "fisica", 2.1),
            new Estudiante("roberto", "fisica", 4.5),
            new Estudiante("daniela", "ingles", 5.7),
            new Estudiante("felipe", "ingles", 3.8),
            new Estudiante("marcela", "ingles", 6.2),
            new Estudiante("cristian", "ingles", 1.5),
            new Estudiante("lorena", "ingles", 4.9),
            new Estudiante("gabriel", "calculo", 5.3),
            new Estudiante("constanza", "programacion", 3.1),
            new Estudiante("rodrigo", "estadistica", 4.7),
            new Estudiante("antonia", "fisica", 6.0),
            new Estudiante("jorge", "ingles", 2.9)
    );

    //verifica si un estudiante pertenece a un curso usando stream y anyMatch
    static boolean perteneceACurso(String nombre, String curso) {
        return estudiantes.stream()
                .filter(e -> e.nombre().equalsIgnoreCase(nombre))
                .anyMatch(e -> e.curso().equalsIgnoreCase(curso));
    }

    //retorna true si el estudiante tiene nota >= 4.0
    static boolean estaAprobado(String nombre) {
        return estudiantes.stream()
                .filter(e -> e.nombre().equalsIgnoreCase(nombre))
                .anyMatch(e -> e.nota() >= 4.0);
    }

    //retorna true si el estudiante tiene nota < 4.0
    static boolean estaReprobado(String nombre) {
        return estudiantes.stream()
                .filter(e -> e.nombre().equalsIgnoreCase(nombre))
                .anyMatch(e -> e.nota() < 4.0);
    }

    //busca al estudiante con findFirst y muestra su nota y estado
    static void mostrarEstadoEstudiante(Scanner scanner) {
        System.out.print("Ingrese nombre del estudiante: ");
        String nombre = scanner.nextLine();

        var resultado = estudiantes.stream()
                .filter(e -> e.nombre().equalsIgnoreCase(nombre))
                .findFirst();

        if (resultado.isPresent()) {
            Estudiante e = resultado.get();
            String estado = e.nota() >= 4.0 ? "Aprobado" : "Reprobado";
            System.out.println("Nota: " + e.nota() + " | Estado: " + estado);
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    //solicita dos numeros y una operacion, muestra el resultado
    static void calculadora(Scanner scanner) {
        System.out.print("Ingrese primer numero: ");
        double num1 = Double.parseDouble(scanner.nextLine());

        System.out.print("Ingrese operacion (+, -, *, /): ");
        String operacion = scanner.nextLine();

        System.out.print("Ingrese segundo numero: ");
        double num2 = Double.parseDouble(scanner.nextLine());

        switch (operacion) {
            case "+" -> System.out.println("Resultado: " + (num1 + num2));
            case "-" -> System.out.println("Resultado: " + (num1 - num2));
            case "*" -> System.out.println("Resultado: " + (num1 * num2));
            case "/" -> {
                if (num2 == 0) {
                    System.out.println("Error: division por cero.");
                } else {
                    System.out.println("Resultado: " + (num1 / num2));
                }
            }
            default -> System.out.println("Operacion no reconocida.");
        }
    }

    //menu interactivo que se repite hasta que el usuario elija salir
    static void menu(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n-----Centro de Apoyo Academico-----");
            System.out.println("1. Consultar estado del estudiante");
            System.out.println("2. Verificar pertenencia al curso");
            System.out.println("3. Calculadora");
            System.out.println("4. Salir");
            System.out.print("Ingrese opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> mostrarEstadoEstudiante(scanner);
                case 2 -> {
                    System.out.print("Ingrese nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese curso: ");
                    String curso = scanner.nextLine();
                    System.out.println(perteneceACurso(nombre, curso) ? "Si pertenece al curso." : "No pertenece al curso.");
                }
                case 3 -> calculadora(scanner);
                case 4 -> System.out.println("Saliendo...");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 4);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menu(scanner);
        scanner.close();
    }

}

