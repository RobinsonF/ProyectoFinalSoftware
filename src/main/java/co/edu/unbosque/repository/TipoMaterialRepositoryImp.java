package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Tipomaterial;
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
    public Optional<Tipomaterial> buscarPorId(Integer id) {
        Tipomaterial tipoMaterial = entityManager.find(Tipomaterial.class, id);
        return tipoMaterial != null ? Optional.of(tipoMaterial) : Optional.empty();
    }

    @Override
    public List<Tipomaterial> listarTipos() {
        String query = "FROM Tipomaterial";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(Tipomaterial tipoMaterial) {
        entityManager.merge(tipoMaterial);
    }

    @Override
    public Tipomaterial buscarPorNombre(String nombre) {
        String query = "FROM TipoMaterial where nombre = '" + nombre + "'";
        List<Tipomaterial> lista = entityManager.createQuery(query).getResultList();
        if(lista.size()!= 0){
            return lista.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Integer obtenerIdPorNombre(String nombre) {
        return buscarPorNombre(nombre).getIdTipoMaterial();
    }
}
