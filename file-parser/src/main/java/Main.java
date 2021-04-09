
import java.io.IOException;

// This class being my main, is where all the instances are created
public class Main {


    // this method is the entry point for my code
    public static void main(String[] args) throws IOException{

        if(args.length > 0) {
             if (args[0].equals("production")) {
            ReadFile firstFile = new ReadFile("config.txt");
            printValues(firstFile);
            
            } else if (args[0].equals("development")) {
            ReadFile firstFile = new ReadFile("config.txt.dev");
            printValues(firstFile);
            } else if (args[0].equals("staging")) {
            ReadFile firstFile = new ReadFile("config.txt.staging");
            printValues(firstFile);
            }
        } else{
            ReadFile firstFile = new ReadFile();
            printValues(firstFile);
        }

    }

    // this main method performs the major functions required of the class instances
    public static void printValues(ReadFile fileReader){
        System.out.println(fileReader.get("dbname"));
        System.out.println(fileReader.get("host"));
        System.out.println(fileReader.get("application.name"));
        System.out.println(fileReader.get("application.port"));
        System.out.println(fileReader.get("application.context-url"));
        System.out.println(fileReader.get("mode"));
        System.out.println(fileReader.get("theme"));
        System.out.println(fileReader.get("pipeline"));

    }

}


