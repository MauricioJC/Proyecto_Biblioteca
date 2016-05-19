package main;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class main {
    public static void main(String[] args){
        Calendar fecha = new GregorianCalendar();
        
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int mes = fecha.get(Calendar.MONTH);
        int año = fecha.get(Calendar.YEAR);
        int hora = fecha.get(Calendar.MINUTE);
        
        System.out.println("Fecha: "+dia +"/"+ mes +"/"+ año +" _"+hora);
        

        
        java.sql.Date sDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        System.out.println("sDate is: "+sDate.getTime());
        
        fecha.setTimeInMillis(sDate.getTime());
        System.out.println("***" + fecha.get(Calendar.DAY_OF_MONTH));
    }
}
