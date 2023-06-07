package Program.Telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import Program.Classes.ClientePF;

public class NovoRegistroPF extends Tela implements ActionListener {

    JButton salvar = new JButton("Salvar", iconSave);
    JButton voltar = new JButton(iconBack);

    JTextField textName = new JTextField();
    JTextField textCPF = new JTextField();
    JTextField textContato = new JTextField();
    JTextField textPedido = new JTextField();

    JLabel labelNome = new JLabel("Nome");
    JLabel labelCPF = new JLabel("CPF");
    JLabel labelContato = new JLabel("Contato");
    JLabel labelPedido = new JLabel("Pedido");

    private String sNome, sCPF, sContato, sPedido;

    public ClientePF clientePF = new ClientePF();

    public NovoRegistroPF() {
        setTitle("Gerenciar Pessoa Física");

        labelNome.setBounds(30, 66, 70, 70);
        labelNome.setForeground(corLabel1);
        labelNome.setVisible(true);
        this.add(labelNome);

        labelCPF.setBounds(30, 100, 70, 70);
        labelCPF.setForeground(corLabel1);
        labelCPF.setVisible(true);
        this.add(labelCPF);

        labelContato.setBounds(30, 134, 70, 70);
        labelContato.setForeground(corLabel1);
        labelContato.setVisible(true);
        this.add(labelContato);

        labelPedido.setBounds(30, 168, 70, 70);
        labelPedido.setForeground(corLabel1);
        labelPedido.setVisible(true);
        this.add(labelPedido);

        textName.setBounds(170, 90, 300, 25);
        textName.setFont(new Font("Arial", Font.ITALIC, 12));
        textName.setToolTipText("Insira o Nome aqui");
        textName.setVisible(true);
        this.add(textName);

        textCPF.setBounds(170, 124, 300, 25);
        textCPF.setFont(new Font("Arial", Font.ITALIC, 12));
        textCPF.setToolTipText("Insira o CPF aqui");
        textCPF.setVisible(true);
        add(textCPF);

        textContato.setBounds(170, 158, 300, 25);
        textContato.setFont(new Font("Arial", Font.ITALIC, 12));
        textContato.setToolTipText("Insira o Contato aqui");
        textContato.setVisible(true);
        this.add(textContato);

        textPedido.setBounds(170, 192, 300, 25);
        textPedido.setFont(new Font("Arial", Font.ITALIC, 12));
        textPedido.setToolTipText("Insira o Pedido aqui");
        textPedido.setVisible(true);
        this.add(textPedido);

        salvar.setVisible(true);
        salvar.setBounds(185, 250, 120, 40);
        salvar.setHorizontalAlignment(SwingConstants.CENTER);
        salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                salvar.setEnabled(false);

                sNome = textName.getText();
                clientePF.setNome(sNome);

                sCPF = textCPF.getText();
                clientePF.setCPF(sCPF);

                sContato = textContato.getText();
                clientePF.setContato(sContato);

                sPedido = textPedido.getText();
                clientePF.setPedido(sPedido);

                new TelaAvisoPF(clientePF);
                NovoRegistroPF.this.dispose();

            }
        });

        this.add(salvar);
        voltar.setBounds(10, 15, 40, 30);
        voltar.addActionListener(this);
        this.add(voltar);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == voltar) {
            this.dispose();
            new NovoRegistro();
        }
    }
}
