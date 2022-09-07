package com.revature.controllers;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ProductDAO;
import com.revature.models.Product;
import com.revature.services.ProductService;

public class JojaController extends HttpServlet{

private static ProductService productService = new ProductService(new ProductDAO());
private static ObjectMapper objmapper = new ObjectMapper();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String URI = req.getRequestURI().replace("/rest/", "");

        resp.setContentType("application/json");
        String jsonString;

        switch(URI) {
            case "Product":
            Integer id =0;
            try {
                id = Integer.parseInt(req.getParameter("id"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            Product foundProduct = productService.getProductById(id);

            jsonString = objmapper.writeValueAsString(foundProduct);

            resp.getWriter().println(jsonString);
                break;
            case "allProducts":
            // resp.getWriter().println("All Stores");

            List<Product> listOfProducts = productService.getAllProducts();

            jsonString = objmapper.writeValueAsString(listOfProducts);

                resp.getWriter().println(jsonString);
                break;
            default:
            resp.setStatus(405);
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        final String URI = req.getRequestURI().replace("/rest/", "");
        resp.setContentType("application/json");
        switch(URI){
            case "addProduct":

            String jsonString = req.getReader().lines().collect(Collectors.joining());

            Product product = objmapper.readValue(jsonString, Product.class);

            product = productService.addProduct(product);

            jsonString = objmapper.writeValueAsString(product);

            resp.getWriter().println(jsonString);

            break;
            default:
            break;
        }
    }
}
