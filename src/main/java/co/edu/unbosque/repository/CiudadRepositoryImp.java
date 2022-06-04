package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Ciudad;
import co.edu.unbosque.entity.Departamento;
import co.edu.unbosque.entity.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Repository
@Transactional
public class CiudadRepositoryImp implements CiudadRepository{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Optional<Ciudad> buscarPorId(Integer id) {
        Ciudad ciudad = entityManager.find(Ciudad.class, id);
        return ciudad != null ? Optional.of(ciudad) : Optional.empty();
    }

    @Override
    public Ciudad buscarPorNombre(String nombre) {
        String query = "FROM Ciudad where nombre = '" + nombre + "'";
        List<Ciudad> lista = entityManager.createQuery(query).getResultList();
        if(lista.size()!= 0){
            return lista.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Integer validarNombre(String nombre) {
        return null;
    }

    @Override
    public Integer obtenerIdPorNombre(String nombre) {
        return buscarPorNombre(nombre).getIdCiudad();
    }

    @Override
    public List<Ciudad> listaCiudades() {
        String query = "FROM Ciudad";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(Ciudad ciudad) {
        entityManager.merge(ciudad);
    }
}
