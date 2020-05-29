package com.manifesting.fileConvertor.Aggregator;

import com.manifesting.fileConvertor.UtilClasses.FunctionUtil;
import com.manifesting.fileConvertor.tcda.repository.TcdaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Scanner;

@Component
public class TagAggregator implements CommandLineRunner {
    @Override
    public void run ( String... args ) throws Exception {
    }

    @Autowired
    TcdaRepository tcdaRepository;
    @Autowired
    FunctionUtil functionUtil;
    private List<String> objList;
    private final StringBuilder aggregatedFile = new StringBuilder();

    public StringBuilder aggregate ( StringBuilder temp ) throws NoSuchMethodException {
        getObjList();
        for (String s : objList) {
            Scanner tempScanner = new Scanner(String.valueOf(temp));
            while (tempScanner.hasNextLine()) {
                String line = tempScanner.nextLine();
                appendLine(line,s);
            }
            tempScanner.close();
        }
        return aggregatedFile;

    }

    private void appendLine ( String line , String s ) {
        Scanner lineScanner = new Scanner(line);
        String word = lineScanner.next();
        if (!word.startsWith("Start") && !word.startsWith("End")) {
            String result = "";
            try {
                Object[] obj = {s};
                Class<?>[] params = new Class[obj.length];
                for (int i = 0; i < obj.length; i++) {
                    if (obj[i] != null) {
                        params[i] = String.class;
                    }
                }
                result = (String) functionUtil.getClass().getDeclaredMethod(word,params).invoke(functionUtil ,obj);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                //e.printStackTrace();
            }
            aggregatedFile.append(result).append("\n");
        } else aggregatedFile.append(line).append("\n");
        lineScanner.close();

    }

    private void getObjList () {
        objList = tcdaRepository.findAllTrackingId();
    }

}
