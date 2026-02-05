package edu.masanz.da.crudj.app;

import edu.masanz.da.crudj.dao.InventarioDao;
import edu.masanz.da.crudj.gui.InventarioGui;
import edu.masanz.da.crudj.dto.Item;

import java.util.Iterator;
import java.util.List;

import static edu.masanz.da.crudj.config.Config.*;

public class App {

    public void run() {
        jugar();
    }

    public void jugar() {
        InventarioDao.inicializarInventario();
        for (int i = 1; i <= CICLOS; i++) {
            System.out.println("\t=======================");
            System.out.println("\t     AVENTURA Nº" + i);
            System.out.println("\t=======================");
            irDeAventura();
        }
    }

    private void irDeAventura() {
        agregarItems(3);
        perderItems();
        mostrarInvetario();
    }

    private void mostrarInvetario() {
        System.out.println("INVENTARIO");
        List<Item> items = InventarioDao.obtenerItems();
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            InventarioGui.mostrarItem(iterator.next());
        }
    }

    private void agregarItems(int n) {
        InventarioDao.agregarItemsRandom(n);
    }

    private void perderItems() {
        Iterator<Item> iterator = InventarioDao.obtenerItems().iterator();
        while (iterator.hasNext()) {
            String idItem = iterator.next().getNombre();
            if ((int) (Math.random() * 100) + 1 <= PROBABILIDAD_PERDIDA) {
                perderItem(idItem);
            }
        }
    }

    private boolean perderItem(String idItem) {
        Item item = InventarioDao.getItemById(idItem);
        if (item != null) {
            int cantidad = (int) (Math.random() * item.getCantidad()) + 1;
            InventarioDao.perderItem(item, cantidad);
            InventarioGui.mesajePerderItem(item, cantidad);
            return true;
        }
        return false;
    }
}
