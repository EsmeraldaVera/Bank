package org.example;

import org.example.web.TransferController;
import org.example.web.CustomerController;
import io.javalin.Javalin;

public class App {

    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            // your config here
            config.enableCorsForAllOrigins();
        }).start(8081);





        //------------------------------------
        // REST API
        //------------------------------------

        // Routes
        app.get("/", ctx ->ctx.result("Hello!")); //only indcluded this because paths are being glitchy
        app.post("/customers/", CustomerController.findByAccount);
        app.post("/customers/{customerId}/transfers",TransferController.createTransfer);
        app.get("/customers/{customerId}/transfers", TransferController.getAllTransfers);
        app.get("/customers/{customerId}/transfers/{id}",TransferController.getTransfer);


    }
}