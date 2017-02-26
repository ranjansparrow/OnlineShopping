package cs.personal.ecommerce.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs.personal.ecommerce.domain.Member;
import cs.personal.ecommerce.domain.OrderLine;
import cs.personal.ecommerce.domain.Product;
import cs.personal.ecommerce.repository.IOrderLineRepo;
import cs.personal.ecommerce.service.IOrderLineService;
@Service
@Transactional
public class OrderLineService implements IOrderLineService {

	@Autowired
	IOrderLineRepo orderLinerepo;
	@Override
	public void save(OrderLine orderLine, List<Product> listOfProducts, Member member) {
		orderLine.setProducts(listOfProducts);
		orderLine.setMember(member);
		orderLinerepo.save(orderLine);
		
		
	}

}
