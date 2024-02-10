package in.gore;

import in.gore.HelloWorldServiceGrpc;
import io.grpc.stub.StreamObserver;

public class ServiceImpl extends HelloWorldServiceGrpc.HelloWorldServiceImplBase{

    @Override
    public void hello(HelloWorld.HelloRequest request, StreamObserver<HelloWorld.HelloResponse> responseObserver) {
        String text = request.getText();
        HelloWorld.HelloResponse response = HelloWorld.HelloResponse.newBuilder().setText("API Called").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void streamingHello(HelloWorld.HelloRequest request, StreamObserver<HelloWorld.HelloResponse> responseObserver) {
        for (int i = 0; i<10; i++) {
            HelloWorld.HelloResponse helloResponse = HelloWorld.HelloResponse.newBuilder().setText("testing").build();
            responseObserver.onNext(helloResponse);
        }
        responseObserver.onCompleted();
    }
}
