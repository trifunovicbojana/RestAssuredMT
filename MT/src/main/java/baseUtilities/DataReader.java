package baseUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataReader {

        String dataPropertyFilePath = "src/test/resources/Data/Configuration.properties";
        Properties obj = new Properties();
        FileInputStream objfile;


        public String getPropertyValue(String string){
            try {
                objfile = new FileInputStream(dataPropertyFilePath);
                obj.load(objfile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return obj.getProperty(string);
        }

    }

