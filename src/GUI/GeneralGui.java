package GUI;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elshan_abdullayev
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *A public class
 */
public class GeneralGui extends JFrame implements ActionListener {

    /***************************************************************************
     ***      declaration of the private variables used in the program       ***
     ***************************************************************************/

    //for creating the JPanel
    //private JPanel searchPanel = new JPanel();
    //for creating the JToolBar for the program
    //private JToolBar searchToolBar = new JToolBar();
    //for creating the label
    //private JLabel searchLabel = new JLabel("Book title:0 ");
    //for creating the JTextField to use it on the searchToolBar
    //private JTextField searchTextField = new JTextField(15);
    //for creating the JButton to use it on the searchToolBar
    //private JButton goButton = new JButton("Go");

    private JDesktopPane desktop = new JDesktopPane();
    //private JSplitPane splitPane;
    //private JScrollPane desktopScrollPane;
    //private JScrollPane treeScrollPane;
    /***************************************************************************
     *create objects from another classes for using them in the ActionListener *
     ***************************************************************************/
    private Menubar menu;
    private Toolbar toolbar;
  //private StatusBar statusbar = new StatusBar();
    private OpenFile openFile;
  //  private ListBooks listBooks;
    private ViewHelp viewHelp;
  //  private BorrowBooks borrowBooks;
  //  private ReturnBooks returnBooks;

  //  private MakeTable addMembers;
  //  private ListMembers listMembers;
  //  private SearchBooksAndMembers search;


    //constructor of JLibrary
    public GeneralGui() {
        //for setting the title for the frame
        super("Validation System");
        //for setting the size
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width/2 + 40, screenSize.height/2 - 40);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);

        
        
        
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image image = kit.getImage(ClassLoader.getSystemResource("images/Host16.gif"));
        setIconImage(image);

        menu = new Menubar();
        toolbar = new Toolbar();
        
        
        
        // menu bar Action.........
        
        setJMenuBar(menu);
        menu.exit.addActionListener(this);
        menu.open.addActionListener(this);
        
  //      menu.addBook.addActionListener(this);
        //menu.listBook.addActionListener(this);
        menu.table.addActionListener(this);
        menu.listTable.addActionListener(this);
        menu.viewHelp.addActionListener(this);
        menu.aboutUs.addActionListener(this);
        
        //menu.searchBooksAndMembers.addActionListener(this);
        //menu.borrowBook.addActionListener(this);
        //menu.returnBook.addActionListener(this);

        //get the graphical user interface components display the desktop
        Container cp = getContentPane();
        desktop.setBackground(Color.GRAY);
        cp.add("Center", desktop);
        //for setting the font
        //searchLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        //for setting the font
        //searchTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        //goButton.setFont(new Font("Tahoma", Font.BOLD, 9));
        //for adding the searchLable to the searchToolBar
        //searchToolBar.add(searchLabel);
        //for adding the searchTextField to searchToolBar
        //searchToolBar.add(searchTextField);
        //for adding the goButton to searchToolBar
        //searchToolBar.add(goButton);
        //for adding listenerAction for the button
        //goButton.addActionListener(this);
        //for setting the layout
        //searchPanel.setLayout(new BorderLayout());
        //for adding the toolBar to the searchPanel
        //searchPanel.add("Center", toolbar);
        //for adding the searchToolBar to the searchPanel
        //searchPanel.add("South", searchToolBar);
        //for adding the searchPanel to the Container
        //cp.add("North", searchPanel);
        //for adding the statusbar to the Container
        //cp.add("South", statusbar);

//        for (int i = 0; i < toolbar.imageName24.length; i++) {
//            //for adding the action to the button
//            toolbar.button[i].addActionListener(this);
//        }

        //for adding WindowListener to the program
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //show the program
        //show();
       
        setVisible(true);
        
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }

    /**
     *this method is invoked when an action occurs.
     *@param ae the action event.
     */
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == menu.open ) {
            Thread runner = new Thread() {
             

                @Override
                public void run() {
                    try {
                        openFile = new OpenFile();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(GeneralGui.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    desktop.add(openFile);
                    try {
                        openFile.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }
        
        
        /*
        if (ae.getSource() == menu.addBook || ae.getSource() == toolbar.button[0]) {
            Thread runner = new Thread() {

                public void run() {
                    addBooks = new AddBooks();
                    desktop.add(addBooks);
                    try {
                        addBooks.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }
        if (ae.getSource() == menu.listBook || ae.getSource() == toolbar.button[1]) {
            Thread runner = new Thread() {

                public void run() {
                    listBooks = new ListBooks();
                    desktop.add(listBooks);
                    try {
                        listBooks.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }*/
        
      if (ae.getSource() == menu.table || ae.getSource() == toolbar.button[2]) {
            Thread runner = new Thread() {
                private MakeTable makeTables;

                public void run() {
                    makeTables = new MakeTable();
                    desktop.add(makeTables);
                    try {
                        makeTables.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }
        if (ae.getSource() == menu.listTable || ae.getSource() == toolbar.button[3]) {
            Thread runner = new Thread() {

                public void run() {
                    ListTable listTable = new ListTable();
                    desktop.add(listTable);
                    try {
                        listTable.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }
        if (ae.getSource() == menu.viewHelp || ae.getSource() == toolbar.button[4]) {
            Thread runner;
            runner = new Thread() {
                
                public void run() {
                    ViewHelp vh = new ViewHelp() {};
                    //search = new SearchBooksAndMembers();
                    desktop.add(vh);
                    try {
                        vh.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }
        if (ae.getSource() == menu.aboutUs || ae.getSource() == toolbar.button[5]) {
            Thread runner = new Thread() {

                public void run() {
                    //borrowBooks = new BorrowBooks();
                    AboutUs about= new AboutUs();
                    desktop.add(about);
                    try {
                        about.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }/*
        if (ae.getSource() == menu.returnBook || ae.getSource() == toolbar.button[6]) {
            Thread runner = new Thread() {

                public void run() {
                    returnBooks = new ReturnBooks();
                    desktop.add(returnBooks);
                    try {
                        returnBooks.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }*/
        if (ae.getSource() == menu.exit || ae.getSource() == toolbar.button[7]) {
            dispose();
            System.exit(0);
        }
    }
}
