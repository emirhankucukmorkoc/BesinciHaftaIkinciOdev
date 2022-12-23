package Kodlama.io.Devs.languages.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import Kodlama.io.Devs.languages.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageDao extends JpaRepository<ProgrammingLanguage, Integer> {


	
}
