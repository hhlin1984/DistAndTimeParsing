package com.linroutingsystems.routedisttimecomp;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.ExecutionException;

import com.linroutingsystems.routedisttimecomp.JSONParser;


/**
 * Created by Chow on 2/11/2016.
 */
public class EstablishURLConnection {
    void EstablishURLConnection(){
        // Empty Constructor
    }
    public String URLConnection(String destination){
        String inputData = "FAILURE";
        /*
        URL googleDistanceAndTimeServer = null;
        try {
            googleDistanceAndTimeServer = new URL(destination);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URLConnection gDATSConnect = null;
        try {
            gDATSConnect = googleDistanceAndTimeServer.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(gDATSConnect.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                inputData += inputLine + "\n";
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
//        DownloadData downloadedData = new DownloadData();
//       inputData = downloadedData.execute(destination);
        try {
            inputData = new DownloadData().execute(destination).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Log.e("EstablishURL, URL Con", inputData);
        return inputData;
    }

    private class DownloadData extends AsyncTask<String, Void, String>{
        protected String doInBackground(String... destination){
            String inputData = "";
            URL googleDistanceAndTimeServer = null;
            try {
                googleDistanceAndTimeServer = new URL(destination[0]);
                Log.e("EstablishURL, DD, Dest", destination[0]);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            URLConnection gDATSConnect = null;
            try {
                gDATSConnect = googleDistanceAndTimeServer.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(gDATSConnect.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                    inputData += inputLine + "\n";
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.e("EstablishURL, DD", inputData);
            return inputData;
        }
    }

}
