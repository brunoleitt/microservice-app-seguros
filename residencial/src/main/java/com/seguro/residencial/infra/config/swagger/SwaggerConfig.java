package com.seguro.residencial.infra.config.swagger;

import com.seguro.residencial.application.models.input.cotacao.CriarCotacaoInput;
import com.seguro.residencial.application.models.view.CotacaoCriadaViewModel;
import com.seguro.residencial.application.models.view.CotacaoModel;
import com.seguro.residencial.domain.models.root.clientes.ClienteEndereco;
import com.seguro.residencial.domain.models.root.clientes.ClienteRoot;
import com.seguro.residencial.domain.models.root.clientes.Profissao;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import com.seguro.residencial.domain.models.root.cotacoes.TipoCalculo;
import com.seguro.residencial.domain.models.root.cotacoes.TipoVigencia;
import com.seguro.residencial.domain.models.root.itens.ItemEndereco;
import com.seguro.residencial.domain.models.root.itens.ItemRoot;
import com.seguro.residencial.domain.models.root.questionarios.QuestionarioRoot;
import com.seguro.residencial.infra.swagger.BaseSwaggerConfig;
import com.seguro.residencial.web.api.controller.exceptionHandle.Problem;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @criado 22/09/2020 - 19:39
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig  {


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .ignoredParameterTypes(ClienteEndereco.class, ClienteRoot.class,CotacaoRoot.class, ItemEndereco.class, ItemRoot.class,
                        Profissao.class, QuestionarioRoot.class,TipoCalculo.class,TipoVigencia.class, Problem.class,Problem.Object.class)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.seguro.residencial.web.api.controller"))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Spring Boot Microservices - Seguros")
                .description("Aplicação para modulo de seguro Residencial")
                .version("1.0")
                .contact(new Contact("Bruno Leite", "https://github.com/brunoleitt", "brunoleitt@gmail.com"))
                .license("Bruno Leite")
                .licenseUrl("http://brunoleite.seguros")
                .build();
    }

}