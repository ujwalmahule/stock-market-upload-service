package com.ujwal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@EnableDiscoveryClient
@RestController
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class UploadServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadServiceApplication.class, args);
	}

	@PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) {

        //storageService.store(file);
		System.out.println(file.getSize());
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "{'fileName':'" + file.getName() + "'}";
    }
}
