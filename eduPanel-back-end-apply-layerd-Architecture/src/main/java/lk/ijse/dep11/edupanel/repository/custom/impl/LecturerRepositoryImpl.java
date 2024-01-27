package lk.ijse.dep11.edupanel.repository.custom.impl;

import lk.ijse.dep11.edupanel.entity.Lecturer;
import lk.ijse.dep11.edupanel.repository.CrudRepositoryImpl;
import lk.ijse.dep11.edupanel.repository.custom.LecturerRepository;
import lk.ijse.dep11.edupanel.util.LecturerType;

import java.util.List;

public class LecturerRepositoryImpl extends CrudRepositoryImpl<Lecturer,Integer> implements LecturerRepository {
    private String type;
    @Override
    public List<Lecturer> findLecturersByType(LecturerType type) {
        this.type= type.name();
        return getEntityManager().createQuery("SELECT l FROM Lecturer l WHERE l.type = lk.ijse.dep11.edupanel.util.LecturerType."+type,Lecturer.class).getResultList();
    }

//    @Override
//    public List<Lecturer> findFullTimeLecturers() {
//        return getEntityManager().createQuery("SELECT l FROM Lecturer l WHERE l.type = lk.ijse.dep11.edupanel.util.LecturerType.FULL_TIME",Lecturer.class).getResultList();
//    }
//
//    @Override
//    public List<Lecturer> findVisitingLectures() {
//        return getEntityManager().createQuery("SELECT l FROM Lecturer l WHERE l.type = lk.ijse.dep11.edupanel.util.LecturerType.VISITING",Lecturer.class).getResultList();
//    }
}
