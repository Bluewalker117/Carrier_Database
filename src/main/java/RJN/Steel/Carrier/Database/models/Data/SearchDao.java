package RJN.Steel.Carrier.Database.models.Data;

import RJN.Steel.Carrier.Database.models.Carrier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
@Transactional
public interface SearchDao extends CrudRepository<Carrier, Integer> {



}
