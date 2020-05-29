package com.manifesting.fileConvertor.Parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manifesting.fileConvertor.Aggregator.TagAggregator;
import com.manifesting.fileConvertor.UtilClasses.GetFunctionFromDms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class Parser implements CommandLineRunner {

    @Autowired
    GetFunctionFromDms getFunctionFromDms;
    @Autowired
    TagAggregator tagAggregator;

    private final StringBuilder jsonString;

    public Parser () {
        this.jsonString = new StringBuilder();
    }

    @Override
    public void run ( String... args ) throws Exception {
        parseWithJackson();
        String data = String.valueOf(tagAggregator.aggregate(jsonString));
        System.out.println(data);
    }


    private void parseWithJackson () {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            Map<?, ?> map = mapper.readValue(Paths.get("C:\\Users\\Nikhil\\Desktop\\JavaProj\\New folder\\newDemo\\json.json").toFile() ,Map.class);
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                if (entry.getKey().equals("partFileElement")) {
                    parseArrayList((ArrayList<?>) entry.getValue());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void parseArrayList ( ArrayList<?> list ) throws IOException {
        for (Object o : list)
            if (o instanceof String) {
                // String s[] = ((String) o).split("\\.");
            } else if (o instanceof ArrayList) {
                parseArrayList((ArrayList<?>) o);
            } else {
                parseObject((LinkedHashMap) o);
            }
    }

    private void parseObject ( LinkedHashMap o ) throws IOException {

        if (o.containsKey("tag")) {
            jsonString.append("Start tag: ").append(o.get("tag")).append("\n");
            String temp = (String) o.get("tag");
            parseArrayList((ArrayList<?>) o.get("body"));
            jsonString.append("End tag: ").append(temp).append("\n");
        } else {
            if (o.containsKey("body")) {
                parseArrayList((ArrayList<?>) o.get("body"));
            } else if (o.containsKey("attributeId")) {
                jsonString.append(getFunctionFromDms.getFunctionFromDms((String) o.get("attributeId"))).append("\n");
            }
        }
    }


}
