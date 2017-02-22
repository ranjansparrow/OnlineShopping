package cs.personal.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cs.personal.ecommerce.domain.Member;
@Repository
public interface IMemberRepo extends CrudRepository<Member, Long> {

}
