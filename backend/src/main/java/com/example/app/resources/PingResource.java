package com.example.app.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class PingResource {

    @GetMapping(path = "/ping")
    public ResponseEntity<Map<String, String>> ping() {
        Map<String, String> map = new HashMap<>();
        map.put("ping", "pong");
        map.put("pang", "pong");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    private String getUpdatedFilePath(String filePath, String partToRemove, String partToAdd) {
        return filePath.substring(0, filePath.length() - partToRemove.length()) + partToAdd;
    }

    /**
     * This method takes a path as an input in which the compressed files
     * will be present and we will detect them.
     *
     * @param folderPath path of folder that contains data files
     * @return response
     */
    @RequestMapping(path = "/put", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> put(@RequestBody String folderPath) {
        File folder = new File(folderPath);
        Map<String, String> map = new HashMap<>();

        Map<String, String> extensionsToBeExtracted = new HashMap<>();
        extensionsToBeExtracted.put(".gz", ".txt");
        extensionsToBeExtracted.put(".bz2", ".txt2");

        List<String> gZippedFiles = new ArrayList<>();
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            for (String extension : extensionsToBeExtracted.keySet()) {
                if (file.getName().endsWith(extension)) {
                    map.put(file.getPath(),
                            getUpdatedFilePath(file.getPath(), extension, extensionsToBeExtracted.get(extension)));
                    gZippedFiles.add(file.getPath());
                }
            }
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
