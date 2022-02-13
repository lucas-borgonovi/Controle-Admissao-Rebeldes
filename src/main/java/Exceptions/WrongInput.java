package Exceptions;

public class WrongInput extends Exception{

    private String message;

    public WrongInput(String message){

        super(message);

    }


}
