package cs.personal.ecommerce.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs.personal.ecommerce.domain.Product;
import cs.personal.ecommerce.repository.IProductRepo;
import cs.personal.ecommerce.service.IProductService;
@Service
@Transactional
public class ProductService implements IProductService {

	@Autowired
	IProductRepo productrepo;
	@Override
	public void save(Product product,String time) {
		product.setImageUpload(time+".jpg");
		productrepo.save(product);
		
	}
	@Override
	public List<Product> findAllProduct() {
		
		return (List<Product>) productrepo.findAll();
	}

}
