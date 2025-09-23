package lk.ijse.aad.spice_ceylon_backend.controller;


import lk.ijse.aad.spice_ceylon_backend.dto.MailDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/mail")
public class MailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping
    public String sendEmail(@RequestBody MailDetailsDTO mailDetailsDTO) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(mailDetailsDTO.getSubject());
            message.setTo(mailDetailsDTO.getToMail());
            message.setFrom("arunaagasthi@gmail.com");
            message.setText(mailDetailsDTO.getMessage());

            javaMailSender.send(message);
            System.out.println(message.toString());
            return "Success";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error while sending mail: " + e.getMessage();
        }
    }

}