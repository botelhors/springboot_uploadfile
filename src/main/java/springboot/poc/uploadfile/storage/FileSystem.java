package springboot.poc.uploadfile.storage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileSystem {

    @Value("${path.destination}")
    private String pathDestination;

    public void save(MultipartFile file) {
        Path destinationDirectory = Paths.get(pathDestination);
        Path fileDirectory = destinationDirectory.resolve(file.getOriginalFilename());

        try {
            Files.createDirectories(fileDirectory);
            file.transferTo(fileDirectory.toFile());
        } catch (IOException e) {
            throw new RuntimeException("Unable to transfer file");
        }
    }
}
