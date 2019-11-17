package com.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.cursomc.dominio.Cliente;
import com.cursomc.dominio.enums.TipoCliente;
import com.cursomc.dto.ClienteNewDTO;
import com.cursomc.repositories.ClienteRepository;
import com.cursomc.resources.exception.FieldMessage;
import com.cursomc.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		if(objDto.getTipoCliente() == TipoCliente.PESSOAFISICA && !BR.isValidCpf(objDto.getCpfCnpj()))
			list.add(new FieldMessage("cpfCnpj", "Cpf inválido!"));
		else if(objDto.getTipoCliente() == TipoCliente.PESSOAJURIDICA && !BR.isValidCnpj(objDto.getCpfCnpj()))
			list.add(new FieldMessage("cpfCnpj", "Cnpj inválido!"));
		
		Cliente cliente = clienteRepository.findByEmail(objDto.getEmail()); 
		if(cliente != null)
			list.add(new FieldMessage("email", "O email informado já existe"));;
			
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}