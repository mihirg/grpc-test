package in.gore;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting server");
        Server start = ServerBuilder.forPort(45000)
                .addService(new ServiceImpl())
                .build()
                .start();
        start.awaitTermination();
        System.out.println("Server Terminated");
    }
}