package com.applibot.grpc.service

import com.applibot.gen.several.SeveralRequest
import com.applibot.gen.several.SeveralResponse
import com.applibot.gen.several.SeveralServiceGrpc
import io.grpc.stub.StreamObserver
import org.lognet.springboot.grpc.GRpcService

@GRpcService
class SeveralServer : SeveralServiceGrpc.SeveralServiceImplBase() {
    override fun getSeveralData(request: SeveralRequest?, responseObserver: StreamObserver<SeveralResponse>?) {
        println("float " + request?.floatData)
        println("double " + request?.doubleData)
        println("int " + request?.intData)
        println("long " + request?.longData)
        println("bool " + request?.boolData)
        println("string " + request?.stringData)
        println("bytes " + request?.byteData)
        println("list " + request?.listList)
        println("inner " + request?.innerListList)
        println("dic " + request?.dicMap)
        println("dicRepeat " + request?.dicRepeatMap)
        println("Animal " + request?.animal)
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