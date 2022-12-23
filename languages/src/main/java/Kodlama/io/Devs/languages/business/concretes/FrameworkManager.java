package Kodlama.io.Devs.languages.business.concretes;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs.languages.business.abstracts.FrameworkService;
import Kodlama.io.Devs.languages.business.request.CreateFrameworksRequest;
import Kodlama.io.Devs.languages.business.request.GetFrameworkByIdRequest;
import Kodlama.io.Devs.languages.business.request.UpdateFrameworksRequest;
import Kodlama.io.Devs.languages.business.responses.GetAllFreameworksResponses;
import Kodlama.io.Devs.languages.business.responses.GetFrameworkByIdResponse;
import Kodlama.io.Devs.languages.dataAccess.abstracts.FrameworkDao;
import Kodlama.io.Devs.languages.entities.concretes.Framework;

@Service
public class FrameworkManager implements FrameworkService {

	private FrameworkDao frameworkDao;
	List<Framework> frameworks;

	public FrameworkManager(FrameworkDao frameworkDao) {
		this.frameworkDao = frameworkDao;
	}

	@Override
	public List<GetAllFreameworksResponses> getAll() {

		List<Framework> frameworks = frameworkDao.findAll();
		List<GetAllFreameworksResponses> getAllFreameworksResponses = new ArrayList<GetAllFreameworksResponses>();

		for (Framework framework : frameworks) {
			GetAllFreameworksResponses getAllFreameworksResponse = new GetAllFreameworksResponses();
			getAllFreameworksResponse.setId(framework.getId());
			getAllFreameworksResponse.setName(framework.getName());
			getAllFreameworksResponses.add(getAllFreameworksResponse);

		}
		return getAllFreameworksResponses;

	}

	@Override
	public void add(CreateFrameworksRequest createFrameworksRequest) {
		Framework framework = new Framework();
		framework.setName(createFrameworksRequest.getName());
		frameworkDao.save(framework);
	}

	@Override
	public void delete(int id) {

		frameworkDao.deleteById(id);
	}

	@Override
	public void update(UpdateFrameworksRequest updateFrameworksRequest, int id) {
		Framework framework = this.frameworkDao.findById(updateFrameworksRequest.getId()).get();
		framework.setName(updateFrameworksRequest.getName());
		this.frameworkDao.save(framework);
		
	}

	@Override
	public GetFrameworkByIdResponse getById(GetFrameworkByIdRequest getProgrammingLanguageByIdRequest) {
		
		List<Framework> frameworks = frameworkDao.findAll();
			GetFrameworkByIdResponse byIdResponse = new GetFrameworkByIdResponse();
			List<GetFrameworkByIdResponse> byIdResponses = new ArrayList<GetFrameworkByIdResponse>();
			
			for (Framework framework : frameworks) {
				if (framework.getId() == getProgrammingLanguageByIdRequest.getId()) {
					byIdResponse.setName(framework.getName());
					byIdResponses.add(byIdResponse);
					
				}
				
			}
			return byIdResponse;
		}
			
		
	

}


