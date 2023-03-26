package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class SampleApp {
    public static void main(String[] args) throws IOException {
        //JSONObject jsonObject = new JSONObject("{\"phonetype\":\"N95\",\"cat\":\"WP\"}");
        String readDataFromFile= FileUtils.readFileToString(new File("C:\\Users\\muppa\\IdeaProjects\\untitled2\\src\\main\\resources\\sample.txt"));

        JsonObject jsonObject = new JsonParser().parse(readDataFromFile).getAsJsonObject();
        System.out.println(jsonObject.toString());
    }
}
