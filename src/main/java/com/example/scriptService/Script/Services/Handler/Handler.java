package com.example.scriptService.Script.Services.Handler;

import com.example.scriptService.Script.Services.ScriptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.IOException;

@Configuration
@KafkaListener( topics = {"${script.commands.topic.name}"})
public class Handler {
    @Autowired
    ScriptService scriptService;
    private static final Logger log = LoggerFactory.getLogger(Handler.class);

    @KafkaHandler
    public void getHandler( String uuid) throws IOException {
        log.info("uuid id{}",uuid );
        String storagePath = uuid+"/project.zip";
 scriptService.generateService(uuid);
    }
}
