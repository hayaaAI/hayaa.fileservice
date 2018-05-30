package hayaa.file.service.controller;

import hayaa.basemodel.model.TransactionResult;
import hayaa.file.service.FileResult;
import hayaa.file.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/file/", method = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(origins = "*", allowCredentials = "true")
public class FileController {
    @Autowired
    private IFileService fileService;

    @RequestMapping(value = "img")
    public TransactionResult<FileResult> uploadImg(@RequestParam("file") MultipartFile file,
                                                   RedirectAttributes redirectAttributes) {
        TransactionResult<FileResult> r = new TransactionResult<FileResult>();
        FileResult fr = new FileResult();
        fr.setDirectoryName("img");
        fr.setFileName(file.getName());
        fileService.upload(fr);
        if (!fr.getAction()) {
            r.setCode(103);
            r.setMessage(fr.getMessage());
        }
        return r;
    }

    @RequestMapping(value = "doc")
    public TransactionResult<FileResult> uploadDoc(@RequestParam("file") MultipartFile file,
                                                   RedirectAttributes redirectAttributes) {
        TransactionResult<FileResult> r = new TransactionResult<FileResult>();
        FileResult fr = new FileResult();
        fr.setDirectoryName("doc");
        fr.setFileName(file.getName());
        fileService.upload(fr);
        if (!fr.getAction()) {
            r.setCode(103);
            r.setMessage(fr.getMessage());
        }
        return r;
    }

}
