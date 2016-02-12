package com.linroutingsystems.routedisttimecomp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chow on 2/11/2016.
 */
public class DataPoints {
    private List<String> origin_addresses;
    private List<String> destination_addresses;
    private ArrayList distance;
    private ArrayList duration;

    public DataPoints(){
        this.origin_addresses = null;
        this.destination_addresses = null;
        this.distance = null;
        this.duration = null;
    }
    public DataPoints(List<String> origin_addresses, List<String> destination_addresses, ArrayList distance, ArrayList duration){
        this.origin_addresses = origin_addresses;
        this.destination_addresses = destination_addresses;
        this.distance = distance;
        this.duration = duration;
    }

}
