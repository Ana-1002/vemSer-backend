package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static java.time.format.DateTimeFormatter.ofPattern;

@Service
@RequiredArgsConstructor
public class EmailService {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaService pessoaService;

    private final freemarker.template.Configuration fmConfiguration;

    private static final String MAIL_TO = "rafael.lazzari@dbccompany.com.br";

    @Value("${spring.mail.username}")
    private String from;
    private final JavaMailSender emailSender;

    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(MAIL_TO);
        message.setSubject("TESTE");
        message.setText("Teste\n minha mensagem \n\nAtt,\nEu.");
        emailSender.send(message);
    }

    public void sendWithAttachment() throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message,
                true);

        helper.setFrom(from);
        helper.setTo(MAIL_TO);
        helper.setSubject("TESTE");
        helper.setText("Teste\n minha mensagem \n\nAtt,\nEu.");

        File file1 = new File("imagem.jpg");

        FileSystemResource file
                = new FileSystemResource(file1);
        helper.addAttachment(file1.getName(), file);

        emailSender.send(message);
    }
    @Scheduled(cron = "@monthly")
    public void sendEmailPromocoes() {
        String templateName = "email-template-pessoa.ftl";
        Integer enviar= 0;
        for (Pessoa lista : pessoaRepository.list()){
            sendEmail(lista, templateName);
        }

    }
    @Scheduled(cron = "@daily")
    public void sendEmailAniversario() {
        String templateName = "email-template-aniversario.ftl";

        for (Pessoa lista : pessoaRepository.list()){
            System.out.println();
            if(pessoaService.aniversario(lista.getDataNascimento())){
                System.out.println("Entrou");
            sendEmail(lista, templateName);}
        }

    }
    @Scheduled(cron = "0 0 8,20 * * *")
    public void sendEmailEndereco() {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        String templateName = "email-template-atualiza-endereco.ftl";
        Integer enviar= 0;
        for (Pessoa lista : pessoaRepository.list()){
            for (Endereco listaE : enderecoRepository.list()){
                if(listaE.getIdPessoa()== lista.getIdPessoa()){
                    enviar++;
                }
            }
            if(enviar==0){
              sendEmail(lista, templateName);
            } else {enviar=0;}
        }

    }

    public void sendEmail(Pessoa lista, String templateName) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(lista.getEmail());
            mimeMessageHelper.setText(geContentFromTemplate(lista, templateName), true);
            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }

    }
    public String geContentFromTemplate(Pessoa pessoa, String templateName) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoa.getNome());
        dados.put("dataNascimento", pessoa.getDataNascimento().format(ofPattern("dd/MM")));
        dados.put("idade", pessoaService.idade(pessoa.getDataNascimento()));
        fmConfiguration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        Template template = fmConfiguration.getTemplate(templateName);
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }
}
