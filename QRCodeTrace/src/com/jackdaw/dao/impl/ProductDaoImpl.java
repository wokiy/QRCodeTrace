package com.jackdaw.dao.impl;

import java.util.List;

import org.hibernate.Session;
import com.jackdaw.dao.ProductDao;
import com.jackdaw.entity.Product;

/**
 * 产品表数据访问对象
 * @author E-Kunt
 *
 */
public class ProductDaoImpl extends DaoSupportImpl implements ProductDao {

	@Override
	public Product loadById(String id) throws RuntimeException {
		Product product = (Product) this.getCurrentSession().load(Product.class, id);
		return product;
	}

	@Override
	public Product getById(String id) throws RuntimeException {
		Product product = (Product) this.getCurrentSession().get(Product.class, id);
		return product;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getByName(String name) throws RuntimeException {
		String hql = "from Product p where p.name like :name";
		List<Product> products = this.getCurrentSession().createQuery(hql).setParameter("name", "%" + name + "%")
				.list();
		return products;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAll() throws RuntimeException {
		String hql = "from Product";
		List<Product> products = this.getCurrentSession().createQuery(hql).list();
		return products;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> findAllPic() throws RuntimeException {
		String hql = "select p.pic from Product p";
		List<String> pics = this.getCurrentSession().createQuery(hql).list();
		return pics;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findLimit(int begin, int end) throws RuntimeException {
		Session session = this.getCurrentSession();
		session.clear();
		String hql = "from Product";
		List<Product> products = session.createQuery(hql).setFirstResult(begin).setMaxResults(end)
				.list();
		return products;
	}

	@Override
	public void add(Product product) throws RuntimeException {
		this.getCurrentSession().save(product);
	}

	@Override
	public void update(Product product) throws RuntimeException {
		this.getCurrentSession().update(product);

	}

	@Override
	public void updateBase(Product product) throws RuntimeException {
		String hql = "update Product p set p.name = ?, p.pic = ? where p.id = ?";
		this.getCurrentSession().createQuery(hql)
		.setParameter(0, product.getName())
		.setParameter(1, product.getPic())
		.setParameter(2, product.getId())
		.executeUpdate();
	}
	
	@Override
	public void delete(Product product) throws RuntimeException {
		this.getCurrentSession().delete(product);
	}

	@Override
	public void deleteAll() throws RuntimeException {
		Session session = this.getCurrentSession();
		String hql = "delete Product";
		session.createQuery(hql).executeUpdate();
	}

	@Override
	public long count() throws RuntimeException {
		String hql = "select count(p) from Product p";
		long count = (long) this.getCurrentSession().createQuery(hql).uniqueResult();
		return count;
	}

}
