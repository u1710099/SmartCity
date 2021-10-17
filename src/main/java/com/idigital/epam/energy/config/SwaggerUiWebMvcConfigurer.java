package com.idigital.epam.energy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//https://springfox.github.io/springfox/docs/snapshot/
//http://localhost:8081/springfox/swagger-ui/index.html
@Component
public class SwaggerUiWebMvcConfigurer implements WebMvcConfigurer {
	private final String baseUrl;

	/**
	 * @param baseUrl
	 */
	public SwaggerUiWebMvcConfigurer(
			@Value("${springfox.documentation.swagger-ui.base-url:}") String baseUrl) {
		this.baseUrl = baseUrl;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String baseUrl = StringUtils.trimTrailingCharacter(this.baseUrl, '/');
		registry.
		addResourceHandler(baseUrl + "/swagger-ui/**")
		.addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
		.resourceChain(false);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController(baseUrl + "/swagger-ui/")
		.setViewName("forward:" + baseUrl + "/swagger-ui/index.html");
	}


	/**
	 *
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//customer
		registry
		.addMapping("/api/customer")
		.allowedOrigins("http://editor.swagger.io");
		registry
		.addMapping("/v2/api-docs.*")
		.allowedOrigins("http://editor.swagger.io");
		registry
		.addMapping("/api/customer")
		.allowedOrigins("*");

		//payment
		registry
		.addMapping("/api/payment")
		.allowedOrigins("http://editor.swagger.io");
		registry
		.addMapping("/v2/api-docs.*")
		.allowedOrigins("http://editor.swagger.io");
		registry
		.addMapping("/api/payment")
		.allowedOrigins("*");

		//admin
		registry
		.addMapping("/admin")
		.allowedOrigins("http://editor.swagger.io");
		registry
		.addMapping("/v2/api-docs.*")
		.allowedOrigins("http://editor.swagger.io");
		registry
		.addMapping("/admin")
		.allowedOrigins("*");

		//CustomerLogin
		registry
		.addMapping("/api/customerLogin/login")
		.allowedOrigins("http://editor.swagger.io");
		registry
		.addMapping("/v2/api-docs.*")
		.allowedOrigins("http://editor.swagger.io");
		registry
		.addMapping("/api/customerLogin/login")
		.allowedOrigins("*");

		//AdminLogin
		registry
		.addMapping("/api/adminLogin/login")
		.allowedOrigins("http://editor.swagger.io");
		registry
		.addMapping("/v2/api-docs.*")
		.allowedOrigins("http://editor.swagger.io");
		registry
		.addMapping("/api/adminLogin/login")
		.allowedOrigins("*");

		//bill
		registry
		.addMapping("/api/billDetails")
		.allowedOrigins("http://editor.swagger.io");
		registry
		.addMapping("/v2/api-docs.*")
		.allowedOrigins("http://editor.swagger.io");
		registry
		.addMapping("/api/billDetails")
		.allowedOrigins("*");

		//customer forgot password
		registry
		.addMapping("/api/forgotPassword")
		.allowedOrigins("http://editor.swagger.io");
		registry
		.addMapping("/v2/api-docs.*")
		.allowedOrigins("http://editor.swagger.io");
		registry
		.addMapping("/api/forgotPassword")
		.allowedOrigins("*");

		//admin forgot password
		registry
		.addMapping("/api/AdminForgotPassword")
		.allowedOrigins("http://editor.swagger.io");
		registry
		.addMapping("/v2/api-docs.*")
		.allowedOrigins("http://editor.swagger.io");
		registry
		.addMapping("/api/AdminForgotPassword")
		.allowedOrigins("*");





	}
}