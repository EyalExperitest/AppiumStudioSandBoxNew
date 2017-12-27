package main.java.tools;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/** JDK 7+. */
public final class CopyFilesNew {

    public static void main(String... aArgs) throws IOException {

        String fromPath = "C:\\Temp\\from.txt";
        String toPath = "C:\\Temp\\to.txt";

        copy(fromPath, toPath);
    }

    public static void copy(String fromPath, String toPath) throws IOException {
        Path FROM = Paths.get(fromPath);
        Path TO = Paths.get(toPath);
        //overwrite existing file, if exists
        CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
        };
        Files.copy(FROM, TO, options);
    }
}