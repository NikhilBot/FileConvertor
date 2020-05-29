package com.manifesting.fileConvertor.UtilClasses;

import com.manifesting.fileConvertor.tcda.repository.TcdaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FunctionUtil implements CommandLineRunner {


    @Autowired
    TcdaRepository tcdaRepository;

    public String getCity ( String id ) {
        return tcdaRepository.findById(id).get().getCity();
    }

    public String getName ( String id ) {
        return tcdaRepository.findById(id).get().getName();
    }

    public String getZip ( String id ) {
        return tcdaRepository.findById(id).get().getZip();
    }

    public String getCountryName ( String id ) {
        return tcdaRepository.findById(id).get().getCountryName();
    }

    public String getCountryCode ( String id ) {
        return tcdaRepository.findById(id).get().getCountryCode();
    }

    public String getContact ( String id ) {
        return tcdaRepository.findById(id).get().getContactPhone();
    }

    public String getLength ( String id ) {
        return tcdaRepository.findById(id).get().getLength();
    }

    public String getHeight ( String id ) {
        return tcdaRepository.findById(id).get().getHeight();
    }


    @Override
    public void run ( String... args ) throws Exception {

    }


}
