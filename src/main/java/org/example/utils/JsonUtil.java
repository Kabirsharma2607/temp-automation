package org.example.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUtil {
    private static List<Data> dataList;

    static {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            dataList = objectMapper.readValue(new File("src/test/datafiles/logindata.json"), new TypeReference<List<Data>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load login data");
        }
    }


    public static List<Data> getLoginDataList() {
        return dataList;
    }

    // Example method to get a specific entry
    public static Data getData(int index) {
        if (index >= 0 && index < dataList.size()) {
            return dataList.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid index for login data");
        }
    }
}
