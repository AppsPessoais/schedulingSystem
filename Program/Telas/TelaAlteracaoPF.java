package Program.Telas;

import Program.Classes.ClientePF;
import Program.ConexãoBD.DAOCliPf;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAlteracaoPF extends JFrame implements ActionListener {

    public Color corFundo1 = new Color(27, 38, 44);
    public Color corPanel = new Color(15, 76, 117);
    public Color corLabel1 = new Color(187, 225, 250);
    public Color corLabel2 = new Color(200, 200, 200);

    public ImageIcon icone = new ImageIcon("Images/iconePrincipal.png");
    public ImageIcon iconCancel = new ImageIcon("Images/cancel2.png");
    public ImageIcon iconEnviar = new ImageIcon("Images/enviar-bd.png");
    public Color branco = new Color(255, 255, 255);

    private ClientePF cliente;
    private boolean isSaved;
    private DAOCliPf dao;

    public String antigoCpf;

    private JTextField tfNome;
    private JTextField tfCpf;
    private JTextField tfContato;
    private JTextField tfPedido;

    private JButton btnSalvar;
    private JButton btnCancelar;

    public TelaAlteracaoPF(ClientePF cliente) {
        this.cliente = cliente;
        this.isSaved = false;
        this.dao = new DAOCliPf();
        antigoCpf = cliente.getCPF();

        setTitle("Alterar Cliente PF");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(corFundo1);
        setSize(400, 300);

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(31, 42, 51));
        panel2.setVisible(true);
        panel2.setBounds(0, 320, 1000, 40);
        this.add(panel2);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setForeground(branco);
        lblNome.setBounds(20, 20, 100, 20);
        add(lblNome);

        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setForeground(branco);
        lblCpf.setBounds(20, 50, 100, 20);
        add(lblCpf);

        JLabel lblContato = new JLabel("Contato:");
        lblContato.setForeground(branco);
        lblContato.setBounds(20, 80, 100, 20);
        add(lblContato);

        JLabel lblPedido = new JLabel("Pedido:");
        lblPedido.setForeground(branco);
        lblPedido.setBounds(20, 110, 100, 20);
        add(lblPedido);

        tfNome = new JTextField(cliente.getNome());
        tfNome.setBounds(130, 20, 200, 20);
        add(tfNome);

        tfCpf = new JTextField(cliente.getCPF());
        tfCpf.setBounds(130, 50, 200, 20);
        add(tfCpf);

        tfContato = new JTextField(cliente.getContato());
        tfContato.setBounds(130, 80, 200, 20);
        add(tfContato);

        tfPedido = new JTextField(cliente.getPedido());
        tfPedido.setBounds(130, 110, 200, 20);
        add(tfPedido);

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

    public ClientePF getCliente() {
        cliente.setNome(tfNome.getText());
        cliente.setCPF(tfCpf.getText());
        cliente.setContato(tfContato.getText());
        cliente.setPedido(tfPedido.getText());

        return cliente;
    }

    public boolean isSaved() {
        return isSaved;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSalvar) {
            ClientePF clienteAlterado = getCliente();
            dao.altera(clienteAlterado, antigoCpf);
            isSaved = true;
            dispose();
        } else if (e.getSource() == btnCancelar) {
            dispose();
        }
    }
}
