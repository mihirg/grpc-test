package in.gore;

import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {

    private static HelloWorldServiceGrpc.HelloWorldServiceBlockingStub stub;
    public HelloResource() {
        if (stub == null) {
            Channel channel = Grpc.newChannelBuilder("localhost:45000", InsecureChannelCredentials.create()).build();
            stub =  HelloWorldServiceGrpc.newBlockingStub(channel);
        }
    }

    @GET
    @Path("/{param}")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("param") String name) {
        HelloWorld.HelloResponse response = stub.hello(HelloWorld.HelloRequest.newBuilder().setText(name).build());
        return response.getText();
    }
}
