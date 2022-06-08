package co.edu.unbosque.repository;

import co.edu.unbosque.dto.CuadrillaDTO;
import co.edu.unbosque.dto.OrdenTrabajoDTO;
import co.edu.unbosque.entity.Cuadrilla;
import co.edu.unbosque.entity.Ordentrabajo;
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
public class OrdenTrabajoRepositoryImp implements OrdenTrabajoRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Optional<Ordentrabajo> buscarPorId(Integer id) {
        Ordentrabajo ordentrabajo = entityManager.find(Ordentrabajo.class, id);
        return ordentrabajo != null ? Optional.of(ordentrabajo) : Optional.empty();
    }

    @Override
    public void eliminarOrden(Integer id) {
        Ordentrabajo ordentrabajo = entityManager.find(Ordentrabajo.class, id);
        ordentrabajo.setEstado("I");
        entityManager.merge(ordentrabajo);
    }

    @Override
    public List<OrdenTrabajoDTO> listaPorUsuario(Integer id) {
        String query = "select o.idTrabajo, o.nombreTrabajo, c.nombreCuadrilla, z.nombre, o.fechaTrabajoi, o.fechaTrabajof from Cuadrilla c, Usuariocuadrilla u, Usuario u2, Ordentrabajo o, Zona z  where c.idCuadrilla  = u.cuadrilla.idCuadrilla and u.usuario.idUsuario = u2.idUsuario and o.cuadrilla.idCuadrilla = c.idCuadrilla and z.idZona = o.zona.idZona  and o.estado = 'A' and u2.idUsuario =" + id;
        List<OrdenTrabajoDTO> listaDTO = new ArrayList<>();
        Query q = entityManager.createQuery(query);
        List<Object[]> datos = q.getResultList();
        for (Object[] obj : datos) {
            listaDTO.add(new OrdenTrabajoDTO(
                    Integer.parseInt(obj[0].toString()),
                    obj[1].toString(),
                    obj[2].toString(),
                    obj[3].toString(),
                    obj[4].toString()
                    ));
        }
        return listaDTO;
    }

    @Override
    public List<Ordentrabajo> listaOrdenes() {
        String query = "FROM Ordentrabajo WHERE estado = 'A'";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(Ordentrabajo ordentrabajo) {
        entityManager.merge(ordentrabajo);
    }
}
