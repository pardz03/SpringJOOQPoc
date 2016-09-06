package com.poc.core;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NameTokenizers;
import org.modelmapper.jooq.RecordValueReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan({"com.poc"})
public class SpringConfig {
	
    @Bean
    public ModelMapper modelMapper(){
    	ModelMapper modelMapper = new ModelMapper();   	
    	modelMapper.getConfiguration().addValueReader(new RecordValueReader());
    	modelMapper.getConfiguration().setSourceNameTokenizer(NameTokenizers.UNDERSCORE);
    	return modelMapper;
    }
}
