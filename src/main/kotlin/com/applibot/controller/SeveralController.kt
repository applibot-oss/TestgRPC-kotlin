package com.applibot.controller

import com.applibot.data.SeveralDataBean
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.io.File


@RestController
@RequestMapping(path = ["several"])
class SeveralController {

    val file = File("/Users/s01308/jsonResult/server.txt").absoluteFile

    @RequestMapping(path = ["data"], method = arrayOf(RequestMethod.POST))
    fun getSeveralData(@RequestBody model: SeveralDataBean): SeveralDataBean {
        val time = System.currentTimeMillis()
        file.appendText("$time\n")
        return model
    }
}