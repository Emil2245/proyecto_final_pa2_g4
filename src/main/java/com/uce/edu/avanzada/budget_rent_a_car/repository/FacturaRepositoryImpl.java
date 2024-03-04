package com.uce.edu.avanzada.budget_rent_a_car.repository;

import com.uce.edu.avanzada.budget_rent_a_car.repository.model.Factura;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(value = TxType.MANDATORY)
    @Override
    public void insertar(Factura factura) {
        this.entityManager.persist(factura);

    }

    @Transactional(value = TxType.MANDATORY)
    @Override
    public void actualizar(Factura factura) {
        this.entityManager.merge(factura);

    }

    @Transactional(value = TxType.MANDATORY)
    @Override
    public void eliminar(Integer id) {
        Factura fac = this.seleccionar(id);
        this.entityManager.remove(fac);

    }

    @Transactional(value = TxType.NOT_SUPPORTED)
    @Override
    public Factura seleccionar(Integer id) {

        return this.entityManager.find(Factura.class, id);
    }

}