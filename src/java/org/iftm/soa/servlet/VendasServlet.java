/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.soa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import org.iftm.ws.calcfrete.CResultado;
import org.iftm.ws.calcfrete.CServico;
import org.iftm.ws.calcfrete.CalcPrecoPrazoWS;

/**
 *
 * @author vhmolinar
 */
@WebServlet(name = "VendasServlet", urlPatterns = {"/VendasServlet"})
public class VendasServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/ws.correios.com.br/calculador/CalcPrecoPrazo.asmx.wsdl")
    private CalcPrecoPrazoWS service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        BigDecimal comprimento = new BigDecimal(20);
        BigDecimal altura = new BigDecimal(5);
        BigDecimal largura = new BigDecimal(10);
        BigDecimal diametro = new BigDecimal(5);
        String maoPropria = "S";
        BigDecimal vlrDeclarado = BigDecimal.ZERO;
        String avisoRecebimento = "N";

        CResultado resultado = calcPrecoPrazo("", "", 
                                              "40010", 
                                              "05311900", 
                                              "38401658", 
                                              "1", 
                                              2, 
                                              comprimento, 
                                              altura, 
                                              largura, 
                                              diametro, 
                                              maoPropria, 
                                              vlrDeclarado, 
                                              avisoRecebimento);

        List<CServico> lista = resultado.getServicos().getCServico();
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VendasServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VendasServlet at " + request.getContextPath() + "</h1>");
            out.println("<br>");
            for(CServico servico : lista){
                out.println("VALOR: " + servico.getValor());
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private CResultado calcPrecoPrazo(java.lang.String nCdEmpresa, java.lang.String sDsSenha, java.lang.String nCdServico, java.lang.String sCepOrigem, java.lang.String sCepDestino, java.lang.String nVlPeso, int nCdFormato, java.math.BigDecimal nVlComprimento, java.math.BigDecimal nVlAltura, java.math.BigDecimal nVlLargura, java.math.BigDecimal nVlDiametro, java.lang.String sCdMaoPropria, java.math.BigDecimal nVlValorDeclarado, java.lang.String sCdAvisoRecebimento) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.iftm.ws.calcfrete.CalcPrecoPrazoWSSoap port = service.getCalcPrecoPrazoWSSoap12();
        return port.calcPrecoPrazo(nCdEmpresa, sDsSenha, nCdServico, sCepOrigem, sCepDestino, nVlPeso, nCdFormato, nVlComprimento, nVlAltura, nVlLargura, nVlDiametro, sCdMaoPropria, nVlValorDeclarado, sCdAvisoRecebimento);
    }

}
