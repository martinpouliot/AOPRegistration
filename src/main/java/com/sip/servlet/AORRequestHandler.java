package com.sip.servlet;

import com.sip.registration.ConnexionRegistrationManager;

import java.io.*;
import java.net.Socket;

public class AORRequestHandler implements Runnable {
    private Socket clientSocket;
    ConnexionRegistrationManager connexionRegistrationManager;

    public AORRequestHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new java.io.InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            String line;
            while ((line = in.readLine()) != null) {
                String response = connexionRegistrationManager.retrieveAOPConnection(line);
                out.println(response);
            }
        } catch (IOException e) {
            System.err.println("AORRegistrationTCPServlet: Failed to handle client request: " + e.getMessage());
        }
    }
}