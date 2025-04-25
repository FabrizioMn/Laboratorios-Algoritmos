package Laboratorio04.Vista;

import javax.swing.*;

import Laboratorio04.Controlador.LibroController;
import Laboratorio04.Controlador.Ordenador;
import Laboratorio04.Modelo.Libro;
import java.util.Arrays;

import java.awt.*;

public class LibroForm extends JFrame {
    private JTextField txtCodigo, txtTitulo;
    private JTextArea txtResultado;
    private JComboBox<String> comboOrden;
    private JList<String> listaLibros;
    private DefaultListModel<String> modeloLista;

    private Libro[] libros;
    private LibroController controller = new LibroController();

    public LibroForm(Libro[] libros) {
        this.libros = libros;

        setTitle("Sistema de Gestión de Biblioteca");
        setSize(700, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior de búsqueda
        JPanel panelBusqueda = new JPanel(new GridLayout(3, 2, 5, 5));
        panelBusqueda.setBorder(BorderFactory.createTitledBorder("Buscar libro"));

        txtCodigo = new JTextField();
        txtTitulo = new JTextField();
        comboOrden = new JComboBox<>(new String[]{"Burbuja", "QuickSort"});
        JButton btnBuscarCodigo = new JButton("Buscar por Código");
        JButton btnBuscarTitulo = new JButton("Buscar por Título");

        panelBusqueda.add(new JLabel("Código:"));
        panelBusqueda.add(txtCodigo);
        panelBusqueda.add(new JLabel("Título:"));
        panelBusqueda.add(txtTitulo);
        panelBusqueda.add(new JLabel("Ordenar por:"));
        panelBusqueda.add(comboOrden);

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnBuscarCodigo);
        panelBotones.add(btnBuscarTitulo);

        // Lista de libros
        modeloLista = new DefaultListModel<>();
        listaLibros = new JList<>(modeloLista);
        JScrollPane scrollLista = new JScrollPane(listaLibros);
        scrollLista.setBorder(BorderFactory.createTitledBorder("Libros disponibles"));

        // Resultado
        txtResultado = new JTextArea(4, 40);
        txtResultado.setEditable(false);
        txtResultado.setLineWrap(true);
        JScrollPane scrollResultado = new JScrollPane(txtResultado);
        scrollResultado.setBorder(BorderFactory.createTitledBorder("Resultado"));

        // Agregar al layout principal
        JPanel panelTop = new JPanel(new BorderLayout());
        panelTop.add(panelBusqueda, BorderLayout.NORTH);
        panelTop.add(panelBotones, BorderLayout.SOUTH);

        add(panelTop, BorderLayout.NORTH);
        add(scrollLista, BorderLayout.CENTER);
        add(scrollResultado, BorderLayout.SOUTH);

        // Mostrar los libros
        cargarLista(libros);

        // Acción: búsqueda por código
        btnBuscarCodigo.addActionListener(e -> {
            Libro[] copia = Arrays.copyOf(libros, libros.length);
            String metodo = (String) comboOrden.getSelectedItem();
            if (metodo.equals("Burbuja")) {
                Ordenador.burbuja(copia);
            } else {
                Ordenador.quickSort(copia, 0, copia.length - 1);
            }

            String codigo = txtCodigo.getText().trim();
            Libro encontrado = controller.buscarPorCodigo(copia, codigo);
            if (encontrado != null) {
                txtResultado.setText("Libro encontrado:\n" + encontrado);
                listaLibros.setSelectedValue(encontrado.toString(), true);
            } else {
                txtResultado.setText("No se encontró un libro con ese código.");
                listaLibros.clearSelection();
            }
        });

        // Acción: búsqueda por título
        btnBuscarTitulo.addActionListener(e -> {
            String titulo = txtTitulo.getText().trim();
            Libro encontrado = controller.buscarPorTitulo(libros, titulo);
            if (encontrado != null) {
                txtResultado.setText("Libro encontrado:\n" + encontrado);
                listaLibros.setSelectedValue(encontrado.toString(), true);
            } else {
                txtResultado.setText("No se encontró un libro con ese título.");
                listaLibros.clearSelection();
            }
        });
    }

    private void cargarLista(Libro[] datos) {
        modeloLista.clear();
        for (Libro libro : datos) {
            modeloLista.addElement(libro.toString());
        }
    }
}