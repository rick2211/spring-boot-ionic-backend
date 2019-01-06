package br.com.ricardo.springboot.services;

import br.com.ricardo.springboot.domain.model.Cliente;
import br.com.ricardo.springboot.domain.model.Pedido;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    void sendOrderConfirmationEmail(Pedido obj);

    void sendEmail(SimpleMailMessage msg);

    void sendNewPasswordEmail(Cliente cliente, String newPass);
}

