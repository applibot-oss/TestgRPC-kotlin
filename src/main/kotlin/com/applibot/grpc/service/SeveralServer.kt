package com.applibot.grpc.service

import com.applibot.gen.several.SeveralData
import com.applibot.gen.several.SeveralServiceGrpc
import io.grpc.stub.StreamObserver
import org.lognet.springboot.grpc.GRpcService
import java.io.File

@GRpcService
class SeveralServer : SeveralServiceGrpc.SeveralServiceImplBase() {

    val file = File("/Users/s01308/result/server.txt").absoluteFile

    override fun getSeveralData(request: SeveralData?, responseObserver: StreamObserver<SeveralData>?) {
        val time = System.currentTimeMillis()
        file.appendText("$time\n")
        responseObserver?.onNext(request)
        responseObserver?.onCompleted()
    }
}