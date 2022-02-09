package com.letscode.controleRebeldes;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Objects;

public class Utils {

    public static LinkedList<Rebelde> Sort(LinkedList<Rebelde> lista,String atributo){

        Rebelde temp;


        for (int i = 0; i < lista.size(); i++) {

            int min = i;


            for (int j = i +1; j < lista.size(); j++) {

                if(atributo.equals("Nome")){

                    int nome = lista.get(j).getNome().toLowerCase(Locale.ROOT).charAt(0);

                    int nomeComparar = lista.get(min).getNome().toLowerCase(Locale.ROOT).charAt(0);

                    if( nome < nomeComparar) {
                        min = j;
                    }

                }else if(atributo.equals("Raca") ){

                    int raca = lista.get(j).getRaca().toString().charAt(0);

                    int racaComparar = lista.get(min).getRaca().toString().charAt(0);

                    if( raca < racaComparar){
                        min = j;
                    }

                }



            }
            temp = lista.get(i);

            lista.set(i, lista.get(min));

            lista.set(min, temp);


        }


        return lista;




    }

    public static LinkedList<Rebelde> Sort(LinkedList<Rebelde> lista){

        Rebelde temp;

        for (int i = 0; i < lista.size(); i++) {

            int min = i;


            for (int j = i +1; j < lista.size(); j++) {

                if(lista.get(j).getIdade() < lista.get(min).getIdade()){
                    min = j;
                }

            }
            temp = lista.get(i);

            lista.set(i, lista.get(min));

            lista.set(min, temp);


        }


        return lista;




    }


}
