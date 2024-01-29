package lk.ijse.dep11.edupanel.repository.custom.impl;

import lk.ijse.dep11.edupanel.repository.custom.QueryRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
@Component
public class QueryRepositoryImpl implements QueryRepository {

    private EntityManager em;

    @Override
    public void setEntityManager(EntityManager em) {

        this.em = em;
    }
}
