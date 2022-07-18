package com.myexample.dsmeta.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.myexample.dsmeta.entidades.Venda;
import com.myexample.dsmeta.repositorios.VendaRepositorio;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class smsServico {

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;

	@Autowired
	private VendaRepositorio reposVenda;
	
	public void sendSms(Long vendaID) {

		Venda sale = reposVenda.findById(vendaID).get();
		String date = sale.getDate().getMonthValue()+"/"+sale.getDate().getYear();
		String valor = String.format("%.2f", sale.getAmount());
		String msgTexto = "O Vendedor " + sale.getSellerName() + " até a data de " + date + " vendeu um total de R$" + valor;
		
		
		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message message = Message.creator(to, from, msgTexto).create();

		System.out.println(message.getSid());
	}
}