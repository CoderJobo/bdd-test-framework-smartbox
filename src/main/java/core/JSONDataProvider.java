package core;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class JSONDataProvider {

    private Reader reader;
    private Gson gson;

    public JSONDataProvider(String filepath) throws FileNotFoundException {
        reader = new FileReader(filepath);
        gson = new Gson();
    }

    public Map<String, String> getAllData(String dataSet) {
        Type type = new TypeToken<HashMap<String, HashMap>>(){}.getType();
        HashMap<String, HashMap> testData = gson.fromJson(reader, type);
        HashMap testDataMap = testData.get("testdata");
        return ((Map)testDataMap.get(dataSet));
    }
}
