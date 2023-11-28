package com.example;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProController {

	@Autowired
	private ProService service;
	
	@GetMapping("/products")
	public List<Product> list(){
		return service.listAll();
	}
	
//	@GetMapping("/products/{id}")
//	public Product get(@PathVariable Integer id) {
//		return service.get(id);
//	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> get(@PathVariable Integer id) {
		try {
			Product prod = service.get(id);
			return new ResponseEntity<Product>(prod,HttpStatus.OK);
					
		} catch (NoSuchElementException e) {
		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	
	}
	@PostMapping("/products")
	public void add(@RequestBody Product product) {
		service.save(product);
		
		}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<?> update(@RequestBody Product pro,@PathVariable Integer id) {
		try {

			Product existPro = service.get(id);
			service.save(pro);
			
			return new ResponseEntity<>(HttpStatus.OK);
	
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	
		}		
	}
		
	
	
	@DeleteMapping("products/{id}")
	public void delete(@PathVariable Integer id) {
		
		service.delete(id);
	
	}
}

