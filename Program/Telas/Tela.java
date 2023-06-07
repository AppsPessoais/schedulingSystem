package Program.Telas;

import java.awt.*;

import javax.swing.*;

public class Tela extends JFrame {

    public ImageIcon iconInsert = new ImageIcon("Images/insert.png");
    public ImageIcon iconConfig = new ImageIcon("Images/config.png");
    public ImageIcon iconCancel = new ImageIcon("Images/cancel.png");
    public ImageIcon iconSave = new ImageIcon("Images/save.png");
    public ImageIcon iconPF = new ImageIcon("Images/PF.png");
    public ImageIcon iconPJ = new ImageIcon("Images/PJ.png");
    public ImageIcon iconBack = new ImageIcon("Images/voltar.png");
    public ImageIcon iconLupa = new ImageIcon("Images/Lupa.png");
    public ImageIcon icone = new ImageIcon("Images/iconePrincipal.png");;

    public Color corFundo1 = new Color(27, 38, 44);
    public Color corPanel = new Color(15, 76, 117);
    public Color corLabel1 = new Color(187, 225, 250);
    public Color corLabel2 = new Color(200, 200, 200);

    public Tela() {
        setIconImage(icone.getImage());
        setTitle("");
        setVisible(true);
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(corFundo1);

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(31, 42, 51));
        panel2.setVisible(true);
        panel2.setBounds(0, 320, 1000, 40);
        this.add(panel2);

    }

}