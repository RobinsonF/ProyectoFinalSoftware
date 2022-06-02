package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Parametro;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ParametroRepositoryImp implements ParametroRepository{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Parametro obtenerParametro(String tipo) {
        String query = "FROM Parametro WHERE tipo = '" + tipo + "'";
        List<Parametro> parametros = entityManager.createQuery(query).getResultList();
        return parametros.get(0);
    }
}
