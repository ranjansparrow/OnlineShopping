package cs.personal.ecommerce.service;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import cs.personal.ecommerce.domain.Member;

@Service
@Transactional
public interface IMemberService {
	public void save(Member member);
	public List<Member> getAllMembers();
	public String findPassword(String username);
	public String findUsername(String username);

}
