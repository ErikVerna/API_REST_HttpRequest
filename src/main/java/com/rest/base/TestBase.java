package com.rest.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public Properties prop;

    public final int ResponseCode_200 = 200;
    public final int ResponseCode_201 = 201;
    public final int ResponseCode_400 = 400;
    public final int ResponseCode_401 = 401;
    public final int ResponseCode_404 = 404;
    public final int ResponseCode_500 = 500;

    public TestBase(){
        prop = new Properties();
        FileInputStream inputStream;

        try {
        inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/rest/config/config.properties");

            prop.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
