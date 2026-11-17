package com.bytetech.servlet;

import com.bytetech.model.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/clientes")
public class ClienteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/clientes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String nombre = limpiar(request.getParameter("nombre"));
        String correo = limpiar(request.getParameter("correo"));
        String telefono = limpiar(request.getParameter("telefono"));
        String interes = limpiar(request.getParameter("interes"));

        if (nombre.isBlank() || correo.isBlank() || telefono.isBlank() || interes.isBlank()
                || !correo.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
            request.setAttribute("error", "Verifica los campos. Todos son obligatorios y el correo debe ser válido.");
            request.getRequestDispatcher("/clientes.jsp").forward(request, response);
            return;
        }

        Cliente cliente = new Cliente(nombre, correo, telefono, interes);
        request.setAttribute("cliente", cliente);
        request.getRequestDispatcher("/resultado.jsp").forward(request, response);
    }

    private String limpiar(String valor) {
        return valor == null ? "" : valor.trim();
    }
}
