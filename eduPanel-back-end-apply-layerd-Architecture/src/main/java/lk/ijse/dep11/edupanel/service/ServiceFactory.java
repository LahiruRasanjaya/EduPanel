package lk.ijse.dep11.edupanel.service;

import lk.ijse.dep11.edupanel.service.custom.impl.LecturerServiceImpl;

public class ServiceFactory {
    private static ServiceFactory INSTANCE;

    private ServiceFactory(){}

    public enum ServiceType{
        LECTURER, USER
    }
    private static ServiceFactory getInstance(){
        return (INSTANCE ==null)? (INSTANCE =new ServiceFactory()):INSTANCE;
    }

    public <T extends SuperService> T getService(ServiceType type){
        switch (type){
            case LECTURER:
                return (T) new LecturerServiceImpl();
            case USER:
                throw new RuntimeException("Not implement yet");
            default:
                throw new IllegalArgumentException();
        }
    }
}
