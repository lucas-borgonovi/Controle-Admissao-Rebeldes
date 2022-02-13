package com.letscode.controleRebeldes;

import Exceptions.WrongInput;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.NoArgsConstructor;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class InteligenciaCentral {

    private static final Logger LOGGER = LogManager.getLogger(InteligenciaCentral.class);

    private LinkedList<Rebelde> rebeldes;

    public InteligenciaCentral() {
        rebeldes = new LinkedList<Rebelde>();
    }

    public void CadastrarRebelde(){

        //rebeldes = new LinkedList<Rebelde>();

        Scanner sc = new Scanner(System.in);

        while(true){
            //Rebelde rebelde = new Rebelde();

            Rebelde rebelde =Rebelde.builder()
                            .Nome(getNomeRebelde())
                            .Idade(getIdadeRebelde())
                            .Raca(getRacaRebelde())
                            .build();

//            rebelde.setNome(getNomeRebelde());
//
//            rebelde.setIdade(getIdadeRebelde());
//
//            rebelde.setRaca(getRacaRebelde());

            System.out.println(rebelde.getNome());
            System.out.println(rebelde.getIdade());
            System.out.println(rebelde.getRaca());

//            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//            Validator validator = factory.getValidator();
//
//            Set<ConstraintViolation<Rebelde>> constraintViolations = validator.validate(rebelde);
//
//            constraintViolations.forEach(x -> LOGGER.error("O  atributo : " + x.getPropertyPath() + "-" + x.getMessage()));

            rebeldes.add(rebelde);

            System.out.println("Rebelde cadastrado com sucesso!");
            System.out.print("Gostaria de cadastrar outro?(S/N): ");

            if(Objects.equals(sc.next().toLowerCase(Locale.ROOT), "s")){

                continue;

            }else{
                //sc.close();
                break;
            }

        }



    }

    private String getNomeRebelde(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Seu Nome: ");

        String nome = sc.next();

        return nome;

    }

    private int getIdadeRebelde(){

        do{
            Scanner sc = new Scanner(System.in);

            System.out.println("Sua idade: ");

            try{
                int idade = Integer.parseInt(sc.next());

                return idade;

            }catch(Exception ex){
                LOGGER.error(new WrongInput("O valor digitado é inválido. Por favor, digite um número."));
                //System.out.println("Digite um valor válido");
                continue;
            }
        }while(true);

    }

    private Raca getRacaRebelde(){

        do{

            Scanner sc = new Scanner(System.in);

            System.out.println("Sua Raça: ");
            System.out.println("0- Humano");
            System.out.println("1- Gree");
            System.out.println("2- Rakata");

            try{
                int racaNumber = Integer.parseInt(sc.next());

                if(racaNumber>=0 && racaNumber <= 2){
                    switch (racaNumber) {
                        case 0:
                            return Raca.HUMANO;
                        case 1:
                            return Raca.GREE;
                        case 2:
                            return Raca.RAKATA;
                        default:
                            break;
                    }
                }else{
                    LOGGER.error("O valor deve estar no intervalo entre 0 e 2...");
                }
            }catch (Exception ex){
                LOGGER.error(new WrongInput("Não há raça correspondente a esse número. Por favor, digite um número válido."));
                System.out.println("Digite um valor válido!");
                continue;
            }

        }while(true);


    }

    private LinkedList<Rebelde> perguntaOrdenacao(){

        Scanner sc = new Scanner(System.in);

        do{


            System.out.println("Deseja ordenar por qual atributo?");
            System.out.println("0- Nome");
            System.out.println("1- Idade");
            System.out.println("2- Raça");

            try{
                int resposta = Integer.parseInt(sc.next());


                if(resposta >= 0 && resposta <= 2){

                    switch (resposta) {
                        case 0:
                            return Utils.Sort(rebeldes,"Nome");
                        case 1:
                            return Utils.Sort(rebeldes);
                        case 2:
                            return Utils.Sort(rebeldes,"Raca");
                        default:
                            break;
                    }

                    sc.close();

                }else{
                    LOGGER.error("O valor deve estar no intervalo entre 0 e 2...");
                }


            }catch (Exception ex){
                LOGGER.error(new WrongInput("Não há ordenação para o valor inserido. Por favor, digite um valor válido."));
                //System.out.println("Digite um valor válido!");
                continue;
            }




        }while(true);



    }

    public void imprimirListaRebeldes() throws FileNotFoundException, UnsupportedEncodingException {

            @Cleanup PrintWriter writer = new PrintWriter("lista-rebeldes.txt","UTF-8");

            rebeldes = perguntaOrdenacao();


            writer.println("Lista de Rebeldes");

            for (int i = 0; i < rebeldes.size(); i++) {

                writer.println("Rebelde: "+ i);
                writer.println("Nome: "+ rebeldes.get(i).getNome());
                writer.println("Idade: "+ rebeldes.get(i).getIdade());
                writer.println("Raça: "+ rebeldes.get(i).getRaca());
                writer.println("-----------------------------------");

            }




    }



}
