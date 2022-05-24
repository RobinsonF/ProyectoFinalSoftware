package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Cuadrilla;
import co.edu.unbosque.entity.Empleado;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class EmpleadoRepositoryImp implements EmpleadoRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Optional<Empleado> buscarPorId(Integer id) {
        Empleado empleado = entityManager.find(Empleado.class, id);
        return empleado != null ? Optional.of(empleado) : Optional.empty();
    }

    @Override
    public List<Empleado> listaEmpleados() {
        String query = "FROM Empleado";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(Empleado empleado) {
        entityManager.merge(empleado);
    }
}
