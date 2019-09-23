package com.example.sampleapp1

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlController {

    @GetMapping("/")
    fun blog(model: Model): String {
        model["title"] = "Blog"
        return "Blog"
    }

//    @GetMapping("/error")
//    fun error(model: Model): String {
//        model["title"] = "Blog"
//        return "Blog"
//    }

}