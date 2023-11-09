package actividad1;

import controller.FuncionariosController;
import domain.Funcionarios;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class Actividad1 {

    public static void main(String[] args) throws SQLException {
        
          Scanner scanner = new Scanner(System.in);
        FuncionariosController funcionariosController;

        try {
            funcionariosController = new FuncionariosController();

            while (true) {
                System.out.println("Menú:");
                System.out.println("1. Crear un nuevo funcionario");
                System.out.println("2. Actualizar un funcionario existente");
                System.out.println("3. Listar todos los funcionarios");
                System.out.println("4. Eliminar un funcionario existente");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                switch (opcion) {
                    case 1:
                        // Crear un nuevo funcionario
                        Funcionarios nuevoFuncionario = obtenerDatosFuncionarioDesdeConsola(scanner);
                        funcionariosController.agregarFuncionario(nuevoFuncionario);

                        // Mostrar el nuevo funcionario
                        Funcionarios funcionarioCreado = funcionariosController.obtenerFuncionario(nuevoFuncionario.getIDEmpleado());
                        if (funcionarioCreado != null) {
                            System.out.println("Nuevo funcionario creado:");
                            System.out.println(funcionarioCreado);
                        } else {
                            System.out.println("No se pudo obtener el nuevo funcionario.");
                        }
                        break;
                    case 2:
                        // Actualizar un funcionario existente
                        Funcionarios funcionarioActualizado = obtenerDatosFuncionarioDesdeConsola(scanner);
                        funcionariosController.actualizarFuncionario(funcionarioActualizado);
                        System.out.println("Funcionario actualizado.");
                        break;
                    case 3:
                        // Listar todos los funcionarios
                        List<Funcionarios> funcionarios = funcionariosController.obtenerFuncionarios();
                        if (funcionarios.isEmpty()) {
                            System.out.println("No hay funcionarios registrados.");
                        } else {
                            System.out.println("Lista de funcionarios:");
                            for (Funcionarios funcionario : funcionarios) {
                                System.out.println(funcionario);
                            }
                        }
                        break;
                    case 4:
                        // Eliminar un funcionario existente
                        System.out.print("Ingrese el ID del funcionario a eliminar: ");
                        int idFuncionarioEliminar = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea
                        funcionariosController.eliminarFuncionario(idFuncionarioEliminar);
                        System.out.println("Funcionario eliminado.");
                        break;
                    case 5:
                        System.out.println("Saliendo del programa.");
                        return;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al conectarse a la base de datos.");
        }
    }

    private static Funcionarios obtenerDatosFuncionarioDesdeConsola(Scanner scanner) {
        Funcionarios nuevoFuncionario = new Funcionarios();

        System.out.print("Número de Identificación: ");
        nuevoFuncionario.setNumeroIdentificacion(scanner.nextInt());
        scanner.nextLine(); // Limpiar el salto de línea

        System.out.print("Tipo de Identificación: ");
        nuevoFuncionario.setTipoIdentificacion(scanner.nextLine());

        System.out.print("Nombres: ");
        nuevoFuncionario.setNombres(scanner.nextLine());

        System.out.print("Apellidos: ");
        nuevoFuncionario.setApellidos(scanner.nextLine());

        System.out.print("Estado Civil: ");
        nuevoFuncionario.setEstadoCivil(scanner.nextLine());

        System.out.print("Género: ");
        nuevoFuncionario.setGenero(scanner.nextLine());

        System.out.print("Dirección: ");
        nuevoFuncionario.setDireccion(scanner.nextLine());

        System.out.print("Teléfono: ");
        nuevoFuncionario.setTelefono(scanner.nextInt());
        scanner.nextLine(); // Limpiar el salto de línea

        System.out.print("Fecha de Nacimiento (YYYY-MM-DD): ");
        nuevoFuncionario.setFechaNacimiento(scanner.nextLine());

        return nuevoFuncionario;
    }
}
