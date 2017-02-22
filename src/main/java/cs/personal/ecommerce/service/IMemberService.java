package cs.personal.ecommerce.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs.personal.ecommerce.domain.Member;

@Service
@Transactional
public interface IMemberService {
	public void save(Member member);

}
