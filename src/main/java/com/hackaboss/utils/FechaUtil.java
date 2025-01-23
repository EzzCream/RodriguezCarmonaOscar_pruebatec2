package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class FechaUtil {
    //Esta funcion tiene como proposito darle formato a la fecha, para que se pueda guardar de manera correcta en la base de datos
    public static LocalDate fechaFormato(String fechaIngresada) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha = null;
        boolean fechaValida = false;
        while (!fechaValida) {
            try {
                fecha = LocalDate.parse(fechaIngresada, formato);
                fechaValida = true;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Por favor, intenta nuevamente.");
            }
        }
        return fecha;
    }
}