package Kodlama.io.Devs.languages.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.languages.business.request.CreateProgrammingLanguagesRequest;
import Kodlama.io.Devs.languages.business.request.GetProgrammingLanguageByIdRequest;
import Kodlama.io.Devs.languages.business.request.UpdateProgrammingLanguagesRequest;
import Kodlama.io.Devs.languages.business.responses.GetAllProgrammingLanguagesResponse;
import Kodlama.io.Devs.languages.business.responses.GetProgrammingLanguagesByIdResponse;

public interface ProgrammingLanguageService {
	List<GetAllProgrammingLanguagesResponse> getAll();
	void add(CreateProgrammingLanguagesRequest createProgrammingLanguagesRequest) throws Exception  ;
	void delete(int id);
	GetProgrammingLanguagesByIdResponse getById(GetProgrammingLanguageByIdRequest getProgrammingLanguageByIdRequest);
	void update(UpdateProgrammingLanguagesRequest updateProgrammingLanguagesRequest, int id);	

	
}
