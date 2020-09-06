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

public class Categorie extends JPanel{
    private JTextField text_nc, text_nom;
    private JPanel panelButtons, panelA, panelLabels, panelTab, panelComb;
    private JButton creer, enre, qui;
    private JLabel nc, nom, article;
    public JTextArea text;
    private JTable clientTable;
    private DefaultTableModel TM; 
    private JList listeCategories;
    private DefaultListModel listModel1 = new DefaultListModel();
    private JLabel welcome;
    
    Categorie(){
        panelButtons = new JPanel();
        panelLabels = new JPanel();
        panelTab = new JPanel();
        panelComb = new JPanel();
        panelA = new JPanel();
        
        welcome = new JLabel();
        
        listeCategories = new JList();
        
        creer = new JButton("Creer");
        enre = new JButton("Enregistrer");
        qui = new JButton("Quitter");
        
        nc = new JLabel("No Categorie");
        nom = new JLabel("Nom Categorie");
        
        article = new JLabel("Article");
        
        text_nc = new JTextField();
        text_nom = new JTextField();
        
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
        
        panelLabels.setLayout(new GridLayout(2,2));
        panelLabels.add(nc);
        panelLabels.add(text_nc);
        panelLabels.add(nom);
        panelLabels.add(text_nom);
        
        
        String [] header={"No Article","Nom Article","Qte Stock","Prix Vente", "Cout Achat", "Profit"};
        TM=new DefaultTableModel(header, 20);
        clientTable=new JTable(TM);
        JScrollPane pane=new JScrollPane(clientTable);
        
        panelTab.setLayout(new BorderLayout());
        panelTab.add(article,BorderLayout.NORTH);
        panelTab.add(pane, BorderLayout.CENTER);
        
        
        panelComb.setLayout(new BorderLayout());
        panelComb.add(welcome, BorderLayout.NORTH);
        panelComb.add(listeCategories, BorderLayout.CENTER);
        
        creer.addActionListener(new CreerListener());
        qui.addActionListener(new QuitterListener());
        enre.addActionListener(new SaveListener());
    
        ArrayList<ObjetCategorie> data = new ArrayList<ObjetCategorie>();
        
        try{
            FileInputStream fis = new FileInputStream("D:\\ProjetJava3\\Categorie.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            data = (ArrayList<ObjetCategorie>)ois.readObject();
            ois.close();
        }catch(Exception e){}
        
        Iterator it = data.iterator();
        
        while(it.hasNext()){
            listModel1.addElement(it.next().toString());
        }
        listeCategories.setModel(listModel1);
        
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
        text_nc.setText("");
        text_nom.setText("");
    }}    
    
    private class SaveListener implements ActionListener{
    public void actionPerformed (ActionEvent event){
        String nc = text_nc.getText();
        String nom = text_nom.getText();
        
        ObjetCategorie c1 = new ObjetCategorie(nc, nom);
        
        ArrayList<ObjetCategorie> data = new ArrayList<ObjetCategorie>();
        
        try{
            FileInputStream fis = new FileInputStream("D:\\ProjetJava3\\Categorie.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            data = (ArrayList<ObjetCategorie>)ois.readObject();
            ois.close();
        }catch(Exception e){}
        
        data.add(c1);
        try{
            FileOutputStream fos = new FileOutputStream("D:\\ProjetJava3\\Categorie.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(data);
            oos.close();
            
        }catch(Exception e){}
        

            listModel1.addElement(c1.toString());
        
        listeCategories.setModel(listModel1);
        
    }}
    
    private class QuitterListener implements ActionListener{
    public void actionPerformed (ActionEvent event){
        
    }}
}