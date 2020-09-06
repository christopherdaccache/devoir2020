package transaction;

import java.awt.BorderLayout;
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

public class Vente extends JPanel{
    private JTextField text_nv, text_des, text_dv, text_mv;
    private JPanel panelButtons, panelA, panelLabels, panelTab, panelComb, panelClients;
    private JButton creer, enre, qui;
    private JLabel nv, des, dv, mv;
    
    public JTextArea text;
    private JLabel detv;
    private JTable venteTable;
    private DefaultTableModel TM;
    ArrayList<ObjetVente> listVente=new ArrayList(); 
    
    private JComboBox client;
    private JLabel labelClient;
    private JList listeVentes;
    private JLabel welcome = new JLabel("");    
    private DefaultListModel listModel1 = new DefaultListModel();
    
    Vente(){
        panelClients = new JPanel();
        panelButtons = new JPanel();
        panelLabels = new JPanel();
        panelTab = new JPanel();
        panelComb = new JPanel();
        panelA = new JPanel();
        
        listeVentes = new JList();
        
        creer = new JButton("Creer");
        enre = new JButton("Enregistrer");
        qui = new JButton("Quitter");
        
        nv = new JLabel("No Vente");
        des = new JLabel("Description");
        dv = new JLabel("Date Vente");
        mv = new JLabel("Montant Vente");
        detv = new JLabel("Details Vente");
        labelClient = new JLabel("Choisir Client");
        
        client = new JComboBox();
        
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
        venteTable=new JTable(TM);
        JScrollPane pane=new JScrollPane(venteTable);
        //pane.setPreferredSize(new Dimension(300,200));
        
        panelTab.setLayout(new BorderLayout());
        panelTab.add(detv, BorderLayout.NORTH);
        panelTab.add(pane, BorderLayout.CENTER);
        
        panelComb.setLayout(new BorderLayout());
        panelClients.add(labelClient);
        panelClients.add(client);
        panelComb.add(panelClients, BorderLayout.NORTH);
        panelComb.add(listeVentes, BorderLayout.CENTER);
        
        
        ArrayList<ObjetClient> dataF = new ArrayList<ObjetClient>();
        
        try{
            FileInputStream fis = new FileInputStream("D:\\ProjetJava3\\Client.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            dataF = (ArrayList<ObjetClient>)ois.readObject();
            ois.close();
        }catch(Exception e){}
        
        Iterator it = dataF.iterator();
        
        
        while(it.hasNext()){
            client.addItem(it.next().toString());
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
        String nc = text_nv.getText();
        String nom = text_des.getText();
        String ville = text_dv.getText();
        String solde = text_mv.getText();
        ObjetVente c1 = new ObjetVente(nc, nom, ville, solde);
        
        ArrayList<ObjetVente> data = new ArrayList<ObjetVente>();
        
        try{
            FileInputStream fis = new FileInputStream("D:\\ProjetJava3\\Vente.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            data = (ArrayList<ObjetVente>)ois.readObject();
            ois.close();
        }catch(Exception e){}
        
        data.add(c1);
        try{
            FileOutputStream fos = new FileOutputStream("D:\\ProjetJava3\\Vente.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(data);
            oos.close();
            
        }catch(Exception e){}
        
        
        listModel1.addElement(c1.toString());
        
        listeVentes.setModel(listModel1);
        
    }}
    
    private class QuitterListener implements ActionListener{
    public void actionPerformed (ActionEvent event){
        
    }}

}