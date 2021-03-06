package com.convector.hbaseloader.output;

import com.convector.hbaseloader.constants.cartodb.User;

/**
 * Created by pyro_ on 18/05/2016.
 */
public abstract class OutputerFactory {

    public static Outputer getOutputter (String type) {
        Outputer out = null;
        switch(type){
            case "screen":     out = new ScreenOutputer();
                break;

            case "hbase":       out = new HBaseInserter("validations");
                break;

            case "timehbase":   out = new HBaseTimeInserter("finalvalidations");
                break;

            case "cartodb":     out = new CartoDBInserter(User.CARLES.toString());
                break;

            case "progress":    out = new ScreenProgressOutputer();
                break;

            case "kafka":       out = new KafkaOutputer();
                break;

            case "timekafka":   out = new TimedKafkaOutputer();
                break;

            default:		    System.err.println("Outputter could not be identified");
        }
        return out;
    }
}
