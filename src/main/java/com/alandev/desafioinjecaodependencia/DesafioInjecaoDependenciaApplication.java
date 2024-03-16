package com.alandev.desafioinjecaodependencia;

import com.alandev.desafioinjecaodependencia.entities.Order;
import com.alandev.desafioinjecaodependencia.service.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DesafioInjecaoDependenciaApplication implements CommandLineRunner {

    private OrderService service;

    public DesafioInjecaoDependenciaApplication(OrderService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(DesafioInjecaoDependenciaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);

        System.out.print("Informe o código do produto: ");
        Integer codigo = in.nextInt();

        System.out.print("Informe o valor básico: ");
        Double valorBasico = in.nextDouble();

        System.out.print("Informe a porcentagem de desconto: ");
        Double porcentagemDesconto = in.nextDouble();

        Order order = new Order(codigo, valorBasico, porcentagemDesconto);
        Double valorTotal = service.total(order);

        System.out.printf("Pedido código %d%n", order.getCode());
        System.out.printf("Valor total R$%.2f%n", valorTotal);

    }
}
