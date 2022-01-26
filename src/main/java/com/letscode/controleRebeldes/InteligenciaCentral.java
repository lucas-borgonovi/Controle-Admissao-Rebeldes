package com.letscode.controleRebeldes;

import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.NoArgsConstructor;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

@NoArgsConstructor
public class InteligenciaCentral {

    private ArrayList<Rebelde> rebeldes;


    public void CadastrarRebelde(){

        rebeldes = new ArrayList<Rebelde>();

        Scanner sc = new Scanner(System.in);

        while(true){
            Rebelde rebelde = new Rebelde();

            rebelde.setNome(getNomeRebelde());

            rebelde.setIdade(getIdadeRebelde());

            rebelde.setRaca(getRacaRebelde());

            System.out.println(rebelde.getNome());
            System.out.println(rebelde.getIdade());
            System.out.println(rebelde.getRaca());

            rebeldes.add(rebelde);

            System.out.println("Rebelde cadastrado com sucesso!");
            System.out.print("Gostaria de cadastrar outro?(S/N): ");

            if(Objects.equals(sc.next().toLowerCase(Locale.ROOT), "s")){

                continue;

            }else{
                sc.close();
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

            }catch (Exception ex){
                System.out.println("Digite um valor válido");
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
                }
            }catch (Exception ex){
                System.out.println("Digite um valor válido!");
                continue;
            }

        }while(true);


    }

    public void imprimirListaRebeldes() throws FileNotFoundException, UnsupportedEncodingException {

            @Cleanup PrintWriter writer = new PrintWriter("lista-rebeldes.txt","UTF-8");

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
