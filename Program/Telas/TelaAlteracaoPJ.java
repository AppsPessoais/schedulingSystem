package Program.Telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Program.Classes.ClientePJ;
import Program.ConexãoBD.DAOCliPj;

public class TelaAlteracaoPJ extends JFrame implements ActionListener {

    public Color corFundo1 = new Color(27, 38, 44);
    public Color corPanel = new Color(15, 76, 117);
    public Color corLabel1 = new Color(187, 225, 250);
    public Color corLabel2 = new Color(200, 200, 200);
    public Color branco = new Color(255, 255, 255);

    public ImageIcon icone = new ImageIcon("Images/iconePrincipal.png");
    public ImageIcon iconCancel = new ImageIcon("Images/cancel2.png");
    public ImageIcon iconEnviar = new ImageIcon("Images/enviar-bd.png");

    private ClientePJ cliente;
    private boolean isSaved;
    private DAOCliPj dao;

    public String antigoCnpj;

    private JTextField tfRazao;
    private JTextField tfCnpj;
    private JTextField tfEmail;
    private JTextField tfContato;
    private JTextField tfResponsavel;
    private JTextField tfEndereco;

    private JButton btnSalvar;
    private JButton btnCancelar;

    public TelaAlteracaoPJ(ClientePJ cliente) {
        this.cliente = cliente;
        this.isSaved = false;
        this.dao = new DAOCliPj();
        antigoCnpj = cliente.getCnpj();

        setTitle("Alterar Cliente PJ");
        setIconImage(icone.getImage());
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(corFundo1);
        setSize(400, 300);

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(31, 42, 51));
        panel2.setVisible(true);
        panel2.setBounds(0, 320, 1000, 40);
        this.add(panel2);

        JLabel lblRazao = new JLabel("Razão Social:");
        lblRazao.setForeground(branco);
        lblRazao.setBounds(20, 20, 100, 20);
        add(lblRazao);

        JLabel lblCnpj = new JLabel("CNPJ:");
        lblCnpj.setBounds(20, 50, 100, 20);
        lblCnpj.setForeground(branco);
        add(lblCnpj);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(20, 80, 100, 20);
        lblEmail.setForeground(branco);
        add(lblEmail);

        JLabel lblContato = new JLabel("Contato:");
        lblContato.setForeground(branco);
        lblContato.setBounds(20, 110, 100, 20);
        add(lblContato);

        JLabel lblResponsavel = new JLabel("Responsável:");
        lblResponsavel.setForeground(branco);
        lblResponsavel.setBounds(20, 140, 100, 20);
        add(lblResponsavel);

        JLabel lblEndereco = new JLabel("Endereço:");
        lblEndereco.setForeground(branco);
        lblEndereco.setBounds(20, 170, 100, 20);
        add(lblEndereco);

        tfRazao = new JTextField(cliente.getRazao());
        tfRazao.setBounds(130, 20, 200, 20);
        add(tfRazao);

        tfCnpj = new JTextField(cliente.getCnpj());
        tfCnpj.setBounds(130, 50, 200, 20);
        add(tfCnpj);

        tfEmail = new JTextField(cliente.getEmail());
        tfEmail.setBounds(130, 80, 200, 20);
        add(tfEmail);

        tfContato = new JTextField(cliente.getContato());
        tfContato.setBounds(130, 110, 200, 20);
        add(tfContato);

        tfResponsavel = new JTextField(cliente.getResponsavel());
        tfResponsavel.setBounds(130, 140, 200, 20);
        add(tfResponsavel);

        tfEndereco = new JTextField(cliente.getEndereco());
        tfEndereco.setBounds(130, 170, 200, 20);
        add(tfEndereco);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(214, 190, 115, 30);
        btnSalvar.setBackground(new Color(6, 185, 57));
        btnSalvar.addActionListener(this);
        btnSalvar.setIcon(iconEnviar);
        add(btnSalvar);

        btnCancelar = new JButton("");
        btnCancelar.setBounds(170, 190, 40, 30);
        btnCancelar.setIcon(iconCancel);
        btnCancelar.setBackground(new Color(245, 250, 250));
        btnCancelar.addActionListener(this);
        add(btnCancelar);
    }

    public ClientePJ getCliente() {
        cliente.setRazao(tfRazao.getText());
        cliente.setCnpj(tfCnpj.getText());
        cliente.setEmail(tfEmail.getText());
        cliente.setContato(tfContato.getText());
        cliente.setResponsavel(tfResponsavel.getText());
        cliente.setEndereco(tfEndereco.getText());

        return cliente;
    }

    public boolean isSaved() {
        return isSaved;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSalvar) {
            ClientePJ clienteAlterado = getCliente();
            dao.altera(clienteAlterado, antigoCnpj);
            isSaved = true;
            dispose();
        } else if (e.getSource() == btnCancelar) {
            dispose();
        }
    }
}
