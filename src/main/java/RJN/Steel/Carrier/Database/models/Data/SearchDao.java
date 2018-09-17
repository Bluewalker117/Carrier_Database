package RJN.Steel.Carrier.Database.models.Data;

import RJN.Steel.Carrier.Database.models.Carrier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface SearchDao extends CrudRepository<Carrier, Integer> {

    List<Carrier> findByName(String name);
}
