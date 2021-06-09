package springboot.poc.uploadfile.resource;

import springboot.poc.uploadfile.storage.FileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileResource {

    @Autowired
    private FileSystem fileSystem;

    @PostMapping
    public void upload(@RequestParam MultipartFile file) {
        fileSystem.save(file);
    }
}
