/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamento;

import java.time.LocalDate;
import java.util.List;
import modelo.*;

/**
 *
 * @author Carrara
 */
public class Sessao {

    private Cliente client;
    private CarrinhoDeCompra kart;
    private Compra compraAtual;
    private GerenciarCliente gerenteCliente;
    private GerenciarEventos gerenteEvento;
    private boolean logado = false;

    public Sessao() {
        this.kart = new CarrinhoDeCompra();
        this.compraAtual = new Compra();
        this.gerenteCliente = new GerenciarCliente();
        this.gerenteEvento = new GerenciarEventos();
    }

    public Sessao(GerenciarCliente gc, GerenciarEventos ge) {
        this.kart = new CarrinhoDeCompra();
        this.compraAtual = new Compra();
        this.gerenteCliente = gc;
        this.gerenteEvento = ge;
    }

    public boolean isLogado() {
        return logado;
    }

    public boolean fazerLogin(String usuario, String senha) {
        this.client = gerenteCliente.getUsuario(usuario);
        if (this.client != null && client.getSenha().equals(senha)) {
            logado = true;
        }
        return logado;
    }

    public void exibirHistorico() {
        if (logado) {
            List<Compra> compras = client.getHistorico().getHistoricoDeCompras();
            for (Compra c : compras) {
                System.out.println(c.toString());
            }
        } else {
            System.out.println("Por favor faça o seu login.");
        }
    }

    public void exibirCatalogo() {
        if (logado) {
            List<Evento> eventos = gerenteEvento.gerarCatalogo();
            System.out.println("Eventos disponíveis:");
            for (Evento e : eventos) {
                e.toString();
                System.out.println("");
            }
        } else {
            System.out.println("Por favor faça o seu login.");
        }

    }

    public boolean adcionarNoCarrinho(int eventoID, int qtd) {
        if (qtd < 1 || qtd > 4) {
            return false;
        }
        for (int i = 0; i < qtd; i++) {            
            kart.adicionar(gerenteEvento.getIngresso(eventoID));
        }
        return true;
    }

    public void finalizarCompra() {
        compraAtual.setCarrinho(kart);
        compraAtual.setDataDaCompra(LocalDate.now().toString());
        compraAtual.setId((int) (Math.random() * 1000));

    }

    public void efetuarPagamento() {
        client.getHistorico().adiciona(compraAtual);
        compraAtual = new Compra();
        kart = new CarrinhoDeCompra();
    }
}
