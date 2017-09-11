package com.acme.test01.siphomashapa;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import com.acme.test01.siphomashapa.resources.ACMEBankResource;
import com.google.common.base.Predicate;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Sipho on 10/09/2017.
 */

@Configuration
@ApplicationPath("/acme")
@EnableSwagger2
public class ACMEAppConfig extends ResourceConfig {

	/**
	 * default constructor of ACMEAppConfig
	 */
	public AppleSoftAppConfig() {
		register(ACMEBankResource.class);
	}

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("acmebank-api")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(postPaths())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("acme bank system")
				.description("acmebank API reference for developers")
				.license("acme bank License")
				.version("1.0")
				.build();
	}

	@SuppressWarnings("unchecked")
	private Predicate<String> postPaths() {

		return or(regex("/acme/v1/.*"));
	}
}
