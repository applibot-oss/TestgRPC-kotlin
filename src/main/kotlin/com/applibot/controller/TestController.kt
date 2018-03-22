package com.applibot.controller

import com.applibot.data.Several
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(path = ["several"])
class TestController {

    @RequestMapping(path = ["test"], method = arrayOf(RequestMethod.POST))
    fun getSeveralData(@RequestBody model: Several): Several {
        return Several(model.id, model.name, model.email)
    }
}