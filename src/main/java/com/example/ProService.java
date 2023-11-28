package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProService {
		
	@Autowired
	private ProductRepository prepo;
	
	public List<Product> listAll(){
		return prepo.findAll();
	}
	
	public void save(Product pro) {
		prepo.save(pro);
		
	}
	
	public Product get(Integer id) {
		return prepo.findById(id).get();
		
	}

	public void delete(Integer id) {
		prepo.deleteById(id);
		
	}
	
}
