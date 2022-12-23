package Kodlama.io.Devs.languages.webApi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.languages.business.abstracts.FrameworkService;
import Kodlama.io.Devs.languages.business.request.CreateFrameworksRequest;
import Kodlama.io.Devs.languages.business.request.GetFrameworkByIdRequest;
import Kodlama.io.Devs.languages.business.request.UpdateFrameworksRequest;
import Kodlama.io.Devs.languages.business.responses.GetAllFreameworksResponses;

@RestController
@RequestMapping("/api/frameworks")
public class FrameworksController {
	
	private FrameworkService frameworkService;

	public FrameworksController(FrameworkService frameworkService) {
		this.frameworkService = frameworkService;
	}
	
	
	@GetMapping("/getall")
	public List<GetAllFreameworksResponses> getAll(){
		return frameworkService.getAll();
	}
	
	
	@PostMapping("/add")
	public void add(CreateFrameworksRequest createFrameworksRequest) {
		frameworkService.add(createFrameworksRequest);
	}
	
	
	@PostMapping("/delete")
	public void delete(int id) {
		frameworkService.delete(id);
	}
	
	
	@PostMapping("/update")
	public void update(UpdateFrameworksRequest updateFrameworksRequest,int id) {
		frameworkService.update(updateFrameworksRequest, id);
	}
	
	@GetMapping("/getbyid")
	public void getById(GetFrameworkByIdRequest frameworkByIdRequest){
		frameworkService.getById(frameworkByIdRequest);

	}
	
	
	
}
