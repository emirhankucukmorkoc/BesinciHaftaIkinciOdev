package Kodlama.io.Devs.languages.webApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.languages.business.concretes.ProgrammingLanguageManager;
import Kodlama.io.Devs.languages.business.request.CreateProgrammingLanguagesRequest;
import Kodlama.io.Devs.languages.business.request.GetProgrammingLanguageByIdRequest;
import Kodlama.io.Devs.languages.business.request.UpdateProgrammingLanguagesRequest;
import Kodlama.io.Devs.languages.business.responses.GetAllProgrammingLanguagesResponse;
import Kodlama.io.Devs.languages.business.responses.GetProgrammingLanguagesByIdResponse;

@RequestMapping("*api/languages")
@RestController
public class ProgrammingLanguagesController {
	
	private ProgrammingLanguageManager languageManager;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageManager languageManager) {
		this.languageManager = languageManager;
	}
	
	
	
	@GetMapping("/getall")
	public List<GetAllProgrammingLanguagesResponse> getAll(){
		return languageManager.getAll();
	}


	@GetMapping("/getbyid")
	public GetProgrammingLanguagesByIdResponse getById(GetProgrammingLanguageByIdRequest getProgrammingLanguageByIdRequest) {
		return this.languageManager.getById(getProgrammingLanguageByIdRequest);
		
	}
	@PostMapping("/add")
	public void add(CreateProgrammingLanguagesRequest programmingLanguagesRequest) throws Exception   {
		this.languageManager.add(programmingLanguagesRequest);
	}
	
	
	
	@PostMapping("/delete")
	public void delete(int id) {
		this.languageManager.delete(id);
	}
	
	@PostMapping("/update")
	public void update( UpdateProgrammingLanguagesRequest updateProgrammingLanguagesRequest,int id) {
		this.languageManager.update(updateProgrammingLanguagesRequest, id);
	}
	
	
	
	

}
