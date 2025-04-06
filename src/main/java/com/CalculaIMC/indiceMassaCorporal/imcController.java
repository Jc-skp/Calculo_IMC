package com.CalculaIMC.indiceMassaCorporal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class imcController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/calcular")
    public String calcularIMC(@RequestParam("nome") String nome,
                              @RequestParam("peso") double peso,
                              @RequestParam("altura") double altura,
                              Model model) {
        double imc = peso / (altura * altura);

        String classificacao;
        String mensagemPositiva;

        if (imc < 18.5) {
            classificacao = "Abaixo do peso";
            mensagemPositiva = "Você pode alcançar um equilíbrio saudável!";
        } else if (imc < 24.9) {
            classificacao = "Peso normal";
            mensagemPositiva = "Parabéns! Mantenha o bom trabalho!";
        } else if (imc < 29.9) {
            classificacao = "Sobrepeso";
            mensagemPositiva = "Com dedicação, você pode melhorar ainda mais sua saúde!";
        } else {
            classificacao = "Obesidade";
            mensagemPositiva = "Nunca é tarde para cuidar de si mesmo!";
        }

        model.addAttribute("nome", nome);
        model.addAttribute("peso", peso);
        model.addAttribute("altura", altura);
        model.addAttribute("imc", imc);
        model.addAttribute("classificacao", classificacao);
        model.addAttribute("mensagemPositiva", mensagemPositiva);

        return "resultado";
    }

}
