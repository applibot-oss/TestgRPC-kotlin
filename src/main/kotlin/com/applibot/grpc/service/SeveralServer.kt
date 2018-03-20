package com.applibot.grpc.service

import com.applibot.gen.several.SeveralRequest
import com.applibot.gen.several.SeveralResponse
import com.applibot.gen.several.SeveralServiceGrpc
import io.grpc.stub.StreamObserver
import org.lognet.springboot.grpc.GRpcService

@GRpcService
class SeveralServer : SeveralServiceGrpc.SeveralServiceImplBase() {
    override fun getSeveralData(request: SeveralRequest?, responseObserver: StreamObserver<SeveralResponse>?) {
        val resp = SeveralResponse.newBuilder().setIsSuccess(true).addAllNames(listOf("taro", "jiro", "kogoro"))
                .addAllOlds(listOf(30, 42, 12)).build()
        responseObserver?.onNext(resp)
        responseObserver?.onCompleted()
    }

    override fun updateSeveralData(request: SeveralRequest?, responseObserver: StreamObserver<SeveralResponse>?) {
        val resp = SeveralResponse.newBuilder().setIsSuccess(true).build()
        responseObserver?.onNext(resp)
        responseObserver?.onCompleted()
    }
}