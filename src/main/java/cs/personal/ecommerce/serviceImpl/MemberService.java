package cs.personal.ecommerce.serviceImpl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import cs.personal.ecommerce.domain.Member;
import cs.personal.ecommerce.repository.IMemberRepo;
import cs.personal.ecommerce.service.IMemberService;
@Service
@Transactional
public class MemberService implements IMemberService {
	@Autowired
	IMemberRepo memberrepo;
	String time = String.valueOf(System.currentTimeMillis());
	
	@Override
	public void save(Member member) {
		member.setImageUpload(time+".jpg");
		memberrepo.save(member);
		
	}
	 Logger log = LoggerFactory.getLogger(this.getClass().getName());
	    private final Path rootLocation = Paths.get("images");
	 @Override
	    public void store(MultipartFile file){
	        try {
	        	System.out.println("while saving image" + time);
	            Files.copy(file.getInputStream(), this.rootLocation.resolve(time+".jpg"));
	        } catch (Exception e) {
	            throw new RuntimeException("FAIL!");
	        }
	    }
	 @Override
	    public Resource loadFile(String filename) {
	        try {
	            Path file = rootLocation.resolve(filename);
	            Resource resource = new UrlResource(file.toUri());
	            if(resource.exists() || resource.isReadable()) {
	                return resource;
	            }else{
	                throw new RuntimeException("FAIL!");
	            }
	        } catch (MalformedURLException e) {
	            throw new RuntimeException("FAIL!");
	        }
	    }
	    @Override
	    public void deleteAll() {
	        FileSystemUtils.deleteRecursively(rootLocation.toFile());
	    }
	    @Override
	    public void init() {
	        try {
	            Files.createDirectory(rootLocation);
	        } catch (IOException e) {
	            throw new RuntimeException("Could not initialize storage!");
	        }
	    }

	

}
