package transaction;

import java.awt.BorderLayout;

import java.awt.event.*;

import javax.swing.*;

public class ProjectTrans extends JFrame{

        private JFrame frame;
        private JMenuBar mbar;
        private JMenu Transactions,Comptes,Stock,Outils,Quitter,Ventes,Achats,Recus,Paiements,Clients,Fournisseurs,Articles;
        private JMenuItem Villes, a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,ca,vers,qui,cdd,ssd;
        
        Vente vente;
        Achat achat;
        paiement paie;
        Client client;
        Fournisseur fournisseur;
        Recu recu;
        Categorie CA;
//        rapportVente rapportVente;
        /*Article article;
RapportsVente rv;
RapportAchat ra;
RapportRecu rr;
RapportPaiement rp;
RapportClient rc;
RapportFournisseur rf;
RapportArticle rA;
*/
    public ProjectTrans(){
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());
            mbar=new JMenuBar();
            frame=new JFrame("Gestion de transactions commerciales");
            Transactions=new JMenu("Transactions"); 
            Ventes =new JMenu("Ventes ");
            Achats  =new JMenu("Achats ");
            Stock=new JMenu("Stock");
            Paiements=new JMenu("Paiements ");
            Comptes=new JMenu("Comptes");
            Clients=new JMenu("Clients");
            Fournisseurs=new JMenu("Fournisseurs");
            Villes=new JMenuItem("Villes");
            Articles=new JMenu("Articles");
            ca=new JMenuItem("Categories Articles");
            cdd=new JMenuItem("Charger du disque");
            ssd=new JMenuItem("Sauvegarder du disque");
            vers=new JMenuItem("Version");
            Recus=new JMenu("Recu");      
            Outils=new JMenu("Outils");
            Quitter=new JMenu("Quitter");
            qui=new JMenuItem("Quitter");
              
           a1 =new JMenuItem(" Creer/Modifier Vente");
           a2=new JMenuItem(" Rapports Vente");
           a3 =new JMenuItem(" Creer/Modifier Achat");
           a4 =new JMenuItem("Rapports");
           a5 =new JMenuItem(" Creer/Modifier Recu");
           a6 =new JMenuItem(" Rapports");
           a7 =new JMenuItem(" Creer/Modifier Paiement");
           a8 =new JMenuItem(" Rapports");
           a9 =new JMenuItem(" Creer/Modifier Clients");
           a10 =new JMenuItem("Rapports");
           a11 =new JMenuItem(" Creer/Modifier Fournisseurs");
           a12 =new JMenuItem("Rapports ");
           a13=new JMenuItem(" Creer/Modifier Articles");
           a14 =new JMenuItem("Rapports");


            Transactions.add(Ventes);
            Transactions.add(Achats);
            Transactions.add(Recus);
            Transactions.add(Paiements);
            Ventes.add(a1);
            Ventes.add(a2);
            Achats.add(a3);
            Achats.add(a4);
            Recus.add(a5);
            Recus.add(a6);
            Paiements.add(a7);
            Paiements.add(a8);
mbar.add(Transactions);
setJMenuBar(mbar);
Comptes.add(Clients);
Comptes.add(Fournisseurs);
Comptes.add(Villes);

Clients.add(a9);
Clients.add(a10);
Fournisseurs.add(a11);
Fournisseurs.add(a12);
Stock.add(Articles);
Stock.add(ca);
Articles.add(a13);
Articles.add(a14);
Outils.add(cdd);
Outils.add(ssd);
Quitter.add(vers);
Quitter.add(qui);
mbar.add(Transactions);
mbar.add(Comptes);
mbar.add(Stock);
mbar.add(Outils);
mbar.add(Quitter);
frame.setJMenuBar(mbar);
frame.setSize(700,700);
frame.setVisible(true);

        a1.addActionListener(new MenuListener());
        a2.addActionListener(new MenuListener());
        
        a3.addActionListener(new MenuListener());
       a4.addActionListener(new MenuListener());
        
        a5.addActionListener(new MenuListener());
        a6.addActionListener(new MenuListener());
        
        a7.addActionListener(new MenuListener());
       a8.addActionListener(new MenuListener());
        
        a9.addActionListener(new MenuListener());
      a10.addActionListener(new MenuListener());
        
        a11.addActionListener(new MenuListener());
       a12.addActionListener(new MenuListener());
        
        a13.addActionListener(new MenuListener());
        a14.addActionListener(new MenuListener());
        ca.addActionListener(new MenuListener());
       qui.addActionListener(new MenuListener());
        vente = new Vente();
        
        achat = new Achat();
        paie= new paiement();

        client = new Client();
        fournisseur = new Fournisseur();
        recu = new Recu();
        
        CA = new Categorie();
   
qui.addActionListener(this::actionPerformed);
    }
        
    public void actionPerformed(ActionEvent e) {
		String sActionButton = e.getActionCommand();

		if(sActionButton.equals(this.qui.getText())){
			this.mbar.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			this.dispose();
			System.exit(0);
		}
    }
    
    private class MenuListener implements ActionListener{
    public void actionPerformed (ActionEvent event){
        JMenuItem obj = (JMenuItem)event.getSource();
        String menu_name = obj.getText();
        
        if(menu_name.equals(" Creer/Modifier Vente")){
            frame.getContentPane().removeAll();
            frame.getContentPane().add(vente);
            frame.revalidate();
            frame.repaint();
        }
        
        
        if (menu_name.equals(" Creer/Modifier Achat")){
            
            frame.getContentPane().removeAll();
            frame.getContentPane().add(achat);
            frame.revalidate();
            frame.repaint();
            
        }
        
       if(menu_name.equals(" Creer/Modifier Paiement")){
                frame.getContentPane().removeAll();
            frame.getContentPane().add(paie);
            frame.revalidate();
            frame.repaint();
        }
        
        if(menu_name.equals(" Creer/Modifier Clients")){
            frame.getContentPane().removeAll();
            frame.getContentPane().add(client);
            frame.revalidate();
            frame.repaint();
        }
        
         if(menu_name.equals(" Creer/Modifier Fournisseurs")){
            frame.getContentPane().removeAll();
            frame.getContentPane().add(fournisseur);
            frame.revalidate();
            frame.repaint();
        }
         
        if(menu_name.equals(" Creer/Modifier Recu")){
            frame.getContentPane().removeAll();
            frame.getContentPane().add(recu);
            frame.revalidate();
            frame.repaint();
        }
        
        if(menu_name.equals("Categories Articles")){
            frame.getContentPane().removeAll();
            frame.getContentPane().add(CA);
            frame.revalidate();
            frame.repaint();
        }
        
        if(menu_name.equals(" Rapports Vente")){
            frame.getContentPane().removeAll();
//            frame.getContentPane().add(rapportVente);
            frame.revalidate();
            frame.repaint();
        }
         
       /* if(ob == a7){
            paie.setVisible(true);
            vente.setVisible(false);
                        recu.setVisible(false);
            client.setVisible(false);
            article.setVisible(false);
            forn.setVisible(false);
            CA.setVisible(false);
            achat.setVisible(false);
            frame.revalidate();
            frame.repaint();
        }
        
        
        
        if(ob == a9){
          client.setVisible(true);
            vente.setVisible(false);
                        paie.setVisible(false);
            recu.setVisible(false);
            article.setVisible(false);
            forn.setVisible(false);
            CA.setVisible(false);
            achat.setVisible(false);
            frame.revalidate();
            frame.repaint();
        new Client();
        
        }
        
        if(ob == a11){
          forn.setVisible(true);
            vente.setVisible(false);
                        paie.setVisible(false);
            recu.setVisible(false);
            article.setVisible(false);
            client.setVisible(false);
            CA.setVisible(false);
            achat.setVisible(false);
            frame.revalidate();
            frame.repaint();
        }
           
        if (ob == a13){
          article.setVisible(true);
            vente.setVisible(false);
                        paie.setVisible(false);
            recu.setVisible(false);
            client.setVisible(false);
            forn.setVisible(false);
            CA.setVisible(false);
            achat.setVisible(false);
            frame.revalidate();
            frame.repaint();
        }
        
        if(ob == ca){
              CA.setVisible(true);
            vente.setVisible(false);
                        paie.setVisible(false);
            recu.setVisible(false);
            client.setVisible(false);
            forn.setVisible(false);
            article.setVisible(false);
            achat.setVisible(false);
            frame.revalidate();
            frame.repaint();
        }
    }
    
        
    /*   if(ob == a2){
            RapportsVente rv = new RapportsVente(frame);
        }
        
        if (ob == a4){
            RapportsAchat ra = new RapportsAchat(frame);
        }
        
        if(ob == a6){
            RapportsRecu rr = new RapportsRecu(frame);
        }
        
        if(ob == a8){
            RapportsPaiement rp = new RapportsPaiement(frame);
        }
        
        if (ob == a10){
            RapportsClient rc = new RapportsClient(frame);
        }
        
        if (ob ==a12){
            RapportsFournisseur rf = new RapportsFournisseur(frame);
        }
        
        if(ob == a14){
            RapportArticle ra = new RapportArticle(frame);
        }*/
        
    }
    }

        
    public static void main(String[] args) {
        new ProjectTrans();
    }
    
}