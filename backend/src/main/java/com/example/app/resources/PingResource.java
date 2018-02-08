package com.example.app.resources;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PingResource {

    @GetMapping(path = "/ping")
    public ResponseEntity<Map<String, String>> ping() {
        Map<String, String> map = new HashMap<>();
        map.put("ping", "pong");
        map.put("pang", "pong");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }


    @RequestMapping(path = "/put", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> put(@RequestBody String filePath) {
        Map<String, String> map = new HashMap<>();
        map.put("filePath", filePath);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
