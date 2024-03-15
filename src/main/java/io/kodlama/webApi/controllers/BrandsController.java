package io.kodlama.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.business.abstracts.BrandService;
import io.kodlama.business.requests.CreateBrandRequest;
import io.kodlama.business.requests.UpdateBrandRequest;
import io.kodlama.business.responces.GetAllBrandsResponse;
import io.kodlama.business.responces.GetByIdBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
	private BrandService brandService;

	@GetMapping
	public List<GetAllBrandsResponse> getAll() {
		return brandService.getAll();
	}

	@GetMapping("/{id}")
	public GetByIdBrandResponse getById(@PathVariable int id) {
		return brandService.getById(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}

	@PutMapping
	public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
		this.brandService.update(updateBrandRequest);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.brandService.delete(id);
	}
}
