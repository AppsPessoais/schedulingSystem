package Program.Telas;

import Program.Classes.ClientePJ;
import Program.ConexãoBD.DAOCliPj;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaTablePJ extends JFrame implements ActionListener {

    JButton voltar = new JButton();
    JButton jbExcluir = new JButton("Excluir");
    JButton jbAlterar = new JButton("Alterar");
    JTable table;

    public ImageIcon iconSave = new ImageIcon("Images/save.png");
    public ImageIcon iconPF = new ImageIcon("Images/PF.png");
    public ImageIcon iconPJ = new ImageIcon("Images/PJ.png");
    public ImageIcon iconBack = new ImageIcon("Images/voltar.png");
    public ImageIcon icone = new ImageIcon("Images/iconePrincipal.png");
    public ImageIcon iconAlterar = new ImageIcon("Images/alterar.png");

    public Color corFundo1 = new Color(27, 38, 44);
    public Color corPanel = new Color(15, 76, 117);
    public Color corLabel1 = new Color(187, 225, 250);
    public Color corLabel2 = new Color(200, 200, 200);
    public ImageIcon iconCancel = new ImageIcon("Images/cancel.png");

    public TelaTablePJ() {
        setTitle("Resultado da Busca");
        setIconImage(icone.getImage());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(corFundo1);
        setSize(1000, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(corPanel);
        panel.setVisible(true);
        panel.setBounds(0, 0, 60, 1000);
        this.add(panel);

        voltar.setIcon(iconBack);
        voltar.setBounds(10, 15, 40, 30);
        voltar.addActionListener(this);
        this.add(voltar);

        jbExcluir.setBounds(850, 405, 110, 30);
        jbExcluir.setHorizontalTextPosition(SwingConstants.LEFT);
        jbExcluir.addActionListener(this);
        jbExcluir.setIcon(iconCancel);

        this.add(jbExcluir);

        jbAlterar.setBounds(730, 405, 110, 30);
        jbAlterar.setIcon(iconAlterar);
        jbAlterar.setAlignmentX(LEFT_ALIGNMENT);
        jbAlterar.addActionListener(this);
        add(jbAlterar);

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Razão Social");
        model.addColumn("CNPJ");
        model.addColumn("Email");
        model.addColumn("Contato");
        model.addColumn("Responsável");
        model.addColumn("Endereço");

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(75, 55, 900, 340);
        scrollPane.setAutoscrolls(true);

        add(scrollPane);

        DAOCliPj daoCPJ = new DAOCliPj();
        List<ClientePJ> clientes = daoCPJ.lista();
        for (ClientePJ cliente : clientes) {
            Object[] rowData = new Object[6];
            rowData[0] = cliente.getRazao();
            rowData[1] = cliente.getCnpj();
            rowData[2] = cliente.getEmail();
            rowData[3] = cliente.getContato();
            rowData[4] = cliente.getResponsavel();
            rowData[5] = cliente.getEndereco();
            model.addRow(rowData);
        }
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == voltar) {
            this.dispose();
            new Manuntencao();
        } else if (e.getSource() == jbExcluir) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(selectedRow);

                DAOCliPj daoCPJ = new DAOCliPj();
                List<ClientePJ> clientes = daoCPJ.lista();
                ClientePJ cliente = clientes.get(selectedRow);
                daoCPJ.excluir(cliente);
            }
        } else if (e.getSource() == jbAlterar) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                DAOCliPj daoCPJ = new DAOCliPj();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                ClientePJ cliente = new ClientePJ();
                cliente.setRazao((String) model.getValueAt(selectedRow, 0));
                cliente.setCnpj((String) model.getValueAt(selectedRow, 1));
                cliente.setEmail((String) model.getValueAt(selectedRow, 2));
                cliente.setContato((String) model.getValueAt(selectedRow, 3));
                cliente.setResponsavel((String) model.getValueAt(selectedRow, 4));
                cliente.setEndereco((String) model.getValueAt(selectedRow, 5));

                TelaAlteracaoPJ telaAlteracao = new TelaAlteracaoPJ(cliente);
                telaAlteracao.setVisible(true);
                telaAlteracao.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                        if (telaAlteracao.isSaved()) {
                            ClientePJ clienteAlterado = telaAlteracao.getCliente();
                            daoCPJ.altera(clienteAlterado, cliente.getRazao());

                            model.setValueAt(clienteAlterado.getRazao(), selectedRow, 0);
                            model.setValueAt(clienteAlterado.getCnpj(), selectedRow, 1);
                            model.setValueAt(clienteAlterado.getEmail(), selectedRow, 2);
                            model.setValueAt(clienteAlterado.getContato(), selectedRow, 3);
                            model.setValueAt(clienteAlterado.getResponsavel(), selectedRow, 4);
                            model.setValueAt(clienteAlterado.getEndereco(), selectedRow, 5);
                        }
                    }
                });
            }
        }
    }
}