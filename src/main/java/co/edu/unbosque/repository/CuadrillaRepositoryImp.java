package co.edu.unbosque.repository;

import co.edu.unbosque.dto.CuadrillaDTO;
import co.edu.unbosque.entity.Cuadrilla;
import co.edu.unbosque.entity.Usuario;
import co.edu.unbosque.entity.Usuariocuadrilla;
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
public class CuadrillaRepositoryImp implements CuadrillaRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Optional<Cuadrilla> buscarPorId(Integer id) {
        Cuadrilla cuadrilla = entityManager.find(Cuadrilla.class, id);
        return cuadrilla != null ? Optional.of(cuadrilla) : Optional.empty();
    }

    @Override
    public Cuadrilla buscarPorNombre(String nombre) {
        String query = "FROM Cuadrilla where nombre_cuadrilla = '" + nombre + "'";
        List<Cuadrilla> lista = entityManager.createQuery(query).getResultList();
        if (lista.size() != 0) {
            return lista.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Integer validarNombre(String nombre) {
        Cuadrilla cuadrilla = buscarPorNombre(nombre);
        if (cuadrilla != null) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Integer obtenerIdPorNombre(String nombre) {
        return buscarPorNombre(nombre).getIdCuadrilla();
    }

    @Override
    public void eliminarCuadrilla(Integer id) {
        Cuadrilla cuadrilla = entityManager.find(Cuadrilla.class, id);
        cuadrilla.setEstado("I");
        entityManager.merge(cuadrilla);
    }

    @Override
    public List<CuadrillaDTO> listaCuadrillaUsuario(Integer id) {
        String query = "select c.idCuadrilla, c.nombreCuadrilla from Cuadrilla c, Usuariocuadrilla u, Usuario u2 where c.idCuadrilla  = u.cuadrilla.idCuadrilla and u.usuario.idUsuario = u2.idUsuario and u2.idUsuario = " + id + " and c.estado = 'A'";
        List<CuadrillaDTO> listaDTO = new ArrayList<>();
        Query q = entityManager.createQuery(query);
        List<Object[]> datos = q.getResultList();
        for (Object[] obj : datos) {
            Cuadrilla cuadrilla = buscarPorNombre(obj[1].toString());
            listaDTO.add(new CuadrillaDTO(Integer.parseInt(obj[0].toString()),obj[1].toString(), cuadrilla.getOrdentrabajos().size()));
        }
        return listaDTO;
    }

    @Override
    public List<Cuadrilla> listaCuadrillas() {
        String query = "FROM Cuadrilla WHERE estado = 'A'";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(Cuadrilla cuadrilla) {
        entityManager.merge(cuadrilla);
    }
}
