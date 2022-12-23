package Kodlama.io.Devs.languages.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.languages.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.languages.business.request.CreateProgrammingLanguagesRequest;
import Kodlama.io.Devs.languages.business.request.GetProgrammingLanguageByIdRequest;
import Kodlama.io.Devs.languages.business.request.UpdateProgrammingLanguagesRequest;
import Kodlama.io.Devs.languages.business.responses.GetAllProgrammingLanguagesResponse;
import Kodlama.io.Devs.languages.business.responses.GetProgrammingLanguagesByIdResponse;
import Kodlama.io.Devs.languages.dataAccess.abstracts.ProgrammingLanguageDao;
import Kodlama.io.Devs.languages.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageDao programmingLanguageDao;
	List<ProgrammingLanguage> programmingLanguages;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageDao programmingLanguageDao) {
		this.programmingLanguageDao = programmingLanguageDao;
	}

	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {
			List<ProgrammingLanguage> languages = programmingLanguageDao.findAll();
			List<GetAllProgrammingLanguagesResponse> getAllProgrammingLanguagesResponses = new ArrayList<GetAllProgrammingLanguagesResponse>();
	        
			for (ProgrammingLanguage language : languages) {
				GetAllProgrammingLanguagesResponse getAllProgrammingLanguagesResponse = new GetAllProgrammingLanguagesResponse();
				getAllProgrammingLanguagesResponse.setId(language.getId());
				getAllProgrammingLanguagesResponse.setName(language.getName());
				
			}

		return getAllProgrammingLanguagesResponses;
		
		}
	

	@Override
	public void add(CreateProgrammingLanguagesRequest createProgrammingLanguagesRequest) throws Exception {
		 if (createProgrammingLanguagesRequest.getName().isEmpty()) {
				throw new Exception("Program Dili Girilmek Zorundadır.");
			}

			for (GetAllProgrammingLanguagesResponse getAllProgrammingLanguagesResponse : getAll()) {
				if (getAllProgrammingLanguagesResponse.getName() == getAllProgrammingLanguagesResponse.getName()) {
					throw new Exception("Programlama dili aynı  geçilemez...");
				}
			}
			ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
			programmingLanguage.setName(createProgrammingLanguagesRequest.getName());
			programmingLanguageDao.save(programmingLanguage);

	
	}

	@Override
	public void delete(int id) {
		programmingLanguageDao.deleteById(id);
	}


	@Override
	public GetProgrammingLanguagesByIdResponse getById(GetProgrammingLanguageByIdRequest getProgrammingLanguageByIdRequest) {	
		List<ProgrammingLanguage> languages = programmingLanguageDao.findAll();
		GetProgrammingLanguagesByIdResponse byIdResponse = new GetProgrammingLanguagesByIdResponse();
		List<GetProgrammingLanguagesByIdResponse> byIdResponses = new ArrayList<GetProgrammingLanguagesByIdResponse>();
		
		for (ProgrammingLanguage programmingLanguage : languages) {
			if (programmingLanguage.getId() == getProgrammingLanguageByIdRequest.getId()) {
				byIdResponse.setName(programmingLanguage.getName());
				byIdResponses.add(byIdResponse);
				
			}
			
		}
		return byIdResponse;
	}

	@Override
	public void update(UpdateProgrammingLanguagesRequest updateProgrammingLanguagesRequest, int id) {
		ProgrammingLanguage programmingLanguage = programmingLanguageDao.findById(updateProgrammingLanguagesRequest.getId()).get();
		programmingLanguage.setName(updateProgrammingLanguagesRequest.getName());
		this.programmingLanguageDao.save(programmingLanguage);
	}


}
