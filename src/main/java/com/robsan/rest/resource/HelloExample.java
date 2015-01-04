package com.robsan.rest.resource;

import org.apache.log4j.Logger;

public class HelloExample{

    final static Logger logger = Logger.getLogger(HelloExample.class);

    public static void main(String[] args) {

        HelloExample obj = new HelloExample();
        obj.runMe("mkyong");

        logger.debug("IN MAIN This is debug : ");

    }

    private void runMe(String parameter){


        logger.debug("This is debug : " + parameter);



        logger.info("This is info : " + parameter);


        logger.warn("This is warn : " + parameter);
        logger.error("This is error : " + parameter);
        logger.fatal("This is fatal : " + parameter);

    }

}