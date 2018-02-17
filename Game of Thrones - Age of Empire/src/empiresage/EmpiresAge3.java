package empiresage;

import java.util.HashMap;
import ageofempiresgui.*;
import javax.swing.SwingWorker;
import java.util.List;
import java.io.IOException; //Anna
import java.nio.file.Files; //Anna
import java.nio.file.StandardOpenOption; //Anna
import java.nio.file.Path; //Anna
import java.nio.file.Paths; //Anna

/**
 *
 * @author Lydia
 */
public class EmpiresAge3  extends SwingWorker <List<HashMap>, HashMap> {

    /**
     * @param args the command line arguments
     * just checking team stuff with this comment
     * another check
     */
    
    
    int y=0; //counter
    String winner =""; //Anna
    public HashMap <String,Integer> gameState;
    
    private gameGUI gg;
    String[] props ;
    public EmpiresAge3()
    {
        props = new String[]{"numberOfVillagersPlayer","numberOfFightersPlayer","numberOfArchPlayer","numberOfHousesPlayer",
                        "numberOfFightingUnit","goldPlayer","woodPlayer","foodPlayer"};
        initialize();
    }
    
    
    public void setUI3(gameGUI gg)
    {
        this.gg = gg;
    }
    
    
    
    public void getUI3(gameGUI gg)
    {
        this.gg = gg;
    }
    
    public void choseUI3(gameGUI gg)
    {
        this.gg = gg;
    }
    
    
    
    String s ="";       
    public void initialize() {
        gameState = new HashMap <String,Integer>();
        gameState.put("numberOfVillagersPlayerOne", 1);
        gameState.put("numberOfVillagersPlayerTwo", 1);
        gameState.put("numberOfFightersPlayerOne", 2);
        gameState.put("numberOfFightersPlayerTwo", 2);
        gameState.put("numberOfArchPlayerOne", 3);
        gameState.put("numberOfArchPlayerTwo", 3);
        gameState.put("numberOfHousesPlayerOne", 1);
        gameState.put("numberOfHousesPlayerTwo", 1);
        gameState.put("numberOfFightingUnitOne", 1);
        gameState.put("numberOfFightingUnitTwo", 1);
        gameState.put("goldPlayerOne", 0);
        gameState.put("goldPlayerTwo", 0);
        gameState.put("woodPlayerOne", 0);
        gameState.put("woodPlayerTwo", 0);
        gameState.put("foodPlayerOne", 0);
        gameState.put("foodPlayerTwo", 0);
    
    }
  
    public HashMap <String,Integer> getGameState() {return gameState;}
    
    
    
    
    
    
    
    
    
    
    
    public void runGameMCTSvsMonteCarlo() throws IOException
    {
        long then = System.currentTimeMillis();

             MCTSPlayer mcts;
             MonteCarlo mc;
        mcts = new MCTSPlayer(gameState,1);       
        mc = new MonteCarlo(gameState,2);
        while (!mc.endGame(gameState) && !mcts.endGame(gameState)){
           gameState= mc.updateMove(gameState);
           mc.setState(gameState);
           mcts.setState(gameState);
           y++;
           gameState = mcts.updateMove(gameState);
           mc.setState(gameState);
           mcts.setState(gameState);
           y++;   
           publish(gameState);   }    
         s += "\ntotal moves: " + y;
        long duration = System.currentTimeMillis() - then;
        if(mcts.endGame(gameState)){
            winner  = ("MSCTS");//Anna
            s +="\nAnd the winnerrrrrrrrr of the battle " +"\n"+"between MCTS and MonteCarlo isssssss MCTS.";
        }
        if(mc.endGame(gameState)){
            winner  = ("MonteCarlo");//anna
            s +="\nAnd the winnerrrrrrrrr of the battle "+"\n"+"between MCTS and MonteCarlo isssssss MonteCarlo.";
        }
            s +="\nIt took " + duration/1000 + " second."; 
            
            //I have coppied from here and its too many eerors can you check, I havent coppied to other runs 
         
         duration=duration/1000;
         String durationString = Long.toString(duration);
         String dataToFile =" "+"\r\n"+durationString +" "+ winner + " "+ gameState;
         //writes data to the file
         Path filePath = Paths.get("gameDataOriginalMCTSvsMonteCarlo.txt");
         if (!Files.exists(filePath)) {
         Files.createFile(filePath);
}
         Files.write(filePath, dataToFile.getBytes(), StandardOpenOption.APPEND);
    }  

         public void runGameMonteCarlovsMonteCarlo() throws IOException {
        long then = System.currentTimeMillis();

             MonteCarlo mc2;
             MonteCarlo mc;
   
        mc2 = new MonteCarlo(gameState,1);       
        mc = new MonteCarlo(gameState,2);
        while (!mc.endGame(gameState) && !mc2.endGame(gameState)){
           gameState= mc.updateMove(gameState);
           mc.setState(gameState);
           mc2.setState(gameState);
           y++;
           gameState = mc2.updateMove(gameState);
           mc.setState(gameState);
           mc2.setState(gameState);
           y++;
           publish(gameState);
      }
         s += "\ntotal moves: " + y;
        long duration = System.currentTimeMillis() - then;
        if(mc2.endGame(gameState)){
            winner  = ("MonteCarlo");//anna
            s +="\nAnd the winnerrrrrrrrr of the battle " +"\n"+"between MonteCarlo2 and MonteCarlo isssssss MonteCarlo2.";
        }
        if(mc.endGame(gameState)){
            winner  = ("MonteCarlo");//Anna
            s +="\nAnd the winnerrrrrrrrr of the battle "+"\n"+"between MonteCarlo2 and MonteCarlo isssssss MonteCarlo.";
        }
            s +="\nIt Took " + duration/1000 + " second.";
              
            
            duration=duration/1000;
         String durationString = Long.toString(duration);
         String dataToFile =" "+"\r\n"+durationString +" "+ winner + " "+ gameState;
         //writes data to the file
         Path filePath = Paths.get("gameDataOriginalMonteCarlovsMonteCarlo.txt");
         if (!Files.exists(filePath)) {
         Files.createFile(filePath);
}
         Files.write(filePath, dataToFile.getBytes(), StandardOpenOption.APPEND);
    }   
  
    public void runGameMinmaxvsMCTS() throws IOException
    {
        long then = System.currentTimeMillis();
        //HashMap <String,Integer> state2 = (HashMap) state.clone();
        //HashMap <String,Integer> state3 = (HashMap) state.clone();
             MinMaxPlayer minMax;
             MCTSPlayer mscts;
        boolean minmaxAnnounced=false;
        boolean mctsAnnounced= false;
        minMax = new MinMaxPlayer(gameState,1);       
        mscts = new MCTSPlayer(gameState,2);
        while (!mscts.endGame(gameState) && !minMax.endGame(gameState)){
           gameState= mscts.updateMove(gameState);
           mscts.setState(gameState);
           minMax.setState(gameState);
           y++;
           gameState = minMax.updateMove(gameState);
           mscts.setState(gameState);
           minMax.setState(gameState);
           y++;   
           publish(gameState);
      
        }
         s += "\ntotal moves: " + y;
        long duration = System.currentTimeMillis() - then;
        if(minMax.endGame(gameState)){
             winner = ("MiniMax");//Anna
            s +="\nAnd the winnerrrrrrrrr of the battle " +"\n"+"between Minimax and MCTS isssssss MiniMax.";
        }
        if(mscts.endGame(gameState)){
            winner  = ("MSCTS");//Anna
            s +="\nAnd the winnerrrrrrrrr of the battle "+"\n"+"between Minimax and MCTS isssssss MCTS.";
        }
            s +="\nIt Took " + duration/1000 + " second.";   
            
            duration=duration/1000;
         String durationString = Long.toString(duration);
         String dataToFile =" "+"\r\n"+durationString +" "+ winner + " "+ gameState;
         //writes data to the file
         Path filePath = Paths.get("gameDataOriginalMinimaxvsMCTS.txt");
         if (!Files.exists(filePath)) {
         Files.createFile(filePath);
}
         Files.write(filePath, dataToFile.getBytes(), StandardOpenOption.APPEND);
    }
    
    public void runGameMCTSvsMCTS() throws IOException
    {
        long then = System.currentTimeMillis();
        //HashMap <String,Integer> state2 = (HashMap) state.clone();
        //HashMap <String,Integer> state3 = (HashMap) state.clone();
             MCTSPlayer mcts2;
             MCTSPlayer mscts;
        boolean minmaxAnnounced=false;
        boolean mctsAnnounced= false;
        mcts2 = new MCTSPlayer(gameState,1);       
        mscts = new MCTSPlayer(gameState,2);
        while (!mscts.endGame(gameState) && !mcts2.endGame(gameState)){
           gameState= mscts.updateMove(gameState);
           mscts.setState(gameState);
           mcts2.setState(gameState);
           y++;
           gameState = mcts2.updateMove(gameState);
           mscts.setState(gameState);
           mcts2.setState(gameState);
           y++;
           publish(gameState);

        }
         s += "\ntotal moves: " + y;
        long duration = System.currentTimeMillis() - then;
        if(mcts2.endGame(gameState)){
            winner  = ("MSCTS");//Anna
            s +="\nAnd the winnerrrrrrrrr of the battle " +"\n"+"between MCTS2 and MCTS1 isssssss MCTS2.";
        }
        if(mscts.endGame(gameState)){
            winner  = ("MSCTS");//Anna
            s +="\nAnd the winnerrrrrrrrr of the battle "+"\n"+"between MCTS2 and MCTS1 isssssss MCTS1.";
        }
            s +="\nIt Took " + duration/1000 + " second."; 
        duration=duration/1000;
         String durationString = Long.toString(duration);
         String dataToFile =" "+"\r\n"+durationString +" "+ winner + " "+ gameState;
         //writes data to the file
         Path filePath = Paths.get("gameDataOriginalMCTSvsMCTS.txt");
         if (!Files.exists(filePath)) {
         Files.createFile(filePath);
}
         Files.write(filePath, dataToFile.getBytes(), StandardOpenOption.APPEND);
            
            
            
    }
   
    public void runGameMinmaxvsMonteCarlo() throws IOException
    {
        long then = System.currentTimeMillis();
        //HashMap <String,Integer> state2 = (HashMap) state.clone();
        //HashMap <String,Integer> state3 = (HashMap) state.clone();
             MinMaxPlayer minMax;
             MonteCarlo mc;
        minMax = new MinMaxPlayer(gameState,1);       
        mc = new MonteCarlo(gameState,2);
        while (!mc.endGame(gameState) && !minMax.endGame(gameState)){
           gameState= mc.updateMove(gameState);
           mc.setState(gameState);
           minMax.setState(gameState);
           y++;
           gameState = minMax.updateMove(gameState);
           mc.setState(gameState);
           minMax.setState(gameState);
           y++;     
           publish(gameState);
        }
         s += "\ntotal moves: " + y;
        long duration = System.currentTimeMillis() - then;
        if(minMax.endGame(gameState)){
             winner = ("MiniMax");//Anna
            s +="\nAnd the winnerrrrrrrrr of the battle " +"\n"+"between Minimax and MonteCarlo isssssss MiniMax.";}
        if(mc.endGame(gameState)){
            winner  = ("MonteCarlo");//Anna
            s +="\nAnd the winnerrrrrrrrr of the battle "+"\n"+"between Minimax and MonteCarlo isssssss MonteCarlo."; }
            s +="\nIt Took " + duration/1000 + " second.";
        duration=duration/1000;
         String durationString = Long.toString(duration);
         String dataToFile =" "+"\r\n"+durationString +" "+ winner + " "+ gameState;
         //writes data to the file
         Path filePath = Paths.get("gameDataOriginalMinmaxvsMonteCarlo.txt");
         if (!Files.exists(filePath)) {
         Files.createFile(filePath);
}
         Files.write(filePath, dataToFile.getBytes(), StandardOpenOption.APPEND);
            }
    
    public void runGameMinimaxvsMinimax() throws IOException
    {
        long then = System.currentTimeMillis();
        //HashMap <String,Integer> state2 = (HashMap) state.clone();
        //HashMap <String,Integer> state3 = (HashMap) state.clone();
          MinMaxPlayer minMax;
          MinMaxPlayer2 minMax2;
        minMax = new MinMaxPlayer(gameState,1);       
        minMax2 = new MinMaxPlayer2(gameState,2);
        while (!minMax2.endGame(gameState) && !minMax.endGame(gameState)){
           gameState= minMax2.updateMove(gameState);
           minMax2.setState(gameState);
           minMax.setState(gameState);
           y++;
           gameState = minMax.updateMove(gameState);
           minMax2.setState(gameState);
           minMax.setState(gameState);
           y++; 
           publish(gameState);
              }
         s += "\ntotal moves: " + y;
        long duration = System.currentTimeMillis() - then;
        if(minMax.endGame(gameState)){
             winner = ("MiniMax");//Anna
            s +="\nAnd the winnerrrrrrrrr of the battle " +"\n"+"between Minimax1 and Minimax2 isssssss Minimax1.";  }
        if(minMax2.endGame(gameState)){
            winner  = ("MiniMax");//Anna
            s +="\nAnd the winnerrrrrrrrr of the battle "+"\n"+"between Minimax1 and Minimax2 isssssss Minimax2.";
        }
            s +="\nIt Took " + duration/1000 + " second."; 
        duration=duration/1000;
         String durationString = Long.toString(duration);
         String dataToFile =" "+"\r\n"+durationString +" "+ winner + " "+ gameState;
         //writes data to the file
         Path filePath = Paths.get("gameDataOriginalMinmaxvsMinimax.txt");
         if (!Files.exists(filePath)) {
         Files.createFile(filePath);
}
         Files.write(filePath, dataToFile.getBytes(), StandardOpenOption.APPEND);
            }
    
    public void runGameMCTSvsMinmax() throws IOException
    {
        long then = System.currentTimeMillis();
        //HashMap <String,Integer> state2 = (HashMap) state.clone();
        //HashMap <String,Integer> state3 = (HashMap) state.clone();
          MCTSPlayer mcts;
          MinMaxPlayer2 minMax2;
        mcts = new MCTSPlayer(gameState,1);       
        minMax2 = new MinMaxPlayer2(gameState,2);
        while (!minMax2.endGame(gameState) && !mcts.endGame(gameState)){
           gameState= minMax2.updateMove(gameState);
           minMax2.setState(gameState);
           mcts.setState(gameState);
           y++;
           gameState = mcts.updateMove(gameState);
           minMax2.setState(gameState);
           mcts.setState(gameState);
           y++; 
           publish(gameState);
              }
         s += "\ntotal moves: " + y;
        long duration = System.currentTimeMillis() - then;
        if(mcts.endGame(gameState)){
            winner  = ("MSCTS");//Anna
            s +="\nAnd the winnerrrrrrrrr of the battle " +"\n"+"between MCTS and Minimax isssssss MCTS.";  }
        if(minMax2.endGame(gameState)){
             winner = ("MiniMax");//Anna
            s +="\nAnd the winnerrrrrrrrr of the battle "+"\n"+"between MCTS and Minimax isssssss Minimax.";
        }
            s +="\nIt Took " + duration/1000 + " second."; 
        duration=duration/1000;
         String durationString = Long.toString(duration);
         String dataToFile =" "+"\r\n"+durationString +" "+ winner + " "+ gameState;
         //writes data to the file
         Path filePath = Paths.get("gameDataOriginalMCTSvsMinimax.txt");
         if (!Files.exists(filePath)) {
         Files.createFile(filePath);
}
         Files.write(filePath, dataToFile.getBytes(), StandardOpenOption.APPEND);
            }
    
    public void runGameMonteCarlovsMinmax() throws IOException
    {
        long then = System.currentTimeMillis();
        //HashMap <String,Integer> state2 = (HashMap) state.clone();
        //HashMap <String,Integer> state3 = (HashMap) state.clone();
          MonteCarlo mc;
          MinMaxPlayer2 minMax2;
        mc = new MonteCarlo(gameState,1);       
        minMax2 = new MinMaxPlayer2(gameState,2);
        while (!minMax2.endGame(gameState) && !mc.endGame(gameState)){
           gameState= minMax2.updateMove(gameState);
           minMax2.setState(gameState);
           mc.setState(gameState);
           y++;
           gameState = mc.updateMove(gameState);
           minMax2.setState(gameState);
           mc.setState(gameState);
           y++; 
           publish(gameState);
              }
         s += "\ntotal moves: " + y;
        long duration = System.currentTimeMillis() - then;
        if(mc.endGame(gameState)){
            winner  = ("MonteCarlo");//Anna
            s +="\nAnd the winnerrrrrrrrr of the battle " +"\n"+"between MonteCarlo and Minimax isssssss MonteCarlo.";  }
        if(minMax2.endGame(gameState)){
             winner = ("MiniMax");//Anna
            s +="\nAnd the winnerrrrrrrrr of the battle "+"\n"+"between MonteCarlo and Minimax isssssss Minimax.";
        }
            s +="\nIt Took " + duration/1000 + " second."; 
        duration=duration/1000;
         String durationString = Long.toString(duration);
         String dataToFile =" "+"\r\n"+durationString +" "+ winner + " "+ gameState;
         //writes data to the file
         Path filePath = Paths.get("gameDataOriginalMonteCarlovsMinimax.txt");
         if (!Files.exists(filePath)) {
         Files.createFile(filePath);
}
         Files.write(filePath, dataToFile.getBytes(), StandardOpenOption.APPEND);
            }
    
    public void runGameMonteCarlovsMCTS() throws IOException
    {
        long then = System.currentTimeMillis();
        //HashMap <String,Integer> state2 = (HashMap) state.clone();
        //HashMap <String,Integer> state3 = (HashMap) state.clone();
          MonteCarlo mc;
          MCTSPlayer mcts;
        mc = new MonteCarlo(gameState,1);       
        mcts = new MCTSPlayer(gameState,2);
        while (!mcts.endGame(gameState) && !mc.endGame(gameState)){
           gameState= mcts.updateMove(gameState);
           mcts.setState(gameState);
           mc.setState(gameState);
           y++;
           gameState = mc.updateMove(gameState);
           mcts.setState(gameState);
           mc.setState(gameState);
           y++; 
           publish(gameState);
              }
         s += "\ntotal moves: " + y;
        long duration = System.currentTimeMillis() - then;
        if(mc.endGame(gameState)){
            winner  = ("MonteCarlo");//Anna
            s +="\nAnd the winnerrrrrrrrr of the battle " +"\n"+"between MonteCarlo and MCTS isssssss MonteCarlo.";  }
        if(mcts.endGame(gameState)){
            winner  = ("MSCTS");//Anna
            s +="\nAnd the winnerrrrrrrrr of the battle "+"\n"+"between MonteCarlo and MCTS isssssss MCTS.";
        }
            s +="\nIt Took " + duration/1000 + " second.";  
        duration=duration/1000;
         String durationString = Long.toString(duration);
         String dataToFile =" "+"\r\n"+durationString +" "+ winner + " "+ gameState;
         //writes data to the file
         Path filePath = Paths.get("gameDataOriginalMonteCarlovsMCTS.txt");
         if (!Files.exists(filePath)) {
         Files.createFile(filePath);
}
         Files.write(filePath, dataToFile.getBytes(), StandardOpenOption.APPEND);
            }
    
            
    @Override
    protected void done(){
        s += "\nthird war is done";

    gg.setresult().append(s);
    }
    @Override
    protected List<HashMap> doInBackground() throws Exception {
        String S = "";
       
        S += ("doing it please wait...\n");
       
      
       if ((gg.jComboBox1.getSelectedItem()=="MCTS") && (gg.jComboBox2.getSelectedItem()=="MonteCarlo2") )
                    
               {
                   gg.loadtime().setText(S + "MCTS vs MonteCarlo has been selected.");
        runGameMCTSvsMonteCarlo(); 
    }
       
       if ((gg.jComboBox1.getSelectedItem()=="Minimax") && (gg.jComboBox2.getSelectedItem()=="MonteCarlo2") )     
               {
                   gg.loadtime().setText(S + "MinMax vs MonteCarlo has been selected.");
        runGameMinmaxvsMonteCarlo(); 
    }
       
       if ((gg.jComboBox1.getSelectedItem()=="MCTS") && (gg.jComboBox2.getSelectedItem()=="Minimax2")  
              )     
               {
                   gg.loadtime().setText(S + "MCTS vs MinMax has been selected.");
        runGameMCTSvsMinmax(); 
    }
       
       if ((gg.jComboBox1.getSelectedItem()=="MonteCarlo") && (gg.jComboBox2.getSelectedItem()=="MonteCarlo2") )
                 
               {
                   gg.loadtime().setText(S+ "MonteCarlo vs MonteCarlo has been selected.");
        runGameMonteCarlovsMonteCarlo(); 
    }
       
       if ((gg.jComboBox1.getSelectedItem()=="MCTS") && (gg.jComboBox2.getSelectedItem()=="MCTS2")) 
                 
               {
                   gg.loadtime().setText(S + "MCTS vs MCTS has been selected.");
        runGameMCTSvsMCTS(); 
    }
       if ((gg.jComboBox1.getSelectedItem()=="Minimax") && (gg.jComboBox2.getSelectedItem()=="Minimax2")) 
                 
               {
                   gg.loadtime().setText(S + "Minmax vs Minmax has been selected.");
        runGameMinimaxvsMinimax(); 
    }
        if ((gg.jComboBox2.getSelectedItem()=="MCTS2") && (gg.jComboBox1.getSelectedItem()=="MonteCarlo")) 
                 
               {
                   gg.loadtime().setText(S + "MonteCarlo vs MCTS has been selected.");
        runGameMonteCarlovsMCTS(); 
    }
        if ((gg.jComboBox2.getSelectedItem()=="Minimax2") && (gg.jComboBox1.getSelectedItem()=="MonteCarlo")) 
                 
               {
                   gg.loadtime().setText(S + "MonteCarlo vs Minmax has been selected.");
        runGameMonteCarlovsMinmax(); 
    }
        if ( (gg.jComboBox2.getSelectedItem()=="MCTS2") && (gg.jComboBox1.getSelectedItem()=="Minimax")) 
                 
               {
                   gg.loadtime().setText(S + "MiniMax vs MCTS has been selected.");
        runGameMinmaxvsMCTS(); 
    }       
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
    @Override
     protected void process(List<HashMap> hms) {
         for (HashMap hm : hms) {
             gg.showState3(hm);
             gg.barchart3(hm);
             
         }
     }

    
}
