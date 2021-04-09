import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

// this class is all about reading a file
public class ReadFile {
        private String filepath;
        private Map<String, String> fileDataBase = new HashMap<String, String>();
// this constructor initializes the field of class, ReadFile
        public ReadFile(String name) {
            this.filepath = Paths.get("").toAbsolutePath() + "/src/main/resources/" + name;
        }
// this constructor takes care of the no-argument condition
    public ReadFile() {
        this.filepath = Paths.get("").toAbsolutePath() + "/src/main/resources/" + "config.txt";
    }

    // this method stores a file in the hashmap and reads from it
        private Map<String, String> readTextFile() {

            try(BufferedReader firstFile = new BufferedReader(new FileReader(filepath))) {
                int counter = 0;
                String newLine = "";
                while ((newLine = firstFile.readLine()) != null) {
                    if(newLine.indexOf("=") != -1) {
                        String key = newLine.substring(0, newLine.indexOf("="));
                        String value = newLine.substring(newLine.indexOf("=") + 1);
                        for(Map.Entry<String, String> element: fileDataBase.entrySet()){
                            if(element.getKey().equals(key)){
                                counter++;
                            }
                        }
                        if (counter == 0){
                            fileDataBase.put(key, value);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("File not found");
            }
            return fileDataBase;
        }

        // this getter returns the value of a specified key
        public String get(String key){
            this.readTextFile();
            String fileValue = " ";
            if(key.equals("application.name")){
                return fileDataBase.get("name");
            }
            if(key.equals("application.port")){
                return fileDataBase.get("port");
            }
            if(key.equals("application.context-url")){
                return fileDataBase.get("context-url");
            }
            for(Map.Entry<String, String> element: fileDataBase.entrySet()){
                if(element.getKey().equals(key)){
                    fileValue = element.getValue();
                }
            }
            return fileValue;
        }

    }
