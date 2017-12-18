package it.contrader.sprint3.dao;

        import it.contrader.sprint3.model.CompatibilityEntity;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.data.repository.query.Param;
        import org.springframework.stereotype.Repository;

        import javax.transaction.Transactional;
        import java.util.List;

@Repository
@Transactional
public interface CompatibilityRepository extends CrudRepository<CompatibilityEntity, Long>
{
    @Query("SELECT id_gomme FROM CompatibilityEntity WHERE id_vehicle=:id_vehicle")
    List<Integer>  getAllIdGommeForIdVehicle(@Param("id_vehicle") int id_vehicle);
}
