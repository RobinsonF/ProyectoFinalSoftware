package co.edu.unbosque.repository;

import co.edu.unbosque.dto.MaterialDTO;
import co.edu.unbosque.dto.ZonaDTO;
import co.edu.unbosque.entity.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ZonaRepositoryImp implements ZonaRepository{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Zona buscarPorId2(Integer id) {
        Zona zona = entityManager.find(Zona.class, id);
        return zona;
    }

    @Override
    public Optional<Zona> buscarPorId(Integer id) {
        Zona zona = entityManager.find(Zona.class, id);
        return zona != null ? Optional.of(zona) : Optional.empty();
    }

    @Override
    public Integer obtenerIdPorNombre(String nombre) {
        Zona zona = buscarPorNombre(nombre);
        return zona.getIdZona();
    }

    @Override
    public String eliminarZona(Integer id) {
        Zona zona = entityManager.find(Zona.class, id);
        if(zona.getOrdentrabajos().size()==0){
            zona.setEstado("I");
            entityManager.merge(zona);
            return "Eliminado correctamente";
        }else{
            return "No se puede elimianr la zona porque cuenta con ordendes de trabajo activas";
        }

    }

    @Override
    public List<Zona> listaZonas() {
        String query = "FROM Zona WHERE estado = 'A'";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(Zona zona) {
        entityManager.merge(zona);
    }

    @Override
    public Zona buscarPorNombre(String nombre) {
        String query = "FROM Zona where lower(nombre) = '" + nombre.toLowerCase() + "'";
        List<Zona> lista = entityManager.createQuery(query).getResultList();
        if(lista.size()!= 0){
            return lista.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Integer validarNombre(String nombre) {
        Zona zona = buscarPorNombre(nombre);
        if(zona!=null){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public Zona buscarPorNombre2(String nombre, String nombre2) {
        String query = "FROM Zona where lower(nombre) not in ('" + nombre2.toLowerCase() + "') and lower(nombre) = '" + nombre.toLowerCase() + "'";
        List<Zona> lista = entityManager.createQuery(query).getResultList();
        if (lista.size() != 0) {
            return lista.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Integer validarNombre2(String nombre, String nombre2) {
        Zona zona = buscarPorNombre2(nombre, nombre2);
        if(zona == null){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public void editarZona(ZonaDTO zonaDTO) {
        Zona zona = entityManager.find(Zona.class, zonaDTO.getIdZona());
        zona.setNombre(zonaDTO.getNombre());
        zona.setLimiteNorte(zonaDTO.getLimiteNorte());
        zona.setLimiteOccidente(zonaDTO.getLimiteOccidente());
        zona.setLimiteOriente(zonaDTO.getLimiteOriente());
        zona.setLimiteSur(zonaDTO.getLimiteSur());
        entityManager.merge(zona);
    }
}
