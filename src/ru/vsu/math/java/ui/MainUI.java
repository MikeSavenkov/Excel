package ru.vsu.math.java.ui;

import ru.vsu.math.java.core.ReadExcelFile;
import ru.vsu.math.java.core.Table;
import ru.vsu.math.java.core.WriteExcelFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;
import java.util.List;

/**
 * Created by Dima on 05.10.14.
 */
public class MainUI extends JFrame {

    private List<Table> tableList;
    private File file = null;
    private JTextArea textArea;


    public MainUI(){
        super("Excel");
        createWindow();
    }

    public void createWindow(){

        setBounds(400, 200, 200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableList = new ArrayList<Table>();
        textArea = new JTextArea();

        JMenuBar mainMenuBar = new JMenuBar();
        Font font = new Font("Verdana", Font.PLAIN, 11);

        JMenu fileMenu = new JMenu("Файл");
        fileMenu.setFont(font);

        JMenuItem readFileItem = new JMenuItem("Прочитать файл");
        readFileItem.setFont(font);
        fileMenu.add(readFileItem);
        readFileItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileRead();
            }
        });

        JMenuItem writeFileItem = new JMenuItem("Записать файл");
        writeFileItem.setFont(font);
        fileMenu.add(writeFileItem);
        writeFileItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    fileWrite();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        fileMenu.addSeparator();

        JMenuItem exitItem = new JMenuItem("Выход");
        exitItem.setFont(font);
        fileMenu.add(exitItem);
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        mainMenuBar.add(fileMenu);
        this.setDefaultLookAndFeelDecorated(true);
        this.add(mainMenuBar);
        this.setJMenuBar(mainMenuBar);
        getContentPane().add(textArea);

    }

    public void fileRead(){
        JFileChooser fileRead = new JFileChooser();
        int ret = fileRead.showDialog(null, "Open");
        if (ret == JFileChooser.APPROVE_OPTION) {
            file = fileRead.getSelectedFile();
            tableList = ReadExcelFile.readExcelFile(file.getAbsolutePath());
            //System.out.println(tableList);
            textArea.setText("Чтение файла завершено.\n");
        }
    }

    public void fileWrite() throws Exception{
        JFileChooser fileWrite = new JFileChooser();
        int ret = fileWrite.showSaveDialog(null);
        if (ret == JFileChooser.APPROVE_OPTION) {
            file = fileWrite.getSelectedFile();
            WriteExcelFile.writeExcelFile(file.getAbsolutePath(),tableList);
            textArea.setText("Запись файла завершена.\n");
        }
    }
}
