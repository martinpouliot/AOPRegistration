package com.sip.servlet;

import com.sip.registration.ConnexionRegistrationManager;
import jakarta.servlet.annotation.WebServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Component
@WebServlet(
        urlPatterns = {"/aor-registration"})
public class AORRegistrationTCPServlet {

    ConnexionRegistrationManager connexionRegistrationManager;
    @Value("${registration.servlet.connection.port}")
    private int PORT;
    @Value("${registration.servlet.connection.timeout}")
    private int TIMEOUT;


    public void start() {
        try {
            connexionRegistrationManager.loadAORData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("AORRegistrationTCPServlet started on port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new AORRequestHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}