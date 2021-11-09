package com.devsuperior.myfirstproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.myfirstproject.entities.Category;
import com.devsuperior.myfirstproject.repositories.CategoryRepository;

@RestController // Define que essa classe vai ser um recurso rest
@RequestMapping(value = "/categories") // defifine o caminho pelo qual esse recurso será acessado
public class CategoryResource {
	
	@Autowired // Essa annotation faz a mágica de linkar o repository ao resource (Para funcionar tem de ter o @component lá no repository indicando que ele é instanciável.
	private CategoryRepository categoryRepository;  //É necessário tornar o Resource dependente do repository porque é de lá que ela vao puxar as informações.

	@GetMapping
	public ResponseEntity<List<Category>> findAll() { //Esta é a assinatura do método para retornar todas as categorias
		List<Category> list = categoryRepository.findAll(); // Tá puxando o método lá do repository.
				
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category cat = categoryRepository.findById(id); // tudo agora passa a ser chamdo do repository e isso torma a acquisição da informação dâmica (sem hardcode).
		return ResponseEntity.ok().body(cat);
	}
}

