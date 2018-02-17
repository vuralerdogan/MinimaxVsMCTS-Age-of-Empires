/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ageofempiresgui;
// still some issues with import

import javax.swing.table.DefaultTableModel;
import empiresage.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.HashMap;
import static javafx.application.Platform.exit;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.text.DefaultCaret;
import javax.swing.text.View;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;


/**
 *
 * @author Steve Bennett
 */
public class gameGUI extends javax.swing.JFrame {



int warrior,archers,houses,villagers,fightingunit;
int warrior2,archers2,houses2,villagers2,fightingunit2;
int total;
int total2;
int clicktime;

DefaultTableModel tm;
String column_names[]; 
DefaultTableModel tm2;
String column_names2[]; 
DefaultTableModel tm3;
String column_names3[]; 
    /**
     * Creates new form gameGUI
     */
   
    public gameGUI () {
        
        try {

UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
}
catch (ClassNotFoundException ex) {
java.util.logging.Logger.getLogger(gameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
}catch (InstantiationException ex) {
java.util.logging.Logger.getLogger(gameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (IllegalAccessException ex) {
java.util.logging.Logger.getLogger(gameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (javax.swing.UnsupportedLookAndFeelException ex) {
java.util.logging.Logger.getLogger(gameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
}

 clicktime=0;       
        
        initComponents();
  }
    
    
    public void barchart3(HashMap <String,Integer> state){ 
    
        
         if(clicktime==3){
            
            DefaultCategoryDataset barChartData3= new DefaultCategoryDataset(); 
            
barChartData3.setValue(state.get("numberOfVillagersPlayerOne"),(String)jComboBox1.getSelectedItem(), "Villagers");
barChartData3.setValue(state.get("numberOfHousesPlayerOne"),(String)jComboBox1.getSelectedItem(), "Houses");
barChartData3.setValue(state.get("numberOfArchPlayerOne"),(String)jComboBox1.getSelectedItem(), "Archers");
barChartData3.setValue(state.get("numberOfFightersPlayerOne"),(String)jComboBox1.getSelectedItem(), "Warriors");
barChartData3.setValue(state.get("numberOfFightingUnitOne"),(String)jComboBox1.getSelectedItem(), "FightingUnits");

barChartData3.setValue(state.get("numberOfVillagersPlayerTwo"),(String)jComboBox2.getSelectedItem(), "Villagers");
barChartData3.setValue(state.get("numberOfHousesPlayerTwo"),(String)jComboBox2.getSelectedItem(),"Houses");
barChartData3.setValue(state.get("numberOfArchPlayerTwo"),(String)jComboBox2.getSelectedItem(), "Archers");
barChartData3.setValue(state.get("numberOfFightersPlayerTwo"),(String)jComboBox2.getSelectedItem(),"Warriors");
barChartData3.setValue(state.get("numberOfFightingUnitTwo"),(String)jComboBox2.getSelectedItem(),"FightingUnits");



JFreeChart barChart3 = ChartFactory.createLineChart3D("War Results3", "Units3", "number3", barChartData3, PlotOrientation.HORIZONTAL, true, true, false);
// TODO add your handling code here:

CategoryPlot barchrt3 = barChart3.getCategoryPlot();
barchrt3.setRangeGridlinePaint(Color.ORANGE);

    ChartPanel barPanel3 = new ChartPanel(barChart3);
    ChartFrame frame3= new ChartFrame("BarChart3", barChart3);
            jPanel3.removeAll();
            jPanel3.add(barPanel3, BorderLayout.CENTER);
            jPanel3.validate();

        }
     
        
    }
    
    
    
   public void barchart2(HashMap <String,Integer> state){ 
    
       
        if(clicktime>=2){
       DefaultCategoryDataset barChartData2= new DefaultCategoryDataset(); 
            
barChartData2.setValue(state.get("numberOfVillagersPlayerOne"),(String)jComboBox1.getSelectedItem(), "Villagers");
barChartData2.setValue(state.get("numberOfHousesPlayerOne"),(String)jComboBox1.getSelectedItem(), "Houses");
barChartData2.setValue(state.get("numberOfArchPlayerOne"),(String)jComboBox1.getSelectedItem(), "Archers");
barChartData2.setValue(state.get("numberOfFightersPlayerOne"),(String)jComboBox1.getSelectedItem(), "Warriors");
barChartData2.setValue(state.get("numberOfFightingUnitOne"),(String)jComboBox1.getSelectedItem(), "FightingUnits");

barChartData2.setValue(state.get("numberOfVillagersPlayerTwo"),(String)jComboBox2.getSelectedItem(), "Villagers");
barChartData2.setValue(state.get("numberOfHousesPlayerTwo"),(String)jComboBox2.getSelectedItem(),"Houses");
barChartData2.setValue(state.get("numberOfArchPlayerTwo"),(String)jComboBox2.getSelectedItem(), "Archers");
barChartData2.setValue(state.get("numberOfFightersPlayerTwo"),(String)jComboBox2.getSelectedItem(),"Warriors");
barChartData2.setValue(state.get("numberOfFightingUnitTwo"),(String)jComboBox2.getSelectedItem(),"FightingUnits");



JFreeChart barChart2 = ChartFactory.createAreaChart("War Results 2", "Units 2", "number 2", barChartData2, PlotOrientation.HORIZONTAL, true, true, false);
// TODO add your handling code here:

CategoryPlot barchrt2 = barChart2.getCategoryPlot();
barchrt2.setRangeGridlinePaint(Color.ORANGE);

    ChartPanel barPanel2 = new ChartPanel(barChart2);
    ChartFrame frame2= new ChartFrame("BarChart2", barChart2);     
            jPanel2.removeAll();
            jPanel2.add(barPanel2, BorderLayout.CENTER);
            jPanel2.validate();
        }
       
       
    
   }
    
   
  public void barchart(HashMap <String,Integer> state){
  
  
  
   /* frame.setVisible(true);
    frame.setSize(500,400);
     These codes show the barchart on the frame. */ 
    if(clicktime>=1){
            
            DefaultCategoryDataset barChartData= new DefaultCategoryDataset(); 
            
barChartData.setValue(state.get("numberOfVillagersPlayerOne"),(String)jComboBox1.getSelectedItem(), "Villagers");
barChartData.setValue(state.get("numberOfHousesPlayerOne"),(String)jComboBox1.getSelectedItem(), "Houses");
barChartData.setValue(state.get("numberOfArchPlayerOne"),(String)jComboBox1.getSelectedItem(), "Archers");
barChartData.setValue(state.get("numberOfFightersPlayerOne"),(String)jComboBox1.getSelectedItem(), "Warriors");
barChartData.setValue(state.get("numberOfFightingUnitOne"),(String)jComboBox1.getSelectedItem(), "FightingUnits");

barChartData.setValue(state.get("numberOfVillagersPlayerTwo"),(String)jComboBox2.getSelectedItem(), "Villagers");
barChartData.setValue(state.get("numberOfHousesPlayerTwo"),(String)jComboBox2.getSelectedItem(),"Houses");
barChartData.setValue(state.get("numberOfArchPlayerTwo"),(String)jComboBox2.getSelectedItem(), "Archers");
barChartData.setValue(state.get("numberOfFightersPlayerTwo"),(String)jComboBox2.getSelectedItem(),"Warriors");
barChartData.setValue(state.get("numberOfFightingUnitTwo"),(String)jComboBox2.getSelectedItem(),"FightingUnits");



JFreeChart barChart = ChartFactory.createBarChart3D("War Results", "Units", "number", barChartData, PlotOrientation.HORIZONTAL, true, true, false);
// TODO add your handling code here:

CategoryPlot barchrt = barChart.getCategoryPlot();
barchrt.setRangeGridlinePaint(Color.ORANGE);

    ChartPanel barPanel = new ChartPanel(barChart);
    ChartFrame frame= new ChartFrame("BarChart", barChart);
            jPanel1.removeAll();
            jPanel1.add(barPanel, BorderLayout.CENTER);
            jPanel1.validate();
    }
   
    
  }
    
  

    public void showState(HashMap <String,Integer> state)
    {   column_names = new String[]{"Prop", (String) jComboBox1.getSelectedItem(),(String) jComboBox2.getSelectedItem()};
          tm =new DefaultTableModel(column_names,3);
          tm.getDataVector().removeAllElements();
        
        
              
        jTable1.setModel(tm);
        jTable1.removeAll();
        int x;
        for (x=0;x<8;x++) 
            {
                Object o[] = {"",0,0};
                tm.addRow(o);
            }
        
       
     
        String[] props = new String[]{"numberOfVillagersPlayer","numberOfFightersPlayer","numberOfArchPlayer","numberOfHousesPlayer",
                        "numberOfFightingUnit","woodPlayer","foodPlayer","goldPlayer"};
        int i;
        int value[];
        
        
        for (i=0;i<props.length;i++) {
            String key = props[i];
            String shownKey = key.replaceFirst("Player", "");
            tm.setValueAt(shownKey, i, 0);
            tm.setValueAt(state.get(key + "One"), i, 1);
            tm.setValueAt(state.get(key + "Two"), i, 2);
            
           
        }
        
        villagers=state.get("numberOfVillagersPlayerOne");
        archers=state.get("numberOfArchPlayerOne");
        warrior=state.get("numberOfFightersPlayerOne");
        fightingunit=state.get("numberOfFightingUnitOne");
        houses=state.get("numberOfHousesPlayerOne");
        
        villagers2=state.get("numberOfVillagersPlayerTwo");
        archers2=state.get("numberOfArchPlayerTwo");
        warrior2=state.get("numberOfFightersPlayerTwo");
        fightingunit2=state.get("numberOfFightingUnitTwo");
        houses2=state.get("numberOfHousesPlayerTwo");
          
       
    }
    
    
   public void showState2(HashMap <String,Integer> state)
    {  
        column_names2 = new String[]{"Prop", (String)jComboBox1.getSelectedItem(),(String)jComboBox2.getSelectedItem()};
          tm2 =new DefaultTableModel(column_names2,3);
          tm2.getDataVector().removeAllElements();
        
        
              
        jTable2.setModel(tm2);
        jTable2.removeAll();
        int x;
        for (x=0;x<8;x++) 
            {
                Object o[] = {"",0,0};
                tm2.addRow(o);
            }
        
        
     
        String[] props2 = new String[]{"numberOfVillagersPlayer","numberOfFightersPlayer","numberOfArchPlayer","numberOfHousesPlayer",
                        "numberOfFightingUnit","woodPlayer","foodPlayer","goldPlayer"};
        int i;
        int value[];
        
        
        for (i=0;i<props2.length;i++) {
            String key = props2[i];
            String shownKey = key.replaceFirst("Player", "");
            tm2.setValueAt(shownKey, i, 0);
            tm2.setValueAt(state.get(key + "One"), i, 1);
            tm2.setValueAt(state.get(key + "Two"), i, 2);
            
           
        }
     
      
    }
   
   public void showState3(HashMap <String,Integer> state)
    {  
        
        column_names3 = new String[]{"Prop", (String)jComboBox1.getSelectedItem(),(String)jComboBox2.getSelectedItem()};
          tm3 =new DefaultTableModel(column_names3,3);
          tm3.getDataVector().removeAllElements();
        
        
              
        jTable3.setModel(tm3);
        jTable3.removeAll();
        int x;
        for (x=0;x<8;x++) 
            {
                Object o[] = {"",0,0};
                tm3.addRow(o);
            }
        
        
     
        String[] props3 = new String[]{"numberOfVillagersPlayer","numberOfFightersPlayer","numberOfArchPlayer","numberOfHousesPlayer",
                        "numberOfFightingUnit","woodPlayer","foodPlayer","goldPlayer"};
        int i;
        int value[];
        
        
        for (i=0;i<props3.length;i++) {
            String key = props3[i];
            String shownKey = key.replaceFirst("Player", "");
            tm3.setValueAt(shownKey, i, 0);
            tm3.setValueAt(state.get(key + "One"), i, 1);
            tm3.setValueAt(state.get(key + "Two"), i, 2);
            
           
        }
     
      
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ParalelFight = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        ParalelFight50 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        ParalelFightOptional = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jPieChart = new javax.swing.JButton();
        SerialFight = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title ", "Title", "Title"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(480, 210, 423, 215);

        ParalelFight.setText("Fight!");
        ParalelFight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParalelFightActionPerformed(evt);
            }
        });
        getContentPane().add(ParalelFight);
        ParalelFight.setBounds(470, 41, 60, 29);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minimax", "MonteCarlo", "MCTS" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(470, 110, 128, 27);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minimax2", "MonteCarlo2", "MCTS2" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(630, 110, 136, 27);

        ParalelFight50.setText("Fight 50x");
        ParalelFight50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParalelFight50ActionPerformed(evt);
            }
        });
        getContentPane().add(ParalelFight50);
        ParalelFight50.setBounds(536, 41, 91, 29);

        jButton4.setText("Help for Algorithms!");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(630, 0, 173, 29);

        jTextField1.setText("1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(680, 70, 77, 26);

        DefaultCaret caret = (DefaultCaret)jTextArea1.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(40, 40, 423, 151);

        ParalelFightOptional.setText("Enter the number of the war:");
        ParalelFightOptional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParalelFightOptionalActionPerformed(evt);
            }
        });
        getContentPane().add(ParalelFightOptional);
        ParalelFightOptional.setBounds(470, 70, 210, 29);

        jTextField2.setBackground(new java.awt.Color(204, 204, 204));
        jTextField2.setText("Vs");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(600, 110, 30, 26);

        jPieChart.setText("Print PieCharts");
        jPieChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPieChartActionPerformed(evt);
            }
        });
        getContentPane().add(jPieChart);
        jPieChart.setBounds(490, 0, 136, 29);

        SerialFight.setText("Serial Fight");
        SerialFight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SerialFightActionPerformed(evt);
            }
        });
        getContentPane().add(SerialFight);
        SerialFight.setBounds(470, 160, 130, 29);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel1);
        jPanel1.setBounds(490, 460, 410, 290);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel2);
        jPanel2.setBounds(50, 460, 410, 290);

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel3);
        jPanel3.setBounds(930, 460, 410, 290);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title ", "Title", "Title"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(40, 210, 423, 215);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title ", "Title", "Title"
            }
        ));
        jScrollPane4.setViewportView(jTable3);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(930, 210, 423, 215);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ageofempiresgui/ss_9ccf9acb373b3e26f9e42a053147845561b2c224.1920x1080.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1920, 1080);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ParalelFightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParalelFightActionPerformed
       
        clicktime=clicktime + 1;
        if (clicktime==1) {
        EmpiresAge ea = new EmpiresAge();
        ea.setUI(this);
        ea.execute();
        }
        if (clicktime==2){
        EmpiresAge2 ea2 = new EmpiresAge2();
        ea2.setUI2(this);
        ea2.execute();
        }
        if(clicktime==3){
        
        EmpiresAge3 ea3 = new EmpiresAge3();
        ea3.setUI3(this);
        ea3.execute();
        
        }
        
        if(clicktime>3){  
        System.exit(0);
     
        }
             
    }//GEN-LAST:event_ParalelFightActionPerformed


    
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
  
         
// TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed
 
    
    
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
            
  
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void ParalelFight50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParalelFight50ActionPerformed
        // TODO add your handling code here:
        
        for (int i=0; i<50; i++){
         EmpiresAge ea = new EmpiresAge();
         ea.getUI(this);
         ea.execute();
        }
    }//GEN-LAST:event_ParalelFight50ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    
        ChoosingAlgorithm ca= new ChoosingAlgorithm();
        ca.setVisible(true);
        
        
    
    
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void ParalelFightOptionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParalelFightOptionalActionPerformed
        // TODO add your handling code here:
         String number=jTextField1.getText();
        
        int x = Integer.parseInt(number);
        
        if (x<=0) {jTextArea1.setText("Enter Only Counting Numbers Please")
                
     ;}
        else{
    
        for(int i=0;i<x; i++){
        
        EmpiresAge ea = new EmpiresAge();
        ea.choseUI(this);
        ea.execute();
        }
        }
        
    }//GEN-LAST:event_ParalelFightOptionalActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jPieChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPieChartActionPerformed
        // TODO add your handling code here:
        
        
        
        DefaultPieDataset xChartData= new DefaultPieDataset(); 
        DefaultPieDataset yChartData= new DefaultPieDataset();
      
     total = villagers + houses + archers + warrior + fightingunit ;
     total2= villagers2 +houses2+ archers2 + warrior2 + fightingunit2;
        int k=100*villagers/total;
        int l=100*archers/total;
        int m=100*warrior/total;
        int n=100*fightingunit/total;
        int o=100*houses/total;
        
        
        int a=100*villagers2/total2;
        int b=100*archers2/total2;
        int c=100*warrior2/total2;
        int d=100*fightingunit2/total2;
        int e=100*houses2/total2;
        

        
xChartData.setValue("villagers",k);
xChartData.setValue("archers", l);
xChartData.setValue("warrior", m);
xChartData.setValue("figh.unit", n);
xChartData.setValue("houses", o);

yChartData.setValue("villagers",a);
yChartData.setValue("archers", b);
yChartData.setValue("warrior", c);
yChartData.setValue("figh.unit",d);
yChartData.setValue("houses",e);


JFreeChart xChart = ChartFactory.createPieChart((String)jComboBox1.getSelectedItem(), xChartData, true, true, true);
JFreeChart yChart = ChartFactory.createPieChart((String)jComboBox2.getSelectedItem(), yChartData, true, true, true);
// TODO add your handling code here:
PiePlot P=(PiePlot)xChart.getPlot();

PiePlot X=(PiePlot)yChart.getPlot();

//P.setForegroundAlpha(TOP_ALIGNMENT);

ChartFrame frame= new ChartFrame("Pie Chart", yChart);
ChartFrame frame2= new ChartFrame("Pie Chart", xChart);

    frame2.setLocation(500,350);
    frame2.setVisible(true);
    frame2.setSize(450,500);
    
     frame.setLocation(952,350);
    frame.setVisible(true);
    frame.setSize(450,500);
    }//GEN-LAST:event_jPieChartActionPerformed

    private void SerialFightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SerialFightActionPerformed
        // TODO add your handling code here:
        clicktime=3;
        EmpiresAge1 ea2 = new EmpiresAge1();
        ea2.serialSet(this);
        ea2.execute();
    }//GEN-LAST:event_SerialFightActionPerformed

    
    
    
    /**
     * @return This is swing worker class codes 
     */
    
    public JTextArea setresult() {
        
        return jTextArea1;
        
    }
    
     public JTextArea loadtime() {
        
        return jTextArea1;
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ParalelFight;
    private javax.swing.JButton ParalelFight50;
    private javax.swing.JButton ParalelFightOptional;
    private javax.swing.JButton SerialFight;
    private javax.swing.JButton jButton4;
    public javax.swing.JComboBox<String> jComboBox1;
    public javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jPieChart;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    public javax.swing.JTextArea jTextArea1;
    public javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

  

  
  

    
}
