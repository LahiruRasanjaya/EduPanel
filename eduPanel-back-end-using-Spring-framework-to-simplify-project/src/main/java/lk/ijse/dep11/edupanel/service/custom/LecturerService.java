package lk.ijse.dep11.edupanel.service.custom;

import lk.ijse.dep11.edupanel.service.SuperService;
import lk.ijse.dep11.edupanel.to.LecturerTO;
import lk.ijse.dep11.edupanel.to.request.LecturerReqTO;
import lk.ijse.dep11.edupanel.util.LecturerType;

import java.util.List;

public interface LecturerService extends SuperService {

//    void setPictureRepository(PictureRepository pictureRepository);
//    void setLinkedInRepository(LinkedInRepository linkedInRepository);
//    void setLecturerRepository(LecturerRepository lecturerRepository);

    LecturerTO saveLecturer(LecturerReqTO lecturerReqTO);

    void updateLecturerDetails(LecturerReqTO lecturerReqTO);

    void updateLecturerDetails(LecturerTO lecturerTO);

    void deleteLecturer(Integer lecturerId);

    LecturerTO getLecturerDetails(Integer lecturerId);

    List<LecturerTO> getLecturers(LecturerType type);
}
