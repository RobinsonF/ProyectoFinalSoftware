package co.edu.unbosque.repository;

import co.edu.unbosque.entity.TipoMaterial;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Repository
@Transactional
public class TipoMaterialRepositoryImp implements TipoMaterialRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Optional<TipoMaterial> buscarPorId(Integer id) {
        TipoMaterial tipoMaterial = entityManager.find(TipoMaterial.class, id);
        return tipoMaterial != null ? Optional.of(tipoMaterial) : Optional.empty();
    }

    @Override
    public List<TipoMaterial> listarTipos() {
        String query = "FROM TipoMaterial";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(TipoMaterial tipoMaterial) {
        entityManager.merge(tipoMaterial);
    }

    @Override
    public TipoMaterial buscarPorNombre(String nombre) {
        String query = "FROM TipoMaterial where nombre = '" + nombre + "'";
        List<TipoMaterial> lista = entityManager.createQuery(query).getResultList();
        if(lista.size()!= 0){
            return lista.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Integer obtenerIdPorNombre(String nombre) {
        return buscarPorNombre(nombre).getIdMaterial();
    }
}
