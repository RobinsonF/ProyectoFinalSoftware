package co.edu.unbosque.repository;

import co.edu.unbosque.dto.CuadrillaDTO;
import co.edu.unbosque.dto.EmpleadoDTO;
import co.edu.unbosque.entity.Cuadrilla;
import co.edu.unbosque.entity.Empleado;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
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
    public void eliminarEmpleado(Integer id) {
        Empleado empleado = entityManager.find(Empleado.class, id);
        empleado.setEstado("I");
        entityManager.merge(empleado);
    }

    @Override
    public List<EmpleadoDTO> listaPorUsuario(Integer id) {
        String query = "select e.idEmpleado, e.nombre, e.apellido, e.cedula, c.nombreCuadrilla from Usuario u, Usuariocuadrilla u2, Cuadrilla c, Empleado e where u.idUsuario = u2.usuario.idUsuario and c.idCuadrilla = u2.cuadrilla.idCuadrilla and c.idCuadrilla = e.cuadrilla.idCuadrilla and e.estado = 'A' and u.idUsuario = " + id;
        List<EmpleadoDTO> listaDTO = new ArrayList<>();
        Query q = entityManager.createQuery(query);
        List<Object[]> datos = q.getResultList();
        for (Object[] obj : datos) {
            listaDTO.add(new EmpleadoDTO(Integer.parseInt(obj[0].toString()),obj[1].toString(), obj[2].toString(), obj[3].toString(), obj[4].toString()));
        }
        return listaDTO;
    }

    @Override
    public List<Empleado> listaEmpleados() {
        String query = "FROM Empleado WHERE estado = 'A'";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(Empleado empleado) {
        entityManager.merge(empleado);
    }
}
