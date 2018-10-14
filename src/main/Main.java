/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import models.Model_IMC;
import views.View_IMC;
import controllers.Controller_IMC;

/**
 *
 * @author JonatanVT
 */


public class Main {
    private static View_IMC View_IMC;
    private static Model_IMC Model_IMC;
    private static Controller_IMC Controller_IMC;
    public static void main(String[] args) {
        View_IMC = new View_IMC();
        Model_IMC = new Model_IMC();
        Controller_IMC = new Controller_IMC(View_IMC, Model_IMC);
    }
    
}


