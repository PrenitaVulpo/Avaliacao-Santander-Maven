package main;

import entities.RawOperation;
import utils.CSVUtil;

public class Main {
    public static void main(String[] args){
        CSVUtil util = new CSVUtil();

        RawOperation[] arr = util.getRawList().toArray(new RawOperation[0]);

        for (RawOperation entry : arr)
        {
            System.out.println(entry);
        }
    }
}
