package com.example.springbootwebquickstart;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResponseController {
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException {
        response.setStatus(200);
        response.setHeader("name", "itheima");
        response.getWriter().write("<h1> hello response </h1>");
    }

    /**
     * 基于ResponseEntity
     */
    @RequestMapping("/response2")
    public ResponseEntity<String> response2() {
        return ResponseEntity.status(200)
                .header("name","javaweb ai")
                .body("<h1> hello response </h1>");

    }

}
