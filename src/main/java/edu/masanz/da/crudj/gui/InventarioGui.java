package edu.masanz.da.crudj.gui;

import edu.masanz.da.crudj.dto.Item;

public class InventarioGui {

    public static void mostrarItem(Item item) {
        System.out.printf("\t%s\n", item.toString());
    }

    public static void mesajePerderItem(Item item, int n) {
        System.out.printf("Has perdido %d de %s\n", n, item.getNombre());
    }

    public static void mesajeAgregarItem(Item item, int n) {
        System.out.printf("Has ganado %d de %s\n", n, item.getNombre());
    }
}
