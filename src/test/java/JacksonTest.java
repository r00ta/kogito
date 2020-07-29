import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
/* 
        String jsonObject = "{\"brand\":\"ford\", \"doors\":5}";
        File file = new File("src/main/resources/database.json"); */
        InputStream inputStream = JacksonTest.class.getClassLoader().getResourceAsStream("database.json");
        JsonNode jsonNode = objectMapper.readTree(inputStream);

        /*
         * Map<String, Object> jsonMap = objectMapper.readValue(file, new
         * TypeReference<Map<String,Object>>(){});
         */
        JsonNode availableNode = jsonNode.at("/operator/isAvailable");
        boolean b = availableNode.asBoolean();
        System.out.println(b);
        // System.out.println(jsonMap.get("operator").get("isAvailable"));
        // System.out.println("car brand = " + jsonMap.get("brand"));
        // System.out.println("car doors = " + car.getDoors());
    }
}