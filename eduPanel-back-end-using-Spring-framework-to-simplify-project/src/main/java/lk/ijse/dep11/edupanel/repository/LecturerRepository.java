package lk.ijse.dep11.edupanel.repository;

import lk.ijse.dep11.edupanel.entity.Lecturer;
import lk.ijse.dep11.edupanel.util.LecturerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LecturerRepository extends JpaRepository<Lecturer,Integer> {
    // find + Subject + By + Predicate
    // query + Subject + By + Predicate
    // read + Subject + By + Predicate
    // get + Subject + By + Predicate
    List<Lecturer> findLecturersByType(LecturerType type);

//    Optional<Lecturer> findLecturerByIdAndName(Integer id, String name);

    @Query("SELECT l FROM Lecturer l WHERE l.type = lk.ijse.dep11.edupanel.util.LecturerType.FULL_TIME")
    List<Lecturer> findFullTimeLecturers();

    @Query("SELECT l FROM Lecturer l WHERE l.type = lk.ijse.dep11.edupanel.util.LecturerType.VISITING")
    List<Lecturer> findVisitingLectures();
}
