package cs.personal.ecommerce.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cs.personal.ecommerce.domain.Member;
@Repository
public interface IMemberRepo extends CrudRepository<Member, Long> {
	
	@Query("select password from Member m where m.username = :username")
	public String checkPassword(@Param("username") String username);
	
	@Query("select username from Member m where m.username = :username")
	public String checkusername(@Param("username") String username);

}
