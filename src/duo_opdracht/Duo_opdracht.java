package duo_opdracht;

//Hier worden alle benodigde functionaliteiten geimporteerd vanuit de bibliotheek
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Duo_opdracht extends JFrame {
    public static void main(String[] args) throws SQLException {
        
        //De verbinding met de SQL data
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/DUO_1", "root", "");
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("SELECT * FROM band_artiest;");
    

        while (resultset.next()) {
                int Sleutel = resultset.getInt("Sleutel");
                String Naam = resultset.getString("Naam");
                String Starttijd = resultset.getString("Beschrijving");

        }
            //Hier worden 2 frames gemaakt, er wordt in deze uitwerking maar gewerkt met 1.
    JFrame frame1 = new Duo_opdracht();
    frame1.setSize( 500, 500 );
    frame1.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame1.setTitle( "DUO Opdracht" );
    frame1.setContentPane( new Paneel() );
    frame1.setVisible( true );
    
    JFrame frame2 = new Duo_opdracht();
    frame2.setSize( 500, 500 );
    frame2.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame2.setTitle( "DUO Opdracht" );
    frame2.setContentPane( new Paneel() );
    frame2.setVisible( false );


    }        
}
 //Dit is het paneel dat op het eerste frame staat. In de class geeft ik de naam en het type aan.
class Paneel extends JPanel{
    
       private JLabel schemaLabel;
       private JLabel naamLabel;
       private JLabel beschrijvingLabel;
       private JLabel sleutelLabel;
       private JLabel bandToevoegen;
       private JLabel optredenToevoegen;
       private JLabel podiumLabel;
       private JLabel starttijdLabel;
       private JLabel eindtijdLabel;
       private JLabel bandLabel;
       private JLabel sleutelOptreden;
       
       private String result;
       
       private JButton openInvoer;
       private JButton optredenInvoer;
       
       private JTextField beschrijvingInvoer;
       private JTextField naamInvoer;
       private JTextField sleutelInvoer;
       private JTextField podiumInvoer;
       private JTextField starttijdInvoer;
       private JTextField eindtijdInvoer;
       private JTextField bandartiestInvoer;
       private JTextField sleuteloptredenInvoer;
       
        //Dit is de contstructor hier worden de objecten aangemaakt. 
        public Paneel() {
        
        setLayout (null);
        setBackground( Color.WHITE );    
            
        schemaLabel = new JLabel();
        schemaLabel.setBounds(150,0,80,40);
        schemaLabel.setText("Schema");
        
        bandToevoegen = new JLabel();
        bandToevoegen.setBounds(180,160,150,40);
        bandToevoegen.setText("Band/artiest toevoegen");
        
        
        
        openInvoer= new JButton("Band invoer");
        openInvoer.addActionListener(new invoerKnopHandler());
        openInvoer.setBounds (300,260,140,20);
        
        optredenInvoer= new JButton("Optreden invoer");
        optredenInvoer.addActionListener(new optredenKnopHandler());
        optredenInvoer.setBounds (300,420,140,20);
        
        naamInvoer = new JTextField(10);
        naamInvoer.setBounds (200,200,100,20);
        
        beschrijvingInvoer = new JTextField(10);
        beschrijvingInvoer.setBounds(200,230,100,20);
        
        sleutelInvoer = new JTextField (10);
        sleutelInvoer.setBounds(200,260,100,20);
        
        podiumInvoer = new JTextField(10);
        podiumInvoer.setBounds(200,320,100,20);
        
        eindtijdInvoer = new JTextField(10);
        eindtijdInvoer.setBounds(200,370,100,20);
        
        starttijdInvoer = new JTextField(10);
        starttijdInvoer.setBounds(200,350,100,20);
        
        bandartiestInvoer = new JTextField(10);
        bandartiestInvoer.setBounds(200,400,100,20);
        
        sleuteloptredenInvoer = new JTextField(10);
        sleuteloptredenInvoer.setBounds (200,430,100,20);
        
        naamLabel = new JLabel();
        naamLabel.setBounds(100,190,100,40);
        naamLabel.setText("Naam band");
        naamLabel.setForeground(Color.gray);
        
        beschrijvingLabel = new JLabel();
        beschrijvingLabel.setBounds (100,220,100,40) ;
        beschrijvingLabel.setText("Beschrijving");
        beschrijvingLabel.setForeground(Color.gray);
        
        sleutelLabel = new JLabel();
        sleutelLabel.setBounds (100,250,100,40) ;
        sleutelLabel.setText("Sleutel");
        sleutelLabel.setForeground(Color.gray);
        
        podiumLabel = new JLabel();
        podiumLabel.setBounds(100,310,100,40);
        podiumLabel.setText("Podium");
        podiumLabel.setForeground(Color.gray);
        
        starttijdLabel = new JLabel ();
        starttijdLabel.setBounds(100,340,100,40);
        starttijdLabel.setText("Starttijd/");
        starttijdLabel.setForeground(Color.gray);
        
        eindtijdLabel = new JLabel ();
        eindtijdLabel.setBounds(100,360,100,40);
        eindtijdLabel.setText("Eindtijd");
        eindtijdLabel.setForeground(Color.gray);
        
        bandLabel = new JLabel();
        bandLabel.setBounds (100,390,120,40);
        bandLabel.setText("Band Artiest");
        bandLabel.setForeground(Color.gray);
        
        sleutelOptreden = new JLabel();
        sleutelOptreden.setBounds (100,420,120,40);
        sleutelOptreden.setText("Sleutel");
        sleutelOptreden.setForeground(Color.gray);
        
        optredenToevoegen = new JLabel();
        optredenToevoegen.setBounds (180,280,120,40);
        optredenToevoegen.setText("Optreden toevoegen");
        

       
            
         //Hier worden de attributen doormidel van de "add" op het paneel gezet.    
            add(openInvoer);
            add(optredenInvoer);
            add(naamInvoer);
            add(podiumInvoer);
            add(sleutelInvoer);
            add(beschrijvingInvoer);
            add(starttijdInvoer);
            add(eindtijdInvoer);
            add(bandartiestInvoer);
            add(sleuteloptredenInvoer);      
            add(starttijdLabel);
            add(eindtijdLabel);
            add(naamLabel);
            add(podiumLabel);
            add(bandToevoegen);
            add(optredenToevoegen);
            add(schemaLabel);
            add(beschrijvingLabel);
            add(sleutelLabel);
            add (sleutelOptreden);
            add(bandLabel);
            
           
        }
        
        //Dit is de KnopHandler die aagemaakt wordt op regel:99. Hier wordt er functionaliteit toegevoegd aan deze knop.
        class invoerKnopHandler implements ActionListener{
            public void actionPerformed (ActionEvent e){
                //Er moet weer opnieuw verbinding gemaakt worden met de database. 
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/DUO_1", "root", "");
                    Statement statement = connection.createStatement();
                    
                    //De tekst die ingevoerd is op JTextFields wordt doormiddel van de .getText uit het vakje gehaald en gebruikt voor de statement 
                    String x = naamInvoer.getText();
                    String y = beschrijvingInvoer.getText();
                    String z = sleutelInvoer.getText();
                    
                    //De 3 values uit de tabel van de datbase worden gevuld doormiddel van Strings x,y,z.
                    statement.executeUpdate("INSERT INTO band_artiest VALUES('"+z+"', '"+x+"', '"+y+"');");
                    
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Paneel.class.getName()).log(Level.SEVERE, null, ex);
                }
      

            }
        }
        //Dit is in principe de zelfde soort knop als de vorige enkel vult deze een andere tabel, deze vult optreden en de vorige band_artiest. 
          class optredenKnopHandler implements ActionListener{
            public void actionPerformed (ActionEvent e){
             try {
                   
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/DUO_1", "root", "");
                    Statement statement = connection.createStatement();
                    
                    String q = podiumInvoer.getText();
                    String w = eindtijdInvoer.getText();
                    String c = starttijdInvoer.getText();
                    String b = bandartiestInvoer.getText();
                    String sl = sleuteloptredenInvoer.getText();
                    
                    
                    
                    statement.executeUpdate("INSERT INTO optreden VALUES('"+sl+"',  '"+q+"', '"+c+"', '"+w+"','"+b+"'  );");
                    
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Paneel.class.getName()).log(Level.SEVERE, null, ex);
                }
      

            }
        }
          /**
           *Doormiddel van de paintcomponent kan er op paneel geschreven of getekend worden, 
           * deze wordt nu gebruikt om de gegevens van de database op het paneel te laten zien.
           */ 
         
         public void paintComponent( Graphics g ) {
           try {
               //Om de gegevens te laten zien moet er verbinding gemaakt worden, in dit gedeelte wordt enkel de tabel optreden opgevraagd.
               super.paintComponents(g );
               Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/DUO_1", "root", "");
               Statement statement = connection.createStatement();
               ResultSet resultset = statement.executeQuery("SELECT * FROM optreden ");
               
               //De for loop is nodig om de gegevens onder elkaar te krijgen, wanneer je dit niet doet zullen alle gegevens over elkaar weergeven worden.
               for (int i = 0; resultset.next();i++) {
                   
                   String Podium = resultset.getString("Podium");
                   String Starttijd = resultset.getString("Starttijd");
                   String Eindtijd = resultset.getString("Eindtijd");
                   
                   // Door er 20*i achter te zetten maak je de stap 20pixels, in dit geval een regelruimte van 20pixels onder elkaar. 
                   g.drawString(Podium,30,50+20*i);
                   g.drawString (Starttijd,100,50+20*i);
                   g.drawString(Eindtijd,160,50+20*i);
                   g.drawRect(20, 30, 340, 142);
                   
                
                   
                                     
               }  } catch (SQLException ex) {
               
                   Logger.getLogger(Duo_opdracht.class.getName()).log(Level.SEVERE, null, ex);
                  
           
           
       
    

     
      }
           try {
               super.paintComponents(g );
               Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/DUO_1", "root", "");
               Statement statement = connection.createStatement();
               ResultSet resultset = statement.executeQuery("SELECT * FROM band_artiest ");
               
               
               for (int i = 0; resultset.next();i++) {
                   
                 
                   String Naam= resultset.getString("Naam");
                   String Beschrijving= resultset.getString("Beschrijving");
                  
                   
                 
                   
                   g.drawString (Naam,230,50+20*i);
                   g.drawString(Beschrijving,310,50+20*i);
                   
                   
                   
                                     
               }  } catch (SQLException ex) {
               
                   Logger.getLogger(Duo_opdracht.class.getName()).log(Level.SEVERE, null, ex);
        
           
            }
         }
    }



    
         
        


         

   
