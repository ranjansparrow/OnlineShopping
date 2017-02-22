package cs.personal.ecommerce.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs.personal.ecommerce.domain.Member;
import cs.personal.ecommerce.repository.IMemberRepo;
import cs.personal.ecommerce.service.IMemberService;
@Service
@Transactional
public class MemberService implements IMemberService {
	@Autowired
	IMemberRepo memberrepo;

	@Override
	public void save(Member member) {
		memberrepo.save(member);
		
	}

	

}
