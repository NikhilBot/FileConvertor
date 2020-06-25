package com.manifesting.fileConvertor.Aggregator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.opendevl.JFlat;
import com.manifesting.fileConvertor.Parser.JsonTemplateParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class JsonToXml implements CommandLineRunner {

    @Autowired
    TagAggregator tagAggregator;
    @Autowired
    JsonTemplateParser jsonTemplateParser;
    @Autowired
    PebbleExample pebbleExample;

    @Autowired
    VelocityExample velocityExample;
    private final Map<String,Object> manifestMap = new HashMap<>();
    public void convert() throws IOException {

         String partFileSpec;
         String batchFileSpec;
        partFileSpec = jsonTemplateParser.parseJsonTemplate("partFileElement");
        batchFileSpec = jsonTemplateParser.parseJsonTemplate("batchFileElement");
        Map<?,?> partFileMap = tagAggregator.aggregatePartFile(partFileSpec);
        Map<?,?> batchFileMap = tagAggregator.aggregateBatchFile(batchFileSpec);
        createMap(partFileMap,batchFileMap);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(out , manifestMap);


        /*JSONArray jsonArray = new JSONArray();
        jsonArray.put(mapper.writeValueAsString(manifestMap));


        System.out.println(jsonArray);
        String csv = CDL.toString(jsonArray);
        System.out.println(csv);
        String xml = U.jsonToXml(String.valueOf(out.toString()));
        try{
            FileWriter xmlFw=new FileWriter("C:\\Users\\Nikhil\\Desktop\\Renderer\\RendererOutputFiles\\XMLOutput.xml");
            FileWriter jsonFw=new FileWriter("C:\\Users\\Nikhil\\Desktop\\Renderer\\RendererOutputFiles\\JSONOutput.json");
            FileWriter csvFw=new FileWriter("C:\\Users\\Nikhil\\Desktop\\Renderer\\RendererOutputFiles\\CSVOutput.csv");

            csvFw.write(csv);
            xmlFw.write(U.formatXml(xml));
            jsonFw.write(out.toString());
            jsonFw.close();
            xmlFw.close();
        }catch(Exception e){System.out.println(e);}*/


        JFlat flatMe = new JFlat(out.toString());

//directly write the JSON document to CSV
        flatMe.json2Sheet().write2csv("C:\\Users\\Nikhil\\Desktop\\Renderer\\RendererOutputFiles\\CSVOutput.json");
    }

    private void createMap(Map<?,?> map,Map<?,?> map2){
        Map<Object,Object> map3 = new HashMap<>();
        for (Map.Entry<?, ?> entry : map2.entrySet())
            map3.put(entry.getKey() , entry.getValue());
        for (Map.Entry<?, ?> entry : map.entrySet())
            map3.put(entry.getKey() , entry.getValue());
        manifestMap.put("amazonManifest" , map3);
    }
    @Override
    public void run ( String... args ) throws Exception {
//        long startTime = System.currentTimeMillis();
        convert();
//        long stopTime = System.currentTimeMillis();
//        long elapsedTime = stopTime - startTime;
//        System.out.println(elapsedTime);
//        long MEGABYTE = 1024L * 1024L;
//        Runtime runtime = Runtime.getRuntime();
//        runtime.gc();
//        long memory = runtime.totalMemory() - runtime.freeMemory();
//        System.out.println(memory/MEGABYTE);
//        FileWriter performFw=new FileWriter("C:\\Users\\Nikhil\\Desktop\\Renderer\\RendererOutputFiles\\performance.txt");
//        performFw.write("Time in milliseconds: " + elapsedTime +"\n");
//        performFw.write("Memory in MB: " + memory +"\n");
//        performFw.close();
//        velocityExample.velocityExample();
//        pebbleExample.pebbleTemplateExample();


    }
}

