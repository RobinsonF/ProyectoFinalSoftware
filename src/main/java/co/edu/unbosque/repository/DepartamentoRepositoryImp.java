package co.edu.unbosque.repository;

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
public class DepartamentoRepositoryImp implements DepartamentoRepository{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Optional<Departamento> buscarPorId(Integer id) {
        Departamento departamento = entityManager.find(Departamento.class, id);
        return departamento != null ? Optional.of(departamento) : Optional.empty();
    }

    @Override
    public List<Departamento> listaDepartamentos() {
        String query = "FROM Departamento";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(Departamento departamento) {
        entityManager.merge(departamento);
    }

    @Override
    public Departamento buscarPorNombre(String nombre) {
        String query = "FROM Departamento where nombre = '" + nombre + "'";
        List<Departamento> lista = entityManager.createQuery(query).getResultList();
        if(lista.size()!= 0){
            return lista.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Integer obtenerIdPorNombre(String nombre) {
        return buscarPorNombre(nombre).getIdDepartamento();
    }
}
