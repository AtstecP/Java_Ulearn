
import java.io.File;


public class FileUtils {

    public static long calculateFolderSize(String path){
        File f = new File(path);
        if(!f.exists()) throw new IllegalArgumentException();
        long size = 0;
        for(var file:f.listFiles()){
            size += file.length();
        }
        return size;
    }
}