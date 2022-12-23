package Kodlama.io.Devs.languages.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.languages.business.request.CreateFrameworksRequest;
import Kodlama.io.Devs.languages.business.request.GetFrameworkByIdRequest;
import Kodlama.io.Devs.languages.business.request.UpdateFrameworksRequest;
import Kodlama.io.Devs.languages.business.responses.GetAllFreameworksResponses;
import Kodlama.io.Devs.languages.business.responses.GetFrameworkByIdResponse;


public interface FrameworkService {
	List<GetAllFreameworksResponses> getAll();
	void add(CreateFrameworksRequest createFrameworksRequest);
	void delete(int id);
	void update(UpdateFrameworksRequest updateFrameworksRequest,int id);
	GetFrameworkByIdResponse getById(GetFrameworkByIdRequest getFrameworkByIdRequest);	


}
