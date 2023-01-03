
package UI;

import javax.swing.*;


public class Calcular {

    double voltaje, intensidad, resistencia, capacitancia, carga, voltaje1, CT;
    double w, xl, xc,IR, IL, IC, IT, angulo, Z, angulo1, I, VR, VL, VC;
    
    public Calcular() {
    }
    
    public void voltaje(double i, double r){
        voltaje = i*r;
    }//fin funcion voltaje
    
    public void intensidad(double v, double r){
        if(r != 0){
            intensidad= v/r;
        } else{
            JOptionPane.showMessageDialog(null, "El valor de la resistencia debe ser diferente de cero, "
                    + "intenta nuevamente (Sintax ERROR)", "Fisix dice: Existe un error",JOptionPane.ERROR_MESSAGE);
        }
    }//fin intensidad
    
    public void resistencia(double v, double i){
        if(i != 0){
            resistencia= v/i;
        } else{
            JOptionPane.showMessageDialog(null, "El valor de la intensidad debe ser diferente de cero, "
                    + "intenta nuevamente (Sintax ERROR)", "Fisix dice: Existe un error",JOptionPane.ERROR_MESSAGE);
        }
    }//fin resistencia
    
    //------------CALCULOS DE CAPACITANCIA----------------------
    
    public void capacitancia(double q, double v){
        if(v != 0){
            capacitancia= q/v;
        }else{
            JOptionPane.showMessageDialog(null, "El valor del voltaje debe ser diferente de cero, "
                    + "intenta nuevamente (Sintax ERROR)", "Fisix dice: Existe un error",JOptionPane.ERROR_MESSAGE);
        }
    }//fin capacitancia
    
    public void carga(double c, double v){
        carga=c*v;
    }//fin carga
    
    public void voltaje1(double c, double q){
        if(c != 0){
            voltaje1=q/c;
        }else{
            JOptionPane.showMessageDialog(null, "El valor de la capacitancia debe ser diferente de cero, "
                    + "intenta nuevamente (Sintax ERROR)", "Fisix dice: Existe un error",JOptionPane.ERROR_MESSAGE);
        }
    }//fin calculo de voltaje
    
 
    
    //-------------------CALCULOS RLC---------------------------------
    
    public void w (double f){
        w= 2*Math.PI*f; 
    }
    
    public void xl (double l){
        double num = w*l;
        xl= (num/(double)(1000));
    }
    
    public void xc (double c){
        double num=w*c; 
        xc= ((double)(1)/num)*1000000;
    }
    
    public void IR (double v, double r){
         if(r != 0){
            IR = v/r;
        }else{
            JOptionPane.showMessageDialog(null, "El valor de la resistencia debe ser diferente de cero, "
                    + "intenta nuevamente (Sintax ERROR)", "Fisix dice: Existe un error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void IL (double v){
        if(xl != 0){
            IL = ((double)(v)/xl);
        }else{
            JOptionPane.showMessageDialog(null, "El valor de la resistencia inductiva debe ser diferente de cero, "
                    + "intenta nuevamente (Sintax ERROR)", "Fisix dice: Existe un error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void IC (double v){
        if(xc != 0){
            IC = ((double)(v)/xc);
        }else{
            JOptionPane.showMessageDialog(null, "El valor de la resistencia capacitiva debe ser diferente de cero, "
                    + "intenta nuevamente (Sintax ERROR)", "Fisix dice: Existe un error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void IT (double v, double r){
        IL = ((double)(v)/xl);
        IC = ((double)(v)/xc);
        IR = v/r;
        
        double aux0;
        double aux1;
        double aux2;
        
        aux0= IL-IC; 
        aux2= Math.sqrt(Math.pow(IR, 2)+ Math.pow(aux0, 2));//(double)(Math.pow(IR, 2) + Math.pow(aux0, 2));
        IT= aux2;//Math.sqrt(Math.pow(I, 2) + Math.pow(aux0, 2));
        
        angulo=Math.atan2(aux0, IR);
        
    }
    
    public void Z(double R){
        double x;
        double aux;
        
        x= xl-xc;
        aux= Math.pow(R, 2) + Math.pow(x, 2);
        Z= Math.sqrt(aux);
        
        angulo1=Math.atan2(x, R);
    }
    
    public void I (double v){
        I=(double)(v/Z);
    }
    
    public void VR (double r){
         VR=r*I;
    }
    
    public void VL (double v){
       VL=xl*I; 
    }
    
    public void VC (double v){
       VC=xc*I;
    }
}
