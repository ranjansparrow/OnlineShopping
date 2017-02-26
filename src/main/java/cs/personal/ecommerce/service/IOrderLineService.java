package cs.personal.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cs.personal.ecommerce.domain.OrderLine;
import cs.personal.ecommerce.domain.Product;
@Service
public interface IOrderLineService {
	public void save(OrderLine orderLine, List<Product> listOfProducts);
}
