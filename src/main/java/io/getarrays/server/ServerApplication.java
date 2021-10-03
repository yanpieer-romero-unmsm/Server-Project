package io.getarrays.server;

import io.getarrays.server.model.Server;
import io.getarrays.server.repository.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static io.getarrays.server.enumeration.Status.SERVER_DOWN;
import static io.getarrays.server.enumeration.Status.SERVER_UP;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ServerRepo serverRepo) {
		return args -> {
			serverRepo.save(new Server(null, "192.168.1.17", "Ubuntu Linux", "16 GB", "Personal PC", "http://localhost/server/image/server1.png", SERVER_UP));
			serverRepo.save(new Server(null, "192.168.1.58", "Fedora Linux", "16 GB", "Dell Tower", "http://localhost/server/image/server2.png", SERVER_DOWN));
			serverRepo.save(new Server(null, "192.168.1.21", "MS 2008", "32 GB", "Web Server", "http://localhost/server/image/server3.png", SERVER_UP));
			serverRepo.save(new Server(null, "192.168.1.14", "Red Hat Enterprise Linux", "64 GB", "Mail Server", "http://localhost/server/image/server4.png", SERVER_DOWN));
		};
	}
}
