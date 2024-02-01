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

        return lecturerService.saveLecturer(lecturerReqTo);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{lecturer-id}", consumes = "multipart/form-data")
    public void updateLecturerDetailsViaMultipart(@PathVariable("lecturer-id") Integer lecturerId,
                                                  @ModelAttribute @Validated(LecturerReqTO.Update.class) LecturerReqTO lecturerReqTO){

        lecturerReqTO.setId(lecturerId);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{lecturer-id}",consumes = "application/json")
    public void updateLecturerDetailsViaJson(@PathVariable("lecturer-id") Integer lecturerId,
                                             @RequestBody @Validated LecturerTO lecturerTO){

        lecturerTO.setId(lecturerId);
        lecturerService.updateLecturerDetails(lecturerTO);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{lecturer-id}")
    public void deleteLecturer(@PathVariable("lecturer-id") Integer lecturerId){


        lecturerService.deleteLecturer(lecturerId);

    }

    @GetMapping(produces = "application/json")
    public List<LecturerTO> getAllLecturers(){

        return lecturerService.getLecturers(null);


    }

    @GetMapping(value = "/{lecturer-id}" , produces = "application/json")
    public LecturerTO getLecturerDetails(@PathVariable("lecturer-id") Integer lecturerId){

        return lecturerService.getLecturerDetails(lecturerId);

    }

    @GetMapping(params = "type=full-time", produces = "application/json")
    public List<LecturerTO> getFullTimeLecturers(){

        return lecturerService.getLecturers(LecturerType.FULL_TIME);

    }

    @GetMapping(params = "type=visiting", produces = "application/json")
    public List<LecturerTO> getPartTimeLecturers(){

        return lecturerService.getLecturers(LecturerType.VISITING);

    }

}
