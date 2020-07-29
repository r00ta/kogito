import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.acme.OperatorSearchService;

public class OperatorSearchServiceTest {

    public static void main(String[] args) throws JsonProcessingException, IOException {
        System.out.print(OperatorSearchService.isAvailable());
    }    
}