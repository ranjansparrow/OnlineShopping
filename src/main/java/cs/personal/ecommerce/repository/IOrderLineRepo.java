package cs.personal.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cs.personal.ecommerce.domain.OrderLine;

@Repository
public interface IOrderLineRepo extends CrudRepository<OrderLine, Long> {

}
