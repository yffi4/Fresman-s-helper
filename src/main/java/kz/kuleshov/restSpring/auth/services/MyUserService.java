package kz.kuleshov.restSpring.auth.services;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import kz.kuleshov.restSpring.auth.Users;
import kz.kuleshov.restSpring.auth.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MyUserService implements UserDetailsService {
    @Autowired
    private UsersRepository userRepository;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findAllByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("username not found");
        }
        return user;
    }
    public Users getUserByEmail(String username) throws UsernameNotFoundException {
        Users user = userRepository.findAllByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("username not found");
        }
        return user;
    }
    public void updateUser(Users updUser) {
        userRepository.save(updUser);
    }

    public void registerUser(Users user){
        Users checkUser = userRepository.findAllByEmail(user.getEmail());
        if(checkUser == null){
            if(user.getStatus() == null){
                user.setStatus("non-activate");
                String fullCode = UUID.randomUUID().toString();
                String code = fullCode.substring(0,5);
                user.setCode(code);
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                userRepository.save(user);
                sendVerificationEmail(user.getEmail(), code,user.getFullName());
            }
        }
    }
    private void sendVerificationEmail(String to, String code,String fullName) {
        String subject = "Your Promocode";
        String text = "Dear " + fullName + "  Thank you for registration. For activate your email account click to link : " + "http://localhost:7070/auth/verify?email=" + to + "&" + "code=" + code;

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);

            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
