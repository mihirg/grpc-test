package in.gore;

import in.gore.HelloWorldServiceGrpc;
import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannelBuilder;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
        Channel channel =
                Grpc.newChannelBuilder("localhost:45000", InsecureChannelCredentials.create()).build();
        HelloWorldServiceGrpc.HelloWorldServiceBlockingStub stub =
                HelloWorldServiceGrpc.newBlockingStub(channel);
        for (int i = 0; i< 100; i++) {
            HelloWorld.HelloResponse mihir = stub.hello(HelloWorld.HelloRequest.newBuilder().setText("Mihir").build());
            System.out.println(mihir.getText());
            Thread.sleep(2000);
        }
    }
}
