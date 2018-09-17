package RJN.Steel.Carrier.Database.models;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import RJN.Steel.Carrier.Database.models.SearchService;

@EnableAutoConfiguration
@Configuration
public class SearchConfiguration {

    @Autowired
    private EntityManager beanentityManager;

    @Bean
    SearchService searchService(){
        SearchService searchService = new SearchService(beanentityManager);
        searchService.intializeSearch();
        return searchService;
    }


}
