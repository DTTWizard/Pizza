package com.docongban.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docongban.request.SendMailAttachmentRequest;
import com.docongban.service.EmailService;

@RestController
@RequestMapping("/api/v1/mail")
public class SendMailController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/simple_mail")
	public ResponseEntity<?> sendSimpleMail() {
		emailService.sendSimpleMessage("letuanminh1892001@gmail.com", "test", "alo alo");
		return ResponseEntity.ok(null);
	}


	@PostMapping("/mail_attachment")
	public ResponseEntity<?> sendMailWithAttachment(@RequestBody SendMailAttachmentRequest request)
			throws MessagingException {
		// Convert request to Dto
		emailService.sendMailWithAttachment(request);
		return ResponseEntity.ok(1);
	}

}
