import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class Utils {

    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        //TODO реализовать метод копирования папки sourceDirectory в destinationDirectory
        Path sourse = Paths.get(sourceDirectory);
        Path destination = Paths.get(destinationDirectory);
        if (!Files.exists(sourse)) throw new IllegalArgumentException();
        try {
            if (!Files.exists(destination)) Files.createDirectory(destination);
            MyFileVisitor myFileVisitor = new MyFileVisitor();
            Files.walkFileTree(sourse, myFileVisitor);
            for (Path path : myFileVisitor.getPaths()) {
                Path test = new File(destinationDirectory + File.separator + path).toPath();
                Files.copy(path, new File(destination + File.separator + path.getFileName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
        }
    }

    public static long calculateFolderSize(String path) {
        File f = new File(path);
        if (!f.exists()) throw new IllegalArgumentException();
        long size = 0;
        for (var file : f.listFiles()) {
            size += file.length();
        }
        return size;
    }
}

class MyFileVisitor extends SimpleFileVisitor<Path> {
    private ArrayList<Path> paths = new ArrayList<>();

    public ArrayList<Path> getPaths() {
        return paths;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        paths.add(file);
        return FileVisitResult.CONTINUE;
    }
}