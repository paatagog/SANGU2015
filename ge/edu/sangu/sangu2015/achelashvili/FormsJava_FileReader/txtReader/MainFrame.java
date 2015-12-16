package ge.edu.sangu.sangu2015.achelashvili.FormsJava_FileReader.txtReader;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;

public class MainFrame extends JFrame {

    JButton Open;
    JButton Sort;
    JButton Clear;
    JLabel text01;
    JTextField txtbox1;
    JPanel btnPanel;
    private static File inputFile;
    private static String newFilePath;

    public MainFrame() { // Everything Happens in Constructor
        super("File Sorter + Saving as Sorted.txt");
        setBounds(100, 100, 800, 400);

        init();
        buttonsToPanel();

        add(text01, BorderLayout.NORTH); // Adds text01 To Local JFrame
        add(btnPanel,BorderLayout.PAGE_END); // adding Panel To JFrame DOWN
        add(txtbox1,BorderLayout.CENTER);

        setResizable(false); // Disable Resize
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Overriding "X" to Close The Main Window
    }

    private void init(){
        Open = new JButton("Open File"); // Passing String Name as ObjectName
        Sort = new JButton("Sort Text");
        Clear = new JButton("Clear");
        text01 = new JLabel("First Java Form");
        txtbox1 = new JTextField(20);
        syncButtons();
    }

    private void syncButtons(){

        Open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OpenFileDialog();

                try {
                    txtbox1.read( new FileReader( inputFile.getAbsolutePath() ), null );
                } catch (IOException ex) {
                    System.out.println("problem accessing file"+inputFile.getAbsolutePath());
                }
                text01.setText("File Opened: " + inputFile.getAbsolutePath());
            }
        });

        Sort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sortFileNSaveNew();
                    txtbox1.read( new FileReader(newFilePath), null ); // New File Path Generates in StringBuilder
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                text01.setText("File Sorted...");
            }
        });

        Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtbox1.setText("");
                text01.setText("Text Cleared...");
            }
        });
    }

    private File OpenFileDialog(){
        JFileChooser openFile = new JFileChooser();
        openFile.showOpenDialog(null);
        inputFile = openFile.getSelectedFile(); // Grab Selected into File
        return inputFile;
    }

    private void buttonsToPanel(){
        btnPanel = new JPanel(new FlowLayout());
        btnPanel.add(Open); // Generating New Panel For Buttons
        btnPanel.add(Sort);
        btnPanel.add(Clear);
    } // Attach Buttons To Panel

    public static void sortFileNSaveNew() throws IOException // Sorts and Saves inputFile as outFile with new path:
    {
        FileReader fileReader = new FileReader(inputFile.getAbsolutePath());
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<String> lines = new ArrayList<>();
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();

        Collections.sort(lines, Collator.getInstance());

        String Path = stringBuilder();
        FileWriter writer = new FileWriter(Path);
        for(String str: lines) {
            writer.write(str + "\r\n");
        }
        writer.close();
    }

    private static String stringBuilder(){
        String Path = inputFile.getAbsolutePath();
        Path=Path.substring(0,Path.indexOf(".txt"));
        Path += " - Sorted.txt";
        newFilePath = Path;
        return Path;
    }
}
