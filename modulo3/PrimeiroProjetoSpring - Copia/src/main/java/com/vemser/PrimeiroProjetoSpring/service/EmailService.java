package com.vemser.PrimeiroProjetoSpring.service;

import com.vemser.PrimeiroProjetoSpring.dto.PessoaDTO;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;
    private static final String MAIL_TO = "rafael.lazzari@dbccompany.com.br";

    @Value("${spring.mail.username}")
    private String from;
    private final JavaMailSender emailSender;

    @Autowired
    private PessoaService pessoaService;

    public void  enderecoModificadosendEmail(Integer id, String mensagem, String titulo) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaService.getPessoaById(id).getEmail());
            mimeMessageHelper.setSubject(titulo);
            mimeMessageHelper.setText(enderecoModificadoTemplate(id, mensagem), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String enderecoModificadoTemplate(Integer id, String mensagem) throws Exception {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaService.getPessoaById(id).getNome());
        dados.put("mensagem", mensagem);
        dados.put("suporteEmail", from);
        Template template = fmConfiguration.getTemplate("emailRecuperaDados-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public void pessoaSendEmail(PessoaDTO pessoaDTO, String mensagem, String titulo) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaDTO.getEmail());
            mimeMessageHelper.setSubject(titulo);
            mimeMessageHelper.setText(pessoaEmailTemplate(pessoaDTO, mensagem), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public String pessoaEmailTemplate(PessoaDTO pessoaDTO, String mensagem) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaDTO.getNome());
        dados.put("mensagem", mensagem);
        dados.put("suporteEmail", from);
        Template template = fmConfiguration.getTemplate("emailRecuperaDados-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }
}
//    public String geContentFromTemplate() throws IOException, TemplateException {
//        Map<String, Object> dados = new HashMap<>();
//        dados.put("nome", "Ana");
//
//        Template template = fmConfiguration.getTemplate("email-template.ftl");
//        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
//        return html;
//    }
//    public void sendEmail() {
//        MimeMessage mimeMessage = emailSender.createMimeMessage();
//        try {
//
//            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//
//            mimeMessageHelper.setFrom(from);
//            mimeMessageHelper.setTo(MAIL_TO);
//            mimeMessageHelper.setSubject("TESTE");
//            mimeMessageHelper.setText(geContentFromTemplate(), true);
//
//            emailSender.send(mimeMessageHelper.getMimeMessage());
//        } catch (MessagingException | IOException | TemplateException e) {
//            e.printStackTrace();
//        }
//    }
//    public void sendSimpleMessage() {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(from);
//        message.setTo(MAIL_TO);
//        message.setSubject("TESTE");
//        message.setText("Teste\n minha mensagem \n\nAtt,\nEu.");
//        emailSender.send(message);
//    }
//
//    public void sendWithAttachment() throws MessagingException {
//        MimeMessage message = emailSender.createMimeMessage();
//
//        MimeMessageHelper helper = new MimeMessageHelper(message,
//                true);
//
//        helper.setFrom(from);
//        helper.setTo(MAIL_TO);
//        helper.setSubject("TESTE");
//        helper.setText("Teste\n minha mensagem \n\nAtt,\nEu.");
//
//        File file1 = new File("imagem.jpg");
//
//        FileSystemResource file
//                = new FileSystemResource(file1);
//        helper.addAttachment(file1.getName(), file);
//
//        emailSender.send(message);
//    }
//