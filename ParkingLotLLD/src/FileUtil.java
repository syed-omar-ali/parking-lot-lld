import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static List<String> readFile(String filePath){
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            fr.close();
            return lines;
        }catch (IOException ioException){
            System.out.println("Exception while reading the file! Exp: "+ioException);
            return null;
        }
    }
}
