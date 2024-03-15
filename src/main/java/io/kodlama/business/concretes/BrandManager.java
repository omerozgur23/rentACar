package io.kodlama.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.kodlama.business.abstracts.BrandService;
import io.kodlama.business.requests.CreateBrandRequest;
import io.kodlama.business.requests.UpdateBrandRequest;
import io.kodlama.business.responces.GetAllBrandsResponse;
import io.kodlama.business.responces.GetByIdBrandResponse;
import io.kodlama.business.rules.BrandBusinessRules;
import io.kodlama.core.utilities.mappers.ModelMapperService;
import io.kodlama.dataAccess.abstratcs.BrandRepository;
import io.kodlama.entities.Brand;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;

	@Override
	public List<GetAllBrandsResponse> getAll() {
		List<Brand> brands = brandRepository.findAll();
		// stream foreach döngüsü yapar
		List<GetAllBrandsResponse> brandsResponse = brands.stream().map(brand -> this.modelMapperService.forResponse()
				// stream map'i
				.map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
		// modelMapper map'i
		return brandsResponse;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		this.brandRepository.save(brand);

	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		return response;
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand); // save => id alındığı için update işlemi yapar
	}

	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);
	}

}
