package org.acme;

import java.io.IOException;
import java.io.InputStream;

import javax.enterprise.context.ApplicationScoped;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@ApplicationScoped
public class OperatorSearchService {

    public static boolean isAvailable() throws JsonProcessingException, IOException {
        
        ObjectMapper objectMapper = new ObjectMapper();
        //InputStream inputStream = OperatorSearchService.class.getClassLoader().getResourceAsStream("database.json");
        
        String json = "{ \"operator\" : { \"isAvailable\" : true } }";
        JsonNode jsonNode = objectMapper.readTree(json);
        JsonNode availableNode = jsonNode.at("/operator/isAvailable");
        return availableNode.asBoolean();
     }
}
