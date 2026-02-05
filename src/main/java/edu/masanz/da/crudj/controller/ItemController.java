package edu.masanz.da.crudj.controller;

import edu.masanz.da.crudj.dao.InventarioDao;
import edu.masanz.da.crudj.dto.Item;
import edu.masanz.da.crudj.dto.Nota;
import edu.masanz.da.crudj.service.NotaService;
import io.javalin.http.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

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

        model.put("items", InventarioDao.obtenerItems());

        context.render("templates/lista-items.ftl", model);
    }

    public static void servirNota(Context context){
        String idItem = context.pathParam("id");
        Map<String, Object> model = new HashMap<>();
        Item item = InventarioDao.getItemById(idItem);
        model.put("eliminar", false);
        model.put("item", item);
        context.render("templates/item.ftl", model);
    }
}
