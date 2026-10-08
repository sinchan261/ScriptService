package com.example.scriptService.Script.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ScriptService {

    private static final Logger log = LoggerFactory.getLogger(ScriptService.class);

    public Path generateService(String projectId) throws IOException {
        log.info("hello2");
       Path ScriptDirectory =  Path.of(
               "C:\\Users\\DELL\\Downloads\\Script\\src\\main\\java\\com\\example\\scriptService\\Script\\ScriptFiles"
       );

        Files.createDirectories(ScriptDirectory);
        log.info("Directory exists: {}", Files.exists(ScriptDirectory));
        String ziplocation = "https://YOUR_PROJECT.supabase.co/storage/v1/object/"
                + "generated-projects/" + projectId + "/project.zip";
        String scriptContent = "#!/bin/bash\n\n" + "ZIP_URL=\"" + ziplocation + "\"\n\n" + "echo \"Project ID: " + projectId + "\"\n" + "echo \"Project ZIP location: $ZIP_URL\"\n\n" + "# Download will be implemented later\n" + "# curl -L \"$ZIP_URL\" -o project.zip\n\n" + "echo \"Script generated successfully.\"\n";
        Path scriptFile = ScriptDirectory.resolve( "install-" + projectId + ".sh" );
        log.info("hello1");
        Files.writeString( scriptFile, scriptContent );
        return scriptFile;
    }
}
