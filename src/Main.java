import Gestor.Tarea;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Tarea> tareas = new ArrayList<>();

        int opcion;

        do {

            System.out.println("GESTOR DE TAREAS");
            System.out.println("1. Añadir tarea");
            System.out.println("2. Ver tareas");
            System.out.println("3. Completar tarea");
            System.out.println("4. Eliminar tarea");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1 -> {
                    System.out.print("Descripción: ");
                    String descripcion = sc.nextLine();

                    tareas.add(new Tarea(descripcion));

                    System.out.println("Tarea añadida.");
                }

                case 2 -> {

                    if (tareas.isEmpty()) {
                        System.out.println("No hay tareas.");
                    } else {

                        for (int i = 0; i < tareas.size(); i++) {

                            String estado =
                                    tareas.get(i).isCompletada()
                                            ? "[COMPLETADA]"
                                            : "[PENDIENTE]";

                            System.out.println(
                                    (i + 1) + ". "
                                            + tareas.get(i).getDescripcion()
                                            + " "
                                            + estado
                            );
                        }
                    }
                }

                case 3 -> {

                    System.out.print("Número de tarea: ");
                    int num = sc.nextInt();

                    if (num >= 1 && num <= tareas.size()) {
                        tareas.get(num - 1).completar();
                        System.out.println("Tarea completada.");
                    } else {
                        System.out.println("Número incorrecto.");
                    }
                }

                case 4 -> {

                    System.out.print("Número de tarea a eliminar: ");
                    int num = sc.nextInt();

                    if (num >= 1 && num <= tareas.size()) {
                        tareas.remove(num - 1);
                        System.out.println("Tarea eliminada.");
                    } else {
                        System.out.println("Número incorrecto.");
                    }
                }



                default -> System.out.println("Opción no válida");
            }

        } while (opcion != 0);

        sc.close();
    }
}