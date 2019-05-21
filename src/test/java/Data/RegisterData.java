package Data;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RegisterData {

@DataProvider(name = "modifiedRegisterDataP")
    public static Iterator<Object[]> modifiedRegisterDataP() {
        List<Object[]> data = new ArrayList<>();
        Path path = Paths.get("testdata", "data.csv");
        try {
            List<String> strings = Files.readAllLines(path);
            for(String str:strings) {
                String[] csvData = str.split(",");
                data.add(csvData);
            }

        } catch (IOException ex) {

        }
        return data.iterator();
    }

}
