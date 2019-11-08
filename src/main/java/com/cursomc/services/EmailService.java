package com.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.cursomc.dominio.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido pedido);
	
	void sendEmail(SimpleMailMessage msg);
}
