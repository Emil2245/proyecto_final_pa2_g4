package com.uce.edu.avanzada.budget_rent_a_car.service;

import com.uce.edu.avanzada.budget_rent_a_car.repository.IClienteRepository;
import com.uce.edu.avanzada.budget_rent_a_car.repository.model.Cliente;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteRepository iClienteRepository;

    @Override
    @Transactional(value = TxType.REQUIRED)
    public void guardar(Cliente cliente) {
        this.iClienteRepository.insertar(cliente);
    }

    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public Cliente buscarPorCedula(String cedula) {
        return this.iClienteRepository.seleccionarPorCedula(cedula);
    }

    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public List<Cliente> buscarTodos() {
        return this.iClienteRepository.seleccionarTodosClientes();
    }

}
