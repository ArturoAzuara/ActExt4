package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

public class Ventana extends JFrame {
    private JPanel panel1;
    private JButton botonPanel1;
    private JLabel etiquetaPanel1;
    private JPanel panel2;
    private JLabel EtiquetaPanel2;
    private JPanel panel3;
    private JComboBox<String> comboboxPanel3;
    private JPanel panel4;
    private GridLayout layout;

    public Ventana(String title) throws HeadlessException {
        super(title);
        this.setSize(800,600);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);
        // panel 1
        panel1 = new JPanel();
        panel1.setBackground(new Color(177, 248, 244));
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        botonPanel1 = new JButton("Presioname!!");
        panel1.add(botonPanel1);
        etiquetaPanel1 = new JLabel("...");
        panel1.add(etiquetaPanel1);
        botonPanel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                etiquetaPanel1.setText("Hola, presionaste el boton del panel 1");
            }
        });

        this.getContentPane().add(panel1,0);

        // panel 2
        String urlImagen = "https://upload.wikimedia.org/wikipedia/en/6/61/Radioheadhailtothethief.png";

        panel2 = new JPanel();
        panel2.setBackground(new Color(248, 182, 177));
        panel2.setLayout(new FlowLayout());
        //Carga la imagen de internet
        try{
            URL url = new URL(urlImagen);
            Image imagen = ImageIO.read(url);
            ImageIcon imagenIcon = new ImageIcon(imagen);
            EtiquetaPanel2 = new JLabel(imagenIcon);
            panel2.add(EtiquetaPanel2);
            this.getContentPane().add(panel2,1);
        }catch (MalformedURLException me){
            System.out.println("URL no valida");
        }catch (Exception e){
            System.out.println("error al cargar la imagen");
        }

        // panel 3
        panel3 = new JPanel();
        panel3.setBackground(new Color(206, 177, 248));

        panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        String[] elementos = {"opcion 1","opcion 2","opcion 3","opcion 4"};
        comboboxPanel3 = new JComboBox<>(elementos);
        comboboxPanel3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getSource());
                System.out.println(comboboxPanel3.getSelectedIndex());

            }
        });
        panel3.add(comboboxPanel3);
        this.getContentPane().add(panel3,2);

        // panel 4
        panel4 = new JPanel();
        panel4.setBackground(new Color(209, 248, 177));
        this.getContentPane().add(panel4,3);


        this.setVisible(true);


    }
}
