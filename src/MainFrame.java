import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JMenuBar menuBar;

    private JMenu fileMenu;
    private JMenuItem sendMenuItem;
    private JMenuItem saveMenuItem;
    private JMenuItem exitMenuItem;

    private JMenu sendSubMenu;
    private JMenuItem sendEmailItem;
    private JMenuItem sendPriterItem;

    private JMenu editMenu;
    private JMenuItem copyMenuItem;
    private JMenuItem pasteMenuItem;

    private JPanel mainPanel;
    private JLabel mainPanelLabel;
    private JPanel personalDataPanel;
    private JTextField codeField;
    private JTextField nameField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private ButtonGroup group;

    private JPanel cvPanel;
    private JTextArea cvTextArea;

    private JPanel areasPanel;
    private JComboBox interesse, atuacao;

    private JPanel bottomPanel;

    public MainFrame() {
        super("Sample Swing UI");

        // Create and set the menu bar
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        createFileMenu();
        createEditMenu();
        createMainPanel();
        createPersonalDataPanel();
        createCvPanel();
        createAreasPanel();
        createBottomPanel();

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createFileMenu() {
        // Create File menu and its items
        fileMenu = new JMenu("File");
        // Create Send submenu and add it to the File menu
        sendSubMenu = new JMenu("Send");
        fileMenu.add(sendSubMenu);
        sendEmailItem = new JMenuItem("Send Email");
        sendSubMenu.add(sendEmailItem);
        sendPriterItem = new JMenuItem("Send Priter");
        sendSubMenu.add(sendPriterItem);
        saveMenuItem = new JMenuItem("Save");
        fileMenu.add(saveMenuItem);
        exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);
    }

    private void createEditMenu(){
        // Create Edit menu and its items
        editMenu = new JMenu("Edit");
        copyMenuItem = new JMenuItem("Copy");
        editMenu.add(copyMenuItem);
        pasteMenuItem = new JMenuItem("Paste");
        editMenu.add(pasteMenuItem);
        menuBar.add(editMenu);
    }

    private void createMainPanel(){
        // Create enclosing panel and its label
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanelLabel = new JLabel("Ficha de Avaliação");
        mainPanelLabel.setForeground(Color.RED);
        mainPanelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(mainPanelLabel);
        setContentPane(mainPanel);
    }

    private void createPersonalDataPanel(){
        // Create personal data subpanel and its contents
        personalDataPanel = new JPanel();
        personalDataPanel.setLayout(new GridLayout(3,2));
        personalDataPanel.setBorder(BorderFactory.createEtchedBorder());
        JLabel codeLabel = new JLabel("Código:");
        personalDataPanel.add(codeLabel);
        codeField = new JTextField(10);
        personalDataPanel.add(codeField);
        JLabel nameLabel = new JLabel("Nome:");
        personalDataPanel.add(nameLabel);
        nameField = new JTextField(10);
        personalDataPanel.add(nameField);
        JLabel sexLabel = new JLabel("Sexo:");
        personalDataPanel.add(sexLabel);
        maleRadioButton = new JRadioButton("Masculino");
        femaleRadioButton = new JRadioButton("Feminino");
        group = new ButtonGroup();
        group.add(maleRadioButton);
        group.add(femaleRadioButton);
        JPanel sexSubSubPanel = new JPanel();
        sexSubSubPanel.add(maleRadioButton);
        sexSubSubPanel.add(femaleRadioButton);
        personalDataPanel.add(sexSubSubPanel);
        mainPanel.add(personalDataPanel);
    }

    private void createCvPanel(){
        // Create the CV panel and a scrollable text area within it
        cvPanel = new JPanel();
        cvPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        cvPanel.setBorder(BorderFactory.createTitledBorder("Curriculum Vitae"));
        cvTextArea  = new JTextArea("",5,30);
        JScrollPane cvScrollPane = new JScrollPane(cvTextArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        cvPanel.add(cvScrollPane);
        mainPanel.add(cvPanel);
    }

    private void createAreasPanel(){
        areasPanel = new JPanel();
        areasPanel.setLayout(new GridLayout(2,2, 10, 10));
        areasPanel.setBorder(BorderFactory.createTitledBorder("Áreas"));
        String[] interesses = {"Desenvolvedor", "Analista"};
        String[] atuacoes = {"Programação", "Design"};
        interesse = new JComboBox(interesses);
        atuacao = new JComboBox(atuacoes);
        JLabel interesseLabel = new JLabel("Interesse:");
        JLabel atuacaoLabel = new JLabel("Atuacao:");
        areasPanel.add(interesseLabel);
        areasPanel.add(atuacaoLabel);
        areasPanel.add(interesse);
        areasPanel.add(atuacao);
        mainPanel.add(areasPanel);
    }

    private void createBottomPanel(){
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(Color.GREEN);
        JButton saveButton = new JButton("Salvar");
        JButton previousButton = new JButton("Anterior");
        JButton nextButton = new JButton("Próximo");
        JButton newButton = new JButton("Novo");
        JButton cancelButton = new JButton("Cancelar");
        bottomPanel.add(saveButton);
        bottomPanel.add(previousButton);
        bottomPanel.add(nextButton);
        bottomPanel.add(newButton);
        bottomPanel.add(cancelButton);
        mainPanel.add(bottomPanel);
    }
}
