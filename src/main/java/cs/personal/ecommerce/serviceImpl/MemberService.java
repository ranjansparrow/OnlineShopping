package cs.personal.ecommerce.serviceImpl;


import java.util.List;

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

	@Override
	public List<Member> getAllMembers() {
		return (List<Member>) memberrepo.findAll();
	}

	@Override
	public String findPassword(String username) {

		return memberrepo.checkPassword(username);
	}

	@Override
	public String findUsername(String username) {

		return memberrepo.checkusername(username);
	}

	@Override
	public long getIdByUsername(String username) {
		return memberrepo.findIdByUsername(username);
	}

	@Override
	public Member findOneMember(long id) {
		return memberrepo.findOne(id);
	}

}
