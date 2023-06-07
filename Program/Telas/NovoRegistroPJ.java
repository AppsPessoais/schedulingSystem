package Program.Telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Program.Classes.ClientePJ;

public class NovoRegistroPJ extends Tela implements ActionListener {
    JButton voltar = new JButton();
    JButton salvar = new JButton("Salvar");
    JTextField jtfRazao = new JTextField();
    JTextField jtfCnpj = new JTextField();
    JTextField jtfEmail = new JTextField();
    JTextField jtfContato = new JTextField();
    JTextField jtfResponsavelLegal = new JTextField();
    JTextField jtfEndereco = new JTextField();
    private String sRazao, sCnpj, sEmail, sContato, sResponsavelLegal, sEndereco;
    public ClientePJ clientePJ = new ClientePJ();

    public NovoRegistroPJ() {
        this.setTitle("Cadastro Pessoa Jurídica");
        setIconImage(icone.getImage());
        setResizable(false);

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(31, 42, 51));
        panel2.setVisible(true);
        panel2.setBounds(0, 320, 1000, 40);
        this.add(panel2);

        JLabel lRazao = new JLabel();
        lRazao.setText("Razão Social:");
        lRazao.setBounds(30, 66, 300, 70);
        lRazao.setForeground(corLabel1);
        this.add(lRazao);

        jtfRazao.setBounds(170, 90, 300, 25);
        jtfRazao.setFont(new Font("Arial", Font.ITALIC, 12));
        jtfRazao.setToolTipText("Insira a razão social aqui");
        jtfRazao.addActionListener(this);
        this.add(jtfRazao);

        JLabel lCnpj = new JLabel();
        lCnpj.setText("CNPJ:");
        lCnpj.setBounds(30, 100, 120, 70);
        lCnpj.setForeground(corLabel1);
        this.add(lCnpj);

        jtfCnpj.setBounds(170, 124, 300, 25);
        jtfCnpj.setFont(new Font("Arial", Font.ITALIC, 12));
        jtfCnpj.setToolTipText("Insira o CNPJ aqui");
        jtfCnpj.addActionListener(this);
        this.add(jtfCnpj);

        JLabel lEmail = new JLabel();
        lEmail.setText("E-mail:");
        lEmail.setBounds(30, 130, 120, 70);
        lEmail.setForeground(corLabel1);
        this.add(lEmail);

        jtfEmail.setBounds(170, 158, 300, 25);
        jtfEmail.setFont(new Font("Arial", Font.ITALIC, 12));
        jtfEmail.setToolTipText("Insira o email aqui");
        jtfEmail.addActionListener(this);
        this.add(jtfEmail);

        JLabel lContato = new JLabel();
        lContato.setText("Contato:");
        lContato.setBounds(30, 168, 120, 70);
        lContato.setForeground(corLabel1);
        this.add(lContato);

        jtfContato.setBounds(170, 192, 300, 25);
        jtfContato.setFont(new Font("Arial", Font.ITALIC, 12));
        jtfContato.setToolTipText("Insira o contato aqui");
        jtfContato.addActionListener(this);
        this.add(jtfContato);

        JLabel lResponsavelLegal = new JLabel();
        lResponsavelLegal.setText("Responsável legal:");
        lResponsavelLegal.setBounds(30, 202, 300, 70);
        lResponsavelLegal.setForeground(corLabel1);
        this.add(lResponsavelLegal);

        jtfResponsavelLegal.setBounds(170, 226, 300, 25);
        jtfResponsavelLegal.setFont(new Font("Arial", Font.ITALIC, 12));
        jtfResponsavelLegal.setToolTipText("Insira o Responsável legal aqui");
        jtfResponsavelLegal.addActionListener(this);
        this.add(jtfResponsavelLegal);

        JLabel lEndereco = new JLabel();
        lEndereco.setText("Endereço:");
        lEndereco.setBounds(30, 238, 300, 70);
        lEndereco.setForeground(corLabel1);
        this.add(lEndereco);

        jtfEndereco.setBounds(170, 260, 300, 25);
        jtfEndereco.setFont(new Font("Arial", Font.ITALIC, 12));
        jtfEndereco.setToolTipText("Insira o Endereço aqui");
        jtfEndereco.addActionListener(this);
        this.add(jtfEndereco);

        voltar.setIcon(iconBack);
        voltar.setBounds(10, 15, 40, 30);
        voltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NovoRegistroPJ.this.dispose();
                new NovoRegistro();
            }
        });

        this.add(voltar);

        salvar.setVisible(true);
        salvar.setBounds(60, 290, 90, 20);
        salvar.setIcon(iconSave);
        salvar.setHorizontalAlignment(SwingConstants.CENTER);
        salvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvar.setEnabled(false);

                sRazao = jtfRazao.getText();
                clientePJ.setRazao(sRazao);

                sCnpj = jtfCnpj.getText();
                clientePJ.setCnpj(sCnpj);

                sEmail = jtfEmail.getText();
                clientePJ.setEmail(sEmail);

                sContato = jtfContato.getText();
                clientePJ.setContato(sContato);

                sResponsavelLegal = jtfResponsavelLegal.getText();
                clientePJ.setResponsavel(sResponsavelLegal);

                sEndereco = jtfEndereco.getText();
                clientePJ.setEndereco(sEndereco);

                NovoRegistroPJ.this.dispose();
                new TelaAvisoPJ(clientePJ);
            }
        });
        this.add(salvar);
    }

    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
