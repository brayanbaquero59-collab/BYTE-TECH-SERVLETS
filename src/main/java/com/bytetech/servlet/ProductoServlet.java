package com.bytetech.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/productos")
public class ProductoServlet extends HttpServlet {
    public record Producto(String nombre, String categoria, String descripcion, String precio) {}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Producto> productos = List.of(
            new Producto("Byte Gamer X", "Computador gamer", "Equipo para videojuegos y alto rendimiento.", "$4.299.000 COP"),
            new Producto("Byte Work Pro", "Computador de escritorio", "Equipo para estudio, oficina y productividad.", "$2.850.000 COP"),
            new Producto("ByteBook Air", "Portátil", "Portátil liviano para trabajar y estudiar.", "$3.199.000 COP"),
            new Producto("Kit periféricos RGB", "Accesorios", "Teclado, mouse y audífonos para tu espacio.", "$389.000 COP")
        );
        String busqueda = request.getParameter("buscar");
        if (busqueda != null && !busqueda.isBlank()) {
            String filtro = busqueda.toLowerCase();
            productos = productos.stream().filter(p -> p.nombre().toLowerCase().contains(filtro)
                    || p.categoria().toLowerCase().contains(filtro)).toList();
        }
        request.setAttribute("productos", productos);
        request.setAttribute("busqueda", busqueda == null ? "" : busqueda);
        request.getRequestDispatcher("/productos.jsp").forward(request, response);
    }
}
