
package calculadoradolares;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class cCalculadoraDolares implements ActionListener{
    
   
    private JFrame main;
    private JButton[] numeros = new JButton[10];
    private JButton ce, igual, punto;
    private JTextField txt;
    
    
    public void isVisible(boolean b){
        
        //Crea el JFrame y le añade las dimensiones
        main = new JFrame();
        main.setTitle("Examen");
        main.setBounds(200,200,200,290);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.getContentPane().setLayout(null);
        main.setResizable(false);
        main.setVisible(b);
        
        //Crea el campo de texto
        txt = new JTextField();
        txt.setBounds(0,0,400,50);
        txt.setVisible(true);
        
        //Validacion para numeros
        txt.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent k){
                char c= k.getKeyChar();
                if(!Character.isDigit(c)){
                    txt.getToolkit().beep();
                    k.consume();
                    txt.setCursor(null);
                }
            }
        });
        
        main.add(txt);
        
        //Declarar botones
        
        for(int i=0; i<numeros.length;i++){
            numeros[i] = new JButton(""+i);
            numeros[i].setBounds(50*i,50,50,50);
           
            if(i>=3 && i<6){
                numeros[i].setBounds(50*(i-3),100,50,50);
            }
            
          
            if(i>=6 && i<10){
             numeros[i].setBounds(50*(i-6),150,50,50);   
            }
            
          
            if(i==9){
                numeros[i].setBounds(50,200,50,50);
            }
            
           
            numeros[i].setVisible(true);
            numeros[i].addActionListener(this);
            main.add(numeros[i]);
        }
        
        
        igual = new JButton("=");
        igual.setBounds(150,50,50,50);
        igual.addActionListener(this);
        main.add(igual);
        
        ce = new JButton("CE");
        ce.setBounds(150,100,50,50);
        ce.addActionListener(this);
        main.add(ce);
        
        punto = new JButton(".");
        punto.setBounds(150,150,50,50);
        punto.addActionListener(this);
        main.add(punto);
        
        
    }
    
  

    @Override
    public void actionPerformed(ActionEvent e) {
        double res = 0;
        
        //Limpia la caja de tecto 
        if(e.getSource()==ce){
            txt.setText("");
        }
        
       
        if(e.getSource()==punto){
            
            //Valida que no se coloquen otros puntos
            if(txt.getText().toString().contains(".")){
                
            }else{
                txt.setText(txt.getText().toString()+".");
            }
        }
        
        //Ejecuta la operacion igual
        if(e.getSource()==igual){
            
            //Valida que la caja de texto no este vacia 
            if(!txt.getText().toString().equals("")){
                res=Double.parseDouble(txt.getText().toString());
                res =res/17;
                txt.setText(res+"");
            }
            
        }
        
      
        for(int i=0;i<numeros.length;i++){
            if(e.getSource()==numeros[i]){
                txt.setText(txt.getText().toString()+i);
            }
        }
        
        
    }
    
}
