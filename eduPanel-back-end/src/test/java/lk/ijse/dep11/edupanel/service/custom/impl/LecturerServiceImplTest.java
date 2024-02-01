package lk.ijse.dep11.edupanel.service.custom.impl;

import lk.ijse.dep11.edupanel.exception.AppException;
import lk.ijse.dep11.edupanel.service.custom.LecturerService;
import lk.ijse.dep11.edupanel.to.LecturerTO;
import lk.ijse.dep11.edupanel.to.request.LecturerReqTO;
import lk.ijse.dep11.edupanel.util.LecturerType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;


//@ExtendWith(MockitoExtension.class)

//@SpringJUnitWebConfig(classes = {WebRootConfig.class, AppConfig.class})
@SpringBootTest
@Transactional
class LecturerServiceImplTest {

    @Autowired
    private LecturerService lecturerService;

//    @Mock
//    private LecturerRepository lecturerRepository;
//    @Mock
//    private LinkedInRepository linkedInRepository;
//    @Mock
//    private PictureRepository pictureRepository;

    @BeforeEach
    void setUp() {

//        entityManager = emf.createEntityManager();

        // when(lecturerRepository.count()).thenReturn(10L);
//        when(lecturerRepository.save(any(Lecturer.class))).thenAnswer(inv ->{
//            Lecturer lecturer = inv.getArgument(0);
//            lecturer.setId(1);
//            return lecturer;
//        });
//
//        when(linkedInRepository.save(any(LinkedIn.class))).thenAnswer(inv -> inv.getArgument(0));
//
//        lecturerService.setLecturerRepository(lecturerRepository);
//        lecturerService.setLinkedInRepository(linkedInRepository);
//        lecturerService.setPictureRepository(pictureRepository);
    }

    @AfterEach
    void tearDown() {
//        entityManager.close();
    }

    @Test
    void saveLecturer() {
        LecturerReqTO lecturerReqTo = new LecturerReqTO("Amith",
                "Associate Lecturer", "BSc, MSc",
                LecturerType.VISITING, 5,
                null,
                "https://linkedin.com");
        LecturerTO lecturerTO = lecturerService.saveLecturer(lecturerReqTo);

        assertNotNull(lecturerTO.getId());
        assertTrue(lecturerTO.getId() > 0);
        assertEquals(lecturerReqTo.getName(), lecturerTO.getName());
        assertEquals(lecturerReqTo.getDesignation(), lecturerTO.getDesignation());
        assertEquals(lecturerReqTo.getQualifications(), lecturerTO.getQualifications());
        assertEquals(lecturerReqTo.getType(), lecturerTO.getType());
        assertEquals(lecturerReqTo.getDisplayOrder(), lecturerTO.getDisplayOrder());
        assumingThat(lecturerReqTo.getLinkedin() != null, () -> assertEquals(lecturerReqTo.getLinkedin(), lecturerTO.getLinkedin()));
        assumingThat(lecturerReqTo.getLinkedin() == null, () -> assertNull(lecturerTO.getLinkedin()));

//        if (lecturerReqTo.getLinkedin() != null){
//            assertEquals(lecturerReqTo.getLinkedin(), lecturerTO.getLinkedin());
//        }else{
//            assertNull(lecturerTO.getLinkedin());
//        }
    }

    @Test
    void deleteLecturer() {
        LecturerReqTO lecturerReqTo = new LecturerReqTO("Amith",
                "Associate Lecturer", "BSc, MSc",
                LecturerType.VISITING, 5,
                null,
                "https://linkedin.com");
        LecturerTO lecturerTO = lecturerService.saveLecturer(lecturerReqTo);
        lecturerService.deleteLecturer(lecturerTO.getId());
        assertThrows(AppException.class, () -> lecturerService.getLecturerDetails(lecturerTO.getId()));
        assertThrows(AppException.class, () -> lecturerService.deleteLecturer(-100));
    }

    @Test
    void getLecturerDetails() {
        LecturerReqTO lecturerReqTo = new LecturerReqTO("Amith",
                "Associate Lecturer", "BSc, MSc",
                LecturerType.VISITING, 5,
                null,
                "https://linkedin.com");
        LecturerTO lecturerTO = lecturerService.saveLecturer(lecturerReqTo);
        LecturerTO lecturer = lecturerService.getLecturerDetails(lecturerTO.getId());
        assertEquals(lecturerTO, lecturer);
        assertThrows(AppException.class, () -> lecturerService.getLecturerDetails(-100));
    }

    @Test
    void getLecturers() {
        for (int i = 0; i < 10; i++) {
            LecturerReqTO lecturerReqTo = new LecturerReqTO("Amith",
                    "Associate Lecturer", "BSc, MSc",
                    i < 5 ? LecturerType.VISITING : LecturerType.FULL_TIME, 5,
                    null,
                    "https://linkedin.com");
            lecturerService.saveLecturer(lecturerReqTo);
        }
        assertTrue(lecturerService.getLecturers(null).size() >= 10);
        assertTrue(lecturerService.getLecturers(LecturerType.FULL_TIME).size() >= 5);
        assertTrue(lecturerService.getLecturers(LecturerType.VISITING).size() >= 5);
    }

    @Test
    void updateLecturerDetails() {
        LecturerReqTO lecturerReqTo = new LecturerReqTO("Amith",
                "Associate Lecturer", "BSc, MSc",
                LecturerType.VISITING, 5,
                null,
                "https://linkedin.com");
        LecturerTO lecturerTO = lecturerService.saveLecturer(lecturerReqTo);
        lecturerTO.setName("Nuwan");
        lecturerTO.setLinkedin(null);
        lecturerService.updateLecturerDetails(lecturerTO);
        LecturerTO lecturer = lecturerService.getLecturerDetails(lecturerTO.getId());
        assertEquals(lecturerTO, lecturer);
    }

}