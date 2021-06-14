package prueba.core.banking.kubo.financiero;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	public static final String TITLE = "API Reference";
	public static final String DESCRIPTION = "";
	public static final String VERSION = "API INIT";
	public static final String LICENSE = "Copyright © 2020";
	public static final Contact CONTACT = new Contact();
	public static final String LICENSE_REF_URL = "https://api.reference.com";
	public static final String TERMS_OF_SERVICE_URL = "https://api.reference.com/privacy.php";

	@Bean
	public OpenAPI customOpenAPI(@Value("${application-description}") String appDesciption,
			@Value("${application-version}") String appVersion) {
		CONTACT.setEmail("contacto@api.reference.com.mx");
		CONTACT.setName("API Reference");
		CONTACT.setUrl("https://api.reference.com");

		return new OpenAPI().info(new Info().title(TITLE).version(appVersion).description(appDesciption)
				.termsOfService(TERMS_OF_SERVICE_URL).contact(CONTACT)
				.license(new License().name(LICENSE).url(LICENSE_REF_URL)));

	}

}
