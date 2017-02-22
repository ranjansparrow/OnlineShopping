package cs.personal.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import cs.personal.ecommerce.service.StorageService;
 

 
@Controller
public class FileUploadController {
 
    @Autowired
    StorageService storageService;
 
    List<String> files = new ArrayList<String>();
 
    @RequestMapping(value = "/upload" , method = RequestMethod.GET)
    public String listUploadedFiles(Model model) {
        return "uploadForm";
    }
 
    @RequestMapping(value = "/upload" , method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) {
        try {
            storageService.store(file);
            model.addAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
            files.add(file.getOriginalFilename());
        } catch (Exception e) {
            model.addAttribute("message", "FAIL to upload " + file.getOriginalFilename() + "!");
        }
        return "uploadForm";
    }
    
    @RequestMapping(value = "/getallfiles" , method = RequestMethod.GET)
    public String getListFiles(Model model) {
        model.addAttribute("files",
                files.stream()
                        .map(fileName -> MvcUriComponentsBuilder
                                .fromMethodName(FileUploadController.class, "getFile", fileName).build().toString())
                        .collect(Collectors.toList()));
        model.addAttribute("totalFiles", "TotalFiles: " + files.size());
        return "listFiles";
    }
    
    @RequestMapping(value = "/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}