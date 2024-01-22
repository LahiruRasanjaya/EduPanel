package lk.ijse.dep11.edupanel.repository;

import lk.ijse.dep11.edupanel.repository.custom.impl.LecturerRepositoryImpl;
import lk.ijse.dep11.edupanel.repository.custom.impl.LinkedinRepositoryImpl;
import lk.ijse.dep11.edupanel.repository.custom.impl.PictureRepositoryImpl;
import lk.ijse.dep11.edupanel.repository.custom.impl.QueryRepositoryImpl;

public class RepositoryFactory {
    public enum RepositoryType{
        LECTURER, LINKEDIN, PICTURE, QUERY
    }

    private static RepositoryFactory INSTANCE;

    private RepositoryFactory() {
    }

    public static RepositoryFactory getInstance() {
        return (INSTANCE == null) ? (INSTANCE = new RepositoryFactory()) : INSTANCE;
    }

    public <T extends SuperRepository> T getRepository(RepositoryType type){
        switch (type){
            case LECTURER:
                return (T) new LecturerRepositoryImpl();
            case LINKEDIN:
                return (T) new LinkedinRepositoryImpl();
            case PICTURE:
                return (T) new PictureRepositoryImpl();
            case QUERY:
                return (T) new QueryRepositoryImpl();
            default:
                throw new IllegalArgumentException();
        }
    }

//    public LecturerRepository getLecturerRepository(){
//        return new LecturerRepositoryImpl();
//    }
//
//    public LinkedInRepository getLinkedInRepository(){
//        return new LinkedInRepositoryImpl();
//    }
//
//    public PictureRepository getPictureRepository(){
//        return new PictureRepositoryImpl();
//    }
//
//    public QueryRepository getQueryRepository(){
//        return new QueryRepositoryImpl();
//    }
}
