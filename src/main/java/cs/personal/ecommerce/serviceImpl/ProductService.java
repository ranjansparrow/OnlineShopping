package cs.personal.ecommerce.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs.personal.ecommerce.domain.Product;
import cs.personal.ecommerce.service.IProductService;
@Service
@Transactional
public class ProductService implements IProductService {

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		
	}

}
