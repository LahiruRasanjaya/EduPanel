package lk.ijse.dep11.edupanel.api;

import com.google.cloud.storage.Bucket;
import lk.ijse.dep11.edupanel.service.custom.LecturerService;
import lk.ijse.dep11.edupanel.to.LecturerTO;
import lk.ijse.dep11.edupanel.to.request.LecturerReqTO;
import lk.ijse.dep11.edupanel.util.LecturerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@RequestMapping("/api/v1/lecturers")
@CrossOrigin
public class LecturerHttpController {

    @Autowired
    private LecturerService lecturerService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "multipart/form-data", produces = "application/json")
    public LecturerTO createNewLecturer(@ModelAttribute @Validated(LecturerReqTO.Create.class)
                                      LecturerReqTO lecturerReqTo){
//
//        AppStore.setBucket(bucket);
//        AppStore.setEntityManager(em);
//        LecturerService lecturerService = ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.LECTURER);
        return lecturerService.saveLecturer(lecturerReqTo);

//        em.getTransaction().begin();
//        try {
//            Lecturer lecturer = mapper.map(lecturerReqTo, Lecturer.class);
//            lecturer.setPicture(null);
//            lecturer.setLinkedIn(null);
//            em.persist(lecturer);
//            LecturerTO lecturerTO = mapper.map(lecturer, LecturerTO.class);
//
//            if (lecturerReqTo.getLinkedin() != null) {
//                LinkedIn linkedIn = new LinkedIn(lecturer, lecturerReqTo.getLinkedin());
//                em.persist(linkedIn);
//                lecturer.setLinkedIn(linkedIn);
//                lecturerTO.setLinkedin(lecturerReqTo.getLinkedin());
//            }
//
//            if (lecturerReqTo.getPicture() != null) {
//                Picture picture = new Picture(lecturer, "lecturers/" + lecturer.getId());
//                lecturer.setPicture(picture);
//                em.persist(picture);
//
//                Blob blobRef = bucket.create(picture.getPicturePath(), lecturerReqTo.getPicture().getInputStream(), lecturerReqTo.getPicture().getContentType());
//                lecturerTO.setPicture(blobRef.signUrl(1, TimeUnit.DAYS, Storage.SignUrlOption.withV4Signature()).toString());
//            }
//
//            em.getTransaction().commit();
//            return lecturerTO;
//        } catch (Throwable t) {
//            em.getTransaction().rollback();
//            throw new RuntimeException(t);
//        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{lecturer-id}", consumes = "multipart/form-data")
    public void updateLecturerDetailsViaMultipart(@PathVariable("lecturer-id") Integer lecturerId,
                                                  @ModelAttribute @Validated(LecturerReqTO.Update.class) LecturerReqTO lecturerReqTO){

//        AppStore.setBucket(bucket);
//        AppStore.setEntityManager(em);
        lecturerReqTO.setId(lecturerId);
//        LecturerService lecturerService = ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.LECTURER);
//        lecturerService.updateLecturerDetails(lecturerReqTO);

//        Lecturer currentLecturer = em.find(Lecturer.class, lecturerId);
//        if (currentLecturer == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//
//        em.getTransaction().begin();
//        try {
//            Lecturer newLecturer = mapper.map(lecturerReqTO, Lecturer.class);
//            newLecturer.setId(lecturerId);
//            newLecturer.setPicture(null);
//            newLecturer.setLinkedIn(null);
//
//            if (lecturerReqTO.getPicture() != null) {
//                newLecturer.setPicture(new Picture(newLecturer, "lecturers/" + lecturerId));
//            }
//            if (lecturerReqTO.getLinkedin() != null) {
//                newLecturer.setLinkedIn(new LinkedIn(newLecturer, lecturerReqTO.getLinkedin()));
//            }
//
//            updateLinkedIn(currentLecturer, newLecturer);
//
//            if (newLecturer.getPicture() != null && currentLecturer.getPicture() == null) {
//                em.persist(newLecturer.getPicture());
//                bucket.create(newLecturer.getPicture().getPicturePath(), lecturerReqTO.getPicture().getInputStream(), lecturerReqTO.getPicture().getContentType());
//            } else if (newLecturer.getPicture() == null && currentLecturer.getPicture() != null) {
//                em.remove(currentLecturer.getPicture());
//                bucket.get(currentLecturer.getPicture().getPicturePath()).delete();
//            } else if (newLecturer.getPicture() != null) {
//                em.merge(newLecturer.getPicture());
//                bucket.create(newLecturer.getPicture().getPicturePath(), lecturerReqTO.getPicture().getInputStream(), lecturerReqTO.getPicture().getContentType());
//            }
//
//            em.merge(newLecturer);
//            em.getTransaction().commit();
//        } catch (Throwable t) {
//            em.getTransaction().rollback();
//            throw new RuntimeException(t);
//        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{lecturer-id}",consumes = "application/json")
    public void updateLecturerDetailsViaJson(@PathVariable("lecturer-id") Integer lecturerId,
                                             @RequestBody @Validated LecturerTO lecturerTO){

//        AppStore.setBucket(bucket);
//        AppStore.setEntityManager(em);
        lecturerTO.setId(lecturerId);
//        LecturerService lecturerService = ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.LECTURER);
        lecturerService.updateLecturerDetails(lecturerTO);

//        Lecturer currentLecturer = em.find(Lecturer.class, lecturerId);
//        if (currentLecturer == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//
//        em.getTransaction().begin();
//        try {
//            Lecturer newLecturer = mapper.map(lecturerTO, Lecturer.class);
//            newLecturer.setId(lecturerId);
//            newLecturer.setPicture(currentLecturer.getPicture());
//            newLecturer.setLinkedIn(lecturerTO.getLinkedin() != null ? new LinkedIn(newLecturer, lecturerTO.getLinkedin()) : null);
//
//            updateLinkedIn(currentLecturer, newLecturer);
//
//            em.merge(newLecturer);
//            em.getTransaction().commit();
//        } catch (Throwable t) {
//            em.getTransaction().rollback();
//            throw new RuntimeException(t);
//        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{lecturer-id}")
    public void deleteLecturer(@PathVariable("lecturer-id") Integer lecturerId){

//        AppStore.setBucket(bucket);
//        AppStore.setEntityManager(em);
//        LecturerService lecturerService = ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.LECTURER);
        lecturerService.deleteLecturer(lecturerId);

//        Lecturer lecturer = em.find(Lecturer.class, lecturerId);
//        if (lecturer == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        em.getTransaction().begin();
//        try {
//            em.remove(lecturer);
//
//            if (lecturer.getPicture() != null) {
//                bucket.get(lecturer.getPicture().getPicturePath()).delete();
//            }
//
//            em.getTransaction().commit();
//        } catch (Throwable t) {
//            em.getTransaction().rollback();
//            throw new RuntimeException(t);
//        }
    }

    @GetMapping(produces = "application/json")
    public List<LecturerTO> getAllLecturers(){

//        AppStore.setBucket(bucket);
//        AppStore.setEntityManager(em);
//        LecturerService lecturerService = ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.LECTURER);
        return lecturerService.getLecturers(null);

//        TypedQuery<Lecturer> query = em.createQuery("SELECT l FROM Lecturer l", Lecturer.class);
//        return getLecturerTOList(query);

    }

    @GetMapping(value = "/{lecturer-id}" , produces = "application/json")
    public LecturerTO getLecturerDetails(@PathVariable("lecturer-id") Integer lecturerId){

//        AppStore.setBucket(bucket);
//        AppStore.setEntityManager(em);
//        LecturerService lecturerService = ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.LECTURER);
        return lecturerService.getLecturerDetails(lecturerId);

//        Lecturer lecturer = em.find(Lecturer.class, lecturerId);
//        if (lecturer == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        return getLecturerTO(lecturer);
    }

    @GetMapping(params = "type=full-time", produces = "application/json")
    public List<LecturerTO> getFullTimeLecturers(){

//        AppStore.setBucket(bucket);
//        AppStore.setEntityManager(em);
//        LecturerService lecturerService = ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.LECTURER);
        return lecturerService.getLecturers(LecturerType.FULL_TIME);

//        TypedQuery<Lecturer> query = em.createQuery("SELECT l FROM Lecturer l WHERE l.type = lk.ijse.dep11.edupanel.util.LecturerType.FULL_TIME", Lecturer.class);
//        return getLecturerTOList(query);
    }

    @GetMapping(params = "type=visiting", produces = "application/json")
    public List<LecturerTO> getPartTimeLecturers(){

//        AppStore.setBucket(bucket);
//        AppStore.setEntityManager(em);
//        LecturerService lecturerService = ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.LECTURER);
        return lecturerService.getLecturers(LecturerType.VISITING);

//        TypedQuery<Lecturer> query = em.createQuery("SELECT l FROM Lecturer l WHERE l.type = lk.ijse.dep11.edupanel.util.LecturerType.VISITING", Lecturer.class);
//        return getLecturerTOList(query);
    }

//    private List<LecturerTO> getLecturerTOList(TypedQuery<Lecturer> query) {
//        return query.getResultStream().map(this::getLecturerTO).collect(Collectors.toList());
//    }
//
//    private LecturerTO getLecturerTO(Lecturer lectureEntity) {
//        LecturerTO lecturerTO = mapper.map(lectureEntity, LecturerTO.class);
//        if (lectureEntity.getLinkedIn() != null) lecturerTO.setLinkedin(lectureEntity.getLinkedIn().getUrl());
//        if (lectureEntity.getPicture() != null) {
//            lecturerTO.setPicture(bucket.get(lectureEntity.getPicture().getPicturePath()).signUrl(1, TimeUnit.DAYS, Storage.SignUrlOption.withV4Signature()).toString());
//        }
//        return lecturerTO;
//    }
//    private void updateLinkedIn(Lecturer currentLecturer, Lecturer newLecturer){
//        if (newLecturer.getLinkedIn() != null && currentLecturer.getLinkedIn() == null) {
//            em.persist(newLecturer.getLinkedIn());
//        } else if (newLecturer.getLinkedIn() == null && currentLecturer.getLinkedIn() != null) {
//            em.remove(currentLecturer.getLinkedIn());
//        } else if (newLecturer.getLinkedIn() != null) {
//            em.merge(newLecturer.getLinkedIn());
//        }
//    }
}
