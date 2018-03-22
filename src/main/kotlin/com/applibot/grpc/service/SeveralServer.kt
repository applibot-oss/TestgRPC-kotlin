package com.applibot.grpc.service

import com.applibot.gen.several.SeveralRequest
import com.applibot.gen.several.SeveralResponse
import com.applibot.gen.several.SeveralServiceGrpc
import io.grpc.stub.StreamObserver
import org.lognet.springboot.grpc.GRpcService
import java.io.File

@GRpcService
class SeveralServer : SeveralServiceGrpc.SeveralServiceImplBase() {

    val file = File("/Users/s01308/result/server.txt").absoluteFile

    override fun getSeveralData(request: SeveralRequest?, responseObserver: StreamObserver<SeveralResponse>?) {
        val time = System.currentTimeMillis()
        file.appendText("$time\n")
        val resp = SeveralResponse.newBuilder().setIsSuccess(true).build()
        responseObserver?.onNext(resp)
        responseObserver?.onCompleted()
    }

    override fun updateSeveralData(request: SeveralRequest?, responseObserver: StreamObserver<SeveralResponse>?) {
        val resp = SeveralResponse.newBuilder().setIsSuccess(true).build()
        responseObserver?.onNext(resp)
        responseObserver?.onCompleted()
    }
}