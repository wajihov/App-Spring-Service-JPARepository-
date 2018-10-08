package org.sid;

/*import java.text.DateFormat;
import java.text.SimpleDateFormat;*/

import org.sid.dao.ContactRepository;
import org.sid.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringClientApplication implements CommandLineRunner {

	@Autowired
	private ContactRepository contactRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringClientApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		/*DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		contactRepository
				.save(new Client("wajih", "BOUFAIED", df.parse("10/01/1983"), "wajihov@hotmail.fr", 97472581L));
		contactRepository.save(new Client("sami", "Khalfa", df.parse("15/05/1986"), "samloussa@hotmail.fr", 23472581L));
		contactRepository.save(new Client("helmi", "Bani", df.parse("12/09/1990"), "halamizou@hotmail.fr", 99552266L));
		contactRepository
				.save(new Client("khaled", "masrour", df.parse("19/06/1991"), "kalouda@hotmail.fr", 22336644L));
		contactRepository.save(new Client("samir", "miloud", df.parse("18/02/1989"), "samiros@hotmail.fr", 552315963L));*/
		contactRepository.findAll().forEach(c -> System.out.println(c.getNom()));

		Client client = contactRepository.findOne(18L);
		System.out.println(" id : " + client.getId() + " / " + client.getNom() + " / " + client.getPrenom() + " / ");
	}
}