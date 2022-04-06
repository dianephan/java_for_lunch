package com.example.lunchorders;
import com.github.alexdlaird.ngrok.NgrokClient;
import com.github.alexdlaird.ngrok.protocol.CreateTunnel;
import com.github.alexdlaird.ngrok.protocol.Tunnel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LunchOrdersApplication {
	public static void main(String[] args) {
		SpringApplication.run(LunchOrdersApplication.class, args);
		final NgrokClient ngrokClient = new NgrokClient.Builder().build();
		final CreateTunnel createTunnel = new CreateTunnel.Builder()
				.build();
		final Tunnel tunnel = ngrokClient.connect(createTunnel);
	}
}
