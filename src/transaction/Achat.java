package transaction;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Achat extends JPanel{
    private JTextField text_nv, text_des, text_dv, text_mv;
    private JPanel panelButtons, panelA, panelLabels, panelTab, panelComb, panelFourns;
    private JButton creer, enre, qui;
    private JLabel nv, des, dv, mv;
    
    public JTextArea text;
    private JLabel detv;
    private JTable achatTable;
    private DefaultTableModel TM;
    ArrayList<ObjetAchat> listAchat=new ArrayList(); 
    
    private JComboBox fourn;
    private JLabel labelFourn;
    private JList listeAchats;

    
    private JLabel welcome = new JLabel("");    
    private DefaultListModel listModel1 = new DefaultListModel();
    
    
    Achat(){
        panelFourns = new JPanel();
        panelButtons = new JPanel();
        panelLabels = new JPanel();
        panelTab = new JPanel();
        panelComb = new JPanel();
        panelA = new JPanel();
        
        listeAchats = new JList();
        
        creer = new JButton("Creer");
        enre = new JButton("Enregistrer");
        qui = new JButton("Quitter");
        
        nv = new JLabel("No Achat");
        des = new JLabel("Description");
        dv = new JLabel("Date Achat");
        mv = new JLabel("Montant Achat");
        detv = new JLabel("Details Achat");
        labelFourn = new JLabel("Choisir Fourn");
        
        fourn = new JComboBox();
        
        text_nv = new JTextField();
        text_des = new JTextField();
        text_dv = new JTextField();
        text_mv = new JTextField();
        
        this.setLayout(new BorderLayout());
        this.add(panelA, BorderLayout.WEST);
        this.add(panelComb, BorderLayout.CENTER);
        this.add(panelTab, BorderLayout.SOUTH);
        
        panelA.setLayout(new BorderLayout());
        panelA.add(panelButtons, BorderLayout.NORTH);
        panelA.add(panelLabels, BorderLayout.CENTER);
        
        panelButtons.add(creer);
        panelButtons.add(enre);
        panelButtons.add(qui);
        
        panelLabels.setLayout(new GridLayout(4,2));
        panelLabels.add(nv);
        panelLabels.add(text_nv);
        panelLabels.add(des);
        panelLabels.add(text_des);
        panelLabels.add(dv);
        panelLabels.add(text_dv);
        panelLabels.add(mv);
        panelLabels.add(text_mv);
        
        
        String [] header={"Article","quantite","prix unit","prix total"};
        TM=new DefaultTableModel(header, 20);
        achatTable=new JTable(TM);
        JScrollPane pane=new JScrollPane(achatTable);
        //pane.setPreferredSize(new Dimension(300,200));
        
        panelTab.setLayout(new BorderLayout());
        panelTab.add(detv, BorderLayout.NORTH);
        panelTab.add(pane, BorderLayout.CENTER);
        
        panelComb.setLayout(new BorderLayout());
        panelFourns.add(labelFourn);
        panelFourns.add(fourn);
        panelComb.add(panelFourns, BorderLayout.NORTH);
        panelComb.add(listeAchats, BorderLayout.CENTER);        
        ArrayList<ObjetClient> dataF = new ArrayList<ObjetClient>();
        
        try{
            FileInputStream fis = new FileInputStream("D:\\ProjetJava3\\Fourn.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            dataF = (ArrayList<ObjetClient>)ois.readObject();
            ois.close();
        }catch(Exception e){}
        
        Iterator it = dataF.iterator();
        
        
        while(it.hasNext()){
            fourn.addItem(it.next().toString());
        }
        
        creer.addActionListener(new CreerListener());
        qui.addActionListener(new QuitterListener());
        enre.addActionListener(new SaveListener());

    qui.addActionListener(this::actionPerformed);
}
        
    public void actionPerformed(ActionEvent e) {
		String sActionButton = e.getActionCommand();

		if(sActionButton.equals(this.qui.getText())){
			this.setVisible(false);
			
		}
    }
    
    private class CreerListener implements ActionListener{
    public void actionPerformed (ActionEvent event){
        text_nv.setText("");
        text_des.setText("");
        text_dv.setText("");
        text_mv.setText("");
    }}    
    
    private class SaveListener implements ActionListener{
    public void actionPerformed (ActionEvent event){
        String np = text_nv.getText();
        String desc = text_des.getText();
        String dp = text_dv.getText();
        String mp = text_mv.getText();
    
        String c1 = fourn.getSelectedItem().toString();
        
        ObjetAchat p1 = new ObjetAchat(np, desc, dp, mp, c1);
        
        ArrayList<ObjetAchat> data = new ArrayList<ObjetAchat>();
        
        try{
            FileInputStream fis = new FileInputStream("D:\\ProjetJava3\\Achat.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            data = (ArrayList<ObjetAchat>)ois.readObject();
            ois.close();
        }catch(Exception e){}
        
        data.add(p1);
        try{
            FileOutputStream fos = new FileOutputStream("D:\\ProjetJava3\\Achat.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(data);
            oos.close();
            
        }catch(Exception e){}
        
       
        listModel1.addElement(p1.toString());
        
        listeAchats.setModel(listModel1);
    }}
    
    private class QuitterListener implements ActionListener{
    public void actionPerformed (ActionEvent event){
        
    }}





}