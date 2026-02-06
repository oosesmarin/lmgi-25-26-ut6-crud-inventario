package edu.masanz.da.crudj.controller;

import edu.masanz.da.crudj.dao.InventarioDao;
import edu.masanz.da.crudj.dto.Item;
import edu.masanz.da.crudj.dto.Nota;
import io.javalin.http.Context;

import java.util.*;

public class ItemController {
    public static void servirIndice(Context context){
        Map<String, Object> model = new HashMap<>();
        model.put("titulo", "Inventario");
        model.put("encabezado", "Inventario interactivo con FreeMarker");
        context.render("templates/index.ftl", model);
    }

    public static void servirLista(Context context){
        Map<String, Object> model = new HashMap<>();

        model.put("numeroPagina", 0);
        model.put("tieneAnterior", false);
        model.put("paginaAnterior", 0);
        model.put("tieneSiguiente", false);
        model.put("paginaSiguiente", 0);

        Map<Integer, Item> items = new HashMap<>();
        for (Item item : InventarioDao.obtenerItems()) {
            items.put(item.getId(), item);
        }
        //model.put("items", InventarioDao.obtenerItems());
        model.put("items", items.values());

        context.render("templates/lista-items.ftl", model);
    }

    public static void servirItem(Context context){
        int idItem = Integer.parseInt(context.pathParam("id"));
        Map<String, Object> model = new HashMap<>();
        Item item = InventarioDao.getItemById(idItem);
        model.put("eliminar", false);
        model.put("item", item);
        context.render("templates/item.ftl", model);
    }

    public static void servirCrearItem(Context context){
        Map<String, Object> model = new HashMap<>();
        Item item = new Item("", 0);
        model.put("agregar", true);
        model.put("item", item);
        context.render("templates/form-item.ftl", model);
    }

    public static void crearItem(Context context){
        String nombre = context.formParam("nombre");
        int cantidad = Integer.parseInt(context.formParam("cantidad"));
        Item item = new Item(nombre, cantidad);
        InventarioDao.agregarItem(item);
        if (item.getId() != 0) {
            context.redirect("/lista-items");
//            response.redirect("/nota/" + nota.getId());
        }else {
            context.redirect("/error");
        }
    }

    public static void servirEditarItem(Context context){
        int idItem = Integer.parseInt(context.pathParam("id"));
        Map<String, Object> model = new HashMap<>();
        Item item = InventarioDao.getItemById(idItem);
        model.put("agregar", false);
        model.put("item", item);
        context.render("templates/form-item.ftl", model);
    }

    public static void editarItem(Context context){
        int id = Integer.parseInt(context.pathParam("id"));
        String nombre = context.formParam("nombre");
        int cantidad = Integer.parseInt(context.formParam("cantidad"));
        Item item = new Item(id, nombre, cantidad);
        InventarioDao.actualizarItem(id, item);
        context.redirect("/item/" + item.getId());
    }

    public static void servirEliminarItem(Context context){
        int id = Integer.parseInt(context.pathParam("id"));
        Map<String, Object> model = new HashMap<>();
        Item item = InventarioDao.getItemById(id);
        model.put("eliminar", true);
        model.put("item", item);
        context.render("templates/item.ftl", model);
    }

    public static void eliminarItem(Context context){
        int id = Integer.parseInt(context.pathParam("id"));
        InventarioDao.eliminarItem(id);
        context.redirect("/lista-items");
    }

    public static void servirError(Context context){
        Map<String, Object> model = new HashMap<>();
        context.render("templates/error.ftl", model);
    }
}
