
package configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

     private Logger logger = LogManager.getLogger(PropertiesLoader.class);
    public Properties getPropertiesFromFile(String propertiesFileName) {
        InputStream inputStream = null;
        Properties properties = new Properties();
        try {
            logger.info("Próba załadowania ustawień z pliku: " + propertiesFileName);
            inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);

            if (inputStream != null) {
                properties.load(inputStream);
                logger.info("Załadowanie ustawień z pliku:" + propertiesFileName + " zakończyło się sukcesem");
            } else {
                throw new FileNotFoundException("Plik ustawień " + propertiesFileName + " nie istnieje");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Nie można załadować ustawień");
        } finally {
            closeResource(inputStream);
        } return properties;
    }
    private void closeResource(InputStream inputStream) {
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
