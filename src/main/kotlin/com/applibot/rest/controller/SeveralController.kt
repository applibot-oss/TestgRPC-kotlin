package com.applibot.rest.controller

import com.applibot.gen.several.SeveralRequest
import com.applibot.gen.several.SeveralResponse
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["several"])
class SeveralController {
    @RequestMapping(path = ["data"], method = arrayOf(RequestMethod.POST))
    fun getSeveralData(@RequestBody model: SeveralRequest): SeveralResponse {
        return SeveralResponse.newBuilder().setIsSuccess(true).build()
    }
}