package comgetit.workarea;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkAreaRepository extends JpaRepository<WorkArea, Long> {

}
