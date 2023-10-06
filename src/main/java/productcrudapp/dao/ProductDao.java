package productcrudapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import productcrudapp.model.Product;

@Component
public class ProductDao {
	@Autowired
	private HibernateTemplate hibernatetemplate;

	@Transactional
	public void createProduct(Product product) {
		this.hibernatetemplate.save(product);

	}

	public List<Product> getProducts() {
		List<Product> products = this.hibernatetemplate.loadAll(Product.class);
		return products;
	}

	@Transactional
	public void deleteProduct(int pid) {
		Product p = this.hibernatetemplate.load(Product.class, pid);
		this.hibernatetemplate.delete(p);
	}
	
	public Product getProduct(int pid) {
		return this.hibernatetemplate.get(Product.class, pid);
	}

}
