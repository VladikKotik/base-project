package base.project.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TxtReaderService {

    public List<String> getAllLinesFromTxtFile(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }
}
