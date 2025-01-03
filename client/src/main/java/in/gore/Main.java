package in.gore;

import in.gore.HelloWorldServiceGrpc;
import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannelBuilder;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
//    public static void main(String[] args) throws Exception {
//        Channel channel =
//                Grpc.newChannelBuilder("localhost:45000", InsecureChannelCredentials.create()).build();
//        HelloWorldServiceGrpc.HelloWorldServiceBlockingStub stub =
//                HelloWorldServiceGrpc.newBlockingStub(channel);
////        for (int i = 0; i< 100; i++) {
////            HelloWorld.HelloResponse mihir = stub.hello(HelloWorld.HelloRequest.newBuilder().setText("Mihir").build());
////            System.out.println(mihir.getText());
////            Thread.sleep(2000);
////        }
//        try {
//            HelloWorld.HelloResponse resp = stub.hello(HelloWorld.HelloRequest.newBuilder().setText("Timbuktoo").build());
//            System.out.println(resp);
//            // sleep 6 mins
//            Thread.sleep(10 * 60 * 1000);
//            resp = stub.hello(HelloWorld.HelloRequest.newBuilder().setText("New York").build());
//            System.out.println(resp);
//        } catch (Exception exp) {
//            System.out.println(exp);
//            throw exp;
//        }
//    }

    public static void main(String[] args) throws Exception {
        ServletContextHandler handler = buildUsingResourceConfig();
        Server server = new Server(8080);
        server.setHandler(handler);
        try {
            server.start();
            server.join();
        } finally {
            server.destroy();
        }
    }

    private static ServletContextHandler buildUsingResourceConfig() {
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        handler.setContextPath("/");
        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(HelloResource.class);
        handler.addServlet(new ServletHolder(new ServletContainer(resourceConfig)), "/api/*");
        return handler;
    }
}
