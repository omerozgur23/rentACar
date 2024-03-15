package io.kodlama.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ch.qos.logback.core.model.Model;
import io.kodlama.business.abstracts.ModelService;
import io.kodlama.business.requests.CreateModelRequest;
import io.kodlama.business.responces.GetAllModelsResponse;
import io.kodlama.core.utilities.mappers.ModelMapperService;
import io.kodlama.dataAccess.abstratcs.ModelRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = modelRepository.findAll();

		List<GetAllModelsResponse> modelsResponse = models.stream()
				.map(model -> this.modelMapperService.forResponse()
				//stream map'i
						.map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
						//modelMapper map'i
		return modelsResponse;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model= this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		this.modelRepository.save(model);
		
	}

}
