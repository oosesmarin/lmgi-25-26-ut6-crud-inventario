package edu.masanz.da.crudj;

import edu.masanz.da.crudj.app.App;
import edu.masanz.da.crudj.controller.ItemController;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinFreemarker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        App aventura = new App();
        aventura.run();

        logger.info("ARRANCANDO APLICACION");

        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("public");
            config.fileRenderer(new JavalinFreemarker());
        }).start(8080);

        app.get("/", ItemController::servirIndice);
        app.get("/lista-items", ItemController::servirLista);
        app.get("/item/{id}", ItemController::servirItem);
        app.get("/crea-item", ItemController::servirCrearItem);
        app.post("/crea-item", ItemController::crearItem);
        app.get("//edita-item/{id}", ItemController::servirEditarItem);
        app.post("//edita-item/{id}", ItemController::editarItem);
//        app.get("/elimina-item/{id}", ItemController::servirEliminarItem);
//        app.post("/elimina-item/{id}", ItemController::eliminarItem);
        app.get("/elimina-item/{id}", ItemController::eliminarItem);
        app.get("/error", ItemController::servirError);

    }

}