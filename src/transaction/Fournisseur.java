package transaction;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
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

public class Fournisseur extends JPanel{
    private JTextField text_nv, text_des, text_dv, text_mv;
    private JPanel panelButtons, panelA, panelLabels, panelTab, panelComb, panelFourns;
    private JButton creer, enre, qui;
    private JLabel nv, des, dv, mv, ec, welcome;
    
    private JList listeFourn;
    private DefaultListModel listModel1 = new DefaultListModel();    
    private JRadioButton act, ferm, sus;
    private ButtonGroup bg;
    
    public JTextArea text;
    private JTable fournisseurTable;
    private DefaultTableModel TM;
   // ArrayList<ObjetClient> listClient=new ArrayList(); 
    
    
    Fournisseur(){
        panelFourns = new JPanel();
        panelButtons = new JPanel();
        panelLabels = new JPanel();
        panelTab = new JPanel();
        panelComb = new JPanel();
        panelA = new JPanel();
        
       listeFourn = new JList();
    
       
        act = new JRadioButton("Actif");
        ferm = new JRadioButton("Ferme");
        sus = new JRadioButton("Suspendu");
        bg = new ButtonGroup();
        bg.add(act);
        bg.add(ferm);
        bg.add(sus);
       
        creer = new JButton("Creer");
        enre = new JButton("Enregistrer");
        qui = new JButton("Quitter");
        
        nv = new JLabel("No Fournisseur");
        des = new JLabel("Nom Fournisseur");
        dv = new JLabel("Ville");
        mv = new JLabel("Solde");
        ec = new JLabel("Etat Compte");
        
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
        fournisseurTable=new JTable(TM);
        JScrollPane pane=new JScrollPane(fournisseurTable);
        //pane.setPreferredSize(new Dimension(300,200));
        
        panelTab.setLayout(new BorderLayout());
        panelTab.add(pane, BorderLayout.CENTER);
        welcome = new JLabel("");
        panelComb.setLayout(new BorderLayout());
        panelComb.add(welcome, BorderLayout.NORTH);
        panelComb.add(listeFourn, BorderLayout.CENTER);

        creer.addActionListener(new CreerListener());
        qui.addActionListener(new QuitterListener());
        enre.addActionListener(new SaveListener());
    
        ArrayList<ObjetClient> data = new ArrayList<ObjetClient>();
        
        try{
            FileInputStream fis = new FileInputStream("D:\\ProjetJava3\\Fourn.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            data = (ArrayList<ObjetClient>)ois.readObject();
            ois.close();
        }catch(Exception e){}
        
        Iterator it = data.iterator();
        
        while(it.hasNext()){
            listModel1.addElement(it.next().toString());
        }
        listeFourn.setModel(listModel1);
      // exit   
    
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
            FileInputStream fis = new FileInputStream("D:\\ProjetJava3\\Fourn.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            data = (ArrayList<ObjetClient>)ois.readObject();
            ois.close();
        }catch(Exception e){}
        
        data.add(c1);
        try{
            FileOutputStream fos = new FileOutputStream("D:\\ProjetJava3\\Fourn.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(data);
            oos.close();
            
        }catch(Exception e){}
        

            listModel1.addElement(c1.toString());
        
        listeFourn.setModel(listModel1);
        
    }}
    
    private class QuitterListener implements ActionListener{
    public void actionPerformed (ActionEvent event){
        
        
    }}

}