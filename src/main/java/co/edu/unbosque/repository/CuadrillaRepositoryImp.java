package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Cuadrilla;
import co.edu.unbosque.entity.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class CuadrillaRepositoryImp implements CuadrillaRepository{
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
        if(lista.size()!= 0){
            return lista.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Integer validarNombre(String nombre) {
        Cuadrilla cuadrilla = buscarPorNombre(nombre);
        if(cuadrilla != null){
            return 1;
        }else{
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
    public List<Cuadrilla> listaCuadrillas() {
        String query = "FROM Cuadrilla WHERE estado = 'A'";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(Cuadrilla cuadrilla) {
        entityManager.merge(cuadrilla);
    }
}
