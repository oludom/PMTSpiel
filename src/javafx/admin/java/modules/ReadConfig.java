package javafx.admin.java.modules;

import java.util.Map;

public class ReadConfig {

    private String URL;

    public ReadConfig(){}

    public ReadConfig(String URL) {
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Map<String, String> readConfigFile(){
        if (URL != null){
            
        }
        return null;
    }
}
