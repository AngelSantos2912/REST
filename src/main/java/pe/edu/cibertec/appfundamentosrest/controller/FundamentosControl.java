package pe.edu.cibertec.appfundamentosrest.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.appfundamentosrest.services.FundamentosServices;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/fundamentos")
public class FundamentosControl {


    private final FundamentosServices fundamentosServices;



//===================================================================//

    @GetMapping("/ejercicio1")
    public ResponseEntity<String> ejercicio1(){
        return new ResponseEntity<>("Hola Mundo Rest", HttpStatus.OK);
    }


    //===================================================================//


    @GetMapping("/primo")
    public ResponseEntity<String> ValidarNumeroPrimo(
        @RequestParam int numero){
        return new ResponseEntity<>(fundamentosServices.validarNumeroPrimo(numero),HttpStatus.OK);
    }

    //===================================================================//

    @GetMapping("/fibonacci/{numero}")
    public ResponseEntity<List<Integer>> CalcularFibonacci(@PathVariable int numero){
        return new ResponseEntity<>(fundamentosServices.CalcularFibonacci(numero), HttpStatus.OK);
    }

    //===================================================================//
    @GetMapping("/factorial")
    public ResponseEntity<String> ValidarNumeroFactorial(@RequestParam("numero") int numero){
        return new ResponseEntity<>(fundamentosServices.CalcularFactorial(numero),HttpStatus.OK);
    }

    //===================================================================//

    @GetMapping("/suma/{numero1}")
    public ResponseEntity<String> suma(@PathVariable int numero1, @PathVariable int numero2){
        return new ResponseEntity<>(String.valueOf(numero1 + numero2),HttpStatus.OK);
    }

    //===================================================================//

    @GetMapping({"/hola", "/hola/{nombre}"})
    public ResponseEntity<String> hola(@PathVariable(required = false) String nombre){
        if(nombre == null){
            return new ResponseEntity<>("Hola Mundo Rest", HttpStatus.OK);
        }
        return new ResponseEntity<>("Hola " + nombre, HttpStatus.OK);
    }

    //===================================================================//

    @GetMapping("/potencia")
    public ResponseEntity<String> potencia
            (@RequestParam(required = false, defaultValue = "2") int numero, @RequestParam(required = false, defaultValue = "2") int exponente){
        double valorPotencia = Math.pow(numero, exponente);
        return new ResponseEntity<>("El resultado es " +  valorPotencia, HttpStatus.OK);
    }

    //===================================================================//

    @GetMapping({"/generar", "/generar/{inicio}"})
    public ResponseEntity<List<Integer>> generar
            (@PathVariable(required = false) Integer inicio, @RequestParam(required = false, defaultValue = "10") Integer fin){
        if(inicio == null){
            inicio = 1;
        }
        List<Integer> rango = new ArrayList<Integer>();
        for(int i = inicio; i <= fin; i++){
            rango.add(i);
        }
        return new ResponseEntity<>(rango, HttpStatus.OK);
    }

    //===================================================================//

}


