import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class BookManager extends JFrame {
    private JTextField idField, titleField, authorField, genreField, publisherField;
    private JSpinner publishDateSpinner;
    private JTable bookTable;
    private DefaultTableModel tableModel;

    public BookManager() {
        setTitle("Book Manager");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        inputPanel.add(titleField);

        inputPanel.add(new JLabel("Author:"));
        authorField = new JTextField();
        inputPanel.add(authorField);

        inputPanel.add(new JLabel("Genre:"));
        genreField = new JTextField();
        inputPanel.add(genreField);

        inputPanel.add(new JLabel("Publisher:"));
        publisherField = new JTextField();
        inputPanel.add(publisherField);

        inputPanel.add(new JLabel("Publish Date:"));
        publishDateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(publishDateSpinner, "dd/MM/yyyy");
        publishDateSpinner.setEditor(dateEditor);
        inputPanel.add(publishDateSpinner);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });
        inputPanel.add(addButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBook();
            }
        });
        inputPanel.add(deleteButton);

        JPanel tablePanel = new JPanel();
        tableModel = new DefaultTableModel(new Object[]{"ID", "Title", "Author", "Genre", "Publisher", "Publish Date"}, 0);
        bookTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(bookTable);
        tablePanel.add(scrollPane);

        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(tablePanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void addBook() {
        String id = idField.getText();
        String title = titleField.getText();
        String author = authorField.getText();
        String genre = genreField.getText();
        String publisher = publisherField.getText();
        Date publishDate = (Date) publishDateSpinner.getValue();

        tableModel.addRow(new Object[]{id, title, author, genre, publisher, publishDate});
    }

    private void deleteBook() {
        int selectedRow = bookTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BookManager();
            }
        });
    }
}
