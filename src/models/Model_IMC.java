/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author JonatanVT
 */
public class Model_IMC {
    
    private double Peso;
    private double Altura;
    private int Sexo;

    public int getSexo() {
        return Sexo;
    }

    public void setSexo(int Sexo) {
        this.Sexo = Sexo;
    }
        
    public double getPeso() {
        System.out.println("getPeso");
        return Peso;
    }

    public void setPeso(double Peso) {
        System.out.println("setPeso");
        this.Peso = Peso;
    }

    public double getAltura() {
        System.out.println("getAltura");
        return Altura;
    }

    public void setAltura(double Altura) {
        System.out.println("setAltura");
        this.Altura = Altura;
    }    
}

