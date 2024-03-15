package io.kodlama.business.abstracts;

import java.util.List;

import io.kodlama.business.requests.CreateModelRequest;
import io.kodlama.business.responces.GetAllModelsResponse;

public interface ModelService {
	List<GetAllModelsResponse> getAll();
	
	void add(CreateModelRequest createModelRequest);
}
