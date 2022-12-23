package Kodlama.io.Devs.languages.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.languages.entities.concretes.Framework;

 @Repository
public interface FrameworkDao  extends JpaRepository<Framework, Integer> {

}
