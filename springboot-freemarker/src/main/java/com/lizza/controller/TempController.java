package com.lizza.controller;

import com.lizza.util.PdfHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.net.URL;
import java.util.HashMap;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-09-18
 */
@RestController
public class TempController {

    @GetMapping("hello")
    public String hello() {
        return "Hello Lizza!";
    }

    @GetMapping("pdf")
    public void getPath(HttpServletResponse response) {
        PdfHelper.download(response, new HashMap<>(), "temp.ftl");
    }
}
