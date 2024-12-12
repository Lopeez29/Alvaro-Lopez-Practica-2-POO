package electronica_main;

import electronica_main.electronica.articulos.Movil;
import electronica_main.electronica.articulos.Television;
import electronica_main.electronica.articulos.marcas.Marca;
import electronica_main.electronica.GestorElectronica;
import electronica_main.util.SistemaOperativo;
import electronica_main.util.TipoPantalla;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorElectronica gestor = new GestorElectronica();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            try {
                System.out.println("\n===== MENÚ DE GESTIÓN DE ELECTRÓNICA =====");
                System.out.println("1. Añadir Marca");
                System.out.println("2. Añadir Televisor");
                System.out.println("3. Añadir Móvil");
                System.out.println("4. Buscar Marca");
                System.out.println("5. Buscar Televisor");
                System.out.println("6. Buscar Móvil");
                System.out.println("7. Listar Marcas");
                System.out.println("8. Listar Artículos");
                System.out.println("9. Salir");
                System.out.print("Elige una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer residual

                switch (opcion) {
                    case 1:
                        System.out.print("Nombre de la marca: ");
                        String nombreMarca = scanner.nextLine();

                        System.out.print("País de origen: ");
                        String pais = scanner.nextLine();

                        float facturacion = solicitarFloat("Facturación: ", scanner);

                        if (gestor.anadirMarca(new Marca(nombreMarca, pais, facturacion))) {
                            System.out.println("Marca añadida correctamente.");
                        } else {
                            System.out.println("Error: La marca ya existe.");
                        }
                        break;

                    case 2:
                        System.out.print("Nombre de la marca del televisor: ");
                        String marcaTele = scanner.nextLine();
                        Marca marcaExistenteTele = gestor.buscarMarca(marcaTele);

                        if (marcaExistenteTele != null) {
                            System.out.print("Nombre del televisor: ");
                            String nombreTele = scanner.nextLine();

                            float precioTele = solicitarFloat("Precio del televisor: ", scanner);
                            int pulgadas = solicitarEntero("Pulgadas del televisor: ", scanner);

                            TipoPantalla tipoPantalla = solicitarTipoPantalla(scanner);

                            gestor.anadirArticulo(new Television(nombreTele, precioTele, marcaExistenteTele, pulgadas, tipoPantalla));
                            System.out.println("Televisor añadido correctamente.");
                        } else {
                            System.out.println("Error: La marca no existe.");
                        }
                        break;

                    case 3:
                        System.out.print("Nombre de la marca del móvil: ");
                        String marcaMovil = scanner.nextLine();
                        Marca marcaExistenteMovil = gestor.buscarMarca(marcaMovil);

                        if (marcaExistenteMovil != null) {
                            System.out.print("Nombre del móvil: ");
                            String nombreMovil = scanner.nextLine();

                            float precioMovil = solicitarFloat("Precio del móvil: ", scanner);
                            int ram = solicitarEntero("RAM del móvil (en GB): ", scanner);

                            SistemaOperativo sistemaOperativo = solicitarSistemaOperativo(scanner);

                            gestor.anadirArticulo(new Movil(nombreMovil, precioMovil, marcaExistenteMovil, ram, sistemaOperativo));
                            System.out.println("Móvil añadido correctamente.");
                        } else {
                            System.out.println("Error: La marca no existe.");
                        }
                        break;

                    case 4:
                        System.out.print("Nombre de la marca a buscar: ");
                        String nombreBuscar = scanner.nextLine();
                        Marca marcaEncontrada = gestor.buscarMarca(nombreBuscar);

                        if (marcaEncontrada != null) {
                            System.out.println("Marca encontrada: " + marcaEncontrada);
                        } else {
                            System.out.println("No se encontró la marca.");
                        }
                        break;

                    case 5:
                        TipoPantalla tipoTeleBuscar = solicitarTipoPantalla(scanner);
                        List<Television> televisores = gestor.buscarTelevisores(tipoTeleBuscar);

                        if (!televisores.isEmpty()) {
                            System.out.println("Televisores encontrados:");
                            televisores.forEach(System.out::println);
                        } else {
                            System.out.println("No se encontraron televisores con ese tipo de pantalla.");
                        }
                        break;

                    case 6:
                        SistemaOperativo sistemaMovilBuscar = solicitarSistemaOperativo(scanner);
                        List<Movil> moviles = gestor.buscarMoviles(sistemaMovilBuscar);

                        if (!moviles.isEmpty()) {
                            System.out.println("Móviles encontrados:");
                            moviles.forEach(System.out::println);
                        } else {
                            System.out.println("No se encontraron móviles con ese sistema operativo.");
                        }
                        break;

                    case 7:
                        System.out.println("Listado de marcas ordenadas por facturación:");
                        gestor.listarMarcas().forEach(System.out::println);
                        break;

                    case 8:
                        System.out.println("Listado de artículos ordenados:");
                        gestor.listarArticulos().forEach(System.out::println);
                        break;

                    case 9:
                        System.out.println("Saliendo del programa...");
                        salir = true;
                        break;

                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada no válida. Asegúrate de introducir el tipo de dato correcto.");
                scanner.nextLine(); // Limpiar buffer
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Valor inválido. " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }

        scanner.close();
    }

    // Métodos auxiliares para solicitar datos seguros
    private static float solicitarFloat(String mensaje, Scanner scanner) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Introduce un número válido.");
            }
        }
    }

    private static int solicitarEntero(String mensaje, Scanner scanner) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Introduce un número entero válido.");
            }
        }
    }

    private static TipoPantalla solicitarTipoPantalla(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Tipo de pantalla (LED, QLED, OLED, QNED): ");
                return TipoPantalla.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Tipo de pantalla no válido.");
            }
        }
    }

    private static SistemaOperativo solicitarSistemaOperativo(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Sistema Operativo (ANDROID, IOS): ");
                return SistemaOperativo.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Sistema operativo no válido.");
            }
        }
    }
}
