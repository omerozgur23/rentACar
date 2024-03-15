package io.kodlama.business.abstracts;

import java.util.List;

import io.kodlama.business.requests.CreateBrandRequest;
import io.kodlama.business.requests.UpdateBrandRequest;
import io.kodlama.business.responces.GetAllBrandsResponse;
import io.kodlama.business.responces.GetByIdBrandResponse;

public interface BrandService {
	List<GetAllBrandsResponse> getAll();
	GetByIdBrandResponse getById(int id);
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(int id);
}
