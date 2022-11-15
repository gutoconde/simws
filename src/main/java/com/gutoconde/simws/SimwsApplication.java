package com.gutoconde.simws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.gutoconde.simws.api.controller.AppInfoController;
import com.gutoconde.simws.api.controller.CargoController;
import com.gutoconde.simws.api.controller.GabineteController;

@SpringBootApplication
@EnableScheduling
@Import({AppInfoController.class, CargoController.class, GabineteController.class})
public class SimwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimwsApplication.class, args);
	}

}
