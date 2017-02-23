package cs.personal.ecommerce.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import cs.personal.ecommerce.domain.Member;

@Service
@Transactional
public interface IMemberService {
	public void save(Member member);
	
	public void store(MultipartFile file);
	
	public Resource loadFile(String fileName);
	public void deleteAll();
	public void init();

}
