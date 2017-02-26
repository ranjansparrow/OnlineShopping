package cs.personal.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs.personal.ecommerce.domain.Product;

@Service
@Transactional
public interface IProductService {
	public void save(Product product,String time);
	public List<Product> findAllProduct();
	public Product findOneProduct(long id);


}
