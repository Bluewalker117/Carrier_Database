package RJN.Steel.Carrier.Database.models;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CarrierSearch {

    @PersistenceContext
    private EntityManager entityManager;

    public List search(String searchInput){

        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Carrier.class).get();

        org.apache.lucene.search.Query query= queryBuilder.keyword().onFields("name").matching(searchInput).createQuery();

        org.hibernate.search.jpa.FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, Carrier.class);

        @SuppressWarnings("unchecked")
        List results = jpaQuery.getResultList();

        return results;

    }
}
