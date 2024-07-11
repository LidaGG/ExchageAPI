/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertidor_monedas_conappi;

import java.util.Scanner;


public class Menu {
    private final CurrencyConverter converter;
    private final Scanner scanner;

    public Menu() {
        this.converter = new CurrencyConverter();
        this.scanner = new Scanner(System.in);
    }

    public void show() {
        while (true) {
            displayMenuOptions();
            int option = scanner.nextInt();

            if (option == 5) {
                System.out.println("Saliendo...");
                break;
            }

            System.out.print("Introduce la cantidad: ");
            double amount = scanner.nextDouble();

            switch (option) {
                case 1:
                    converter.convert("USD", "EUR", amount);
                    break;
                case 2:
                    converter.convert("EUR", "USD", amount);
                    break;
                case 3:
                    converter.convert("USD", "MXN", amount);
                    break;
                case 4:
                    converter.convert("MXN", "USD", amount);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
        scanner.close();
    }

    private void displayMenuOptions() {
        System.out.println("Convertidor de Monedas");
        System.out.println("1. USD a EUR");
        System.out.println("2. EUR a USD");
        System.out.println("3. USD a MXN");
        System.out.println("4. MXN a USD");
        System.out.println("5. Salir");
        System.out.print("Elige una opción: ");
    }
}
