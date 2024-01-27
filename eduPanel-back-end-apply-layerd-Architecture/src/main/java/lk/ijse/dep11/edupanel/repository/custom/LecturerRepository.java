package lk.ijse.dep11.edupanel.repository.custom;

import lk.ijse.dep11.edupanel.entity.Lecturer;
import lk.ijse.dep11.edupanel.repository.CrudRepository;
import lk.ijse.dep11.edupanel.util.LecturerType;

import java.util.List;

public interface LecturerRepository extends CrudRepository<Lecturer,Integer> {
    List<Lecturer> findLecturersByType(LecturerType type);
//    List<Lecturer> findFullTimeLecturers();
//    List<Lecturer> findVisitingLectures();
}
