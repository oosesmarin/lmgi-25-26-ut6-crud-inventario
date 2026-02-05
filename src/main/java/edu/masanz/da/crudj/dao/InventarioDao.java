package edu.masanz.da.crudj.dao;

import edu.masanz.da.crudj.gui.InventarioGui;
import edu.masanz.da.crudj.dto.Item;

import java.util.*;
import java.util.Map.Entry;

import static edu.masanz.da.crudj.config.Config.*;

public class InventarioDao {
    private static Map<String, Item> inventario;


    public static void inicializarInventario() {
        inventario = new HashMap<>();
        agregarItemsRandom();
    }

    public static void agregarItem(Item item) {
        inventario.put(item.getNombre(), item);
        InventarioGui.mesajeAgregarItem(item, item.getCantidad());
    }

    public static void perderItem(Item item, int n) {
        int nuevaCantidad = item.getCantidad() - n;
        if (nuevaCantidad == 0) {
            inventario.remove(item.getNombre());
        } else {
            item.setCantidad(nuevaCantidad);
        }
    }

    public static Item getItemById(String idItem) {
        Set<Entry<String, Item>> entradas = inventario.entrySet();
        for (Entry<String, Item> entrada : entradas) {
            if (entrada.getKey().equalsIgnoreCase(idItem)) {
                return inventario.get(entrada.getKey());
            }
        }
        return null;
    }

    public static List<Item> obtenerItems() {
        List<Item> items = new ArrayList<>();
        for (Item value : inventario.values()) {
            items.add(value);
        }
        return items;
    }

    public static void agregarItemsRandom() {
        agregarItemsRandom(ITEMS_INICALES);
    }

    public static void agregarItemsRandom(int cantidad) {
        int itemsRestantes = cantidad;
        while (itemsRestantes > 0) {
            String nombre = ITEMS[(int) (Math.random() * ITEMS.length)];
            Item itemRandom = new Item(nombre, (int) (Math.random() * 5) + 1);
            if (getItemById(nombre) == null) {
                agregarItem(itemRandom);
                itemsRestantes--;
            }
        }
    }
}
