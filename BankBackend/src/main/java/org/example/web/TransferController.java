package org.example.web;

import org.example.entity.Transfer;
import org.example.repository.JpaTransferRepository;
import org.example.repository.TransferRepository;
import io.javalin.http.Handler;
import org.eclipse.jetty.http.HttpStatus;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TransferController {

    static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
    }

    //-------------------------------------------------
    static TransferRepository transferRepository = new JpaTransferRepository(entityManagerFactory);
    //--------------------------------------------------

    public static Handler createTransfer = ctx -> {
        String userId=ctx.pathParam("customerId");
        System.out.println(userId);
        Transfer transfer = ctx.bodyAsClass(Transfer.class);
        transferRepository.save(transfer);
        ctx.status(HttpStatus.CREATED_201);
    };

    public static Handler getAllTransfers = ctx -> {
        String filter = ctx.queryParam("filter");
        if (filter == null) {
            filter = "all";
        }
        List<Transfer> transfer = transferRepository.findAll(filter);
        ctx.json(transfer);
    };

    public static Handler getTransfer = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Transfer transfer = transferRepository.findById(id);
        if (transfer == null) {
            ctx.status(HttpStatus.NOT_FOUND_404);
        } else
            ctx.json(transfer);
    };

//        public static Handler deleteTodo = ctx -> {
//        int id = Integer.parseInt(ctx.pathParam("id"));
//        todoRepository.delete(id);
//        ctx.status(HttpStatus.OK_200);
//    };

}
