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
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class paiement extends JPanel{
    private JTextField text_nv, text_des, text_dv, text_mv;
    private JPanel panelButtons, panelA, panelLabels, panelTab, panelComb, panelFourns;
    private JButton creer, enre, qui;
    private JLabel nv, des, dv, mv;
    private JRadioButton cash,cheque,transfert;
    private ButtonGroup bg;

    
    public JTextArea text;
    private JLabel detv;
    private JTable paieTable;
    private DefaultTableModel TM;
    private JLabel welcome = new JLabel("");
    
    private JComboBox fourn;
    private JLabel labelFourn;
    private JList listePaies;
    
    private DefaultListModel listModel1 = new DefaultListModel();
    
    paiement(){
        panelFourns = new JPanel();
        panelButtons = new JPanel();
        panelLabels = new JPanel();
        panelTab = new JPanel();
        panelComb = new JPanel();
        panelA = new JPanel();
    
        bg = new ButtonGroup();
    
        cash = new JRadioButton("Cash");
        cheque = new JRadioButton("Cheque");
        transfert = new JRadioButton("Transfert");
        bg = new ButtonGroup();
        bg.add(cash);
        bg.add(cheque);
        bg.add(transfert);
    
        
        
        listePaies = new JList();
        
        creer = new JButton("Creer");
        enre = new JButton("Enregistrer");
        qui = new JButton("Quitter");
        
        nv = new JLabel("No Paiement");
        des = new JLabel("Description");
        dv = new JLabel("Date Paiement");
        mv = new JLabel("Montant Paiement");
        detv = new JLabel("Details Paiement");
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
        
        panelLabels.setLayout(new GridLayout(5,2));
        panelLabels.add(nv);
        panelLabels.add(text_nv);
     
        panelLabels.add(des);
        panelLabels.add(text_des);
        
        panelLabels.add(dv);
        panelLabels.add(text_dv);
        
        panelLabels.add(mv);
        panelLabels.add(text_mv);
        
        JLabel ec = new JLabel("mode paiment");
        panelLabels.add(ec);
        
        JPanel RB = new JPanel();
        RB.add(cash);
        RB.add(cheque);
        RB.add(transfert);
        
        panelLabels.add(RB);
      
        panelComb.setLayout(new BorderLayout());
        panelFourns.add(labelFourn);
        panelFourns.add(fourn);
        panelComb.add(panelFourns, BorderLayout.NORTH);
        panelComb.add(listePaies, BorderLayout.CENTER);
        
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
        String ec = "";
        if(bg.isSelected(cash.getModel())){
            ec = "Cash";
        };
        if(bg.isSelected(cheque.getModel())){
            ec = "Cheque";
        };
        if(bg.isSelected(transfert.getModel())){
            ec = "Transfert";
        };
        
        String c1 = fourn.getSelectedItem().toString();
        
        ObjetPaie p1 = new ObjetPaie(np, desc, dp, mp, ec, c1);
        
        ArrayList<ObjetPaie> data = new ArrayList<ObjetPaie>();
        
        try{
            FileInputStream fis = new FileInputStream("D:\\ProjetJava3\\Paie.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            data = (ArrayList<ObjetPaie>)ois.readObject();
            ois.close();
        }catch(Exception e){}
        
        data.add(p1);
        try{
            FileOutputStream fos = new FileOutputStream("D:\\ProjetJava3\\Paie.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(data);
            oos.close();
            
        }catch(Exception e){}
        
       
        listModel1.addElement(p1.toString());
        
        listePaies.setModel(listModel1);
    }}
    
    private class QuitterListener implements ActionListener{
    public void actionPerformed (ActionEvent event){
        
    }}



}