package Kodlama.io.Devs.languages.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProgrammingLanguagesByIdResponse {
	private int id;
	private String name;

}
