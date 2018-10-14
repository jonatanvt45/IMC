/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.Model_IMC;
import views.View_IMC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author JonatanVT
 */
public class Controller_IMC implements ActionListener{
    private final Model_IMC model_IMC;
    private final View_IMC view_IMC;
    
    public Controller_IMC(View_IMC View_IMC, Model_IMC Model_IMC){
        this.model_IMC = Model_IMC;
        this.view_IMC = View_IMC;
        view_IMC.jbtn_limpiar.addActionListener(this);
        view_IMC.jbtn_calcular.addActionListener(this);
        initView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==view_IMC.jbtn_calcular){
        try {
            model_IMC.setAltura(Double.parseDouble(view_IMC.jtf_altura.getText()));
            model_IMC.setPeso(Double.parseDouble(view_IMC.jtf_peso.getText()));
            
            double peso;
            double altura;
            double imc;
            peso = model_IMC.getPeso();
            altura = model_IMC.getAltura();
            
            if(peso==0 || altura==0){
                JOptionPane.showMessageDialog(view_IMC,"No puedes poner el cero ahi");
            }
            else if(peso<0 || altura<0){
                JOptionPane.showMessageDialog(view_IMC,"Upps! No puedes usar numeros negativos");
            }
            else if(altura>250){
                JOptionPane.showMessageDialog(view_IMC,"A menos que seas pie grande,\nte recomendamos usar tu altura real");
            }
            else if(altura<50){
                JOptionPane.showMessageDialog(view_IMC,"A menos que seas Chandra Bahadur Dangi,\nte recomendamos usar tu altura real");
            }
            else if(peso<25){
                JOptionPane.showMessageDialog(view_IMC,"A menos que seas Valeria Levitin,\nte recomendamos usar tu peso real");
            }
            else{
                altura=altura/100;
                imc=peso/(altura*altura);
                DecimalFormat formato = new DecimalFormat("#.00");

                switch (view_IMC.jcb_sex.getSelectedIndex()){
                    case 0:
                        JOptionPane.showMessageDialog(view_IMC,"Upps! Olvidaste especificar tu sexo");
                        break;
                    case 1:
                        if(imc<19){
                            JOptionPane.showMessageDialog(view_IMC,"Tu IMC es de: "+formato.format(imc)+"\n Esto significa que tienes desnutricion");
                        }
                        else if(imc>=19 && imc<24){
                            JOptionPane.showMessageDialog(view_IMC,"Tu IMC es de: "+formato.format(imc)+"\n Esto significa que tu peso es normal");
                        }
                        else if(imc>=24 && imc<27){
                            JOptionPane.showMessageDialog(view_IMC,"Tu IMC es de: "+formato.format(imc)+"\n Esto significa que tienes sobrepeso");
                        }
                        else if(imc>=27 && imc<32){
                            JOptionPane.showMessageDialog(view_IMC,"Tu IMC es de: "+formato.format(imc)+"\n Esto significa que tienes obesidad");
                        }
                        else if(imc>=32){
                            JOptionPane.showMessageDialog(view_IMC,"Tu IMC es de: "+formato.format(imc)+"\n Esto significa que tienes obesidad grave");
                        }
                        break;
                        case 2: // hombre
                        if(imc<20){
                            JOptionPane.showMessageDialog(view_IMC,"Tu IMC es de: "+formato.format(imc)+"\n Esto significa que tienes desnutricion");
                        }
                        else if(imc>=20 && imc<24){
                            JOptionPane.showMessageDialog(view_IMC,"Tu IMC es de: "+formato.format(imc)+"\n Esto significa que tu peso es normal");
                        }
                        else if(imc>=24 && imc<30){
                            JOptionPane.showMessageDialog(view_IMC,"Tu IMC es de: "+formato.format(imc)+"\n Esto significa que tienes sobrepeso");
                        }
                        else if(imc>=30 && imc<40){
                            JOptionPane.showMessageDialog(view_IMC,"Tu IMC es de: "+formato.format(imc)+"\n Esto significa que tienes obesidad");
                        }
                        else if(imc>=40){
                            JOptionPane.showMessageDialog(view_IMC,"Tu IMC es de: "+formato.format(imc)+"\n Esto significa que tienes obesidad grave");
                        }
                        break;
                }
            }
        }
        catch (Exception x){
            JOptionPane.showMessageDialog(view_IMC, "Upps! No puedo dejar que escribas eso ahi");
        }
      }
        else if(e.getSource()==view_IMC.jbtn_limpiar){
            view_IMC.jtf_altura.setText(null);
            view_IMC.jtf_peso.setText(null);
            view_IMC.jcb_sex.setSelectedIndex(0);
        }
    }
    private void initView() {
        view_IMC.setTitle("Calculadora de IMC");
        view_IMC.setLocationRelativeTo(null);
        view_IMC.setVisible(true);
    }
    
}

    

