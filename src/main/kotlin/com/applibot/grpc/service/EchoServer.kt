package com.applibot.grpc.service

import com.applibot.gen.echo.EchoMessage
import com.applibot.gen.echo.EchoServiceGrpc
import io.grpc.stub.StreamObserver
import org.lognet.springboot.grpc.GRpcService

@GRpcService
class EchoServer : EchoServiceGrpc.EchoServiceImplBase() {
    override fun echoService(request: EchoMessage?, responseObserver: StreamObserver<EchoMessage>?) {
        val msg = EchoMessage.newBuilder().setMessage("echo \\${request?.message}/").build()
        responseObserver?.onNext(msg)
        responseObserver?.onCompleted()
    }
}