package com.ctgu.sell;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class loggertest02 {

    @Test
    public void Test02(){
        log.debug("debug...");
        log.info("info...");
        log.error("error...");
    }
}
