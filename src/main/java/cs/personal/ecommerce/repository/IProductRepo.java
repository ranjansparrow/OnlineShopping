package cs.personal.ecommerce.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cs.personal.ecommerce.domain.Product;
@Repository
public interface IProductRepo extends CrudRepository<Product, Long> {
	/*@Query("select imageUpload from Product p where p.username = :username")
	public void getImageName(@Param("username") String username);*/
}
