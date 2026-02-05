package edu.masanz.da.crudj;

import edu.masanz.da.crudj.app.App;
import edu.masanz.da.crudj.controller.ItemController;
import edu.masanz.da.crudj.controller.NotaController;

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
        app.get("/item/{id}", ItemController::servirNota);
//        app.get("/crea-item", NotaController::servirCrearNota);
//        app.post("/crea-item", NotaController::crearNota);
//        app.get("//edita-item/{id}", NotaController::servirEditarNota);
//        app.post("//edita-item/{id}", NotaController::editarNota);
//        app.get("/elimina-item/{id}", NotaController::servirEliminarNota);
//        app.post("/elimina-item/{id}", NotaController::eliminarNota);
//        app.get("/error", NotaController::servirError);

    }

}