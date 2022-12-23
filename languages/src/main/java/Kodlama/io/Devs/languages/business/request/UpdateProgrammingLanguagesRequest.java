package Kodlama.io.Devs.languages.business.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateProgrammingLanguagesRequest {
	private int id;
	private String name;

}
