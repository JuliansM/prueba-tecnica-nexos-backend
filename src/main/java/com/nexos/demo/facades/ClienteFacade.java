package com.nexos.demo.facades;

import com.nexos.demo.models.Cliente;
import com.nexos.demo.models.DetalleFactura;
import com.nexos.demo.models.Factura;
import com.nexos.demo.models.builders.ClienteFacturaBuilder;
import com.nexos.demo.models.dto.ClienteDTO;
import com.nexos.demo.models.dto.DetalleFacturaDTO;
import com.nexos.demo.models.dto.FacturaDTO;
import com.nexos.demo.services.ClienteService;
import com.nexos.demo.services.DetalleFacturaService;
import com.nexos.demo.services.FacturaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClienteFacade {

    private final ClienteService clienteService;
    private final FacturaService facturaService;
    private final DetalleFacturaService detalleFacturaService;
    private final ModelMapper modelMapper;

    public ClienteFacade(ClienteService clienteService, FacturaService facturaService,
                         DetalleFacturaService detalleFacturaService, ModelMapper modelMapper) {
        this.clienteService = clienteService;
        this.facturaService = facturaService;
        this.detalleFacturaService = detalleFacturaService;
        this.modelMapper = modelMapper;
    }

    public List<ClienteDTO> obtenerClientes() {
        return clienteService.findAll().stream()
                .map(cliente -> modelMapper.map(cliente, ClienteDTO.class))
                .collect(Collectors.toList());
    }

    public List<ClienteFacturaBuilder> obtenerClientesFactura() {
        List<ClienteFacturaBuilder> clienteFacturaBuilders = new ArrayList<>();
        List<Cliente> clientes = clienteService.findAll();

        clientes.forEach(cliente -> {
            ClienteFacturaBuilder clienteFacturaBuilder = new ClienteFacturaBuilder();

            clienteFacturaBuilder.setIdCliente(cliente.getIdCliente());
            clienteFacturaBuilder.setNombreCliente(cliente.getNombre());
            clienteFacturaBuilder.setApellido1Cliente(cliente.getApellido1());
            clienteFacturaBuilder.setApellido2Cliente(cliente.getApellido2());

            List<Factura> facturas = facturaService.findByIdCliente(cliente.getIdCliente());
            if (facturas != null) {
                clienteFacturaBuilder.setFacturaDTOS(facturas.stream()
                        .map(fac -> modelMapper.map(fac, FacturaDTO.class))
                        .collect(Collectors.toList()));
            }
            clienteFacturaBuilders.add(clienteFacturaBuilder);
        });

        clienteFacturaBuilders.forEach(clienteBuild -> clienteBuild.getFacturaDTOS().forEach(fac -> {
            List<DetalleFactura> detalleFacturas = detalleFacturaService.findByIdFactura(fac.getIdFactura());
            if (detalleFacturas != null) {
                clienteBuild.setDetalleFacturaDTOS(detalleFacturas.stream()
                        .map(det -> {
                            clienteBuild.calcularValorTotalGastado(det.getImporte());
                            return modelMapper.map(det, DetalleFacturaDTO.class);
                        })
                        .collect(Collectors.toList()));
            }
        }));
        final BigDecimal CIEN_MIL = new BigDecimal(100000);
        return clienteFacturaBuilders.stream()
                .filter(cb -> cb.getValorTotalGastado().compareTo(CIEN_MIL) == 1)
                .collect(Collectors.toList());
    }
}
