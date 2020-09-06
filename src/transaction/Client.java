package transaction;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Client extends JPanel{
    private JTextField text_nv, text_des, text_dv, text_mv;
    private JPanel panelButtons, panelA, panelLabels, panelTab, panelComb;
    private JButton creer, enre, qui;
    private JLabel nv, des, dv, mv, ec;
    private JRadioButton act, ferm, sus;
    private ButtonGroup bg;
    public JTextArea text;
    private JLabel detv;
    private JTable clientTable;
    private DefaultTableModel TM;
    //ArrayList<ObjetClient> listClient=new ArrayList(); 
    private JList listeClients;
    private DefaultListModel listModel1 = new DefaultListModel();
    private JLabel welcome;
    
    Client(){
        panelButtons = new JPanel();
        panelLabels = new JPanel();
        panelTab = new JPanel();
        panelComb = new JPanel();
        panelA = new JPanel();
        
        welcome = new JLabel();
        
        listeClients = new JList();
        
        creer = new JButton("Creer");
        enre = new JButton("Enregistrer");
        qui = new JButton("Quitter");
        
        nv = new JLabel("No Client");
        des = new JLabel("Nom Client");
        dv = new JLabel("Ville");
        mv = new JLabel("Solde");
        
        ec = new JLabel("Etat Compte");
        
        act = new JRadioButton("Actif");
        ferm = new JRadioButton("Ferme");
        sus = new JRadioButton("Suspendu");
        bg = new ButtonGroup();
        bg.add(act);
        bg.add(ferm);
        bg.add(sus);
        
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
        
        panelLabels.setLayout(new GridLayout(5,2));
        panelLabels.add(nv);
        panelLabels.add(text_nv);
        panelLabels.add(des);
        panelLabels.add(text_des);
        panelLabels.add(dv);
        panelLabels.add(text_dv);
        panelLabels.add(mv);
        panelLabels.add(text_mv);
        panelLabels.add(ec);
        
        JPanel RadioButtons = new JPanel();
        RadioButtons.add(act);
        RadioButtons.add(ferm);
        RadioButtons.add(sus);
        
        panelLabels.add(RadioButtons);
        
        
        
        String [] header={"No Trs","Type Trs","Date Trs","Montant Trs"};
        TM=new DefaultTableModel(header, 20);
        clientTable=new JTable(TM);
        JScrollPane pane=new JScrollPane(clientTable);
        
        panelTab.setLayout(new BorderLayout());
        panelTab.add(pane, BorderLayout.CENTER);
        
        
        panelComb.setLayout(new BorderLayout());
        panelComb.add(welcome, BorderLayout.NORTH);
        panelComb.add(listeClients, BorderLayout.CENTER);
        
        creer.addActionListener(new CreerListener());
        qui.addActionListener(new QuitterListener());
        enre.addActionListener(new SaveListener());
    
        ArrayList<ObjetClient> data = new ArrayList<ObjetClient>();
        
        try{
            FileInputStream fis = new FileInputStream("D:\\ProjetJava3\\Client.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            data = (ArrayList<ObjetClient>)ois.readObject();
            ois.close();
        }catch(Exception e){}
        
        Iterator it = data.iterator();
        
        while(it.hasNext()){
            listModel1.addElement(it.next().toString());
        }
        listeClients.setModel(listModel1);
        
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
        String nc = text_nv.getText();
        String nom = text_des.getText();
        String ville = text_dv.getText();
        String solde = text_mv.getText();
        String ec = "";
        if(bg.isSelected(act.getModel())){
            ec = "Actif";
        };
        if(bg.isSelected(ferm.getModel())){
            ec = "Ferme";
        };
        if(bg.isSelected(sus.getModel())){
            ec = "Suspenduds";
        };
        
        ObjetClient c1 = new ObjetClient(nc, nom, ville, solde, ec);
        
        ArrayList<ObjetClient> data = new ArrayList<ObjetClient>();
        
        try{
            FileInputStream fis = new FileInputStream("D:\\ProjetJava3\\Client.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            data = (ArrayList<ObjetClient>)ois.readObject();
            ois.close();
        }catch(Exception e){}
        
        data.add(c1);
        try{
            FileOutputStream fos = new FileOutputStream("D:\\ProjetJava3\\Client.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(data);
            oos.close();
            
        }catch(Exception e){}
        
            listModel1.addElement(c1.toString());
        
        listeClients.setModel(listModel1);
        
    }}
    
    private class QuitterListener implements ActionListener{
    public void actionPerformed (ActionEvent event){
        
    }}
}